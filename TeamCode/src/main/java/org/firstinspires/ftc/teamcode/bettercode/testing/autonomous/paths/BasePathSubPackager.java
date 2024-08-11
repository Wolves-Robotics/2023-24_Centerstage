package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths;

import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.camera.BaseCamera;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

abstract public class BasePathSubPackager {
    public Action getPath(PathPackager paths,
                          MecanumDrive drive,
                          MainAutonomous.ColorEnum color,
                          MainAutonomous.StartPosEnum startPos,
                          MainAutonomous.EndPosEnum endPos,
                          MainAutonomous.TrussPass trussPass,
                          BaseCamera.PropPosEnum propPos) {
        if (color == MainAutonomous.ColorEnum.RED) {
            return getRedPath(paths, drive, startPos, endPos, trussPass, propPos).getAction(drive);
        } else {
            return getBluePath(paths, drive, startPos, endPos, trussPass, propPos).getAction(drive);
        }
    }

    abstract protected BasePath getRedPath(PathPackager paths,
                                           MecanumDrive drive,
                                           MainAutonomous.StartPosEnum startPos,
                                           MainAutonomous.EndPosEnum endPos,
                                           MainAutonomous.TrussPass trussPass,
                                           BaseCamera.PropPosEnum propPos);

    abstract protected BasePath getBluePath(PathPackager paths,
                                            MecanumDrive drive,
                                            MainAutonomous.StartPosEnum startPos,
                                            MainAutonomous.EndPosEnum endPos,
                                            MainAutonomous.TrussPass trussPass,
                                            BaseCamera.PropPosEnum propPos);
}
