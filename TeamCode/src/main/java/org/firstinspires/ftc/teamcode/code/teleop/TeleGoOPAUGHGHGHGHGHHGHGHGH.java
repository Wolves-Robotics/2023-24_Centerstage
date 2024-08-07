package org.firstinspires.ftc.teamcode.code.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.code.constants.Consts;
import org.firstinspires.ftc.teamcode.code.constants.PIDConsts.SlidePID;
import org.firstinspires.ftc.teamcode.code.constants.Movement;
import org.firstinspires.ftc.teamcode.code.constants.hardwareConsts.Arm;
import org.firstinspires.ftc.teamcode.code.constants.hardwareConsts.Claw;
import org.firstinspires.ftc.teamcode.code.constants.hardwareConsts.Drone;
import org.firstinspires.ftc.teamcode.code.constants.hardwareConsts.Lights;
import org.firstinspires.ftc.teamcode.code.constants.hardwareConsts.Popper;
import org.firstinspires.ftc.teamcode.code.constants.hardwareConsts.Slide;

@TeleOp
public class TeleGoOPAUGHGHGHGHGHHGHGHGH extends OpMode {
    private Consts consts;
    private SlidePID slidePID;
    private Movement movement;
    private Arm arm;
    private Slide slide;
    private Claw claw;
    private Popper popper;
    private Lights lights;
    private Drone drone;

    private MultipleTelemetry telem;

    private ElapsedTime runtime, deltaTime;

    private double driveSwitchTime = 0.;
    private boolean robotCentricBool = false;

    private double motorPower = 1.;

    private int slideTarget = 0;

    @Override
    public void init() {
        telem = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        consts = new Consts(hardwareMap);
        slidePID = new SlidePID(hardwareMap);
        movement = new Movement(hardwareMap);
        arm = new Arm(hardwareMap);
        slide = new Slide(hardwareMap);
        claw = new Claw(hardwareMap);
        popper = new Popper(hardwareMap);
        lights = new Lights(hardwareMap);
        drone = new Drone(hardwareMap);

        runtime = new ElapsedTime();
        deltaTime = new ElapsedTime();
        driveSwitchTime = 0;

        consts.setInit();
        telem.addLine("Initialized.");
        telem.update();
    }

    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        deltaTime.reset();

        // Player 1
        if (gamepad1.dpad_left) {
            popper.goUp();
        }
        if (gamepad1.dpad_right) {
            popper.goDown();
        }
        if (gamepad1.dpad_down) {
            drone.shoot();
        }
        if (gamepad1.options) {
            consts.imu.resetYaw();
        }

        if (gamepad1.left_bumper) {
            movement.changeMode(runtime);
        }


        // Player 2
        if (gamepad2.y) {
            slide.goUp();
        }
        if (gamepad2.a) {
            slide.goDown();
        }
        if (gamepad2.b) {
            slide.stay();
        }
        if (gamepad2.x) {
            slide.hang();
        }
        if(gamepad2.dpad_down){
            motorPower = arm.setGrab();
            lights.lightStates = Lights.LightStates.CLAWDOWN;
        }
        if(gamepad2.dpad_up){
            motorPower = arm.setRest();
            lights.lightStates = Lights.LightStates.CLAWUP;
        }
        if(gamepad2.left_bumper){
            motorPower = arm.setScore();
            lights.lightStates = Lights.LightStates.SCORE;
        }
        if (gamepad2.right_bumper) {
            claw.switchPos(runtime);
        }

        // Final things to update after every loop
        movement.run(gamepad1, motorPower, telem, true);

//        slidePID.run(slideTarget);
        telem.addData("Slide Target", slideTarget);
        telem.addData("Slide Pos", slidePID.getCurrentPos());
        telem.addData("Slide Power", slidePID.power);
        telem.addData("Delta Time", deltaTime.milliseconds());

        lights.setLights();

        telem.update();
    }

    public double getCurrentPos() {
        return (consts.slideL.getCurrentPosition() + consts.slideR.getCurrentPosition()) / 2.;
    }
}
