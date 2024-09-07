package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.camera;

import org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.opmodes.MainAutonomous;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class differenceDetection extends BaseCamera {
    private Boolean getFrame = false, frameGot = false;
    private double staticMid, staticRight, meanMid, meanRight;
    private int color;

    public differenceDetection(MainAutonomous.ColorEnum _color) {
        if (_color == MainAutonomous.ColorEnum.RED) {
            color = 1;
        } else if (_color == MainAutonomous.ColorEnum.BLUE) {
            color = 2;
        }
    }

    public void getReferenceFrame() {
        getFrame = true;
    }

    @Override
    protected Mat doStuff(Mat mat) {
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2YCrCb);
        Core.extractChannel(mat, mat, color);

        meanMid = Core.mean(mat.submat(mid)).val[0];
        meanRight = Core.mean(mat.submat(right)).val[0];

        if (getFrame && !frameGot) {
            staticMid = meanMid;
            staticRight = meanRight;
            frameGot = true;
        }

        if (frameGot) {
            if (meanMid > staticMid + 1) {
                propPos = PropPosEnum.MID;
            } else if (meanRight > staticRight + 1) {
                propPos = PropPosEnum.RIGHT;
            } else {
                propPos = PropPosEnum.LEFT;
            }
        }

        return mat;
    }
}
