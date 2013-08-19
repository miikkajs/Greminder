/**
 * 
 */
package com.salomaa.greminder.providers;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Miikkajs
 * 
 */ 
public interface DataProvider {
	public void sendData(List<Map<String, Object>> data);
	public List<Map<String, Object>> getData() throws NullPointerException;
}
