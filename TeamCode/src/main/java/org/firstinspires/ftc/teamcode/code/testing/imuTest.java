package org.firstinspires.ftc.teamcode.code.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.code.constants.Consts;

@TeleOp
public class imuTest extends OpMode {
    Consts consts;

    @Override
    public void init() {
        consts = new Consts(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Rotation", consts.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES));
    }
}
