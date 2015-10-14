package jp.ac.shizuoka.inf.cs.cs13000.group3;

import jp.ac.shizuoka.inf.cs.cs13000.group3.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.RectF;
import android.graphics.Rect;
import java.awt.*;

public class MainActivity extends Activity {
	final int MATRIX_NUM = 20;
	String Koumokudate;
	String Utiwakedate;
	String Kingakudate;
	int year;
	int month;
	int day;
	int sum_syokuhi = 0;
	int sum_koutuhi = 0;
	int sum_gorakuhi = 0;
	int sum_kounetuhi = 0;
	int sum_gakugyouhi = 0;
	int sum_circlehi = 0;
	int sum_sonota = 0;
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(new CanvasView(this, MATRIX_NUM));
		Intent intent3 = getIntent();
		year = intent3.getIntExtra("yeargraph", year);
		month = intent3.getIntExtra("monthgraph", month);
		day = intent3.getIntExtra("daygraph", day);
		
		Button button1 = new Button(this);
		button1.setText("ボタン1");
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		//setContentView(layout);
		
		layout.addView(button1); 
		layout.addView(new CanvasView(this, MATRIX_NUM));
		setContentView(layout);

		try {
			// クラスのインスタンス化

			SubOpenHelper helper = new SubOpenHelper(getApplicationContext(),
					"test22.db", 1);
			// コンストラクタのデータを決める。コンテキスト、DBファイル名、バージョン。

			// データベースの設定
			SQLiteDatabase db;
			db = helper.getWritableDatabase();
			// データベースに書き込めるように設定

			// カーソルの設定
			String[] cols = { "Koumoku", "Utiwake", "Kingaku", "year", "month",
					"day" };
			Cursor c = db.query("Date_Table", cols, null, null, null, null,
					null, null);
			// カーソルのリストを作る。１：テーブル名、２：取得する列名（カラム等）の配列、
			// ３＆４：取得するレコードの条件、５：GROUP BY条件、６：「HAVING」条件、
			// ７：「ORDER BY」条件、８：「limit」条件
			boolean isEof = c.moveToFirst();
			// カーソルを先頭に移動

			// ソートするための変数
			while (isEof) {
				if (c.getString(3).equals(String.valueOf(year))
						&& (Integer.parseInt(c.getString(4)) + 1) == (month + 1)
						&& c.getString(5).equals(String.valueOf(day))) {
					if (c.getString(0).equals("食費")) {
						sum_syokuhi += Integer.parseInt(c.getString(2));

					} else if (c.getString(0).equals("交通費")) {
						sum_koutuhi += Integer.parseInt(c.getString(2));

					} else if (c.getString(0).equals("娯楽費")) {
						sum_gorakuhi += Integer.parseInt(c.getString(2));

					} else if (c.getString(0).equals("光熱費")) {
						sum_kounetuhi += Integer.parseInt(c.getString(2));

					} else if (c.getString(0).equals("学業費")) {
						sum_gakugyouhi += Integer.parseInt(c.getString(2));

					} else if (c.getString(0).equals("サークル費")) {
						sum_circlehi += Integer.parseInt(c.getString(2));

					} else if (c.getString(0).equals("その他")) {
						sum_sonota += Integer.parseInt(c.getString(2));

					}

				}
				isEof = c.moveToNext();
				// sortを今の項目（c.getString(0)）にセットする
				// 次の
				// while文。カーソルが最後に行くまで繰り返す。
				// getString(0)メソッドで、カーソルの一行目を追加。2,3も同じ。
				// }

			}

			c.close();
			// 終わったら閉じる。これがないとエラーとなる。データベースも。
			db.close();
		}

