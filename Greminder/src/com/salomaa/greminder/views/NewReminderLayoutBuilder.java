/**
 * 
 */
package com.salomaa.greminder.views;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @author Miikkajs
 * 
 */
public class NewReminderLayoutBuilder implements LayoutBuilder {
	private Context mContext;

	public NewReminderLayoutBuilder(Context context) {
		this.mContext = context;
	}

	@Override
	public View createLayout(List<Map<String, Object>> data) {
		WebView webView = new WebView(mContext);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/NewReminder.html");
		return webView;
	}

}
