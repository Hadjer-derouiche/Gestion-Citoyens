package controler;

import java.awt.event.*;
import javax.swing.*;

import model.Mairie;
import view.AffichePView;
import view.DecesView;
import view.DivorceView;
import view.EtatPView;
import view.MariageView;
import view.NaissanceView;
import view.SaisiePView;

public class MainContrl implements ActionListener  {
	
	
	private Mairie mairie;

    public MainContrl(Mairie m) {
        mairie = m;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		 switch (command) {
	        case "saisieP":
	        	SaisiePView p=new SaisiePView(mairie);
	            break;
	        case "mariage":  
	             new MariageView(mairie);
	            break;
	        case "naissance":
	        	new NaissanceView(mairie);
	            break;
	        case "divorce":
	        	new DivorceView(mairie);
	            break;
	        case "etatP":
	        	new EtatPView(mairie);
	            break;
	        case "deces":
	        	new DecesView(mairie);
	            break;
	        case "affichageP":
	          new AffichePView(mairie);
	          break;
	        default:
	            System.out.println("Interface inconnue");
	    }
	}
	

}
