package dec.eighteen.mani.blooddonar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class BloodDonorReg extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText un,pass,mail,phno,addr,adhar;
    Button reg;
    String otp_res,res_type;
    String user,pwd,mailID,ph,address,adhrID;
    DatabaseHelper dbh;
    int MY_PERMISSIONS_REQUEST_READ_CONTACTS=1;
    public final static String PHNO="phno";
    public final static String ADDRESS="addr";
    Spinner spinner;
    String[] dept = { "A+","B+","A-","B-","AB+","AB-","O+","O-",  };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_donor_reg);
        un=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.pass);
        mail=(EditText)findViewById(R.id.mail);
        phno=(EditText)findViewById(R.id.phno);
        addr=(EditText)findViewById(R.id.addr);
        adhar=(EditText)findViewById(R.id.adhar);
        reg=(Button)findViewById(R.id.register);
        spinner=findViewById(R.id.type);
        spinner.setOnItemSelectedListener(BloodDonorReg.this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.spinner, dept);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=un.getText().toString();

                pwd=pass.getText().toString();
                mailID=mail.getText().toString();
                ph=phno.getText().toString();
                address=addr.getText().toString();
                adhrID=adhar.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(un.getText().toString().contentEquals("") && pass.getText().toString().contentEquals("") && mail.getText().toString().contentEquals("") && phno.getText().toString().contentEquals("") &&
                        addr.getText().toString().contentEquals("") && adhar.getText().toString().contentEquals("") ){
                    Toast.makeText(BloodDonorReg.this,
                            "Enter Details first", Toast.LENGTH_LONG)
                            .show();
                }
                else if(un.getText().toString().contentEquals("")){
                    Toast.makeText(BloodDonorReg.this,
                            "Enter Username", Toast.LENGTH_LONG)
                            .show();
                }
                else if(pass.getText().toString().contentEquals("")){
                    Toast.makeText(BloodDonorReg.this,
                            "Enter Password", Toast.LENGTH_LONG)
                            .show();
                }
                else if(mail.getText().toString().contentEquals("")){
                    Toast.makeText(BloodDonorReg.this,
                            "Enter MailID", Toast.LENGTH_LONG)
                            .show();
                }
                else if (!(mail.getText().toString()).matches(emailPattern) )
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();

                }
                else if(phno.getText().toString().contentEquals("")){
                    Toast.makeText(BloodDonorReg.this,
                            "Enter Phone Number", Toast.LENGTH_LONG)
                            .show();
                }
                else if(addr.getText().toString().contentEquals("")){
                    Toast.makeText(BloodDonorReg.this,
                            "Enter Address", Toast.LENGTH_LONG)
                            .show();
                }

                else if(adhar.getText().toString().contentEquals("")){
                    Toast.makeText(BloodDonorReg.this,
                            "Enter Pincode", Toast.LENGTH_LONG)
                            .show();
                }

                else {
                    dbh = new DatabaseHelper(BloodDonorReg.this);
                    dbh.open();


                    Random r = new Random();
                    int otp = r.nextInt(9000 - 1000) + 1000;
                    otp_res = String.valueOf(otp);
                    // Toast.makeText(Register.this, "OTP" + otp_res, Toast.LENGTH_LONG) .show();


                    Toast.makeText(BloodDonorReg.this,
                            "Registeration finished", Toast.LENGTH_LONG)
                            .show();

                    dbh.Register(user,pwd,mailID,ph,address,adhrID,res_type,"Not Donate");
                    Toast.makeText(BloodDonorReg.this,
                            "Congrats: Register Successfull", Toast.LENGTH_LONG)
                            .show();

                    dbh.close();
                    Intent i=new Intent(BloodDonorReg.this, BloodDonorLogin.class);
                    startActivity(i);
                    finish();
                }










            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        res_type = dept[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
