/**
 * 
 */
package com.salomaa.greminder.map;

import java.io.Serializable;

/**
 * Class that can return map state.
 * implements Serializable
 * @author Miikkajs
 *
 */
public class MapState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -258761719618644433L;
	
	private double latitude;
	private double longitude;
    private float zoom;	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public float getZoom() {
		return zoom;
	}

	public void setZoom(float zoom) {
		this.zoom = zoom;
	}
	


}
