package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.yellowPlace.blue;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public class Blue {
    public static TrajectorySequence getYellowPlacePathC(SampleMecanumDrive drive, String position, Pose2d endPos) {
        TrajectorySequence yellowPlacePath;
        if (position == "left") {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(54, 32))
                    .build();
        } else if (position == "mid") {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(54, 26))
                    .build();
        } else {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(54, 17))
                    .build();
        }

        return yellowPlacePath;
    }

    public static TrajectorySequence getYellowPlacePathF(SampleMecanumDrive drive, String position, Pose2d endPos) {
        TrajectorySequence yellowPlacePath;
        if (position == "left") {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(54, 30))
                    .build();
        } else if (position == "mid") {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(54, 24))
                    .build();
        } else {
            yellowPlacePath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(54, 15))
                    .build();
        }

        return yellowPlacePath;
    }
}