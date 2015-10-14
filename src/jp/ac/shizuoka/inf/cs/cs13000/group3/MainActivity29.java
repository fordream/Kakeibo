package jp.ac.shizuoka.inf.cs.cs13000.group3;

import java.util.Calendar;

import jp.ac.shizuoka.inf.cs.cs13000.group3.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Canvas;

public class MainActivity29 extends Activity {
	String Koumokudate[];
	String Utiwakedate[];
	String Kingakudate[];
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);;
	int month = calendar.get(Calendar.MONTH);;
	int day = calendar.get(Calendar.DAY_OF_MONTH);
	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	String tablename = String.valueOf(year) + "-" + String.valueOf(month + 1)
			+ "-" + String.valueOf(day);

	int turn = 0;
	boolean Calenderhantei = false;
	boolean Gakusyokuhantei = false;
	boolean Koumokuhantei = false;
	static int Count = 0;
	static int count = 0;
	static int Buttoncount = 0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity29);
		count = 0;
		Intent intent1 = getIntent();
		Intent intent2 = getIntent();
		Intent intent4 = getIntent();
		TextView yearmonthday = (TextView) findViewById(id.textView1);
		Button button6 = (Button)findViewById(id.button6);
		button6.setText("全削除");
		button6.setTextSize(9);
		//二つのインテントのインスタンスを作成
		
		//項目や学食の画面から戻ってきたときに、日付をセットしなおさないようにする
		if(Count != 0) {
			if(intent1.getStringExtra("write1") != null ) {
				Buttoncount = 1;
			}
			if(intent2.getStringExtra("write2") != null ) {
				Buttoncount = 1;
			}
		}
		
		if (Count != 0) {// 初回はこのプログラムで現在の日時を取得して、次回からはｶﾚﾝﾀﾞｰから時間をもってくる
			Intent intent3 = getIntent();
			year = intent3.getIntExtra("year", year);
			month = intent3.getIntExtra("month", month);
			day = intent3.getIntExtra("day", day);
			tablename = String.valueOf(year) + "-" + String.valueOf(month + 1)
					+ "-" + String.valueOf(day);
			yearmonthday.setText(tablename);
			
		}
		
		//項目画面から戻ってきたときに、項目画面に移る前の日付の情報を取得
		if(intent1.getStringExtra("write1") != null) {
			Intent intent3 = getIntent();
			year = intent3.getIntExtra("year25", year);
			month = intent3.getIntExtra("month25", month);
			day = intent3.getIntExtra("day25", day);
			tablename = String.valueOf(year) + "-" + String.valueOf(month + 1)
					+ "-" + String.valueOf(day);
			yearmonthday.setText(tablename);
		}
		
		//学食画面から戻ってきたときに、学食画面に移る前の日付の情報を取得
		if(intent1.getStringExtra("write2") != null) {
			Intent intent3 = getIntent();
			year = intent3.getIntExtra("year101", year);
			month = intent3.getIntExtra("month101", month);
			day = intent3.getIntExtra("day101", day);
			tablename = String.valueOf(year) + "-" + String.valueOf(month + 1)
					+ "-" + String.valueOf(day);
			yearmonthday.setText(tablename);
		}
		
		
		//deleteButtonを押したときの日付を取得
				if(intent4.getStringExtra("Buttondelete") != null) {
					Intent intent3 = getIntent();
					year = intent3.getIntExtra("yeardelete", year);
					month = intent3.getIntExtra("monthdelete", month);
					day = intent3.getIntExtra("daydelete", day);
					tablename = String.valueOf(year) + "-" + String.valueOf(month + 1)
							+ "-" + String.valueOf(day);
					yearmonthday.setText(tablename);
				}
		
		//nextButtonを押したとき＋１された日付を取得
		if(intent4.getStringExtra("Buttonnext") != null) {
			Intent intent3 = getIntent();
			year = intent3.getIntExtra("yearnext", year);
			month = intent3.getIntExtra("monthnext", month);
			day = intent3.getIntExtra("daynext", day);
			tablename = String.valueOf(year) + "-" + String.valueOf(month + 1)
					+ "-" + String.valueOf(day);
			yearmonthday.setText(tablename);
		}
		
		//beforeButtonを押したとき-１された日付を取得
		if(intent4.getStringExtra("Buttonbefore") != null) {
			Intent intent3 = getIntent();
			year = intent3.getIntExtra("yearbefore", year);
			month = intent3.getIntExtra("monthbefore", month);
			day = intent3.getIntExtra("daybefore", day);
			tablename = String.valueOf(year) + "-" + String.valueOf(month + 1)
					+ "-" + String.valueOf(day);
			yearmonthday.setText(tablename);
		}
		

		yearmonthday.setText(tablename);
		

		Koumokudate = new String[8];
		Utiwakedate = new String[8];
		Kingakudate = new String[8];

		for (int i = 0; i < 8; i++) {
			Koumokudate[i] = null;
			Utiwakedate[i] = null;
			Kingakudate[i] = null;
		}

		Koumokuhantei = intent1.getBooleanExtra("Koumokuhantei", false);
		if (Koumokuhantei == true && Count != 0) {
			// 項目追加からの情報受け取り
			// turn = intent1.getIntExtra("date4", turn);
			Koumokudate[0] = intent1.getStringExtra("data1");
			Utiwakedate[0] = intent1.getStringExtra("data2");
			Kingakudate[0] = intent1.getStringExtra("data3");
		}

		Gakusyokuhantei = intent2.getBooleanExtra("Gakusyokuhantei", false);
		if (Gakusyokuhantei == true && Count != 0) {
			// 学食メニューからの情報受け取り
			for (int i = 1; i < 8; i++) {
				Koumokudate[i] = intent2.getStringExtra("Koumoku");
				Utiwakedate[i] = intent2.getStringExtra("Utiwakedata" + i);
				Kingakudate[i] = intent2.getStringExtra("Kingaku" + i);
			}
		}
		
		// TextViewに各値を表示させるための設定
		TextView KoumokuView = (TextView) findViewById(id.textView3);
		TextView SumView = (TextView) findViewById(id.textView4);
		

		// データベースに書き込んで読み込む設定
		try {
			// クラスのインスタンス化
			int sum = 0;
			SubOpenHelper helper = new SubOpenHelper(getApplicationContext(),
					"test22.db", 1);
			// コンストラクタのデータを決める。コンテキスト、DBファイル名、バージョン。

			// データベースの設定
			SQLiteDatabase db;
			db = helper.getWritableDatabase();
			// データベースに書き込めるように設定

			if (intent1.getStringExtra("write1") != null) {
				if(!intent1.getStringExtra("data3").equals("")) {
					db.execSQL("insert into  Date_Table(Koumoku,Utiwake,Kingaku,year,month,day) values ('"
							+ Koumokudate[0]
							+ "', '"
							+ Utiwakedate[0]
							+ "','"
							+ Kingakudate[0] 
							+ "','"
							+ year
							+ "','"
							+ month
							+ "','"
							+ day + "');");
					// insertで行に追加
				}
			}

			if (intent2.getStringExtra("write2") != null) {
				for (int i = 1; i < 8; i++) {
					if (!intent2.getStringExtra("Utiwakedata" + i).equals("無し")) {
						db.execSQL("insert into  Date_Table(Koumoku,Utiwake,Kingaku,year,month,day) values ('"
								+ Koumokudate[i]
								+ "', '"
								+ Utiwakedate[i]
								+ "','"
								+ Kingakudate[i] 
								+ "','"
								+ year
								+ "','"
								+ month
								+ "','"
								+ day + "');");
					}
				}

			}

			KoumokuView.setText("");
			// text1の初期化

			// カーソルの設定
			String[] cols = { "Koumoku", "Utiwake", "Kingaku","year","month","day" };
			Cursor c = db.query("Date_Table", cols, null, null, null, null,
					null, null);
			// カーソルのリストを作る。１：テーブル名、２：取得する列名（カラム等）の配列、
			// ３＆４：取得するレコードの条件、５：GROUP BY条件、６：「HAVING」条件、
			// ７：「ORDER BY」条件、８：「limit」条件
			boolean isEof = c.moveToFirst();
			// カーソルを先頭に移動

			String sort = "";
			// ソートするための変数
			while (isEof) {
				if(c.getString(3).equals(String.valueOf(year)) && (Integer.parseInt(c.getString(4))+1) == (month +1) && c.getString(5).equals(String.valueOf(day))   ){
					if (!sort.equals(c.getString(0))) {
						KoumokuView.append("\n" + c.getString(0) + "\n");
					}
					KoumokuView.append("          " + c.getString(1)
							+ "           " + c.getString(2) + "円\n");
					
					
					sort = c.getString(0);
					if(!c.getString(2).equals("") && !c.getString(2).equals(null)) {
						sum += Integer.parseInt(c.getString(2));
						
					}
				}	
					isEof = c.moveToNext();
					// sortを今の項目（c.getString(0)）にセットする
					// 次の
					// while文。カーソルが最後に行くまで繰り返す。
					// getString(0)メソッドで、カーソルの一行目を追加。2,3も同じ。
				//}
				
			}
			SumView.setText("合計；" + sum);
			// 次のリストにカーソルを移す。
			c.close();
			// 終わったら閉じる。これがないとエラーとなる。データベースも。
			db.close();
		}

		// 異常終了時
		catch (SQLiteException e) {
			KoumokuView.setText("エラー");
			return;
		}

		
		// 追加部分
		Button Beforebutton = (Button) findViewById(id.button1);
		Beforebutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				calendar.set(year, month, 1);
				// day=calendar.get(Calendar.DAY_OF_MONTH);
				// dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
				// calendar.add(Calendar.MONTH, 1);
				calendar.add(Calendar.DATE, -1);
				// 戻るボタンだから知りたいのは前月の末日だからmonthは+1しなくていい
				int lastDate = calendar.get(Calendar.DATE);

				if (Buttoncount == 0 ) {
					Calendar calendar2 = Calendar.getInstance();
					day = calendar2.get(Calendar.DAY_OF_MONTH);
					// 初回は現在の時刻に設定する。
					// ボタンを押すたびに時刻が変わると困るのでほんとの初回のみ
				}
				Intent intent3 = getIntent();
				Calenderhantei = intent3.getBooleanExtra("hantei", false);
				// intentクラスのオブジェクト作成とｶﾚﾝﾀﾞｰから日杖を取得したかどうかのhanteiを取得
				if (Calenderhantei == true && count == 0) {
					year = intent3.getIntExtra("year", year);
					month = intent3.getIntExtra("month", month);
					day = intent3.getIntExtra("day", day);
					count++;
					// ここも初回だけｶﾚﾝﾀﾞｰの時刻を取得する
				}
				Calenderhantei = false;
				calendar.set(year, month, day);

				if (day == 1) {
					if (month == 0) {
						year--;
						month = 11;
						day = lastDate;
					} else {
						month--;
						day = lastDate;

					}
				} else {
					day--;
				}
				
				Buttoncount++;
				count++;
				
				Intent intent = new Intent();
				intent.putExtra("yearbefore", year);
				intent.putExtra("monthbefore", month);
				intent.putExtra("daybefore", day);
				intent.putExtra("Buttonbefore","ok");
				intent.setClass(MainActivity29.this, MainActivity29.class);
				startActivity(intent);
				return;
				
			}
 
		});

		Button Nextbutton = (Button) findViewById(id.button2);
		Nextbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				calendar.set(year, month, 1);
				// day=calendar.get(Calendar.DAY_OF_MONTH);
				// dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
				calendar.add(Calendar.MONTH, 1);
				calendar.add(Calendar.DATE, -1);
				int lastDate = calendar.get(Calendar.DATE);
				if (Buttoncount == 0) {
					Calendar calendar2 = Calendar.getInstance();
					day = calendar2.get(Calendar.DAY_OF_MONTH);
				}
				Intent intent3 = getIntent();
				Calenderhantei = intent3.getBooleanExtra("hantei", false);

				if (Calenderhantei == true && count == 0) {
					year = intent3.getIntExtra("year", year);
					month = intent3.getIntExtra("month", month);
					day = intent3.getIntExtra("day", day);
					count++;
				}
				Calenderhantei = false;
				calendar.set(year, month, day);

				if (day == lastDate) {
					if (month == 11) {
						year++;
						month = 0;
						day = 1;
					} else {
						month++;
						day = 1;

					}
				} else {
					day++;
				}
				Buttoncount++;
				
				Intent intent = new Intent();
				intent.setClass(MainActivity29.this, MainActivity29.class);
				intent.putExtra("yearnext", year);
				intent.putExtra("monthnext", month);
				intent.putExtra("daynext", day);
				intent.putExtra("Buttonnext", "ok");
				startActivity(intent);
				return;
				
			}

		});

		Button Graphbutton = (Button) findViewById(id.button3);
		Graphbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity29.this, MainActivity.class);
				intent.putExtra("yeargraph", year);
				intent.putExtra("monthgraph", month);
				intent.putExtra("daygraph", day);
				startActivity(intent);
				return;
			}

		});

		Button Calenderbutton = (Button) findViewById(id.button4);
		Calenderbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity29.this, MainActivity91.class);
				startActivity(intent);
				return;
			}

		});

		Button Koumokubutton = (Button) findViewById(id.button5);
		Koumokubutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity29.this, MainActivity25.class);
				intent.putExtra("year25", year);
				intent.putExtra("month25", month);
				intent.putExtra("day25", day);
				startActivity(intent);
				return;
			}

		});

		Button Alldeletebutton = (Button) findViewById(id.button6);
		Alldeletebutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity29.this);
				alertDialogBuilder.setTitle("削除しますか？");
				alertDialogBuilder.setMessage("いいですか");
				
				alertDialogBuilder.setNegativeButton("削除",new DialogInterface.OnClickListener() {
					@Override
			        public void onClick(DialogInterface dialog, int which) {
						
						AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity29.this);
						alertDialogBuilder.setTitle("本当に削除しますか？");
						alertDialogBuilder.setMessage("本当にいいですか");
						
						alertDialogBuilder.setNegativeButton("削除",new DialogInterface.OnClickListener() {
							@Override
					        public void onClick(DialogInterface dialog, int which) {
								SubOpenHelper helper = new SubOpenHelper(
										getApplicationContext(), "test22.db", 1);
								SQLiteDatabase db;
								db = helper.getWritableDatabase();
								db.delete("Date_Table", "_id like '%'", null);
								// この命令でデータベースを完全初期化できる。
								Intent intent = new Intent();
								intent.setClass(MainActivity29.this, MainActivity29.class);
								intent.putExtra("yeardelete", year);
								intent.putExtra("monthdelete", month);
								intent.putExtra("daydelete", day);
								intent.putExtra("Buttondelete", "ok");
								startActivity(intent);
								return;
					        }
					    });
						
						alertDialogBuilder.setPositiveButton("キャンセル",
				                new DialogInterface.OnClickListener() {
				                    @Override
				                    public void onClick(DialogInterface dialog, int which) {
				                    }
				                });
						
						AlertDialog alertDialog = alertDialogBuilder.create();
						alertDialog.show();
						
						
			        }
			    });
				 alertDialogBuilder.setPositiveButton("キャンセル",
			                new DialogInterface.OnClickListener() {
			                    @Override
			                    public void onClick(DialogInterface dialog, int which) {
			                    }
			                });

				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}

		});
		
		Count++;
		
		
		
		

	}
}