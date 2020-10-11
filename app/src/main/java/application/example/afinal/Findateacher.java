package application.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Findateacher extends AppCompatActivity {

    EditText ex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findateacher);

        ex = findViewById(R.id.ex);
    }

    public void addData(View view) {

        DBHandler dbHandler = new DBHandler(this);


        long val = dbHandler.addInfo(ex.getText().toString());
        if (val > 0) {
            Toast.makeText(this, "Teacher Added Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Teacher Not Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}