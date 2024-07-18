package dec.eighteen.mani.blooddonar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class StemRegister extends AppCompatActivity {
    EditText un,pass,mail,phno,addr,adhar,stemm;
    Button reg;
    String otp_res;
    String user,pwd,mailID,ph,address,adhrID,ste;
     DatabaseHelper dbh;

     CheckBox c1,c2,c3,c4,c5,c6;
    int MY_PERMISSIONS_REQUEST_READ_CONTACTS=1;
    public final static String PHNO="phno";
    public final static String ADDRESS="addr";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stem_register);
        un=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.pass);
        mail=(EditText)findViewById(R.id.mail);
        phno=(EditText)findViewById(R.id.phno);
        addr=(EditText)findViewById(R.id.addr);
        adhar=(EditText)findViewById(R.id.adhar);
        stemm=(EditText)findViewById(R.id.stemm);
        reg=(Button)findViewById(R.id.register);
        c1=(CheckBox)findViewById(R.id.check1);
        c2=(CheckBox)findViewById(R.id.check2);
        c3=(CheckBox)findViewById(R.id.check3);
        c4=(CheckBox)findViewById(R.id.check4);
        c5=(CheckBox)findViewById(R.id.check5);
        c6=(CheckBox)findViewById(R.id.check6);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer buffer=new StringBuffer();

                if(c1.isChecked()){
                    buffer.append("leovin");
                    stemm.setText(buffer);

                }
                else if(c1.isChecked()==false) {
                    stemm.setText("");

                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer buffer=new StringBuffer();
                if(c2.isChecked()){
                    buffer.append("valves");
                    stemm.setText(buffer);

                }
                else if(c2.isChecked()==false) {
                    stemm.setText("");

                }
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StringBuffer buffer=new StringBuffer();
                if(c3.isChecked()){
                    buffer.append("Venis");
                    stemm.setText(buffer);

                }
                else if(c3.isChecked()==false) {
                    stemm.setText("");

                }
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StringBuffer buffer=new StringBuffer();
                if(c4.isChecked()){
                    buffer.append("Tendons");
                    stemm.setText(buffer);

                }
                else if(c4.isChecked()==false) {
                    stemm.setText("");

                }
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //StringBuffer buffer=new StringBuffer();
                if(c5.isChecked()){
                   // buffer.append("skin");
                    stemm.setText("skin");

                }
                else if(c5.isChecked()==false) {
                    stemm.setText("");

                }
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // StringBuffer buffer=new StringBuffer();
                if(c6.isChecked()){
                    //buffer.append("bones");
                    stemm.setText("bones");

                }
                else if(c6.isChecked()==false) {
                    stemm.setText("");

                }
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=un.getText().toString();

                pwd=pass.getText().toString();
                mailID=mail.getText().toString();
                ph=phno.getText().toString();
                address=addr.getText().toString();
                adhrID=adhar.getText().toString();
                ste=stemm.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(un.getText().toString().contentEquals("") && pass.getText().toString().contentEquals("") && mail.getText().toString().contentEquals("") && phno.getText().toString().contentEquals("") &&
                        addr.getText().toString().contentEquals("") && adhar.getText().toString().contentEquals("") ){
                    Toast.makeText(StemRegister.this,
                            "Enter Details first", Toast.LENGTH_LONG)
                            .show();
                }
                else if(un.getText().toString().contentEquals("")){
                    Toast.makeText(StemRegister.this,
                            "Enter Username", Toast.LENGTH_LONG)
                            .show();
                }
                else if(pass.getText().toString().contentEquals("")){
                    Toast.makeText(StemRegister.this,
                            "Enter Password", Toast.LENGTH_LONG)
                            .show();
                }
                else if(mail.getText().toString().contentEquals("")){
                    Toast.makeText(StemRegister.this,
                            "Enter MailID", Toast.LENGTH_LONG)
                            .show();
                }
                else if (!(mail.getText().toString()).matches(emailPattern) )
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();

                }
                else if(phno.getText().toString().contentEquals("")){
                    Toast.makeText(StemRegister.this,
                            "Enter Phone Number", Toast.LENGTH_LONG)
                            .show();
                }
                else if(addr.getText().toString().contentEquals("")){
                    Toast.makeText(StemRegister.this,
                            "Enter Address", Toast.LENGTH_LONG)
                            .show();
                }

                else if(adhar.getText().toString().contentEquals("")){
                    Toast.makeText(StemRegister.this,
                            "Enter Pincode", Toast.LENGTH_LONG)
                            .show();
                }

                else {
                    dbh = new DatabaseHelper(StemRegister.this);
                    dbh.open();


                    Random r = new Random();
                    int otp = r.nextInt(9000 - 1000) + 1000;
                    otp_res = String.valueOf(otp);
                    // Toast.makeText(Register.this, "OTP" + otp_res, Toast.LENGTH_LONG) .show();


                    Toast.makeText(StemRegister.this,
                            "Registeration finished", Toast.LENGTH_LONG)
                            .show();

                    dbh.RegisterStem(user,pwd,mailID,ph,address,adhrID,ste,"Not Donate");
                    Toast.makeText(StemRegister.this,
                            "Congrats: Register Successfull", Toast.LENGTH_LONG)
                            .show();

                    dbh.close();
                    Intent i=new Intent(StemRegister.this, BloodDonorLogin.class);
                    startActivity(i);
                    finish();
                }










            }
        });
    }
}
