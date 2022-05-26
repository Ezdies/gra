package com.example.gra;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BreakoutGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GameCanvas canvas = new GameCanvas(640, 800);
        GridPane grid = new GridPane();
        grid.add(canvas,0,0);

        Scene scene = new Scene(grid, 640, 800);
        stage.setTitle("BreakOut Game");
        stage.setScene(scene);
        canvas.draw();
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}