package io.blinktech.memberentry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank on 7/21/15.
 */
public class MemberDataInterface {
    private SQLiteDatabase database;
    private DBOpenHelper dbHelper;
    public long result;

    public MemberDataInterface(Context context){
        dbHelper = new DBOpenHelper(context);
    }

    public void open() throws SQLException {

        database = dbHelper.getWritableDatabase();

    }

    public void openRead() throws SQLException {

        database = dbHelper.getReadableDatabase();

    }

    public void close() throws SQLException {
        dbHelper.close();
    }

    public long createMember(Member element) throws SQLException {

        this.open();

        ContentValues value = new ContentValues();
        value.put(dbHelper.MEMBER_ID, element.getMemberId());
        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.CHILD_ID, element.getChildId());
        value.put(dbHelper.MARRIAGE_STATUS, element.getMarriageStatus());
        value.put(dbHelper.FAMILY_PLAN, element.getFamilyPlan());
        value.put(dbHelper.EDUCATION, element.getEducation());
        value.put(dbHelper.LITERACY, element.getLiteracy());
        value.put(dbHelper.WEDDING_ARR, element.getWeddingArr());
        value.put(dbHelper.WEDDING_DEPT, element.getWeddingDept());

        long newRowId;
        newRowId = this.database.insert(dbHelper.TABLE_MEMBER, null, value);

        this.close();
        return newRowId;
    }

    public Member getMember(int id) throws SQLException{
        this.openRead();

        Member element = new Member();

        String selection = "_id=?";
        String[] selectionArgs = new String[] { String.valueOf(id)};
        Cursor c = database.query(DBOpenHelper.TABLE_MEMBER,null,selection,selectionArgs,null,null,null);
        if(c.getCount() == 0) {
            return null;
        }
        c.moveToFirst();
        element.setName(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.NAME)));
        element.setMemberId(id);
        element.setFamilyId(c.getInt(c.getColumnIndexOrThrow(DBOpenHelper.FAMILY_ID)));
        element.setAge(c.getInt(c.getColumnIndexOrThrow(DBOpenHelper.AGE)));
        element.setChildId(c.getInt(c.getColumnIndexOrThrow(DBOpenHelper.CHILD_ID)));
        element.setMarriageStatus(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.MARRIAGE_STATUS)));
        element.setFamilyPlan(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.FAMILY_PLAN)));
        element.setEducation(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.EDUCATION)));
        element.setLiteracy(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.LITERACY)));
        element.setWeddingArr(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.WEDDING_ARR)));
        element.setWeddingDept(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.WEDDING_DEPT)));

        this.close();

        return element;

    }

    public List<Member> getAllMembers(){
        List<Member> patientList = new ArrayList<Member>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBER, null);

        if(cursor.moveToFirst()){
            do{
                Member element = new Member(Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),cursor.getString(2),
                        Integer.parseInt(cursor.getString(3)),
                        Integer.parseInt(cursor.getString(4)),cursor.getString(5),
                        cursor.getString(6),cursor.getString(7),
                        cursor.getString(8),cursor.getString(9),
                        cursor.getString(10));
                //Log.println(Log.ASSERT,"log",element.getName());
               // element.setProfileId(Integer.parseInt(cursor.getString(0)));
                patientList.add(element);
                //  Log.println(Log.ASSERT,"log",cursor.getString(4));
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return patientList;
    }

    public int getPatientCount(){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_MEMBER, null);
        int c = cursor.getCount();
        db.close();
        cursor.close();
        return c;
    }


    public void deleteAllTables(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM " + dbHelper.TABLE_MEMBER);
        db.close();
    }
}
