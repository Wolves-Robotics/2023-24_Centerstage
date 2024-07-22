package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class RedClosePath extends BasePath {
    @Override
    protected void setAction(MecanumDrive drive) {
        action = drive.actionBuilder(drive.pose)
                .build();
    }
}
