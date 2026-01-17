package org.firstinspires.ftc.teamcode.modules;
import org.firstinspires.ftc.teamcode.config.RobotConfig;
import org.firstinspires.ftc.teamcode.util.Constants;

public class LauncherSubsystem {
    private final RobotConfig robot;
    private boolean spinning = false;
    private boolean pushed = false;

    public LauncherSubsystem(RobotConfig robot) {
        this.robot = robot;
    }

    public void spinUp() {
        robot.launchMotor.setPower(Constants.LAUNCHER_POWER);
        spinning = true;
    }

    public void stop() {
        robot.launchMotor.setPower(Constants.LAUNCHER_IDLE);
        spinning = false;
    }

    public void push() {
        robot.pusherServo.setPosition(Constants.PUSHER_PUSH);
        pushed = true;
    }

    public void retract() {
        robot.pusherServo.setPosition(Constants.PUSHER_REST);
        pushed = false;
    }

    public boolean isSpinning() {
        return spinning;
    }

    public boolean isPushed() {
        return pushed;
    }

    public double getPower() {
        return robot.launchMotor.getPower();
    }
}
