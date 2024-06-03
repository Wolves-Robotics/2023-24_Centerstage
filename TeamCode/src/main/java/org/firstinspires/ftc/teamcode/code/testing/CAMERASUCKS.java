package org.firstinspires.ftc.teamcode.code.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.checkerframework.checker.units.qual.C;
import org.firstinspires.ftc.teamcode.code.constants.AutoConsts;
import org.firstinspires.ftc.teamcode.code.constants.Consts;
import org.firstinspires.ftc.teamcode.code.constants.hardwareConsts.Lights;

@TeleOp
public class CAMERASUCKS extends OpMode {
    AutoConsts autoConsts;
    Consts consts;

    MultipleTelemetry telem;

    @Override
    public void init() {
        autoConsts = new AutoConsts(hardwareMap);
        autoConsts.setProcessor();
        autoConsts.setCamera();

        consts = new Consts(hardwareMap);
        consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLACK);

        telem = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        FtcDashboard.getInstance().startCameraStream(autoConsts.processor, 30.);
    }

    @Override
    public void init_loop() {
//        if (gamepad1.a) {
//            autoConsts.processor.setReferenceFrame();
//        }
        telem.addData("Prop position", autoConsts.processor.getPropPosition());
        telem.update();
    }

    @Override
    public void loop() {
        telem.addData("Prop position", autoConsts.processor.getPropPosition());
        telem.update();
    }
}
