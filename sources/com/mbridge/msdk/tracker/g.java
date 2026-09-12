package com.mbridge.msdk.tracker;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class g implements l {

    /* renamed from: a, reason: collision with root package name */
    private final c f38566a;

    /* renamed from: b, reason: collision with root package name */
    private final s f38567b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicLong f38568c = new AtomicLong(0);

    /* renamed from: d, reason: collision with root package name */
    private final long[] f38569d = new long[2];

    public g(c cVar, s sVar) {
        this.f38566a = cVar;
        this.f38567b = sVar;
    }

    @Override // com.mbridge.msdk.tracker.l
    public void a(e eVar) {
        try {
            long incrementAndGet = this.f38568c.incrementAndGet();
            this.f38569d[0] = System.currentTimeMillis();
            this.f38569d[1] = incrementAndGet;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("TrackManager", "notice error", e11);
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.l
    public long[] a() {
        long[] jArr = this.f38569d;
        return jArr.length == 0 ? new long[]{0, 0} : jArr;
    }

    @Override // com.mbridge.msdk.tracker.l
    public void b(e eVar) {
        try {
            i iVar = new i(eVar);
            iVar.a(1);
            iVar.b(0);
            iVar.a(System.currentTimeMillis() + eVar.f());
            this.f38566a.a(iVar);
            this.f38567b.k();
            this.f38567b.e();
            this.f38567b.a(eVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("TrackManager", "process error", e11);
            }
        }
    }
}
