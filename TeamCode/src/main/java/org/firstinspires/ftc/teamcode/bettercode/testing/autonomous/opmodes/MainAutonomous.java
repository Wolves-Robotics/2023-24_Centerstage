package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.Pose2d;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.hardware.AutoPickolPopper;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths.PathPackager;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;

import java.util.List;

abstract public class MainAutonomous extends OpMode {
    private RobotHardware0 robotHardware;
    private List<LynxModule> allHubs;

    private GamepadBetter0 gamepadBetter;
    private GamepadBetter0.Gamepad1A getFrameButton;

    private MultipleTelemetry Telemetry;

    private MecanumDrive drive;

    private PathPackager pathPackager;

    private AutoPickolPopper pickolPopper;

    public enum ColorEnum {
        RED,
        BLUE
    }
    protected ColorEnum color;

    public enum StartPosEnum {
        CLOSE,
        FAR
    }
    protected StartPosEnum startPos;

    public enum EndPosEnum {
        EDGE,
        CENTER
    }
    protected EndPosEnum endPos;

    public enum TrussPass {
        CENTER,
        EDGE
    }
    protected TrussPass trussPass;

    abstract protected void setVariables();

    @Override
    public final void init() {
        setVariables();
        lynxModuleInit();

        robotHardware = new RobotHardware0(hardwareMap, allHubs, color);
        drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, Math.toRadians(0)));
        pathPackager = new PathPackager(drive, startPos, endPos, trussPass, color);
        pickolPopper = new AutoPickolPopper(robotHardware, telemetry);
        gamepadBetter = new GamepadBetter0(gamepad1, gamepad2);
        getFrameButton = gamepadBetter.new Gamepad1A();
        Telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        robotHardware.setDaemon(true);
        robotHardware.start();
    }

    @Override
    public final void init_loop() {
        if (getFrameButton.getInput()) {
            robotHardware.processor.getReferenceFrame();
        }
        Telemetry.addData("Prop position", robotHardware.processor.getPropPosition());
        Telemetry.update();
    }

    @Override
    public final void start() {
        pathPackager.generatePaths(robotHardware.processor.getPropPosition());
        robotHardware.killCamera();

        Actions.runBlocking(
                new SequentialAction(
                        pathPackager.getToPurple(),
                        pathPackager.getPurpleToYellow(),
                        pickolPopper.getAction(),
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
