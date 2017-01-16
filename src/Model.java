import java.util.ArrayList;
import java.util.List;

public class Model extends java.util.Observable{

	List fileList = new ArrayList();
	
	List<User> userList = new ArrayList<User>();
	
	User a,b;

	public Model() {
		
		a = new User("a","a");
		b = new User("b","b");
		
		userList.add(a);
		userList.add(b);
		
		System.out.println("Model erstellt");
	}

	public boolean loginAction(String user, String password) {

		for (User item : userList) {
			if (item != null) {
				
				if(user.equals(item.name)){
					if(password.equals(item.password)){
					return true;
					}
				}
			}
		}
		
		return false;
		
		
	}
	
	public String[] files(){
		
		String fileString[]=new String[99];
		
		for(int i=0; i<fileList.size(); i++){
			fileString[i]=(String) fileList.get(i);
		}
		
		return fileString;
	}

	public void deleteSomething() {
		// TODO Auto-generated method stub
		
	}

	public void addFile(String file) {
		// TODO Auto-generated method stub
		fileList.add(file);
		System.out.println(file+" hochgeladen.");
		
		setChanged();
		notifyObservers();
	}

	public void shareFile(int fileID) {
		// TODO Auto-generated method stub
		System.out.println("Shared file "+fileID+" equals "+fileList.get(fileID));
	}

}
