package project.pbd.klu.ecobus;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main8Activity extends AppCompatActivity {

    EditText name,color;
    Button b;
    int l;
    String n,p;
    MyDatabase myDb;
    ClipboardManager myClipboard;
    ClipData myClip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        try {

            name = findViewById(R.id.name);
            color = findViewById(R.id.pwd);
            b = findViewById(R.id.button10);
            myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            myDb = new MyDatabase(this);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    n = name.getText().toString();
                    p = color.getText().toString();

                    l = myDb.compare(n, p);
                    if (l == 1) {
                        String t1 = n;
                        myClip= ClipData.newPlainText("text", t1);
                        myClipboard.setPrimaryClip(myClip);
                        Intent intent = new Intent(getApplicationContext(), Main10Activity.class);
                        startActivity(intent);
                    }

                }
            });
        }
        catch (Exception e){
        throw new IllegalStateException("This is not Possible", e);
    }

    }
}