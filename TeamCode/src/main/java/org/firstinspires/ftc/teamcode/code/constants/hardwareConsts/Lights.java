package org.firstinspires.ftc.teamcode.code.constants.hardwareConsts;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.code.constants.Consts;

public class Lights {
    public enum LightStates {
        ENDGAME,
        SCORE,
        CLOSE,
        OPEN,
        CLAWDOWN,
        CLAWUP,
        INITIALIZE,
        OFF
    }

    Consts consts;

    public LightStates lightStates;

    public Lights(HardwareMap _hardwareMap) {
        consts = new Consts(_hardwareMap);

        lightStates = LightStates.INITIALIZE;
    }

    public void setLights() {
        switch (lightStates) {
            case INITIALIZE:
                consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.HOT_PINK);
                break;
            case CLOSE:
                consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.VIOLET);
                break;
            case OPEN:
                consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.YELLOW);
                break;
            case SCORE:
                consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_FOREST_PALETTE);
                break;
            case CLAWUP:
                consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BREATH_BLUE);
                break;
            case CLAWDOWN:
                consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.HEARTBEAT_RED);
                break;
            case ENDGAME:
                consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_RAINBOW_PALETTE);
                break;
            case OFF:
                consts.lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLACK);
        }
    }
}
