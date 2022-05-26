package com.example.gra;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends GraphicsItem {
    private Point2D moveVector;
    private double velocity;
    public double lastX;
    public double lastY;

    public Ball() {
        this.moveVector = new Point2D(1, -1).normalize();
        this.width = 10;
        this.height = 10;
        this.velocity = 0.001;
    }


    public void setPosition(Point2D point2D) {
        this.x = (float) point2D.getX() - width / 2;
        this.y = (float) point2D.getY() - height / 2 - 5;
    }

    public void updatePosition(double seconds){
        this.lastX = x;
        this.lastY = y;
        this.x += moveVector.getX() * velocity * seconds;
        this.y += moveVector.getY() * velocity * seconds;
    }

    @Override
    void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillOval(x, y, width, height);
    }

    public void bounceHorizontally(){
        this.moveVector = new Point2D(moveVector.getX(), -moveVector.getY());
    }

    public void bounceVertically(){
        this.moveVector = new Point2D(-moveVector.getX(), moveVector.getY());
    }



}
