package org.firstinspires.ftc.teamcode.code.autonomous.pathing.finalPaths;

import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purpleToBackdrop.BlueCloseToBackdrop;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public class BlueClosePath extends BlueCloseToBackdrop {

    @Override
    public TrajectorySequence getWhitePath() {
        return null;
    }
}
