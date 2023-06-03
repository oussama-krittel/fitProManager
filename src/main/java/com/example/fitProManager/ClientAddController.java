package com.example.fitProManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientAddController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField adhesiondateD;
    @FXML
    private TextField adhesiondateM;
    @FXML
    private TextField adhesiondateY;
    @FXML
    private TextField adresse;
    @FXML
    private TextField birthdateD;
    @FXML
    private TextField birthdateM;
    @FXML
    private TextField birthdateY;
    @FXML
    private ComboBox<?> category;
    @FXML
    private TextField cin;
    @FXML
    private TextField email;
    @FXML
    private TextField firstname;
    @FXML
    private ComboBox<?> gender;
    @FXML
    private TextField lastname;
    @FXML
    private ComboBox<?> offer;

    private Membre getInfoClient(){
         String nom = lastname.getText();
         String prenom = firstname.getText();
         String mail = email.getText();
         String Cin = cin.getText();
         String adress = adresse.getText();
         String sexe = (String) gender.getValue();
         String categorie = (String) category.getValue();
         String Offer = (String) offer.getValue();
         int BDd = Integer.parseInt(birthdateD.getText());
         int BDm = Integer.parseInt(birthdateM.getText());
         int BDy = Integer.parseInt(birthdateY.getText());
         int ADd = Integer.parseInt(adhesiondateD.getText());
         int ADm = Integer.parseInt(adhesiondateM.getText());
         int ADy = Integer.parseInt(adhesiondateY.getText());
         Date birthdate=new  Date(BDd,BDm,BDy);
         Date adesiondate=new  Date(ADd,ADm,ADy);
         Membre client=new Membre(nom,Cin,prenom,mail,adress,"3456789678","F",birthdate,adesiondate);
         return client;
    }


    public void toClients(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Clients.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addClient(){
        Membre newMembre=getInfoClient();
        Module2.ajouterMembre(newMembre);
       // Date d=new Date(19, 07,2002);
       // Membre m=new Membre("nom","Cin","prenom","mail","adresse","2345678","sexe",d,d);
        //Module2.ajouterMembre(m);
        System.out.println("addclient got called");
    }

}
