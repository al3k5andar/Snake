package com.am.demo;

import com.am.demo.listeners.MyKeyListener;
import com.am.demo.panes.Field;
import com.am.demo.snake.Snake;
import com.am.demo.threads.BlockMovement;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static int blockSize= 30;

    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        FlowPane root= new FlowPane();
        root.setPadding(new Insets(10));
        Field field= new Field(30,20);

        Snake snake= new Snake(7, field);
        field.addSnake(snake);

        BlockMovement movement= new BlockMovement(field);
        Thread move= new Thread(movement);
        move.start();

        root.getChildren().add(field);

        Scene scene= new Scene(root);
        scene.setOnKeyPressed(new MyKeyListener(movement));

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
