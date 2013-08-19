/**
 * 
 */
package com.salomaa.greminder.views;

import java.util.Map;

import android.view.View;

/**
 * @author Miikkajs
 *
 */
public interface LayoutBuilder {
/**
 * @param data
 * @return ViewGroup
 */
public View createLayout(Map<String,Object> data);
}
