package com.javaclass.anima.android03a2a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent it2Page2 ,it2Page3;
    Button GotoPage2,GotoPage3;
    TextView show ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GotoPage2 = (Button) findViewById(R.id.gotoPage2);
        GotoPage3 = (Button) findViewById(R.id.gotoPage3);
        show = (TextView) findViewById(R.id.show);


        GotoPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it2Page2 =new Intent(MainActivity.this,Page2.class);
                it2Page2.putExtra("name","Brad");
                it2Page2.putExtra("price",123);
                //startActivity(it2Page2);
                startActivityForResult(it2Page2,2);
            }
        });
        GotoPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPage3();
            }
        });
    }



    private void gotoPage3() {
        Intent intent = new Intent(this, Page3.class);
        // startActivity(intent);
        startActivityForResult(intent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            show.setText("Come back from Page2");
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("data");
                show.append("\n" + result);
            }
        } else if (requestCode == 3) {
            show.setText("Come back from Page3");
        } else {
            show.setText("Hello, Page");
        }
    }
}
