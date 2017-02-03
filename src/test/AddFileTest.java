package test;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import model.Model;
import ui.Constants;
import view.View;

public class AddFileTest {
	

	@Test
	public void test() {
		
		String username = "boris@potsdam.de";
		Model testModel = new Model();
		new View(testModel,username);
		
		URL testFilePath = getClass().getClassLoader().getResource("raw/shared.png");
		File testFile = new File(testFilePath.getFile());
		
		//Aufruf der Funktion zum Datei hochladen
		testModel.addFile(username, testFile);
			
		String uploadedFilePath = Constants.uploadPathRoot + username + File.separator + "shared.png";
		File uploadedFile = new File(uploadedFilePath);
		
		//überprüft ob shared.png in der Dateiliste ist und ob es im Temporären Verzeichnis liegt
		assertTrue(testModel.files(username).contains("shared.png") && uploadedFile.exists());		
	}

}
