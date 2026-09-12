package androidx.media3.common.util;

import android.os.Looper;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final p f10463a;

    /* renamed from: b, reason: collision with root package name */
    private final p f10464b;

    /* renamed from: c, reason: collision with root package name */
    private final a f10465c;

    /* renamed from: d, reason: collision with root package name */
    private Object f10466d;

    /* renamed from: e, reason: collision with root package name */
    private Object f10467e;

    /* renamed from: f, reason: collision with root package name */
    private int f10468f;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Object obj, Object obj2);
    }

    public g(Object obj, Looper looper, Looper looper2, i iVar, a aVar) {
        this.f10463a = iVar.createHandler(looper, null);
        this.f10464b = iVar.createHandler(looper2, null);
        this.f10466d = obj;
        this.f10467e = obj;
        this.f10465c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Object obj) {
        if (this.f10468f == 0) {
            k(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Object obj) {
        int i11 = this.f10468f - 1;
        this.f10468f = i11;
        if (i11 == 0) {
            k(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(com.google.common.base.f fVar) {
        final Object apply = fVar.apply(this.f10467e);
        this.f10467e = apply;
        this.f10464b.post(new Runnable() { // from class: androidx.media3.common.util.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.f(apply);
            }
        });
    }

    private void k(Object obj) {
        Object obj2 = this.f10466d;
        this.f10466d = obj;
        if (obj2.equals(obj)) {
            return;
        }
        this.f10465c.a(obj2, obj);
    }

    public Object d() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == this.f10464b.getLooper()) {
            return this.f10466d;
        }
        androidx.media3.common.util.a.g(myLooper == this.f10463a.getLooper());
        return this.f10467e;
    }

    public void h(Runnable runnable) {
        this.f10463a.post(runnable);
    }

    public void i(final Object obj) {
        this.f10467e = obj;
        this.f10464b.post(new Runnable() { // from class: androidx.media3.common.util.d
            @Override // java.lang.Runnable
            public final void run() {
                g.this.e(obj);
            }
        });
    }

    public void j(com.google.common.base.f fVar, final com.google.common.base.f fVar2) {
        androidx.media3.common.util.a.g(Looper.myLooper() == this.f10464b.getLooper());
        this.f10468f++;
        this.f10463a.post(new Runnable() { // from class: androidx.media3.common.util.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.g(fVar2);
            }
        });
        k(fVar.apply(this.f10466d));
    }
}
