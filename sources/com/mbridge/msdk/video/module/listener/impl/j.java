package com.mbridge.msdk.video.module.listener.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.n0;

/* loaded from: classes5.dex */
public class j extends e {

    /* renamed from: d, reason: collision with root package name */
    private int f39513d;

    public j(ImageView imageView, int i11) {
        super(imageView);
        this.f39513d = i11;
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.e, com.mbridge.msdk.foundation.same.image.c
    public void onSuccessLoad(Bitmap bitmap, String str) {
        Bitmap a11;
        if (bitmap == null) {
            return;
        }
        try {
            if (this.f39506a == null || bitmap.isRecycled() || (a11 = n0.a(bitmap, 1, this.f39513d)) == null) {
                return;
            }
            this.f39506a.setImageBitmap(a11);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }
}
