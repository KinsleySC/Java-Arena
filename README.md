# ⚔️ JAVA ARENA - Combat Tactique

## 📝 Présentation du Projet
**Java Arena** est un moteur de jeu de combat tactique au tour par tour développé en Java. Le joueur incarne un dresseur qui constitue une équipe de créatures élémentaires pour affronter des monstres sauvages dans une arène.

## 🎮 Fonctionnalités du Jeu
**Système de combat** : Affrontements au tour par tour basés sur une mécanique de "Pierre-Feuille-Ciseaux" (Eau > Feu > Plante).
* **Gestion d'équipe** : Création d'une équipe de 3 monstres sélectionnés aléatoirement lors du démarrage d'une nouvelle partie.
* **Inventaire & Boutique** : Achat et utilisation de consommables (potions de soin, résurrection, outils de capture).
* **Persistance** : Sauvegarde de la progression et chargement de parties existantes via un système de fichiers CSV.

## 📋 Règles de Combat
**Avantage Élémentaire** : Une attaque efficace inflige le double des dégâts normaux.
**État KO** : Un monstre à 0 PV est hors de combat ; il ne peut plus attaquer ni être ciblé.
**Capture** : Un monstre sauvage peut être capturé uniquement s'il possède moins de 30% de ses PV.

## 🛠️ Spécifications Techniques
**Architecture POO** : Utilisation de l'encapsulation, de l'héritage et du polymorphisme pour le calcul des dégâts élémentaires.
**Gestion des Données** : Utilisation de structures dynamiques pour l'équipe et de Maps pour l'inventaire afin d'éviter les boucles de recherche.
**Robustesse** : Système d'exceptions personnalisées pour bloquer les actions illégales (ex: attaquer une cible déjà KO) et sécuriser les saisies utilisateur.

## 🚀 Installation et Lancement
1. Clone le projet depuis GitHub.
2. Compile les fichiers source avec `javac`.
3. Lance la classe principale pour accéder au menu principal.
