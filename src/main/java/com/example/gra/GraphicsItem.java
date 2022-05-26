package com.example.gra;

import javafx.scene.canvas.GraphicsContext;

public abstract class GraphicsItem {
    protected static int canvasWidth;
    protected static int canvasHeight;

    protected float x;
    protected float y;
    protected float width;
    protected float height;

    public static void setCanvasWidth(int canvasWidth) {
        GraphicsItem.canvasWidth = canvasWidth;
    }

    public static void setCanvasHeight(int canvasHeight) {
        GraphicsItem.canvasHeight = canvasHeight;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    abstract void draw(GraphicsContext graphicsContext);
}
