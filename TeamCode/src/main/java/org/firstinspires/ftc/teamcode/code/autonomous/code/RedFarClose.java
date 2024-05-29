package org.firstinspires.ftc.teamcode.code.autonomous.code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class RedFarClose extends MainAutonomous {
    @Override
    public void setVariables() {
        color = "red";
        startDis = "far";
        endDis = "close";
    }
}
