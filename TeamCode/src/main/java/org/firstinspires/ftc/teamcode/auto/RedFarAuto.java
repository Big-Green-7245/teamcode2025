package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.util.Constants;


@Autonomous(name="Red Far Auto", group="Red")
public class RedFarAuto extends AutoBase {
    @Override
    public void runOpMode() {
        initHardware();
        telemetry.addData("Status", "Ready!");
        telemetry.update();
        waitForStart();
        autoTimer.reset();
        odometry.setPosition(0, 0, 0);
        if (!opModeIsActive()) return;
        try {
            driveToPose(0, 24, Constants.AUTO_DRIVE_SPEED, 3.0);
            sleep(250);
            driveToPose(20, 36, Constants.AUTO_DRIVE_SPEED, 5.0);
            turnToHeading(60, Constants.AUTO_TURN_SPEED, 2.0);
            sleep(250);
            scorePreload();
            sleep(250);
            if (getRemainingTime() > 8.0) {
                driveToPose(0, 24, Constants.AUTO_DRIVE_SPEED, 4.0);
                driveToPose(0, 0, Constants.AUTO_DRIVE_SPEED, 3.0);
            }
            robot.stopAllMotors();
        } catch (Exception e) {
            robot.stopAllMotors();
        }
    }
}
