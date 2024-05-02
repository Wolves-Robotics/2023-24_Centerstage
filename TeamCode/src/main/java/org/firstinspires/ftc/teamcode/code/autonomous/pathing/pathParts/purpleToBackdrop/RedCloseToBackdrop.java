package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purpleToBackdrop;

import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purple.RedClosePurple;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public abstract class RedCloseToBackdrop extends RedClosePurple {
    @Override
    public TrajectorySequence getPurpleToBackdropPath() {
        purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                .lineTo(new Vector2d(50, -41))
                .build();
        endPos = purplePath.end();

        return purpleToBackdropPath;
    }
}
