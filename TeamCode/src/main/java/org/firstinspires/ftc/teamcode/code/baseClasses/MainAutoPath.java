package org.firstinspires.ftc.teamcode.code.baseClasses;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.code.constants.AutoConsts;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.code.autonomous.roadrunner.trajectorysequence.TrajectorySequence;

import java.util.Objects;

abstract public class MainAutoPath {
    private MultipleTelemetry telemetry;
    protected double centerLine, leftLine, rightLine;
    protected double color;

    private AutoConsts autoConsts;

    protected String startDis, endDis, position;

    protected Pose2d startPos, endPos;

    protected SampleMecanumDrive drive;

    protected TrajectorySequence purplePath, purpleToBackdropPath, yellowPlacePath, gotoWhitePath,  parkPath;

    public void initVarsAndCamera(HardwareMap _hardwareMap, SampleMecanumDrive drive, Telemetry telemetry, String color, String startDis, String endDis) {
        autoConsts = new AutoConsts(_hardwareMap);

//         generate lines that the purple placement will depend upon
//         changes whether the bot starts close or far side
        centerLine = 14;
        leftLine = 8.;
        rightLine = 15.5;
        if (Objects.equals(startDis, "far")) {
            centerLine = -37.5;
            leftLine = -39.;
            rightLine = -31.;
        }
        if (color == "red")
        {
            this.color = 1.;
        } else {
            this.color = -1.;
        }
        // sets other variables used in path making
        this.drive = drive;
        this.startDis = startDis;
        this.endDis = endDis;
        this.telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        // start position of the bot on roadrunner's coordinate place
        startPos = new Pose2d(centerLine, -61 * this.color, Math.toRadians(-90 * this.color));
        drive.setPoseEstimate(startPos);

        // sets the processor to detect red or blue, depending on what the color is
        autoConsts.setProcessor();
        autoConsts.processor.setColor(color);

        // sets the camera with the previously build processor
        autoConsts.setCamera();
    }

    protected String getTeamElementPos() {
        String position = autoConsts.processor.getPropPosition();
        autoConsts.stopCamera();

        telemetry.addData("Position: ", position);
        telemetry.update();

        return position;
    }

    abstract public TrajectorySequence getPurplePath();

    abstract public TrajectorySequence getPurpleToBackdropPath();

    abstract public TrajectorySequence getYellowPlacePath();

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

    public SampleMecanumDrive getDrive() {return drive;}
}