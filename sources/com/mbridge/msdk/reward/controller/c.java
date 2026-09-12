package com.mbridge.msdk.reward.controller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Context f37213a;

    /* renamed from: b, reason: collision with root package name */
    private final String f37214b;

    public c(Context context, String str) {
        this.f37213a = context;
        this.f37214b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        CopyOnWriteArrayList<CampaignEx> c11;
        if (this.f37213a == null || TextUtils.isEmpty(this.f37214b)) {
            return;
        }
        try {
            com.mbridge.msdk.reward.report.a.a(this.f37213a, this.f37214b);
            m0.a();
            m0.a(e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_RES));
            m0.a(e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML));
            com.mbridge.msdk.videocommon.setting.b.b().b(this.f37214b);
            if (q0.a().a("c_d_v_w_i", false) || TextUtils.isEmpty(this.f37214b) || (c11 = com.mbridge.msdk.videocommon.cache.a.a().c(this.f37214b, 1)) == null || c11.size() <= 0) {
                return;
            }
            com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f37213a, this.f37214b, c11, 94, (com.mbridge.msdk.videocommon.listener.a) null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoControllerInitTask", "initRewardVideoController task ", e11);
            }
        }
    }
}
