package com.example.main_project.GUI_Example;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.*;

public class ResponsifLoginPage extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //LayoutUtama
        VBox Layout = new VBox(20);
        Layout.setAlignment(Pos.CENTER);
        Layout.setPadding(new Insets(30));
        Layout.setStyle("-fx-background-color : #87EEB;");

        //Judul
        Text ApplicationName = new Text("EMUY HEALTH");
        ApplicationName.setFont(Font.font("Segoe UI"));
        Text ApplicationMotto = new Text("Stay Healthy With Emuy");

        //Pembuat Responsif Judul
        ApplicationName.styleProperty().bind(Bindings.createStringBinding(()->{
            double FontSize = Math.max(18,primaryStage.getWidth()/20);
            return "-fx-font-size : " + FontSize + "px; -fx-font-weight: bold;";
        },primaryStage.widthProperty()));

        ApplicationMotto.styleProperty().bind(Bindings.createStringBinding(()->{
            double Fontsize = Math.max(10,primaryStage.getWidth()/50);
            return "-fx-font-size : " + Fontsize + "px;";
        },primaryStage.widthProperty()));

        //Kotak Login
        VBox KotakLogin = new VBox(10);
        KotakLogin.setAlignment(Pos.CENTER);
        KotakLogin.setPadding(new Insets(20));
        KotakLogin.setStyle("-fx-background-color: white;-fx-background-radius: 10px;");
        KotakLogin.setMinWidth(300);

        //Isi Kotak Login
        Label TulisanLogin = new Label("Login");
        TulisanLogin.setFont(Font.font("Segoe UI;"));
        TulisanLogin.setStyle("-fx-font-weight : bold;");
        Label TulisanUsername = new Label("Username");
        Label TulisanPassword = new Label("Password");
        TextField TabelUsername = new TextField();
        PasswordField TabelPassword = new PasswordField();


        TulisanLogin.setFont(Font.font("Segoe UI", 15));

        TabelUsername.setPromptText("Username");
        TabelUsername.setStyle("-fx-background-color : #f0f0f0; -fx-background-radius : 5px;");
        TabelPassword.setPromptText("Password");
        TabelPassword.setStyle("-fx-background-color : #f0f0f0; -fx-background-radius : 5px;");
        //Pembuat Responsif Kotak Login
        KotakLogin.maxWidthProperty().bind(primaryStage.widthProperty().multiply(0.2));

        HBox BtnBox = new HBox(10);
        BtnBox.setAlignment(Pos.CENTER);
        Button LoginBtn = new Button("Login");
        Button SignUpBtn = new Button("SignUp");

        LoginBtn.setStyle("-fx-background-color: #1e90ff; -fx-text-fill: white; -fx-background-radius: 5px;");
        SignUpBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #1e90ff; -fx-border-color: #1e90ff; -fx-border-radius: 5px;");
        BtnBox.getChildren().addAll(LoginBtn,SignUpBtn);

        KotakLogin.getChildren().addAll(
                TulisanLogin,
                TulisanUsername,
                TabelUsername,
                TulisanPassword,
                TabelPassword,
                BtnBox
        );

        Layout.getChildren().addAll(ApplicationName,ApplicationMotto,KotakLogin);

        //Pengaturan Scene
        Scene scene1 = new Scene(Layout,600,300);
        primaryStage.setTitle("Emuy Corporation");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }
}
