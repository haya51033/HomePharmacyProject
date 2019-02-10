package com.example.android.homepharmacyproject.Activity;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.homepharmacyproject.R;

public class RegistrationActivity extends AppCompatActivity {

    EditText et, et1, et2, et3, et4;
    Spinner spinner;
    Button button;
    String spinnerValue;
  //  SQLiteDatabase mDb;
    //Cursor cur;

   /* private static final String[] USER_COLUMNS = {
            DataContract.UserEntry._ID,
            DataContract.UserEntry.COLUMN_FULL_NAME,
            DataContract.UserEntry.COLUMN_USER_NAME,
            DataContract.UserEntry.COLUMN_EMAIL,
            DataContract.UserEntry.COLUMN_PASSWORD,
            DataContract.UserEntry.COLUMN_REMINDER_QUESTION
    };*/

    String _email;
    String _user_Name;
    String _full_Name;
    String _password;
    String _reminder_question;

    //DB dbHelper;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        //////CREATE DATABASE
     //   dbHelper = new DB(this);
        //mDb = dbHelper.getWritableDatabase();


        et = (EditText) findViewById(R.id.etRFN);
        et1 = (EditText) findViewById(R.id.etREmail);
        et2 = (EditText) findViewById(R.id.etRUsername);
        et3 = (EditText) findViewById(R.id.etRPassword);
        et4 = (EditText) findViewById(R.id.etRAnswer);

        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.btnRegister);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerValue =adapterView.getItemAtPosition(i).toString();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(et.getText().toString().trim().length() != 0 && et1.getText().toString().trim().length() != 0
                        && et3.getText().toString().trim().length() != 0
                        && et4.getText().toString().trim().length() != 0
                        && spinnerValue.trim().length() != 0 ){

                    _email = et1.getText().toString();
                    _full_Name = et.getText().toString();
                    _user_Name = et2.getText().toString();
                    _password = et3.getText().toString();
                    _reminder_question = et4.getText().toString();

            //     if(checkAlreadyExist(_email)){
                     ///////INSERT NEW USER///////
                   // addUser( _user_Name, _email, _password, _full_Name,  _reminder_question);
                     Toast.makeText(getApplicationContext(),"ADDED SUCCESSFULLY ! ",Toast.LENGTH_LONG).show();


                    /*

                      int i = 0;
                     String[] values = new String[20];
                     Cursor resultSet = getUsers();
                     if (resultSet != null && resultSet.moveToFirst());
                     {
                         do {
                             if (resultSet != null) {
                                 values[i] = resultSet.getString(resultSet.getColumnIndex("email"));
                                 i++;
                             }
                         }while (resultSet.moveToNext());
                         resultSet.close();
                     }
                     if (cursor == null || cursor.getColumnCount() == 0 ||cursor.moveToLast()) {

                         Toast.makeText(getApplicationContext(),"NO USERS.......",Toast.LENGTH_LONG).show();

                     }
                     else {
                         String FirstName11 = cur.getString(1);
                         String FirstNam11e = cur.getString(2);
                         String FirstName = cur.getString(3);
                         String LastName = cur.getString(4);*/
                   //      Toast.makeText(getApplicationContext(),"currrr ! ",Toast.LENGTH_LONG).show();

                     //}

                     int ss =3;
                     int sd =ss +1;
               //  }


                }
                else {
                    Toast.makeText(getApplicationContext(),"Please fill in all fields ! ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

  /*  public boolean checkAlreadyExist(String email) {
        String query = "SELECT " + DataContract.UserEntry.COLUMN_EMAIL + " FROM " + DataContract.UserEntry.TABLE_NAME
                +" WHERE "+ DataContract.UserEntry.COLUMN_EMAIL + " =?";

        Cursor cursor = mDb.rawQuery(query, new String[]{email});
        if (cursor.getCount() > 0)
        {
            Toast.makeText(getApplicationContext(),"The email is already Exist!!", Toast.LENGTH_LONG).show();
            return false;

        }
        else

        return true;
    }*/

   /* private void addUser(String _user_Name, String _email, String _password,
                         String _full_Name, String _reminder_question) {
        String _user_Name1 = _user_Name;
        String _email1 = _email;
        String _password1 =_password;
        String _full_Name1 = _full_Name;
        String _reminder_question1 = _reminder_question;

        ContentValues cv = new ContentValues();
        cv.put(DataContract.UserEntry.COLUMN_USER_NAME,_user_Name);
        cv.put(DataContract.UserEntry.COLUMN_EMAIL, _email);
        cv.put(DataContract.UserEntry.COLUMN_PASSWORD,_password);
        cv.put(DataContract.UserEntry.COLUMN_FULL_NAME, _full_Name);
        cv.put(DataContract.UserEntry.COLUMN_REMINDER_QUESTION, _reminder_question);

     //   mDb.insert(DataContract.UserEntry.TABLE_NAME,null, cv);
        Uri uri = getContentResolver().insert(DataContract.UserEntry.CONTENT_URI, cv);

        // Display the URI that's returned with a Toast
        // [Hint] Don't forget to call finish() to return to MainActivity after this insert is complete
        if(uri != null) {
            Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
        }
        finish();
    }*/



/*
*     public boolean check(){
        dbHelper.getReadableDatabase();

        Cursor mCursor = mDb.rawQuery("SELECT * FROM " + USER_COLUMNS + " WHERE    yourKey=? AND yourKey1=?", new String[_email,_email]{});

        if (mCursor != null)
        {
            return true;
}
        else
                {
                return false;
                }
                }



    /*
    *     public static boolean CheckIsDataAlreadyInDBorNot(String TableName, String dbfield, String fieldValue) {
        SQLiteDatabase mDb1 = EGLifeStyleApplication.sqLiteDatabase;
        String Query = "Select * from " + TableName + " where " + dbfield + " = " + fieldValue;
        Cursor cursor = sqldb.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
*/
  /*  public Cursor getUsers() {
        cur =   getContentResolver().query(DataContract.UserEntry.CONTENT_URI, USER_COLUMNS, null, null, null);
        return cur;
    }*/
}