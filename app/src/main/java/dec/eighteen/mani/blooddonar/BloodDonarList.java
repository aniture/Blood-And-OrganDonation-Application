package dec.eighteen.mani.blooddonar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class BloodDonarList extends AppCompatActivity {
    ListView listView;
    DatabaseHelper dbh;
    String sid;
    public final static String NAME1="Name1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_donar_list);
        listView=findViewById(R.id.list_view);
        dbh=new DatabaseHelper(this);
        dbh.open();


        List<String> data=dbh.getDetails();

        ArrayAdapter<String> ad= new ArrayAdapter<>(this,R.layout.list,data);
        listView.setAdapter(ad);



        dbh.close();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                String item=arg0.getItemAtPosition(arg2).toString();//whole item in the position

                String[] res=item.split("\n");
                String[] id1=res[0].split(":");
                String[] id2=res[2].split(":");
                String[] id3=res[5].split(":");
                Intent i = new Intent(BloodDonarList.this, ConfirmBlood.class);
                i.putExtra("name", id1[1]);
                i.putExtra("phno", id2[1]);
                i.putExtra("blood", id3[1]);
                startActivity(i);

                finish();





            }
        });
    }
}
