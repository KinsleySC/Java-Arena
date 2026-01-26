import java.util.ArrayList;
import java.util.HashMap;

public class Joueur {
    private String nom;
    private ArrayList<Monstre> equipe = new ArrayList<>();
    private HashMap<String, Integer> inventaire = new HashMap<>();

    public Joueur(String nom) { this.nom = nom; }
    public String getNom() { return nom; }
    public int getCredits() { return 10; }
    public void ajouterMonstre(Monstre m) { equipe.add(m); }
    public void afficherEquipe() { System.out.println("Equipe affichée"); }
    public void afficherInventaire() { System.out.println("Inventaire affiché"); }
    public boolean aTousSesMonstresKO() { return false; }
    public ArrayList<Monstre> getEquipe() { return equipe; }
}
