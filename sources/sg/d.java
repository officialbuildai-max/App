package sg;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import io.reactivex.rxjava3.core.n;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f75472a = new d();

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m d(j observable) {
        Intrinsics.h(observable, "observable");
        return observable.E(qz.a.c()).v(io.reactivex.rxjava3.android.schedulers.b.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m f(j observable) {
        Intrinsics.h(observable, "observable");
        return observable.E(qz.a.c()).v(qz.a.c());
    }

    public final n c() {
        return new n() { // from class: sg.b
            @Override // io.reactivex.rxjava3.core.n
            public final m a(j jVar) {
                m d11;
                d11 = d.d(jVar);
                return d11;
            }
        };
    }

    public final n e() {
        return new n() { // from class: sg.c
            @Override // io.reactivex.rxjava3.core.n
            public final m a(j jVar) {
                m f11;
                f11 = d.f(jVar);
                return f11;
            }
        };
    }
}
