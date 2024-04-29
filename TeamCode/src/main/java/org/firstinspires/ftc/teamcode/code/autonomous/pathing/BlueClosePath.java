package org.firstinspires.ftc.teamcode.code.autonomous.pathing;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.code.baseClasses.MainAutoPath;

import java.util.Objects;

public class BlueClosePath extends MainAutoPath {
    public TrajectorySequence getPurplePath() {
        this.position = getTeamElementPos();

        if (Objects.equals(position, "left")) {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(22.5, 33))
                    .lineTo(new Vector2d(22.5, 45))
                    .lineTo(new Vector2d(14, 42))
                    .turn(Math.toRadians(-90))
                    .build();
        } else if (Objects.equals(position, "mid")) {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(14, 40))
                    .lineTo(new Vector2d(13, 30))
                    .lineTo(new Vector2d(14, 42))
                    .turn(Math.toRadians(90))
                    .build();
        } else {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(25.5, 50))
                    .lineToLinearHeading(new Pose2d(8, 30, Math.toRadians(0)))
                    .lineTo(new Vector2d(15.5, 30))
                    .lineTo(new Vector2d(14, 42))
                    .turn(Math.toRadians(180))
                    .build();
        }

        endPos = purplePath.end();

        return purplePath;
    }

    public TrajectorySequence getPurpleToBackdropPath() {
        if (Objects.equals(startDis, "close")) {
            purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(50, 41))
                    .build();
        } else {
            if (Objects.equals(position, "mid")) {
                purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                        .lineTo(new Vector2d(-53, -42))
                        .lineTo(new Vector2d(-53, -2))
                        .lineTo(new Vector2d(38, -2))
                        .lineTo(new Vector2d(50, -41))
                        .build();
            } else {
                purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                        .lineTo(new Vector2d(-35, -2))
                        .lineTo(new Vector2d(38, -2))
                        .lineTo(new Vector2d(50, -41))
                        .build();
            }
        }
        endPos = purpleToBackdropPath.end();

        return purpleToBackdropPath;
    }

    public TrajectorySequence getYellowPlacePath() {
        if (Objects.equals(position, "left")) {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, -34))
                    .build();
            endPos = new Pose2d(53, -34, Math.toRadians(180));
        } else if (Objects.equals(position, "mid")) {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, -26))
                    .build();
            endPos = new Pose2d(53, -26, Math.toRadians(180));
        } else {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, -21))
                    .build();
            endPos = new Pose2d(53, -21, Math.toRadians(180));
        }

        return yellowPlacePath;
    }
    @Override
    public TrajectorySequence getParkPath() {
        if (Objects.equals(endDis, "close")) {
            parkPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(50, 60))
                    .build();
        } else {
            parkPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(50, 10))
                    .build();
        }

        return parkPath;
    }
}
