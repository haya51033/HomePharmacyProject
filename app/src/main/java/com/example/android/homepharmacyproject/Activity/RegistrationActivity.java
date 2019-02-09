package com.example.android.homepharmacyproject.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.homepharmacyproject.Database.DB;
import com.example.android.homepharmacyproject.Database.DataContract;
import com.example.android.homepharmacyproject.R;

public class RegistrationActivity extends AppCompatActivity {

    EditText et, et1, et2, et3, et4;
    Spinner spinner;
    Button button;
    String spinnerValue;
    SQLiteDatabase mDb;
    Cursor cur;

    private static final String[] USER_COLUMNS = {
            DataContract.UserEntry._ID,
            DataContract.UserEntry.COLUMN_FULL_NAME,
            DataContract.UserEntry.COLUMN_USER_NAME,
            DataContract.UserEntry.COLUMN_EMAIL,
            DataContract.UserEntry.COLUMN_PASSWORD,
            DataContract.UserEntry.COLUMN_REMINDER_QUESTION
    };

    String _email;
    final DB dbHelper = new DB(this);



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

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
                            //////////////
                    /////////////
                    /////////////
                    //////////////
                }
            }
        });
    }


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
    public Cursor getUsers() {
        cur =   getContentResolver().query(DataContract.UserEntry.CONTENT_URI, USER_COLUMNS, null, null, null);
        return cur;
    }
}