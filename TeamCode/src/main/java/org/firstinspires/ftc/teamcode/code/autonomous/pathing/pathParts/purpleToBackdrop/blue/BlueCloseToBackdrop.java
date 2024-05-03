package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purpleToBackdrop.blue;

import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purple.blue.BlueClosePurple;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public abstract class BlueCloseToBackdrop extends BlueClosePurple {
    @Override
    public TrajectorySequence getPurpleToBackdropPath() {
        purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                .lineTo(new Vector2d(50, 41))
                .build();
        endPos = purpleToBackdropPath.end();

        return purpleToBackdropPath;
    }
}
