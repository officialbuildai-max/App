package androidx.compose.runtime;

import java.util.List;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3942a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final w f3943b = new a();

    /* loaded from: classes.dex */
    public static final class a implements w {
        a() {
        }
    }

    public static final l a(f fVar, m mVar) {
        return new o(mVar, fVar, null, 4, null);
    }

    public static final d2 b(f fVar, m mVar) {
        return new o(mVar, fVar, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(androidx.collection.d0 d0Var, int i11, int i12) {
        int a11 = d0Var.a(i11);
        d0Var.j(i11, d0Var.a(i12));
        d0Var.j(i12, a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(List list, int i11, int i12) {
        Object obj = list.get(i11);
        list.set(i11, list.get(i12));
        list.set(i12, obj);
    }
}
