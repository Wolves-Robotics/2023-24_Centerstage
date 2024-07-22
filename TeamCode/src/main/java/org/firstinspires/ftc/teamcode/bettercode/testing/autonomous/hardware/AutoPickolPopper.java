package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.hardware;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;

import java.util.List;

public class AutoPickolPopper extends BaseAutoHardware{
    private ElapsedTime elapsedTime;

    public AutoPickolPopper(HardwareMap _hardwareMap, List<LynxModule> _allHubs) {
        super(_hardwareMap, _allHubs);
    }

    @Override
    protected void init() {
        elapsedTime = new ElapsedTime();
        robotHardware.setServoPos(RobotHardware0.Names.pickol, 0.6);
    }

    @Override
    protected boolean loop() {
        if (elapsedTime.seconds() > 1) {
            robotHardware.setServoPos(RobotHardware0.Names.pickol, 0);
            return true;
        }

        return false;
    }
}
