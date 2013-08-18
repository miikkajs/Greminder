/**
 * 
 */
package com.salomaa.greminder.providers;

import java.util.Map;

/**
 * 
 * @author Miikkajs
 * 
 */
public interface DataProvider {
	public void sendData(Map<String, Object> data);
	public Map<String, Object> getData() throws NullPointerException;
}
