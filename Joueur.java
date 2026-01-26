import java.util.ArrayList;
import java.util.HashMap;

public class Joueur {
    private String nom;
    private ArrayList<Monstre> equipe;
    private HashMap<String, Integer> inventaire;
    private int credits;          

    public Joueur(String nom) {
        this.nom = nom;
        this.equipe = new ArrayList<Monstre>();
        this.inventaire = new HashMap<String, Integer>();
        this.credits = 10;
    }

    public String getNom() {
        return this.nom;
    }

    public ArrayList<Monstre> getEquipe() {
        return this.equipe;
    }

    public int getCredits() {
        return this.credits;
    }

    public void ajouterMonstre(Monstre monstre) throws Exception {
        if (this.equipe.size() >= 3) {
            throw new Exception("L'equipe est deja pleine (3 monstres maximum) !");
        }
        this.equipe.add(monstre);
    }

    public void ajouterCredits(int montant) {
        this.credits = this.credits + montant;
    }

    public void retirerCredits(int montant) throws Exception {
        if (this.credits < montant) {
            throw new Exception("Pas assez de credits !");
        }
        this.credits = this.credits - montant;
    }

    public void ajouterObjet(String nomObjet, int quantite) {
        if (this.inventaire.containsKey(nomObjet)) {
            int quantiteActuelle = this.inventaire.get(nomObjet);

            this.inventaire.put(nomObjet, quantiteActuelle + quantite);
        } else {
            this.inventaire.put(nomObjet, quantite);
        }
    }

    public void utiliserObjet(String nomObjet) throws Exception {
        if (!this.inventaire.containsKey(nomObjet)) {
            throw new Exception("Vous ne possedez pas cet objet !");
        }
        int quantite = this.inventaire.get(nomObjet);

        if (quantite <= 0) {
            throw new Exception("Vous n'avez plus de " + nomObjet + " !");
        }

        this.inventaire.put(nomObjet, quantite - 1);
    }

    public boolean possedeObjet(String nomObjet) {
        if (!this.inventaire.containsKey(nomObjet)) {
            return false;
        }
        return this.inventaire.get(nomObjet) > 0;
    }

    public int getQuantiteObjet(String nomObjet) {
        if (!this.inventaire.containsKey(nomObjet)) {
            return 0;
        }
        return this.inventaire.get(nomObjet);
    }

    public int nombreMonstresVivants() {
        int compteur = 0;

        for (int i = 0; i < this.equipe.size(); i++) {
            Monstre monstre = this.equipe.get(i);
            if (!monstre.estKO()) {
                compteur = compteur + 1;
            }
        }
        return compteur;
    }

    public boolean aTousSesMonstresKO() {
        return this.nombreMonstresVivants() == 0;
    }

    public void afficherEquipe() {
        System.out.println("\n=== Equipe de " + this.nom + " ===");
        for (int i = 0; i < this.equipe.size(); i++) {
            Monstre monstre = this.equipe.get(i);
            System.out.println((i + 1) + ". " + monstre.toString());
        }
    }

    public void afficherInventaire() {
        System.out.println("\n=== Inventaire (Credits: " + this.credits + ") ===");
        for (String nomObjet : this.inventaire.keySet()) {
            int quantite = this.inventaire.get(nomObjet);
            System.out.println("- " + nomObjet + " x" + quantite);
        }
    }
}
