package com.transsion.postdetail.layer.local;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class j1 {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f49118a;

    /* renamed from: b, reason: collision with root package name */
    private final TextView f49119b;

    /* renamed from: c, reason: collision with root package name */
    private long f49120c;

    /* renamed from: d, reason: collision with root package name */
    private int f49121d = 1;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f49122e = new Runnable() { // from class: com.transsion.postdetail.layer.local.h1
        @Override // java.lang.Runnable
        public final void run() {
            j1.e(j1.this);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f49123f = new Runnable() { // from class: com.transsion.postdetail.layer.local.i1
        @Override // java.lang.Runnable
        public final void run() {
            j1.f(j1.this);
        }
    };

    /* loaded from: classes6.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f49125b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f49126c;

        a(TextView textView, String str) {
            this.f49125b = textView;
            this.f49126c = str;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.h(animation, "animation");
            j1.this.f49120c = System.currentTimeMillis();
            TextView textView = this.f49125b;
            if (textView != null) {
                jg.c.k(textView);
            }
            TextView textView2 = this.f49125b;
            if (textView2 != null) {
                textView2.setText(this.f49126c);
            }
        }
    }

    public j1(TextView textView, TextView textView2) {
        this.f49118a = textView;
        this.f49119b = textView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(j1 j1Var) {
        TextView textView = j1Var.f49118a;
        if (textView != null) {
            jg.c.g(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(j1 j1Var) {
        TextView textView = j1Var.f49119b;
        if (textView != null) {
            jg.c.g(textView);
        }
    }

    private final void g(String str, long j11, TextView textView, long j12, Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(500L);
        if (textView != null) {
            jg.c.g(textView);
        }
        ofFloat.addListener(new a(textView, str));
        ofFloat.setStartDelay(j11);
        ofFloat.start();
        if (j12 <= 0 || textView == null) {
            return;
        }
        textView.postDelayed(runnable, j12);
    }

    public static /* synthetic */ void i(j1 j1Var, String str, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 3000;
        }
        j1Var.h(str, j11);
    }

    public final void d() {
        TextView textView = this.f49118a;
        if (textView != null) {
            jg.c.g(textView);
        }
        TextView textView2 = this.f49119b;
        if (textView2 != null) {
            jg.c.g(textView2);
        }
    }

    public final void h(String content, long j11) {
        TextView textView;
        Intrinsics.h(content, "content");
        TextView textView2 = this.f49118a;
        if (textView2 != null && jg.c.i(textView2) && (textView = this.f49119b) != null && jg.c.i(textView)) {
            int i11 = this.f49121d;
            TextView textView3 = i11 == 1 ? this.f49119b : this.f49118a;
            Runnable runnable = i11 == 1 ? this.f49123f : this.f49122e;
            textView3.removeCallbacks(runnable);
            g(content, 0L, textView3, j11, runnable);
            this.f49121d = this.f49121d != 1 ? 1 : 2;
            return;
        }
        TextView textView4 = this.f49118a;
        if (textView4 == null || !jg.c.i(textView4)) {
            this.f49121d = 1;
            g(content, 0L, this.f49118a, j11, this.f49122e);
        } else {
            long j12 = System.currentTimeMillis() - this.f49120c < 500 ? 500L : 0L;
            this.f49121d = 2;
            g(content, j12, this.f49119b, j11, this.f49123f);
        }
    }
}
