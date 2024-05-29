package org.firstinspires.ftc.teamcode.code.autonomous.code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class BlueCloseMid extends MainAutonomous {
    @Override
    public void setVariables() {
        color = "blue";
        startDis = "close";
        endDis = "mid";
    }
}
