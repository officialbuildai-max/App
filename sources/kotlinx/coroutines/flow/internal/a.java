package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private c[] f67926a;

    /* renamed from: b, reason: collision with root package name */
    private int f67927b;

    /* renamed from: c, reason: collision with root package name */
    private int f67928c;

    /* renamed from: d, reason: collision with root package name */
    private t f67929d;

    public static final /* synthetic */ int g(a aVar) {
        return aVar.f67927b;
    }

    public static final /* synthetic */ c[] h(a aVar) {
        return aVar.f67926a;
    }

    public final i1 c() {
        t tVar;
        synchronized (this) {
            tVar = this.f67929d;
            if (tVar == null) {
                tVar = new t(this.f67927b);
                this.f67929d = tVar;
            }
        }
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final c i() {
        c cVar;
        t tVar;
        synchronized (this) {
            try {
                c[] cVarArr = this.f67926a;
                if (cVarArr == null) {
                    cVarArr = k(2);
                    this.f67926a = cVarArr;
                } else if (this.f67927b >= cVarArr.length) {
                    Object[] copyOf = Arrays.copyOf(cVarArr, cVarArr.length * 2);
                    Intrinsics.g(copyOf, "copyOf(...)");
                    this.f67926a = (c[]) copyOf;
                    cVarArr = (c[]) copyOf;
                }
                int i11 = this.f67928c;
                do {
                    cVar = cVarArr[i11];
                    if (cVar == null) {
                        cVar = j();
                        cVarArr[i11] = cVar;
                    }
                    i11++;
                    if (i11 >= cVarArr.length) {
                        i11 = 0;
                    }
                    Intrinsics.f(cVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!cVar.a(this));
                this.f67928c = i11;
                this.f67927b++;
                tVar = this.f67929d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (tVar != null) {
            tVar.a0(1);
        }
        return cVar;
    }

    protected abstract c j();

    protected abstract c[] k(int i11);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(c cVar) {
        t tVar;
        int i11;
        Continuation[] b11;
        synchronized (this) {
            try {
                int i12 = this.f67927b - 1;
                this.f67927b = i12;
                tVar = this.f67929d;
                if (i12 == 0) {
                    this.f67928c = 0;
                }
                Intrinsics.f(cVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                b11 = cVar.b(this);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        for (Continuation continuation : b11) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
            }
        }
        if (tVar != null) {
            tVar.a0(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int m() {
        return this.f67927b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final c[] n() {
        return this.f67926a;
    }
}
