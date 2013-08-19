/**
 * 
 */
package com.salomaa.greminder.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salomaa.greminder.views.LayoutBuilder;
import com.salomaa.greminder.views.NewReminderLayoutBuilder;

/**
 * @author Miikkajs
 * 
 */
public class NewReminderFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LayoutBuilder layoutBuilder = new NewReminderLayoutBuilder(getActivity());
		return layoutBuilder.createLayout(new ArrayList<Map<String,Object>>());
//		return inflater.inflate(R.layout.layout_newreminderfragment, container,false);
	}
}
