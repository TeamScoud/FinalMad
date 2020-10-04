package application.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity5 extends AppCompatActivity {

  Spinner spinner,spinner3;
 Button btt8,btt,btt2,btt3;
 EditText edt1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        spinner = findViewById(R.id.spinner);
        spinner3 = findViewById(R.id.spinner3);
        btt = findViewById(R.id.btt);
        btt2 = findViewById(R.id.btt2);
        btt8= findViewById(R.id.btt8);
        btt3= findViewById(R.id.btt3);
        edt1= findViewById(R.id.edt1);

        ViewAll();
        deleteInfo1();
        updateData1();



    }

    public void addData_1(View view){

        DBHandler_1 dbHandler_1 = new DBHandler_1(this);

            long val_1 = dbHandler_1.insertFindateacher(spinner.getSelectedItem().toString(),spinner3.getSelectedItem().toString());
            if (val_1>0) {
                Toast.makeText(this, "Make A Teacher List Added Successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Make A Teacher List Not Added Successfully", Toast.LENGTH_SHORT).show();
            }
        }

    public void ViewAll(){

        final DBHandler_1 dbHandler_1 = new DBHandler_1(this);
        btt3.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View view) {




                                          Cursor res = dbHandler_1.getAllData();
                                          if (res.getCount() == 0){

                                              showMessage("Error","Nothing Found");
                                              return;
                                          }

                                          StringBuffer buffer = new StringBuffer();
                                          while (res.moveToNext()){
                                              buffer.append("Id :"+ res.getString(0)+"\n");
                                              buffer.append("Subject :"+ res.getString(1)+"\n");
                                              buffer.append("Teacher :"+ res.getString(2)+"\n\n");


                                          }

                                          showMessage("Data",buffer.toString());
                                      }
                                  }
        );

    }
    public void showMessage(String title,String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

    public void deleteInfo1() {

        final DBHandler_1 dbHandler_1 = new DBHandler_1(this);
        //validation

        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleteRows = dbHandler_1.deleteFindateacher(edt1.getText().toString());

                if (deleteRows > 0) {


                    Toast.makeText(MainActivity5.this, " Deleted Successfully", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(MainActivity5.this, " Deleted Not Successfully", Toast.LENGTH_SHORT).show();


                }
            }
        });

    }

    public void updateData1(){

        final DBHandler_1 dbHandler_1 = new DBHandler_1(this);
        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isUpdate = dbHandler_1.updateFindateacher(edt1.getText().toString(),spinner.getSelectedItem().toString(),spinner3.getSelectedItem().toString());

                if (isUpdate == true){
                    Toast.makeText(MainActivity5.this,"Data Updated Successfully",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity5.this,"Data Not Updated",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}