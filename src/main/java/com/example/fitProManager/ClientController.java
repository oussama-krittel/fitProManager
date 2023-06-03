package com.example.fitProManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ClientController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void toHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void toCategories(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Categories.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toOffers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Offers.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void toAddClient(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addClient.fxml")));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println("the prbleme is to add clients "+e);
        }
    }
    @FXML
    public void toViewClient(ActionEvent event){
       try{
           Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ViewClient.fxml")));
           stage=(Stage)((Node)event.getSource()).getScene().getWindow();
           scene=new Scene(root);
           stage.setScene(scene);
           stage.show();
       }catch (IOException e){
           System.out.println("the problem is in to View client "+e);
       }
    }
    public void toLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void toClients(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Clients.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}