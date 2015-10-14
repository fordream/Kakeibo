package jp.ac.shizuoka.inf.cs.cs13000.group3;

import jp.ac.shizuoka.inf.cs.cs13000.group3.R.id;
import java.util.Calendar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity91 extends Activity {

	private Button[] button_table=new Button[50];//ｶﾚﾝﾀﾞｰボタンの配列の定義

    Calendar calendar = Calendar.getInstance();//ｶﾚﾝﾀﾞｰクラスのオブジェクトを作成
    int year = calendar.get(Calendar.YEAR);//それぞれ現在の日時を取得
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int dayOfWeek =calendar.get(Calendar.DAY_OF_WEEK);
    

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity91);
        
        button_table[1] = (Button)findViewById(id.button1_1);
        button_table[2] = (Button)findViewById(id.button1_2);
        button_table[3] = (Button)findViewById(id.button1_3);
        button_table[4] = (Button)findViewById(id.button1_4);
        button_table[5] = (Button)findViewById(id.button1_5);
        button_table[6] = (Button)findViewById(id.button1_6);
        button_table[7] = (Button)findViewById(id.button1_7);
        button_table[8] = (Button)findViewById(id.button2_1);
        button_table[9] = (Button)findViewById(id.button2_2);
        button_table[10] = (Button)findViewById(id.button2_3);
        button_table[11] = (Button)findViewById(id.button2_4);
        button_table[12] = (Button)findViewById(id.button2_5);
        button_table[13] = (Button)findViewById(id.button2_6);
        button_table[14] = (Button)findViewById(id.button2_7);
        button_table[15] = (Button)findViewById(id.button3_1);
        button_table[16] = (Button)findViewById(id.button3_2);
        button_table[17] = (Button)findViewById(id.button3_3);
        button_table[18] = (Button)findViewById(id.button3_4);
        button_table[19] = (Button)findViewById(id.button3_5);
        button_table[20] = (Button)findViewById(id.button3_6);
        button_table[21] = (Button)findViewById(id.button3_7);
        button_table[22] = (Button)findViewById(id.button4_1);
        button_table[23] = (Button)findViewById(id.button4_2);
        button_table[24] = (Button)findViewById(id.button4_3);
        button_table[25] = (Button)findViewById(id.button4_4);
        button_table[26] = (Button)findViewById(id.button4_5);
        button_table[27] = (Button)findViewById(id.button4_6);
        button_table[28] = (Button)findViewById(id.button4_7);
        button_table[29] = (Button)findViewById(id.button5_1);
        button_table[30] = (Button)findViewById(id.button5_2);
        button_table[31] = (Button)findViewById(id.button5_3);
        button_table[32] = (Button)findViewById(id.button5_4);
        button_table[33] = (Button)findViewById(id.button5_5);
        button_table[34] = (Button)findViewById(id.button5_6);
        button_table[35] = (Button)findViewById(id.button5_7);
        button_table[36] = (Button)findViewById(id.button6_1);
        button_table[37] = (Button)findViewById(id.button6_2);
        button_table[38] = (Button)findViewById(id.button6_3);
        button_table[39] = (Button)findViewById(id.button6_4);
        button_table[40] = (Button)findViewById(id.button6_5);
        button_table[41] = (Button)findViewById(id.button6_6);
        button_table[42] = (Button)findViewById(id.button6_7);
        
        
        
        calendar.set(year,month,1);//現在のｶﾚﾝﾀﾞｰを現在の年、月の一日に設定
        day=calendar.get(Calendar.DAY_OF_MONTH);//現在の日を取得
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);//つき始めの１日の曜日を取得、日1,月2,・・・土7
        calendar.add(Calendar.MONTH, 1);//ｶﾚﾝﾀﾞｰを一ヶ月進める
        calendar.add(Calendar.DATE, -1);//ｶﾚﾝﾀﾞｰを一日戻す
       
        int lastDate = calendar.get(Calendar.DATE);//今の日がその月の末日
        //日1,月2,・・・土7
        
       
		for(int i=dayOfWeek;i<=dayOfWeek+lastDate-1;i++){
			button_table[i].setText(String.valueOf(day));
			button_table[i].setTextSize(15);
			day=day+1;
		}
		//それぞれのｶﾚﾝﾀﾞｰボタンにdayをsetTextする
		
		String tablename = String.valueOf(year)+"年"+String.valueOf(month+1) +"月"; 
        TextView yearmonthday = (TextView) findViewById(id.textView2);
	    yearmonthday.setText(tablename);
	    //上に現在の日時を表示する。
		
	
			 
		Button Xbutton = (Button) findViewById(id.button2);
		Xbutton.setOnClickListener( new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent();
	    		intent.setClass(MainActivity91.this,MainActivity91.class);
	    		startActivity(intent);
			}
		});
		
		        
		Button beforebutton = (Button) findViewById(id.button3);
		beforebutton.setOnClickListener( new View.OnClickListener() {
			public void onClick(View v) {
				if(month==0){
	    			year=year-1;
	    			month=11;
	    		}
	    		else{
	    			month=month-1;
	    		}
				TextView yearmonthday = (TextView) findViewById(id.textView2);
				yearmonthday.setText(String.valueOf(year+"年"+(month+1)+"月"));
	            calendar.set(year,month,1);
	            day=calendar.get(Calendar.DAY_OF_MONTH);
	            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	            calendar.add(Calendar.MONTH, 1);
	            calendar.add(Calendar.DATE, -1);
	            int lastDate = calendar.get(Calendar.DATE);
	            calendar.set(year,month,1);
	            //日1,月2,・・・土7
	            for(int i=1;i<dayOfWeek;i++){
	            	button_table[i].setText("");
	            }
	    		for(int i=dayOfWeek;i<=dayOfWeek+lastDate-1;i++){
	    			button_table[i].setText(String.valueOf(day));
	    			button_table[i].setTextSize(15);
	    			day=day+1;
	    		}
	    		for(int i=dayOfWeek+lastDate;i<=42;i++){
	    			button_table[i].setText("");
	    		}
			}
		});
		     
		Button nextbutton = (Button) findViewById(id.button1);
		nextbutton.setOnClickListener( new View.OnClickListener() {
			public void onClick(View v) {
				if(month==11){
	    			year=year+1;
	    			month=0;
	    		}
	    		else{
	    			month=month+1;
	    		}
				TextView yearmonthday = (TextView) findViewById(id.textView2);
				yearmonthday.setText(String.valueOf(year+"年"+(month+1)+"月"));
	            calendar.set(year,month,1);
	            day=calendar.get(Calendar.DAY_OF_MONTH);
	            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	            calendar.add(Calendar.MONTH, 1);
	            calendar.add(Calendar.DATE, -1);
	            int lastDate = calendar.get(Calendar.DATE);
	            calendar.set(year,month,1);
	            //日1,月2,・・・土7
	            for(int i=1;i<dayOfWeek;i++){
	            	button_table[i].setText("");
	            }
	    		for(int i=dayOfWeek;i<=dayOfWeek+lastDate-1;i++){
	    			button_table[i].setText(String.valueOf(day));
	    			button_table[i].setTextSize(15);
	    			day=day+1;
	    		}
	    		for(int i=dayOfWeek+lastDate;i<=42;i++){
	    			button_table[i].setText("");
	    		}
			}
		});
		
		
		
		for (int i = 1; i <= 42; i++) {//ボタンすべてにクリック処理を設定する
			button_table[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					calendar.set(year, month, 1);
					day = calendar.get(Calendar.DAY_OF_MONTH);
					dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
					calendar.add(Calendar.MONTH, 1);
					calendar.add(Calendar.DATE, -1);
					int lastDate = calendar.get(Calendar.DATE);
					calendar.set(year, month, 1);
					
					for (int i = dayOfWeek; i <= dayOfWeek + lastDate - 1; i++) {
					//全部で４２子あるボタンの中でもdayがsetTextされているボタンのみそのボタンの情報を返すように設定する
						if (v == button_table[i]) {
							Intent intent = new Intent();
							intent.setClass(MainActivity91.this,
									MainActivity29.class);
							intent.putExtra("year", year);
							intent.putExtra("month", month);
							intent.putExtra("day", day);
							intent.putExtra("hantei", true);
							startActivity(intent);
						}
						day = day + 1;
					}

				}

			});
		}
		    	
		        
		        
    }
}

		