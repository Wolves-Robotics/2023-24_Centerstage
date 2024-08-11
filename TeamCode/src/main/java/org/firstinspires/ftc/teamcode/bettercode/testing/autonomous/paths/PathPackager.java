package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.camera.BaseCamera;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.park.ParkPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.purpleToYellow.PurpleToYellowPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.toPurple.ToPurplePackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;

public class PathPackager {
    private MecanumDrive drive;

    private MainAutonomous.StartPosEnum startPos;
    private MainAutonomous.EndPosEnum endPos;
    private MainAutonomous.TrussPass trussPass;
    private MainAutonomous.ColorEnum color;

    private Pose2d lastPose;

    private Action toPurple, purpleToYellow, park;

    public PathPackager(MecanumDrive _drive, MainAutonomous.StartPosEnum _startPos, MainAutonomous.EndPosEnum _endPos, MainAutonomous.TrussPass _trussPass, MainAutonomous.ColorEnum _color) {
        drive = _drive;
        lastPose = drive.pose;

        startPos = _startPos;
        endPos = _endPos;
        trussPass = _trussPass;
        color = _color;
    }

    public void generatePaths(BaseCamera.PropPosEnum propPos) {
        getStartPos();
        toPurple = new ToPurplePackager().getPath(this, drive, color, startPos, endPos, trussPass, propPos);
        purpleToYellow = new PurpleToYellowPackager().getPath(this, drive, color, startPos, endPos, trussPass, propPos);
        park = new ParkPackager().getPath(this, drive, color, startPos, endPos, trussPass, propPos);
    }

    private void getStartPos() {
        //TODO: if pose is fucked, change these
        //they are operating under the assumption that changing drive.pose overrides the pose given during init
        if (color == MainAutonomous.ColorEnum.RED) {
            if (startPos == MainAutonomous.StartPosEnum.CLOSE) {
                drive.pose = new Pose2d(14, -63, Math.toRadians(-90));
            } else if (startPos == MainAutonomous.StartPosEnum.FAR) {
                drive.pose = new Pose2d(-37.5, -63, Math.toRadians(-90));
            }
        } else if (color == MainAutonomous.ColorEnum.BLUE) {
            if (startPos == MainAutonomous.StartPosEnum.CLOSE) {
                drive.pose = new Pose2d(14, 63, Math.toRadians(90));
            } else if (startPos == MainAutonomous.StartPosEnum.FAR) {
                drive.pose = new Pose2d(-37.5, 63, Math.toRadians(90));
            }
        }
    }

    public void setLastPose(Pose2d pose) {lastPose = pose;}
    public Pose2d getlastPose() {return lastPose;}

    public Action getToPurple() {
        return toPurple;
    }
    public Action getPurpleToYellow() {
        return purpleToYellow;
    }
    public Action getPark() {
        return park;
    }
}
