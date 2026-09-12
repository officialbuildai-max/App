package com.mbridge.msdk.foundation.same.report;

import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.v;
import com.mbridge.msdk.tracker.w;
import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
public class n extends w {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.w
    public v<String> a(q qVar) {
        String str;
        try {
            str = new String(qVar.f38670b, com.mbridge.msdk.tracker.network.toolbox.f.a(qVar.f38671c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(qVar.f38670b);
        }
        return v.a(str, com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
    }
}