		// 異常終了時
		catch (SQLiteException e) {
			return;
		}

	}

	class CanvasView extends View {
		int matrixNum;
		int status[][];
		int posX;
		int posY;

		Context con;

		CanvasView(Context context, int num) {
			super(context);
			con = context;
			matrixNum = num;
			status = new int[matrixNum][matrixNum];
			for (int y = 0; y < matrixNum; y++) {
				for (int x = 0; x < matrixNum; x++) {
					status[y][x] = 0;
				}
			}
			posX = 0;
			posY = 0;
			setBackgroundColor(Color.WHITE);

		}

		protected void onDraw(Canvas canvas) {
			

			int screenWidth = getWidth();
			int screenHeight = getHeight();
			int boxWidth;
			if (screenWidth < screenHeight) {
				boxWidth = screenWidth;
			} else {
				boxWidth = screenHeight;
			}
			int yHeight = (int) ((float) boxWidth / matrixNum);
			int xWidth = (int) ((float) boxWidth / matrixNum);
			int lineWidth = screenWidth / 200;
			int width = (int) ((float) boxWidth / matrixNum);

			Paint paint = new Paint();
			paint.setColor(Color.RED);
			paint.setStrokeWidth(lineWidth);
			for (int i = 0; i <= matrixNum; i++) {
				canvas.drawLine(i * xWidth, 0, i * xWidth, boxWidth - 1, paint);
				canvas.drawLine(0, i * yHeight, boxWidth - 1, i * yHeight,
						paint);
			}
			Paint onoffPanel[] = new Paint[3];
			onoffPanel[0] = new Paint();
			onoffPanel[1] = new Paint();
			onoffPanel[2] = new Paint();
			onoffPanel[0].setColor(Color.WHITE);
			onoffPanel[0].setStyle(Paint.Style.FILL);
			onoffPanel[1].setColor(Color.rgb(255, 64, 64));
			onoffPanel[1].setStyle(Paint.Style.FILL);
			onoffPanel[2].setColor(Color.YELLOW);
			onoffPanel[2].setStyle(Paint.Style.FILL);

			Paint p = new Paint();
			p.setTextSize(width);
			canvas.drawText("食        交通    娯楽    光熱    学業    サ   その他", 0, width * (matrixNum + 1), p);
			canvas.drawText(String.valueOf(sum_syokuhi),0, width * (matrixNum + 1) + 50, p);
			canvas.drawText(String.valueOf(sum_koutuhi),70, width * (matrixNum + 1) + 50, p);
			canvas.drawText(String.valueOf(sum_gorakuhi),140, width * (matrixNum + 1) + 50, p);
			canvas.drawText(String.valueOf(sum_kounetuhi),210, width * (matrixNum + 1) + 50, p);
			canvas.drawText(String.valueOf(sum_gakugyouhi),280, width * (matrixNum + 1) + 50, p);
			canvas.drawText(String.valueOf(sum_circlehi),350, width * (matrixNum + 1) + 50, p);
			canvas.drawText(String.valueOf(sum_sonota),420, width * (matrixNum + 1) + 50, p);

			int graph_syokuhi = sum_syokuhi;
			int graph_koutuhi = sum_koutuhi;
			int graph_gorakuhi = sum_gorakuhi;
			int graph_kounetuhi = sum_kounetuhi;
			int graph_gakugyouhi = sum_gakugyouhi;
			int graph_circlehi = sum_circlehi;
			int graph_sonota = sum_sonota;
			int g_syokuhi = graph_syokuhi / 100;// statusの配列を20に変更してるから、金額をとりあえず1~20にする
			int g_koutuhi = graph_koutuhi / 100;
			int g_gorakuhi = graph_gorakuhi / 100;
			int g_kounetuhi = graph_kounetuhi / 100;
			int g_gakugyouhi = graph_gakugyouhi / 100;
			int g_circlehi = graph_circlehi / 100;
			int g_sonota = graph_sonota / 100;
			
			for(int i = 0; i < g_syokuhi && i < 20; i++) {
				status[19 - i][0] = 2;
			}
			
			for(int i = 0; i < g_koutuhi && i < 20; i++) {
				status[19 - i][3] = 2;
			}
			
			for(int i = 0; i < g_gorakuhi && i < 20; i++) {
				status[19 - i][6] = 2;
			}
			
			for(int i = 0; i < g_kounetuhi && i < 20; i++) {
				status[19 - i][9] = 2;
			}
			
			for(int i = 0; i < g_gakugyouhi && i < 20; i++) {
				status[19 - i][12] = 2;
			}
			
			for(int i = 0; i < g_circlehi && i < 20; i++) {
				status[19 - i][15] = 2;
			}
			
			for(int i = 0; i < g_sonota && i < 20; i++) {
				status[19 - i][18] = 2;
			}
			
		
			for (int y = 0; y < matrixNum; y++) {
				for (int x = 0; x < matrixNum; x++) {
					canvas.drawRect(new RectF(x * xWidth + 1, y * yHeight + 1,
							(x + 1) * xWidth - 1, (y + 1) * yHeight - 1),
							onoffPanel[status[y][x]]);
				}
			}

		}

	}

}
