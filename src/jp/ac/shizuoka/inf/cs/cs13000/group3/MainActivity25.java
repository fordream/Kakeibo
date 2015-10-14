package jp.ac.shizuoka.inf.cs.cs13000.group3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.widget.Button;
import android.widget.Spinner;
import jp.ac.shizuoka.inf.cs.cs13000.group3.R.id;
import android.view.View;
import android.widget.EditText;


public class MainActivity25 extends Activity {
	static int turn = 0;//データベースなしでの保存方法のための変数
	static boolean Koumokuhantei = false;
	static int year;
	static int month;
	static int day;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity25);
		Intent intent = getIntent();
		year = intent.getIntExtra("year25", year);
		month = intent.getIntExtra("month25", month);
		day = intent.getIntExtra("day25", day);
		
		
		Button OKbutton = (Button) findViewById(id.button2);
		OKbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);//すぴなーの定義
				
				String Koumoku = spinner1.getSelectedItem().toString();//スピナーの項目情報を取得
				EditText Utiwake = (EditText)findViewById(id.editText2);//エディットテキストから情報を取得
				EditText Kingaku = (EditText)findViewById(id.editText1);
				turn++;
				
			    Intent intent1=new Intent(MainActivity25.this,MainActivity29.class);//メインメニューへの画面遷移とintentの設定
			    intent1.putExtra("data1", Koumoku.toString());
			    intent1.putExtra("data2", Utiwake.getText().toString());
			    intent1.putExtra("data3", Kingaku.getText().toString());
			    intent1.putExtra("date4",turn);
			    intent1.putExtra("write1", "ok");
			    intent1.putExtra("Koumokuhantei", true);
			    intent1.putExtra("year25", year);
			    intent1.putExtra("month25", month);
			    intent1.putExtra("day25", day);
			    startActivity(intent1);
			}
			
		});
		
		Button Gakusyokubutton = (Button) findViewById(id.button1);//ｌ学食メニューへ画面遷移
		Gakusyokubutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent2 =new Intent();
				intent2.setClass( MainActivity25.this,  MainActivity101.class);
				intent2.putExtra("year101", year);
			    intent2.putExtra("month101", month);
			    intent2.putExtra("day101", day);
                startActivity(intent2);
			}
			
		});
			
	}
}
