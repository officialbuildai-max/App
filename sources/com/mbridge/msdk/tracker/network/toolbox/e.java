package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.t;

/* loaded from: classes5.dex */
public class e implements com.mbridge.msdk.tracker.network.c {
    @Override // com.mbridge.msdk.tracker.network.c
    public String a(t<?> tVar) {
        String t11 = tVar.t();
        int g11 = tVar.g();
        if (g11 == 0) {
            return t11;
        }
        return Integer.toString(g11) + '-' + t11;
    }
}
