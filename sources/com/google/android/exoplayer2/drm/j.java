package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.s;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import com.google.common.collect.r4;
import com.google.common.primitives.Ints;
import java.util.Map;

/* loaded from: classes3.dex */
public final class j implements x {

    /* renamed from: a, reason: collision with root package name */
    private final Object f25047a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private v1.f f25048b;

    /* renamed from: c, reason: collision with root package name */
    private u f25049c;

    /* renamed from: d, reason: collision with root package name */
    private k.a f25050d;

    /* renamed from: e, reason: collision with root package name */
    private String f25051e;

    private u b(v1.f fVar) {
        k.a aVar = this.f25050d;
        if (aVar == null) {
            aVar = new s.b().b(this.f25051e);
        }
        Uri uri = fVar.f27797c;
        i0 i0Var = new i0(uri == null ? null : uri.toString(), fVar.f27802h, aVar);
        r4 it = fVar.f27799e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            i0Var.e((String) entry.getKey(), (String) entry.getValue());
        }
        DefaultDrmSessionManager a11 = new DefaultDrmSessionManager.b().e(fVar.f27795a, h0.f25038d).b(fVar.f27800f).c(fVar.f27801g).d(Ints.o(fVar.f27804j)).a(i0Var);
        a11.E(0, fVar.c());
        return a11;
    }

    @Override // com.google.android.exoplayer2.drm.x
    public u a(v1 v1Var) {
        u uVar;
        com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
        v1.f fVar = v1Var.f27763b.f27828c;
        if (fVar == null || p0.f27680a < 18) {
            return u.f25071a;
        }
        synchronized (this.f25047a) {
            try {
                if (!p0.c(fVar, this.f25048b)) {
                    this.f25048b = fVar;
                    this.f25049c = b(fVar);
                }
                uVar = (u) com.google.android.exoplayer2.util.a.e(this.f25049c);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return uVar;
    }
}
