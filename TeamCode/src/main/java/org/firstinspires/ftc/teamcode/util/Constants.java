package org.firstinspires.ftc.teamcode.util;

public class Constants {
    public static final String FRONT_LEFT = "frontLeft";
    public static final String FRONT_RIGHT = "frontRight";
    public static final String BACK_LEFT = "backLeft";
    public static final String BACK_RIGHT = "backRight";

    public static final String INTAKE_MOTOR = "intake";
    public static final String LAUNCH_MOTOR = "rhino";

    public static final String PUSHER_SERVO = "pusherServo";

    public static final String ODO_X_ENCODER = "odoX";
    public static final String ODO_Y_ENCODER = "odoY";

    public static final double DRIVE_SPEED_TURBO = 1.0;
    public static final double DRIVE_SPEED_FAST = 0.8;
    public static final double DRIVE_SPEED_NORMAL = 0.6;
    public static final double DRIVE_SPEED_SLOW = 0.4;
    public static final double DRIVE_SPEED_PRECISION = 0.25;

    public static final double INTAKE_POWER_IN = 1.0;
    public static final double INTAKE_POWER_OUT = -1.0;
    public static final double INTAKE_POWER_STOP = 0.0;

    public static final double LAUNCHER_POWER = 1.0;
    public static final double LAUNCHER_IDLE = 0.0;
    public static final int LAUNCHER_SPINUP_MS = 1000;

    public static final double PUSHER_REST = 1.0;
    public static final double PUSHER_PUSH = 0.7;

    public static final double ODO_WHEEL_DIAMETER = 1.5;
    public static final double ODO_COUNTS_PER_REV = 8192.0;
    public static final double ODO_COUNTS_PER_INCH = ODO_COUNTS_PER_REV / (ODO_WHEEL_DIAMETER * Math.PI);

    public static final double ODO_X_OFFSET = 0.0;
    public static final double ODO_Y_OFFSET = 0.0;

    public static final double AUTO_DRIVE_SPEED = 0.5;
    public static final double AUTO_STRAFE_SPEED = 0.5;
    public static final double AUTO_TURN_SPEED = 0.3;

    public static final double AUTO_POSITION_TOLERANCE = 1.0;
    public static final double AUTO_HEADING_TOLERANCE = Math.toRadians(3);

    public static final double AUTO_DRIVE_KP = 0.08;
    public static final double AUTO_DRIVE_KD = 0.0;

    public static final double AUTO_TURN_KP = 0.5;
    public static final double AUTO_TURN_KD = 0.0;

    public static final double AUTO_STRAFE_KP = 0.08;
    public static final double AUTO_STRAFE_KD = 0.0;

    public static final double TILE_SIZE = 24.0;
    public static final double FIELD_WIDTH = 144.0;
    public static final double FIELD_LENGTH = 144.0;

    public static final int POINTS_LEAVE = 3;
    public static final int POINTS_AUTO_CLASSIFIED = 3;
    public static final int POINTS_TELEOP_CLASSIFIED = 3;
    public static final int POINTS_DEPOT = 1;
    public static final int POINTS_PARTIAL_BASE = 5;
    public static final int POINTS_FULL_BASE = 10;
    public static final int POINTS_BOTH_BASE_BONUS = 10;

    public static final int MATCH_LENGTH_AUTO_MS = 30000;
    public static final int MATCH_LENGTH_TELEOP_MS = 120000;
    public static final int ENDGAME_WARNING_MS = 20000;
}
