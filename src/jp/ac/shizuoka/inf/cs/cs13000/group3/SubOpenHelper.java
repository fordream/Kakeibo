package jp.ac.shizuoka.inf.cs.cs13000.group3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.widget.Button;
import android.widget.Spinner;
import jp.ac.shizuoka.inf.cs.cs13000.group3.R.id;
import android.view.View;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SubOpenHelper extends SQLiteOpenHelper {
	 
    // コンストラクタ
    public SubOpenHelper(Context c,String dbname,int version){
            super(c,dbname,null,version);
        //第一引数は、データベースを所有するコンテキストオブジェクトを指定。
        //第二引数は、DBファイル名。保存場所。
        //data/data/<パッケージ名>/database/<ファイル名>に保存される。
    //nullにすると、メモリ内に保存される。
        //第三引数は、不明。とりあえずnull。
        //第四引数は、DBのバージョンで、作成するときに指定。今は1。
        //データベース管理のために使うらしい。
    }
 
    // データベースが一番最初に作られたときの処理
    // コンストラクタに渡されたDBファイル名が存在しない場合に呼ばれる
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "";
        sql += "create table Date_Table (";
        //テーブルの名前
        sql += "_id integer primary key autoincrement";
        //_idはカラム名。一意に決まる。1,2,3と格納されるため、integer型。
        //重複禁止のため、primary key。autoincrementとは、一度割り当てられた
        //値を削除されても再度は使われないようにするもの。
        sql += ",Koumoku text not null";
        sql += ",Utiwake text";
        sql += ",Kingaku text";
        sql += ",year text";
        sql += ",month text";
        sql += ",day text";
        //それぞれ項目の名前。not nullは、nullと入れるとエラーになる。
        sql += ")";
        db.execSQL(sql);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}