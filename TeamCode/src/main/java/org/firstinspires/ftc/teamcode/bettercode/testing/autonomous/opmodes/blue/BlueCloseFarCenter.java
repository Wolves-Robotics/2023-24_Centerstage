package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.blue;


import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

public class BlueCloseFarCenter extends MainAutonomous {
    @Override
    public void setVariables() {
        color = ColorEnum.BLUE;
        startPos = StartPosEnum.CLOSE;
        endPos = EndPosEnum.CENTER;
        trussPass = TrussPass.CENTER;
    }
}
