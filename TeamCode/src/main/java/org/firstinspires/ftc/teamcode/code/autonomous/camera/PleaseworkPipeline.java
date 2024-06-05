package org.firstinspires.ftc.teamcode.code.autonomous.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.external.function.Consumer;
import org.firstinspires.ftc.robotcore.external.function.Continuation;
import org.firstinspires.ftc.robotcore.external.stream.CameraStreamSource;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.concurrent.atomic.AtomicReference;

@Config
public class PleaseworkPipeline implements VisionProcessor, CameraStreamSource {
    private final AtomicReference<Bitmap> lastFrame =
            new AtomicReference<>(Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565));

    private Rect mid, right;

    private Boolean getFrame = false, frameGot = false;
    public double staticMid, staticRight, meanMid, meanRight;

    private String outStr;

    public static int color = 1;

    public void setReferenceFrame() {getFrame = true;}

    public String getPropPosition() {
        return outStr;
    }

    @Override
    public void getFrameBitmap(Continuation<? extends Consumer<Bitmap>> continuation) {
        continuation.dispatch(bitmapConsumer -> bitmapConsumer.accept(lastFrame.get()));
    }

    private void bitmapFuckery(Mat mat) {
        Bitmap b = Bitmap.createBitmap(mat.width(), mat.height(), Bitmap.Config.RGB_565);
        Utils.matToBitmap(mat, b);
        lastFrame.set(b);
    }

    @Override
    public void init(int i, int i1, CameraCalibration cameraCalibration) {
        mid = new Rect(250, i1/2, 100, i1/2);
        right = new Rect(250, 0, 100, i1/2);
        lastFrame.set(Bitmap.createBitmap(i, i1, Bitmap.Config.RGB_565));
    }

    @Override
    public Object processFrame(Mat mat, long l) {
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
                outStr = "mid";
            } else if (meanRight > staticRight + 1) {
                outStr = "right";
            } else {
                outStr = "left";
            }
        }

        Imgproc.rectangle(mat, mid, new Scalar(255));
        Imgproc.rectangle(mat, right, new Scalar(255));
        bitmapFuckery(mat);
        return mat;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int i, int i1, float v, float v1, Object o) {

    }
}
