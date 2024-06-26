package org.firstinspires.ftc.teamcode.code.autonomous.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.external.function.Consumer;
import org.firstinspires.ftc.robotcore.external.function.Continuation;
import org.firstinspires.ftc.robotcore.external.stream.CameraStreamSource;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.concurrent.atomic.AtomicReference;

@Config
abstract public class BaseCameraPipeline implements VisionProcessor, CameraStreamSource {
    private final AtomicReference<Bitmap> lastFrame =
            new AtomicReference<>(Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565));

    private String outStr;

    public static double averageReference = 0.35;

    protected Rect MID_RECTANGLE;

    protected Rect RIGHT_RECTANGLE;

    abstract protected Mat doShit(Mat frame);

    private Mat setRects(Mat mat) {

        Imgproc.rectangle(mat, MID_RECTANGLE, new Scalar(255, 0, 0));
        Imgproc.rectangle(mat, RIGHT_RECTANGLE, new Scalar(255, 0, 0));

        return mat;
    }

    private void getOutput(Mat mat) {
        double midBox = Core.sumElems(mat.submat(MID_RECTANGLE)).val[0];
        double rightBox = Core.sumElems(mat.submat(RIGHT_RECTANGLE)).val[0];

        double averagedMidBox = midBox / MID_RECTANGLE.area() / 255;
        double averagedRightBox = rightBox / RIGHT_RECTANGLE.area() / 255;

        if(averagedMidBox > averageReference){
            outStr = "mid";
        }else if(averagedRightBox > averageReference){
            outStr = "right";
        }else{
            outStr = "left";
        }
    }

    private void bitmapFuckery(Mat mat) {
        Bitmap b = Bitmap.createBitmap(mat.width(), mat.height(), Bitmap.Config.RGB_565);
        Utils.matToBitmap(mat, b);
        lastFrame.set(b);
    }

    @Override
    public void getFrameBitmap(Continuation<? extends Consumer<Bitmap>> continuation) {
        continuation.dispatch(bitmapConsumer -> bitmapConsumer.accept(lastFrame.get()));
    }

    @Override
    public void init(int width, int height, CameraCalibration calibration) {
        lastFrame.set(Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565));
    }

    @Override
    public Object processFrame(Mat frame, long l) {
        Mat mat = doShit(frame);

        mat = setRects(mat);

        getOutput(mat);

        bitmapFuckery(mat);

        return null;
    }

    private android.graphics.Rect makeGraphicsRect(Rect rect, float scaleBmpPxToCanvasPx) {
        int left = Math.round(rect.x * scaleBmpPxToCanvasPx);
        int top = Math.round(rect.y * scaleBmpPxToCanvasPx);
        int right = left + Math.round(rect.width * scaleBmpPxToCanvasPx);
        int bottom = top + Math.round(rect.height * scaleBmpPxToCanvasPx);

        return new android.graphics.Rect(left, top, right, bottom);
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {
        Paint midRect  = new Paint();
        Paint rightRect = new Paint();

        midRect.setColor(Color.RED);
        midRect.setStyle(Paint.Style.STROKE);
        midRect.setStrokeWidth(scaleCanvasDensity * 4);

        rightRect.setColor(Color.RED);
        rightRect.setStyle(Paint.Style.STROKE);
        rightRect.setStrokeWidth(scaleCanvasDensity * 4);

        if (outStr == "mid") {
            midRect.setStyle(Paint.Style.FILL);
        } else if (outStr == "right") {
            rightRect.setStyle(Paint.Style.FILL);
        }

        canvas.drawRect(makeGraphicsRect(MID_RECTANGLE, scaleBmpPxToCanvasPx), midRect);
        canvas.drawRect(makeGraphicsRect(RIGHT_RECTANGLE, scaleBmpPxToCanvasPx), rightRect);
    }

    public String getPropPosition(){
        return outStr;
    }
}
