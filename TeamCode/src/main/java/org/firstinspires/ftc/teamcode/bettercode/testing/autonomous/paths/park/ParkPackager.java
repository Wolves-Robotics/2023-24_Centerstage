package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.park;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.camera.BaseCamera;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePathSubPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.park.blue.BlueCenter;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.park.blue.BlueEdge;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.park.red.RedCenter;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.park.red.RedEdge;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class ParkPackager extends BasePathSubPackager {
    @Override
    protected BasePath getRedPath(PathPackager paths,
                                  MecanumDrive drive,
                                  MainAutonomous.StartPosEnum startPos,
                                  MainAutonomous.EndPosEnum endPos,
                                  MainAutonomous.TrussPass trussPass,
                                  BaseCamera.PropPosEnum propPos) {
        if (endPos == MainAutonomous.EndPosEnum.EDGE) {
            return new RedEdge(paths);
        } else {
            return new RedCenter(paths);
        }
    }

    @Override
    protected BasePath getBluePath(PathPackager paths,
                                   MecanumDrive drive,
                                   MainAutonomous.StartPosEnum startPos,
                                   MainAutonomous.EndPosEnum endPos,
                                   MainAutonomous.TrussPass trussPass,
                                   BaseCamera.PropPosEnum propPos) {
        if (endPos == MainAutonomous.EndPosEnum.EDGE) {
            return new BlueEdge(paths);
        } else {
            return new BlueCenter(paths);
        }
    }
}
