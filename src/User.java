import java.util.ArrayList;
import java.util.List;


public class User {

	List fileList = new ArrayList();
	List sharedList = new ArrayList();
	
	public String name, password;
	
	
	public User(String name, String password){
		
		this.name=name;
		this.password=password;
		
		fileList.add("gdfihlu.png");
		fileList.add("iuhdsf.mp3");
		fileList.add("dfsgiuh.doc");
		fileList.add("asdfsadf.xml");
		
		System.out.println("User");
	}
	
	
	
}
