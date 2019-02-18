package project.pbd.klu.ecobus;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main10Activity extends AppCompatActivity {
    Button a5,a2,a3,a4,a6,a9;
    MyDatabase myDb;
    EditText id,nm,pp;
    ClipboardManager myClipboard;
    ClipData ac;
    String tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        a2=findViewById(R.id.button13);
        a3=findViewById(R.id.button14);
        a4=findViewById(R.id.button15);
        a5=findViewById(R.id.button16);
        a6=findViewById(R.id.button18);
        a9=findViewById(R.id.button19);
        nm=findViewById(R.id.editText7);
        pp=findViewById(R.id.editText8);
        id=findViewById(R.id.editText9);
        myDb = new MyDatabase(this);
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        if (myClipboard != null) {
            ac = myClipboard.getPrimaryClip();
        }
        if(ac!=null) {
            ClipData.Item item = ac.getItemAt(0);
            tt = item.getText().toString();
        }

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
                startActivity(intent);
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.loadData(tt);
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.delete(Integer.parseInt(id.getText().toString()));
            }
        });

        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.updateDate(Integer.parseInt(id.getText().toString().trim()), nm.getText().toString(), pp.getText().toString());
            }
        });
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.deleteall();
            }
        });

        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.ld(tt);
            }
        });

    }
}
