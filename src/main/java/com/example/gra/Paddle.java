package com.example.gra;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle extends GraphicsItem {
    public Paddle() {
        this.width = 150;
        this.height = 50;

        this.x = (canvasWidth - width) / 2;
        this.y = (float) (canvasHeight * 0.95);
    }

    @Override
    void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.HOTPINK);
        graphicsContext.fillRect(x, y, width, height);
    }

    public void setPosition(int x) {
        this.x = x - this.width / 2;
        if (this.x < 0) {
            this.x = 0;
        } else if (this.x + this.width / 2 > canvasWidth - width / 2) {
            this.x = canvasWidth - width;
        }
    }
}
