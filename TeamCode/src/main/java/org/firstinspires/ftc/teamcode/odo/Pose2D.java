package org.firstinspires.ftc.teamcode.odo;

public class Pose2D {
    public double x;
    public double y;
    public double heading;

    public Pose2D() {
        this(0, 0, 0);
    }

    public Pose2D(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    public void set(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    public Pose2D copy() {
        return new Pose2D(x, y, heading);
    }

    public double distanceTo(Pose2D other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double angleTo(Pose2D other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return Math.atan2(dy, dx);
    }
}
