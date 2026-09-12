package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.graphics.t1;
import androidx.compose.ui.graphics.u1;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import p.a;
import y.m;

/* loaded from: classes.dex */
final class StateLayer {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3564a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f3565b;

    /* renamed from: c, reason: collision with root package name */
    private final Animatable f3566c = androidx.compose.animation.core.a.b(0.0f, 0.0f, 2, null);

    /* renamed from: d, reason: collision with root package name */
    private final List f3567d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private p.f f3568e;

    public StateLayer(boolean z10, Function0 function0) {
        this.f3564a = z10;
        this.f3565b = function0;
    }

    public final void b(z.g gVar, float f11, long j11) {
        long j12;
        float floatValue = ((Number) this.f3566c.k()).floatValue();
        if (floatValue <= 0.0f) {
            return;
        }
        long k11 = u1.k(j11, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.f3564a) {
            z.f.d(gVar, k11, f11, 0L, 0.0f, null, null, 0, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
            return;
        }
        float i11 = m.i(gVar.i());
        float g11 = m.g(gVar.i());
        int b11 = t1.f4722a.b();
        z.d H0 = gVar.H0();
        long i12 = H0.i();
        H0.e().n();
        try {
            H0.c().a(0.0f, 0.0f, i11, g11, b11);
            j12 = i12;
            try {
                z.f.d(gVar, k11, f11, 0L, 0.0f, null, null, 0, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
                H0.e().j();
                H0.f(j12);
            } catch (Throwable th2) {
                th = th2;
                H0.e().j();
                H0.f(j12);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j12 = i12;
        }
    }

    public final void c(p.f fVar, n0 n0Var) {
        boolean z10 = fVar instanceof p.d;
        if (z10) {
            this.f3567d.add(fVar);
        } else if (fVar instanceof p.e) {
            this.f3567d.remove(((p.e) fVar).a());
        } else if (fVar instanceof p.b) {
            this.f3567d.add(fVar);
        } else if (fVar instanceof p.c) {
            this.f3567d.remove(((p.c) fVar).a());
        } else if (fVar instanceof a.b) {
            this.f3567d.add(fVar);
        } else if (fVar instanceof a.c) {
            this.f3567d.remove(((a.c) fVar).a());
        } else if (!(fVar instanceof a.C0907a)) {
            return;
        } else {
            this.f3567d.remove(((a.C0907a) fVar).a());
        }
        p.f fVar2 = (p.f) CollectionsKt.v0(this.f3567d);
        if (Intrinsics.c(this.f3568e, fVar2)) {
            return;
        }
        if (fVar2 != null) {
            c cVar = (c) this.f3565b.invoke();
            kotlinx.coroutines.k.d(n0Var, null, null, new StateLayer$handleInteraction$1(this, z10 ? cVar.c() : fVar instanceof p.b ? cVar.b() : fVar instanceof a.b ? cVar.a() : 0.0f, h.d(fVar2), null), 3, null);
        } else {
            kotlinx.coroutines.k.d(n0Var, null, null, new StateLayer$handleInteraction$2(this, h.e(this.f3568e), null), 3, null);
        }
        this.f3568e = fVar2;
    }
}
