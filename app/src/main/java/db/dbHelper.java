package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.seele.overtime.po.Item;

/**
 * 工具类
 * 用于操作数据库
 */
public class dbHelper extends SQLiteOpenHelper{

    //数据库名
    public static final String DBNAME = "overtime.db";

    //版本
    public static final int VERSION =1;

    //建表语句，无关大小写
    private static final String CREATETABLE = "create table "
                                            + Item.TABLENAME
                                            + "(title string,minutes int,date string,flg string)";

    /**
     * 构造函数，必须实现
     * @param context 上下文路径
     * @param name 数据库名称
     * @param factory 可选游标工厂，通常为NULL
     * @param version 当前版本号
     */
    public dbHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    /**
     * 数据库第一次创建时会调用，一般在其中创建数据库
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //使用execSQL()方法执行DDL语句，如果没有异常，这个方法没有返回值
        db.execSQL(CREATETABLE);
    }

    /**
     * 当数据库需要修改的时候，android系统会主动调用这个方法
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.deleteDB(db);
        this.onCreate(db);
    }

    /**
     * 删除表
     * @param db
     */
    private void deleteDB(SQLiteDatabase db){
        db.execSQL("drop table if exists " + Item.TABLENAME);
    }

    /**
     * 打开数据库时的回调函数
     * @param db
     */
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public synchronized void close(){
        super.close();
    }
}
