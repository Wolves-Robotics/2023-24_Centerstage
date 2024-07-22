package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.red;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

class RedCloseClose extends MainAutonomous {
    @Override
    protected void setVariables() {
        color = colorEnum.RED;
        startPos = startPosEnum.CLOSE;
        endPos = endPosEnum.CLOSE;
    }
}
