package org.firstinspires.ftc.teamcode.code.constants;

import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Movement {
    private static Consts consts;

    private double driveSwitchTime = 0.;
    private boolean robotCentricBool = true;

    public Movement(HardwareMap _hardwareMap) {
        consts = new Consts(_hardwareMap);
    }

    // really doesnt belong here, but fuck it we ball
    public final void fieldCentricDrive(Gamepad gamepad, double motorPower, MultipleTelemetry telem) {
        telem.addLine("Field Centric");
        double y = -gamepad.left_stick_y;
        double x = gamepad.left_stick_x;
        double rx = gamepad.right_stick_x;

        double botHeading = consts.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);
        rotX = rotX * 1.1;
        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;

        consts.frontLeft.setPower(frontLeftPower * motorPower);
        consts.backLeft.setPower(backLeftPower * motorPower);
        consts.frontRight.setPower(frontRightPower * motorPower);
        consts.backRight.setPower(backRightPower * motorPower);
    }

    public final void landonRobotCentric(Gamepad gamepad, double motorPower, MultipleTelemetry telem) {
        double x = -gamepad.left_trigger + gamepad.right_trigger;
        robotCentricDrive(gamepad, motorPower, telem, x);
    }

    public final void regularRobotCentric(Gamepad gamepad, double motorPower, MultipleTelemetry telem) {
        double x = gamepad.left_stick_x;
        robotCentricDrive(gamepad, motorPower, telem, x);
    }

    private void robotCentricDrive(Gamepad gamepad, double motorPower, MultipleTelemetry telem, double xInput) {
        telem.addLine("Robot Centric");
        double y = -gamepad.left_stick_y; // Remember, Y stick value is reversed
        double x = xInput * 1.1; // Counteract imperfect strafing
        double rx = gamepad.right_stick_x;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        consts.frontLeft.setPower(frontLeftPower * motorPower);
        consts.backLeft.setPower(backLeftPower * motorPower);
        consts.frontRight.setPower(frontRightPower * motorPower);
        consts.backRight.setPower(backRightPower * motorPower);
    }

    public final void changeMode(ElapsedTime runtime) {
        if (runtime.seconds() - driveSwitchTime >= 0.3) {
            robotCentricBool = !robotCentricBool;
            driveSwitchTime = runtime.seconds();
        }
    }

    public final void run(Gamepad gamepad, double power, MultipleTelemetry telem, boolean landon) {
        if (robotCentricBool) {if (landon) {landonRobotCentric(gamepad, power, telem);}
                               else {regularRobotCentric(gamepad, power, telem);}}
        else {fieldCentricDrive(gamepad, power, telem);}
    }
}
