package project.pbd.klu.ecobus;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    int yi=3;
    EditText a,b;
    Button login;
    String p,q,li,la;
    String[] un=new String[2000];
    String[] pass=new String[2000];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        try {
            un[0]="kumar";
            un[1]="evpr";
            un[2]="vishnu";

            pass[0]="kumar123";
            pass[1]="evpr123";
            pass[2]="vishnu123";

        Intent i= getIntent();
        li=i.getStringExtra("mix");
        la=i.getStringExtra("nix");
        if(li!=null && la!=null) {
            un[yi] = li;
            pass[yi] = la;
            yi++;
        }

            a = (EditText) findViewById(R.id.editText);
            b = (EditText) findViewById(R.id.editText2);
            login=(Button) findViewById(R.id.button);



            login.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    p = a.getText().toString();
                    q = b.getText().toString();

                    for(int i = 0; i<=3; i++) {
                        if (p.equals(un[i]))
                        {
                            if (q.equals(pass[i]))
                            {
                                next();
                                Toast.makeText(getApplicationContext(), "You have Logged in Successfully", Toast.LENGTH_LONG).show();
                                break;

                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_LONG).show();

                            }
                        }
                        else{
                            //Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_LONG).show();
                        }

                    }
                }
            });
        }

        catch(IndexOutOfBoundsException e)
        {
            throw new IllegalStateException("This is not Possible", e);
        }

        }
        public void next() {
            Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
            startActivity(intent);
        }
    }


