package model;
import java.util.ArrayList;
import java.util.List;


public class User {

	List<String> fileList = new ArrayList<String>();
	
	//in der file list steht dazu noch mit welchem leuten die datei geteilt wurde das heißt im falle von löschen kann der eintrag
	//aus den anderen listen rausgenommen werden.
	
	List<String> sharedList = new ArrayList<String>();
	
	public String name, password;
	
	
	public User(String name, String password){
		
		this.name=name;
		this.password=password;
		
		/*fileList.add("gdfihlu.png");
		fileList.add("iuhdsf.mp3");
		fileList.add("dfsgiuh.doc");
		fileList.add("asdfsadf.xml");
		
		sharedList.add("asdfsadf.xml");*/
		
		System.out.println("User");
	}
	
	
	
}
