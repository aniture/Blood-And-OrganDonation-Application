package dec.eighteen.mani.blooddonar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    long delay=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Timer t=new Timer();
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                Intent i=new Intent(Splash.this,Category.class);
                startActivity(i);
                finish();
            }
        };
        t.schedule(tt,delay);


    }
}
