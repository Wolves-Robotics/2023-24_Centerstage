package org.firstinspires.ftc.teamcode.code.autonomous.code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
@Autonomous
public class BlueFarMid extends MainAutonomous {
    @Override
    public void setVariables() {
        color = "blue";
        startDis = "far";
        endDis = "mid";
    }
}
