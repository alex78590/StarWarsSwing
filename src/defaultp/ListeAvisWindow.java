package defaultp;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JEditorPane;
public class ListeAvisWindow extends JFrame  {
	
	
	
	DAOFilm f = new DAOFilm();
	 int id=0;
	JButton ajouterAvis = new JButton("ajoutez votre avis");
	
	public void envoyer(int id1) {
		id=id1;
		ArrayList<Avis>avis = f.listeAvis(id);
		String[] columns = new String[] {
	            "Id", "note","commentaire"
	        };
	         
		Object[][] data = new Object[avis.size()][10];
		
		for (int i=0, j=0;i< avis.size();i++, j++){

			data[j][0] = avis.get(i).getId(); 
			data[j][1] = avis.get(i).getNote();
			data[j][2] = avis.get(i).getCommentaire(); 
			
			
			
			}
		
		String titre[]= columns;
		JTable tableau = new JTable(data, titre);
		this.getContentPane().add(new JScrollPane(tableau));
		
	}
	
	
	
	ListeAvisWindow(){
		super("Liste Avis");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(ajouterAvis);
		
		ajouterAvis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAvis myWindow = new AddAvis();
				myWindow.setVisible(true);
				myWindow.envoyer(id);
				myWindow.setVisible(true);
			}
		});
		
		
		
	
		
		
		
	}
	
	

	
	public  class   Ajouter implements   ActionListener
    {
         /**
         * obligatoire car test implémente l'interface ActionListener
         */
        public  void    actionPerformed(ActionEvent e)
        {
            System.out.println("Ici !");
        }
    }
	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		ListeAvisWindow myWindow = new ListeAvisWindow();
		myWindow.setVisible(true);
		
	}

}
