package com.example.fitProManager;

public class Expiration {
    private Membre membre;
    private Categorie categorie;
    private Date dateExpiration;

    public Expiration(Membre membre, Categorie categorie, Date dateExpiration) {
        this.membre = membre;
        this.categorie = categorie;
        this.dateExpiration = dateExpiration;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
