package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.roadrunner1_0.messages;

import com.acmerobotics.roadrunner.ftc.PositionVelocityPair;

public final class ThreeDeadWheelInputsMessage {
    public long timestamp;
    public PositionVelocityPair par0;
    public PositionVelocityPair par1;
    public PositionVelocityPair perp;

    public ThreeDeadWheelInputsMessage(PositionVelocityPair par0, PositionVelocityPair par1, PositionVelocityPair perp) {
        this.timestamp = System.nanoTime();
        this.par0 = par0;
        this.par1 = par1;
        this.perp = perp;
    }
}