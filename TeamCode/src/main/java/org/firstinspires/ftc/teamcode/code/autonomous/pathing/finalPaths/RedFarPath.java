package org.firstinspires.ftc.teamcode.code.autonomous.pathing.finalPaths;

import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purple.RedFarPurple;
import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purpleToBackdrop.RedThroughDoor;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public class RedFarPath extends RedThroughDoor {
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

    @Override
    public TrajectorySequence getWhitePath() {
        return null;
    }
}
