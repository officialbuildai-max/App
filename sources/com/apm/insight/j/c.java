package com.apm.insight.j;

import android.os.Handler;
import android.text.TextUtils;
import com.apm.insight.e;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;

/* loaded from: classes2.dex */
public final class c extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Handler handler) {
        super(handler, MBInterstitialActivity.WEB_LOAD_TIME);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (e.c().b()) {
            return;
        }
        String d11 = e.a().d();
        if (TextUtils.isEmpty(d11) || "0".equals(d11)) {
            a(b());
            com.apm.insight.a.a((Object) "[DeviceIdTask] did is null, continue check.");
        } else {
            e.c().a(d11);
            com.apm.insight.a.a((Object) "[DeviceIdTask] did is ".concat(String.valueOf(d11)));
        }
    }
}
