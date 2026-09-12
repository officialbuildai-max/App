package androidx.compose.ui.input.pointer;

import androidx.compose.ui.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.layout.l f5060a;

    /* renamed from: b, reason: collision with root package name */
    private final m f5061b = new m();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.collection.h0 f5062c = new androidx.collection.h0(10);

    public f(androidx.compose.ui.layout.l lVar) {
        this.f5060a = lVar;
    }

    private final void f(long j11, androidx.collection.l0 l0Var) {
        this.f5061b.i(j11, l0Var);
    }

    public final void a(long j11, List list, boolean z10) {
        Object obj;
        m mVar = this.f5061b;
        this.f5062c.g();
        int size = list.size();
        boolean z11 = true;
        for (int i11 = 0; i11 < size; i11++) {
            f.c cVar = (f.c) list.get(i11);
            if (z11) {
                androidx.compose.runtime.collection.b g11 = mVar.g();
                int n11 = g11.n();
                if (n11 > 0) {
                    Object[] m11 = g11.m();
                    int i12 = 0;
                    do {
                        obj = m11[i12];
                        if (Intrinsics.c(((l) obj).k(), cVar)) {
                            break;
                        } else {
                            i12++;
                        }
                    } while (i12 < n11);
                }
                obj = null;
                l lVar = (l) obj;
                if (lVar != null) {
                    lVar.n();
                    lVar.l().b(j11);
                    androidx.collection.h0 h0Var = this.f5062c;
                    Object b11 = h0Var.b(j11);
                    if (b11 == null) {
                        b11 = new androidx.collection.l0(0, 1, null);
                        h0Var.o(j11, b11);
                    }
                    ((androidx.collection.l0) b11).e(lVar);
                    mVar = lVar;
                } else {
                    z11 = false;
                }
            }
            l lVar2 = new l(cVar);
            lVar2.l().b(j11);
            androidx.collection.h0 h0Var2 = this.f5062c;
            Object b12 = h0Var2.b(j11);
            if (b12 == null) {
                b12 = new androidx.collection.l0(0, 1, null);
                h0Var2.o(j11, b12);
            }
            ((androidx.collection.l0) b12).e(lVar2);
            mVar.g().b(lVar2);
            mVar = lVar2;
        }
        if (!z10) {
            return;
        }
        androidx.collection.h0 h0Var3 = this.f5062c;
        long[] jArr = h0Var3.f2415b;
        Object[] objArr = h0Var3.f2416c;
        long[] jArr2 = h0Var3.f2414a;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i13 = 0;
        while (true) {
            long j12 = jArr2[i13];
            if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i14 = 8 - ((~(i13 - length)) >>> 31);
                for (int i15 = 0; i15 < i14; i15++) {
                    if ((255 & j12) < 128) {
                        int i16 = (i13 << 3) + i15;
                        f(jArr[i16], (androidx.collection.l0) objArr[i16]);
                    }
                    j12 >>= 8;
                }
                if (i14 != 8) {
                    return;
                }
            }
            if (i13 == length) {
                return;
            } else {
                i13++;
            }
        }
    }

    public final void b() {
        this.f5061b.c();
    }

    public final boolean c(g gVar, boolean z10) {
        if (this.f5061b.a(gVar.b(), this.f5060a, gVar, z10)) {
            return this.f5061b.e(gVar) || this.f5061b.f(gVar.b(), this.f5060a, gVar, z10);
        }
        return false;
    }

    public final void d() {
        this.f5061b.d();
        b();
    }

    public final void e() {
        this.f5061b.h();
    }
}
