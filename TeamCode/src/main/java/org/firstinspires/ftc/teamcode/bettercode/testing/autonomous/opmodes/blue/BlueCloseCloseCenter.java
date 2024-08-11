package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

@Autonomous
public class BlueCloseCloseCenter extends MainAutonomous {
    @Override
    protected void setVariables() {
        color = ColorEnum.BLUE;
        startPos = StartPosEnum.CLOSE;
        endPos = EndPosEnum.EDGE;
        trussPass = TrussPass.CENTER;
    }
}
