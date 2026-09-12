package androidx.view;

import androidx.view.Lifecycle;
import androidx.view.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h0 implements r {

    /* renamed from: a, reason: collision with root package name */
    private final Object f9688a;

    /* renamed from: b, reason: collision with root package name */
    private final c.a f9689b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(Object obj) {
        this.f9688a = obj;
        this.f9689b = c.f9660c.c(obj.getClass());
    }

    @Override // androidx.view.r
    public void onStateChanged(u uVar, Lifecycle.Event event) {
        this.f9689b.a(uVar, event, this.f9688a);
    }
}
