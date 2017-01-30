/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author UserPL022Pc15
 */
public class WebPage extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group g = new Group();
        
        Scene sc = new Scene(g, 1060, 768);
        
        //Browser funcional
        GridPane gp = new GridPane();
        WebView browser = new WebView();
        WebEngine we = browser.getEngine();
        we.load("http://atec.pt");
        browser.setPrefWidth(1024);
        browser.setPrefHeight(768);
        
        Button btLoad = new Button("GO");
        Button btBack = new Button("Back");
        Button btForward = new Button("Forward");
        TextField barraNav = new TextField();
        
        gp.add(btBack, 0, 0);
        gp.add(btForward, 1, 0);
        gp.add(barraNav, 2, 0);
        gp.add(btLoad, 3, 0);
        gp.add(browser, 2, 1);
        
        btLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                we.getHistory().go(-1);
            }
        });
        
        btBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                we.load(barraNav.getText());
            }
        });
        
        btForward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                we.getHistory().go(+1);
            }
        });
        
        g.getChildren().add(gp);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
