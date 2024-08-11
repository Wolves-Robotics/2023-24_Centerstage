package org.firstinspires.ftc.teamcode.bettercode.testing.autonomous.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import org.firstinspires.ftc.robotcore.external.function.Consumer;
import org.firstinspires.ftc.robotcore.external.function.Continuation;
import org.firstinspires.ftc.robotcore.external.stream.CameraStreamSource;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Rect;

import java.util.concurrent.atomic.AtomicReference;

abstract public class BaseCamera implements VisionProcessor, CameraStreamSource {
    private final AtomicReference<Bitmap> lastFrame =
            new AtomicReference<>(Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565));

    public enum PropPosEnum {
        LEFT,
        MID,
        RIGHT
    }
    protected PropPosEnum propPos = PropPosEnum.LEFT;

    protected Rect mid, right;

    abstract protected Mat doShit(Mat frame);

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

        mid = new Rect(250, height/2, 100, height/2);
        right = new Rect(250, 0, 100, height/2);
    }

    @Override
    public Object processFrame(Mat frame, long l) {
        Mat mat = doShit(frame);

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

        if (propPos == PropPosEnum.MID) {
            midRect.setStyle(Paint.Style.FILL);
        } else if (propPos == PropPosEnum.RIGHT) {
            rightRect.setStyle(Paint.Style.FILL);
        }

        canvas.drawRect(makeGraphicsRect(mid, scaleBmpPxToCanvasPx), midRect);
        canvas.drawRect(makeGraphicsRect(mid, scaleBmpPxToCanvasPx), rightRect);
    }

    public PropPosEnum getPropPosition(){
        return propPos;
    }
}
