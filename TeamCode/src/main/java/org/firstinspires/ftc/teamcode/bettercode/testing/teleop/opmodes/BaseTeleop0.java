package org.firstinspires.ftc.teamcode.bettercode.testing.teleop.opmodes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0.BoolInput;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0.DoubleInput;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0.TriggerInput;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;
import org.firstinspires.ftc.teamcode.bettercode.testing.teleop.subsystems.subsystems0.BaseSubsystem;
import org.firstinspires.ftc.teamcode.bettercode.testing.teleop.subsystems.subsystems0.ClawSubsystem;
import org.firstinspires.ftc.teamcode.bettercode.testing.teleop.subsystems.subsystems0.DriveSubsystem;

import java.util.Arrays;
import java.util.List;

abstract public class BaseTeleop0 extends OpMode {
    private List<LynxModule> allHubs;
    protected GamepadBetter0 gamepadBetter;
    private RobotHardware0 robotHardware;
    private DriveSubsystem drive;
    private ClawSubsystem claw;

    private MultipleTelemetry telem;

    private List<BaseSubsystem> subsystemsList;

    abstract protected DoubleInput setMovement();
    abstract protected DoubleInput setRotation();
    abstract protected TriggerInput setLeftTrigger();
    abstract protected TriggerInput setRightTrigger();
    abstract protected BoolInput setMovementChange();
    abstract protected BoolInput setResetYaw();
    abstract protected BoolInput setClawChange();

    @Override
    public final void init() {
        lynxModuleInit();

        telem = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        gamepadBetter = new GamepadBetter0(gamepad1, gamepad2);

        robotHardware = new RobotHardware0(hardwareMap, allHubs);
        robotHardware.start();
        drive = new DriveSubsystem(robotHardware);
        claw = new ClawSubsystem(robotHardware);

        setCommands();

        subsystemsList = Arrays.asList(drive, claw);

        telem.addLine("Initialized");
        telem.update();
    }

    private void setCommands() {
        drive.setLeftStick(setMovement());
        drive.setRightStick(setRotation());
        drive.setLeftTrigger(setLeftTrigger());
        drive.setRightTrigger(setRightTrigger());
        drive.setSwitchInput(setMovementChange());
        drive.setResetYawInput(setResetYaw());

        claw.setSwitchInput(setClawChange());
    }

    @Override
    public final void init_loop() {}

    @Override
    public final void start() {
        drive.start();
    }

    @Override
    public final void loop() {
        telem.addData("Hardware loop time(ms)", robotHardware.getLastLoopTime());
        telem.addData("Drive Type", drive.getDriveStates());
        telem.addData("Drive loop time(ms)", drive.getLastLoopTime());
        telem.update();
    }

    @Override
    public final void stop() {
        for (BaseSubsystem subsystem: subsystemsList) {
            subsystem.interrupt();
        }
    }

    private void lynxModuleInit() {
        allHubs = hardwareMap.getAll(LynxModule.class);

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }
}
