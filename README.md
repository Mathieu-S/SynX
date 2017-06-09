![logo synx](https://raw.githubusercontent.com/Mathieu-S/SynX/master/src/main/resources/static/img/logo.png)

SynX est une application web conçue pour la gestion de ticket d'incident. C'est à la base un projet scolaire. 
Ce projet a été créé sur une base Spring Boot. Maven est nécessaire à sa compilation.

###Fonctionnalité :
- Affichage et gestion des tickets d'incidents
- Gestion des utilisateurs
- Gestion du matériel

###Démarrer l'application :
Pour démarrer l'application, il vous faut Java 1.8 minimum installé sur votre machine, une base de données MySQL 5 minimum.

Vous devez importer la base de données SynX dans votre MySQL (fichier synx.sql fourni). Une fois l'importation 
terminer,vous devez modifier le fichier application.properties (_il se trouve dans le dossier ressource du projet_) 
avec vos identifiants de base de données.

Une fois ces modifications effectuées, vous pouvez compiler le projet avec Maven. La compilation crée un fichier jar nommé "synx-1.0.jar". L'application peut être exécutée n'importe où telle quelle. Un serveur Tomcat est inutile.

###Se connecter à l'application :
L'accès à l'application se fait sur le port 8080. 
Si l'application est exécutée en local sur votre machine, vous pouvez y accéder grâce à cette URL : [localhost:8080](localhost:8080)
Le compte admin par défaut est admin@synx.com et admin en mot de passe.

**Attention** : Si une exception apparaît au démarrage, vérifier bien la configuration de votre base de données. SynX ne peut pas démarrer sans.
