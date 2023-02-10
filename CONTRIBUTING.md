# Contributing to CONTRIBUTING.md

Nous tenons à vous remercier pour votre désir de contribuer !


> Si vous souhaitez contribuer au projet, mais vous n'avez pas assez de temps. Il y a des moyens simples comme :
> - Mettez une étoile
> - Faire un tweet sur le projet
> - Référez-vous à ce projet dans le fichier readme de votre projet
> - Mentionnez le projet lors de rencontres locales et parlez-en à vos amis/collègues


## Table du contenu

- [Code de Conduite](#code-de-conduite)
- [J'ai une Question](#jai-une-question)
- [Je veux contribuer](#je-veux-contribuer)
- [Reporter des Bugs](#reporter-des-bugs)
- [Suggérer des améliorations](#suggérer-des-améliorations)
- [Messages de commit](#messages-de-commit)
- [Joindre l'équipe](#joindre-léquipe)


## Code de Conduite

Ce projet et tout ce qui y contribuent doivent respecter les règles [ci-contre](CODE_OF_CONDUCT.md).



## J'ai une question


Avant de poser une question s'assurer qu'il n'existe pas d'issue en rapport avec la question [Issues](/issues) ?Si oui posez la question dans l'issue trouvée,sinon créer une issue et poser votre question.

- Ouvrir la section des Issues.
- Fournir le plus d'infos et de détails possibles

Nous vous répondrons le plus tôt possible.



## Je veux contribuer


### Reporter des Bugs


#### Avant de soumettre un rapport de bug

Un bon rapport de bug ne devrait pas obliger les autres à vous pourchasser pour plus d'informations.
Par conséquent, nous vous demandons d'enquêter attentivement, de collecter des informations et de décrire le problème en détail dans votre rapport. Veuillez effectuer les étapes suivantes à l'avance pour nous aider à corriger tout bogue potentiel le plus rapidement possible.

- Assurez-vous que vous utilisez la dernière version.
- Déterminez si votre bogue est vraiment un bogue et non une erreur de votre côté, par ex. en utilisant des composants/versions d'environnement incompatibles (Assurez-vous d'avoir lu la [documentation](). Si vous recherchez de l'aide, vous pouvez consulter [cette section](#j'ai-une-question)).
- Pour voir si d'autres utilisateurs ont rencontré (et potentiellement déjà résolu) le même problème que vous, vérifiez s'il n'y a pas déjà un rapport de bogue existant pour votre bogue ou erreur dans le [bug tracker](issues?q=label%3Abug ).
- Assurez-vous également de rechercher sur Internet (y compris Stack Overflow) pour voir si des utilisateurs extérieurs à la communauté GitHub ont discuté du problème.
- Collecter des informations sur le bug :
- Suivi de la pile (Traceback)
- Système d'exploitation, plate-forme et version (Windows, Linux, macOS, x86, ARM)
- Version de l'interpréteur, du compilateur, du SDK, de l'environnement d'exécution, du gestionnaire de packages, selon ce qui semble pertinent.
- Eventuellement votre entrée et la sortie
- Pouvez-vous reproduire le problème de manière fiable ? Et pouvez-vous également le reproduire avec des versions plus anciennes ?


#### Comment soumettre un bon rapport de bug ?

> Vous ne devez jamais signaler des problèmes, des vulnérabilités ou des bogues liés à la sécurité, y compris des informations sensibles, au traqueur de problèmes ou ailleurs en public. Au lieu de cela, les bogues sensibles doivent être envoyés par e-mail à <Emmanuelle ADOTE>.


Nous utilisons les issues GitHub pour suivre les bogues et les erreurs. Si vous rencontrez un problème avec le projet :

- Ouvrez un [Problème](/issues/new). (Puisque nous ne pouvons pas être sûrs à ce stade s'il s'agit d'un bogue ou non, nous vous demandons de ne pas encore parler d'un bogue et de ne pas étiqueter le problème.)
- Expliquez le comportement auquel vous vous attendez et le comportement réel.
- Veuillez fournir autant de contexte que possible et décrire les *étapes de reproduction* que quelqu'un d'autre peut suivre pour recréer le problème par lui-même. Cela inclut généralement votre code. Pour de bons rapports de bogues, vous devez isoler le problème et créer un cas de test réduit.
- Fournissez les informations que vous avez recueillies dans la section précédente.

Une fois déposé :

- L'équipe du projet étiquettera le problème en conséquence.
- Un membre de l'équipe essaiera de reproduire le problème avec les étapes fournies. S'il n'y a pas d'étapes de reproduction ou aucun moyen évident de reproduire le problème, l'équipe vous demandera ces étapes et marquera le problème comme "nécessite-repro". Les bogues avec la balise "needs-repro" ne seront pas traités tant qu'ils ne seront pas reproduits.
  -Si l'équipe est en mesure de reproduire le problème, celui-ci sera marqué "à corriger", ainsi qu'éventuellement d'autres balises (telles que "critique"), et le problème sera laissé pour être [implémenté par quelqu'un](# votre-première-contribution-de-code).
### Suggérer des améliorations

Cette section vous guide tout au long de la soumission d'une suggestion d'amélioration pour CONTRIBUTING.md, **incluant des fonctionnalités entièrement nouvelles et des améliorations mineures aux fonctionnalités existantes**. Suivre ces directives aidera les mainteneurs et la communauté à comprendre votre suggestion et à trouver des suggestions connexes.


#### Avant de soumettre une amélioration

- Assurez-vous que vous utilisez la dernière version.
- Consulter la liste des milestones et découvrez si la fonctionnalité est déjà couverte, peut-être par une configuration individuelle.
- Effectuez une [recherche](/issues) pour voir si l'amélioration a déjà été suggérée. Si c'est le cas, ajoutez un commentaire au problème existant au lieu d'en ouvrir un nouveau.
- Découvrez si votre idée correspond à la portée et aux objectifs du projet. À vous de monter un dossier solide pour convaincre les développeurs du projet du bien-fondé de cette fonctionnalité. Gardez à l'esprit que nous voulons des fonctionnalités qui seront utiles à la majorité de nos utilisateurs et pas seulement à un petit sous-ensemble. Si vous ne ciblez qu'une minorité d'utilisateurs, envisagez d'écrire une bibliothèque de modules complémentaires/plugins.


#### Comment soumettre une bonne suggestion d'amélioration ?

Les suggestions d'amélioration sont suivies en tant que [problèmes GitHub](/issues).

- Utilisez un **titre clair et descriptif** pour le problème afin d'identifier la suggestion.
- Fournissez une **description étape par étape de l'amélioration suggérée** avec autant de détails que possible.
- **Décrivez le comportement actuel** et **expliquez quel comportement vous attendiez à la place** et pourquoi.
- À ce stade, vous pouvez également indiquer les alternatives qui ne fonctionnent pas pour vous.
- Vous pouvez **inclure des captures d'écran et des GIF animés** qui vous aident à démontrer les étapes ou à indiquer la partie à laquelle la suggestion est liée.
- Vous pouvez utiliser [cet outil](https://www.cockos.com/licecap/) pour enregistrer des GIF sur macOS et Windows, et [cet outil](https://github.com/colinkeenan/silentcast) ou [cet outil](https://github.com/GNOME/byzanz) sous Linux.
- **Expliquez pourquoi cette amélioration serait utile** à la plupart des utilisateurs de CONTRIBUTING.md. Vous pouvez également signaler les autres projets qui l'ont mieux résolu et qui pourraient servir d'inspiration.

### Messages de commit
Les commits doivent respecter certaines règles. Chaque commit doit être relié à une issue.
Il doit être précédé du type de commit comme ceci `type:`
Les types possibles sont feat,fix,refactor ...
Pour faire un commit conforme
``git commit -m "type: message #issue"``


## Joindre l'équipe
Pour joindre l'équipe joindre un membre de l'équipe et lui soumettre la demande ;



## Attribution
Ce guide est basé sur le **contributing.md**. [contributing](https://contributing.md/)!
