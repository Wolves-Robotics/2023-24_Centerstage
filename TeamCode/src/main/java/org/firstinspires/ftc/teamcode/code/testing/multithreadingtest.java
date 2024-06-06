package org.firstinspires.ftc.teamcode.code.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.code.constants.AutoConsts;
import org.firstinspires.ftc.teamcode.code.constants.Consts;

import java.util.ArrayList;
import java.util.List;

@TeleOp
public class multithreadingtest extends OpMode {
    ElapsedTime elapsedTime;

    AutoConsts autoConsts;
    Consts consts;

    MultipleTelemetry telem;
    @Override
    public void init() {
        elapsedTime = new ElapsedTime();

        autoConsts = new AutoConsts(hardwareMap);
        autoConsts.setProcessor();
        autoConsts.setCamera();
//
        consts = new Consts(hardwareMap);
        consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLACK);
//
        telem = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
//
        FtcDashboard.getInstance().startCameraStream(autoConsts.processor, 30.);
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void loop() {
        telem.addData("Loop Time", elapsedTime.milliseconds());
        telem.update();
        elapsedTime.reset();
    }
}
