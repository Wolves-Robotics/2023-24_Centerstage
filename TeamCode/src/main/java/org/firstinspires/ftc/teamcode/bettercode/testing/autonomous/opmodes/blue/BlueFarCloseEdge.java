package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.blue;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

public class BlueFarCloseEdge extends MainAutonomous {
    @Override
    protected void setVariables() {
        color = ColorEnum.BLUE;
        startPos = StartPosEnum.FAR;
        endPos = EndPosEnum.EDGE;
        trussPass = TrussPass.EDGE;
    }
}
