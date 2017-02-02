package model;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import view.View;

public class Model {

	Map<String, User> userMap = new HashMap<String, User>();
	Map<String, View> viewMap = new HashMap<String, View>();
	
	User a, b;

	public Model() {
		userMap.put("a", new User("a", "a"));
		userMap.put("b", new User("b", "b"));

		System.out.println("Model erstellt");
	}

	public boolean loginAction(String username, String password) {

		// if( user.equals(userMap.get(user).name) ) daraus könnte man noch
		// "user existiert nicht" machen aber
		// das ist vllt nicht so der Inbegriff von Sicherheit

		if (userMap.get(username) != null) {
			if (password.equals(userMap.get(username).password)) {
				return true;
			}
		}
		return false;
	}

	public List<String> files(String username) {
		return userMap.get(username).fileList;
	}

	public List<String> sharedFiles(String username) {
		return userMap.get(username).sharedList;
	}

	public void addFile(String username, File file) {
//		userMap.get(username).fileList.add(filename);
	//	viewMap.get(username).notify("Datei '"+filename+"' hochgeladen.");

		
		
		//
		String path =System.getProperty("java.io.tmpdir");
    	
    	path=path+username+"/"+file.getName();
    	
    	System.out.println(path);
		
	}

	public boolean shareFile(String username, String username2, int fileID) {

		if (userMap.get(username2) == null) {
			return false;
		} else {
			userMap.get(username2).sharedList.add(userMap.get(username).fileList.get(fileID));
			System.out.println("Shared file which " + fileID + " equals " + userMap.get(username).fileList.get(fileID)
					+ "with " + username2);
			
			viewMap.get(username).notify("Datei mit Nutzer '"+username2+"' geteilt");
			
			if(viewMap.get(username2)!=null)
			viewMap.get(username2).notify("Datei '"+userMap.get(username).fileList.get(fileID)+"' von Nutzer '"+username+"' erhalten");
			
			
			for (String temp : userMap.get(username2).sharedList) {
				System.out.println(temp);
			}
		}
		return true;
	}
	
	public void addListener(String s, View v){
		viewMap.put(s, v);
	}
	
	public void removeListener(String s){
		viewMap.remove(s);
	}

}
