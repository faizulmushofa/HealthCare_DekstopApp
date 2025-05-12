package com.example.main_project.GUI_Example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EmuyHealthLogin extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main container
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #87EEB;"); // Light blue background

        // Content container
        HBox contentBox = new HBox(50);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setPadding(new Insets(20));

        // Left section with logo and title
        VBox leftSection = new VBox(10);
        leftSection.setAlignment(Pos.CENTER);

        // Title
        Text title = new Text("EMUY HEALTH");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Rabbit silhouette using SVG path
        SVGPath rabbitSilhouette = new SVGPath();
        rabbitSilhouette.setContent("M50,10 C45,0 35,0 30,10 C25,0 15,0 10,10 C10,30 10,70 15,90 "
                + "C25,100 35,100 45,90 C50,70 50,30 50,10 Z "
                + "M20,35 C15,40 15,45 20,50 C25,45 25,40 20,35 Z "
                + "M40,35 C35,40 35,45 40,50 C45,45 45,40 40,35 Z");
        rabbitSilhouette.setFill(Color.BLACK);
        rabbitSilhouette.setScaleX(1.5);
        rabbitSilhouette.setScaleY(1.5);

        // Footer text
        Text footer = new Text("Jalan move like rabbit but stay healthy, ****");
        footer.setFont(Font.font("Arial", 10));

        leftSection.getChildren().addAll(title, rabbitSilhouette, footer);

        // Right section with login form
        VBox rightSection = new VBox(10);
        rightSection.setStyle("-fx-background-color: white; -fx-padding: 20px; -fx-background-radius: 10px;");
        rightSection.setMaxWidth(250);
        rightSection.setAlignment(Pos.TOP_CENTER);

        // Login title
        Label loginLabel = new Label("Login");
        loginLabel.setFont(Font.font("Arial", 14));

        // Username field
        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();
        usernameField.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 5px;");

        // Password field
        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 5px;");

        // Buttons container
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        // Login button
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #1e90ff; -fx-text-fill: white; -fx-background-radius: 5px;");
        loginButton.setPrefWidth(80);

        // Sign up button
        Button signUpButton = new Button("Sign up");
        signUpButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #1e90ff; -fx-border-color: transparent;");

        buttonBox.getChildren().addAll(loginButton, signUpButton);

        rightSection.getChildren().addAll(loginLabel, usernameLabel, usernameField,
                passwordLabel, passwordField, buttonBox);

        contentBox.getChildren().addAll(leftSection, rightSection);
        root.getChildren().add(contentBox);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Emuy Health");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}