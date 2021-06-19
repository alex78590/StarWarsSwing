package defaultp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DAOFilm {

	String strClassName = "";
	String dbName= ""; 
	String login= ""; 
	String motdepasse= ""; 
	String strUrl = "" +  dbName;
	Connection conn = null;
	Statement stFilm = null;  
	ArrayList<Film> ListeFilms = null;
	
	public DAOFilm() {
		this.strClassName = "com.mysql.jdbc.Driver";
		this.dbName= "starwars"; 
		this.login= "root"; 
		this.motdepasse= ""; 
		this.strUrl = "jdbc:mysql://127.0.0.1/" +  dbName;
		this.ListeFilms=new ArrayList<Film>();
		try {
		Class.forName(strClassName);
		this.conn = DriverManager.getConnection(strUrl, login, motdepasse);
		this.stFilm = conn.createStatement();  
		}
		catch(ClassNotFoundException e) {  
			System.err.println("Driver non chargé !");  e.printStackTrace();
		}
		catch(SQLException e) {
			System.err.println(" erreur !");  e.printStackTrace();
		}
	}
	
	public void fermerStatement() {
		try {
		this.conn.close();
	}
		catch(SQLException e) {
			System.err.println(" erreur !");  e.printStackTrace();
		}
	}
	
	public void lister() {
		try {
		ResultSet rsFilms = this.stFilm.executeQuery("select * from Film");
		while(rsFilms.next()) {
			System.out.print("Id[" + rsFilms.getInt("id") + "],"
			+ rsFilms.getString("titre")+","
			+ rsFilms.getString("sortie")+","
			+ rsFilms.getInt("numero")+","
			+ rsFilms.getInt("cout")+","
			+ rsFilms.getInt("recette")+"\n"); 
			}  
		
		
		
		
		}
		catch(SQLException e) {
			System.err.println(" erreur !");  e.printStackTrace();
		}
	}
	
	public ArrayList<Film>listerFilm1() {
		
		ArrayList<Film>films=new ArrayList<Film>();
		try {
		ResultSet rsFilms = this.stFilm.executeQuery("select * from Film");
		
		while(rsFilms.next()) {
			films.add(new Film(rsFilms.getInt("id"),rsFilms.getString("titre"),rsFilms.getString("sortie"),rsFilms.getInt("numero"),rsFilms.getInt("cout"),rsFilms.getInt("recette")));
			/*System.out.print("Id[" + rsFilms.getInt("id") + "],"
			+ rsFilms.getString("titre")+","
			+ rsFilms.getString("sortie")+","
			+ rsFilms.getInt("numero")+","
			+ rsFilms.getInt("cout")+","
			+ rsFilms.getInt("recette")+"\n"); */
			}  
		
		
		
		
		}
		catch(SQLException e) {
			System.err.println(" erreur !");  e.printStackTrace();
		}
		return films;
	}
	
	public void ajouter(String titre,String sortie, int numero, int recette, int cout) {
		
		try {
		this.stFilm.executeUpdate("insert into Film (titre,sortie,numero,cout,recette) values ("
		+'"'+titre+'"'+','+sortie+','+numero+','+recette+','+cout+")");
		}
		catch(SQLException e) {
			System.err.println(" erreur !");  e.printStackTrace();
			}
		}
	
	public void supprimer(int id) {
		try {
			this.stFilm.executeUpdate("delete from Film where id=\""+id+"\"");
			}
			catch(SQLException e) {
				System.err.println(" erreur !");  e.printStackTrace();
				}
			}
	
	public ArrayList<Film>ListerFilm() {
		ArrayList<Film>films = this.ListeFilms;
		return films;
	}
	
	public void ajouterFilm(Film a) {
		
		try {
			this.conn.setAutoCommit(false);        
			  PreparedStatement prepStmt = conn.prepareStatement(    
			    "insert into film(titre,sortie,numero,cout,recette) values (?,?,?,?,?)");
			
				prepStmt.setString(1, a.getTitre());
				prepStmt.setString(2, a.getAnnee());
				prepStmt.setInt(3, a.getNumEpisode());
				prepStmt.setInt(4, a.getCout());
				prepStmt.setInt(5, a.getRecette());
				
			
			
			prepStmt.execute();
		}
			catch(SQLException e) {
				System.err.println(" grosse merde");  e.printStackTrace();
				}
		System.out.println(a);
			}
	
	public void modifier(int id,String titre,String sortie, int numero, int recette, int cout) {
		try {
			this.stFilm.executeUpdate("update film set titre='"+titre+"'"+",sortie='"+sortie+"'"
					+",numero="+numero+",recette="+recette+",cout="+cout+" where id="+id+"");
			}
			catch(SQLException e) {
				System.err.println(" erreur !");  e.printStackTrace();
				}
		
	}
	
	public Film filmById(int id) {
		
		
			Film film=null;
		try {
			ResultSet rsFilms = this.stFilm.executeQuery("select * from Film where id="+id+"");
			while(rsFilms.next()) {
				 film=new Film(rsFilms.getInt("id"),rsFilms.getString("titre"),rsFilms.getString("sortie"),rsFilms.getInt("numero"),rsFilms.getInt("cout"),rsFilms.getInt("recette"));
				}  
			
			
			}
			catch(SQLException e) {
				System.err.println(" erreur !");  e.printStackTrace();
			}
		return film;
	}
	public void ajouterBis(String titre , String anneesortie, int numeroEpisode, int recette , int cout){
        try {
            this.stFilm.executeUpdate("INSERT INTO film(titre,sortie,numero,cout,recette) values (" +'"'+titre+'"'+','+'"'+anneesortie+'"'+','+numeroEpisode+','+recette+','+cout+")");
            System.out.println("INSERT INTO film(titre,sortie,numero,cout,recette) values (" +'"'+titre+'"'+','+'"'+anneesortie+'"'+','+numeroEpisode+','+recette+','+cout+")");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
	
	
	public  ArrayList<Avis>listeAvis(int idFilm) {
		ArrayList<Avis>avis=new ArrayList<Avis>();
		try {
		ResultSet rsFilms = this.stFilm.executeQuery("select * from Avis where idFilm ="+idFilm);
		while(rsFilms.next()) {
			avis.add(new Avis(rsFilms.getInt("id"),rsFilms.getInt("note"),rsFilms.getString("commentaire"),rsFilms.getInt("idFilm")));

			}  
		
		
		
		
		}
		catch(SQLException e) {
			System.err.println(" erreur !");  e.printStackTrace();
		}
		return avis;
	}
	
	
	public void ajouterAvis(String commentaire , int note, int idFilm){
        try {
            this.stFilm.executeUpdate("INSERT INTO avis(note,commentaire,idFilm) values (" +'"'+note+'"'+','+'"'+commentaire+'"'+','+idFilm+")");
            System.out.println("INSERT INTO avis(note,commentaire,idFilm) values (" +'"'+note+'"'+','+'"'+commentaire+'"'+','+idFilm+")");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
	public static void main(String[] args) {
		DAOFilm f= new DAOFilm();
//		f.lister();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("titre du film");
//		String titre = sc.nextLine();
//		System.out.println("date de sortie");
//		String sortie = sc.nextLine();
//		System.out.println("numero");
//		int numero = sc.nextInt();
//		System.out.println("cout");
//		int recette = sc.nextInt();
//		System.out.println("recette");
//		int cout = sc.nextInt();
//		System.out.println("id");
//		int id = sc.nextInt();
		
		/* ajoute un film*/
		//f.ajouter(titre, sortie, numero, recette, cout);
		/* supp un film */
		//f.supprimer(id);
		
//		ArrayList<Film> films = new ArrayList<Film>();
//		Film film1 = new Film(0,"Film Test","1977",4,50,5000);
//		films.add(film1);
		
		/*ajoute un film depuis un objet film*/
		
		f.listeAvis(1);
		
		//sc.close();
		f.fermerStatement();
	}
}
