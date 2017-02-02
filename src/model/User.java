package model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ui.Constants;


public class User {

	List<String> fileList = new ArrayList<String>();  //beinhaltet Dateinamen von Dateien die man selber hochgeladen hat
	List<String> sharedList = new ArrayList<String>();//beinhaltet Referenzen auf Dateien die mit einem geteilt wurden.
	
//	List<String> shareList = new ArrayList<String>(); hier könnte drin stehen wer mit wem geteilt hat, um das Teilen nach dem löschen
//  von dateien rückgängig gemacht wird da wir aber kein löschen implementiert haben muss das auch nicht mehr sein.
	
	
	public String name, password;
	
	
	public User(String name, String password){
		
		this.name=name;
		this.password=password;
		
		String path = Constants.uploadPathRoot + name + File.separator ;
		File f = new File(path);
	    f.mkdir();
		
		
		/*fileList.add("gdfihlu.png");
		fileList.add("iuhdsf.mp3");
		fileList.add("dfsgiuh.doc");
		fileList.add("asdfsadf.xml");
		
		sharedList.add("asdfsadf.xml");*/
		
		System.out.println("User");
		
		
		
		
	}
	
	
	
}
