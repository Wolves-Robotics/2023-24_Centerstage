package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.red;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

public class RedCloseCloseEdge extends MainAutonomous {
    @Override
    protected void setVariables() {
        color = ColorEnum.RED;
        startPos = StartPosEnum.CLOSE;
        endPos = EndPosEnum.EDGE;
        trussPass = TrussPass.EDGE;
    }
}
