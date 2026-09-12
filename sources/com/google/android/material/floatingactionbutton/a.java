package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* loaded from: classes4.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private Animator f29034a;

    public void a() {
        Animator animator = this.f29034a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f29034a = null;
    }

    public void c(Animator animator) {
        a();
        this.f29034a = animator;
    }
}
