package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import org.firstinspires.ftc.teamcode.util.Constants;

public class RobotConfig {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public DcMotor intakeMotor;
    public DcMotor transferMotor;
    public DcMotor shooterMotor;

    public GoBildaPinpointDriver pinpoint;

    private HardwareMap hwMap;

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        initDriveMotors();
        initSubsystems();
        initOdometry();
    }

    private void initDriveMotors() {
        frontLeft = hwMap.get(DcMotor.class, Constants.FRONT_LEFT);
        frontRight = hwMap.get(DcMotor.class, Constants.FRONT_RIGHT);
        backLeft = hwMap.get(DcMotor.class, Constants.BACK_LEFT);
        backRight = hwMap.get(DcMotor.class, Constants.BACK_RIGHT);

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        setDriveMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private void initSubsystems() {
        intakeMotor = hwMap.get(DcMotor.class, Constants.INTAKE_MOTOR);
        transferMotor = hwMap.get(DcMotor.class, Constants.TRANSFER_MOTOR);
        shooterMotor = hwMap.get(DcMotor.class, Constants.SHOOTER_MOTOR);

        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        transferMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeMotor.setPower(0);
        transferMotor.setPower(0);
        shooterMotor.setPower(0);
    }

    private void initOdometry() {
        pinpoint = hwMap.get(GoBildaPinpointDriver.class, Constants.PINPOINT);

        pinpoint.setOffsets(Constants.PINPOINT_X_OFFSET_MM, Constants.PINPOINT_Y_OFFSET_MM, DistanceUnit.MM);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGRAM_POD);
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD,
                GoBildaPinpointDriver.EncoderDirection.FORWARD);
        pinpoint.resetPosAndIMU();
    }

    public void resetDriveEncoders() {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setDriveMode(DcMotor.RunMode mode) {
        frontLeft.setMode(mode);
        frontRight.setMode(mode);
        backLeft.setMode(mode);
        backRight.setMode(mode);
    }

    public void stopAllMotors() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        intakeMotor.setPower(0);
        launchMotor.setPower(0);
    }
}
