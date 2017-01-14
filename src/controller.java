import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller  implements ActionListener{

	Model model;
	View view;
	
	public Controller(Model model, View view) {
		// TODO Auto-generated constructor stub
		System.out.println("Controller erstellt.");
		this.model=model;
		this.view=view;
		
		
		
	}
	
	public ActionListener getDeleteListener () {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                model.deleteSomething();
            }
        };
    }
	
	public ActionListener addFileListener () {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                model.addFile(view.file1);
            }
        };
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
