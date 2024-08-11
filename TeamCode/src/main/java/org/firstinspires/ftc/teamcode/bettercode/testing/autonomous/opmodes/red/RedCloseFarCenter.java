package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.red;


import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

public class RedCloseFarCenter extends MainAutonomous {
    @Override
    public void setVariables() {
        color = ColorEnum.RED;
        startPos = StartPosEnum.CLOSE;
        endPos = EndPosEnum.CENTER;
        trussPass = TrussPass.CENTER;
    }
}
