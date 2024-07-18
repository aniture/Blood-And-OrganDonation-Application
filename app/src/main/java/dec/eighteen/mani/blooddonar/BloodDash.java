package dec.eighteen.mani.blooddonar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BloodDash extends AppCompatActivity {
TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_dash);

        t2=findViewById(R.id.get);


        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(BloodDash.this,BloodGetAlert.class);
                startActivity(i);
            }
        });
    }
}
