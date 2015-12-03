package com.qualcomm.ftcrobotcontroller;

import android.content.Context;
import android.hardware.Camera;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by adam on 11/25/15.
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder mHolder;
	private android.hardware.Camera mCamera;
	public CameraPreview(Context context, android.hardware.Camera camera) {

		super(context);
		mCamera = camera;
		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

	}

	@Override public void surfaceCreated(SurfaceHolder holder) {
		try {
			mCamera.setPreviewDisplay(holder);
			mCamera.startPreview();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	@Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		if (mHolder.getSurface() == null){
			return;
		}
		try {
			mCamera.stopPreview();
		}catch (Exception e){
			e.printStackTrace();
		}

		try {
			mCamera.setPreviewDisplay(mHolder);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override public void surfaceDestroyed(SurfaceHolder holder) {
		mCamera.release();
	}

}
