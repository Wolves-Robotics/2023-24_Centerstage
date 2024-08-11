package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.camera.BaseCamera;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePath;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.BasePathSubPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.blue.BlueCloseLeft;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.blue.BlueCloseMid;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.blue.BlueFarLeft;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.blue.BlueFarMid;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.blue.BlueFarRight;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.red.RedCloseLeft;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.red.RedCloseMid;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.red.RedCloseRight;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.red.RedFarLeft;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.red.RedFarMid;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.red.RedFarRight;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class ToPurplePackager extends BasePathSubPackager {
    @Override
    protected BasePath getRedPath(PathPackager paths,
                                  MecanumDrive drive,
                                  MainAutonomous.StartPosEnum startPos,
                                  MainAutonomous.EndPosEnum endPos,
                                  MainAutonomous.TrussPass trussPass,
                                  BaseCamera.PropPosEnum propPos) {
        if(startPos == MainAutonomous.StartPosEnum.CLOSE) {
            if (propPos == BaseCamera.PropPosEnum.LEFT) {
                return new RedCloseLeft(paths);
            } else if (propPos == BaseCamera.PropPosEnum.MID) {
                return new RedCloseMid(paths);
            } else {
                return new RedCloseRight(paths);
            }
        } else {
            if (propPos == BaseCamera.PropPosEnum.LEFT) {
                return new RedFarLeft(paths);
            } else if (propPos == BaseCamera.PropPosEnum.MID) {
                return new RedFarMid(paths);
            } else {
                return new RedFarRight(paths);
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
        if(startPos == MainAutonomous.StartPosEnum.CLOSE) {
            if (propPos == BaseCamera.PropPosEnum.LEFT) {
                return new BlueCloseLeft(paths);
            } else if (propPos == BaseCamera.PropPosEnum.MID) {
                return new BlueCloseMid(paths);
            } else {
                return new BlueCloseMid(paths);
            }
        } else {
            if (propPos == BaseCamera.PropPosEnum.LEFT) {
                return new BlueFarLeft(paths);
            } else if (propPos == BaseCamera.PropPosEnum.MID) {
                return new BlueFarMid(paths);
            } else {
                return new BlueFarRight(paths);
            }
        }
    }
}
