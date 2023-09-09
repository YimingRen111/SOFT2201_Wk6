import javafx.scene.paint.Paint;

import java.util.Random;

public class Ball {
    private double xPos;
    private double yPos;
    private double radius;
    private double xVel;
    private double yVel;
    private Paint colour;

    private MovementStrategy strategy;
    private BallPit ballPit;

    Ball(double startX, double startY, double startRadius, Paint colour, BallPit ballPit) {
        this.xPos = startX;
        this.yPos = startY;
        this.radius = startRadius;
        this.colour = colour;
        this.ballPit = ballPit;
        xVel = new Random().nextInt(10);
        yVel = new Random().nextInt(10);
    }

    void tick() {
        xPos += xVel;
        yPos += yVel;
    }

    void setxVel(double xVel) {
        this.xVel = xVel;
    }

    void setyVel(double yVel) {
        this.yVel = yVel;
    }

    double getRadius() {
        return radius;
    }

    double getxPos() {
        return xPos;
    }

    double getyPos() {
        return yPos;
    }

    Paint getColour() {
        return colour;
    }

    double getxVel() {
        return xVel;
    }

    double getyVel() {
        return yVel;
    }

    void setxPos(double xPos) {
        this.xPos = xPos;
    }

    void setyPos(double yPos) {
        this.yPos = yPos;
    }


    public void setStrategy(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public MovementStrategy getStrategy() {
        return this.strategy;
    }

    public void think() {
        strategy.move(this, ballPit);
    }

}
