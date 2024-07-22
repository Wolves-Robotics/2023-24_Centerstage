package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths;

import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;
import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

public class PathPackager {
    private MecanumDrive drive;

    private MainAutonomous.startPosEnum startPos;
    private MainAutonomous.endPosEnum endPos;
    private MainAutonomous.colorEnum color;

    private Action toPurple, purpleToBack, yellowDrop, park;

    public PathPackager(MecanumDrive _drive, MainAutonomous.startPosEnum _startPos, MainAutonomous.endPosEnum _endPos, MainAutonomous.colorEnum _color) {
        drive = _drive;

        startPos = _startPos;
        endPos = _endPos;
        color = _color;
    }

    public void generatePaths(String randomPos) {

    }

    public Action getToPurple() {
        return toPurple;
    }
    public Action getPurpleToBack() {
        return purpleToBack;
    }
    public Action getYellowDrop() {
        return yellowDrop;
    }
    public Action getPark() {
        return park;
    }
}
