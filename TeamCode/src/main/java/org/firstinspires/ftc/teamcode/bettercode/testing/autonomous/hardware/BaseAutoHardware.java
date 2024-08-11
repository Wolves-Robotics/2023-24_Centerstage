package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.hardware;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;

import java.util.List;

abstract public class BaseAutoHardware {
    protected RobotHardware0 robotHardware;

    private boolean initialized = false;

    abstract protected void init();
    abstract protected boolean loop();

    public BaseAutoHardware(RobotHardware0 _robotHardware) {
        robotHardware = _robotHardware;
    }

    private class doAction implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            if (!initialized) {
                init();
                initialized = true;
            }
            return loop();
        }
    }

    public Action getAction() {
        return new doAction();
    }
}
