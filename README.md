# Projet-Application-Bancaire

Ce repository contient la partie back-end du projet. Elle a été développée sous Eclispe.
Ce projet contient 6 classes:
- banquier avec l'attribut agence
- client avec les attributs : dateNaissance, adresse, mail, nomConseiller, idConseiller
Ces deux classes héritent de la classe UtilisateursCompte qui contient les attributs id, nom et prénom.
- message avec les attributs : id, idEmetteur, idRecepteur, date et contenu.
- virement avec les attributs : id, date, idEmetteur, idRecepteur, montant
- CptBancaire avec les attributs : id, idUtilisateur, IBAN, BIC, solde

La classe client est liée aux classes CptBancaire et message.
La classe banquier est liée à la classe message.
La classe CptBancaire est liée à la classe virement et client.
La classe virement est liée à la classe CptBancaire.
La classe message est liée aux classes banquier et client.

Chaque classe contient plusieurs méthodes. Elles contiennent toutes les métodes d'ajout, de suppression, et de recherche par id.
Les classes banquier, client et cptBancaire contiennent en plus la méthode modifier.
Enfin les classes virement et message contiennent la méthode rechercher par idRecepteur.
