/**
 * 
 */
package com.salomaa.greminder.adapters;

import com.salomaa.greminder.GreminderApplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * @author Miikkajs
 * 
 */
public class NavDrawerListAdapter extends BaseAdapter {
	private Context mContext;
	private String[] mNavItems;

	public NavDrawerListAdapter(String[] navItems) {
		this.mContext = GreminderApplication.getInstance();
		this.mNavItems = navItems;
	}

	@Override
	public int getCount() {
		return mNavItems.length;
	}

	@Override
	public Object getItem(int position) {
		return mNavItems[position];
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		if (convertView == null) {
			Button button = new Button(mContext);
			button.setText(mNavItems[position]);
			return button;
		}
		return convertView;
	}

}
