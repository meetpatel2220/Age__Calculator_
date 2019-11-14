package in.tvac.akshaye.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1="Hello";
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });


    }
}
