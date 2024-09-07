package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.red;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class RedCloseRight extends BasePath {
    public RedCloseRight(PathPackager _startPos) {
        super(_startPos);
    }

    @Override
    public Action getAction(MecanumDrive drive) {
        return drive.actionBuilder(startPos)
                .lineToY(-45)
                .setTangent(Math.toRadians(90))
                .splineTo(new Vector2d(50, -49), Math.toRadians(0))
                .build();
    }

    @Override
    protected Pose2d setlastPose() {
        return null;
    }
}