package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.yellowPlace.blue;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purpleToBackdrop.blue.BlueUnderTruss;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public abstract class BlueUTYellow extends BlueUnderTruss {
    @Override
    public TrajectorySequence getYellowPlacePath() {
        yellowPlacePath = Blue.getYellowPlacePath(drive, position, endPos);
        endPos = yellowPlacePath.end();

        return yellowPlacePath;
    }
}
