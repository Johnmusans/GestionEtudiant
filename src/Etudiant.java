public class Etudiant {
    private String matricule;
    private String nom;
    private String postNom;
    private String prenom;
    private String genre;

    // Constructeur
    public Etudiant(String matricule, String nom, String postNom, String prenom, String genre) {
        this.matricule = matricule;
        this.nom = nom;
        this.postNom = postNom;
        this.prenom = prenom;
        this.genre = genre;
    }

    // Getters et setters
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostNom() {
        return postNom;
    }

    public void setPostNom(String postNom) {
        this.postNom = postNom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
