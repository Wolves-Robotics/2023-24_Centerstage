package org.firstinspires.ftc.teamcode.code.autonomous.pathing.finalPaths;

import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purple.BlueFarPurple;
import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purpleToBackdrop.BlueThroughDoor;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public class BlueFarPath extends BlueThroughDoor {
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

    @Override
    public TrajectorySequence getWhitePath() {
        return null;
    }
}
