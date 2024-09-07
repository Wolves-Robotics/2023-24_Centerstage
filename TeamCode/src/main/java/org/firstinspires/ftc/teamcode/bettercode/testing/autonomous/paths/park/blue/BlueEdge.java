package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.park.blue;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class BlueEdge extends BasePath {
    public BlueEdge(PathPackager _startPos) {
        super(_startPos);
    }

    @Override
    public Action getAction(MecanumDrive drive) {
        return drive.actionBuilder(startPos)
                .setTangent(Math.toRadians(-90))
                .lineToY(60)
                .build();
    }

    @Override
    protected Pose2d setlastPose() {
        return null;
    }
}
