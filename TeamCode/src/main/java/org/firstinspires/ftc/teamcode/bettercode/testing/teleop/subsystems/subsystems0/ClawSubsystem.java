package org.firstinspires.ftc.teamcode.bettercode.testing.teleop.subsystems.subsystems0;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0;

public class ClawSubsystem extends BaseSubsystem{
    private ElapsedTime elapsedTime;
    private GamepadBetter0.BoolInput switchInput;

    private boolean clawOpen = true;
    private double clawChangeTime = 0.;

    public void setSwitchInput(GamepadBetter0.BoolInput boolInput) {
        switchInput = boolInput;
    }

    public ClawSubsystem(RobotHardware0 _robotHardware) {
        super(_robotHardware);
        elapsedTime = new ElapsedTime();
    }

    @Override
    protected void doShit() {
        if (switchInput.getInput() && elapsedTime.seconds() - clawChangeTime >= 0.3) {
            clawOpen = !clawOpen;
            if (clawOpen) {
                setOpen();
            } else {
                setClose();
            }
            clawChangeTime = elapsedTime.seconds();
        }
    }

    private void setClose() {
        robotHardware.setServoPos(RobotHardware0.Names.claw, 0.6);
    }

    private void setOpen() {
        robotHardware.setServoPos(RobotHardware0.Names.claw, 0);
    }
}
