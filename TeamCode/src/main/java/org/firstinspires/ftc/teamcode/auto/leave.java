package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name="LeaveZone", group="Autonomous")
public class leave extends LinearOpMode {
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    @Override
    public void runOpMode() {
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();

        if (opModeIsActive()) {
            frontLeft.setPower(0.5);
            backLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backRight.setPower(0.5);
            sleep(1500);
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }
    }
}


