package com.bumptech.glide.integration.webp;

import android.graphics.Bitmap;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class WebpFrame {
    static final int FRAME_DURATION_MS_FOR_MIN = 100;
    static final int MIN_FRAME_DURATION_MS = 20;
    boolean blendPreviousFrame;
    int delay;
    boolean disposeBackgroundColor;

    /* renamed from: ih, reason: collision with root package name */
    int f20219ih;

    /* renamed from: iw, reason: collision with root package name */
    int f20220iw;

    /* renamed from: ix, reason: collision with root package name */
    int f20221ix;

    /* renamed from: iy, reason: collision with root package name */
    int f20222iy;

    @Keep
    private long mNativePtr;

    WebpFrame(long j11, int i11, int i12, int i13, int i14, int i15, boolean z10, boolean z11) {
        this.mNativePtr = j11;
        this.f20221ix = i11;
        this.f20222iy = i12;
        this.f20220iw = i13;
        this.f20219ih = i14;
        this.delay = i15;
        this.blendPreviousFrame = z10;
        this.disposeBackgroundColor = z11;
        fixFrameDuration();
    }

    private void fixFrameDuration() {
        if (this.delay < 20) {
            this.delay = 100;
        }
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native void nativeRenderFrame(int i11, int i12, Bitmap bitmap);

    public void dispose() {
        nativeDispose();
    }

    protected void finalize() throws Throwable {
        nativeFinalize();
    }

    public int getDurationMs() {
        return this.delay;
    }

    public int getHeight() {
        return this.f20219ih;
    }

    public int getWidth() {
        return this.f20220iw;
    }

    public int getXOffest() {
        return this.f20221ix;
    }

    public int getYOffest() {
        return this.f20222iy;
    }

    public boolean isBlendWithPreviousFrame() {
        return this.blendPreviousFrame;
    }

    public void renderFrame(int i11, int i12, Bitmap bitmap) {
        nativeRenderFrame(i11, i12, bitmap);
    }

    public boolean shouldDisposeToBackgroundColor() {
        return this.disposeBackgroundColor;
    }
}
