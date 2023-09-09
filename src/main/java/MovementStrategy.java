interface MovementStrategy {
    void move(Ball ball, BallPit ballPit);
}

class OrangeBallStrategy implements MovementStrategy {
    @Override
    public void move(Ball ball, BallPit ballPit) {
        double leftDistance = ball.getxPos();
        double rightDistance = ballPit.getWidth() - ball.getxPos();
        double topDistance = ball.getyPos();
        double bottomDistance = ballPit.getHeight() - ball.getyPos();

        // Find the minimum distance
        double minDistance = Math.min(Math.min(leftDistance, rightDistance), Math.min(topDistance, bottomDistance));

        // Accelerate towards the closest edge
        if (minDistance == leftDistance) {
            ball.setxVel(ball.getxVel() - 0.017); // Accelerate left
        } else if (minDistance == rightDistance) {
            ball.setxVel(ball.getxVel() + 0.017); // Accelerate right
        } else if (minDistance == topDistance) {
            ball.setyVel(ball.getyVel() - 0.017); // Accelerate up
        } else if (minDistance == bottomDistance) {
            ball.setyVel(ball.getyVel() + 0.017); // Accelerate down
        }
    }
}

class PurpleBallStrategy implements MovementStrategy {
    private boolean freeze = false;
    private long freezeStartTime = 0;
    private static final long FREEZE_DURATION = 1000; // 1 second in milliseconds

    @Override
    public void move(Ball ball, BallPit ballPit) {
        if (freeze) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - freezeStartTime < FREEZE_DURATION) {
                ball.setxVel(0);
                ball.setyVel(0);
            } else {
                freeze = false;
            }
        }
    }

    public void freeze() {
        this.freeze = true;
        this.freezeStartTime = System.currentTimeMillis();
    }
}
