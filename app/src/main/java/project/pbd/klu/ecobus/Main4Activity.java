package project.pbd.klu.ecobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {
    Button a,b,c,d;
    MyDatabase myDb;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        a=(Button) findViewById(R.id.button3);
        b=(Button) findViewById(R.id.button4);
        c=(Button)findViewById(R.id.button5);
        d=(Button)findViewById(R.id.button6);
        myDb = new MyDatabase(this);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s="BZA -> HYD";
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                intent.putExtra("loc",s);
                startActivity(intent);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 s="HYD -> BZA";
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                intent.putExtra("loc",s);
                startActivity(intent);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s="BZA -> SBC";
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                intent.putExtra("loc",s);
                startActivity(intent);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s="SBC -> BZA";
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                intent.putExtra("loc",s);
                startActivity(intent);
            }
        });


    }
}
