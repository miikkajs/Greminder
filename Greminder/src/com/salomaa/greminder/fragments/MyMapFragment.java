/**
 * 
 */
package com.salomaa.greminder.fragments;

import java.io.IOException;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.salomaa.greminder.map.MapState;
import com.salomaa.greminder.utils.FileManager;

/**
 * @author Miikkajs
 * 
 */
public class MyMapFragment extends SupportMapFragment {
	private GoogleMap mMapView;
	public static final String MAP_STATE_FILE_NAME = "mapState.bin";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onResume() {
		super.onResume();
		mMapView = getMap();
		mMapView.setMyLocationEnabled(true);
		restoreMapState();
	}

	@Override
	public void onDestroy() {
		saveMapState();

		super.onDestroy();
	}

	private void restoreMapState() {
		MapState mapState = null;
		try {
			mapState = (MapState) FileManager.readFile(MAP_STATE_FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (mapState != null) {
			mMapView.animateCamera(CameraUpdateFactory.newLatLngZoom(
					new LatLng(mapState.getLatitude(), mapState.getLongitude()),
					mapState.getZoom()));
		}
		mMapView.addMarker(new MarkerOptions().title("Test").position(
				new LatLng(60.173324, 24.941025)));
	}

	private void saveMapState() {
		double latitude = mMapView.getCameraPosition().target.latitude;
		double longitude = mMapView.getCameraPosition().target.longitude;
		float zoom = mMapView.getCameraPosition().zoom;
		MapState mapState = new MapState();
		mapState.setLatitude(latitude);
		mapState.setLongitude(longitude);
		mapState.setZoom(zoom);
		try {
			FileManager.writeToFile(mapState, MAP_STATE_FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
