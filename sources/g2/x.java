package g2;

import androidx.media3.common.e0;
import androidx.media3.common.t;

/* loaded from: classes2.dex */
public final class x extends androidx.media3.exoplayer.source.m {

    /* renamed from: f, reason: collision with root package name */
    private final androidx.media3.common.t f63386f;

    public x(e0 e0Var, androidx.media3.common.t tVar) {
        super(e0Var);
        this.f63386f = tVar;
    }

    @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
    public e0.c o(int i11, e0.c cVar, long j11) {
        super.o(i11, cVar, j11);
        androidx.media3.common.t tVar = this.f63386f;
        cVar.f10035c = tVar;
        t.h hVar = tVar.f10293b;
        cVar.f10034b = hVar != null ? hVar.f10392h : null;
        return cVar;
    }
}
