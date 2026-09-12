package la;

import com.google.android.exoplayer2.a3;
import com.google.android.exoplayer2.p3;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final int f68923a;

    /* renamed from: b, reason: collision with root package name */
    public final a3[] f68924b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.trackselection.h[] f68925c;

    /* renamed from: d, reason: collision with root package name */
    public final p3 f68926d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f68927e;

    public r(a3[] a3VarArr, com.google.android.exoplayer2.trackselection.h[] hVarArr, p3 p3Var, Object obj) {
        this.f68924b = a3VarArr;
        this.f68925c = (com.google.android.exoplayer2.trackselection.h[]) hVarArr.clone();
        this.f68926d = p3Var;
        this.f68927e = obj;
        this.f68923a = a3VarArr.length;
    }

    public boolean a(r rVar) {
        if (rVar == null || rVar.f68925c.length != this.f68925c.length) {
            return false;
        }
        for (int i11 = 0; i11 < this.f68925c.length; i11++) {
            if (!b(rVar, i11)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(r rVar, int i11) {
        return rVar != null && p0.c(this.f68924b[i11], rVar.f68924b[i11]) && p0.c(this.f68925c[i11], rVar.f68925c[i11]);
    }

    public boolean c(int i11) {
        return this.f68924b[i11] != null;
    }
}
