/**Cette classe va permettre de controller la vue parametrageView et interragir avec le modèle parametrage
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package parametrage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acceuil.DBHelper;

public class ParametrageController implements ActionListener{
	private JButton boutton;
	private JTextField[] param;
	private Parametrage a;
	private int idBtn;

	public ParametrageController(JButton btn, JTextField[] param2) {
		super();
		this.boutton=btn;
		this.param=param2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("btn")) {
			idBtn=Integer.parseInt(boutton.getName().substring(3, 5));
			a=DBHelper.detailBoutton(idBtn);
			param[1].setText(Integer.toString(a.getNumeroBoutton()));
			param[3].setText(a.getDescription());
			param[5].setText(Double.toString(a.getPrix()));
			param[7].setText(Integer.toString(a.getCouleurR()));
			param[9].setText(Integer.toString(a.getCouleurG()));
			param[11].setText(Integer.toString(a.getCouleurB()));
			param[13].setText((a.isVisible() ? "oui" : "non"));
		}
		else if(boutton.getName().contains("validationVrai")){
			a=DBHelper.detailBoutton(Integer.parseInt(param[1].getText()));
			a.setDescription(param[3].getText());
			a.setPrix(Double.parseDouble(param[5].getText()));
			a.setCouleurR(Integer.parseInt(param[7].getText()));
			a.setCouleurG(Integer.parseInt(param[9].getText()));
			a.setCouleurB(Integer.parseInt(param[11].getText()));
			a.setVisible((param[13].getText().toLowerCase().contains("ui") ? true : false));
			DBHelper.majBoutton(a);
			
			java.awt.Window win[] = java.awt.Window.getWindows();
			for(int i=0;i<win.length;i++){
				win[i].dispose();
			}
			Parametrage.initialise();
		}
		else if(boutton.getName().contains("validationFaux")){
			java.awt.Window win[] = java.awt.Window.getWindows();
			for(int i=0;i<win.length;i++){
				win[i].dispose();
			}
			Parametrage.initialise();
		}
	}

}
