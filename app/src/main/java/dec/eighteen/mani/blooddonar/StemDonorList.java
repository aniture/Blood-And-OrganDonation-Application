package dec.eighteen.mani.blooddonar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class StemDonorList extends AppCompatActivity {
    public final static String NAME2="stemName";
    ListView listView;
    DatabaseHelper dbh;
    String sid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stem_donor_list);
       /* SharedPreferences sp=getSharedPreferences(NAME2,0);
        sid=sp.getString("key_stem","");*/
        listView=findViewById(R.id.list_view);
        dbh=new DatabaseHelper(this);
        dbh.open();


        List<String> data=dbh.getDetails2();

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
                Intent i = new Intent(StemDonorList.this, ConfirmStem.class);
                i.putExtra("name", id1[1]);
                i.putExtra("phno", id2[1]);
                i.putExtra("stem", id3[1]);
                startActivity(i);

                finish();





            }
        });
    }
}
