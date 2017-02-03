import view.Login;
import model.Model;
import model.User;

public class main {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		//zum Login bitte folgende Daten benutzen:
		//U: alex@potsdam.de P: a 
		//U: boris@potsdam.de P: b
		//U: chris@potsdam.de P: c
		
		Login login = new Login(model);
		
	}
}