package org.firstinspires.ftc.teamcode.code.autonomous.pathing;

import org.firstinspires.ftc.teamcode.code.autonomous.pathing.finalPaths.BlueClosePath;
import org.firstinspires.ftc.teamcode.code.autonomous.pathing.finalPaths.BlueFarPath;
import org.firstinspires.ftc.teamcode.code.autonomous.pathing.finalPaths.RedClosePath;
import org.firstinspires.ftc.teamcode.code.autonomous.pathing.finalPaths.RedFarPath;
import org.firstinspires.ftc.teamcode.code.baseClasses.MainAutoPath;

public class PathingWrapper {
    static MainAutoPath path;

    public static MainAutoPath getPath(String color, String startPos) {
        if (color == "red") {
            if (startPos == "close") {
                path = new RedClosePath();
            } else {
                path = new RedFarPath();
            }
        } else {
            if (startPos == "close") {
                path = new BlueClosePath();
            } else {
                path = new BlueFarPath();
            }
        }

        return path;
    }
}
