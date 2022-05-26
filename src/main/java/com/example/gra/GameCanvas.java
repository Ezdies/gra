package com.example.gra;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameCanvas extends Canvas {
    private GraphicsContext graphicsContext = super.getGraphicsContext2D();
    private Paddle paddle;
    private Ball ball;
    private boolean gameIsPlaying;
    private AnimationTimer animationTimer = new AnimationTimer() {
        private long lastTime;

        @Override
        public void handle(long time) {
            time -= lastTime;
            ball.updatePosition(time / 1000000000.0);
            draw();
            lastTime = time;
            if (shouldBallBounceHorizontally()) {
                ball.bounceHorizontally();

            }
            if (shouldBallBounceVertically()) {
                ball.bounceVertically();
            }
            if (shouldBallBounceFromPaddle()) {
                ball.bounceHorizontally();
            }

        }


        @Override
        public void start() {
            super.start();
            lastTime = System.nanoTime();
        }
    };


    public GameCanvas(double w, double h) {
        super(w, h);
        GraphicsItem.setCanvasHeight((int) this.getHeight());
        GraphicsItem.setCanvasWidth((int) this.getWidth());
        this.paddle = new Paddle();
        this.ball = new Ball();
        this.setOnMouseMoved(mouseEvent -> {
            this.paddle.setPosition((int) mouseEvent.getX());
            if (!this.gameIsPlaying) {
                this.ball.setPosition(new Point2D((int) mouseEvent.getX(), paddle.getY()));
            }
//            }else{
//                this.ball.updatePosition();
//            }
            this.draw();
        });

        this.setOnMouseClicked(mouseEvent -> {
            this.gameIsPlaying = true;
            animationTimer.start();
        });

    }

    public void draw() {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.paddle.draw(graphicsContext);
        this.ball.draw(graphicsContext);
    }

    private boolean shouldBallBounceHorizontally() {
        return ball.lastY > 0 && ball.y <= 0;
    }

    private boolean shouldBallBounceFromPaddle() {
        return ball.lastY + ball.height < paddle.y && ball.y + ball.height >= paddle.y
                && ball.x >= paddle.x && ball.x <= paddle.x + paddle.width;
    }

    private boolean shouldBallBounceVertically() {
        return (ball.x <= 0 && ball.lastX > 0)
                || (ball.x + ball.width >= getWidth() - 1 && ball.lastX + ball.width < getWidth() - 1);
    }
}
