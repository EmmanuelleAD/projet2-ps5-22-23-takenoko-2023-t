# Rapport Takenoko - Équipe T
## 1. Point d'avancement

Ce rapport global porte sur les progrès réalisés par notre équipe dans le codage du jeu Takenoko. Pour les règles du jeu, veuillez vous référer au lien suivant : https://www.trictrac.net/jeu-de-societe/ressource/clique/383f6c35aed2eaace1a85aec076074c1/takenoko.

- Concernant notre projet, nous avons couvert **les fonctionnalités** suivantes :

  -  Un jeu de Takenoko pour 2 à 4 joueurs, avec trois types de cartes objectif (Jardinier, Panda et Parcelle)
  - Les joueurs peuvent effectuer l'une des quatre actions suivantes : poser une parcelle sur le plateau, déplacer le jardinier en ligne droite, déplacer le panda en ligne droite ou piocher une carte objectif.
  - Le jeu se joue entre trois classes de bots, chacune effectuant les meilleurs coups pour accomplir un type d'objectif (Jardinier, Parcelle ou Panda).
  - Bien que le jeu en lui-même soit similaire à l'original, certains éléments n'ont pas été pris en compte dans notre implémentation : les canaux d'irrigation, la fonctionnalité de dé et de météo, ainsi que la couleur des parcelles et les améliorations possibles sur les parcelles.



- Pour les logs, le code utilise java.util.logging qui est un package Java standard pour la gestion de journaux. Un objet Logger a été créé pour l'application avec le nom de la classe Jeu, et un handler de console a été ajouté pour afficher les messages de journal sur la console. Les messages de journal sont formatés pour inclure le nom de la classe, la date et l'heure, le niveau de gravité et le message.



- Le programme simule une partie entre différents joueurs et enregistre les statistiques dans un fichier CSV. Les résultats sont enregistrés à l'aide de la méthode appendCsv de la classe Writing. JCommander gère les arguments en ligne de commande et permet à l'utilisateur de choisir le mode de jeu (démo ou 2 mille) et s'il souhaite enregistrer les statistiques dans un fichier CSV.
- Concernant le bot demandé pour la livraison les fonctionnalités récupérer le maximum de bambous,5 cartes ont été complètement implémentées. N'ayant pas les canaux d'irriguation et la météo nous n'avons pas pu impémenter "Quand il tire une la météo « ? » dans les premiers tours, il prend une irrigation.". Le cerveau de livraison à chaque fois qu'il a au moins 2 objectifs panda en main, alterne les actions pour essayer de les réaliser à la fois.
-Puisque notre jeu est sans couleur, nous ne pouvions pas implémenter le sabotage des objectifs parcelles; néanmoins nous avons réussi l'implémentation des objectifs pandas et jardinier tout ceci confirmé par des tests.
## 2. Architecture et qualité
Pour plus d'informations ou si vous souhaitez contribuer, consulter le contributing.md et le readme
Les commits sont bien évidemment reliés aux issues


## 3 Processus
Sur un plan global l'ensemble des fonctionnalités a été fait en commun. En termes de valeur : 
Wassim : implémentation cerveau parcelle, amélioration de qualité du code et intégration de sonar, écriture de tests
Brahim : implémentation du cerveau jardinier, du sabotage jardinier, de la détection des placements de parcelles possibles.
Emmanuelle : détection des objectifs parcelles dans tous les sens, création du cerveau Panda, intégration d'objectif vérifier pour détecter les manquants pour un objectif
Amine : implémentation du jardinier, implémentation du panda, déplacements possibles pour le jardinier et le panda, écriture et lecture csv
Notre travail s'est fait avec la création de branches "feature/<nom>" à chaque fois que nous avions une nouvelle fonctionnalité à implémenter. A la fin de l'implémentation, la branche est merge avec master par un système de pull request.


1. This is a numbered list
2. Another item in the list

**This text is bold**
_This text is italic_