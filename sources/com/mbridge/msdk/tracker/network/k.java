package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.tracker.network.v;
import java.nio.charset.StandardCharsets;

/* loaded from: classes5.dex */
public class k extends h<String> implements v.a {
    private final j<String> C;

    public k(int i11, String str, String str2, long j11, j<String> jVar) {
        super(i11, str, 0, str2, j11);
        this.C = jVar;
        a((v.a) this);
    }

    private void a(v<String> vVar, q qVar) {
        j<String> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.a(this, vVar, qVar);
            } catch (Exception e11) {
                o0.b(h.B, "parseNetworkResponse error: ", e11);
            }
        }
    }

    private void b(v<String> vVar) {
        j<String> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.b(this, vVar, vVar.f38747c.f38614a);
            } catch (Exception e11) {
                o0.b(h.B, "parseNetworkResponse error: ", e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    public v<String> a(q qVar) {
        try {
            v<String> a11 = v.a(new String(qVar.f38670b, StandardCharsets.UTF_8), com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
            a(a11, qVar);
            return a11;
        } catch (Throwable th2) {
            o0.b(h.B, "parseNetworkResponse error: ", th2);
            v<String> a12 = v.a(new a0(th2));
            b(a12);
            return a12;
        }
    }

    @Override // com.mbridge.msdk.tracker.network.v.a
    public void a(b0 b0Var) {
        b(v.a(b0Var));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
    }
}
