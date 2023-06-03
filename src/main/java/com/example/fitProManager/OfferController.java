
package com.example.fitProManager;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        import java.io.IOException;

public class OfferController {
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
    public void toClients(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Clients.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void toAddOffer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addOffer.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void toViewOffer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewOffer.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void toLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
