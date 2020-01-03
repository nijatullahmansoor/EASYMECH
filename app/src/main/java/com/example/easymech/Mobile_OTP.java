package com.example.easymech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class Mobile_OTP extends AppCompatActivity {
    private Button _confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile__otp);

        _confirm = (Button) findViewById(R.id.confirm_1);


        _confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your account has been created!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Mobile_OTP.this, MainActivity.class));
            /*Intent int3 = new Intent(OTP.this, User_Profile.class);
            startActivity(int3); */

            }
        });
    }
}