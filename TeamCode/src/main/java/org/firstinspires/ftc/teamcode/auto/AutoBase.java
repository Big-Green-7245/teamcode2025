package org.firstinspires.ftc.teamcode.auto;
import org.firstinspires.ftc.teamcode.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.config.RobotConfig;
import org.firstinspires.ftc.teamcode.modules.DriveSubsystem;
import org.firstinspires.ftc.teamcode.modules.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.modules.LauncherSubsystem;
import org.firstinspires.ftc.teamcode.odo.OdometrySubsystem;
import org.firstinspires.ftc.teamcode.odo.Pose2D;
import org.firstinspires.ftc.teamcode.util.Constants;

public abstract class AutoBase extends LinearOpMode {

    protected RobotConfig robot;
    protected DriveSubsystem drive;
    protected BallSubsystem ball;
    protected OdometrySubsystem odometry;

    protected ElapsedTime runtime = new ElapsedTime();
    protected ElapsedTime autoTimer = new ElapsedTime();

    protected void initHardware() {
        robot = new RobotConfig();
        robot.init(hardwareMap);

        drive = new DriveSubsystem(robot);
        ball = new BallSubsystem(robot);
        odometry = new OdometrySubsystem(robot);
    }

    protected void driveToPose(double targetX, double targetY, double maxPower, double timeout) {
        ElapsedTime timer = new ElapsedTime();
        double lastError = 0;

        while (opModeIsActive() && timer.seconds() < timeout) {
            odometry.update();
            Pose2D current = odometry.getPose();
            Pose2D target = new Pose2D(targetX, targetY, 0);

            double distance = current.distanceTo(target);

            if (distance < Constants.AUTO_POSITION_TOLERANCE) break;

            double angle = current.angleTo(target);
            double headingError = normalizeAngle(targetAngle - current.heading);

            double errorDerivative = (distance - lastError) / 0.02;
            lastError = distance;

            double drivePower = Constants.AUTO_DRIVE_KP * distance
                    + Constants.AUTO_DRIVE_KD * errorDerivative;
            double turnPower = Constants.AUTO_TURN_KP * headingError;

            drivePower = Math.max(-maxPower, Math.min(maxPower, drivePower));
            turnPower = Math.max(-0.5, Math.min(0.5, turnPower));

            double forward = drivePower * Math.cos(targetAngle - current.heading);
            double strafe = drivePower * Math.sin(targetAngle - current.heading);

            drive.drive(forward, strafe, turnPower);
        }

        drive.stop();
        sleep(100);
    }

    protected void turnToHeading(double targetHeadingDeg, double maxPower, double timeout) {
        double targetHeading = Math.toRadians(targetHeadingDeg);
        ElapsedTime timer = new ElapsedTime();

        while (opModeIsActive() && timer.seconds() < timeout) {
            odometry.update();
            Pose2D current = odometry.getPose();

            double headingError = normalizeAngle(targetHeading - current.heading);
            if (Math.abs(headingError) < Constants.AUTO_HEADING_TOLERANCE) break;

            double turnPower = Constants.AUTO_TURN_KP * headingError;
            turnPower = Math.max(-maxPower, Math.min(maxPower, turnPower));

            drive.drive(0, 0, turnPower);
        }

        drive.stop();
        sleep(100);
    }

    protected void leaveStartLine() {
        driveToPose(0, 24, Constants.AUTO_DRIVE_SPEED, 3.0);
        sleep(250);
    }

    protected void scorePreload() {
        ball.spinUpShooter();
        sleep(1000);

        for (int i = 0; i < 3; i++) {
            ball.runTransfer();
            sleep(500);
            ball.stopTransfer();
            sleep(500);
        }

        ball.stopShooter();
        sleep(250);
    }

    protected void returnToBase() {
        driveToPose(0, 0, Constants.AUTO_DRIVE_SPEED, 5.0);
        sleep(250);
    }

    protected double getRemainingTime() {
        return (Constants.MATCH_LENGTH_AUTO_MS / 1000.0) - autoTimer.seconds();
    }

    private double normalizeAngle(double angle) {
        while (angle > Math.PI) angle -= 2 * Math.PI;
        while (angle < -Math.PI) angle += 2 * Math.PI;
        return angle;
    }
}