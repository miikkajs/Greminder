package com.salomaa.greminder.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.salomaa.greminder.R;
import com.salomaa.greminder.fragments.DetailFragment;
import com.salomaa.greminder.fragments.MyMapFragment;
import com.salomaa.greminder.fragments.NewReminderFragment;

/**
 * @author Miikkajs
 * 
 */
public class MainActivity extends ActionBarActivity {
	private String[] mNavItems;
	private MyMapFragment mapFragment = new MyMapFragment();
	private NewReminderFragment newReminderFragment = new NewReminderFragment();
	private DetailFragment detailFragment = new DetailFragment();
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mNavItems = getResources().getStringArray(R.array.nav_menu_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		// Set the adapter for the list view
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.nav_drawer_layout, mNavItems));
		// Set the list's click listener
		mDrawerList.setOnItemClickListener(new NavMenuItemClickListener());

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.abc_action_bar_home_description,
				R.string.abc_action_mode_done);
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/**
	 * @author Miikkajs
	 * 
	 */
	private class NavMenuItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			Fragment fragment = null;
			if (mNavItems[arg2].equals(getString(R.string.new_reminder))) {
				fragment = newReminderFragment;
			} else if (mNavItems[arg2].equals(getString(R.string.map))) {
				fragment = mapFragment;
			} else if (mNavItems[arg2].equals(getString(R.string.details))) {
				fragment = detailFragment;
			}
			if (fragment != null) {
				if (!fragment.isInLayout()) {
					fragmentManager.beginTransaction()
							.replace(R.id.content_frame, fragment).commit();
				}
			}
		}

	}

}
