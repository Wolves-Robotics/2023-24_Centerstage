package org.firstinspires.ftc.teamcode.bettercode.testing.hardware;

import android.util.Size;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.camera.differenceDetection;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;
import org.firstinspires.ftc.vision.VisionPortal;

import java.util.HashMap;
import java.util.List;

public class RobotHardware0 extends Thread {
    public static double inputDeadTime = 0.3;
    public static double bumperDeadZone = 0.75;
    public volatile double movementPower = 1;

    private static HardwareMap hardwareMap;
    private List<LynxModule> allHubs;

    private ElapsedTime deltaTime;
    private double lastLoopTime;

    public enum Names {
        frontLeft,
        frontRight,
        backLeft,
        backRight,
        slideLeft,
        slideRight,
        pickol,
        slideToArm,
        armJoint,
        claw,
        drone
    }

    private static HashMap<Names, String> nameHashMap;
    private HashMap<String, MotorClass> motorClassMap;
    private HashMap<String, ServoClass> servoClassMap;

    private IMU imu;
    private YawPitchRollAngles imuAngles;

    private static VisionPortal portal;
    public differenceDetection processor;

    private static class MotorClass {
        DcMotor motor;
        int pos = 0;

        public MotorClass(Names name, boolean isReverse) {
            motor = hardwareMap.dcMotor.get(nameHashMap.get(name));
            if (isReverse) motor.setDirection(DcMotorSimple.Direction.REVERSE);
        }
    }

    private static class ServoClass {
        Servo servo;
        double pos = 0d;

        public ServoClass(Names name, boolean isReverse) {
            servo = hardwareMap.servo.get(nameHashMap.get(name));
            if (isReverse) servo.setDirection(Servo.Direction.REVERSE);
        }
    }

    private void standardInit(HardwareMap _hardwareMap, List<LynxModule> _allHubs) {
        hardwareMap = _hardwareMap;
        allHubs = _allHubs;
        deltaTime = new ElapsedTime();

        setNameHashMap();

        setHardwareMaps();

        setImu();

        servoInit();
    }

    public RobotHardware0(HardwareMap _hardwareMap, List<LynxModule> _allHubs) {
        standardInit(_hardwareMap, _allHubs);
    }

    public RobotHardware0(HardwareMap _hardwareMap, List<LynxModule> _allHubs, MainAutonomous.ColorEnum color) {
        standardInit(_hardwareMap, _allHubs);

        setCamera(color);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            deltaTime.reset();

            // clears cache every loop, as the caching mode is on manual
            lynxModuleUpdate();

            // gets all the positions of the hardware
            updateMotorPosition();
            updateServoPosition();

            imuAngles = imu.getRobotYawPitchRollAngles();

            lastLoopTime = deltaTime.milliseconds();
        }
    }

    private void updateMotorPosition() {
        for (MotorClass motorClass: motorClassMap.values()) {
            motorClass.pos = motorClass.motor.getCurrentPosition();
        }
    }
    private void updateServoPosition() {
        for (ServoClass servoClass: servoClassMap.values()) {
            servoClass.pos = servoClass.servo.getPosition();
        }
    }

    public int getMotorPos(Names name) {
        return motorClassMap.get(nameHashMap.get(name)).pos;
    }
    public double getServoPos(Names name) {
        return servoClassMap.get(nameHashMap.get(name)).pos;
    }
    public YawPitchRollAngles getImuAngles() {
        return imuAngles;
    }
    public void resetImuYaw() {imu.resetYaw();}

    public void setMotorPower(Names name, double power) {
        motorClassMap.get(nameHashMap.get(name)).motor.setPower(power);
    }
    public void setServoPos(Names name, double pos) {
        if (pos > 1) {pos = 1;}
        else if (pos < 0) {pos = 0;}

        servoClassMap.get(nameHashMap.get(name)).servo.setPosition(pos);
    }

    private void lynxModuleUpdate() {
        for (LynxModule hub : allHubs) {
            hub.clearBulkCache();
        }
    }

    private void setNameHashMap() {
        nameHashMap = new HashMap<>();

        nameHashMap.put(Names.frontLeft, "frontLeft");
        nameHashMap.put(Names.frontRight, "frontRight");
        nameHashMap.put(Names.backLeft, "backLeft");
        nameHashMap.put(Names.backRight, "backRight");
        nameHashMap.put(Names.slideLeft, "slideLeft");
        nameHashMap.put(Names.slideRight, "slideRight");
        nameHashMap.put(Names.pickol, "pickol");
        nameHashMap.put(Names.slideToArm, "idk1");
        nameHashMap.put(Names.armJoint, "idk2");
        nameHashMap.put(Names.claw, "idk3");
        nameHashMap.put(Names.drone, "drone");
    }
    private void setHardwareMaps() {
        motorClassMap = new HashMap<>();
        motorClassMap.put(nameHashMap.get(Names.frontLeft), new MotorClass(Names.frontLeft, false));
        motorClassMap.put(nameHashMap.get(Names.frontRight), new MotorClass(Names.frontRight, true));
        motorClassMap.put(nameHashMap.get(Names.backLeft), new MotorClass(Names.backLeft, false));
        motorClassMap.put(nameHashMap.get(Names.backRight), new MotorClass(Names.backRight, true));
        motorClassMap.put(nameHashMap.get(Names.slideLeft), new MotorClass(Names.slideLeft, true));
        motorClassMap.put(nameHashMap.get(Names.slideRight), new MotorClass(Names.slideRight, false));

        servoClassMap = new HashMap<>();
        servoClassMap.put(nameHashMap.get(Names.pickol), new ServoClass(Names.pickol, false));
        servoClassMap.put(nameHashMap.get(Names.slideToArm), new ServoClass(Names.slideToArm, true));
        servoClassMap.put(nameHashMap.get(Names.armJoint), new ServoClass(Names.armJoint, false));
        servoClassMap.put(nameHashMap.get(Names.claw), new ServoClass(Names.claw, false));
        servoClassMap.put(nameHashMap.get(Names.drone), new ServoClass(Names.drone, true));
    }
    private void setImu() {
        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD));
        imu.initialize(parameters);
        imu.resetYaw();
    }
    private void servoInit() {
        setServoPos(Names.slideToArm, 0);
        setServoPos(Names.armJoint, 0.1);
        setServoPos(Names.claw, 0);
        setServoPos(Names.pickol, 0);
    }

    private void setCamera(MainAutonomous.ColorEnum color) {
        processor = new differenceDetection(color);
        portal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Goof"))
                .setCameraResolution(new Size(640, 480))
                .setCamera(BuiltinCameraDirection.BACK)
                .addProcessor(processor)
                .enableLiveView(true)
                .build();
    }
    public void killCamera() {
        portal.close();
    }

    public final double getLastLoopTime() {
        return lastLoopTime;
    }
}
