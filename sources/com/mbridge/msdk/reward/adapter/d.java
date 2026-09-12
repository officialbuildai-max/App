package com.mbridge.msdk.reward.adapter;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f37103a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f37104b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f37105c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f37106d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f37107e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f37108f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f37109g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f37110h = 0;

    public void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            this.f37104b = campaignEx;
            this.f37106d = campaignEx.getSecondRequestIndex();
            this.f37107e = campaignEx.getSecondShowIndex();
            this.f37108f = campaignEx.getFilterCallBackState();
            this.f37110h = campaignEx.getFilterAdsShowCallState();
            this.f37109g = campaignEx.getFilterAdsVideoCallState();
        }
    }

    public void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f37103a = copyOnWriteArrayList;
    }

    public void a(boolean z10) {
        this.f37105c = z10;
    }

    public boolean a() {
        return this.f37106d == 1 && this.f37105c;
    }

    public CopyOnWriteArrayList<CampaignEx> b() {
        return this.f37103a;
    }

    public int c() {
        return this.f37109g;
    }

    public int d() {
        return this.f37108f;
    }

    public boolean e() {
        return this.f37105c;
    }
}
