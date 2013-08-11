/**
 * 
 */
package com.salomaa.greminder.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Application;
import android.content.Context;

import com.salomaa.greminder.GreminderApplication;

/**
 * Helper class to do IO actions.
 * @author Miikkajs
 *
 */
public class FileManager {
	private static Application application =  GreminderApplication.getInstance();
	
	/**
	 * @param object
	 * @param fileName
	 * @throws IOException
	 */
	public static  void writeToFile(Object object, String fileName) throws IOException{
		FileOutputStream fos = application.openFileOutput(fileName, Context.MODE_PRIVATE);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
		objectOutputStream.writeObject(object);
		fos.close();
	}
	
	/**
	 * @param fileName
	 * @return Object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object readFile(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = application.openFileInput(fileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fis);
		Object o =objectInputStream.readObject();
		fis.close();
		return o;
		
	}

}
