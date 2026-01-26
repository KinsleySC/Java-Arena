import java.lang.annotation.ElementType;

public class Bestiaire {
    public Monstre genererMonstreAleatoire() {
        return new Monstre("Monstre Test", 100, 10, Element.FEU);
    }
    public Monstre genererMonstreSauvage() {
        return new Monstre("Sauvage", 150, 15, Element.EAU);
    }
}
