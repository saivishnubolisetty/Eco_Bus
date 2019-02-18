package project.pbd.klu.ecobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {
    EditText u,h;
    Button nb;
    String sa,si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        u=findViewById(R.id.editText3);
        h=findViewById(R.id.editText4);
        nb=(Button) findViewById(R.id.button8);
        nb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sa=u.getText().toString();
                si=h.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("mix",sa);
                intent.putExtra("nix",si);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"you have successfully registerd",Toast.LENGTH_LONG).show();
            }
        });

    }
}
