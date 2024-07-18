package dec.eighteen.mani.blooddonar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class OrganGetAlert extends AppCompatActivity implements LocationListener{
    String s,locationn;
    ListView listView;
    DatabaseHelper dbh;
    LocationManager locationManager;
    public final static String NAME1="Name_Orgon";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organ_get_alert);
        SharedPreferences sp=getSharedPreferences(NAME1,0);
        s=sp.getString("key_orgon","");
        listView=findViewById(R.id.list_view);
        dbh=new DatabaseHelper(OrganGetAlert.this);
        dbh.open();
        List<String> data=dbh.getDetailOrgan(s);
        getLocation();
        ArrayAdapter<String> ad= new ArrayAdapter<>(this,R.layout.list,data);
        listView.setAdapter(ad);

        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                String item=arg0.getItemAtPosition(arg2).toString();//whole item in the position

                final String[] res=item.split("\n");
                final String[] id1=res[0].split(":");
                String[] id2=res[2].split(":");
                final String[] id3=res[3].split(":");

                AlertDialog.Builder builder = new AlertDialog.Builder(OrganGetAlert.this)
                        .setMessage("Are you sure to Share Location?")
                        .setPositiveButton("Share", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SmsManager smsManager = SmsManager.getDefault();
                                String message = "From user "+id1[1]+" Location  "+locationn;

                                smsManager.sendTextMessage(id3[1], null, message, null, null);
                                Toast.makeText(getApplicationContext(), "SMS sent.",
                                        Toast.LENGTH_LONG).show();
                                Toast.makeText(OrganGetAlert.this, "loc  "+locationn, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                builder.show();

               /* AlertDialog.Builder builder = new AlertDialog.Builder(BloodGetAlert.this);
                builder.setMessage(R.string.dialog_fire_missiles)
                        .setPositiveButton(R.string.share, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(BloodGetAlert.this,"hii",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                 builder.create();
                builder.show();*/


            }
        });
        dbh.close();
    }

    @Override
    public void onLocationChanged(Location location) {
        try {
            getLocation();
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
           /* loc.setText(addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));

*/

            locationn=addresses.get(0).getAddressLine(0);

            // address=addresses.get(0).getAddressLine(1);
            Toast.makeText(OrganGetAlert.this, locationn, Toast.LENGTH_SHORT).show();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);

        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

}
