package com.bennyplo.animation;

import android.content.Context;
import android.opengl.GLSurfaceView;

import java.util.Timer;
import java.util.TimerTask;


public class MyView extends GLSurfaceView {
    private final MyRenderer mRenderer;
    Timer timer;
    public MyView(Context context) {
        super(context);
        setEGLContextClientVersion(2);// Create an OpenGL ES 2.0 context.
        mRenderer = new MyRenderer();// Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        timer =new Timer();
        TimerTask task = new TimerTask() {
            float angle=0;
            @Override
            public void run() {
                mRenderer.setmAngle(angle); //spining about the y-axis
                requestRender(); //ask the render to update
                angle +=1; //spining about the y-axis
                if(angle >=360) angle=0;
            }
        };
        timer.scheduleAtFixedRate(task,0,10); //trigger the timer every 10 ms
    }
}
