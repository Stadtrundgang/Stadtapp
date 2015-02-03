package com.example.stadtapp.tabs;

import com.example.stadtapp.MainActivity;
import com.example.stadtapp.R;
import com.example.stadtapp.R.id;
import com.example.stadtapp.R.layout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragmentTab extends Fragment {

private static View view;
/**
 * Note that this may be null if the Google Play services APK is not
 * available.
 */

private static GoogleMap mMap;
private static Double latitude, longitude;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    if (container == null) {
        return null;
    }
   // view = (RelativeLayout) inflater.inflate(R.layout.map_layout, container, false);
    view =  inflater.inflate(R.layout.map_layout, container, false);
    // Passing harcoded values for latitude & longitude. Please change as per your need. This is just used to drop a Marker on the Map   		
    		latitude = 26.78;
            longitude = 72.56;
            
            setUpMapIfNeeded(); // For setting up the MapFragment
            
            /*
            mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                @Override
                public void onMyLocationChange(Location location) {
                        CameraUpdate center=CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude()));
                        CameraUpdate zoom=CameraUpdateFactory.zoomTo(11);
                        mMap.moveCamera(center);
                        mMap.animateCamera(zoom);
                }
            });
            */
            
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng point) {
                    MarkerOptions marker = new MarkerOptions().position(
                            new LatLng(point.latitude, point.longitude)).title("New Marker");

                   mMap.addMarker(marker);
                System.out.println(point.latitude+"---"+ point.longitude);  
                }
            });
            
            
    return view;
}

/***** Sets up the map if it is possible to do so *****/
public static void setUpMapIfNeeded() {
    // Do a null check to confirm that we have not already instantiated the map.
    if (mMap == null) {
        // Try to obtain the map from the SupportMapFragment.
        mMap = ((MapFragment) MainActivity.fragmentManager.findFragmentById(R.id.location_map)).getMap();

        // Check if we were successful in obtaining the map.
        if (mMap != null)
            setUpMap();
    }
}

/**
 * This is where we can add markers or lines, add listeners or move the
 * camera.
 * <p>
 * This should only be called once and when we are sure that {@link #mMap}
 * is not null.
 */



private static void setUpMap() {
    // For showing a move to my loction button
    mMap.setMyLocationEnabled(true);
    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
	mMap.getUiSettings().setCompassEnabled(true); 
	mMap.getUiSettings().setMyLocationButtonEnabled(true); // For testing
    // For dropping a marker at a point on the Map
    //mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("My Home").snippet("Home Address"));
    // For zooming automatically to the Dropped PIN Location
    //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,
            //longitude), 12.0f));
	
  
}

@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    if (mMap != null)
        setUpMap();

    if (mMap == null) {
        // Try to obtain the map from the SupportMapFragment.
        mMap = ((MapFragment) MainActivity.fragmentManager
                .findFragmentById(R.id.location_map)).getMap(); // getMap is deprecated
        // Check if we were successful in obtaining the map.
        if (mMap != null)
            setUpMap();
    }
}

/**** The mapfragment's id must be removed from the FragmentManager
 **** or else if the same it is passed on the next time then 
 **** app will crash ****/
@Override
public void onDestroyView() {
    super.onDestroyView();
    if (mMap != null) {
        MainActivity.fragmentManager.beginTransaction()
            .remove(MainActivity.fragmentManager.findFragmentById(R.id.location_map)).commit();
        mMap = null;
    }
}
}