/**
 * 
 */
package com.salomaa.greminder.providers;

import java.util.Map;

/**
 * @author Miikkajs
 *
 */
public class PersistentMemoryDataProvider implements DataProvider {

	/* (non-Javadoc)
	 * @see com.salomaa.greminder.providers.DataProvider#sendData(java.util.Map)
	 */
	@Override
	public void sendData(Map<String, Object> data) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.salomaa.greminder.providers.DataProvider#getData()
	 */
	@Override
	public Map<String, Object> getData() throws NullPointerException{
		// TODO Auto-generated method stub
		throw new NullPointerException();
	}

}
