//package com.example.demo.box;
//
//import com.sun.javafx.scene.traversal.Direction;
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import tornadofx.ViewTransition;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class SnakeGame extends Application {
//    static int speed = 5;
//    static int foodcolor = 0;
//    static int width = 20;
//    static int height = 20;
//    static int foodX = 0;
//    static int foodY = 0;
//    static int cornersize = 25;
//    static List<Corner> snake = new ArrayList<>();
//    static Dir direction = Dir.LEFT;
//    static boolean gameOver = false;
//    static Random rond = new Random();
//
//
//    public enum Dir {
//        LEFT, RIGHT, UP, DOWN
//    }
//
//    public static class Corner {
//        int x;
//        int y;
//
//        public Corner(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public void start(Stage stage) {
//        try {
//            newfood();
//
//            VBox root = new VBox();
//            Canvas c = new Canvas(width * cornersize, height * cornersize);
//            GraphicsContext gc = c.getGraphicsContext2D();
//            root.getChildren().add(c);
//
//            new AnimationTimer() {
//                long lastTick = 0;
//
//                public void handle(long now) {
//                    if (lastTick == 0) {
//                        lastTick = now;
//                        tick(gc);
//                        return;
//                    }
//                    if (now - lastTick > 100000 / speed) {
//                        lastTick = now;
//                        tick(gc);
//                    }
//                }
//            }.start();
//            Scene scene = new Scene(root, width - cornersize, height * cornersize);
//
//            // control
//            scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
//                if (key.getCode()== KeyCode.UP){ direction = Dir.UP; }
//                if (key.getCode()== KeyCode.DOWN){ direction = Dir.DOWN; }
//                if (key.getCode()== KeyCode.LEFT){ direction = Dir.LEFT; }
//                if (key.getCode()== KeyCode.RIGHT){ direction = Dir.RIGHT; }
//            });
//
//            // add start snake part
//            snake.add(new Corner(width/2,height/2));
//            snake.add(new Corner(width/2,height/2));
//            snake.add(new Corner(width/2,height/2));
//
////            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//            stage.setScene(scene);
//            stage.setTitle("Snake Game");
//            stage.show();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    // tick
//    public static void tick(GraphicsContext gc){
//        if (gameOver){
//            gc.setFill(Color.RED);
//            gc.setFont(new Font("",50));
//            gc.fillText("Game Over",100,250);
//            return;
//        }
//        for (int i = snake.size() - 1; i>=1;i--){
//            snake.get(i).x = snake.get(i-1).x;
//            snake.get(i).y = snake.get(i-1).y;
//        }
//        switch (direction){
//            case UP:
//                snake.get(0).y--;
//                if (snake.get(0).y<0){
//                    gameOver = true;
//                }
//            case DOWN:
//                snake.get(0).y++;
//                if (snake.get(0).y>height){
//                    gameOver = true;
//                }
//                break;
//            case LEFT:
//                snake.get(0).x--;
//                if (snake.get(0).x<0){
//                    gameOver = true;
//                }
//            case RIGHT:
//                snake.get(0).x++;
//                if (snake.get(0).x>width){
//                    gameOver = true;
//                }
//                break;
//        }
//        // eat food
//        if (foodX == snake.get(0).x && foodY == snake.get(0).y){
//                snake.add(new Corner(-1,-1));
//                newfood();
//            }
//            // self destroy
//            for (int i =1;i<snake.size();i++){
//                if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
//                    gameOver = true;
//                    break;
//                }
//            }
//        // fill
//        // background
//        gc.setFill(Color.BLACK);
//        gc.fillRect(0,0,width*cornersize,height*cornersize);
//
//        // score
//        gc.setFill(Color.WHITE);
//        gc.setFont(new Font("",30));
//        gc.fillText("Score",+(speed-6),10,30);
//
//        //random color
//        Color cc = Color.WHITE;
//        if (foodcolor == 0) {
//            cc = Color.ANTIQUEWHITE;
//        }
//        gc.setFill(cc);
//        gc.fillOval(foodX*cornersize,foodY*cornersize,cornersize,cornersize);
//
//        // snake
//        for (Corner c:snake){
//            gc.setFill(Color.LIGHTGREEN);
//            gc.fillRect(c.x*cornersize,c.y*cornersize,cornersize-1,cornersize-1);
//            gc.setFill(Color.GREEN);
//            gc.fillRect(c.x*cornersize,c.y*cornersize,cornersize-2,cornersize-2);
//        }
//    }
//    // food
//    public static void newfood(){
//        start:while(true){
//        foodX = rond.nextInt(width);
//        foodY = rond.nextInt(height);
//
//        for (Corner c:snake){
//            if (c.x == foodX && c.y == foodY){
//                continue  start;
//            }
//        }
//        foodcolor = rond.nextInt(5);
//        speed++;
//        break;
//        }
//    }
//    public static void main(String[] args){
//        launch(args);
//    }
//}
//
