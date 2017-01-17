import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import ui.SFileButton;

public class Model extends java.util.Observable {

	List fileList = new ArrayList();

	List<User> userList = new ArrayList<User>(); // oder vllt maps nutzen

	Map<String, User> userMap = new HashMap<String, User>();

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

	public List files(String username) {
		return userMap.get(username).fileList;
	}

	public List sharedFiles(String username) {
		return userMap.get(username).sharedList;
	}

	public void deleteSomething() {
		// TODO Auto-generated method stub

	}

	public void addFile(String username, String file) {
		// TODO Auto-generated method stub
		userMap.get(username).fileList.add(file);
		System.out.println(file + " hochgeladen.");
		setChanged();
		notifyObservers();
	}

	public boolean shareFile(String username, String username2, int fileID) {
		// TODO Auto-generated method stub

		if (userMap.get(username2) == null) {
			return false;
		} else {
			userMap.get(username2).sharedList.add(userMap.get(username).fileList.get(fileID));
			System.out.println("Shared file which " + fileID + " equals " + userMap.get(username).fileList.get(fileID)
					+ "with " + username2);

			setChanged();
			notifyObservers();
			
			for (String temp : userMap.get(username2).sharedList) {
				System.out.println(temp);
			}
			
		}
		return true;
	}

}
