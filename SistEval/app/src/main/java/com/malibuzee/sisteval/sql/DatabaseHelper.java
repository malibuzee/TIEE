package com.malibuzee.sisteval.sql;

/**
 * Created by F129 on 08/04/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.malibuzee.sisteval.activities.Alumno;
import com.malibuzee.sisteval.model.AlumnoModelo;
import com.malibuzee.sisteval.model.TagModelo;
import com.malibuzee.sisteval.model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "SistEval.db";

    // User table
    private static final String TABLE_USER = "docente";
    private static final String TABLE_TAGS = "CREATE TABLE TAGS(SERIAL_TAG TEXT PRIMARY KEY, NOMBREOBJ TEXT)";
    private static final String TABLE_ALUMNO = "CREATE TABLE ALUMNO(MATRICULA TEXT PRIMARY KEY, NOMBRES TEXT, APELLIDOS TEXT, EDAD TEXT, SERIAL_ALUM TEXT)";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_CCT = "user_cct";
    private static final String COLUMN_USER_NOMESCUELA = "user_nomescuela";
    private static final String COLUMN_USER_GRADO = "user_grado";
    private static final String COLUMN_USER_GRUPO = "user_grupo";

    // create table sql query

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_CCT + " TEXT," + COLUMN_USER_NOMESCUELA + " TEXT,"
            + COLUMN_USER_GRADO + " TEXT," + COLUMN_USER_GRUPO + " TEXT" + ")";


    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(TABLE_TAGS);
        db.execSQL(TABLE_ALUMNO);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS TABLE_TAGS");
        db.execSQL(TABLE_TAGS);
        db.execSQL("DROP TABLE IF EXISTS TABLE_ALUMNO");
        db.execSQL(TABLE_ALUMNO);

        // Create tables again
        onCreate(db);

    }


    // Clase para agregar Tags desde RegistroTags.java

    public void agregarTags(String serial, String nombreObj) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            db.execSQL("INSERT INTO TAGS VALUES('" + serial + "','" + nombreObj + "')");
            db.close();
        }
    }

    // Clase para agregar Alumnos desde Alumnos.java

    public void agregarAlumno(String matricula, String nombres, String apellidos, String edad, String serial_alum) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            db.execSQL("INSERT INTO ALUMNO VALUES('" + matricula + "','" + nombres + "','" + apellidos + "','" + edad + "','" + serial_alum + "')");
            db.close();
        }
    }


    // Clase para obtener las TAGS y visualizarlar desde ListaTags.java

    public List<TagModelo> obtenerTags() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TAGS", null);
        List<TagModelo> objectags = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                objectags.add(new TagModelo(cursor.getString(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        return objectags;
    }

    // Clase para obtener los ALUMNOS y visualizarlar desde ListaAlumnos.java

    public List<AlumnoModelo> obtenerAlumno() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ALUMNO", null);
        List<AlumnoModelo> objectalumno = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                objectalumno.add(new AlumnoModelo(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        return objectalumno;
    }



    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_CCT, user.getCct());
        values.put(COLUMN_USER_NOMESCUELA, user.getNomescuela());
        values.put(COLUMN_USER_GRADO, user.getGrado());
        values.put(COLUMN_USER_GRUPO, user.getGrupo());

       // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_CCT,
                COLUMN_USER_NOMESCUELA,
                COLUMN_USER_GRADO,
                COLUMN_USER_GRUPO

        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                user.setCct(cursor.getString(cursor.getColumnIndex(COLUMN_USER_CCT)));
                user.setNomescuela(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NOMESCUELA)));
                user.setGrado(cursor.getString(cursor.getColumnIndex(COLUMN_USER_GRADO)));
                user.setGrupo(cursor.getString(cursor.getColumnIndex(COLUMN_USER_GRUPO)));

                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }





    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_CCT, user.getCct());
        values.put(COLUMN_USER_NOMESCUELA, user.getNomescuela());
        values.put(COLUMN_USER_GRADO, user.getGrado());
        values.put(COLUMN_USER_GRUPO, user.getGrupo());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
