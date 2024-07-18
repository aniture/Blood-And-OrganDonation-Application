package dec.eighteen.mani.blooddonar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmBlood extends AppCompatActivity {
    Bundle b;
    DatabaseHelper dbh;
    TextView t1,t2,t3;
    String one,two,thr;
    EditText e1,e2,e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_blood);
        b=getIntent().getExtras();
        one=b.getString("name");
        two=b.getString("phno");
        thr=b.getString("blood");

        t1=findViewById(R.id.name);
        t2=findViewById(R.id.phno);
        t3=findViewById(R.id.bg);

        e1=findViewById(R.id.uname);
        e2=findViewById(R.id.mob);
        e3=findViewById(R.id.desc);


        b1=findViewById(R.id.app);

        t1.setText(one);
        t2.setText(two);
        t3.setText(thr);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh = new DatabaseHelper(ConfirmBlood.this);
                dbh.open();
                dbh.BloodReq(one,two,e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),"Not shared");
                dbh.updateprod(two,"Donated");
                Toast.makeText(ConfirmBlood.this,
                        "Approved", Toast.LENGTH_LONG)
                        .show();
                Intent i=new Intent(ConfirmBlood.this,BloodDonarList.class);
                startActivity(i);
                finish();
                dbh.close();
            }
        });

    }
}
