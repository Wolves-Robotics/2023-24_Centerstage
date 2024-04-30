package org.firstinspires.ftc.teamcode.code.autonomous.pathing;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.code.baseClasses.MainAutoPath;

public class RedClosePath extends MainAutoPath {
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

    @Override
    public TrajectorySequence getPurpleToBackdropPath() {
        purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                .lineTo(new Vector2d(50, -41))
                .build();

        endPos = purplePath.end();

        return purpleToBackdropPath;
    }

    @Override
    public TrajectorySequence getYellowPlacePath() {
        if (position == "left") {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, -33))
                    .build();
        } else if (position == "mid") {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, -39))
                    .build();
        } else {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, -49))
                    .build();
        }
        endPos = yellowPlacePath.end();

        return yellowPlacePath;
    }
}
