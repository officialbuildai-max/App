package com.mbridge.msdk.mbnative.cache;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.Campaign;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class a extends b<String, List<Campaign>> {

    /* renamed from: a, reason: collision with root package name */
    private e f36285a = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));

    /* renamed from: b, reason: collision with root package name */
    private int f36286b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.mbnative.cache.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0508a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f36287a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f36288b;

        RunnableC0508a(List list, String str) {
            this.f36287a = list;
            this.f36288b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i11 = 0; i11 < this.f36287a.size(); i11++) {
                CampaignEx campaignEx = (CampaignEx) this.f36287a.get(i11);
                campaignEx.setCacheLevel(1);
                a.this.f36285a.a(campaignEx, this.f36288b, 1);
            }
        }
    }

    public a(int i11) {
        this.f36286b = i11;
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public List<Campaign> a(String str, int i11) {
        List<CampaignEx> a11 = this.f36285a.a(str, i11, 1, this.f36286b);
        if (a11 == null) {
            return null;
        }
        if (a(a11, 1)) {
            a(a11, str);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a11);
        return arrayList;
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public void a(String str, Campaign campaign, String str2) {
        boolean z10 = !TextUtils.isEmpty(str2);
        if (campaign == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (this.f36285a.a(campaignEx.getId(), campaignEx.getTab(), str, campaignEx.getCacheLevel(), campaignEx.getType(), z10)) {
                this.f36285a.a(campaignEx.getId(), str, campaignEx.getCacheLevel(), this.f36286b, z10);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public void a(String str, List<Campaign> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        this.f36285a.a(str, 1, this.f36286b, false);
        this.f36285a.a(str, 2, this.f36286b, false);
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx = (CampaignEx) list.get(i11);
            campaignEx.setCacheLevel(1);
            this.f36285a.a(campaignEx, str, 1);
        }
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public void a(String str, List<Campaign> list, String str2) {
        boolean z10 = !TextUtils.isEmpty(str2);
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        this.f36285a.a(str, 1, this.f36286b, z10);
        this.f36285a.a(str, 2, this.f36286b, z10);
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new RunnableC0508a(list, str));
    }

    public void a(List<CampaignEx> list, String str) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx = list.get(i11);
            campaignEx.setCacheLevel(2);
            this.f36285a.a(campaignEx, str, 1);
        }
    }

    public boolean a(List<CampaignEx> list, int i11) {
        if (list != null && list.size() > 0) {
            if (System.currentTimeMillis() - list.get(0).getTimestamp() > (i11 != 1 ? i11 != 2 ? 0L : b() : a())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public List<Campaign> b(String str, int i11) {
        List<CampaignEx> a11 = this.f36285a.a(str, i11, 2, this.f36286b);
        if (a11 == null) {
            return null;
        }
        if (a(a11, 2)) {
            this.f36285a.a(str, 2, this.f36286b);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a11);
        return arrayList;
    }
}
