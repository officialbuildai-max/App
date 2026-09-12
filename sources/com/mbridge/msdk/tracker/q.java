package com.mbridge.msdk.tracker;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class q implements l {

    /* renamed from: a, reason: collision with root package name */
    private final g f38764a;

    public q(g gVar) {
        this.f38764a = gVar;
    }

    @Override // com.mbridge.msdk.tracker.l
    public void a(e eVar) {
        if (y.b(this.f38764a)) {
            return;
        }
        this.f38764a.a(eVar);
    }

    @Override // com.mbridge.msdk.tracker.l
    public long[] a() {
        return y.b(this.f38764a) ? new long[]{0, 0} : this.f38764a.a();
    }

    @Override // com.mbridge.msdk.tracker.l
    public void b(e eVar) {
        if (y.b(this.f38764a)) {
            return;
        }
        try {
            h e11 = eVar.e();
            if (y.a(e11)) {
                eVar.a(e11.a(eVar));
            }
            this.f38764a.b(eVar);
        } catch (Exception e12) {
            if (a.f38550a) {
                Log.e("TrackManager", "process event error", e12);
            }
        }
    }
}
