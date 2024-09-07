package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.park.blue;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class BlueCenter extends BasePath {
    public BlueCenter(PathPackager _startPos) {
        super(_startPos);
    }

    @Override
    public Action getAction(MecanumDrive drive) {
        return drive.actionBuilder(startPos)
                .setTangent(Math.toRadians(-90))
                .lineToY(12)
                .build();
    }

    @Override
    protected Pose2d setlastPose() {
        return null;
    }
}
