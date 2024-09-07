package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.red;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class RedFarRight extends BasePath {
    public RedFarRight(PathPackager _paths) {
        super(_paths);
    }

    @Override
    public Action getAction(MecanumDrive drive) {
        return drive.actionBuilder(startPos)
                .setTangent(Math.toRadians(90))
                .splineTo(new Vector2d(-31, -30), Math.toRadians(0))
                .build();
    }

    @Override
    protected Pose2d setlastPose() {
        return new Pose2d(new Vector2d(-31, -30), Math.toRadians(0));
    }
}