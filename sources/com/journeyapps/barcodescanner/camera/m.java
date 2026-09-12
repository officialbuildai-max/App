package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import java.util.List;
import xe.q;

/* loaded from: classes4.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private q f34057a;

    /* renamed from: b, reason: collision with root package name */
    private int f34058b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f34059c = false;

    /* renamed from: d, reason: collision with root package name */
    private PreviewScalingStrategy f34060d = new n();

    public m(int i11, q qVar) {
        this.f34058b = i11;
        this.f34057a = qVar;
    }

    public q a(List list, boolean z10) {
        return this.f34060d.b(list, b(z10));
    }

    public q b(boolean z10) {
        q qVar = this.f34057a;
        if (qVar == null) {
            return null;
        }
        return z10 ? qVar.d() : qVar;
    }

    public int c() {
        return this.f34058b;
    }

    public Rect d(q qVar) {
        return this.f34060d.d(qVar, this.f34057a);
    }

    public void e(PreviewScalingStrategy previewScalingStrategy) {
        this.f34060d = previewScalingStrategy;
    }
}
