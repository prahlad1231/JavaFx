package demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Demo Login");
        stage.setMinHeight(300);
        stage.setMinWidth(350);    
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(gridPane, 300, 300);
        scene.getStylesheets().add(Login.class.getResource("design.css").toExternalForm());
        stage.setScene(scene);
        
        Text title = new Text("  Welcome");
        title.setId("welcomeText");
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        gridPane.add(title, 0, 0, 2, 1);
        
        Label usernameLabel = new Label("Username: ");
        TextField username = new TextField();
        gridPane.add(usernameLabel, 0, 2);
        gridPane.add(username, 1, 2);
        
        
        Label passwordLabel = new Label("Password: ");
        gridPane.add(passwordLabel, 0, 3);
        PasswordField password = new PasswordField();
        gridPane.add(password, 1, 3);
        
        Button login = new Button("Sign In");
        Button cancel = new Button("Reset");
        VBox button = new VBox(12);
        button.setAlignment(Pos.BOTTOM_RIGHT);
        button.getChildren().addAll(login, cancel);
        gridPane.add(button, 1, 7);
        
        final Text text = new Text();
        text.setId("infoText");
        gridPane.add(text, 0, 8);
        
        // event handling
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String usernameInput = username.getText();
                String passwordInput = password.getText();
                if(usernameInput.equals("Admin") && passwordInput.equals("admin")) {
                    text.setFill(Color.BLUE);  
                    text.setText("Welcome Admin!");
                }
                else {
                    text.setFill(Color.RED);  
                    text.setText("Incorrect username/password!");
                }
            }
        });
        
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                username.setText(null);
                password.setText(null);
                text.setText(null);
            }
        });
        
        stage.show();
    }
    
}
