package defaultp;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
import java.awt.Color;
public class AddAndListAvis extends JFrame  {
	
	
	
	DAOFilm f = new DAOFilm();
	ArrayList<Film>films = f.listerFilm1();
    int id=0;
	
	AddAndListAvis(){
		super("Ajouter et consulter avis");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\Alexis\\Downloads\\langfr-260px-Star_Wars_Logo.svg.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			getContentPane().add(picLabel);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		JComboBox comboFilm = new JComboBox();
		comboFilm.addItem("Sélectionnez un film");
		for (int i=0;i<films.size();i++) {
			
			Film f = new Film(films.get(i).getId(),films.get(i).getAnnee(),films.get(i).getTitre(),
					films.get(i).getCout(),films.get(i).getRecette(),films.get(i).getNumEpisode());
			
			comboFilm.addItem(f);
		}
		
		
		
		
		contentPane.add(comboFilm);
		
		comboFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox c = (JComboBox)e.getSource();
				Film film =(Film)c.getSelectedItem();
				id=film.getId();
		        System.out.println( film.getTitre()+""+film.getId() );
		        int i=id; 
				ListeAvisWindow obj= new ListeAvisWindow();
				obj.envoyer(i);
				obj.setVisible(true);
		        
			}
			
		});
		

		
		
	}
		
		
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		AddAndListAvis myWindow = new AddAndListAvis();
		myWindow.setVisible(true);
		
	}

}
