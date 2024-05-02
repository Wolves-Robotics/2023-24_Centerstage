package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purple;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.code.baseClasses.MainAutoPath;

public abstract class RedClosePurple extends MainAutoPath {
    @Override
    protected Pose2d setStartPos() {
        return new Pose2d(14, -61, Math.toRadians(-90));
    }

    @Override
    public TrajectorySequence getPurplePath() {
        this.position = getTeamElementPos();

        if (position == "left") {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(25.5, -50))
                    .lineToLinearHeading(new Pose2d(9, -30, Math.toRadians(0)))
                    .lineTo(new Vector2d(16.5, -30))
                    .lineTo(new Vector2d(14, -42))
                    .turn(Math.toRadians(180))
                    .build();
        } else if (position == "mid") {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(14, -40))
                    .lineTo(new Vector2d(13, -30))
                    .lineTo(new Vector2d(14, -42))
                    .turn(Math.toRadians(-90))
                    .build();
        } else {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(22.5, -33))
                    .lineTo(new Vector2d(22.5, -45))
                    .lineTo(new Vector2d(14, -42))
                    .turn(Math.toRadians(-90))
                    .build();
        }
        endPos = purplePath.end();

        return purplePath;
    }
}
