/**
 * 
 */
package com.salomaa.greminder.views;

import java.util.Map;

import android.view.ViewGroup;

/**
 * @author Miikkajs
 *
 */
public interface LayoutBuilder {
public ViewGroup createLayout(Map<String,Object> data);
}
