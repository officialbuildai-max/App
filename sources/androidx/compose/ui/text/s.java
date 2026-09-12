package androidx.compose.ui.text;

import androidx.compose.ui.text.style.d;
import androidx.compose.ui.text.style.e;
import androidx.compose.ui.text.style.h;
import androidx.compose.ui.unit.LayoutDirection;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final long f6428a = o0.w.f70751b.a();

    /* JADX WARN: Code restructure failed: missing block: B:41:0x003d, code lost:
    
        if (o0.w.e(r12, r24.e()) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.text.r a(androidx.compose.ui.text.r r24, int r25, int r26, long r27, androidx.compose.ui.text.style.n r29, androidx.compose.ui.text.u r30, androidx.compose.ui.text.style.g r31, int r32, int r33, androidx.compose.ui.text.style.o r34) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.s.a(androidx.compose.ui.text.r, int, int, long, androidx.compose.ui.text.style.n, androidx.compose.ui.text.u, androidx.compose.ui.text.style.g, int, int, androidx.compose.ui.text.style.o):androidx.compose.ui.text.r");
    }

    private static final u b(r rVar, u uVar) {
        return rVar.g() == null ? uVar : uVar == null ? rVar.g() : rVar.g().c(uVar);
    }

    public static final r c(r rVar, LayoutDirection layoutDirection) {
        int h11 = rVar.h();
        h.a aVar = androidx.compose.ui.text.style.h.f6475b;
        int f11 = androidx.compose.ui.text.style.h.k(h11, aVar.g()) ? aVar.f() : rVar.h();
        int d11 = e0.d(layoutDirection, rVar.i());
        long e11 = o0.x.d(rVar.e()) ? f6428a : rVar.e();
        androidx.compose.ui.text.style.n j11 = rVar.j();
        if (j11 == null) {
            j11 = androidx.compose.ui.text.style.n.f6504c.a();
        }
        androidx.compose.ui.text.style.n nVar = j11;
        u g11 = rVar.g();
        androidx.compose.ui.text.style.g f12 = rVar.f();
        int d12 = rVar.d();
        e.a aVar2 = androidx.compose.ui.text.style.e.f6441a;
        int a11 = androidx.compose.ui.text.style.e.d(d12, aVar2.b()) ? aVar2.a() : rVar.d();
        int c11 = rVar.c();
        d.a aVar3 = androidx.compose.ui.text.style.d.f6437a;
        int b11 = androidx.compose.ui.text.style.d.e(c11, aVar3.c()) ? aVar3.b() : rVar.c();
        androidx.compose.ui.text.style.o k11 = rVar.k();
        if (k11 == null) {
            k11 = androidx.compose.ui.text.style.o.f6508c.a();
        }
        return new r(f11, d11, e11, nVar, g11, f12, a11, b11, k11, null);
    }
}
