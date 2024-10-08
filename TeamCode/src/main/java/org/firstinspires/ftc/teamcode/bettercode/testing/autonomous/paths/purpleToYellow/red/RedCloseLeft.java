package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.red;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class RedCloseLeft extends BasePath {
    public RedCloseLeft(PathPackager _paths) {
        super(_paths);
    }

    @Override
    public Action getAction(MecanumDrive drive) {
        return drive.actionBuilder(startPos)
                .lineToX(19)
                .setTangent(Math.toRadians(180))
                .splineTo(new Vector2d(50, -35), Math.toRadians(0))
                .build();
    }

    @Override
    protected Pose2d setlastPose() {
        return null;
    }
}
