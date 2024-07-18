package dec.eighteen.mani.blooddonar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    Button login;
    public final static String DEPT="depart";
    EditText un,pd;
    String cur_dat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        login=(Button)findViewById(R.id.login);
        un=(EditText)findViewById(R.id.un_ad);
        pd=(EditText)findViewById(R.id.pd_ad);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=un.getText().toString();
                String pass=pd.getText().toString();
                if(user.contentEquals("admin") && pass.contentEquals("admin")){
                    String s="1";
                    Intent ii = new Intent(AdminLogin.this,AdminDash.class);

                    startActivity(ii);
                    finish();
                    Toast.makeText(getApplicationContext(), "Success : login",
                            Toast.LENGTH_LONG).show();


                }
                else{
                    Toast.makeText(getApplicationContext(), "Not Match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
