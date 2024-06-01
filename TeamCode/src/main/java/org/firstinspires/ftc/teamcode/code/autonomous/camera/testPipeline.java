package org.firstinspires.ftc.teamcode.code.autonomous.camera;

import com.acmerobotics.dashboard.config.Config;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

@Config
public class testPipeline extends BaseCameraPipeline {
    private Boolean getFrame = false, frameGot = false;

    Mat mat = new Mat();
    Mat staticMat = new Mat();

    public static int num11 = 0, num12 = 0, num13 = 0, num21 = 255, num22 = 220, num23 = 100;

    public void setReferenceFrame() {
        getFrame = true;
    }

    @Override
    protected Mat doShit(Mat frame) {
        Imgproc.cvtColor(frame, mat, Imgproc.COLOR_RGB2HSV);
        if (getFrame && !frameGot) {
            staticMat = mat.clone();
            frameGot = true;
        }

        if (frameGot) {
            Scalar test = new Scalar(num11, num12, num13);
            Scalar test2 = new Scalar(num21, num22, num23);

            Core.bitwise_xor(mat, staticMat, mat);
            Core.inRange(mat, test, test2, mat);
            Core.bitwise_not(mat, mat);
        }

        return mat;
    }
}
