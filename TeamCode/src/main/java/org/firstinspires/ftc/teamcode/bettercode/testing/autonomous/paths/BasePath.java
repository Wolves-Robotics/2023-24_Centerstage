package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.paths;

import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.MecanumDrive;

abstract public class BasePath {
    protected Action action;

    abstract protected void setAction(MecanumDrive drive);

    public Action getAction() {
        return action;
    }
}
