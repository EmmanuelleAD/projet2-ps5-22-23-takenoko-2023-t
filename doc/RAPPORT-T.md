# Rapport Takenoko - Équipe T

### BARATLI Wassim – ACHEHBOUNE Mohammed Amine - ADOTE Adjo Emmanuelle - AKHYATE Brahim


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

### 1. Comment est faite l'architecture du projet ? Et quels choix vous ont amené à la réaliser ainsi ?

- Le projet est divisé en 2 parties : la partie base (Personnages + élement du jeu) et la partie intelligence (classes Cerveau) + la partie Jeu (class Jeu et main)
- Tout d'abbord, nous avons commencé par créer un MVP du jeu composé seulement de bots random et de parcelles ayant des positions. Puis nous avons crées des objectifs et des actions, construits tout deux à partir d'une classe abstraite mère (Objectif et Action) desquelles découlent les objectifs et les actions particuliers. Nous avons fait ce choix car cela semblait plus cohérent et surtout pour que les objectifs et les actions aient la même structure. De plus, cela nous a permis de profiter des avantages du polymorphisme pour ne pas avoir à faire des casts multiples et réinstancier la même méthode à chaque fois.
- Ensuite, nous avons crée les personnages Panda et Jardinnier en utlisant là aussi une classe abstraite mère personnage afin de regrouper des caractéristiques communes comme le nom et le déplacement en ligne droite. Ainsi nous avons par la suite crée les objectifs et action Jardinnier et Panda en introduisant également les bambous comme un objet à part entière. De cette manière l'architecture de notre projet nous permettait de créer petit à petit des objectifs et des actions en fonction de nos besoins.
- Or plus le nombre d'objectifs et d'actions augmentait, plus il était difficile de gérer les interactions entre les personnages et les objectifs puisqu'il fallait valider les objectifs des joueurs en leur accordant des points. Nous avons donc crée une classe ObjectifVerifier qui permet de stocker la verification d'un objectif et stoker les éléments manquants pour valider l'objectif. Nous avons là aussi utilisé le polymorphisme en créeant une classe mère ObjectifVerifier.
- Pour ce qui est de l'intelligence, nous avions plusieurs possibilités pour l'introduire dans le jeu : soit d'introduire l'intelligence dans la classe joueur ou créer des cerveaux à part entière que pourraient avoir les joueurs. C'est finalement cette option que nous avons choisi. Pour cela nous avons de nouveau utilisé le polymorphisme en créant une classe mère Cerveau qui a les méthodes decider et verifierObjectif. Nous avons ensuite crée des classes filles CerveauRandom, CerveauLivraison et CerveauDemo qui héritent de Cerveau et qui implémentent les méthodes décider et verifierObjectif. Nous avons fait ce choix car cela nous permettait de créer des cerveaux différents et de les tester facilement.
- La classe Read CSV er Writing ont la responsabilité de gérer l'écriture et la modification des statistiques sur le fichier CSV.
- Le moteur du Jeu est situé dans la classe Jeu. Cette classe instancie plusieurs joueurs doté ou non de cerveaux, un plateau de parcelles, une pioche de carte objectif, ainsi que tous les peronnages du jeu. Cette classe est responsable de la gestion des tours, de la gestion des objectifs et des actions, ainsi que de l'attribution du score de chaque joueur.
- Pour la partie test, les tests unitaires ont été écrits pour chaque classe et méthode. Nous avons utilisé JUnit pour les tests unitaires. Nous avons également utilisé JCommander pour les tests d'intégration car cela nous permettait de tester les arguments en ligne de commande.


### 2. Où trouver les infos (de la java doc, de la doc sur les points et les classes importants ?)
- Le readme contient la description générale du Jeu, ainsi que les instructions pour lancer le jeu et les tests.
- Le contributing contient les instructions pour contribuer au projet.
- Le code est plus ou moins commenté et nous avons essayé de nommer les variables et les méthodes de manière claire et explicite.
- Les tests unitaires sont dans le dossier test.



### 3. Etat de la base de code : quelles parties sont bien faites ? Quelles parties sont à refactor et pourquoi ? Comment la sortie SONAR le montre-elle (ou pas) ?
- Le code est plus ou moins commenté et nous avons essayé de nommer les variables et les méthodes de manière claire et explicite.
- Les tests unitaires sont dans le dossier test. Chaque classe de tests avec ses tests ; des tests de cas généraux et particuliers .
- CE QUI EST BIEN : LES ACTIONS, LES OBJECTIFS,LES CERVEAU .Dans les classes Actions et Objectifs nous avons réussi à réaliser de bonnes abstactions qui nous ont permis de profiter du polymorphisme et d'éviter des casts redondants.Nous avons par exemple une méthode traiter dans Action qui est redéfini par toutes les classes filles et qui s'adapte au comportement attendu.
Les classes CERVEAU ont également une bonne implémentation avec l'encapsulation de méthodes générales dans la classe mère et leurs utilisations dans les classes filles.Nous avons également fait l'éffort d'orienter le plus possible nos classes Cerveau vers un comportement humain en créant des méthodes comme piocherUneCarte, placerUneParcelle .
- CE QUI EST A REFACTOR :  La classe OBJECTIFPARCELLE .Dans la classe OBJECTIFPARCELLE, il faut refactor les méthodes de détection des motifs.Ces dernierères poourraient être moins nombreuses et optimisées en matière de performance.Il faudrait également déplacer les méthodes qui fournissent les parcelles manquantes dans une autre classe afin de respecter le prinicpe de responsabilité unique.
- Nous avons utilisé Sonar pour analyser notre code. Nous avons obtenu un score de 0% de bugs, 0% de vulnérabilités, 0,8% de code dupliqué, 170 unit test et un coverage de 83%




## 3 Processus

### 1. Organisation

Sur un plan global l'ensemble des fonctionnalités a été fait en commun. En termes de valeur :
- Wassim : implémentation cerveau parcelle, amélioration de qualité du code et intégration de sonar, écriture de tests
- Brahim : implémentation du cerveau jardinier, du sabotage jardinier, de la détection des placements de parcelles possibles.
- Emmanuelle : détection des objectifs parcelles dans tous les sens, création du cerveau Panda, intégration d'objectif vérifier pour détecter les manquants pour un objectif
- Amine : implémentation du jardinier, implémentation du panda, déplacements possibles pour le jardinier et le panda, écriture et lecture csv

- Notre travail s'est fait avec la création de branches "feature/<nom>" à chaque fois que nous avions une nouvelle fonctionnalité à implémenter. A la fin de l'implémentation, la branche est merge avec master par un système de pull request.

### 2. Rétrospective

- Le début du projet était un peu compliqué car nous n'avions pas encore bien compris comment bien créer les issues et les milestones. Nous avons eu quelques difficultés à nous organiser au début. Au fur et 
- Nous avons eu des difficultés à gérer les conflits de merge entre les branches. Nous avons donc décidé de faire des pull request pour chaque fonctionnalité implémentée afin de pouvoir merger les branches plus facilement.


### 2. Points à améliorer
- Améliorer communication dans l'équipe, travail à distance pas toujours évident, améliorer le découpage des fonctionnalités
