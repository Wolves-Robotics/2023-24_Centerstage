package org.firstinspires.ftc.teamcode.bettercode.testing.teleop.subsystems.subsystems0;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.bettercode.testing.hardware.RobotHardware0;

abstract public class BaseSubsystem extends Thread{
    RobotHardware0 robotHardware;

    private ElapsedTime deltaTime;
    protected ElapsedTime elapsedTime;
    private double lastLoopTime;

    public BaseSubsystem(RobotHardware0 _robotHardware) {
        robotHardware = _robotHardware;

        deltaTime = new ElapsedTime();
        elapsedTime = new ElapsedTime();
    }

    abstract protected void doShit();

    @Override
    public final void run() {
        while (!Thread.interrupted()) {
            deltaTime.reset();

            doShit();

            try {
                //noinspection BusyWait
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lastLoopTime = deltaTime.milliseconds();
        }
    }

    public final double getLastLoopTime() {
        return lastLoopTime;
    }
}
