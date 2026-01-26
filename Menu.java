import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Bestiaire bestiaire;
    private Sauvegarde sauvegarde;
    private Boutique boutique;
    private InterfaceCombat interfaceCombat;
    private Joueur joueur;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.bestiaire = new Bestiaire();
        this.sauvegarde = new Sauvegarde();
        this.boutique = new Boutique(this.scanner);
        this.interfaceCombat = new InterfaceCombat(this.scanner);
        this.joueur = null; 
    }
    public void afficherMenuPrincipal() {
        boolean continuer = true;
    
        while (continuer) {
            System.out.println("\n=============================");
            System.out.println("    POKEBAM ARENA - MENU");
            System.out.println("=============================");
            System.out.println("1. Commencer une nouvelle partie");
            System.out.println("2. Charger une partie existante");
            System.out.println("3. Quitter");
            System.out.print("\nVotre choix : ");
            String choix = this.scanner.nextLine();
    
            if (choix.equals("1")) {
                this.nouvellePartie();
            } else if (choix.equals("2")) {
                this.chargerPartie();
            } else if (choix.equals("3")) {
                System.out.println("Merci d'avoir joue a PokeBam Arena !");
                continuer = false;
            } else {
                System.out.println("Choix invalide ! Veuillez entrer 1, 2 ou 3.");
            }
        }
        this.scanner.close();
    }
    private void nouvellePartie() {
        System.out.println("\n=== NOUVELLE PARTIE ===");
        System.out.println("Bienvenue sur Java Arena !");
        System.out.print("Entrez votre nom : ");
        String nomJoueur = this.scanner.nextLine();

        this.joueur = new Joueur(nomJoueur);
        System.out.println("\nSelection de votre equipe de depart...");
        try {
            Monstre monstre1 = this.bestiaire.genererMonstreAleatoire();
            this.joueur.ajouterMonstre(monstre1);
            System.out.println("1. " + monstre1.getNom() + " rejoint votre equipe !");

            Monstre monstre2 = this.bestiaire.genererMonstreAleatoire();
            this.joueur.ajouterMonstre(monstre2);
            System.out.println("2. " + monstre2.getNom() + " rejoint votre equipe !");

            Monstre monstre3 = this.bestiaire.genererMonstreAleatoire();
            this.joueur.ajouterMonstre(monstre3);
            System.out.println("3. " + monstre3.getNom() + " rejoint votre equipe !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        this.afficherMenuJoueur();
    }
    private void chargerPartie() {
        if (!this.sauvegarde.sauvegardeExiste()) {
            System.out.println("Aucune sauvegarde trouvee !");
            return;
        }
        try {
            System.out.println("\nChargement de la partie...");
            this.joueur = this.sauvegarde.chargerPartie();

            System.out.println("Bienvenue " + this.joueur.getNom() + " !");
            this.afficherMenuJoueur();
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement : " + e.getMessage());
        }
    }
    private void afficherMenuJoueur() {
        boolean continuer = true;
        
        while (continuer) {
            System.out.println("\n=== MENU JOUEUR ===");
            System.out.println("1. Commencer une nouvelle partie ou charger une partie existante");
            System.out.println("2. Mon equipe (afficher l'etat - PV par monstres)");
            System.out.println("3. Mon joueur");
            System.out.println("4. Boutique");
            System.out.println("5. Quitter (avec possibilite de sauvegarder)");
            System.out.print("\nVotre choix : ");
            String choix = this.scanner.nextLine();

            if (choix.equals("1")) {
                this.lancerCombat();
            } else if (choix.equals("2")) {
                this.joueur.afficherEquipe();
            } else if (choix.equals("3")) {
                this.afficherInfosJoueur();
            } else if (choix.equals("4")) {
                this.boutique.afficherMenu(this.joueur);
            } else if (choix.equals("5")) {
                continuer = this.gererQuitter();
            } else {
                System.out.println("Choix invalide !");
            }
        }
    }
    private void afficherInfosJoueur() {
        System.out.println("\n=== INFORMATIONS ===");
        System.out.println("Nom : " + this.joueur.getNom());
        System.out.println("Credits : " + this.joueur.getCredits());
        this.joueur.afficherInventaire();
    }

    private void lancerCombat() {
        if (this.joueur.aTousSesMonstresKO()) {
            System.out.println("Tous vos monstres sont K.O. ! Utilisez des potions de resurrection.");
            return;
        }
        Monstre monstreSauvage = this.bestiaire.genererMonstreSauvage();

        Combat combat = new Combat(this.joueur, monstreSauvage);
    
        this.interfaceCombat.lancerCombat(combat);
    }
    
    private boolean gererQuitter() {
        System.out.println("\nVoulez-vous sauvegarder avant de quitter ?");
        System.out.println("1. Sauvegarder et quitter");
        System.out.println("2. Quitter sans sauvegarder");
        System.out.println("3. Retour");
        System.out.print("\nVotre choix : ");
        String choix = this.scanner.nextLine();
        
        if (choix.equals("1")) {
            try {
                this.sauvegarde.sauvegarderPartie(this.joueur);
            } catch (Exception e) {
                System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
            }
            return false;
        } else if (choix.equals("2")) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.afficherMenuPrincipal();
    }
}
