package com.jfbd.smartWar;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import android.Location.LocationManager;
import android.app.Activity;
import android.os.Bundle;

public class SmartWarActivity extends MapActivity {
	
	
	 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
   
        // Get a reference to the MapView
        MapView myMapView = (MapView)findViewById(R.id.map_view);
        // Get the Map View’s controller
        MapController mapController = myMapView.getController();
        // Configure the map display options
        myMapView.setSatellite(true);
        myMapView.setStreetView(true);
        myMapView.displayZoomControls(false);
        // Zoom in
        mapController.setZoom(17);
        LocationManager locationManager;
        LocationProvider locationProvider = LocationManager.NETWORK_PROVIDER;
        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager)getSystemService(context);
        Criteria criteria = new Criteria();

        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        updateWithNewLocation(location);
        locationManager.requestLocationUpdates(provider, 2000, 10,
        locationListener);

    }

	@Override
	protected boolean isRouteDisplayed() {
	
		return false;
	}
}