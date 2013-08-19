/**
 * 
 */
package com.salomaa.greminder.fragments;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salomaa.greminder.providers.DataProvider;
import com.salomaa.greminder.providers.PersistentMemoryDataProvider;
import com.salomaa.greminder.views.DetailViewLayoutBuilder;
import com.salomaa.greminder.views.LayoutBuilder;

/**
 * @author Miikkajs
 * 
 */
public class DetailFragment extends Fragment {
	private Map<String, Object> data = new HashMap<String, Object>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DataProvider dataProvider = new PersistentMemoryDataProvider();
		try {
			data = dataProvider.getData();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LayoutBuilder layoutBuilder = new DetailViewLayoutBuilder(getActivity());
		if (data != null) {

		}
		View layout = layoutBuilder.createLayout(data);

		return layout;
	}
}
