package project.pbd.klu.ecobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button k,x,o,u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k=(Button) findViewById(R.id.button);
        x=(Button) findViewById(R.id.button2);
        o=(Button) findViewById(R.id.button11);
        u=(Button) findViewById(R.id.button12);
        k.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);

            }
        });
        x.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Main7Activity.class);
                startActivity(intent);

            }
        });
        o.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Main8Activity.class);
                startActivity(intent);

            }
        });
        u.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Main9Activity.class);
                startActivity(intent);

            }
        });
    }
}
