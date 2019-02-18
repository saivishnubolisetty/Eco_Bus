package project.pbd.klu.ecobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main9Activity extends AppCompatActivity {
    EditText w,w1;
    Button a;
    String n,p;
    MyDatabase myDb;
    int mike=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        a=findViewById(R.id.button9);
        w=findViewById(R.id.editText5);
        w1=findViewById(R.id.editText6);
        myDb = new MyDatabase(this);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=w.getText().toString();
                p=w1.getText().toString();
               mike= myDb.doInsert(n,p);
               if(mike==1)
               {
                   Intent i=new Intent(getApplicationContext(),Main8Activity.class);
                   startActivity(i);
               }
            }
        });
    }
}
