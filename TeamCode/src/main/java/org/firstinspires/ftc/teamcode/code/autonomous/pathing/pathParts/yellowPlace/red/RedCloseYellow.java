package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.yellowPlace.red;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purpleToBackdrop.red.RedCloseToBackdrop;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public abstract class RedCloseYellow extends RedCloseToBackdrop {
    @Override
    public TrajectorySequence getYellowPlacePath() {
        yellowPlacePath = Red.getYellowPlacePath(drive, position, endPos);
        endPos = yellowPlacePath.end();

        return yellowPlacePath;
    }
}
