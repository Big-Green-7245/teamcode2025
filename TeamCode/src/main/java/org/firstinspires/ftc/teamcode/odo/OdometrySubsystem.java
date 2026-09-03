package org.firstinspires.ftc.teamcode.odo;

import org.firstinspires.ftc.teamcode.config.RobotConfig;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@SuppressWarnings({"unused", "FieldMayBeFinal"})
public class OdometrySubsystem {

    private final RobotConfig robot;
    private final Pose2D currentPose;

    public OdometrySubsystem(RobotConfig robot) {
        this.robot = robot;
        this.currentPose = new Pose2D(0, 0, 0);
        reset();
    }

    public void reset() {
        currentPose.set(0, 0, 0);
        robot.pinpoint.resetPosAndIMU();
    }

    public void setPosition(double x, double y, double heading) {
        currentPose.set(x, y, heading);
        robot.pinpoint.setPosition(new org.firstinspires.ftc.robotcore.external.navigation.Pose2D(
                DistanceUnit.INCH, x, y, AngleUnit.RADIANS, heading));
    }

    public void update() {
        robot.pinpoint.update();
        org.firstinspires.ftc.robotcore.external.navigation.Pose2D pose = robot.pinpoint.getPosition();

        currentPose.x = pose.getX(DistanceUnit.INCH);
        currentPose.y = pose.getY(DistanceUnit.INCH);
        currentPose.heading = pose.getHeading(AngleUnit.RADIANS);
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
