package com.google.android.material.progressindicator;

import com.google.android.material.progressindicator.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    protected j f29530a;

    /* renamed from: b, reason: collision with root package name */
    protected final List f29531b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public i(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            this.f29531b.add(new h.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public float b(int i11, int i12, int i13) {
        return (i11 - i12) / i13;
    }

    public abstract void c();

    public abstract void d(androidx.vectordrawable.graphics.drawable.b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(j jVar) {
        this.f29530a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g();

    public abstract void h();
}
