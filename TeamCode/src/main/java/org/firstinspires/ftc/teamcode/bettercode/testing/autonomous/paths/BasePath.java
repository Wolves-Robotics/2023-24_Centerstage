package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public abstract class BasePath {
    private PathPackager paths;
    protected Pose2d startPos;

    public BasePath(PathPackager _paths) {
        paths = _paths;
        startPos = paths.getlastPose();
    }

    public Action doStuff(MecanumDrive drive) {
        paths.setLastPose(setlastPose());
        return getAction(drive);
    }

    abstract public Action getAction(MecanumDrive drive);

    protected abstract Pose2d setlastPose();
}
