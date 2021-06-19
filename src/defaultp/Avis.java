package defaultp;

public class Avis {
	int id;
	int note;
	String commentaire;
	int idFilm;
	
	public Avis(int i,int n,String c,int iF) {
		this.id = i;
		this.note = n;
		this.commentaire = c;
		this.idFilm = iF;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + ", note=" + note + ", commentaire=" + commentaire + ", idFilm=" + idFilm + "]";
	}
	
	
}
