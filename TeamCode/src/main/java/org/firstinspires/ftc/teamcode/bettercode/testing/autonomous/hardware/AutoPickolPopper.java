package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.hardware;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;

import java.util.List;

public class AutoPickolPopper extends BaseAutoHardware{
    public ElapsedTime elapsedTime;
    private Telemetry telemetry;

    public AutoPickolPopper(RobotHardware0 _robotHardware, Telemetry _telemetry) {
        super(_robotHardware);
        elapsedTime = new ElapsedTime();
        telemetry = _telemetry;
    }

    @Override
    protected void init() {
        elapsedTime.reset();
        robotHardware.setServoPos(RobotHardware0.Names.pickol, 0.6);
    }

    @Override
    protected boolean loop() {
        if (elapsedTime.seconds() > 1) {
            robotHardware.setServoPos(RobotHardware0.Names.pickol, 0);
            return false;
        }
        return true;
    }
}
