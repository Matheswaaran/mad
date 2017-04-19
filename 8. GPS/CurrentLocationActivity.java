import java.io.IOException;
import java.util.List; 
import java.util.Locale;
import android.app.Activity; 
import android.content.Context; 
import android.location.Address; 
import android.location.Geocoder; 
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
public class CurrentLocationActivity extends Activity {
	/** Called when the activity is first created. */ Private TextView
	super.onCreate(savedInstanceState); setContentView(R.layout.main);
	gpsLocationView=(TextView) findViewById(R.id.gps_text);
	/* Use the LocationManager class to obtain GPS locations */
	LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	LocationListener mlocListener = new MyLocationListener();
	mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
}
/* Class My Location Listener */
public class MyLocationListener implements LocationListener {
	@Override
	public void onLocationChanged(Location loc) {
		loc.getLatitude();
		loc.getLongitude();
		Geocoder gcd = new Geocoder(getApplicationContext(),
		Locale.getDefault());
		Try
		{
		addresses = gcd.getFromLocation(loc.getLatitude(),loc.getLongitude(), 1);
		}
		catch (IOException e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		String text=(addresses!=null)?"City : "+addresses.get(0).getSubLocality()+"\n Country
		: "+addresses.get(0).getCountryName():"Unknown Location";
		String locationValue = "My current location is: "+
		text; gpsLocationView.setText(locationValue);
	}
	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(getApplicationContext(),"Gps Disabled",Toast.LENGTH_SHORT ).show();
	}
	@Override
	public void onProviderEnabled(String provider)
	{
		Toast.makeText(getApplicationContext(),"Gps Enabled",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras)
	{
	}
}