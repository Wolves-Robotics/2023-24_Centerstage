package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0;

import com.acmerobotics.roadrunner.Time;
import com.acmerobotics.roadrunner.Twist2dDual;

public interface Localizer {
    Twist2dDual<Time> update();
}
