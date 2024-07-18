package dec.eighteen.mani.blooddonar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper {
	public static final String KEY_ID = "Id";
	public static final String KEY_FIRST = "Name";
	public static final String KEY_SECOND = "Password";
	public static final String KEY_THIRD = "mailID";
	public static final String KEY_FOURTH = "PhNumber";
	public static final String KEY_FIFTH = "Address";
	public static final String KEY_SIXTH = "Pincode";
    public static final String KEY_SEVENTH = "Bloodgroup";
    public static final String KEY_EIGHT = "BStatus";

    public static final String one = "SName";
    public static final String two = "SPassword";
    public static final String three = "SMailID";
    public static final String four = "PHNumber";
    public static final String five = "SAddress";
    public static final String six = "SPincode";
	public static final String seven = "StemCelll";
	public static final String eight = "SStatus";

	public static final String k1 = "OName";
	public static final String k2 = "OPassword";
	public static final String k3 = "mailID";
	public static final String k4 = "PhNumber";
	public static final String k5 = "Address";
	public static final String k6 = "Pincode";
    public static final String k7 = "OrganName";
	public static final String k8 = "SOrgan";


    public static final String KEY_FIRST1 = "BBName";
    public static final String KEY_SECOND1 = "BPHNO";
    public static final String KEY_THIRD1 = "UUName";
    public static final String KEY_FOURTH1 = "UPhNumber";
    public static final String KEY_FIFTH1 = "UDesc";
    public static final String KEY_SIXTH1 = "UStatus";

	public static final String k11 = "OOName";
	public static final String k21 = "OOPH";
	public static final String k31 = "OUName";
	public static final String k41 = "OPhNumber";
	public static final String k51 = "ODesc";
	public static final String k61 = "Ostat";


    public static final String one1 = "SSName";
    public static final String two1 = "SPH";
    public static final String three1 = "SUName";
    public static final String four1 = "SPHno";
    public static final String five1 = "SDesc";
    public static final String six1 = "SStat";

	public static final String nine = "comment";
	private static final String DATABASE_NAME = "REDD";

	private static final String DATABASE_TABLE1 = "UserRegister";
	private static final String DATABASE_TABLE2 = "StemReg";
	private static final String DATABASE_TABLE3 = "DonorReg";


    private static final String DATABASE_TABLE4 = "BloodReq";
    private static final String DATABASE_TABLE5 = "OrganReq";
    private static final String DATABASE_TABLE6 = "StemReq";
	private static final int DATABASE_VERSION = 5;
	private DbHelper dbh;
	private final Context context;
	private static SQLiteDatabase ourdatabase;
	
	private static final String DATABASE_CREATE1 ="create table "+DATABASE_TABLE1+"("
			+ KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ KEY_FIRST+" TEXT NOT NULL, "+KEY_SECOND+" TEXT NOT NULL, "
			+KEY_THIRD+" TEXT NOT NULL, "
			+KEY_FOURTH+" TEXT NOT NULL, "+KEY_FIFTH+" TEXT NOT NULL, "+KEY_SIXTH+" TEXT NOT NULL,"+KEY_SEVENTH+" TEXT NOT NULL,"+KEY_EIGHT+" TEXT NOT NULL);";



	private static final String DATABASE_CREATE2 ="create table "+DATABASE_TABLE2+"("
			+ one+" TEXT NOT NULL,"
			+ two+" TEXT NOT NULL,"
			+ three+" TEXT NOT NULL,"
			+ four+" TEXT NOT NULL,"
			+ five+" TEXT NOT NULL,"
            + six+" TEXT NOT NULL,"
            + seven+" TEXT NOT NULL,"
                        + eight+" TEXT NOT NULL);";
	private static final String DATABASE_CREATE3 ="create table "+DATABASE_TABLE3+"("
			+ k1+" TEXT NOT NULL,"
			+ k2+" TEXT NOT NULL,"
			+ k3+" TEXT NOT NULL,"
			+ k4+" TEXT NOT NULL,"
			+ k5+" TEXT NOT NULL,"
            + k6+" TEXT NOT NULL,"
			+ k7+" TEXT NOT NULL,"
			+ k8+" TEXT NOT NULL);";

    private static final String DATABASE_CREATE4 ="create table "+DATABASE_TABLE4+"("
            + KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_FIRST1+" TEXT NOT NULL, "+KEY_SECOND1+" TEXT NOT NULL, "
            +KEY_THIRD1+" TEXT NOT NULL, "
            +KEY_FOURTH1+" TEXT NOT NULL, "+KEY_FIFTH1+" TEXT NOT NULL, "+KEY_SIXTH1+" TEXT NOT NULL);";

	private static final String DATABASE_CREATE5 ="create table "+DATABASE_TABLE5+"("
			+ k11+" TEXT NOT NULL,"
			+ k21+" TEXT NOT NULL,"
			+ k31+" TEXT NOT NULL,"
			+ k41+" TEXT NOT NULL,"
			+ k51+" TEXT NOT NULL,"
			+ k61+" TEXT NOT NULL);";







    private static final String DATABASE_CREATE6 ="create table "+DATABASE_TABLE6+"("
            + one1+" TEXT NOT NULL,"
            + two1+" TEXT NOT NULL,"
            + three1+" TEXT NOT NULL,"
            + four1+" TEXT NOT NULL,"
            + five1+" TEXT NOT NULL,"
            + six1+" TEXT NOT NULL);";

    public DatabaseHelper(Context c){
		this.context=c;
	}
	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null,DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		

		@Override
		public void onCreate(SQLiteDatabase arg0) {
			// TODO Auto-generated method stub
			
			arg0.execSQL(DATABASE_CREATE1);
			arg0.execSQL(DATABASE_CREATE2);
			arg0.execSQL(DATABASE_CREATE3);
            arg0.execSQL(DATABASE_CREATE4);
			arg0.execSQL(DATABASE_CREATE5);
            arg0.execSQL(DATABASE_CREATE6);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			arg0.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE1);
			onCreate(arg0);
		}
		
	}
	
	public DatabaseHelper open(){
		dbh=new DbHelper(context);
		ourdatabase=dbh.getWritableDatabase();
		return this;
	}
	public void close(){
		dbh.close();
	}
	
	public long Register(String name, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_FIRST, name);
		initialValues.put(KEY_SECOND, s2);
		initialValues.put(KEY_THIRD, s3);
		initialValues.put(KEY_FOURTH, s4);
		initialValues.put(KEY_FIFTH, s5);
		initialValues.put(KEY_SIXTH, s6);
        initialValues.put(KEY_SEVENTH, s7);
        initialValues.put(KEY_EIGHT, s8);

		return ourdatabase.insert(DATABASE_TABLE1, null, initialValues);
	}
	public long RegisterOrgan(String name, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		initialValues.put(k1, name);
		initialValues.put(k2, s2);
		initialValues.put(k3, s3);
		initialValues.put(k4, s4);
		initialValues.put(k5, s5);
		initialValues.put(k6, s6);
        initialValues.put(k7, s7);
		initialValues.put(k8, s8);
		return ourdatabase.insert(DATABASE_TABLE3, null, initialValues);
	}
	public long RegisterStem(String name, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		initialValues.put(one, name);
		initialValues.put(two, s2);
		initialValues.put(three, s3);
		initialValues.put(four, s4);
		initialValues.put(five, s5);
		initialValues.put(six, s6);
        initialValues.put(seven, s7);
        initialValues.put(eight, s8);
		return ourdatabase.insert(DATABASE_TABLE2, null, initialValues);
	}



    public long BloodReq(String name, String s2, String s3, String s4, String s5, String s6) {
        // TODO Auto-generated method stub
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_FIRST1, name);
        initialValues.put(KEY_SECOND1, s2);
        initialValues.put(KEY_THIRD1, s3);
        initialValues.put(KEY_FOURTH1, s4);
        initialValues.put(KEY_FIFTH1, s5);
        initialValues.put(KEY_SIXTH1, s6);


        return ourdatabase.insert(DATABASE_TABLE4, null, initialValues);
    }
	public long OrganReq(String name, String s2, String s3, String s4, String s5, String s6) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		initialValues.put(k11, name);
		initialValues.put(k21, s2);
		initialValues.put(k31, s3);
		initialValues.put(k41, s4);
		initialValues.put(k51, s5);
		initialValues.put(k61, s6);


		return ourdatabase.insert(DATABASE_TABLE5, null, initialValues);
	}

    public long StemReq(String name, String s2, String s3, String s4, String s5, String s6) {
        // TODO Auto-generated method stub
        ContentValues initialValues = new ContentValues();
        initialValues.put(one1, name);
        initialValues.put(two1, s2);
        initialValues.put(three1, s3);
        initialValues.put(four1, s4);
        initialValues.put(five1, s5);
        initialValues.put(six1, s6);


        return ourdatabase.insert(DATABASE_TABLE6, null, initialValues);
    }
	public long RegisterDriver(String name, String s2, String s3) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		initialValues.put(one, name);
		initialValues.put(two, s2);
		initialValues.put(three, s3);

		return ourdatabase.insert(DATABASE_TABLE2, null, initialValues);
	}

	public Cursor getAllContacts1()
	{
		return ourdatabase.query(DATABASE_TABLE1, new String[] {KEY_FOURTH},null,null, null, null, null, null);
	}

	public long Confirm(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		initialValues.put(k1, s1);
		initialValues.put(k2, s2);
		initialValues.put(k3, s3);
		initialValues.put(k4, s4);
		initialValues.put(k5, s5);
		initialValues.put(k6, s6);
		initialValues.put(k7, s7);
		initialValues.put(k8, s8);

		return ourdatabase.insert(DATABASE_TABLE3, null, initialValues);
	}
    public long Complaints(String name, String s2, String s3, String s4, String s5, String s6, String s7) {
        // TODO Auto-generated method stub
        ContentValues initialValues = new ContentValues();
        initialValues.put(one, name);
        initialValues.put(two, s2);

        initialValues.put(three, s3);
        initialValues.put(four, s4);
		initialValues.put(five, s5);
		initialValues.put(six, s6);
		initialValues.put(seven, s7);

        return ourdatabase.insert(DATABASE_TABLE2, null, initialValues);
    }

    public ArrayList<String> getDetails() {

        String[] colname=new String[]{KEY_FIRST,KEY_THIRD,KEY_FOURTH,KEY_FIFTH,KEY_SIXTH,KEY_SEVENTH,KEY_EIGHT};
       // String[] s=new String[]{dept};
        Cursor c=ourdatabase.query(DATABASE_TABLE1, colname,null,null, null,null,null,null);
        ArrayList<String> arr=new ArrayList<String>();

        int date=c.getColumnIndex(KEY_FIRST);
        int detail=c.getColumnIndex(KEY_THIRD);
        int pdate=c.getColumnIndex(KEY_FOURTH);
        int area=c.getColumnIndex(KEY_FIFTH);
		int loc=c.getColumnIndex(KEY_SIXTH);
        int loc1=c.getColumnIndex(KEY_SEVENTH);
        int loc2=c.getColumnIndex(KEY_EIGHT);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            arr.add("Name						:"+c.getString(date)+"\n"+
                    "Mail ID						:"+c.getString(detail)+"\n"+
                    "Phone No					:"+c.getString(pdate)+"\n"+
                    "Address					:"+c.getString(area)+"\n"+
					"PinCode					:"+c.getString(loc)+"\n"+
                    "Bloodgroup				:"+c.getString(loc1)+"\n"+
                    "Status				    :"+c.getString(loc2)
					);
        }
        return arr;
    }
    public ArrayList<String> getDetailReq(String s) {

        String[] colname=new String[]{KEY_FIRST1,KEY_SECOND1,KEY_THIRD1,KEY_FOURTH1,KEY_FIFTH1,KEY_SIXTH1};
        // String[] s=new String[]{dept};
        Cursor c=ourdatabase.query(DATABASE_TABLE4, colname,KEY_FIRST1+ "=?",new String[]{s}, null,null,null,null);
        ArrayList<String> arr=new ArrayList<String>();

        int date=c.getColumnIndex(KEY_FIRST1);
        int loc1=c.getColumnIndex(KEY_SECOND1);
        int detail=c.getColumnIndex(KEY_THIRD1);
        int pdate=c.getColumnIndex(KEY_FOURTH1);
        int area=c.getColumnIndex(KEY_FIFTH1);
        int loc=c.getColumnIndex(KEY_SIXTH1);


        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            arr.add("Name						:"+c.getString(date)+"\n"+
                    "Phone No						:"+c.getString(loc1)+"\n"+
                    "User Name					:"+c.getString(detail)+"\n"+
                    "Phone Number					:"+c.getString(pdate)+"\n"+
                    "Description					:"+c.getString(area)+"\n"+
                    "Status				:"+c.getString(loc)

            );
        }
        return arr;
    }
    public ArrayList<String> getDetailStem(String s) {

        String[] colname=new String[]{one1,two1,three1,four1,five1,six1};
        // String[] s=new String[]{dept};
        Cursor c=ourdatabase.query(DATABASE_TABLE6, colname,one1+ "=?",new String[]{s}, null,null,null,null);
        ArrayList<String> arr=new ArrayList<String>();

        int date=c.getColumnIndex(one1);
        int loc1=c.getColumnIndex(two1);
        int detail=c.getColumnIndex(three1);
        int pdate=c.getColumnIndex(four1);
        int area=c.getColumnIndex(five1);
        int loc=c.getColumnIndex(six1);


        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            arr.add("Name						:"+c.getString(date)+"\n"+
                    "Phone No						:"+c.getString(loc1)+"\n"+
                    "User Name					:"+c.getString(detail)+"\n"+
                    "Phone Number					:"+c.getString(pdate)+"\n"+
                    "Description					:"+c.getString(area)+"\n"+
                    "Status				:"+c.getString(loc)

            );
        }
        return arr;
    }
    public ArrayList<String> getDetailOrgan(String s) {

        String[] colname=new String[]{k11,k21,k31,k41,k51,k61};
        // String[] s=new String[]{dept};
        Cursor c=ourdatabase.query(DATABASE_TABLE5, colname,k11+ "=?",new String[]{s}, null,null,null,null);
        ArrayList<String> arr=new ArrayList<String>();

        int date=c.getColumnIndex(k11);
        int loc1=c.getColumnIndex(k21);
        int detail=c.getColumnIndex(k31);
        int pdate=c.getColumnIndex(k41);
        int area=c.getColumnIndex(k51);
        int loc=c.getColumnIndex(k61);


        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            arr.add("Name						:"+c.getString(date)+"\n"+
                    "Phone No						:"+c.getString(loc1)+"\n"+
                    "User Name					:"+c.getString(detail)+"\n"+
                    "Phone Number					:"+c.getString(pdate)+"\n"+
                    "Description					:"+c.getString(area)+"\n"+
                    "Status				:"+c.getString(loc)

            );
        }
        return arr;
    }


	public ArrayList<String> getBooked() {

		String[] colname=new String[]{k1,k2,k3,k4,k5,k6,k8};
		// String[] s=new String[]{dept};
		Cursor c=ourdatabase.query(DATABASE_TABLE3, colname,null,null, null,null,null,null);
		ArrayList<String> arr=new ArrayList<String>();

		int date=c.getColumnIndex(k1);
		int detail=c.getColumnIndex(k2);
		int pdate=c.getColumnIndex(k3);
		int area=c.getColumnIndex(k4);
		int loc=c.getColumnIndex(k5);
		int loc1=c.getColumnIndex(k6);
		int loc2=c.getColumnIndex(k8);

		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			arr.add("UserName							   :"+c.getString(date)+"\n"+
					"Truck ID						   :"+c.getString(detail)+"\n"+
					"Source				:"+c.getString(pdate)+"\n"+
					"Destination					:"+c.getString(area)+"\n"+
					"Days					:"+c.getString(loc)+"\n"+
					"Price					:"+c.getString(loc1)+"\n"+
					"BookingDate					:"+c.getString(loc2)+"\n"
			);
		}
		return arr;
	}



	public ArrayList<String> getBookedUser(String s) {

		String[] colname=new String[]{k1,k2,k3,k4,k5,k6,k8};
		// String[] s=new String[]{dept};
		Cursor c=ourdatabase.query(DATABASE_TABLE3, colname, k1+ "=?",new String[]{s}, null,null,null,null);
		ArrayList<String> arr=new ArrayList<String>();

		int date=c.getColumnIndex(k1);
		int detail=c.getColumnIndex(k2);
		int pdate=c.getColumnIndex(k3);
		int area=c.getColumnIndex(k4);
		int loc=c.getColumnIndex(k5);
		int loc1=c.getColumnIndex(k6);
		int loc2=c.getColumnIndex(k8);

		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			arr.add("UserName							   :"+c.getString(date)+"\n"+
					"Truck ID						   :"+c.getString(detail)+"\n"+
					"Source				:"+c.getString(pdate)+"\n"+
					"Destination					:"+c.getString(area)+"\n"+
					"Days					:"+c.getString(loc)+"\n"+
					"Price					:"+c.getString(loc1)+"\n"+
					"BookingDate					:"+c.getString(loc2)+"\n"
			);
		}
		return arr;
	}


	public ArrayList<String> getDetailsTruck(String stat) {

		String[] colname=new String[]{one,two,three,four,six,seven};
		// String[] s=new String[]{dept};
		Cursor c=ourdatabase.query(DATABASE_TABLE2, colname, five+ "=?",new String[]{stat}, null,null,null,null);
		ArrayList<String> arr=new ArrayList<String>();
		int date=c.getColumnIndex(one);
		int detail=c.getColumnIndex(two);
		int pdate=c.getColumnIndex(three);
		int area=c.getColumnIndex(four);
		int area1=c.getColumnIndex(six);
		int area2=c.getColumnIndex(seven);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			arr.add("Vehicle Name						:"+c.getString(area1)+"\n"+
					"Vehicle Typ							:"+c.getString(area2)+"\n"+
					"Truck ID							   	:"+c.getString(date)+"\n"+
					"Source						   			:"+c.getString(detail)+"\n"+
					"Destination							:"+c.getString(pdate)+"\n"+
					"Cost(per day)						:"+c.getString(area)+"\n"


			);
		}
		return arr;
	}
	public ArrayList<String> getDetails1() {

		String[] colname=new String[]{k1,k3,k4,k5,k6,k7,k8};
		// String[] s=new String[]{dept};
		Cursor c=ourdatabase.query(DATABASE_TABLE3, colname,null,null, null,null,null,null);
		ArrayList<String> arr=new ArrayList<String>();

		int date=c.getColumnIndex(k1);
		int detail=c.getColumnIndex(k3);
		int pdate=c.getColumnIndex(k4);
		int area=c.getColumnIndex(k5);
		int loc=c.getColumnIndex(k6);
        int loc1=c.getColumnIndex(k7);
        int loc3=c.getColumnIndex(k8);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			arr.add("Name						:"+c.getString(date)+"\n"+
					"Mail ID						:"+c.getString(detail)+"\n"+
					"Phone No					:"+c.getString(pdate)+"\n"+
					"Address					:"+c.getString(area)+"\n"+
					"PinCode					:"+c.getString(loc)+"\n"+
                    "Organ List					:"+c.getString(loc1)+"\n"+
                    "Status				:"+c.getString(loc3)
			);
		}
		return arr;
	}


    public ArrayList<String> getDetails2() {

        String[] colname=new String[]{one,two,three,four,five,six,seven,eight};
        // String[] s=new String[]{dept};
        Cursor c=ourdatabase.query(DATABASE_TABLE2, colname,null,null, null,null,null,null);
        ArrayList<String> arr=new ArrayList<String>();

        int date=c.getColumnIndex(one);
        int detail=c.getColumnIndex(three);
        int pdate=c.getColumnIndex(four);
        int area=c.getColumnIndex(five);
        int loc=c.getColumnIndex(six);
        int loc1=c.getColumnIndex(seven);
        int loc2=c.getColumnIndex(eight);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            arr.add("Name						:"+c.getString(date)+"\n"+
                    "Mail ID						:"+c.getString(detail)+"\n"+
                    "Phone No					:"+c.getString(pdate)+"\n"+
                    "Address					:"+c.getString(area)+"\n"+
                    "PinCode					:"+c.getString(loc)+"\n"+
                    "Stem List					:"+c.getString(loc1)+"\n"+
                    "Status					:"+c.getString(loc2)

            );
        }
        return arr;
    }

	public String retrievepass(String name){
		String pass="";
		String[] colname=new String[]{KEY_SECOND};
		String[] s=new String[]{name};
		Cursor c = ourdatabase.query(DATABASE_TABLE1, colname, KEY_FIRST + "=?",s, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			pass=c.getString(0);			
		}
		return pass;
		
	}
    public String retrievephno1(String name){
        String pass="";
        String[] colname=new String[]{KEY_FOURTH1};
        String[] s=new String[]{name};
        Cursor c = ourdatabase.query(DATABASE_TABLE4, colname, KEY_FIRST1 + "=?",s, null, null, null, null);
        if(c!=null){
            c.moveToFirst();
            pass=c.getString(0);
        }
        return pass;

    }
    public String retrievepass1(String name){
        String pass="";
        String[] colname=new String[]{k2};
        String[] s=new String[]{name};
        Cursor c = ourdatabase.query(DATABASE_TABLE3, colname, k1 + "=?",s, null, null, null, null);
        if(c!=null){
            c.moveToFirst();
            pass=c.getString(0);
        }
        return pass;

    }
	public String retrievepass2(String name){
		String pass="";
		String[] colname=new String[]{two};
		String[] s=new String[]{name};
		Cursor c = ourdatabase.query(DATABASE_TABLE2, colname, one + "=?",s, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			pass=c.getString(0);
		}
		return pass;

	}

	public String retrievephno(String name){
		String pass="";
		String[] colname=new String[]{three};
		String[] s=new String[]{name};
		Cursor c = ourdatabase.query(DATABASE_TABLE2, colname, one + "=?",s, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			pass=c.getString(0);
		}
		return pass;

	}
	public void updateprod(String name, String qty) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_EIGHT, qty);

		String[] s = new String[] { name };
		ourdatabase.update(DATABASE_TABLE1, initialValues, KEY_FOURTH + " = ?", s);
	}
	public void updateprod1(String name, String qty) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		initialValues.put(k8, qty);

		String[] s = new String[] { name };
		ourdatabase.update(DATABASE_TABLE3, initialValues, k4 + " = ?", s);
	}

    public void updateprod2(String name, String qty) {
        // TODO Auto-generated method stub
        ContentValues initialValues = new ContentValues();
        initialValues.put(eight, qty);

        String[] s = new String[] { name };
        ourdatabase.update(DATABASE_TABLE2, initialValues, four + " = ?", s);
    }
	/*public void delete(String id) {
		String[] s=new String[]{id};
		ourdatabase.delete(DATABASE_TABLE1, KEY_ID+"=?", s);
	}
*/
	public void delete(String id) {
		String[] s=new String[]{id};
		ourdatabase.delete(DATABASE_TABLE2, one + " =?", s);
	}
}

