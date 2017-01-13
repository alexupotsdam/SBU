import java.util.ArrayList;
import java.util.List;

public class Model {

	List fileList = new ArrayList();

	public Model() {
		System.out.println("Model erstellt");

		fileList.add("gdfihlu.png");
		fileList.add("iuhdsf.mp3");
		fileList.add("dfsgiuh.doc");
		fileList.add("asdfsadf.xml");
		
	}

	public boolean loginAction(String user, String password) {

		if (user.equals("a")) {
			if (password.equals("a")) {
				return true;
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

}
