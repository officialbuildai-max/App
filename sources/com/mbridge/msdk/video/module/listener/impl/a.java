package com.mbridge.msdk.video.module.listener.impl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private Activity f39501a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f39502b;

    public a(Activity activity, CampaignEx campaignEx) {
        this.f39501a = activity;
        this.f39502b = campaignEx;
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i11, Object obj) {
        super.a(i11, obj);
        if (i11 != 106 || this.f39501a == null || this.f39502b == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            String a11 = com.mbridge.msdk.click.c.a(this.f39502b.getClickURL(), "-999", "-999");
            if (!TextUtils.isEmpty(a11)) {
                intent.setData(Uri.parse(a11));
                this.f39501a.startActivity(intent);
            }
        } catch (Throwable th2) {
            o0.b("NotifyListener", th2.getMessage(), th2);
        }
        this.f39501a.finish();
    }
}
