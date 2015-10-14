package jp.ac.shizuoka.inf.cs.cs13000.group3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.widget.Button;
import android.widget.Spinner;
import jp.ac.shizuoka.inf.cs.cs13000.group3.R.id;
import android.view.View;


public class MainActivity101 extends Activity {
	static boolean Gakusyokuhantei = false;
	static int year;
	static int month;
	static int day;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity101);
		Intent intent = getIntent();
		year = intent.getIntExtra("year101", year);
		month = intent.getIntExtra("month101", month);
		day = intent.getIntExtra("day101", day);
		

		
	    Button OKbutton = (Button) findViewById(id.button1);
	    OKbutton.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    	Intent intent =new Intent();
                intent.setClass( MainActivity101.this,  MainActivity29.class);
               
                Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
                Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
                Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
                Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);
                Spinner spinner5 = (Spinner)findViewById(R.id.spinner5);
                Spinner spinner6 = (Spinner)findViewById(R.id.spinner6);
                Spinner spinner7 = (Spinner)findViewById(R.id.spinner7);
                
                
                String Utiwake1 = spinner1.getSelectedItem().toString();
                String Utiwake2 = spinner2.getSelectedItem().toString();
                String Utiwake3 = spinner3.getSelectedItem().toString();
                String Utiwake4 = spinner4.getSelectedItem().toString();
                String Utiwake5 = spinner5.getSelectedItem().toString();
                String Utiwake6 = spinner6.getSelectedItem().toString();
                String Utiwake7 = spinner7.getSelectedItem().toString();
                
                String Kingaku1 = null;
                String Kingaku2 = null;
                String Kingaku3 = null;
                String Kingaku4 = null;
                String Kingaku5 = null;
                String Kingaku6 = null;
                String Kingaku7 = null;
                 
                
                if(Utiwake4.equals( "ネギ塩から揚げ丼（中）")) {
                	Kingaku4 = "368";
                }
                if(Utiwake2.equals( "クリームチーズバーグ")) {
                	Kingaku2 = "368";
                }
                
                if(Utiwake2.equals( "チキンおろしだれ")) {
                	Kingaku2 = "294";
                }
                if(Utiwake2.equals( "スンドゥブ")) {
                	Kingaku2 = "294";
                }
                if(Utiwake2.equals( "海老カツ")) {
                	Kingaku2 = "294";
                }
                if(Utiwake2.equals( "豆乳煮")) {
                	Kingaku2 = "157";
                }
                if(Utiwake2.equals( "ささみチーズカツ")) {
                	Kingaku2 = "157";
                }
                if(Utiwake2.equals( "豚生姜焼き")) {
                	Kingaku2 = "157";
                }
                if(Utiwake2.equals( "デミグラスハンバーグ")) {
                	Kingaku2 = "157";
                }
                if(Utiwake2.equals( "サバの味噌煮")) {
                	Kingaku2 = "157";
                }
                if(Utiwake2.equals( "秋刀魚の塩焼き")) {
                	Kingaku2 = "157";
                }
                if(Utiwake2.equals( "大根と豚肉の味噌あん")) {
                	Kingaku2 = "126";
                }
                if(Utiwake2.equals( "カニクリームコロッケ")) {
                	Kingaku2 = "105";
                }
                if(Utiwake2.equals( "旨辛豆腐")) {
                	Kingaku2 = "126";
                }
                if(Utiwake2.equals( "麻婆豆腐")) {
                	Kingaku2 = "126";
                }
                if(Utiwake3.equals( "バランス惣菜")) {
                	Kingaku3 = "84";
                }
                if(Utiwake3.equals( "いももち")) {
                	Kingaku3 = "84";
                }
                if(Utiwake3.equals( "揚げ出し豆腐")) {
                	Kingaku3 = "84";
                }
                if(Utiwake3.equals( "ほうれん草のゴマ和え")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "揚げ餃子")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "五目ひじき")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "煮玉子")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "牛とろコロッケ")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "冷奴")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "カボチャの煮物")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "きんぴらごぼう")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "オクラとモロヘイヤのおひたし")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "揚げ茄子キムチ和え")) {
                	Kingaku3 = "52";
                }
                if(Utiwake3.equals( "大根おろし")) {
                	Kingaku3 = "31";
                }
                if(Utiwake3.equals( "彩りサラダ")) {
                	Kingaku3 = "126";
                }
                if(Utiwake3.equals( "ポテトコーン＆サラダ")) {
                	Kingaku3 = "84";
                }
                if(Utiwake1.equals( "ごはん（小）")) {
                	Kingaku1 = "63";
                }
                if(Utiwake1.equals( "ごはん（中）")) {
                	Kingaku1 = "94";
                }
                if(Utiwake1.equals( "ごはん（大）")) {
                	Kingaku1 = "126";
                }
                if(Utiwake1.equals( "麦飯（小）")) {
                	Kingaku1 = "63";
                }
                if(Utiwake1.equals( "麦飯（中）")) {
                	Kingaku1 = "94";
                }
                if(Utiwake1.equals( "麦飯（大）")) {
                	Kingaku1 = "126";
                }
                if(Utiwake4.equals( "特選ハンバーグ丼（小）")) {
                	Kingaku4 = "450";
                }
                if(Utiwake4.equals( "特選ハンバーグ丼（中）")) {
                	Kingaku4 = "480";
                }
                if(Utiwake4.equals( "特選ハンバーグ丼（大）")) {
                	Kingaku4 = "510";
                }
                if(Utiwake4.equals( "パワー丼（小）")) {
                	Kingaku4 = "336";
                }
                if(Utiwake4.equals( "パワー丼（中）")) {
                	Kingaku4 = "399";
                }
                if(Utiwake4.equals( "パワー丼（大）")) {
                	Kingaku4 = "483";
                }
                if(Utiwake4.equals( "チキン竜田丼（小）")) {
                	Kingaku4 = "336";
                }
                if(Utiwake4.equals( "チキン竜田丼（中）")) {
                	Kingaku4 = "399";
                }
                if(Utiwake4.equals( "チキン竜田丼（大）")) {
                	Kingaku4 = "483";
                }
                if(Utiwake4.equals( "豚玉丼（小）")) {
                	Kingaku4 = "304";
                }
                if(Utiwake4.equals( "豚玉丼（中）")) {
                	Kingaku4 = "367";
                }
                if(Utiwake4.equals( "豚玉丼（大）")) {
                	Kingaku4 = "451";
                }
                if(Utiwake4.equals( "ネギ塩唐揚げ丼（小）")) {
                	Kingaku4 = "304";
                }
                if(Utiwake4.equals( "ネギ塩唐揚げ丼（大）")) {
                	Kingaku4 = "451";
                }
                if(Utiwake4.equals( "カレーライス（小）")) {
                	Kingaku4 = "220";
                }
                if(Utiwake4.equals( "カレーライス（中）")) {
                	Kingaku4 = "252";
                }
                if(Utiwake4.equals( "カレーライス（大）")) {
                	Kingaku4 = "336";
                }
                if(Utiwake4.equals( "カツカレーライス（小）")) {
                	Kingaku4 = "367";
                }
                if(Utiwake4.equals( "カツカレーライス（中）")) {
                	Kingaku4 = "399";
                }
                if(Utiwake4.equals( "カツカレーライス（大）")) {
                	Kingaku4 = "462";
                }
                if(Utiwake5.equals( "唐揚げらーめん")) {
                	Kingaku5 = "399";
                }
                if(Utiwake5.equals( "唐揚げらーめん（大）")) {
                	Kingaku5 = "462";
                }
                if(Utiwake5.equals( "台湾ﾗｰﾒﾝ")) {
                	Kingaku5 = "399";
                }
                if(Utiwake5.equals( "台湾ラーメン（大）")) {
                	Kingaku5 = "462";
                }
                if(Utiwake5.equals( "味噌らーめん")) {
                	Kingaku5 = "346";
                }
                if(Utiwake5.equals( "味噌らーめん（大）")) {
                	Kingaku5 = "409";
                }
                if(Utiwake5.equals( "肉野菜そば")) {
                	Kingaku5 = "367";
                }
                if(Utiwake5.equals( "かき揚げそば")) {
                	Kingaku5 = "304";
                }
                if(Utiwake5.equals( "釜玉そば")) {
                	Kingaku5 = "304";
                }
                if(Utiwake5.equals( "ほうとう風うどん")) {
                	Kingaku5 = "367";
                }
                if(Utiwake5.equals( "肉野菜うどん")) {
                	Kingaku5 = "367";
                }
                if(Utiwake5.equals( "かき揚げうどん")) {
                	Kingaku5 = "304";
                }
                if(Utiwake5.equals( "釜玉うどん")) {
                	Kingaku5 = "304";
                }
                if(Utiwake6.equals( "豚汁（小）")) {
                	Kingaku6 = "73";
                }
                if(Utiwake6.equals( "豚汁")) {
                	Kingaku6 = "105";
                }
                if(Utiwake6.equals( "わかめと豆腐のお味噌汁")) {
                	Kingaku6 = "31";
                }
                if(Utiwake7.equals( "ストロベリーティラミス")) {
                	Kingaku7 = "105";
                }
                if(Utiwake7.equals( "ベイクドチーズケーキ")) {
                	Kingaku7 = "105";
                }
                if(Utiwake7.equals( "プラリネトルテ")) {
                	Kingaku7 = "105";
                }
                if(Utiwake7.equals( "ヘーゼルナッツ＆モカ")) {
                	Kingaku7 = "105";
                }
                if(Utiwake7.equals( "レモンケーキ")) {
                	Kingaku7 = "105";
                }
                if(Utiwake7.equals( "いちごトルテ")) {
                	Kingaku7 = "105";
                }
                if(Utiwake7.equals( "杏仁豆腐")) {
                	Kingaku7 = "84";
                }
               
                
                
              //ここにif文で一個ずつ学食の値段を定義する。
                
                
                
                /* if(!Utiwake1.equals("無し")) {
                 	intent.putExtra("Koumoku","食費");
                 }
                 else {
                 	Utiwake1 = null;
                 	intent.putExtra("Koumoku","null");
                 }
                 
                 if(!Utiwake2.equals("無し")) {
                 	intent.putExtra("Koumoku","食費");
                 }
                 else {
                 	Utiwake2 = null;
                 	intent.putExtra("Koumoku","null");
                 }
                 */
                intent.putExtra("Koumoku", "食費");
                intent.putExtra("Utiwakedata1", Utiwake1.toString());
                intent.putExtra("Utiwakedata2", Utiwake2.toString());
                intent.putExtra("Utiwakedata3", Utiwake3.toString());
                intent.putExtra("Utiwakedata4", Utiwake4.toString());
                intent.putExtra("Utiwakedata5", Utiwake5.toString());
                intent.putExtra("Utiwakedata6", Utiwake6.toString());
                intent.putExtra("Utiwakedata7", Utiwake7.toString());
                intent.putExtra("Kingaku1", Kingaku1);
                intent.putExtra("Kingaku2", Kingaku2);
                intent.putExtra("Kingaku3", Kingaku3);
                intent.putExtra("Kingaku4", Kingaku4);
                intent.putExtra("Kingaku5", Kingaku5);
                intent.putExtra("Kingaku6", Kingaku6);
                intent.putExtra("Kingaku7", Kingaku7);
                intent.putExtra("year101", year);
			    intent.putExtra("month101", month);
			    intent.putExtra("day101", day);
				
				intent.putExtra("write2", "ok");
                intent.putExtra("Gakusyokuhantei", true);
                startActivity(intent);
                return;
			}
			
		});
			
	}
}
