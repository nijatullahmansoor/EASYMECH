package com.example.easymech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Sign_up_activity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _sign_button;
    EditText editID, textname,textpass2, textphone, textemail, textpass;
    String id, name, phone, email,  pass1, pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_activity);
        openHelper = new DatabaseHelper(this);

        _sign_button = (Button) findViewById(R.id.SignUp);
        textname = (EditText) findViewById(R.id.username);
        textphone = (EditText) findViewById(R.id.phone);
        textemail = (EditText) findViewById(R.id.my_email);
        textpass = (EditText) findViewById(R.id.pass_word1);
        textpass2 = (EditText) findViewById(R.id.pass_word2);
            _sign_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    db=openHelper.getWritableDatabase();
                    String name = textname.getText().toString();
                    String phone = textphone.getText().toString();
                    String email = textemail.getText().toString();
                    String pass1 = textpass.getText().toString();
                    String pass2 = textpass2.getText().toString();
                    insertData(name,phone,email,pass2);
                    Toast.makeText(getApplicationContext(), "Your account is in progress! Please confirm your phone number", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Sign_up_activity.this, Mobile_OTP.class));

                }
            });

    }
    public void insertData(String username, String mobile, String email, String pass2){
        ContentValues val = new ContentValues();
        val.put(DatabaseHelper.KEY_NAME,username);
        val.put(DatabaseHelper.KEY_MOBILE,mobile);
        val.put(DatabaseHelper.KEY_EMAIL,email);
        val.put(DatabaseHelper.KEY_PASS,pass2);
        long id = db.insert(DatabaseHelper.TABLE_NAME,null,val);

    }



}
