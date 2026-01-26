import java.util.Random;
public class Bestiaire {
   private Random random = new Random();
   public Bestiaire() {
   }

   public Monstre creerMonstrePlante() {
      return new Monstre("Herbizard", 100, 15, ElementType.PLANTE);
   }

   public Monstre creerMonstreEau() {
      return new Monstre("Aquatique", 120, 12, ElementType.EAU);
   }

   public Monstre creerMonstreFeu() {
      return new Monstre("Flammeche", 110, 14, ElementType.FEU);
   }

   public Monstre genererMonstreAleatoire() {
      int var1 = this.random.nextInt(3);
      if (var1 == 0) {
         return this.creerMonstrePlante();
      } else {
         return var1 == 1 ? this.creerMonstreEau() : this.creerMonstreFeu();
      }
   }

   public Monstre genererMonstreSauvage() {
      int var1 = this.random.nextInt(3);
      if (var1 == 0) {
         return new Monstre("Aquatique Sauvage", 200, 12, ElementType.EAU);
      } else {
         return var1 == 1 ? new Monstre("Flammeche Sauvage", 200, 14, ElementType.FEU) : new Monstre("Herbizard Sauvage", 200, 15, ElementType.PLANTE);
      }
   }
}
