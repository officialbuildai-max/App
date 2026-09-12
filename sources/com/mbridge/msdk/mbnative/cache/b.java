package com.mbridge.msdk.mbnative.cache;

import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* loaded from: classes5.dex */
public abstract class b<K, V> {
    public long a() {
        g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 == null) {
            d11 = h.b().a();
        }
        return d11.Z() * 1000;
    }

    public abstract V a(K k11, int i11);

    public abstract void a(K k11, V v11);

    public abstract void a(K k11, V v11, String str);

    public abstract void a(String str, Campaign campaign, String str2);

    public long b() {
        g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 == null) {
            d11 = h.b().a();
        }
        return d11.a0() * 1000;
    }

    public V b(K k11, int i11) {
        return null;
    }
}
