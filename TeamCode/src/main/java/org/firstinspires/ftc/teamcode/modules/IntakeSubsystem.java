package org.firstinspires.ftc.teamcode.modules;

import org.firstinspires.ftc.teamcode.config.RobotConfig;
import org.firstinspires.ftc.teamcode.util.Constants;

public class IntakeSubsystem {
    private final RobotConfig robot;
    private double currentPower = 0.0;

    public enum State {
        STOPPED,
        RUNNING,
        REVERSING
    }

    private State state = State.STOPPED;

    public IntakeSubsystem(RobotConfig robot) {
        this.robot = robot;
    }

    public void run() {
        currentPower = Constants.INTAKE_POWER_IN;
        robot.intakeMotor.setPower(currentPower);
        state = State.RUNNING;
    }

    public void reverse() {
        currentPower = Constants.INTAKE_POWER_OUT;
        robot.intakeMotor.setPower(currentPower);
        state = State.REVERSING;
    }

    public void stop() {
        currentPower = Constants.INTAKE_POWER_STOP;
        robot.intakeMotor.setPower(currentPower);
        state = State.STOPPED;
    }

    public void setPower(double power) {
        currentPower = power;
        robot.intakeMotor.setPower(power);

        if (power > 0.1) {
            state = State.RUNNING;
        } else if (power < -0.1) {
            state = State.REVERSING;
        } else {
            state = State.STOPPED;
        }
    }

    public double getPower() {
        return currentPower;
    }

    public State getState() {
        return state;
    }
}
