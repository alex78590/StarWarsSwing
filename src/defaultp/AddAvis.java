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
public class AddAvis extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
		
		private String commentaire = "";
		private int note =0;
		private int idFilm=0;
		public void envoyer(int id1) {
			this.idFilm=id1;
			System.out.print(this.idFilm);
		}
		
	public AddAvis( ) {
		 super("Ma fenêtre de films");
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		 this.setSize(new Dimension(600, 400));
		 this.setLocationRelativeTo(null);
		 JPanel contentPane=  (JPanel) this.getContentPane();
		 contentPane.setLayout(new GridLayout(7,6)); 	
		 contentPane.add(createToolBar(), BorderLayout.NORTH);
		 
		 
		 
	
		 JLabel c = new JLabel("commentaire");
		 JTextField commentaire = new JTextField("");
		 commentaire.setPreferredSize(new Dimension(10,10));
		 
		 
		 contentPane.add(c);
		 contentPane.add(commentaire);
		
		 
		 JLabel n = new JLabel("note sur 5");
		 JTextField note = new JTextField("");
		 note.setPreferredSize(new Dimension(10,10));
		 
		 
		 contentPane.add(n);
		 contentPane.add(note);
		
		 
		
		 
		 
		 System.out.print(this.idFilm); 
		 JButton btnPushMe = new JButton("Ajouter");
		 contentPane.add(btnPushMe);
		 
		 btnPushMe.addActionListener((e) -> {
			 
			 this.commentaire = commentaire.getText();
			 this.note = Integer.parseInt(note.getText());			 
			
			 DAOFilm d = new DAOFilm();
			 d.ajouterAvis(this.commentaire, this.note, this.idFilm);
			 
		 });
	}
	
	public static void main(String[] args)throws Exception  {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		AddAvis window = new AddAvis();
		window.setVisible( true);
		// TODO Auto-generated method stub

	}
	
	
	 private JToolBar createToolBar() {
		 JToolBar toolBar = new JToolBar();

		 
		 return toolBar;
		 
	 }



}




