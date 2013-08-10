/**
 * 
 */
package com.salomaa.greminder.fragments;

import com.salomaa.greminder.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Mii
 * 
 */
public class MapFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.layout_mapfragment, container, false);
	}
}
