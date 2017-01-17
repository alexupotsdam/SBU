import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model extends java.util.Observable{

	List fileList = new ArrayList();
	
	List<User> userList = new ArrayList<User>(); //oder vllt maps nutzen
	
	Map<String, User> userMap = new HashMap<String, User>();
	
	
	User a,b;

	public Model() {
		userMap.put("a", new User("a","a"));
		userMap.put("b", new User("b","b"));
		
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
	

	
	public String[] files(String username){
		
		String fileString[]=new String[99];
		
		for(int i=0; i<userMap.get(username).fileList.size(); i++){
			fileString[i]=(String) userMap.get(username).fileList.get(i);
		}
		
		return fileString;
	}

	public void deleteSomething() {
		// TODO Auto-generated method stub
		
	}

	public void addFile( String username, String file ) {
		// TODO Auto-generated method stub
		userMap.get(username).fileList.add(file);
		System.out.println(file+" hochgeladen.");
		setChanged();
		notifyObservers();
	}

	public void shareFile( String username, String username2, int fileID) {
		// TODO Auto-generated method stub
		System.out.println("Shared file which"+fileID+" equals "+userMap.get(username).fileList.get(fileID));
	}

}
