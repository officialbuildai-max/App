package com.mbridge.msdk.advanced.middle;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private NativeAdvancedAdListener f34222a;

    /* renamed from: b, reason: collision with root package name */
    private c f34223b;

    /* renamed from: c, reason: collision with root package name */
    private MBridgeIds f34224c;

    /* renamed from: d, reason: collision with root package name */
    private String f34225d;

    /* renamed from: e, reason: collision with root package name */
    private String f34226e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.f34223b = cVar;
        this.f34224c = mBridgeIds;
        this.f34225d = mBridgeIds.getUnitId();
    }

    public void a(CampaignEx campaignEx, int i11) {
        c cVar;
        o0.b("NativeAdvancedLoadManager", "onLoadSuccessed: " + i11);
        c cVar2 = this.f34223b;
        if (cVar2 == null || !cVar2.g() || campaignEx == null) {
            return;
        }
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f34222a;
        if (nativeAdvancedAdListener != null && this.f34223b != null) {
            nativeAdvancedAdListener.onLoadSuccessed(this.f34224c);
        }
        this.f34223b.a(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        j.a(com.mbridge.msdk.foundation.controller.c.m().d(), arrayList, this.f34225d, campaignEx.isBidCampaign());
        if (i11 != 2 || (cVar = this.f34223b) == null) {
            return;
        }
        cVar.a(campaignEx, true);
    }

    public void a(com.mbridge.msdk.foundation.error.b bVar, int i11) {
        c cVar = this.f34223b;
        if (cVar == null || !cVar.g()) {
            return;
        }
        String str = "";
        if (bVar != null) {
            String g11 = bVar.g();
            if (!TextUtils.isEmpty(g11)) {
                str = g11;
            }
        }
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f34222a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLoadFailed(this.f34224c, str);
        }
        this.f34223b.a(false);
        j.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, this.f34225d, !TextUtils.isEmpty(this.f34226e), bVar != null ? bVar.a() : null);
    }

    public void a(NativeAdvancedAdListener nativeAdvancedAdListener) {
        this.f34222a = nativeAdvancedAdListener;
    }

    public void a(String str) {
        this.f34226e = str;
    }
}
