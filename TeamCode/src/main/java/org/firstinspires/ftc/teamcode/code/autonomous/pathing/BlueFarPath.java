package org.firstinspires.ftc.teamcode.code.autonomous.pathing;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.code.baseClasses.MainAutoPath;

import java.util.Objects;

public class BlueFarPath extends MainAutoPath {
    @Override
    public TrajectorySequence getPurplePath() {
        this.position = getTeamElementPos();

        if (position == "left") {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(leftLine - 10, 50))
                    .lineToLinearHeading(new Pose2d(rightLine - 1, 30, Math.toRadians(180)))
                    .lineTo(new Vector2d(leftLine, 30))
                    .lineTo(new Vector2d(centerLine, 42))
                    .build();
        } else if (position == "mid") {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(centerLine, 40))
                    .lineTo(new Vector2d(centerLine + 1, 32))
                    .lineTo(new Vector2d(centerLine, 42))
                    .turn(Math.toRadians(90))
                    .build();
        } else {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(leftLine - 7.5, 38))
                    .lineTo(new Vector2d(leftLine - 7.5, 45))
                    .lineTo(new Vector2d(centerLine, 42))
                    .turn(Math.toRadians(90))
                    .build();
        }
        endPos = purplePath.end();

        return purplePath;
    }

    @Override
    public TrajectorySequence getPurpleToBackdropPath() {
        if (position == "mid") {
            purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(-53, 42))
                    .lineTo(new Vector2d(-53, 2))
                    .lineTo(new Vector2d(38, 2))
                    .lineTo(new Vector2d(50, 41))
                    .build();
        } else {
            purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(-35, 2))
                    .lineTo(new Vector2d(38, 2))
                    .lineTo(new Vector2d(50, 41))
                    .build();
        }
        endPos = purpleToBackdropPath.end();

        return purpleToBackdropPath;
    }

    @Override
    public TrajectorySequence getYellowPlacePath() {
        if (position == "left") {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, 34))
                    .build();
        } else if (position == "mid") {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, 26))
                    .build();
        } else {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, 21))
                    .build();
        }
        endPos = yellowPlacePath.end();

        return yellowPlacePath;
    }
}
