package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.yellowPlace.blue;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public class Blue {
    public static TrajectorySequence getYellowPlacePath(SampleMecanumDrive drive, String position, Pose2d endPos) {
        TrajectorySequence yellowPlacePath;
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

        return yellowPlacePath;
    }
}