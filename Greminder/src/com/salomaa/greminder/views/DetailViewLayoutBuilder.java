/**
 * 
 */
package com.salomaa.greminder.views;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Miikkajs
 * 
 */
public class DetailViewLayoutBuilder implements LayoutBuilder {
	private Context mContext;

	public DetailViewLayoutBuilder(Context context) {
		this.mContext = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.salomaa.greminder.views.LayoutBuilder#createLayout(java.util.Map)
	 */
	@Override
	public View createLayout(List<Map<String, Object>> data) {
		LinearLayout layout = new LinearLayout(mContext);
		layout.setOrientation(LinearLayout.VERTICAL);
		for (Map<String, Object> map : data) {
			Set<String> keys = map.keySet();
			Iterator<String> iterator = keys.iterator();
			while (iterator.hasNext()) {
				String caption = iterator.next();
				TextView captionTextView = new TextView(mContext);
				captionTextView.setText(caption);
				TextView detailTextView = new TextView(mContext);
				detailTextView.setText(map.get(caption).toString());
				layout.addView(detailTextView);

			}
		}

		return layout;
	}

}
