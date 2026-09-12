package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes4.dex */
class c0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    private final ViewOverlay f29248a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(View view) {
        this.f29248a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.d0
    public void a(Drawable drawable) {
        this.f29248a.add(drawable);
    }

    @Override // com.google.android.material.internal.d0
    public void b(Drawable drawable) {
        this.f29248a.remove(drawable);
    }
}
