package org.firstinspires.ftc.teamcode.code.autonomous.code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class RedCloseMid extends MainAutonomous {
    @Override
    public void setVariables() {
        color = "red";
        startDis = "close";
        endDis = "mid";
    }
}
