package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.util.Constants;

@Autonomous(name = "redclose", group = "Red")
public class RedCloseAuto extends AutoBase {

    @Override
    public void runOpMode() {

        initHardware();

        waitForStart();
        autoTimer.reset();
        odometry.setPosition(0, 0, 0);

        if (!opModeIsActive()) return;

        try {

            driveToPose(0, 24, Constants.AUTO_DRIVE_SPEED, 3.0);
            sleep(250);

            driveToPose(36, 36, Constants.AUTO_DRIVE_SPEED, 5.0);
            turnToHeading(45, Constants.AUTO_TURN_SPEED, 2.0);
            sleep(250);

            scorePreload();
            sleep(250);

            if (getRemainingTime() > 8.0) {
                driveToPose(0, 24, Constants.AUTO_DRIVE_SPEED, 4.0);
                driveToPose(0, 0, Constants.AUTO_DRIVE_SPEED, 3.0);
            }

            drive.stop();
            intake.stop();
            launcher.stop();

        } catch (Exception e) {
            robot.stopAllMotors();
        }
    }
}
