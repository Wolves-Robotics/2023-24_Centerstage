package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purple.red;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.pathStart.RedStart;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public abstract class RedFarPurple extends RedStart {
    @Override
    protected Pose2d setStartPos() {
        return new Pose2d(-37.5, -61, Math.toRadians(-90));
    }

    @Override
    public TrajectorySequence getPurplePath() {
        this.position = getTeamElementPos();

        if (position == "left") {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(-46.5, -33))
                    .lineTo(new Vector2d(-46.5, -45))
                    .lineTo(new Vector2d(-37.5, -42))
                    .turn(Math.toRadians(-90))
                    .build();
        } else if (position == "mid") {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(-37.5, -40))
                    .lineTo(new Vector2d(-36.5, -30))
                    .lineTo(new Vector2d(-37.5, -42))
                    .turn(Math.toRadians(-90))
                    .build();
        } else {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(-21, 50))
                    .lineToLinearHeading(new Pose2d(-38, 30, Math.toRadians(0)))
                    .lineTo(new Vector2d(-31, 30))
                    .lineTo(new Vector2d(-37.5, 42))
                    .turn(Math.toRadians(180))
                    .build();
        }
        endPos = purplePath.end();

        return purplePath;
    }
}
