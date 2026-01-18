package org.firstinspires.ftc.teamcode.modules;

import org.firstinspires.ftc.teamcode.config.RobotConfig;
import org.firstinspires.ftc.teamcode.util.Constants;

public class BallSubsystem {
    private final RobotConfig robot;
    private double intakePower = 0.0;
    private boolean shooterSpinning = false;
    private double transferPower = 0.0;

    public enum State {
        STOPPED,
        RUNNING,
        REVERSING
    }

    private State intakeState = State.STOPPED;
    private State transferState = State.STOPPED;

    public BallSubsystem(RobotConfig robot) {
        this.robot = robot;
    }

    public void runIntake() {
        intakePower = Constants.INTAKE_POWER_IN;
        robot.intakeMotor.setPower(intakePower);
        intakeState = State.RUNNING;
    }

    public void intakeReverse() {
        intakePower = Constants.INTAKE_POWER_OUT;
        robot.intakeMotor.setPower(intakePower);
        intakeState = State.REVERSING;
    }

    public void stopIntake() {
        intakePower = Constants.INTAKE_POWER_STOP;
        robot.intakeMotor.setPower(intakePower);
        intakeState = State.STOPPED;
    }

    public void setIntakePower(double power) {
        intakePower = power;
        robot.intakeMotor.setPower(power);

        if (power > 0.1) {
            intakeState = State.RUNNING;
        } else if (power < -0.1) {
            intakeState = State.REVERSING;
        } else {
            intakeState = State.STOPPED;
        }
    }

    public double getIntakePower() {
        return intakePower;
    }

    public State getState() {
        return intakeState;
    }

    public void spinUpShooter() {
        robot.shooterMotor.setPower(Constants.SHOOTER_POWER);
        shooterSpinning = true;
    }

    public void stopShooter() {
        robot.shooterMotor.setPower(Constants.SHOOTER_IDLE);
        shooterSpinning = false;
    }

    public void setShooterPower(double power) {
        robot.transferMotor.setPower(power);
    }

    public boolean shooterSpinning() {
        return shooterSpinning;
    }

    public void runTransfer() {
        transferPower = Constants.TRANSFER_POWER;
        robot.transferMotor.setPower(transferPower);
        transferState = State.RUNNING;
    }

    public void transferReverse() {
        transferPower = Constants.TRANSFER_REVERSE;
        robot.transferMotor.setPower(transferPower);
        transferState = State.REVERSING;
    }

    public void stopTransfer() {
        transferPower = Constants.TRANSFER_IDLE;
        robot.transferPower.setPower(transferPower);
        transferState = State.STOPPED;
    }

    public void setTransferPower(double power) {
        transferPower = power;
        robot.transferMotor.setPower(power);

        if (power > 0.1) {
            transferState = State.RUNNING;
        } else if (power < -0.1) {
            transferState = State.REVERSING;
        } else {
            transferState = State.STOPPED;
        }
    }

    public double getTransferPower() {
        return transferPower;
    }

    public State getTransferState() {
        return transferState;
    }
}
