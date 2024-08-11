package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.park.red;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class RedEdge extends BasePath {
    public RedEdge(Pose2d _startPos) {
        super(_startPos);
    }

    @Override
    public Action getAction(MecanumDrive drive) {
        return drive.actionBuilder(startPos)
                .setTangent(Math.toRadians(90))
                .lineToY(-60)
                .build();
    }
}
