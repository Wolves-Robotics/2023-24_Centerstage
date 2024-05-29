package org.firstinspires.ftc.teamcode.code.autonomous.code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class RedCloseClose extends MainAutonomous {
    @Override
    public void setVariables() {
        color = "red";
        startDis = "close";
        endDis = "close";
    }
}
