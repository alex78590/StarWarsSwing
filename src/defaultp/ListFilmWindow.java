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
import java.util.List;

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
public class ListFilmWindow extends JFrame  {
	
	
	
	DAOFilm f = new DAOFilm();
	ArrayList<Film>films = f.listerFilm1();
	
	ListFilmWindow(){
		super("Liste Films");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		
		
	
		
		
		String[] columns = new String[] {
	            "Id", "titre","annee" ,"numero", "cout","recette","moyenne"
	        };
	         
		Object[][] data = new Object[films.size()][100];
		
		
		for (int i=0, j=0;i< films.size();i++, j++){
			ArrayList<Avis> avis = f.listeAvis(films.get(i).id);
			data[j][0] = films.get(i).getId(); 
			data[j][1] = films.get(i).getTitre();
			data[j][2] = films.get(i).getAnnee(); 
			data[j][3] = films.get(i).getNumEpisode();
			data[j][4] = films.get(i).getCout(); 
			data[j][5] = films.get(i).getRecette();
			data[j][6] = films.get(i).getMoyenne(avis);
			
			
			
			}
		
		
		

		String titre[]= columns;
		
		
		JButton btnAvis = new JButton("Ajouter ou consulter des avis");
		btnAvis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAndListAvis myWindow = new AddAndListAvis();
				myWindow.setVisible(true);
			}
		});
		
		JButton ajouterFilm = new JButton("Ajouter un film");
		ajouterFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert myWindow = new insert();
				myWindow.setVisible(true);
			}
		});
		
		
		getContentPane().add(ajouterFilm);
		getContentPane().add(btnAvis);
		JTable tableau = new JTable(data, titre);
		JScrollPane scrollPane = new JScrollPane(tableau);
		this.getContentPane().add(scrollPane);
		
		
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
		
		ListFilmWindow myWindow = new ListFilmWindow();
		myWindow.setVisible(true);
		
		
	}

}
