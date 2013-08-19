/**
 * 
 */
package com.salomaa.greminder.providers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * @author Miikkajs
 * 
 */
public class IssueReportingApiDataProvider implements DataProvider {
	private final static String REQUEST_URL = "https://pate.affecto.com/restWAR/open311/v1/requests.json?";
	private Map<String, Object> requestParemeters = new HashMap<String, Object>();

	public IssueReportingApiDataProvider() {
		requestParemeters.put("start_date", "2010-05-24T00:00:00Z");
		requestParemeters.put("end_date", "2013-06-24T00:00:00Z");
		requestParemeters.put("status", "open");
	}

	private String buildRequest() {
		StringBuilder builder = new StringBuilder();
		builder.append(REQUEST_URL);
		Iterator<String> iterator = requestParemeters.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = requestParemeters.get(key).toString();
			try {
				builder.append(URLEncoder.encode(key, "UTF-8")).append("=")
						.append(URLEncoder.encode(value, "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String request;
		request = builder.toString();

		return request;
	}

	@Override
	public void sendData(List<Map<String, Object>> data) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String, Object>> getData() throws NullPointerException {
		HttpURLConnection urlConnection = null;
		InputStream in = null;
		List<Map<String, Object>> data = null;
		try {
			URL url = new URL(buildRequest());
			urlConnection = (HttpURLConnection) url.openConnection();

			in = new BufferedInputStream(urlConnection.getInputStream());

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(in));
			String dataString;
			StringBuilder builder = new StringBuilder();
			while ((dataString = bufferedReader.readLine()) != null) {
				Log.d("getData", "Data: " + dataString);
				builder.append(dataString);
			}
			data = parseData(builder.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			urlConnection.disconnect();
		}
		return data;
	}

	private List<Map<String, Object>> parseData(String data) {
		JSONArray jsonArray = null;
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		try {
			jsonArray = new JSONArray(data);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < jsonArray.length(); i++) {
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				try {
					dataMap.put("description", jsonObject.get("description"));
					dataMap.put("lat", jsonObject.get("lat"));
					dataMap.put("lon", jsonObject.get("long"));
					dataList.add(dataMap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dataList;
	}

}
