import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEtudiants {
    private static final String FILE_PATH = "etudiants.json";
    private static List<Etudiant> etudiants = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        chargerEtudiants();

        while (true) {
            System.out.println("1. Enregistrer un nouvel etudiant");
            System.out.println("2. Afficher les etudiants enregistres");
            System.out.println("3. Quitter");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne

            if (choix == 1) {
                enregistrerNouvelEtudiant(scanner);
            } else if (choix == 2) {
                afficherEtudiants();
            } else if (choix == 3) {
                break;
            }
        }

        scanner.close();
    }

    private static void enregistrerNouvelEtudiant(Scanner scanner) {
        System.out.print("Matricule: ");
        String matricule = scanner.nextLine();
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Post Nom: ");
        String postNom = scanner.nextLine();
        System.out.print("Prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        Etudiant etudiant = new Etudiant(matricule, nom, postNom, prenom, genre);
        etudiants.add(etudiant);
        sauvegarderEtudiants();
    }

    private static void afficherEtudiants() {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant enregistré.");
        } else {
            for (Etudiant etudiant : etudiants) {
                System.out.println("Matricule: " + etudiant.getMatricule());
                System.out.println("Nom: " + etudiant.getNom());
                System.out.println("Post Nom: " + etudiant.getPostNom());
                System.out.println("Prenom: " + etudiant.getPrenom());
                System.out.println("Genre: " + etudiant.getGenre());
                System.out.println("------");
            }
        }
    }

    private static void chargerEtudiants() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                etudiants = LireEtudiant.lireDeJSON(FILE_PATH);
            }
        } catch (IOException e) {
            System.out.println("Aucun fichier trouvé, un nouveau fichier sera créé.");
        }
    }

    private static void sauvegarderEtudiants() {
        try {
            LireEtudiant.sauvegarderEtudiants(FILE_PATH, etudiants);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
