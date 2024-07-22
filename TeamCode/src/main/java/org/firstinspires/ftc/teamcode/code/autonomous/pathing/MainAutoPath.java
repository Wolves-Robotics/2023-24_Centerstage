package org.firstinspires.ftc.teamcode.code.autonomous.pathing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
//import com.acmerobotics.roadrunner.geometry.Pose2d;
//import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.code.constants.AutoConsts;
//import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.drive.SampleMecanumDrive;
//import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

import java.util.Objects;

@Config
abstract public class MainAutoPath {
    public static double buckdayMovement = 12d;

    private MultipleTelemetry telemetry;

    public AutoConsts autoConsts;

    protected String startDis, endDis, position;

//    protected Pose2d startPos, endPos;
//
//    protected SampleMecanumDrive drive;

//    protected TrajectorySequence purplePath, purpleToBackdropPath, yellowPlacePath, gotoWhitePath,  parkPath;
//
//    abstract protected Pose2d setStartPos();

    public void setReferenceFrame() {
        autoConsts.processor.setReferenceFrame();
    }

//    public void initVarsAndCamera(HardwareMap _hardwareMap, SampleMecanumDrive _drive, Telemetry _telemetry, String _color, String _startDis, String _endDis) {
//        autoConsts = new AutoConsts(_hardwareMap);
//        telemetry = new MultipleTelemetry(_telemetry, FtcDashboard.getInstance().getTelemetry());
//
//        drive = _drive;
//        startDis = _startDis;
//        endDis = _endDis;
//
//        // start position of the bot on roadrunner's coordinate place
//        startPos = setStartPos();
//        drive.setPoseEstimate(startPos);
//
//        // sets the processor to detect red or blue, depending on what the color is
//        autoConsts.setProcessor();
////        autoConsts.processor.setColor(_color);
//
//        // sets the camera with the previously build processor
//        autoConsts.setCamera();
//
//        FtcDashboard.getInstance().startCameraStream(autoConsts.processor, 30.);
//    }

    protected String getTeamElementPos() {
        String position = autoConsts.processor.getPropPosition();
        autoConsts.stopCamera();

        telemetry.addData("Position: ", position);
        telemetry.update();

        return position;
    }

//    abstract public TrajectorySequence getPurplePath();
//
//    abstract public TrajectorySequence getPurpleToBackdropPath();
//
//    abstract public TrajectorySequence getYellowPlacePath();
//
//    abstract public TrajectorySequence getWhitePath();
//
//    abstract public TrajectorySequence getParkPath();
//
//    public SampleMecanumDrive getDrive() {return drive;}
}