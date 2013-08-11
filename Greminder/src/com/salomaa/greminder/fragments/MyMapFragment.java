/**
 * 
 */
package com.salomaa.greminder.fragments;

import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * @author Miikkajs
 * 
 */
public class MyMapFragment extends SupportMapFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		GoogleMap mapView = getMap();
		mapView.setMyLocationEnabled(true);
	}

}
