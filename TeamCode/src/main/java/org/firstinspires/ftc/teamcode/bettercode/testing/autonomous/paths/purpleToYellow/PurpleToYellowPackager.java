package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.camera.BaseCamera;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePathSubPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.blue.BlueCloseLeft;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.blue.BlueCloseMid;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.blue.BlueCloseRight;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.red.RedCloseLeft;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.red.RedCloseMid;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.red.RedCloseRight;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class PurpleToYellowPackager extends BasePathSubPackager {
    @Override
    protected BasePath getRedPath(PathPackager paths,
                                  MecanumDrive drive,
                                  MainAutonomous.StartPosEnum startPos,
                                  MainAutonomous.EndPosEnum endPos,
                                  MainAutonomous.TrussPass trussPass,
                                  BaseCamera.PropPosEnum propPos) {
        if (startPos == MainAutonomous.StartPosEnum.CLOSE) {
            if (propPos == BaseCamera.PropPosEnum.LEFT) {
                return new RedCloseLeft();
            } else if (propPos == BaseCamera.PropPosEnum.MID) {
                return new RedCloseMid();
            } else {
                return new RedCloseRight();
            }
        } else {
            if (propPos == BaseCamera.PropPosEnum.LEFT) {
                return null;
            } else if (propPos == BaseCamera.PropPosEnum.MID) {
                return null;
            } else {
                return null;
            }
        }
    }

    @Override
    protected BasePath getBluePath(PathPackager paths,
                                   MecanumDrive drive,
                                   MainAutonomous.StartPosEnum startPos,
                                   MainAutonomous.EndPosEnum endPos,
                                   MainAutonomous.TrussPass trussPass,
                                   BaseCamera.PropPosEnum propPos) {
        if (startPos == MainAutonomous.StartPosEnum.CLOSE) {
            if (propPos == BaseCamera.PropPosEnum.LEFT) {
                return new BlueCloseLeft();
            } else if (propPos == BaseCamera.PropPosEnum.MID) {
                return new BlueCloseMid();
            } else {
                return new BlueCloseRight();
            }
        } else {
            if (propPos == BaseCamera.PropPosEnum.LEFT) {
                return null;
            } else if (propPos == BaseCamera.PropPosEnum.MID) {
                return null;
            } else {
                return null;
            }
        }
    }
}
