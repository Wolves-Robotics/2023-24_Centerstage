package org.firstinspires.ftc.teamcode.code.autonomous.pathing.pathParts.pathStart;

import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.code.baseClasses.MainAutoPath;

public abstract class BlueStart extends MainAutoPath {
    @Override
    public TrajectorySequence getParkPath() {
        if (endDis == "close") {
            parkPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(50, 60))
                    .build();
        } else {
            parkPath = drive.trajectorySequenceBuilder(endPos)
                    .lineTo(new Vector2d(50, 10))
                    .build();
        }

        return parkPath;
    }
}
