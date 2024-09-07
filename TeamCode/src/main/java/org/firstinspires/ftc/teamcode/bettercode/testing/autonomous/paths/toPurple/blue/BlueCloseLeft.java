package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.blue;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class BlueCloseLeft extends BasePath {
    public BlueCloseLeft(PathPackager _paths) {
        super(_paths);
    }

    @Override
    public Action getAction(MecanumDrive drive) {
        return drive.actionBuilder(startPos)
                .setTangent(Math.toRadians(-90))
                .splineTo(new Vector2d(23, 33), Math.toRadians(-90))
                .build();
    }

    @Override
    protected Pose2d setlastPose() {
        return new Pose2d(new Vector2d(23, 33), Math.toRadians(-90));
    }
}