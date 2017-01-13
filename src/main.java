//import gui.LoginView;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("TODO: Sharedbox Ultimate fertig machen");
		
		//NEW hintergrundkram
		//Loginwindow in ne Klasse schieben
		//LoginView view = new LoginView("SharedBox Ultimate - Share Your Stuff!"); 
		
		Model model = new Model();
		
		//Login login = new Login(model);
		View view = new View(model);

	}

}
