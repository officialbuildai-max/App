package com.google.firebase.perf.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class f implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f32424a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference f32425b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f32426c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f32427d;

    private f(View view, Runnable runnable, Runnable runnable2) {
        this.f32425b = new AtomicReference(view);
        this.f32426c = runnable;
        this.f32427d = runnable2;
    }

    public static void a(View view, Runnable runnable, Runnable runnable2) {
        view.getViewTreeObserver().addOnPreDrawListener(new f(view, runnable, runnable2));
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View view = (View) this.f32425b.getAndSet(null);
        if (view == null) {
            return true;
        }
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f32424a.post(this.f32426c);
        this.f32424a.postAtFrontOfQueue(this.f32427d);
        return true;
    }
}
