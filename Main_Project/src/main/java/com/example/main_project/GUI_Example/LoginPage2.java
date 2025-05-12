package com.example.main_project.GUI_Example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginPage2 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage Stage1) throws Exception {
        VBox BoxJudul_Motto = new VBox(20);
        BoxJudul_Motto.setAlignment(Pos.TOP_CENTER);
        BoxJudul_Motto.setPadding(new Insets(30));
        BoxJudul_Motto.setStyle("-fx-background-color: #ADD8E6;");

        Text Tittle = new Text("EMUY HEALTH");
        Text Motto = new Text("Stay Healthy With Emuy");

        //ResponsifLogin

    }
}
