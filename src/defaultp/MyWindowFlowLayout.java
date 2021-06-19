package defaultp;
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
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JEditorPane;

public class MyWindowFlowLayout extends JFrame  {
	private JButton btnPushMe = new JButton("push me");
	private JButton btnClickMe = new JButton("click me");
	private JCheckBox chkCheckMe = new JCheckBox("check me");
	private JTextField txtEditMe = new JTextField("edit me");
	DAOFilm f = new DAOFilm();
	MyWindowFlowLayout(){
		super("swing app");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		
		btnPushMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Film>films = f.listerFilm1();
				for (int i=0;i<films.size();i++) {
					System.out.print(films.get(i).getId());
					System.out.print(films.get(i).getTitre());
					System.out.print(films.get(i).getAnnee());
					System.out.print(films.get(i).getNumEpisode());
					System.out.print(films.get(i).getCout());
					System.out.print(films.get(i).getRecette());}
			}
		});
		contentPane.add(btnPushMe);
		
		
		contentPane.add(btnClickMe);
		
		
		contentPane.add(chkCheckMe);
		
		
		contentPane.add(txtEditMe);
	}
//	public void actionPerformed(ActionEvent event) {
//		if(event.getSource() == this.btnPushMe) {
//			System.out.println("cliqué");
//		}
//		
//	}
	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		MyWindowFlowLayout myWindow = new MyWindowFlowLayout();
		myWindow.setVisible(true);
	}

}
