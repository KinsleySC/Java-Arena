# ⚔️ JAVA ARENA - Combat Tactique

## 📝 Présentation du Projet
[cite_start]**Java Arena** est un moteur de jeu de combat tactique au tour par tour développé en Java[cite: 8, 9]. [cite_start]Le joueur incarne un dresseur qui constitue une équipe de créatures élémentaires pour affronter des monstres sauvages dans une arène[cite: 10].

## 🎮 Fonctionnalités du Jeu
* [cite_start]**Système de combat** : Affrontements au tour par tour basés sur une mécanique de "Pierre-Feuille-Ciseaux" (Eau > Feu > Plante)[cite: 9, 17].
* [cite_start]**Gestion d'équipe** : Création d'une équipe de 3 monstres sélectionnés aléatoirement lors du démarrage d'une nouvelle partie[cite: 26, 34].
* [cite_start]**Inventaire & Boutique** : Achat et utilisation de consommables (potions de soin, résurrection, outils de capture)[cite: 27, 38].
* [cite_start]**Persistance** : Sauvegarde de la progression et chargement de parties existantes via un système de fichiers CSV[cite: 31, 34, 59].

## 📋 Règles de Combat
* [cite_start]**Avantage Élémentaire** : Une attaque efficace inflige le double des dégâts normaux[cite: 21].
* [cite_start]**État KO** : Un monstre à 0 PV est hors de combat ; il ne peut plus attaquer ni être ciblé[cite: 22, 23].
* [cite_start]**Capture** : Un monstre sauvage peut être capturé uniquement s'il possède moins de 30% de ses PV[cite: 57].

## 🛠️ Spécifications Techniques
* [cite_start]**Architecture POO** : Utilisation de l'encapsulation, de l'héritage et du polymorphisme pour le calcul des dégâts élémentaires[cite: 46, 47].
* [cite_start]**Gestion des Données** : Utilisation de structures dynamiques pour l'équipe et de Maps pour l'inventaire afin d'éviter les boucles de recherche[cite: 49, 50].
* [cite_start]**Robustesse** : Système d'exceptions personnalisées pour bloquer les actions illégales (ex: attaquer une cible déjà KO) et sécuriser les saisies utilisateur[cite: 52, 53].

## 🚀 Installation et Lancement
1. [cite_start]Clone le projet depuis GitHub.
2. Compile les fichiers source avec `javac`.
3. [cite_start]Lance la classe principale pour accéder au menu principal.
