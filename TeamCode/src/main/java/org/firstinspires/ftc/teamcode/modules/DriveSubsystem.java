package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.config.RobotConfig;
import org.firstinspires.ftc.teamcode.util.Constants;

public class DriveSubsystem {
    private final RobotConfig robot;
    private double speedMultiplier;

    public DriveSubsystem(RobotConfig robot) {
        this.robot = robot;
        this.speedMultiplier = Constants.DRIVE_SPEED_NORMAL;
    }

    public void drive(Gamepad gamepad) {
        double y = gamepad.left_stick_y;
        double x = gamepad.left_stick_x;
        double rx = -gamepad.right_stick_x;
        drive(y, x, rx);
    }

    public void drive(double forward, double strafe, double rotate) {
        forward *= speedMultiplier;
        strafe *= speedMultiplier;
        rotate *= speedMultiplier;

        double frontLeftPower = forward + strafe + rotate;
        double backLeftPower = forward - strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backRightPower = forward + strafe - rotate;

        double max = Math.max(1.0, Math.max(
                Math.abs(frontLeftPower),
                Math.max(Math.abs(backLeftPower),
                        Math.max(Math.abs(frontRightPower), Math.abs(backRightPower)))));

        frontLeftPower /= max;
        backLeftPower /= max;
        frontRightPower /= max;
        backRightPower /= max;

        robot.frontLeft.setPower(frontLeftPower);
        robot.backLeft.setPower(backLeftPower);
        robot.frontRight.setPower(frontRightPower);
        robot.backRight.setPower(backRightPower);
    }

    public void stop() {
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);
    }

    public void setSpeed(double speed) {
        this.speedMultiplier = Math.max(0.0, Math.min(1.0, speed));
    }

    public double getSpeed() {
        return speedMultiplier;
    }

    public int getAverageEncoder() {
        return (Math.abs(robot.frontLeft.getCurrentPosition()) +
                Math.abs(robot.frontRight.getCurrentPosition()) +
                Math.abs(robot.backLeft.getCurrentPosition()) +
                Math.abs(robot.backRight.getCurrentPosition())) / 4;
    }
}
