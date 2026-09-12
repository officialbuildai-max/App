package com.blankj.utilcode.util;

import android.view.View;

/* loaded from: classes2.dex */
public abstract class ClickUtils$OnDebouncingClickListener implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f20088c = true;

    /* renamed from: d, reason: collision with root package name */
    private static final Runnable f20089d = new Runnable() { // from class: com.blankj.utilcode.util.ClickUtils$OnDebouncingClickListener.1
        @Override // java.lang.Runnable
        public void run() {
            boolean unused = ClickUtils$OnDebouncingClickListener.f20088c = true;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private long f20090a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f20091b;

    public ClickUtils$OnDebouncingClickListener() {
        this(true, 1000L);
    }

    public ClickUtils$OnDebouncingClickListener(boolean z10, long j11) {
        this.f20091b = z10;
        this.f20090a = j11;
    }

    private static boolean b(View view, long j11) {
        return e0.E(view, j11);
    }

    public abstract void c(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.f20091b) {
            if (b(view, this.f20090a)) {
                c(view);
            }
        } else if (f20088c) {
            f20088c = false;
            view.postDelayed(f20089d, this.f20090a);
            c(view);
        }
    }
}
