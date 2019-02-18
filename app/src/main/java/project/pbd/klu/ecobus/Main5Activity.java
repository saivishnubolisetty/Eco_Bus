package project.pbd.klu.ecobus;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    TextView m,n;
    String l,kk,text;
    int k,pk,pio;
    Button z;
    MyDatabase myDb;
    ClipboardManager myClipboard;
    ClipData abc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        m=findViewById(R.id.textView8);
        z=(Button)findViewById(R.id.button7);
        n=findViewById(R.id.textView6);
        myDb = new MyDatabase(this);
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        if (myClipboard != null) {
            abc = myClipboard.getPrimaryClip();
        }
        if(abc!=null) {
            ClipData.Item item = abc.getItemAt(0);
             text = item.getText().toString();
        }

        Intent i= getIntent();
           pk =i.getIntExtra("mi",1);
           l=i.getStringExtra("ni");
           kk=i.getStringExtra("locc");
       k =pk*1400;
       m.append(Integer.toString(k));
       n.append(l);

       z.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), Main6Activity.class);
               startActivity(intent);
               myDb.dInsert(l,kk,text,k);
                             }

           });

    }
}
