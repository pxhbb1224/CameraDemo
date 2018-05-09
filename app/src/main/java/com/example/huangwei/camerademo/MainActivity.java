package com.example.huangwei.camerademo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,TextureView.SurfaceTextureListener{
  TextureView textureView;
  Camera camera;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.btn_take_photo).setOnClickListener(this);
    textureView = findViewById(R.id.texture_view);
    textureView.setSurfaceTextureListener(this);
  }

  @Override
  public void onClick(View v) {

  }

  @Override
  public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
    camera = Camera.open();
    try{
      camera.setPreviewTexture(surface);
      camera.startPreview();
    }catch (IOException e){
      e.printStackTrace();
    }
  }

  @Override
  public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
    // Ignored, Camera does all the work for us
    // test for branch \1
    // test for branch \2
    // test for branch \3
    // test for master
    // test for branch \2
    // again
    // add test 1
    // add test 2
    // add test 3
  }

  @Override
  public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
    camera.stopPreview();
    camera.release();
    return true;
  }

  @Override
  public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    // Invoked every time there's a new Camera preview frame
  }

  private void initCamera(){
    CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
    try {
      CameraCharacteristics cameraCharacteristics = manager.getCameraCharacteristics("101");
      Integer facing = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
      if (facing!=null && facing == CameraCharacteristics.LENS_FACING_FRONT){

      }
    }catch (CameraAccessException e){
      e.printStackTrace();
    }catch (NullPointerException e){
      e.printStackTrace();
    }
  }
}
