package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f67999a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f68000b;

    /* renamed from: c, reason: collision with root package name */
    private final m2[] f68001c;

    /* renamed from: d, reason: collision with root package name */
    private int f68002d;

    public m0(CoroutineContext coroutineContext, int i11) {
        this.f67999a = coroutineContext;
        this.f68000b = new Object[i11];
        this.f68001c = new m2[i11];
    }

    public final void a(m2 m2Var, Object obj) {
        Object[] objArr = this.f68000b;
        int i11 = this.f68002d;
        objArr[i11] = obj;
        m2[] m2VarArr = this.f68001c;
        this.f68002d = i11 + 1;
        Intrinsics.f(m2Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        m2VarArr[i11] = m2Var;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f68001c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i11 = length - 1;
            m2 m2Var = this.f68001c[length];
            Intrinsics.e(m2Var);
            m2Var.m(coroutineContext, this.f68000b[length]);
            if (i11 < 0) {
                return;
            } else {
                length = i11;
            }
        }
    }
}
