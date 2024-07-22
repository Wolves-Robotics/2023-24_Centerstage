package org.firstinspires.ftc.teamcode.bettercode.testing.hardware;

import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadBetter0{
    private Gamepad gamepad1;
    private Gamepad gamepad2;

    public GamepadBetter0(Gamepad _gamepad1, Gamepad _gamepad2) {
        gamepad1 = _gamepad1;
        gamepad2 = _gamepad2;
    }

    abstract public class BoolInput {
        abstract public boolean getInput();
    }
    abstract public class DoubleInput {
        abstract public double getXInput();
        abstract public double getYInput();
    }

    abstract public class TouchpadInput {
        abstract public boolean getPressed();
        abstract public boolean getFinger1Pressed();
        abstract public boolean getFinger2Pressed();
        abstract public double getFinger1X();
        abstract public double getFinger2X();
        abstract public double getFinger1Y();
        abstract public double getFinger2Y();
    }

    abstract public class TriggerInput {
        abstract public boolean getBoolInput();
        abstract public double getDoubleInput();
    }

    public class Gamepad1A extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.a;
        }
    }
    public class Gamepad2A extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.a;
        }
    }
    public class Gamepad1B extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.b;
        }
    }
    public class Gamepad2B extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.b;
        }
    }
    public class Gamepad1X extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.x;
        }
    }
    public class Gamepad2X extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.x;
        }
    }
    public class Gamepad1Y extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.y;
        }
    }
    public class Gamepad2Y extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.y;
        }
    }
    public class Gamepad1DUP extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.dpad_up;
        }
    }
    public class Gamepad2DUP extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.dpad_up;
        }
    }
    public class Gamepad1DDOWN extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.dpad_down;
        }
    }
    public class Gamepad2DDOWN extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.dpad_down;
        }
    }
    public class Gamepad1DLEFT extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.dpad_left;
        }
    }
    public class Gamepad2DLEFT extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.dpad_left;
        }
    }
    public class Gamepad1DRIGHT extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.dpad_right;
        }
    }
    public class Gamepad2DRIGHT extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.dpad_right;
        }
    }
    public class Gamepad1LStickButton extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.left_stick_button;
        }
    }
    public class Gamepad2LStickButton extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.left_stick_button;
        }
    }
    public class Gamepad1RStickButton extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.right_stick_button;
        }
    }
    public class Gamepad2RStickButton extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.right_stick_button;
        }
    }
    public class Gamepad1LBumper extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.left_bumper;
        }
    }
    public class Gamepad2LBumper extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.left_bumper;
        }
    }
    public class Gamepad1RBumper extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.right_bumper;
        }
    }
    public class Gamepad2RBumper extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.right_bumper;
        }
    }
    public class Gamepad1Options extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.options;
        }
    }
    public class Gamepad2Options extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.options;
        }
    }
    public class Gamepad1Share extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad1.share;
        }
    }
    public class Gamepad2Share extends BoolInput {
        @Override
        public boolean getInput() {
            return gamepad2.share;
        }
    }

    public class Gamepad1LStick extends DoubleInput {
        @Override
        public double getXInput() {
            return gamepad1.left_stick_x;
        }

        @Override
        public double getYInput() {
            return gamepad1.left_stick_y;
        }
    }
    public class Gamepad2LStick extends DoubleInput {
        @Override
        public double getXInput() {
            return gamepad2.left_stick_x;
        }

        @Override
        public double getYInput() {
            return gamepad2.left_stick_y;
        }
    }
    public class Gamepad1RStick extends DoubleInput {
        @Override
        public double getXInput() {
            return gamepad1.right_stick_x;
        }

        @Override
        public double getYInput() {
            return gamepad1.right_stick_y;
        }
    }
    public class Gamepad2RStick extends DoubleInput {
        @Override
        public double getXInput() {
            return gamepad2.right_stick_x;
        }

        @Override
        public double getYInput() {
            return gamepad2.right_stick_y;
        }
    }

    public class Gamepad1Touchpad extends TouchpadInput {
        @Override
        public boolean getPressed() {
            return gamepad1.touchpad;
        }
        @Override
        public boolean getFinger1Pressed() {
            return gamepad1.touchpad_finger_1;
        }
        @Override
        public boolean getFinger2Pressed() {
            return gamepad1.touchpad_finger_2;
        }
        @Override
        public double getFinger1X() {
            return gamepad1.touchpad_finger_1_x;
        }
        @Override
        public double getFinger2X() {
            return gamepad1.touchpad_finger_2_x;
        }
        @Override
        public double getFinger1Y() {
            return gamepad1.touchpad_finger_1_y;
        }
        @Override
        public double getFinger2Y() {
            return gamepad1.touchpad_finger_2_y;
        }
    }
    public class Gamepad2Touchpad extends TouchpadInput {
        @Override
        public boolean getPressed() {
            return gamepad2.touchpad;
        }
        @Override
        public boolean getFinger1Pressed() {
            return gamepad2.touchpad_finger_1;
        }
        @Override
        public boolean getFinger2Pressed() {
            return gamepad2.touchpad_finger_2;
        }
        @Override
        public double getFinger1X() {
            return gamepad2.touchpad_finger_1_x;
        }
        @Override
        public double getFinger2X() {
            return gamepad2.touchpad_finger_2_x;
        }
        @Override
        public double getFinger1Y() {
            return gamepad2.touchpad_finger_1_y;
        }
        @Override
        public double getFinger2Y() {
            return gamepad2.touchpad_finger_2_y;
        }
    }


    public class Gamepad1LTrigger extends TriggerInput {
        @Override
        public boolean getBoolInput() {
            return gamepad1.left_trigger > RobotHardware0.bumperDeadZone;
        }
        @Override
        public double getDoubleInput() {
            return gamepad1.left_trigger;
        }
    }
    public class Gamepad2LTrigger extends TriggerInput {
        @Override
        public boolean getBoolInput() {
            return gamepad2.left_trigger > RobotHardware0.bumperDeadZone;
        }
        @Override
        public double getDoubleInput() {
            return gamepad2.left_trigger;
        }
    }
    public class Gamepad1RTrigger extends TriggerInput {
        @Override
        public boolean getBoolInput() {
            return gamepad1.right_trigger > RobotHardware0.bumperDeadZone;
        }
        @Override
        public double getDoubleInput() {
            return gamepad1.right_trigger;
        }
    }
    public class Gamepad2RTrigger extends TriggerInput {
        @Override
        public boolean getBoolInput() {
            return gamepad2.right_trigger > RobotHardware0.bumperDeadZone;
        }
        @Override
        public double getDoubleInput() {
            return gamepad2.right_trigger;
        }
    }
}
