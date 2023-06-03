package com.example.fitProManager;

public class Main {
    public static void main(String[] args) {
        System.out.println(Module2.getMembres("SELECT * FROM membre").get(0).getNom());
        Date d=new Date(19, 07,2002);
        Membre m=new Membre("nom","Cin","prenom","mail","adresse","2345678","sexe",d,d);
        Module2.ajouterMembre(m);
        //System.out.println(Module2.getInscriptions("SELECT * FROM inscription").get(0).getDateInscription().getJour());
        //System.out.println(Module2.getCategorie("SELECT * FROM categorie").get(0).getNomCategorie());
       // System.out.println(Module2.getOffres("SELECT * FROM offre").get(0).getCategorie().getIdCategorie());


        /*
        Date datenaissance = new Date(11 , 12 , 2000);
        Date dateAdherence = new Date(11 , 12 , 2020);
        Membre membre = new Membre("Oussama", "BH345234", "Krittel", "r@gmail.com", "jhvj" ,
                "767875" , "H" , datenaissance , dateAdherence );
        Module.ajouterMembre(membre);

        Categorie categorie = new Categorie("Bascketball");
        Module.ajouterCategorie(categorie);

        Categorie categorie2 = Module.getCategorie("SELECT * FROM categorie").get(0);
        Offre offre = new Offre("3 mois (Foot)", "250dh" , 90 , categorie2);
        Module.ajouterOffre(offre);

        Offre offre2 = Module.getOffres("SELECT * FROM offre").get(0);
        Membre membre2 = Module.getMembres("SELECT * FROM membre").get(0);
        Date datenaissance = new Date(11 , 12 , 2000);
        Inscription inscription = new Inscription(offre2, membre2, datenaissance);
        Module.ajouterInsciption(inscription);

        */

        /*
        Date datenaissance = new Date(11 , 12 , 2000);
        Date dateAdherence = new Date(11 , 12 , 2020);
        Membre membre = new Membre("Oussama", "BH345234", "Krittel", "f@gmail.com", "jhvj" ,
                "767875" , "H" , datenaissance , dateAdherence );
        Module.modifierMembre(2,membre);

        Categorie categorie = new Categorie("Yoga");
        Module.modifierCategorie(3,categorie);

        Categorie categorie2 = Module.getCategorie("SELECT * FROM categorie").get(0);
        Offre offre = new Offre("3 mois (Foot)", "470dh" , 90 , categorie2);
        Module.modifierOffre(3,offre);

        */
        /*
        Module.supprimerMembre(2);

        Module.supprimerCategorie(4);

        Module.supprimerOffre(4);
         */












    }
}