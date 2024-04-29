package org.firstinspires.ftc.teamcode.code.autonomous.pathing;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.code.baseClasses.MainAutoPath;

import java.util.Objects;

public class RedFarPath extends MainAutoPath {
    @Override
    public TrajectorySequence getPurplePath() {
        this.position = getTeamElementPos();

        if (Objects.equals(position, "left")) {
            purplePath = drive.trajectorySequenceBuilder(startPos)
                    .lineTo(new Vector2d(-46.5, -33))
                    .lineTo(new Vector2d(-46.5, -45))
                    .lineTo(new Vector2d(-37.5, -42))
                    .turn(Math.toRadians(-90))
                    .build();
        } else if (Objects.equals(position, "mid")) {
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

    @Override
    public TrajectorySequence getPurpleToBackdropPath() {
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

        endPos = purplePath.end();

        return purpleToBackdropPath;
    }

    @Override
    public TrajectorySequence getYellowPlacePath() {
        if (Objects.equals(position, "left")) {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(53, -33))
                    .build();
        } else if (Objects.equals(position, "mid")) {
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

    @Override
    public TrajectorySequence getParkPath() {
        if (Objects.equals(endDis, "close")) {
            parkPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(50, -60))
                    .build();
        } else {
            parkPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(50, -10))
                    .build();
        }

        return parkPath;
    }
}
