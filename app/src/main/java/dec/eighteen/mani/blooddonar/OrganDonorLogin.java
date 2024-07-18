package dec.eighteen.mani.blooddonar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrganDonorLogin extends AppCompatActivity {
    EditText e1,e2;
    Button b1,reg;
    String name,pass;
    public final static String NAME1="Name_Orgon";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organ_donor_login);
        e1=(EditText)findViewById(R.id.un);
        e2=(EditText)findViewById(R.id.pd);
        b1=(Button)findViewById(R.id.login);
        reg=(Button)findViewById(R.id.reg);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name= e1.getText().toString();
                pass= e2.getText().toString();

                if(name.contentEquals(" ") && pass.contentEquals(" ")){
                   /* Intent ii = new Intent(Login.this,UserDashboard.class);
                    startActivity(ii);*/
                    Toast.makeText(OrganDonorLogin.this,"Enter the details", Toast.LENGTH_LONG).show();
                }else{
                    DatabaseHelper dbh = new DatabaseHelper(OrganDonorLogin.this);
                    dbh.open();
                    String gpass= dbh.retrievepass1(name);
                    //region = dbh.retrievereg(name);
                    if(pass.contentEquals(gpass)){
//				Intent ii = new Intent(this,GenerateQRCode.class);
                      /*  Intent ii = new Intent(Login.this,UserDashboard.class);
                        startActivity(ii);*/
                        Toast.makeText(OrganDonorLogin.this,"Login successfully...", Toast.LENGTH_LONG).show();

                        SharedPreferences sp=getSharedPreferences(NAME1,0);
                        SharedPreferences.Editor se=sp.edit();
                        se.putString("key_orgon",e1.getText().toString());
                        se.apply();
                        Intent i=new Intent(OrganDonorLogin.this,OrganGetAlert.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(OrganDonorLogin.this,"Authentication Failure", Toast.LENGTH_LONG).show();
                    }
                }
                e1.setText("");
                e2.setText("");
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(OrganDonorLogin.this,OrganDonorReg.class);
                startActivity(ii);
            }
        });
    }
}
