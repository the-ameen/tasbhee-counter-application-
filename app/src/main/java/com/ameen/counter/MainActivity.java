package com.ameen.counter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity {
    Button btncount,btnreset;
    TextView textView;
    int i;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncount=findViewById(R.id.count);
        textView=findViewById(R.id.fadingtextviewww);
        btnreset=findViewById(R.id.rst);

        sharedPref=getSharedPreferences("userinfo",Context.MODE_PRIVATE);
        editor=sharedPref.edit();
        Toast.makeText(this,"CREATED BY AMEEN ",Toast.LENGTH_LONG).show();


        String user=sharedPref.getString("counttt","");
        textView.setText(user);
        int getcountint=Integer.parseInt(user);
        i=getcountint;






        btncount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                editor.putString("counttt", String.valueOf(i));
                editor.apply();
                textView.setText(i+"");

            }
        });
        btnreset.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                i=0;
                //editor.putInt("counttt", i);
                textView.setText(i+"");
                SharedPreferences sharedPref=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();

                editor.putString("counttt", textView.getText().toString());
                editor.apply();
                return false;

            }
        });


    }


    public void onBackPressed() {

        editor.putString("counttt", textView.getText().toString());

        editor.apply();
        Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();

        finish();


    }

}
