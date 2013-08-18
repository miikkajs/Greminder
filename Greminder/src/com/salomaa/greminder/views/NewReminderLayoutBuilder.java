/**
 * 
 */
package com.salomaa.greminder.views;

import java.util.Map;

import android.content.Context;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.salomaa.greminder.views.LayoutBuilder#createLayout(java.util.Map)
	 */
	@Override
	public ViewGroup createLayout(Map<String, Object> data) {
		WebView webView = new WebView(mContext);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/NewReminder.html");
		return webView;
	}
}
