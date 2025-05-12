package com.example.main_project.GUI_Example;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.application.Application;

public class LoginPage extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    Stage Stage1;
    static String Warning;
    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage1 = primaryStage;
        //Warna Background
        StackPane Layout = new StackPane();
        Layout.setPadding(new Insets(20));
        Layout.setStyle("-fx-background-color: #87EEB;");
        Layout.setPrefSize(800,600);

        //ukuran box dari kanan dan kiri
        HBox UkuranBox = new HBox(50);
        UkuranBox.setAlignment(Pos.CENTER);
        UkuranBox.setPadding(new Insets(20));
        //HBox.setHgrow(UkuranBox,Priority.ALWAYS);
       // UkuranBox.setPrefWidth(Region.USE_COMPUTED_SIZE);

        //Wqadah Tulisan Emuy dan Motto
        VBox BoxKanan = new VBox(10);
        BoxKanan.setAlignment(Pos.CENTER);
        BoxKanan.setPrefWidth(300);
        //ikon jendela
        

        //Gambar Kelinci
        //Image GambarKelinci = new Image("C:\\Users\\faizu\\Documents\\Project_PBO_Kelompok\\EMUYHealthCare\\src\\main\\resources\\Kelinci.png");
        //ImageView imageView = new ImageView(GambarKelinci);

        //Ukuran GAmbar Kelinci
        //imageView.setFitHeight(150);
        //imageView.setPreserveRatio(true);


        Text Tittle = new Text("EMUY HEALTH");
        Tittle.setFont(Font.font("Arial", FontWeight.BOLD,24));
        Text footer = new Text("Stay Healthy With Emuy");
        footer.setFont(Font.font("Arial",FontWeight.BOLD,10));
        //BoxKanan.getChildren().add()
        BoxKanan.getChildren().addAll(Tittle,footer);

        //Responsif
        /*imageView.fitWidthProperty().bind(Bindings.createDoubleBinding(() ->
                        Math.max(200, primaryStage.getWidth() / 2),
                        primaryStage.widthProperty()
                )
        );

        imageView.fitHeightProperty().bind(Bindings.createDoubleBinding(() ->
                        Math.max(300, primaryStage.getHeight() / 2),
                        primaryStage.heightProperty()
                )
        );
        */
        Tittle.styleProperty().bind(Bindings.createStringBinding(() -> {
            double fontSize = Math.max(20, primaryStage.getWidth() / 30);
            return "-fx-font-size: " + fontSize + "px; -fx-font-weight: bold;";
        }, primaryStage.widthProperty()));

        footer.styleProperty().bind(Bindings.createStringBinding(() -> {
            double fontSize = Math.max(10, primaryStage.getWidth() / 50);
            return "-fx-font-size: " + fontSize + "px; -fx-font-weight: bold;";
        }, primaryStage.widthProperty()));


        //Kotak Login

        VBox KotakLogin = new VBox(10);
        KotakLogin.setStyle("-fx-background-color: white; -fx-padding: 20px; -fx-background-radius: 10px;");
        //KotakLogin.setMaxHeight(200);
        KotakLogin.setPrefWidth(300);
        //KotakLogin.setPrefHeight(200);
        KotakLogin.setAlignment(Pos.TOP_CENTER);
        //VBox.setVgrow(KotakLogin,Priority.ALWAYS);

        //Isi Kotak Login
        Label TulisanLogin = new Label("Login");
        TulisanLogin.setFont(Font.font("Arial",15));

        Label TulisanUsername = new Label("Username");
        TextField KolomUsername = new TextField();
        Label TulisanPassword = new Label("Password");
        PasswordField KolomPassowrd = new PasswordField();
        KolomUsername.setPromptText("Username");
        Button LoginBtn = new Button("Login");

        KolomUsername.setOnAction(e->{
            KolomPassowrd.requestFocus();
        });

        KolomUsername.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 5px;");
        KolomPassowrd.setPromptText("Password");
        KolomPassowrd.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 5px;");
        KolomPassowrd.setOnAction(e->{
            LoginBtn.fire();
        });
        //Label Peringatan Kalo password Salah

        //Kotak Tombol Login
        HBox ButtonBox = new HBox(10);
        ButtonBox.setAlignment(Pos.CENTER);

        LoginBtn.setStyle("-fx-background-color: #1e90ff; -fx-text-fill: white; -fx-background-radius: 5px;");
        LoginBtn.setPrefWidth(80);
        Label WarnLabel = new Label(Warning);
        WarnLabel.setStyle("-fx-text-fill: Red;");
        WarnLabel.setFont(Font.font("Arial",12));
        LoginBtn.setOnAction(event -> {
            String Result = CheckLogin(KolomUsername,KolomPassowrd);
            WarnLabel.setText(Result);
        });

        Button SignUpBtn = new Button("Sign Up");
        SignUpBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #1e90ff; -fx-border-color: #1e90ff; -fx-border-radius : 5px;");

        ButtonBox.getChildren().addAll(LoginBtn,SignUpBtn);

        KotakLogin.getChildren().addAll(
                TulisanLogin,
                TulisanUsername,
                KolomUsername,
                TulisanPassword,
                KolomPassowrd,
                WarnLabel,
                ButtonBox
        );


        KotakLogin.styleProperty().bind(Bindings.createStringBinding(() -> {
            double fontSize = Math.max(15, primaryStage.getWidth() / 100);
            return "-fx-background-color: white; -fx-padding: 20px; -fx-background-radius: 10px;" +
                    "-fx-font-size: " + fontSize + "px; -fx-font-weight: bold;";
        }, primaryStage.widthProperty()));


        UkuranBox.getChildren().addAll(BoxKanan,KotakLogin);
        Layout.getChildren().add(UkuranBox);


        Scene Scene1 = new Scene(Layout,800,600);
        //Stage1.getIcons().add(IkonKelinci);
        Stage1.setTitle("Emuy HealthCare");
        Stage1.setScene(Scene1);
        Stage1.show();
    }

    private static String CheckLogin(TextField Username,PasswordField Password){
        String UsernameCheck = Username.getText();
        String PasswordCheck = Password.getText();
            if (UsernameCheck.equals("Admin1234") && PasswordCheck.equals("Admin1234")){
               return "Sabar dek ya Blom Update";
            }
           return "Maaf Password Yang anda Masukan Salah!!";
    }

}
