package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.config;
import org.fitstinspires.ftc.teamcode.util;
import org.firstinspires.ftc.teamcode.modules;

@TeleOp(name = "WIN", group = "TeleOp")
public class Win extends OpMode {
    private RobotConfig robotConfig = new RobotConfig();
    private ButtonHelper gamepad1X = new ButtonHelper(gamepad1);

    private drivesystem drive;
    private ballsystem ball;

    private boolean toggleShooter = false;

    @Override
    public void init() {
        robotConfig.init(hardwareMap);
        drive = new drivesystem(robotConfig);
        ball = new ballsystem(robotConfig);

        telemetry.addLine("We are ready to win!");
        telemetry.update();
    }

    @Override
    public void loop() {
        drive.drive(gamepad1);

        if (gamepad1.left_bumper) {
            ball.intakeReverse();
            ball.transferReverse();
        } else {
            ball.setTransferPower(gamepad1.right_trigger);
            ball.setIntakePower(Math.max(gamepad1.left_trigger, gamepad1.right_trigger));
        }

        if (gamepad1X.aReleased()) {
            toggleShooter = !toggleShooter;
        }

        if (toggleShooter) {
            ball.spinUpShooter();
        } else {
            ball.stopShooter();
        }
    }
}