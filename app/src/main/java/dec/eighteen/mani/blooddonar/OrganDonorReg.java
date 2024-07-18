package dec.eighteen.mani.blooddonar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class OrganDonorReg extends AppCompatActivity {
    EditText un,pass,mail,phno,addr,adhar,organ;
    Button reg;
    String otp_res;
    String user,pwd,mailID,ph,address,adhrID,org;
    DatabaseHelper dbh;
    int MY_PERMISSIONS_REQUEST_READ_CONTACTS=1;
    public final static String PHNO="phno";
    public final static String ADDRESS="addr";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organ_donor_reg);
        un=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.pass);
        mail=(EditText)findViewById(R.id.mail);
        phno=(EditText)findViewById(R.id.phno);
        addr=(EditText)findViewById(R.id.addr);
        adhar=(EditText)findViewById(R.id.adhar);
        organ=(EditText)findViewById(R.id.organ);
        reg=(Button)findViewById(R.id.register);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=un.getText().toString();

                pwd=pass.getText().toString();
                mailID=mail.getText().toString();
                ph=phno.getText().toString();
                address=addr.getText().toString();
                adhrID=adhar.getText().toString();
                org=organ.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(un.getText().toString().contentEquals("") && pass.getText().toString().contentEquals("") && mail.getText().toString().contentEquals("") && phno.getText().toString().contentEquals("") &&
                        addr.getText().toString().contentEquals("") && adhar.getText().toString().contentEquals("") ){
                    Toast.makeText(OrganDonorReg.this,
                            "Enter Details first", Toast.LENGTH_LONG)
                            .show();
                }
                else if(un.getText().toString().contentEquals("")){
                    Toast.makeText(OrganDonorReg.this,
                            "Enter Username", Toast.LENGTH_LONG)
                            .show();
                }
                else if(pass.getText().toString().contentEquals("")){
                    Toast.makeText(OrganDonorReg.this,
                            "Enter Password", Toast.LENGTH_LONG)
                            .show();
                }
                else if(mail.getText().toString().contentEquals("")){
                    Toast.makeText(OrganDonorReg.this,
                            "Enter MailID", Toast.LENGTH_LONG)
                            .show();
                }
                else if (!(mail.getText().toString()).matches(emailPattern) )
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();

                }
                else if(phno.getText().toString().contentEquals("")){
                    Toast.makeText(OrganDonorReg.this,
                            "Enter Phone Number", Toast.LENGTH_LONG)
                            .show();
                }
                else if(addr.getText().toString().contentEquals("")){
                    Toast.makeText(OrganDonorReg.this,
                            "Enter Address", Toast.LENGTH_LONG)
                            .show();
                }

                else if(adhar.getText().toString().contentEquals("")){
                    Toast.makeText(OrganDonorReg.this,
                            "Enter Pincode", Toast.LENGTH_LONG)
                            .show();
                }

                else {
                    dbh = new DatabaseHelper(OrganDonorReg.this);
                    dbh.open();


                    Random r = new Random();
                    int otp = r.nextInt(9000 - 1000) + 1000;
                    otp_res = String.valueOf(otp);
                    // Toast.makeText(Register.this, "OTP" + otp_res, Toast.LENGTH_LONG) .show();


                    Toast.makeText(OrganDonorReg.this,
                            "Registeration finished", Toast.LENGTH_LONG)
                            .show();

                    dbh.RegisterOrgan(user,pwd,mailID,ph,address,adhrID,org,"Not Donate");
                    Toast.makeText(OrganDonorReg.this,
                            "Congrats: Register Successfull", Toast.LENGTH_LONG)
                            .show();

                    dbh.close();
                    Intent i=new Intent(OrganDonorReg.this, OrganDonorLogin.class);
                    startActivity(i);
                    finish();
                }










            }
        });
    }
}
