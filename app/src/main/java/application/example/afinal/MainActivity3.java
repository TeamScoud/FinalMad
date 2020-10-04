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

public class MainActivity3 extends AppCompatActivity {

    EditText e3,e;
    DBHandler myDB;
    Button button3,button2,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button3 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button2);
        e3 = findViewById(R.id.e3);
        e = findViewById(R.id.e);
        button4 = findViewById(R.id.button4);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);
            }
        });
/*
        ListView listView = (ListView) findViewById(R.id.listView);

        myDB = new DBHandler(this);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if(data.getCount() == 0){

            Toast.makeText(SecondActivity.this," Does Not Successfully View",Toast.LENGTH_SHORT).show();
        }else{

            while (data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);

                Toast.makeText(SecondActivity.this," All Subjects View Successfully",Toast.LENGTH_SHORT).show();
            }
        }
    }

      */
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = e3.getText().toString();
                SQLiteDatabase sqLiteDatabase = getApplicationContext().openOrCreateDatabase("UserInfo2.db", Context.MODE_PRIVATE,null);

                Cursor c = sqLiteDatabase.rawQuery("select * from users where subject='"+n+"'", null);

                if (c.getCount() == 0){

                    Toast.makeText(getApplicationContext(),"Data not searched", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("id :"+ c.getString(0)+"\n");
                    buffer.append("subject :"+ c.getString(1)+"\n\n");


                }


                Toast.makeText(getApplicationContext(),"Results : \n "+buffer.toString(),Toast.LENGTH_SHORT).show();





            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String p = e.getText().toString();
                SQLiteDatabase sqLiteDatabase = getApplicationContext().openOrCreateDatabase("UserInf2.db", Context.MODE_PRIVATE, null);

                Cursor c1 = sqLiteDatabase.rawQuery("select * from Findateacher where teacher='" + p + "'", null);
                //Cursor c1 = sqLiteDatabase.rawQuery("select * from teachers INNER JOIN teachers ON teachers.id = users.id where teachername='"+p+"'", null);

                if (c1.getCount() == 0) {

                    Toast.makeText(getApplicationContext(), "Data not searched", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c1.moveToNext()) {
                    buffer.append("id :" + c1.getString(0) + "\n");
                    buffer.append("Teacher :" + c1.getString(1) + "\n");
                    buffer.append("subject :"+ c1.getString(2)+"\n\n");


                }


                Toast.makeText(getApplicationContext(), "Results : \n " + buffer.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        }
}