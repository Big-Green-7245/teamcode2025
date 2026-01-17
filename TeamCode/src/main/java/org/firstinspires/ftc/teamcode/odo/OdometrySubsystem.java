package org.firstinspires.ftc.teamcode.odo;

import org.firstinspires.ftc.teamcode.config.RobotConfig;
import org.firstinspires.ftc.teamcode.util.Constants;

@SuppressWarnings({"unused", "FieldMayBeFinal"})
public class OdometrySubsystem {

    private final RobotConfig robot;
    private final Pose2D currentPose;

    private int lastXEncoder;
    private int lastYEncoder;

    public OdometrySubsystem(RobotConfig robot) {
        this.robot = robot;
        this.currentPose = new Pose2D(0, 0, 0);
        reset();
    }

    public void reset() {
        currentPose.set(0, 0, 0);
        lastXEncoder = robot.odoXEncoder.getCurrentPosition();
        lastYEncoder = robot.odoYEncoder.getCurrentPosition();
    }

    public void setPosition(double x, double y, double heading) {
        currentPose.set(x, y, heading);
        lastXEncoder = robot.odoXEncoder.getCurrentPosition();
        lastYEncoder = robot.odoYEncoder.getCurrentPosition();
    }

    public void update() {
        int currentXEncoder = robot.odoXEncoder.getCurrentPosition();
        int currentYEncoder = robot.odoYEncoder.getCurrentPosition();

        int deltaX = currentXEncoder - lastXEncoder;
        int deltaY = currentYEncoder - lastYEncoder;

        double dx = (double) deltaX / Constants.ODO_COUNTS_PER_INCH;
        double dy = (double) deltaY / Constants.ODO_COUNTS_PER_INCH;

        double heading = currentPose.heading;

        double globalDx = dx * Math.cos(heading) - dy * Math.sin(heading);
        double globalDy = dx * Math.sin(heading) + dy * Math.cos(heading);

        currentPose.x += globalDx;
        currentPose.y += globalDy;

        lastXEncoder = currentXEncoder;
        lastYEncoder = currentYEncoder;
    }

    public Pose2D getPose() {
        return currentPose.copy();
    }

    public double getX() {
        return currentPose.x;
    }

    public double getY() {
        return currentPose.y;
    }

    public double getHeading() {
        return currentPose.heading;
    }

    public double getHeadingDegrees() {
        return Math.toDegrees(currentPose.heading);
    }
}
