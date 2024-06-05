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

    public static int color = 1;

    public void setReferenceFrame() {
        getFrame = true;
    }

    @Override
    protected Mat doShit(Mat frame) {
        Imgproc.cvtColor(frame, mat, Imgproc.COLOR_RGB2YCrCb);
        Core.extractChannel(mat, mat, color);

        if (getFrame && !frameGot) {
            staticMat = mat.clone();
            frameGot = true;
        }

        if (frameGot) {

        }

        return mat;
    }
}
