package com.umeng.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.umeng.myapplication.utils.AlarmMangerUtils;

public class MainActivity extends Activity {

    private EditText et1 ;
    private EditText et2 ;
    private Button btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn = (Button) findViewById(R.id.btn);





            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   String text1 = et1.getText().toString();
                    String  text2 = et2.getText().toString();
                    Log.e("kong","str1=" + text1);
                    Log.e("kong","str2=" + text2);
                    AlarmMangerUtils.setAlarm(MainActivity.this, 1, Integer.parseInt(text1), Integer.parseInt(text2),  0 );
                }
            });




    }
}
