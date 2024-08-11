package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.blue;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

public class BlueCloseFarEdge extends MainAutonomous {
    @Override
    protected void setVariables() {
        color = ColorEnum.BLUE;
        startPos = StartPosEnum.CLOSE;
        endPos = EndPosEnum.CENTER;
        trussPass = TrussPass.EDGE;
    }
}
