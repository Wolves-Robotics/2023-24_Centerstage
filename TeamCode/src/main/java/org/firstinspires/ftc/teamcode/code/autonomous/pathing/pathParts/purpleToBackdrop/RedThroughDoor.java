package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purpleToBackdrop;

import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.purple.RedFarPurple;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

public abstract class RedThroughDoor extends RedFarPurple {
    @Override
    public TrajectorySequence getPurpleToBackdropPath() {
        if (position == "mid") {
            purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(-53, -42))
                    .lineTo(new Vector2d(-53, -2))
                    .lineTo(new Vector2d(38, -2))
                    .lineTo(new Vector2d(50, -41))
                    .build();
        } else {
            purpleToBackdropPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(-35, -2))
                    .lineTo(new Vector2d(38, -2))
                    .lineTo(new Vector2d(50, -41))
                    .build();
        }
        endPos = purplePath.end();

        return purpleToBackdropPath;
    }
}
