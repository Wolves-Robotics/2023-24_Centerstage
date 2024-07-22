package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.hardware;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;

import java.util.List;

abstract public class BaseAutoHardware implements Action {
    protected RobotHardware0 robotHardware;

    private boolean initialized = false;

    abstract protected void init();
    abstract protected boolean loop();

    public BaseAutoHardware(HardwareMap hardwareMap, List<LynxModule> allHubs) {
        robotHardware = new RobotHardware0(hardwareMap, allHubs);
    }

    @Override
    public boolean run(@NonNull TelemetryPacket packet) {
        if (!initialized) {
            initialized = true;
            init();
        }

        return loop();
    }
}
