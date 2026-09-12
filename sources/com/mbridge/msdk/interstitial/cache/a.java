package com.mbridge.msdk.interstitial.cache;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f35968b = "com.mbridge.msdk.interstitial.cache.a";

    /* renamed from: c, reason: collision with root package name */
    private static a f35969c;

    /* renamed from: a, reason: collision with root package name */
    private e f35970a;

    private a() {
        try {
            Context d11 = c.m().d();
            if (d11 != null) {
                this.f35970a = e.a(g.a(d11));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f35969c == null) {
                    f35969c = new a();
                }
                aVar = f35969c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public List<CampaignEx> a(String str, int i11) {
        List<CampaignEx> a11;
        ArrayList arrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (a11 = this.f35970a.a(str, i11, 0, 1)) == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                Iterator<CampaignEx> it = a11.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
                return arrayList2;
            } catch (Exception e11) {
                e = e11;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public synchronized void a(long j11, String str) {
        try {
            if (this.f35970a != null && j11 != 0 && !TextUtils.isEmpty(str)) {
                this.f35970a.a(j11, str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            o0.b(f35968b, e11.getMessage());
        }
    }

    public void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f35970a.e(campaignEx.getId(), str);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void a(String str, List<CampaignEx> list) {
        try {
            if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
                return;
            }
            Iterator<CampaignEx> it = list.iterator();
            while (it.hasNext()) {
                b(it.next(), str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(List<CampaignEx> list, String str) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<CampaignEx> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), str);
        }
    }

    public void b(CampaignEx campaignEx, String str) {
        try {
            if (this.f35970a == null || campaignEx == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f35970a.a(campaignEx, str, 0);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
