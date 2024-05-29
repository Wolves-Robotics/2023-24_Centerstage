package org.firstinspires.ftc.teamcode.code.autonomous.code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class RedFarMid extends MainAutonomous {
    @Override
    public void setVariables() {
        color = "red";
        startDis = "far";
        endDis = "mid";
    }
}
