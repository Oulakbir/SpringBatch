# Spring Batch Job : Traitement des Commandes

## Description

Ce projet implémente un job **Spring Batch** pour traiter une liste de commandes à partir d'un fichier CSV. L'objectif est de transformer les données des commandes en appliquant une remise sur le montant et de sauvegarder les données mises à jour dans une base de données **HSQLDB**. Le job affiche également les commandes insérées à la fin de l'exécution.

---

## Fonctionnalités

1. **Lecture des données** : Les commandes sont lues à partir d'un fichier `orders.csv` utilisant un `FlatFileItemReader`.
2. **Transformation des données** : Une remise de **10%** est appliquée au montant (`amount`) de chaque commande.
3. **Écriture des données** : Les commandes transformées sont sauvegardées dans une base de données HSQLDB.
4. **Affichage des résultats** : Les commandes insérées sont affichées dans le terminal après la fin du job grâce à un `JobCompletionNotificationListener`.

---

## Prérequis

- **Java 17**
- **Spring Boot 2.5+**
- **HSQLDB**
- **Maven**

---

## Structure du Projet

```
├── src/main/java
│   ├── com.example.batch
│   │   ├── BatchConfig.java          # Configuration du job Spring Batch
│   │   ├── Order.java                # Classe représentant une commande
│   │   ├── OrderProcessor.java       # Transforme les données en appliquant la remise
│   │   ├── OrderReader.java          # Lit les commandes depuis le fichier CSV
│   │   ├── OrderWriter.java          # Écrit les commandes transformées dans la base
│   │   └── JobCompletionListener.java# Affiche les commandes insérées
├── src/main/resources
│   ├── application.properties        # Configuration de l'application et HSQLDB
│   └── orders.csv                    # Fichier contenant les commandes initiales
```

---

## Guide d'Exécution

1. **Cloner le projet** :
   ```bash
   git clone https://github.com/Oulakbir/SpringBatch.git
   cd SpringBatch
   ```

2. **Configurer les propriétés** :
   Modifiez `src/main/resources/application.properties` si nécessaire (par exemple, pour configurer la base de données).

3. **Exécuter le job** :
   ```bash
   mvn spring-boot:run
   ```

4. **Vérifier les résultats** :
   - Les commandes mises à jour seront enregistrées dans la base de données.
   - Les commandes insérées s'afficheront dans le terminal.

---

## Exemple de Résultats

### Input : Fichier `orders.csv`
```csv
orderId,customerName,amount
1,John Doe,100
2,Jane Smith,200
3,Sam Wilson,300
```
Vous pouvez trouvez un fichier csv dans mon projet appelé 'orders.csv' et travaillez avec !!

### Output : Console

Job Terminé avec succès !
![Screenshot 2024-12-18 173217](https://github.com/user-attachments/assets/7a51d381-4675-4791-b873-edbc8687f81b)

Commandes insérées :

![Screenshot 2024-12-18 173228](https://github.com/user-attachments/assets/3f5fa793-ee96-4a39-add8-747415228eb5)

---

## Auteur

- **[Ilham OULAKBIR]**
