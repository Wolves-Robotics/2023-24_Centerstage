package org.firstinspires.ftc.teamcode.bettercode.testing.teleop.opmodes;

import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0;

public class TwoPlayer0 extends BaseTeleop0{
    @Override
    protected GamepadBetter0.DoubleInput setMovement() {
        return gamepadBetter.new Gamepad1LStick();
    }

    @Override
    protected GamepadBetter0.DoubleInput setRotation() {
        return null;
    }

    @Override
    protected GamepadBetter0.TriggerInput setLeftTrigger() {
        return gamepadBetter.new Gamepad1LTrigger();
    }

    @Override
    protected GamepadBetter0.TriggerInput setRightTrigger() {
        return gamepadBetter.new Gamepad1RTrigger();
    }

    @Override
    protected GamepadBetter0.BoolInput setMovementChange() {
        return gamepadBetter.new Gamepad1LStickButton();
    }

    @Override
    protected GamepadBetter0.BoolInput setResetYaw() {
        return gamepadBetter.new Gamepad1Options();
    }

    @Override
    protected GamepadBetter0.BoolInput setClawChange() {
        return null;
    }
}
