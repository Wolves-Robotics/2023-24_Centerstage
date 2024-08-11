package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

@Autonomous
public class RedCloseCloseCenter extends MainAutonomous {
    @Override
    protected void setVariables() {
        color = ColorEnum.RED;
        startPos = StartPosEnum.CLOSE;
        endPos = EndPosEnum.EDGE;
        trussPass = TrussPass.CENTER;
    }
}
