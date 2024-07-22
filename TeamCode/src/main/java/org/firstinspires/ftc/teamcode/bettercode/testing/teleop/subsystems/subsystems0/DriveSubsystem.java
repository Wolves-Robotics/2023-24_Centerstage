package org.firstinspires.ftc.teamcode.bettercode.testing.teleop.subsystems.subsystems0;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0.BoolInput;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0.DoubleInput;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.GamepadBetter0.TriggerInput;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;
import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0.Names;

public class DriveSubsystem extends BaseSubsystem{
    BoolInput switchInput, resetYawInput;
    DoubleInput leftStick, rightStick;
    TriggerInput leftTrigger, rightTrigger;

    public void setLeftStick(DoubleInput input) {
        leftStick = input;
    }
    public void setRightStick(DoubleInput input) {
        rightStick = input;
    }
    public void setLeftTrigger(TriggerInput input) {
        leftTrigger = input;
    }
    public void setRightTrigger(TriggerInput input) {
        rightTrigger = input;
    }
    public void setSwitchInput(BoolInput input) {
        switchInput = input;
    }
    public void setResetYawInput(BoolInput input) {
        resetYawInput = input;
    }

    public DriveSubsystem(RobotHardware0 _robotHardware) {
        super(_robotHardware);
    }

    public enum DriveStates {
        ROBOTCENTRIC,
        FIELDCENTRIC
    }
    private DriveStates driveStates = DriveStates.FIELDCENTRIC;

    @Override
    protected void doShit() {
        switch (driveStates) {
            case FIELDCENTRIC:
                if (rightStick == null) {
                    fieldCentricInput(leftStick, leftTrigger, rightTrigger);
                } else {
                    fieldCentricInput(leftStick, rightStick);
                }
                break;
            case ROBOTCENTRIC:
                if (rightStick == null) {
                    robotCentricInput(leftStick, leftTrigger, rightTrigger);
                } else {
                    robotCentricInput(leftStick, rightStick);
                }
                break;
        }

        if (switchInput.getInput() && elapsedTime.seconds() > RobotHardware0.inputDeadTime) {
            switch (driveStates) {
                case FIELDCENTRIC:
                    driveStates = DriveStates.ROBOTCENTRIC;
                    break;
                case ROBOTCENTRIC:
                    driveStates = DriveStates.FIELDCENTRIC;
                    break;
            }
            elapsedTime.reset();
        }

        if (resetYawInput.getInput()) {
            robotHardware.resetImuYaw();
        }
    }

    private void fieldCentricInput(DoubleInput leftStick, DoubleInput rightStick) {
        double rx = rightStick.getXInput();
        fieldCentricDrive(leftStick, rx);
    }
    private void fieldCentricInput(DoubleInput leftStick, TriggerInput leftTrigger, TriggerInput rightTrigger) {
        double rx = -leftTrigger.getDoubleInput() + rightTrigger.getDoubleInput();
        fieldCentricDrive(leftStick, rx);
    }
    private void fieldCentricDrive(DoubleInput leftStick, double rx) {
        double y = -leftStick.getYInput();
        double x = leftStick.getXInput();

        double botHeading = robotHardware.getImuAngles().getYaw(AngleUnit.RADIANS);
        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);
        rotX = rotX * 1.1;
        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;

        robotHardware.setMotorPower(Names.frontLeft, frontLeftPower * robotHardware.movementPower);
        robotHardware.setMotorPower(Names.frontRight, frontRightPower * robotHardware.movementPower);
        robotHardware.setMotorPower(Names.backLeft, backLeftPower * robotHardware.movementPower);
        robotHardware.setMotorPower(Names.backRight, backRightPower * robotHardware.movementPower);
    }

    private void robotCentricInput(DoubleInput leftStick, DoubleInput rightStick) {
        double rx = rightStick.getXInput();
        robotCentricDrive(leftStick, rx);
    }
    private void robotCentricInput(DoubleInput leftStick, TriggerInput leftTrigger, TriggerInput rightTrigger) {
        double rx = -leftTrigger.getDoubleInput() + rightTrigger.getDoubleInput();
        robotCentricDrive(leftStick, rx);
    }
    private void robotCentricDrive(DoubleInput leftStick, double rx) {
        double y = -leftStick.getYInput();
        double x = leftStick.getXInput() * 1.1;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        robotHardware.setMotorPower(Names.frontLeft, frontLeftPower * robotHardware.movementPower);
        robotHardware.setMotorPower(Names.frontRight, frontRightPower * robotHardware.movementPower);
        robotHardware.setMotorPower(Names.backLeft, backLeftPower * robotHardware.movementPower);
        robotHardware.setMotorPower(Names.backRight, backRightPower * robotHardware.movementPower);
    }

    public DriveStates getDriveStates() {
        return driveStates;
    }
}
