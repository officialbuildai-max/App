package com.aliyun.player.videoview.displayView;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.aliyun.player.IPlayer;
import com.aliyun.player.videoview.AliDisplayView;
import com.cicada.player.utils.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class IDisplayView {
    private static final String TAG = "AliDisplayView_" + IDisplayView.class.getSimpleName();
    private final ViewGroup mParent;
    protected OnDisplayViewStatusListener mOnViewStatusListener = null;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private int mVideoRotate = 0;
    private IPlayer.ScaleMode mScaleMode = IPlayer.ScaleMode.SCALE_ASPECT_FIT;
    private IPlayer.MirrorMode mMirrorMode = IPlayer.MirrorMode.MIRROR_MODE_NONE;
    private IPlayer.RotateMode mRotateMode = IPlayer.RotateMode.ROTATE_0;
    private boolean mDirectRender = false;
    private View mChildView = null;

    /* loaded from: classes2.dex */
    public interface OnDisplayViewStatusListener {
        void onSurfaceCreated(Surface surface);

        void onSurfaceDestroy();

        void onSurfaceSizeChanged();

        void onViewCreated(AliDisplayView.DisplayViewType displayViewType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IDisplayView(ViewGroup viewGroup) {
        this.mParent = viewGroup;
        Logger.v(TAG, this + " new IDisplayView()");
    }

    private void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mParent.post(runnable);
        }
    }

    private void saveToSdcard(Bitmap bitmap) {
        File file = new File("/sdcard/" + UUID.randomUUID().toString() + ".png");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Logger.e(TAG, file.getAbsolutePath());
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
        } catch (IOException e12) {
            e12.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMirrorModeInner(IPlayer.MirrorMode mirrorMode) {
        if (mirrorMode != null) {
            this.mMirrorMode = mirrorMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRotateModeInner(IPlayer.RotateMode rotateMode) {
        if (rotateMode != null) {
            this.mRotateMode = rotateMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleModeInner(IPlayer.ScaleMode scaleMode) {
        if (scaleMode != null) {
            this.mScaleMode = scaleMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        if ((r0 * r3) < (r1 * r6)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008a, code lost:
    
        r3 = (int) (((r1 * 1.0f) * r6) / r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
    
        if ((r0 * r3) > (r1 * r6)) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateViewParams() {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.player.videoview.displayView.IDisplayView.updateViewParams():void");
    }

    public void attachView() {
        Logger.v(TAG, " attachView");
        runOnUiThread(new Runnable() { // from class: com.aliyun.player.videoview.displayView.IDisplayView.7
            @Override // java.lang.Runnable
            public void run() {
                IDisplayView.this.mParent.addView(IDisplayView.this.mChildView, 0);
                IDisplayView iDisplayView = IDisplayView.this;
                iDisplayView.setMirrorModeInner(iDisplayView.mMirrorMode);
                IDisplayView iDisplayView2 = IDisplayView.this;
                iDisplayView2.setScaleModeInner(iDisplayView2.mScaleMode);
                IDisplayView iDisplayView3 = IDisplayView.this;
                iDisplayView3.setRotateModeInner(iDisplayView3.mRotateMode);
                IDisplayView.this.updateViewParams();
            }
        });
    }

    public void detachView() {
        Logger.v(TAG, " detachView");
        runOnUiThread(new Runnable() { // from class: com.aliyun.player.videoview.displayView.IDisplayView.6
            @Override // java.lang.Runnable
            public void run() {
                if (IDisplayView.this.mChildView.getParent() == IDisplayView.this.mParent) {
                    IDisplayView.this.mParent.removeView(IDisplayView.this.mChildView);
                }
            }
        });
    }

    protected abstract View getRenderView(Context context);

    public void initView() {
        this.mChildView = getRenderView(this.mParent.getContext());
    }

    protected abstract boolean mirrorRenderView(IPlayer.MirrorMode mirrorMode);

    public void parentSizeChanged() {
        Logger.v(TAG, "parentSizeChanged  ");
        runOnUiThread(new Runnable() { // from class: com.aliyun.player.videoview.displayView.IDisplayView.1
            @Override // java.lang.Runnable
            public void run() {
                IDisplayView.this.updateViewParams();
            }
        });
    }

    protected abstract boolean rotateRenderView(IPlayer.RotateMode rotateMode);

    public void setMirrorMode(final IPlayer.MirrorMode mirrorMode) {
        Logger.v(TAG, "setMirrorMode  " + mirrorMode);
        setMirrorModeInner(mirrorMode);
        this.mChildView.post(new Runnable() { // from class: com.aliyun.player.videoview.displayView.IDisplayView.5
            @Override // java.lang.Runnable
            public void run() {
                IDisplayView.this.mirrorRenderView(mirrorMode);
            }
        });
    }

    public void setOnViewStatusListener(OnDisplayViewStatusListener onDisplayViewStatusListener) {
        Logger.v(TAG, this + " setOnViewStatusListener " + onDisplayViewStatusListener);
        this.mOnViewStatusListener = onDisplayViewStatusListener;
    }

    public void setRenderFlag(boolean z10) {
        Logger.v(TAG, "setRenderFlag  " + z10);
        this.mDirectRender = z10;
        runOnUiThread(new Runnable() { // from class: com.aliyun.player.videoview.displayView.IDisplayView.2
            @Override // java.lang.Runnable
            public void run() {
                IDisplayView.this.updateViewParams();
            }
        });
    }

    public void setRotateMode(IPlayer.RotateMode rotateMode) {
        Logger.v(TAG, "setRotateMode  " + rotateMode);
        setRotateModeInner(rotateMode);
        updateViewParams();
    }

    public void setScaleMode(IPlayer.ScaleMode scaleMode) {
        Logger.v(TAG, "setScaleMode  " + scaleMode);
        setScaleModeInner(scaleMode);
        runOnUiThread(new Runnable() { // from class: com.aliyun.player.videoview.displayView.IDisplayView.4
            @Override // java.lang.Runnable
            public void run() {
                IDisplayView.this.updateViewParams();
            }
        });
    }

    public abstract void setSurfaceReuse(boolean z10);

    public void setVideoSize(int i11, int i12, int i13) {
        Logger.v(TAG, "setVideoSize  " + i11 + " ， " + i12 + " ， " + i13);
        this.mVideoWidth = i11;
        this.mVideoHeight = i12;
        this.mVideoRotate = i13;
        runOnUiThread(new Runnable() { // from class: com.aliyun.player.videoview.displayView.IDisplayView.3
            @Override // java.lang.Runnable
            public void run() {
                IDisplayView.this.updateViewParams();
            }
        });
    }

    protected abstract Bitmap snapRenderView();

    public Bitmap snapShot() {
        return snapRenderView();
    }
}
