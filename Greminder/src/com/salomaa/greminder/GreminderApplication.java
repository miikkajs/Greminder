/**
 * 
 */
package com.salomaa.greminder;

import android.app.Application;

/**
 * @author Miikkajs
 * 
 */
public class GreminderApplication extends Application {
	private static Application singleton;
	
 	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
	}
	
	public static Application getInstance(){
		return singleton;
	}
}
