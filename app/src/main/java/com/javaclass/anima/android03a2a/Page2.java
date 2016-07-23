package com.javaclass.anima.android03a2a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {

    TextView text2;
    String name;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Intent it = getIntent();
        name = it.getStringExtra("name");
        price = it.getIntExtra("price", 0);

        text2 = (TextView) findViewById(R.id.tv_text2);
        text2.setText("作者 ： " + name +"\n"+ " price : " + price);

    }

    @Override
    public void finish() {
        Intent it = new Intent();
        it.putExtra("data","ok");
        setResult(RESULT_OK,it);

        super.finish();
    }
}
