package defaultp;
import java.lang.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
public class insert extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
		private String nomFilmText = "";
		private String anneeSortieText = "";
		private String coutFilmText ="";
		private String recetteFilmText="";
		private String numeroFilmText="";
		private int numeroFilmInt= 0;
		private int coutFilmInt = 0;
		private int recetteFilmInt = 0;
		
	public insert( ) {
		 super("Ma fenêtre de films");
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		 this.setSize(new Dimension(600, 400));
		 this.setLocationRelativeTo(null);
		 JPanel contentPane=  (JPanel) this.getContentPane();
		 contentPane.setLayout(new GridLayout(7,6)); 	
		 contentPane.add(createToolBar(), BorderLayout.NORTH);
		 
		 
		 
	
		 
		 JTextField nomFilm = new JTextField("Nom");
		 nomFilm.setPreferredSize(new Dimension(10,10));
		 
		 
		 contentPane.add(nomFilm);
		
		 
		 JTextField anneeSortie = new JTextField("Annee");
		 anneeSortie.setPreferredSize(new Dimension(10,10));
		 this.anneeSortieText = anneeSortie.getText();
		 
		 contentPane.add(anneeSortie);
		
		 JTextField numeroFilm = new JTextField("0");
		 numeroFilm.setPreferredSize(new Dimension(10,10));
		 contentPane.add(numeroFilm);
		 this.numeroFilmText = numeroFilm.getText();
		 
		 this.numeroFilmInt = Integer.parseInt(this.numeroFilmText);
		 
		 
		 JTextField coutFilm = new JTextField("0");
		 coutFilm.setPreferredSize(new Dimension(10,10));
		 contentPane.add(coutFilm);
		 this.coutFilmText = coutFilm.getText();
		 this.coutFilmInt = Integer.parseInt(this.coutFilmText);
		 
		 JTextField recetteFilm = new JTextField("0");
		 recetteFilm.setPreferredSize(new Dimension(10,10));
		 contentPane.add(recetteFilm);
		 this.recetteFilmText = recetteFilm.getText();
		 this.recetteFilmInt = Integer.parseInt(this.recetteFilmText);
		 		 
		 JButton btnPushMe = new JButton("Ajouter");
		 contentPane.add(btnPushMe);
		 
		 btnPushMe.addActionListener((e) -> {
			 this.nomFilmText = nomFilm.getText();
			 this.anneeSortieText = anneeSortie.getText();			 
			 this.numeroFilmText = numeroFilm.getText();
			 this.numeroFilmInt = Integer.parseInt(this.numeroFilmText);
			 this.coutFilmText = coutFilm.getText();
			 this.coutFilmInt = Integer.parseInt(this.coutFilmText);
			 this.recetteFilmText = recetteFilm.getText();
			 this.recetteFilmInt = Integer.parseInt(this.recetteFilmText);
			 		 
			 DAOFilm d = new DAOFilm();
			 d.ajouterBis(this.nomFilmText ,this.anneeSortieText , this.numeroFilmInt ,this.coutFilmInt, this.recetteFilmInt);
		 });
	}
	
	public static void main(String[] args)throws Exception  {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		insert window = new insert();
		window.setVisible( true);
		// TODO Auto-generated method stub

	}
	
	private void btnPushListener(ActionEvent event) {
		DAOFilm d = new DAOFilm();
		d.ajouterBis(this.nomFilmText ,this.anneeSortieText , this.numeroFilmInt ,this.coutFilmInt, this.recetteFilmInt);
		
	}
	 private JToolBar createToolBar() {
		 JToolBar toolBar = new JToolBar();

		 
		 return toolBar;
		 
	 }



}




