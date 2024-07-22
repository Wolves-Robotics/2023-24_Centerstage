package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes;

import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.hardware.AutoPickolPopper;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;

import java.util.List;

abstract public class MainAutonomous extends OpMode {
    private RobotHardware0 robotHardware;
    private List<LynxModule> allHubs;

    private GamepadBetter0 gamepadBetter;
    private GamepadBetter0.Gamepad1A getFrameButton;

    private MecanumDrive drive;

    private PathPackager pathPackager;

    private AutoPickolPopper pickolPopper;

    public enum colorEnum {
        RED,
        BLUE
    }
    protected colorEnum color;

    public enum startPosEnum {
        CLOSE,
        FAR
    }
    protected startPosEnum startPos;

    public enum endPosEnum {
        CLOSE,
        FAR
    }
    protected endPosEnum endPos;

    abstract protected void setVariables();

    @Override
    public final void init() {
        setVariables();
        lynxModuleInit();

        robotHardware = new RobotHardware0(hardwareMap, allHubs, color);
        pathPackager = new PathPackager(drive, startPos, endPos, color);
        pickolPopper = new AutoPickolPopper(hardwareMap, allHubs);
        gamepadBetter = new GamepadBetter0(gamepad1, gamepad2);
        getFrameButton = gamepadBetter.new Gamepad1A();

        drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, Math.toRadians(0)));
    }

    @Override
    public final void init_loop() {
        if (getFrameButton.getInput()) {
            robotHardware.processor.getReferenceFrame();
        }
    }

    @Override
    public final void start() {
        pathPackager.generatePaths(robotHardware.processor.getPropPosition());
        robotHardware.killCamera();

        Actions.runBlocking(
                new SequentialAction(
                        pathPackager.getToPurple(),
                        pathPackager.getPurpleToBack(),
                        pathPackager.getYellowDrop(),
                        pickolPopper,
                        pathPackager.getPark()
                )
        );
    }

    @Override
    public final void loop() {

    }

    @Override
    public final void stop() {

    }

    private void lynxModuleInit() {
        allHubs = hardwareMap.getAll(LynxModule.class);

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }
}
