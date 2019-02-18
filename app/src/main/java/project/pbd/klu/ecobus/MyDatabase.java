package project.pbd.klu.ecobus;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabase extends SQLiteOpenHelper {
    static final private String DB_NAME="bss gi";
    private String TABLE_NAME="ebb";
    private String T_NAME="ebbb";
    int ctt=0;
    SQLiteDatabase myDb;
    Context ctx;
    String cname, cmm;

    public MyDatabase(Context context)
        {
            super(context, DB_NAME, null, 1);
            ctx = context;
        }
        @Override
        public void onCreate (SQLiteDatabase db){
        try {
            db.execSQL("create table " + T_NAME + "(_id integer primary key autoincrement,name text unique,pwd text);");

            db.execSQL("create table " + TABLE_NAME + "(_id integer primary key autoincrement,name text,pid integer,route text,st text);");
        }
        catch(SQLiteConstraintException e){
            Toast.makeText(ctx,"Unique id or name", Toast.LENGTH_LONG).show();

        }
            }
        @Override
        public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){

        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);

    }

        public int doInsert (String name, String pd){
        myDb = getWritableDatabase();
        myDb.execSQL("insert into " + T_NAME + " (name,pwd) values ('"+ name + "','" + pd + "');");
        Toast.makeText(ctx, "REGISTERD SUCCESFULLY !!!", Toast.LENGTH_SHORT).show();
        return 1;
    }

        public void dInsert (String r, String f ,String n,int kp){
        myDb = getWritableDatabase();
        myDb.execSQL("insert into " + TABLE_NAME + " (name,pid,route,st) values('" + n + "  ',' " +kp+" ',' " + r + " ',' " + f + " ');");
    }

        public void loadData (String tq)
        {
            myDb = getReadableDatabase();

            Cursor cursor = myDb.rawQuery("Select * from " + TABLE_NAME, null);

            String result = "";
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String fname = cursor.getString(1);
                String fcolor = cursor.getString(2);
                String fr = cursor.getString(3);
                String ffr = cursor.getString(4);

                result += " " + id + "  " + fname + " " + fcolor + " " + fr + " " + ffr + " \n";

            }

            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }

    public void ld (String tt)
    {
        myDb = getReadableDatabase();

        Cursor cursor = myDb.rawQuery("Select * from " + T_NAME, null);

        String result = "";
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String tname = cursor.getString(1);
            String tpwd = cursor.getString(2);
            if(tt.equals(tname))
            {
                result += " " + id + "  " + tname + " " + tpwd + " \n";
            }
        }

        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }


    public int compare (String nameee, String ppp)
        {
            myDb = getReadableDatabase();

            Cursor ck = myDb.rawQuery("Select * from " + T_NAME, null);

            while (ck.moveToNext()) {
                String fname = ck.getString(1);
                String fp = ck.getString(2);
                if (nameee.equals(fname)) {
                    if (ppp.equals(fp)) {
                        ctt = 1;
                        cname = nameee;

                        Toast.makeText(ctx, "You have Logged in Succesfully", Toast.LENGTH_LONG).show();
                    } else {
                    }
                } else {
                }
            }

            return ctt;
        }
        public void updateDate ( int id, String name, String color){
        myDb = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("_id",id);
        content.put("name", name);
        content.put("pwd", color);

        String[] selectionArgs = {String.valueOf(id)};

        myDb.update(T_NAME, content, "_id=?", selectionArgs);
        Toast.makeText(ctx, "Record is Updated", Toast.LENGTH_SHORT).show();

    }

        public void delete ( int id){
        myDb = getWritableDatabase();
        String[] selectionArgs = {String.valueOf(id)};
        myDb.delete(TABLE_NAME, "_id=?", selectionArgs);

        Toast.makeText(ctx, "Record is Deleted ", Toast.LENGTH_SHORT).show();

    }

    public void deleteall(){
        myDb = getWritableDatabase();
        myDb.execSQL("delete from "+ TABLE_NAME);
        myDb.execSQL("vacuum");
    }


}