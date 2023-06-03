package com.example.fitProManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Module2 {
    public static Connection connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/gymdatabase?useSSL=false";
            String username = "root";
            String password = "";

            // Establish the connection
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
    // Membres :
    public static List<Membre> getMembres(String query){
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = Module2.connect();

            // Create a statement object
            stmt = conn.createStatement();

            // Execute a query to retrieve all books
            rs = stmt.executeQuery(query);

            // Create an array to store the books
            List<Membre> membres = new ArrayList<Membre>();

            // Process the result set and populate the array
            while (rs.next()) {
                int id = rs.getInt("idMembre");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                String tel = rs.getString("tel");
                String sexe = rs.getString("sexe");
                int jourNaissance = rs.getInt("jourNaissance");
                int moisNaissance = rs.getInt("moisNaissance");
                int anneeNaissance = rs.getInt("anneeNaissance");
                int jourAdherence = rs.getInt("jourNaissance");
                int moisAdherence = rs.getInt("moisNaissance");
                int anneeAdherence = rs.getInt("anneeNaissance");
                com.example.fitProManager.Date dateNaissance = new com.example.fitProManager.Date(jourNaissance, moisNaissance, anneeNaissance);
                com.example.fitProManager.Date dateAdherence = new com.example.fitProManager.Date(jourAdherence, moisAdherence, anneeAdherence);

                Membre membre = new Membre(id, nom, prenom, email, adresse, tel, sexe, dateNaissance, dateAdherence);
                membres.add(membre);
            }
            return membres;

        }catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public static void ajouterMembre(Membre membre){

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = Module2.connect();

            // Prepare the SQL statement with parameters
            String sql = "INSERT INTO membre (nom, prenom, email, adresse, tel, sexe" +
                    ", jourNaissance, moisNaissance, anneeNaissance, jourAdherence, moisAdherence, anneeAdherence , cin)" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            // Set the parameter values for the book

            stmt.setString(1, membre.getNom());
            stmt.setString(2, membre.getPrenom());
            stmt.setString(3, membre.getEmail());
            stmt.setString(4, membre.getAdresse());
            stmt.setString(5, membre.getTel());
            stmt.setString(6, membre.getSexe());
            stmt.setInt(7, membre.getDateNaissance().getJour());
            stmt.setInt(8, membre.getDateNaissance().getMois());
            stmt.setInt(9, membre.getDateNaissance().getAnnée());
            stmt.setInt(10, membre.getDateAdherence().getJour());
            stmt.setInt(11, membre.getDateAdherence().getMois());
            stmt.setInt(12, membre.getDateAdherence().getAnnée());
            stmt.setString(13, membre.getCin());


            // Execute the INSERT statement
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            // Close all resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void modifierMembre(int id , Membre newmembre){

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            // Establish the connection
            conn = Module2.connect();

            // Prepare the SQL statement with parameters
            String sql = "UPDATE membre SET nom = ?, prenom = ?, email = ?, adresse = ?, tel = ?, sexe = ?, " +
                    "jourNaissance = ?, moisNaissance = ?, anneeNaissance = ?, jourAdherence = ?, moisAdherence = ?, " +
                    "anneeAdherence = ? , cin = ?  WHERE idMembre = ?";
            stmt = conn.prepareStatement(sql);

            // Set the parameter values for the member
            stmt.setString(1, newmembre.getNom());
            stmt.setString(2, newmembre.getPrenom());
            stmt.setString(3, newmembre.getEmail());
            stmt.setString(4, newmembre.getAdresse());
            stmt.setString(5, newmembre.getTel());
            stmt.setString(6, newmembre.getSexe());
            stmt.setInt(7, newmembre.getDateNaissance().getJour());
            stmt.setInt(8, newmembre.getDateNaissance().getMois());
            stmt.setInt(9, newmembre.getDateNaissance().getAnnée());
            stmt.setInt(10, newmembre.getDateAdherence().getJour());
            stmt.setInt(11, newmembre.getDateAdherence().getMois());
            stmt.setInt(12, newmembre.getDateAdherence().getAnnée());
            stmt.setString(13, newmembre.getCin());
            stmt.setInt(14, id);


            // Execute the UPDATE statement
            stmt.executeUpdate();


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void supprimerMembre(int id){

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            conn = Module2.connect();

            // Prepare the SQL statement with parameter
            String sql = "DELETE FROM membre WHERE idMembre = ?";
            stmt = conn.prepareStatement(sql);

            // Set the parameter value for the member's ID
            stmt.setInt(1, id);

            // Execute the DELETE statement
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    // Inscriptions :
    public static List<Inscription> getInscriptions(String query){
        Statement stmt = null;
        Statement stmt2 = null;
        Statement stmt3 = null;
        Statement stmt4 = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = Module2.connect();

            // Create a statement object
            stmt = conn.createStatement();


            // Execute a query to retrieve all books
            rs = stmt.executeQuery(query);

            // Create an array to store the books
            List<Inscription> inscriptions = new ArrayList<Inscription>();

            // Process the result set and populate the array
            while (rs.next()) {
                int idInscription = rs.getInt("idInscription");

                //Get offre
                int idOffre = rs.getInt("idOffre");
                Offre offre = getOffres("SELECT * FROM offre where idOffre =" + idOffre).get(0);

                //Get Membre
                int idMembre = rs.getInt("idMembre");
                Membre membre = getMembres("SELECT * FROM membre where idMembre=" + idMembre).get(0);

                //Get DateInscription
                int jourInsciption = rs.getInt("jourInscription");
                int moisInsciption = rs.getInt("moisInscription");
                int anneeInsciption = rs.getInt("anneeInscription");
                com.example.fitProManager.Date dateInscription = new com.example.fitProManager.Date(jourInsciption, moisInsciption, anneeInsciption);

                //Create inscription and add it :
                Inscription inscription = new Inscription(idInscription, offre, membre, dateInscription);
                inscriptions.add(inscription);

            }
            return inscriptions;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public static void ajouterInsciption(Inscription inscription){

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = Module2.connect();

            // Prepare the SQL statement with parameters
            String sql = "INSERT INTO inscription ( jourInscription, moisInscription, anneeInscription," +
                    "idMembre , idOffre)" +
                    " VALUES (?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            // Set the parameter values for the book

            stmt.setInt(1, inscription.getDateInscription().getJour());
            stmt.setInt(2, inscription.getDateInscription().getMois());
            stmt.setInt(3, inscription.getDateInscription().getAnnée());
            stmt.setInt(4, inscription.getMembre().getIdPersonne());
            stmt.setInt(5, inscription.getOffre().getIdOffre());

            // Execute the INSERT statement
            stmt.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //Offre :
    public static List<Offre> getOffres(String query) {

        Connection conn = null;
        Statement stmt = null;

        ResultSet rs = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = Module2.connect();
            // Create a statement object
            stmt = conn.createStatement();

            // Execute a query to retrieve all books
            rs = stmt.executeQuery(query);

            // Create an array to store the books
            List<Offre> offres = new ArrayList<Offre>();

            // Process the result set and populate the array
            while (rs.next()) {

                int idOffre = rs.getInt("idOffre");
                String nomOffre = rs.getString("nomOffre");
                String prixOffre = rs.getString("prixOffre");
                int dureeOffre = rs.getInt("dureeOffre");
                int idCategorie = rs.getInt("idCategorie");
                String query2 = "SELECT * FROM categorie where idCategorie=" + idCategorie;
                Categorie categorie = Module2.getCategorie(query2).get(0);


                Offre offre = new Offre(idOffre, nomOffre, prixOffre, dureeOffre, categorie);
                offres.add(offre);
            }
            return offres;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    public static void ajouterOffre(Offre offre) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = Module2.connect();
            // Prepare the SQL statement with parameters
            String sql = "INSERT INTO offre (nomOffre, prixOffre, dureeOffre, idCategorie)" +
                    " VALUES (?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            // Set the parameter values for the offre
            stmt.setString(1, offre.getNomOffre());
            stmt.setString(2, offre.getPrixOffre());
            stmt.setInt(3, offre.getDureeOffre());
            stmt.setInt(4, offre.getCategorie().getIdCategorie());

            // Execute the INSERT statement
            stmt.executeUpdate();

            // Close the statement
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void supprimerOffre(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;

        // Close all resources
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = Module2.connect();

            // Prepare the SQL statement with parameter
            String sql = "DELETE FROM offre WHERE idOffre = ?";
            stmt = conn.prepareStatement(sql);

            // Set the parameter value for the member's ID
            stmt.setInt(1, id);

            // Execute the DELETE statement
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void modifierOffre(int id, Offre newOffre) {

        Connection conn = null;
        PreparedStatement stmt = null;

        // Close all resources
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = Module2.connect();

            // Prepare the SQL statement with parameters
            String sql = "UPDATE offre SET nomOffre = ?, prixOffre = ?, dureeOffre = ?, idCategorie = ? WHERE idOffre = ?;";
            stmt = conn.prepareStatement(sql);

            // Set the parameter values for the member
            stmt.setString(1, newOffre.getNomOffre());
            stmt.setString(2, newOffre.getPrixOffre());
            stmt.setInt(3, newOffre.getDureeOffre());
            stmt.setInt(4, newOffre.getCategorie().getIdCategorie());
            stmt.setInt(5, id);

            // Execute the UPDATE statement
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
                e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //Categorie :
    public static void ajouterCategorie(Categorie categorie) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = Module2.connect();

            // Prepare the SQL statement with parameters
            String sql = "INSERT INTO categorie (nomCategorie)" +
                    " VALUES (?)";
            stmt = conn.prepareStatement(sql);

            // Set the parameter values for the offre
            stmt.setString(1, categorie.getNomCategorie());

            // Execute the INSERT statement
            stmt.executeUpdate();

            // Close the statement
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static List<Categorie> getCategorie(String query) {

        Connection conn = null;
        Statement stmt = null;

        ResultSet rs = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = Module2.connect();

            // Create a statement object
            stmt = conn.createStatement();

            // Execute a query to retrieve all books
            rs = stmt.executeQuery(query);

            // Create an array to store the books
            List<Categorie> categories = new ArrayList<Categorie>();

            // Process the result set and populate the array
            while (rs.next()) {

                int idCategorie = rs.getInt("idCategorie");
                String nomCategorie = rs.getString("nomCategorie");

                Categorie categorie = new Categorie(idCategorie, nomCategorie);

                categories.add(categorie);
            }
            return categories;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            // Close all resources
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;

    }

    public static void modifierCategorie(int id, Categorie newCategorie) {

        Connection conn = null;
        PreparedStatement stmt = null;

        // Close all resources
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = Module2.connect();

            // Prepare the SQL statement with parameters
            String sql = "UPDATE categorie SET nomCategorie = ? WHERE idCategorie = ?";
            stmt = conn.prepareStatement(sql);

            // Set the parameter values for the member
            stmt.setString(1, newCategorie.getNomCategorie());
            stmt.setInt(2, id);


            // Execute the UPDATE statement
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            // Close all resources
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void supprimerCategorie(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;

        // Close all resources
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = Module2.connect();

            // Prepare the SQL statement with parameter
            String sql = "DELETE FROM categorie WHERE idCategorie = ?";
            stmt = conn.prepareStatement(sql);

            // Set the parameter value for the member's ID
            stmt.setInt(1, id);

            // Execute the DELETE statement
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            // Close all resources
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}




