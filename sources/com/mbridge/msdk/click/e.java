package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes5.dex */
public class e extends f {

    /* renamed from: e, reason: collision with root package name */
    private int f34359e;

    /* renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.task.b f34362h;

    /* renamed from: i, reason: collision with root package name */
    private p f34363i;

    /* renamed from: b, reason: collision with root package name */
    JumpLoaderResult f34356b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f34357c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f34358d = null;

    /* renamed from: f, reason: collision with root package name */
    private g f34360f = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f34361g = true;

    /* renamed from: j, reason: collision with root package name */
    private Handler f34364j = new Handler(Looper.getMainLooper());

    public e(Context context) {
        this.f34362h = new com.mbridge.msdk.foundation.same.task.b(context);
        this.f34363i = new p(context);
    }

    public void a() {
        this.f34361g = false;
    }

    public void a(String str, CampaignEx campaignEx, g gVar) {
        this.f34358d = new String(campaignEx.getClickURL());
        this.f34360f = gVar;
        this.f34356b = null;
        this.f34363i.a(campaignEx.getClickURL(), gVar, "5".equals(campaignEx.getClick_mode()) || PrepareException.ERROR_NO_URL.equals(campaignEx.getClick_mode()), campaignEx.getId(), str, campaignEx, true, false, com.mbridge.msdk.click.retry.a.f34475p);
    }

    public void a(String str, CampaignEx campaignEx, g gVar, String str2, boolean z10, boolean z11, int i11) {
        String str3;
        this.f34358d = str2;
        this.f34360f = gVar;
        this.f34356b = null;
        this.f34359e = i11;
        if (campaignEx != null) {
            r1 = "5".equals(campaignEx.getClick_mode()) || PrepareException.ERROR_NO_URL.equals(campaignEx.getClick_mode());
            str3 = campaignEx.getId();
        } else {
            str3 = "";
        }
        this.f34363i.a(str2, gVar, r1, str3, str, campaignEx, z10, z11, i11);
    }
}
