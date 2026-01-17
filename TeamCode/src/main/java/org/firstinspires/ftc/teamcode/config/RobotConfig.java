package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.util.Constants;

public class RobotConfig {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public DcMotor intakeMotor;
    public DcMotor launchMotor;

    public DcMotor odoXEncoder;
    public DcMotor odoYEncoder;

    public Servo pusherServo;

    private HardwareMap hwMap;

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        initDriveMotors();
        initSubsystems();
        initOdometry();
        initServos();
    }

    private void initDriveMotors() {
        frontLeft = hwMap.get(DcMotor.class, Constants.FRONT_LEFT);
        frontRight = hwMap.get(DcMotor.class, Constants.FRONT_RIGHT);
        backLeft = hwMap.get(DcMotor.class, Constants.BACK_LEFT);
        backRight = hwMap.get(DcMotor.class, Constants.BACK_RIGHT);

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        setDriveMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private void initSubsystems() {
        intakeMotor = hwMap.get(DcMotor.class, Constants.INTAKE_MOTOR);
        launchMotor = hwMap.get(DcMotor.class, Constants.LAUNCH_MOTOR);

        intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        launchMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        launchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeMotor.setPower(0);
        launchMotor.setPower(0);
    }

    private void initOdometry() {
        odoXEncoder = hwMap.get(DcMotor.class, Constants.ODO_X_ENCODER);
        odoYEncoder = hwMap.get(DcMotor.class, Constants.ODO_Y_ENCODER);

        odoXEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        odoYEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        odoXEncoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        odoYEncoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private void initServos() {
        pusherServo = hwMap.get(Servo.class, Constants.PUSHER_SERVO);
        pusherServo.setPosition(Constants.PUSHER_REST);
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