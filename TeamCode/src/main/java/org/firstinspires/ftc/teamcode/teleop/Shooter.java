package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
@TeleOp(name="Scrimmage", group="TeleOp")
public class Shooter extends OpMode {
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private DcMotor shooterLeft, shooterRight;
    private CRServo spinnerServo;
    @Override
    public void init() {
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        shooterLeft  = hardwareMap.get(DcMotor.class, "shooterLeft");
        shooterRight = hardwareMap.get(DcMotor.class, "shooterRight");
        spinnerServo = hardwareMap.get(CRServo.class, "spinnerServo");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        shooterLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        shooterRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = -gamepad1.right_stick_x;

        double frontLeftPower  = y + x + rx;
        double backLeftPower   = y - x + rx;
        double frontRightPower = y - x - rx;
        double backRightPower  = y + x - rx;
        double max = Math.max(1.0, Math.max(
                Math.abs(frontLeftPower),
                Math.max(Math.abs(backLeftPower),
                        Math.max(Math.abs(frontRightPower), Math.abs(backRightPower)))));
        frontLeft.setPower(frontLeftPower / max);
        backLeft.setPower(backLeftPower / max);
        frontRight.setPower(frontRightPower / max);
        backRight.setPower(backRightPower / max);
        if (gamepad1.right_trigger > 0.5) {
            shooterLeft.setPower(1.0);
            shooterRight.setPower(1.0);
        } else {
            shooterLeft.setPower(0.0);
            shooterRight.setPower(0.0);
        }

        if (gamepad1.b) {
            spinnerServo.setPower(-1.0);
        } else {
            spinnerServo.setPower(0.0);
        }
        telemetry.addData("Shooter", gamepad1.right_trigger > 0.5 ? "ON" : "OFF");
        telemetry.addData("Spinner Power", spinnerServo.getPower());
        telemetry.update();

    }
}


