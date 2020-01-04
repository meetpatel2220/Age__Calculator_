package in.md.meet.agecalculator;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener mdate, mdate1;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9,t10,t11;
    EditText eday, emonth, eyear, eday1, emonth1, eyear1;
    MediaPlayer mysong;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mysong=MediaPlayer.create(MainActivity.this,R.raw.hbd);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t9 = findViewById(R.id.t9);
        t10 = findViewById(R.id.t10);
        t11 = findViewById(R.id.t11);

        eday = findViewById(R.id.day);
        emonth = findViewById(R.id.month);
        eyear = findViewById(R.id.year);
        eday1 = findViewById(R.id.day1);
        emonth1 = findViewById(R.id.month1);
        eyear1 = findViewById(R.id.year1);

        MobileAds.initialize(this, "ca-app-pub-4990616185549475~9391762331");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eday.setText("");
                emonth.setText("");
                eyear.setText("");
                eday1.setText("");
                emonth1.setText("");
                eyear1.setText("");

                t4.setText("- - Days");
                t5.setText("- - Hours");
                t6.setText("- - Minutes");
                t7.setText("- - Seconds");
                t8.setText("- - Years - - Months - - Days");
                t9.setText("- - Weeks");
                t11.setText("- - Months - - Days");

            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new
                        DatePickerDialog(MainActivity.this, android.R.style.Theme, mdate, year
                        , month, day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();


            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal1 = Calendar.getInstance();
                int year1 = cal1.get(Calendar.YEAR);
                int month1 = cal1.get(Calendar.MONTH);
                int day1 = cal1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog1 = new
                        DatePickerDialog(MainActivity.this, android.R.style.Theme, mdate1, year1
                        , month1, day1);

                datePickerDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog1.show();


            }
        });

        mdate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;
                eday.setText(day + "");
                emonth.setText(month + "");
                eyear.setText(year + "");

            }
        };

        mdate1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year1, int month1, int day1) {
                month1 = month1 + 1;

                eday1.setText(day1 + "");
                emonth1.setText(month1 + "");
                eyear1.setText(year1 + "");

            }
        };
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int D1=0 , D2 = 0, Y1 = 0, Y2 = 0, M1 = 0, M2 = 0;

                try {
                    D1 = Integer.parseInt(eday.getText().toString().trim());
                    M1 = Integer.parseInt(emonth.getText().toString().trim());
                    Y1 = Integer.parseInt(eyear.getText().toString().trim());
                    D2 = Integer.parseInt(eday1.getText().toString().trim());
                    M2 = Integer.parseInt(emonth1.getText().toString().trim());
                    Y2 = Integer.parseInt(eyear1.getText().toString().trim());

                } catch (NumberFormatException ne) {

                }

               int xx=D1;
                int xx1=M1;

                int pp=D2;
                int pp1=M2;


                int zz=Y1;
                int zz1=0;

                if (zz % 4 == 0) {

                    if (zz % 100 == 0) {

                        if (zz %400 == 0) {
                            zz1=1;
                        }

                    } else {
                        zz1=1;
                    }

                }
                int yy=Y2;
                int yy1=0;

                if (yy % 4 == 0) {

                    if (yy % 100 == 0) {

                        if (yy %400 == 0) {
                            yy1=1;
                        }

                    } else {
                        yy1=1;
                    }

                }
                if(D1==29 && M1==2){
                    D1=1;
                    M1=3;
                }
                if(pp==29 && pp1==2){
                    D2=1;
                    M2=3;
                }
                if(xx==pp && xx1==pp1 && xx!=0 && pp!=0 && xx1!=0 && pp1!=0){
                                   t11.setText("Today is your BirthDay");

                    mysong.start();
                }

                if(pp==29 && pp1==2 && yy1==0){
                    eday1.setError("invalid date");
                }
                else if(xx==29 && xx1==2 && zz1==0){
                    eday.setError("invalid date");

                }
                else if(eday==null){
                    eday.setError("Please write date");


                } else if(eday1==null){
                    eday1.setError("Please write date");


                }
               else if(emonth==null){
                    emonth.setError("Please write date");


                } else if(emonth1==null){
                    emonth1.setError("Please write date");


                }
                else if(eyear==null){

                    eyear.setError("Please write date");


                } else if(eyear1==null){
                    eyear1.setError("Please write date");


                }
                else if(M1>12 ){
                    emonth.setError("Please do correct date");

                }
                else if( M2>12 ){
                    emonth1.setError("Please do correct date");

                }
                else if (M1 == 1 && D1 > 31) {
                    eday.setError("Please do correct date");

                } else if (M1 == 2 && D1 > 28) {

                    if(zz1==1){

                        if(D1>29){
                            eday.setError("Please do correct date");

                        }
                    }
                   else {
                        eday.setError("Please do correct date");

                    }

                } else if (M1 == 3 && D1 > 31) {
                    eday.setError("Please do correct date");

                } else if (M1 == 4 && D1 > 30) {
                    eday.setError("Please do correct date");

                } else if (M1 == 5 && D1 > 31) {
                    eday.setError("Please do correct date");

                } else if (M1 == 6 && D1 > 30) {
                    eday.setError("Please do correct date");

                } else if (M1 == 7 && D1 > 31) {
                    eday.setError("Please do correct date");

                } else if (M1 == 8 && D1 > 31) {
                    eday.setError("Please do correct date");

                } else if (M1 == 9 && D1 > 30) {
                    eday.setError("Please do correct date");

                } else if (M1 == 10 && D1 > 31) {
                    eday.setError("Please do correct date");

                } else if (M1 == 11 && D1 > 30) {
                    eday.setError("Please do correct date");

                } else if (M1 == 12 && D1 > 31) {
                    eday.setError("Please do correct date");

                }
                else if (M2 == 1 && D2 > 31) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 2 && D2 > 28) {

                    if(yy1==1){

                        if(D2>29){
                            eday1.setError("Please do correct date");

                        }
                    }
                    else {
                        eday1.setError("Please do correct date");

                    }

                } else if (M2 == 3 && D2 > 31) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 4 && D2 > 30) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 5 && D2 > 31) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 6 && D2 > 30) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 7 && D2 > 31) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 8 && D2 > 31) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 9 && D2 > 30) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 10 && D2 > 31) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 11 && D2 > 30) {
                    eday1.setError("Please do correct date");

                } else if (M2 == 12 && D2 > 31) {
                    eday1.setError("Please do correct date");

            }


                else  {




                    int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                    int m = 0;
                    int p = Y1;
                    if (M1 <= 2) {
                        while (p < Y2) {


                            if (p % 4 == 0) {

                                if (p % 100 == 0) {

                                    if (p % 400 == 0) {
                                        m = m + 1;
                                    }

                                } else {
                                    m = m + 1;
                                }

                            }
                            p++;

                        }
                    } else {
                        int r = Y1 + 1;
                        while (r < Y2) {
                            if (r % 4 == 0) {



                                if (r % 100 == 0) {

                                    if (r % 400 == 0) {
                                        m = m + 1;
                                    }

                                } else {
                                    m = m + 1;
                                }

                            }
                            r++;


                        }
                    }

                    for (int i = 1; i <= 12; i++) {
                        for (int j = 1; j <= 12; j++) {

                            if (M1 == i && M2 == j) {
                                int o = i + 1;
                                int n = 0;
                                int f = 0;
                                while (o <= 12) {
                                    f = f + 1;
                                    n = n + a[o - 1];
                                    o++;
                                }
                                int l = 0;
                                int q = j;

                                while (0 <= q - 2) {
                                    f = f + 1;

                                    l = l + a[q - 2];
                                    q--;


                                }
                                int xxx=0;
                                int yyy;
                       yyy=0;
                                if(xx==29 && xx1==2){

                                    int jj=Y2;

                                    while(jj % 4 != 0 && xxx!=0) {

                                        if (jj % 100 == 0) {

                                            if (jj % 400 == 0) {
                                                m = m + 1;
                                                xxx=1;
                                                yyy=jj;
                                            }

                                        } else {
                                            m = m + 1;
                                            xxx=1;
                                            yyy=jj;

                                        }

                                        jj++;
                                    }



                                }




                                if(M1==M2){
                                    if(xx==29 && xx1==2 && pp==29 && pp1==2) {

                                        t11.setText("Today is your BirthDay");


                                    }else {

                                        if(D1<D2){
                                            t11.setText("11 Months "+(a[M2-1]+D1-D2)+" Days");

                                        }
                                        else {
                                            t11.setText((D1-D2)+" Days");

                                        }

                                    }

                                }
                                if(M2<M1){

                                    if(D1>=D2){

                                        if(xx==29 && xx1==2){
                                            t11.setText((yyy-Y2)+" Years "+(M1-M2)+" Months "+(D1-D2-1)+" Days");

                                        }
                                        if(pp==29 && pp1==2){
                                            t11.setText((M1-M2)+" Months "+(D1-D2+1)+" Days");

                                        }

                                        else {
                                            t11.setText((M1-M2)+" Months "+(D1-D2)+" Days");

                                        }
                                    }else {
                                        if(xx==29 && xx1==2){
                                            t11.setText((yyy-Y2)+" Years "+(M1-M2-1)+" Months "+(a[M2-1]-D2+D1-1)+" Days");

                                        }
                                        if(pp==29 && pp1==2){
                                            t11.setText((M1-M2-1)+" Months "+(a[M2-1]-D2+D1+1)+" Days");

                                        }

                                        else {
                                            t11.setText((M1-M2-1)+" Months "+(a[M2-1]-D2+D1)+" Days");

                                        }



                                    }

                                }
                                if(M2>M1){
                                    if(D1>=D2){

                                        if(xx==29 && xx1==2){
                                            t11.setText((yyy-Y2-1)+" Years "+(12-M2+M1)+" Months "+(D1-D2-1)+" Days");

                                        }
                                        if(pp==29 && pp1==2){
                                            t11.setText((12-M2+M1)+" Months "+(D1-D2+1)+" Days");

                                        }
                                         else
                                         {
                                            t11.setText((12-M2+M1)+" Months "+(D1-D2)+" Days");

                                        }

                                    }else {

                                        if(xx==29 && xx1==2){
                                            t11.setText((yyy-Y2-1)+" Years "+(12-M2+M1-1)+" Months "+(a[M2-1]-D2+D1-1)+" Days");

                                        }
                                        if(pp==29 && pp1==2){
                                            t11.setText((12-M2+M1-1)+" Months "+(a[M2-1]-D2+D1+1)+" Days");

                                        }

                                        else {
                                            t11.setText((12-M2+M1-1)+" Months "+(a[M2-1]-D2+D1)+" Days");

                                        }

                                    }

                                }



                                if (Y1 == Y2) {

                                    if (M1 == M2) {

                                        if(xx==29 && xx1==2 && pp!=29 ){
                                            t8.setText("0 Years 0 Months " + (D2 - D1+1) + " Days");

                                        }
                                        if(pp==29 && pp1==2 && xx!=29){
                                            t8.setText("0 Years 0 Months " + (D2 - D1-1) + " Days");

                                        }
                                        else{
                                            t8.setText("0 Years 0 Months " + (D2 - D1) + " Days");

                                        }
                                    } else {
                                        if (D2 >= D1) {

                                            if(xx==29 && xx1==2 && pp!=29){
                                                t8.setText("0 Years " + (M2 - M1) + " Months " + (D2 - D1+1) + " Days");

                                            }
                                            if(pp==29 && pp1==2 && xx!=29){
                                                t8.setText("0 Years " + (M2 - M1) + " Months " + (D2 - D1-1) + " Days");

                                            }
                                            else{
                                                t8.setText("0 Years " + (M2 - M1) + " Months " + (D2 - D1) + " Days");

                                            }

                                        } else {
                                            if(xx==29 && xx1==2 && pp!=29){
                                                t8.setText("0 Years " + (M2 - M1 - 1) + " Months " + (a[M1 - 1] - D1 + D2+1) + " Days");

                                            }
                                            if(pp==29 && pp1==2 && xx!=29){
                                                t8.setText("0 Years " + (M2 - M1 - 1) + " Months " + (a[M1 - 1] - D1 + D2-1) + " Days");

                                            }
                                            else {
                                                t8.setText("0 Years " + (M2 - M1 - 1) + " Months " + (a[M1 - 1] - D1 + D2) + " Days");

                                            }


                                        }
                                    }


                                }

                                if (Y1 != Y2) {

                                    if (M2 == M1) {

                                        if (D2 >= D1) {

                                            if(xx==29 && xx1==2 && pp!=29){
                                                t8.setText((Y2 - Y1) + " Years " + (0) + " Months " + (D2 - D1+1) + " Days");

                                            }
                                            if(pp==29 && pp1==2 && xx!=29){
                                                t8.setText((Y2 - Y1) + " Years " + (0) + " Months " + (D2 - D1-1) + " Days");

                                            }
                                            else {
                                                t8.setText((Y2 - Y1) + " Years " + (0) + " Months " + (D2 - D1) + " Days");

                                            }

                                        } else {

                                            if(xx==29 && xx1==2 && pp!=29){
                                                t8.setText((Y2 - Y1 - 1) + " Years " + (11 - D1 + D2) + " Months " + (a[M1 - 1] - D1 + D2+1) + " Days");

                                            }
                                            if(pp==29 && pp1==2 && xx!=29){
                                                t8.setText((Y2 - Y1 - 1) + " Years " + (11 - D1 + D2) + " Months " + (a[M1 - 1] - D1 + D2-1) + " Days");

                                            }
                                            else {
                                                t8.setText((Y2 - Y1 - 1) + " Years " + (11 - D1 + D2) + " Months " + (a[M1 - 1] - D1 + D2) + " Days");

                                            }

                                        }

                                    }
//szdlndjn
                                    if (M2 > M1) {

                                        if (D2 >= D1) {

                                            if(xx==29 && xx1==2 && pp!=29){
                                                t8.setText((Y2 - Y1) + " Years " + (M2 - M1) + " Months " + (D2 - D1+1) + " Days");

                                            }
                                            if(pp==29 && pp1==2 && xx!=29){
                                                t8.setText((Y2 - Y1) + " Years " + (M2 - M1) + " Months " + (D2 - D1-1) + " Days");

                                            }
                                            else {
                                                t8.setText((Y2 - Y1) + " Years " + (M2 - M1) + " Months " + (D2 - D1) + " Days");

                                            }

                                        } else {
                                            if(xx==29 && xx1==2 && pp!=29){
                                                t8.setText((Y2 - Y1) + " Years " + (M2 - M1 - 1) + " Months " + (a[M1 - 1] - D1 + D2+1) + " Days");

                                            }
                                            if(pp==29 && pp1==2 && xx!=29){
                                                t8.setText((Y2 - Y1) + " Years " + (M2 - M1 - 1) + " Months " + (a[M1 - 1] - D1 + D2-1) + " Days");

                                            }
                                            else {
                                                t8.setText((Y2 - Y1) + " Years " + (M2 - M1 - 1) + " Months " + (a[M1 - 1] - D1 + D2) + " Days");

                                            }

                                        }

                                    } else {


                                        if (D2 >= D1) {

                                            if(xx==29 && xx1==2 && pp!=29){
                                                if((12-M1+M2)==12)
                                                {
                                                    t8.setText((Y2 - Y1) + " Years " + "0 Months " + (D2 - D1+1) + " Days");

                                                }
                                                else {
                                                    t8.setText((Y2 - Y1 - 1) + " Years " + (12 - M1 + M2) + " Months " + (D2 - D1+1) + " Days");

                                                }

                                            }
                                            if(pp==29 && pp1==2 && xx!=29){
                                                if((12-M1+M2)==12)
                                                {
                                                    t8.setText((Y2 - Y1) + " Years " + "0 Months " + (D2 - D1-1) + " Days");

                                                }
                                                else {
                                                    t8.setText((Y2 - Y1 - 1) + " Years " + (12 - M1 + M2) + " Months " + (D2 - D1-1) + " Days");

                                                }



                                            }
                                            else {

                                                if((12 - M1 + M2)==12){
                                                    t8.setText((Y2 - Y1) + " Years " +"0 Months " + (D2 - D1) + " Days");

                                                }
                                                else {
                                                    t8.setText((Y2 - Y1 - 1) + " Years " + (12 - M1 + M2) + " Months " + (D2 - D1) + " Days");

                                                }

                                            }

                                        } else {
                                            if(xx==29 && xx1==2 && pp!=29){
                                                if((11 - M1 + M2)==12){
                                                    t8.setText((Y2 - Y1) + " Years " +  "0 Months " + (a[M1 - 1] - D1 + D2+1) + " Days");

                                                }
                                                else {
                                                    t8.setText((Y2 - Y1 - 1) + " Years " + (11 - M1 + M2) + " Months " + (a[M1 - 1] - D1 + D2+1) + " Days");

                                                }

                                            }
                                            if(pp==29 && pp1==2 && xx!=29){

                                                if((11 - M1 + M2)==12){

                                                    t8.setText((Y2 - Y1 ) + " Years " + "0 Months " + (a[M1 - 1] - D1 + D2-1) + " Days");

                                                }
                                                else {
                                                    t8.setText((Y2 - Y1 - 1) + " Years " + (11 - M1 + M2) + " Months " + (a[M1 - 1] - D1 + D2-1) + " Days");

                                                }

                                            }
                                            else {
                                                if( (11 - M1 + M2)==12){

                                                    t8.setText((Y2 - Y1) + " Years "+ "0 Months " + (a[M1 - 1] - D1 + D2) + " Days");

                                                }
                                                else {
                                                    t8.setText((Y2 - Y1 - 1) + " Years " + (11 - M1 + M2) + " Months " + (a[M1 - 1] - D1 + D2) + " Days");

                                                }

                                            }

                                        }


                                    }

                                }


                                if (Y2 % 4 == 0 && M2 > 2) {
//jsdklb
                                    if(xx==29 && xx1==2 && pp!=29){
                                        t4.setText((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1+1) + " Days");

                                        t9.setText(((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1+1)) / 7 + " Weeks");
                                        t5.setText((24 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1+1)) + " Hours");
                                        t6.setText((24 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1+1)) + " Minutes");
                                        t7.setText((24 * 60 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1+1)) + " Seconds");

                                    }
                                    if(pp==29 && pp1==2 && xx!=29){
                                        t4.setText((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1-1) + " Days");

                                        t9.setText(((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1-1)) / 7 + " Weeks");
                                        t5.setText((24 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1-1)) + " Hours");
                                        t6.setText((24 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1-1)) + " Minutes");
                                        t7.setText((24 * 60 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1-1)) + " Seconds");

                                    }
                                    else {
                                        t4.setText((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1) + " Days");

                                        t9.setText(((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1)) / 7 + " Weeks");
                                        t5.setText((24 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1)) + " Hours");
                                        t6.setText((24 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1)) + " Minutes");
                                        t7.setText((24 * 60 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m + 1)) + " Seconds");

                                    }

                                } else {

                                    if(xx==29 && xx1==2 && pp!=29){
                                        t4.setText((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m+1) + " Day");
                                        t9.setText(((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m+1) / 7) + " Weeks");

                                        t5.setText(24 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m+1) + " Hours");
                                        t6.setText(24 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m+1) + " Minutes");
                                        t7.setText(24 * 60 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m+1) + " Seconds");

                                    }
                                    if(pp==29 && pp1==2 && xx!=29){
                                        t4.setText((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m-1) + " Day");
                                        t9.setText(((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m-1) / 7) + " Weeks");

                                        t5.setText(24 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m-1) + " Hours");
                                        t6.setText(24 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m-1) + " Minutes");
                                        t7.setText(24 * 60 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m-1) + " Seconds");

                                    }
                             else {
                                        t4.setText((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m) + " Day");
                                        t9.setText(((365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m) / 7) + " Weeks");

                                        t5.setText(24 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m) + " Hours");
                                        t6.setText(24 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m) + " Minutes");
                                        t7.setText(24 * 60 * 60 * (365 * (Y2 - Y1 - 1) + n + l + a[M1 - 1] - D1 + D2 + m) + " Seconds");

                                    }


                                }


                            }


                        }


                    }




                }





            }
        });


    }


}
