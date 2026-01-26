public class Monstre {
    private String nom;
    private Element type;

    public Monstre(String nom, int pv, int pui, Element type) { 
        this.nom = nom; 
        this.type = type;
    }
    public String getNom() {
        return this.nom;
    }
}
