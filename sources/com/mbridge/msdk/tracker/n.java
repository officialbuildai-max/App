package com.mbridge.msdk.tracker;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class n implements f {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f38604a = new ConcurrentHashMap<>();

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f38605a;

        public a(boolean z10) {
            this.f38605a = z10;
        }

        public boolean a() {
            return this.f38605a;
        }
    }

    @Override // com.mbridge.msdk.tracker.f
    public boolean a(e eVar) throws Exception {
        a aVar;
        if (eVar != null && !TextUtils.isEmpty(eVar.b())) {
            try {
                String b11 = eVar.b();
                if (this.f38604a.containsKey(b11)) {
                    aVar = this.f38604a.get(b11);
                } else {
                    a aVar2 = new a(com.mbridge.msdk.foundation.same.report.c.a(b11));
                    this.f38604a.put(b11, aVar2);
                    aVar = aVar2;
                }
                if (aVar != null) {
                    return aVar.a();
                }
                return false;
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("TrackManager", "apply", e11);
                }
            }
        }
        return false;
    }
}
