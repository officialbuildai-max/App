package com.mbridge.msdk.foundation.same.net.wrapper;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;

/* loaded from: classes5.dex */
public class h extends c {
    public h(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.wrapper.c
    public void addExtraParams(String str, e eVar) {
        try {
            int a11 = t0.a();
            String c11 = t0.c();
            if (eVar != null) {
                eVar.a("misk_spt", String.valueOf(a11));
                if (!TextUtils.isEmpty(c11)) {
                    eVar.a("misk_spt_det", c11);
                }
            }
        } catch (Exception e11) {
            o0.a("CampaignRequest", e11.getMessage());
        } finally {
            super.addExtraParams(str, eVar);
        }
    }
}
