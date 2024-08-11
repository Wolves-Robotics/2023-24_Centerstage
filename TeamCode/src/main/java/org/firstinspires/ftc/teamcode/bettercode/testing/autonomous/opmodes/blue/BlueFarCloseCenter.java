package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.blue;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

public class BlueFarCloseCenter extends MainAutonomous {
    @Override
    protected void setVariables() {
        color = ColorEnum.BLUE;
        startPos = StartPosEnum.FAR;
        endPos = EndPosEnum.EDGE;
        trussPass = TrussPass.CENTER;
    }
}
