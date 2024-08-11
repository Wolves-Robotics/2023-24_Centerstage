package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.red;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

public class RedFarFarEdge extends MainAutonomous {
    @Override
    protected void setVariables() {
        color = ColorEnum.RED;
        startPos = StartPosEnum.FAR;
        endPos = EndPosEnum.CENTER;
        trussPass = TrussPass.EDGE;
    }
}
