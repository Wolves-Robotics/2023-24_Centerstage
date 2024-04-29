package org.firstinspires.ftc.teamcode.code.constants.hardwareConsts;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.code.constants.Consts;

public class Drone {
    Consts consts;

    public Drone(HardwareMap _hardwareMap) {
        consts = new Consts(_hardwareMap);
    }

    public void shoot() {
        consts.drone.setPosition(1);
    }
}
