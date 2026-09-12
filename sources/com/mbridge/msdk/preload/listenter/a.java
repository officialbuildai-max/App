package com.mbridge.msdk.preload.listenter;

import com.mbridge.msdk.out.PreloadListener;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class a implements PreloadListener {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<PreloadListener> f36848a;

    /* renamed from: b, reason: collision with root package name */
    private int f36849b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f36850c = false;

    public a(PreloadListener preloadListener) {
        if (preloadListener != null) {
            this.f36848a = new WeakReference<>(preloadListener);
        }
    }

    public void a(boolean z10) {
        this.f36850c = z10;
    }

    public boolean a() {
        return this.f36850c;
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public void onPreloadFaild(String str) {
        WeakReference<PreloadListener> weakReference = this.f36848a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f36848a.get().onPreloadFaild(str);
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public void onPreloadSucceed() {
        WeakReference<PreloadListener> weakReference = this.f36848a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f36848a.get().onPreloadSucceed();
    }
}
