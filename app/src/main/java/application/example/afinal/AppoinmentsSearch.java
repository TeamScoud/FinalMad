package application.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppoinmentsSearch extends AppCompatActivity {

    EditText e5;
    Button button5,button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinments_search);

        //define objects
        e5 = findViewById(R.id.e5);
        button5 = findViewById(R.id.button5);

        button10 = findViewById(R.id.button10);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppoinmentsSearch.this,Appoinments.class);
                startActivity(intent);

            }
        });

//Searching part
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = e5.getText().toString();
                SQLiteDatabase sqLiteDatabase = getApplicationContext().openOrCreateDatabase("UserIfo1.db", Context.MODE_PRIVATE,null);

                Cursor c = sqLiteDatabase.rawQuery("select * from contacts where number='"+n+"'", null);

                if (c.getCount() == 0){

                    Toast.makeText(getApplicationContext(),"Data not searched", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("id :"+ c.getString(0)+"\n");
                    buffer.append("number :"+ c.getString(1)+"\n");
                    buffer.append("subject :"+ c.getString(2)+"\n");
                    buffer.append("date :"+ c.getString(3)+"\n");
                    buffer.append("mode :"+ c.getString(4)+"\n\n");

                }


                Toast.makeText(getApplicationContext(),"Results : \n "+buffer.toString(),Toast.LENGTH_SHORT).show();





            }
        });

    }
}