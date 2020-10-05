package application.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Notes extends AppCompatActivity {

    DBHandler_3 myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        myDb = new DBHandler_3(this);
    }
}