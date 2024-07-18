package dec.eighteen.mani.blooddonar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class StemList extends AppCompatActivity {
    ListView listView;
    DatabaseHelper dbh;
    String sid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stem_list);

        listView=findViewById(R.id.list_view);
        dbh=new DatabaseHelper(this);
        dbh.open();


        List<String> data=dbh.getDetails2();

        ArrayAdapter<String> ad= new ArrayAdapter<>(this,R.layout.list,data);
        listView.setAdapter(ad);



        dbh.close();
    }
}
