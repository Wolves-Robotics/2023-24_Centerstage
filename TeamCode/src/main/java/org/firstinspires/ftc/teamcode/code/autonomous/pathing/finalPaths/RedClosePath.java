package org.firstinspires.ftc.teamcode.code.autonomous.pathing.finalPaths;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.yellowPlace.red.RedCloseYellow;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public class RedClosePath extends RedCloseYellow {
    @Override
    public TrajectorySequence getWhitePath() {
        return null;
    }
}
