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

public class OrganDonorList extends AppCompatActivity {

    ListView listView;
    DatabaseHelper dbh;
    String sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organ_donor_list);
        listView=findViewById(R.id.list_view);
        dbh=new DatabaseHelper(this);
        dbh.open();


        List<String> data=dbh.getDetails1();

        ArrayAdapter<String> ad= new ArrayAdapter<>(this,R.layout.list,data);
        listView.setAdapter(ad);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                String item=arg0.getItemAtPosition(arg2).toString();//whole item in the position

                String[] res=item.split("\n");
                String[] id1=res[0].split(":");
                String[] id2=res[2].split(":");
                String[] id3=res[5].split(":");
                Intent i = new Intent(OrganDonorList.this, ConfirmOrgan.class);
                i.putExtra("name", id1[1]);
                i.putExtra("phno", id2[1]);
                i.putExtra("organ", id3[1]);
                startActivity(i);

                finish();





            }
        });
        dbh.close();
    }
}
