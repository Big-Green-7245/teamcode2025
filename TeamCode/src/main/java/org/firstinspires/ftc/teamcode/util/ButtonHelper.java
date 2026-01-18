package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ButtonHelper{
    private final Gamepad gamepad;
    private final boolean[] buttons = new boolean[15];
    private final boolean[] prev = new boolean[15];

    public static final int
            dpad_up            = 0,
            dpad_down          = 1,
            dpad_left          = 2,
            dpad_right         = 3,
            a                  = 4,
            b                  = 5,
            x                  = 6,
            y                  = 7,
            CROSS              = 4,
            CIRCLE             = 5,
            SQUARE             = 6,
            TRIANGLE           = 7,
            guide              = 8,
            start              = 9,
            back               = 10,
            left_bumper        = 11,
            right_bumper       = 12,
            left_stick_button  = 13,
            right_stick_button = 14;

    public ButtonHelper(final Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public void update() {
        System.arraycopy(buttons, 0, prev, 0, 15);

        buttons[dpad_up] = gamepad.dpad_up;
        buttons[dpad_down] = gamepad.dpad_down;
        buttons[dpad_left] = gamepad.dpad_left;
        buttons[dpad_right] = gamepad.dpad_right;
        buttons[a] = gamepad.a;
        buttons[b] = gamepad.b;
        buttons[x] = gamepad.x;
        buttons[y] = gamepad.y;
        buttons[guide] = gamepad.guide;
        buttons[start] = gamepad.start;
        buttons[back] = gamepad.back;
        buttons[left_bumper] = gamepad.left_bumper;
        buttons[right_bumper] = gamepad.right_bumper;
        buttons[left_stick_button] = gamepad.left_stick_button;
        buttons[right_stick_button] = gamepad.right_stick_button;
    }

    public boolean held(int idx) { return buttons[idx]; }
    public boolean released(int idx) { return !buttons[idx] && prev[idx]; }
    public boolean pressing(int idx) { return buttons[idx] && !prev[idx]; }

    public boolean aPressed() { return pressing(a); }
    public boolean bPressed() { return pressing(b); }
    public boolean xPressed() { return pressing(x); }
    public boolean yPressed() { return pressing(y); }
    public boolean dpadUpPressed() { return pressing(dpad_up); }
    public boolean dpadDownPressed() { return pressing(dpad_down); }
    public boolean dpadLeftPressed() { return pressing(dpad_left); }
    public boolean dpadRightPressed() { return pressing(dpad_right); }
    public boolean leftBumperPressed() { return pressing(left_bumper); }
    public boolean rightBumperPressed() { return pressing(right_bumper); }
    public boolean leftStickButtonPressed() { return pressing(left_stick_button); }
    public boolean rightStickButtonPressed() { return pressing(right_stick_button); }
    public boolean startPressed() { return pressing(start); }
    public boolean backPressed() { return pressing(back); }

    public boolean aReleased() { return released(a); }
    public boolean bReleased() { return released(b); }
    public boolean xReleased() { return released(x); }
    public boolean yReleased() { return released(y); }
}
