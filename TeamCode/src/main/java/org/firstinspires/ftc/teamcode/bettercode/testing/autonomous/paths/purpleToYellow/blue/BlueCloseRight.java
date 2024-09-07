package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.blue;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class BlueCloseRight extends BasePath {
    public BlueCloseRight(PathPackager _startPos) {
        super(_startPos);
    }

    @Override
    public Action getAction(MecanumDrive drive) {
        return drive.actionBuilder(startPos)
                .lineToX(19)
                .setTangent(Math.toRadians(180))
                .splineTo(new Vector2d(50, 20), Math.toRadians(0))
                .build();
    }

    @Override
    protected Pose2d setlastPose() {
        return null;
    }
}
