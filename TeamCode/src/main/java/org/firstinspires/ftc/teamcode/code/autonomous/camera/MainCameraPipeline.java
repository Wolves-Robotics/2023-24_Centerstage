package org.firstinspires.ftc.teamcode.code.autonomous.camera;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.Objects;

@Config
public class MainCameraPipeline extends BaseCameraPipeline {
    public static double minimumValue = 100;
    public static double maximumValue = 255;
    public static double minimumBlueHue = 100;
    public static double maximumBlueHue = 115;
    public static double minimumRedLowHue = 0;
    public static double maximumRedLowHue = 25;
    public static double minimumRedHighHue = 160;
    public static double maximumRedHighHue = 255;

    Mat mat = new Mat();

    String color;

    @Override
    protected Mat doShit(Mat frame) {
        Imgproc.cvtColor(frame, mat , Imgproc.COLOR_RGB2HSV);

        Scalar minimumBlue = new Scalar(minimumBlueHue, minimumValue, minimumValue);
        Scalar maximumBlue = new Scalar(maximumBlueHue, maximumValue, maximumValue);
        Scalar minimumRedLow = new Scalar(minimumRedLowHue, minimumValue, minimumValue);
        Scalar maximumRedLow = new Scalar(maximumRedLowHue, maximumValue, maximumValue);
        Scalar minimumRedHigh = new Scalar(minimumRedHighHue, minimumValue, minimumValue);
        Scalar maximumRedHigh = new Scalar(maximumRedHighHue, maximumValue, maximumValue);

        if (color == "blue") {
            Core.inRange(mat, minimumBlue, maximumBlue, mat);
        } else {
            Mat mat1 = mat.clone();
            Mat mat2 = mat.clone();
            Core.inRange(mat1, minimumRedLow, maximumRedLow, mat1);
            Core.inRange(mat2, minimumRedHigh, maximumRedHigh, mat2);
            Core.bitwise_or(mat1, mat2, mat);
            mat1.release();
            mat2.release();
        }

        return mat;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
