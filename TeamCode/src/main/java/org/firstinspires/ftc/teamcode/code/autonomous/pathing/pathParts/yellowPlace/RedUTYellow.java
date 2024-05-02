package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.yellowPlace;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purpleToBackdrop.RedUnderTruss;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public abstract class RedUTYellow extends RedUnderTruss {
    @Override
    public TrajectorySequence getYellowPlacePath() {
        yellowPlacePath = Red.getYellowPlacePath(drive, position, endPos);
        endPos = yellowPlacePath.end();

        return yellowPlacePath;
    }
}
