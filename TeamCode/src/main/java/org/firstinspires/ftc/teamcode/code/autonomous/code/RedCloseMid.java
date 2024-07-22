package org.firstinspires.ftc.teamcode.code.autonomous.code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
@Autonomous
public class RedCloseMid extends MainAutonomous {
    @Override
    public void setVariables() {
        color = "red";
        startDis = "close";
        endDis = "mid";
    }
}
