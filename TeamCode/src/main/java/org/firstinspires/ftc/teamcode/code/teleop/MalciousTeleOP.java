package org.firstinspires.ftc.teamcode.code.teleop;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.lang.Math;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
public class MalciousTeleOP extends LinearOpMode {

    private void wristServo(double pos, Servo s1, Servo s2) {
        s1.setPosition(pos);
        s2.setPosition(pos);
    }

    private void setArmPos(double degrees, Servo arm) {
        degrees = (degrees + 360) % 360;
        // TODO: some algorithm to get the 0-1 value for the servo
        double pos = 0;
        arm.setPosition(pos);
    }

    private void setArmWristPos(double degrees, Servo armWrist1, Servo armWrist2) {
        degrees = (degrees + 360) % 360;
        // TODO: some algorithm to get the 0-1 value for the servo
        double pos = 0;
        wristServo(pos, armWrist1, armWrist2);
    }

    private void armInverseKinematics(double x, double y, Servo arm, Servo armWrist1, Servo armWrist2) {
        double armLength1 = 3;
        double armLength2 = 2;
        double distance = Math.hypot(x, y);

        double phi = Math.atan(y / x);
        double theta = Math.acos((Math.pow(armLength1, 2) + Math.pow(distance, 2) - Math.pow(armLength2, 2)) / 2 * armLength1 * distance);
        double alpha = Math.acos((Math.pow(armLength1, 2) + Math.pow(armLength2, 2) - Math.pow(distance, 2)) / 2 * armLength1 * armLength2);

        setArmPos(phi + theta, arm);
        setArmWristPos(alpha - 180, armWrist1, armWrist2);
    }


    RevBlinkinLedDriver lights;
    public enum State {
        HIGH_2ND_LINE,
        LOW,
        MID,
        RESET,
        GRAB
    }

    private enum LightStates {
        ENDGAME,
        SCORE,
        GRAB,
        OPEN,
        CLAWDOWN,
        CLAWUP,
        INITIALIZE
    }
    LightStates lightStates;

    public double motorPower = 1.;
    ElapsedTime runTime;

    boolean clawOpen = true;
    double clawChangeTime = 0.;

    @Override
    public void runOpMode() throws InterruptedException {
        //CONFIGS

        lights = hardwareMap.get(RevBlinkinLedDriver.class, "light");
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("backRight");
        DcMotor slideR = hardwareMap.dcMotor.get("slideRight");
        DcMotor slideL = hardwareMap.dcMotor.get("slideLeft");
        Servo popper = hardwareMap.get(Servo.class, "pickol");
        Servo arm = hardwareMap.get(Servo.class, "idk1");
        Servo joint = hardwareMap.get(Servo.class, "idk2");
        Servo claw = hardwareMap.get(Servo.class, "idk3");
//        ServoEx arm;
//        ServoEx joint;

//        arm = new SimpleServo(hardwareMap, "idk1", 0, 355);
//        joint = new SimpleServo(hardwareMap, "idk2", 0, 355 );
        //REVERSINGS


        frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        slideR.setDirection(DcMotorSimple.Direction.FORWARD);

        slideL.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setDirection(Servo.Direction.REVERSE);
        joint.setDirection(Servo.Direction.FORWARD);
//        arm.setDirection(Servo.Direction.REVERSE);
//        joint.setInverted(true);
//        arm.setInverted(false);


        //States
        State state = State.RESET;



        IMU imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD));
        imu.initialize(parameters);


//        //Servo/Motor intits here
//

        arm.setPosition(0);
        joint.setPosition(0.1);
        claw.setPosition(0);
        popper.setPosition(0);
        lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.HOT_PINK);
//        arm.turnToAngle(125);
//        joint.turnToAngle(0);
        runTime = new ElapsedTime();

        //TELEOP MAIN
        waitForStart();

        if (isStopRequested()) return;
        runTime.reset();
        while (opModeIsActive()) {
            telemetry.addLine(String.format("%s", runTime.seconds()));

//            switch (state) {
//                case RESET:
//                    // servo.setpos(0)
//                    if (gamepad2.b) {
//                        state = State.LOW;
//                    } else if (gamepad2.y) {
//                        state = State.HIGH_2ND_LINE;
//                    } else if (gamepad2.x) {
//                        state = State.MID;
//                    } else if (gamepad2.right_bumper) {
//                        state = State.GRAB;
//                    }
//                    break;
//                case GRAB:
//                    if
//            }

            //TESTING
//            if(gamepad2.a){
//                arm.setPosition(0.9);
//            }
//            if(gamepad2.b){
//                arm.setPosition(0);
//
//            }
//            if(gamepad2.y){
//                arm.setDirection(Servo.Direction.REVERSE);
//
//                arm.setPosition(0.2);
//            }
//            if (gamepad2.dpad_down){
//
//            }
//            if (armIsReverse) {
//                arm.setDirection(Servo.Direction.REVERSE);
//            } else {
//                arm.setDirection(Servo.Direction.FORWARD);
//            }
//            arm.setPosition(armPosition);
//
//            if (jointIsReverse) {
//                joint.setDirection(Servo.Direction.REVERSE);
////            } else {
////                joint.setDirection(Servo.Direction.FORWARD);
////            }
////            joint.setPosition(jointPosition);
           if (runTime.seconds() >= 90){
               lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_RAINBOW_PALETTE);
           }
        //SECOND PLAYER
            if(gamepad2.dpad_down){
                arm.setPosition(0);
                joint.setPosition(0.61);
                motorPower = 1;
                lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.HEARTBEAT_RED);
            }
            if(gamepad2.dpad_up){
                arm.setPosition(0);
                joint.setPosition(0.1);
                motorPower = 1.;
                lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BREATH_BLUE);
            }
            if(gamepad2.y){
                arm.setPosition(1);
                joint.setPosition(0.31);
                motorPower = 0.55;
                lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_FOREST_PALETTE);
            }

            if (gamepad2.right_bumper && runTime.seconds() - clawChangeTime >= 0.15) {
                clawOpen = !clawOpen;
                if (clawOpen) {
                    claw.setPosition(0);
                    lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.YELLOW);
                } else {
                    claw.setPosition(0.6);
                    lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.VIOLET);
                }
                clawChangeTime = runTime.seconds();
            }

            if (gamepad2.b){
                arm.setPosition(1);
                joint.setPosition(0.35);
                motorPower = 0.55;
            }
            //FIRST PLAYER

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;


            if (gamepad1.options) {
                imu.resetYaw();
            }

            double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
            double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);
            rotX = rotX * 1.1;
            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            double frontLeftPower = (rotY + rotX + rx) / denominator;
            double backLeftPower = (rotY - rotX + rx) / denominator;
            double frontRightPower = (rotY - rotX - rx) / denominator;
            double backRightPower = (rotY + rotX - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower * motorPower);
            backLeftMotor.setPower(backLeftPower * motorPower);
            frontRightMotor.setPower(frontRightPower * motorPower);
            backRightMotor.setPower(backRightPower * motorPower);

            if (gamepad1.y) {
                slideL.setPower(1);
                slideR.setPower(1);
            }
            if (gamepad1.a) {
                slideL.setPower(-1);
                slideR.setPower(-1);
            }
            if (gamepad1.b) {
                slideL.setPower(0);
                slideR.setPower(0);
            }
            if (gamepad1.x){
                slideL.setPower(0.3);
                slideR.setPower(0.3);
            }
            if (gamepad1.dpad_left) {
                popper.setPosition(0);
            }
            if (gamepad1.dpad_right) {
                popper.setPosition(0.6);
            }

            telemetry.update();
        }
    }
}