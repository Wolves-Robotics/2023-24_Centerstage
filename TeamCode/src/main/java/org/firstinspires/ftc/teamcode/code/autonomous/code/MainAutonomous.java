package org.firstinspires.ftc.teamcode.code.autonomous.code;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.PathingWrapper;
import org.firstinspires.ftc.teamcode.code.autonomous.pathing.MainAutoPath;
import org.firstinspires.ftc.teamcode.code.constants.AutoConsts;
import org.firstinspires.ftc.teamcode.code.constants.Consts;

@Disabled
@Autonomous(group = "Auto")
public abstract class MainAutonomous extends OpMode {
    Consts consts;
    AutoConsts.autoEnums autoEnums;

    public String startDis, endDis, color;

//    SampleMecanumDrive drive;
//
//    TrajectorySequence purplePath, purpleToBackdropPath, yellowPlacePath, parkPath;

    private ElapsedTime runtime;

    MainAutoPath pathingTool;

    public abstract void setVariables();

    @Override
    public void init() {
        setVariables();

        consts = new Consts(hardwareMap);
        autoEnums = new AutoConsts.autoEnums();

        consts.setInit();

        runtime = new ElapsedTime();

//        drive = new SampleMecanumDrive(hardwareMap);
//
//        pathingTool = PathingWrapper.getPath(color, startDis);
//
//        pathingTool.initVarsAndCamera(hardwareMap, drive, telemetry, color, startDis, endDis);

        consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLACK);

    }

    @Override
    public void init_loop() {
        if (gamepad1.a) {
            pathingTool.setReferenceFrame();
        }
    }

    @Override
    public void start() {
        runtime.reset();
//        purplePath = pathingTool.getPurplePath();
//        purpleToBackdropPath = pathingTool.getPurpleToBackdropPath();
//        yellowPlacePath = pathingTool.getYellowPlacePath();
//        parkPath = pathingTool.getParkPath();
//
//        drive = pathingTool.getDrive();
//        drive.followTrajectorySequenceAsync(purplePath);
    }

    @Override
    public void loop()
    {
        switch(autoEnums.state)
        {
            case PLACE_PURPLE:
//                if (!drive.isBusy()) {
//                    autoEnums.state = AutoConsts.State.Idle;
////                    drive.followTrajectorySequenceAsync(purpleToBackdropPath);
//                }
                break;
            case PLACE_YELLOW:
                switch(autoEnums.yellowState)
                {
                    case DRIVE:
//                        if (!drive.isBusy()) {
//                            autoEnums.yellowState = AutoConsts.YellowState.POSITION;
//                            drive.followTrajectorySequenceAsync(yellowPlacePath);
//                        }
//                        break;
//                    case POSITION:
//                        if (!drive.isBusy()) {
//                            runtime.reset();
//                            autoEnums.yellowState = AutoConsts.YellowState.PLACE;
//                        }
                        break;
                    case PLACE:
                        consts.popper.setPosition(0.6);
                        if (runtime.time() > 1) {
                            consts.popper.setPosition(0);
                            autoEnums.state = AutoConsts.State.SCORE;
                        }
                        break;
                }
                break;
            case SCORE:
                autoEnums.state = AutoConsts.State.PARK;
//                drive.followTrajectorySequenceAsync(parkPath);
                break;
            case PARK:
//                if (!drive.isBusy()) {
//                    autoEnums.state = AutoConsts.State.Idle;
//                }
                break;
            case Idle:
                break;
        }

//        drive.update();
    }
}
