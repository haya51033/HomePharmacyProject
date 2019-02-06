package com.example.android.homepharmacyproject.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class DB extends SQLiteOpenHelper {
    // The database name
    private static final String DATABASE_NAME = "HOME_PHARMACY.db";

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_USER_TABLE = "CREATE TABLE " + DataContract.UserEntry.TABLE_NAME + " (" +
                DataContract.UserEntry._ID + " INTEGER PRIMARY KEY," +
                DataContract.UserEntry.COLUMN_USER_ID + " INTEGER NOT NULL, " +
                DataContract.UserEntry.COLUMN_FULL_NAME+ " TEXT NOT NULL, " +
                DataContract.UserEntry.COLUMN_USER_NAME + " TEXT NOT NULL, " +
                DataContract.UserEntry.COLUMN_EMAIL + " TEXT NOT NULL, " +
                DataContract.UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL, " +
                DataContract.UserEntry.COLUMN_REMINDER_QUESTION + " TEXT NOT NULL " +

                " );";




        final String SQL_CREATE_MEMBERS_TABLE = "CREATE TABLE " + DataContract.MemberEntry.TABLE_NAME + " (" +
                DataContract.MemberEntry._ID + " INTEGER PRIMARY KEY," +
                DataContract.MemberEntry.COLUMN_MEMBER_ID+ " INTEGER NOT NULL, " +
                DataContract.MemberEntry.COLUMN_MEMBER_NAME +" TEXT NOT NULL, " +
                DataContract.MemberEntry.COLUMN_AGE +" INTEGER NOT NULL, " +
                DataContract.MemberEntry.COLUMN_GENDER + " TEXT NOT NULL, " +
                DataContract.MemberEntry.COLUMN_EMAIL + " TEXT NOT NULL, " +
                DataContract.MemberEntry.COLUMN_PREGNANT + " BOOLEAN NOT NULL " +

                " );";

        final String SQL_CREATE_DRUG_TABLE = "CREATE TABLE " + DataContract.DrugEntry.TABLE_NAME + " (" +
                DataContract.DrugEntry._ID + " INTEGER PRIMARY KEY," +
                DataContract.DrugEntry.COLUMN_DRUG_ID+ " INTEGER NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_COMMERCIAL_NAME+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_COMMERCIAL_NAME_ARABIC+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_SCIENTIFIC_NAME+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_SCIENTIFIC_NAME_ARABIC+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_INDICATION+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_INDICATION_ARABIC+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_EXPIRY_DATE+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_CONCENTRATION+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_TYPE+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_WARNINGS+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_WARNINGS_ARABIC+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_SIDE_EFFECTS+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_SIDE_EFFECTS_ARABIC+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_PREGNENT_ALLOWED+ " BOOLEAN NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_DESCRIPTION+ " TEXT NOT NULL, " +
                DataContract.DrugEntry.COLUMN_DRUG_DESCRIPTION_ARABIC+ " TEXT NOT NULL " +

                " );";


        final String SQL_CREATE_DRUG_LIST_TABLE = "CREATE TABLE " + DataContract.DrugListEntry.TABLE_NAME + " (" +
                DataContract.DrugEntry._ID + " INTEGER PRIMARY KEY," +
                DataContract.DrugListEntry.COLUMN_LIST_ID+ " INTEGER NOT NULL, " +
                DataContract.DrugListEntry.COLUMN_DRUG_L_ID+ " INTEGER NOT NULL, " +
                DataContract.DrugListEntry.COLUMN_MEMBER_L_ID+ " INTEGER NOT NULL, " +
                DataContract.DrugListEntry.COLUMN_DRUG_START_DATE+ " TEXT NOT NULL, " +
                DataContract.DrugListEntry.COLUMN_DRUG_END_DATE+ " TEXT NOT NULL, " +
                DataContract.DrugListEntry.COLUMN_DRUG_DOSE_QUANTITY+ " TEXT NOT NULL, " +
                DataContract.DrugListEntry.COLUMN_DRUG_DOSE_REPEAT+ " TEXT NOT NULL, " +
                DataContract.DrugListEntry.COLUMN_DRUG_DOSE_DESCRIPTION+ " TEXT NOT NULL " +


                " );";


        final String SQL_CREATE_FIRST_AID_TABLE = "CREATE TABLE " + DataContract.FirstAidEntry.TABLE_NAME + " (" +
                DataContract.FirstAidEntry._ID + " INTEGER PRIMARY KEY," +
                DataContract.FirstAidEntry.COLUMN_FIRST_AID_ID+ " INTEGER NOT NULL, " +
                DataContract.FirstAidEntry.COLUMN_FIRST_AID_TITLE+ " TEXT NOT NULL, " +
                DataContract.FirstAidEntry.COLUMN_FIRST_AID_DESCRIPTION+ " TEXT NOT NULL, " +
                DataContract.FirstAidEntry.COLUMN_FIRST_AID_LINK+ " TEXT NOT NULL, " +
                DataContract.FirstAidEntry.COLUMN_FIRST_AID_IMAGE+ " TEXT NOT NULL, " +
                DataContract.FirstAidEntry.COLUMN_FIRST_AID_DRUG+ " INTEGER NOT NULL " +

                " );";


        db.execSQL(SQL_CREATE_USER_TABLE);
        db.execSQL(SQL_CREATE_DRUG_TABLE);
        db.execSQL(SQL_CREATE_MEMBERS_TABLE);
        db.execSQL(SQL_CREATE_DRUG_LIST_TABLE);
        db.execSQL(SQL_CREATE_FIRST_AID_TABLE);
        Log.i(TAG, "SQLite Created successfully !!! ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DataContract.UserEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DataContract.MemberEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DataContract.DrugEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DataContract.DrugListEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DataContract.FirstAidEntry.TABLE_NAME);
        onCreate(db);
    }
}

