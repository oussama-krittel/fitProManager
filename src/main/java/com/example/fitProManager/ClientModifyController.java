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

public class ClientModifyController {
    @FXML
    private TextField adhesiondated;
    @FXML
    private TextField adhesiondatem;
    @FXML
    private TextField adhesiondatey;
    @FXML
    private TextField adress;
    @FXML
    private TextField birthdated;
    @FXML
    private TextField birthdatem;
    @FXML
    private TextField birthdatey;
    @FXML
    private ComboBox<?> categorie;
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
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void toClients(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Clients.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
}
    @FXML
    private void initialize() {
        // Code to execute when the FXML file is loaded
        System.out.println("FXML file loaded");
        // Call your desired function here
        filForm();
    }
    public void filForm(){
        firstname.setText("oussama");
        lastname.setText("krittel");
        email.setText("kloussama04@gmail.com");
        cin.setText("DJ466400");
        adress.setText("tilila agadir morroco");
    }
}
