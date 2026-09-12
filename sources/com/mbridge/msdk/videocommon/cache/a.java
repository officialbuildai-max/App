package com.mbridge.msdk.videocommon.cache;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.videocommon.setting.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f39922b = "com.mbridge.msdk.videocommon.cache.a";

    /* renamed from: c, reason: collision with root package name */
    private static a f39923c;

    /* renamed from: a, reason: collision with root package name */
    private e f39924a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.videocommon.cache.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0574a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f39925a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f39926b;

        RunnableC0574a(String str, CampaignEx campaignEx) {
            this.f39925a = str;
            this.f39926b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f39925a, this.f39926b);
        }
    }

    private a() {
        try {
            Context d11 = c.m().d();
            if (d11 != null) {
                this.f39924a = e.a(g.a(d11));
            } else {
                o0.b(f39922b, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static a a() {
        if (f39923c == null) {
            synchronized (a.class) {
                try {
                    if (f39923c == null) {
                        f39923c = new a();
                    }
                } finally {
                }
            }
        }
        return f39923c;
    }

    public int a(String str, int i11, boolean z10, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            List<CampaignEx> a11 = z10 ? this.f39924a.a(str, 0, 0, i11, str2) : this.f39924a.a(str, 0, 0, i11, false);
            if (a11 == null) {
                return 0;
            }
            for (CampaignEx campaignEx : a11) {
                if (campaignEx != null && campaignEx.getReadyState() == 0) {
                    arrayList.add(campaignEx);
                }
            }
            return arrayList.size();
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public List<com.mbridge.msdk.foundation.entity.c> a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.f39924a.d(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return null;
    }

    public List<CampaignEx> a(String str, int i11, boolean z10) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f39924a.a(str, 0, 0, i11, z10);
        } catch (Exception e11) {
            o0.b(f39922b, e11.getLocalizedMessage());
            return null;
        }
    }

    public List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.setting.a c11 = b.b().c();
            long e11 = c11 != null ? c11.e() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            if (list.size() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx campaignEx : list) {
                    if (campaignEx != null) {
                        long plct = campaignEx.getPlct() * 1000;
                        long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                        if ((plct > 0 && plct >= timestamp) || (plct <= 0 && e11 >= timestamp)) {
                            arrayList2.add(campaignEx);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e12) {
                e = e12;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e13) {
            e = e13;
        }
    }

    public synchronized void a(long j11, String str) {
        try {
            this.f39924a.b(j11, str);
        } catch (Exception e11) {
            e11.printStackTrace();
            o0.b(f39922b, e11.getMessage());
        }
    }

    public void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getId())) {
                    return;
                }
                this.f39924a.d(campaignEx.getId(), campaignEx.getRequestId());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (campaignEx.isBidCampaign()) {
                    com.mbridge.msdk.foundation.same.buffer.b.c(str, campaignEx.getRequestId());
                }
                String localRequestId = campaignEx.getLocalRequestId();
                if (TextUtils.isEmpty(localRequestId)) {
                    this.f39924a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                    return;
                }
                boolean z10 = true;
                if (campaignEx.getSecondRequestIndex() != 1 && !localRequestId.contains("label_second")) {
                    z10 = false;
                }
                if (localRequestId.contains("label_second")) {
                    localRequestId = localRequestId.replace("label_second", "");
                }
                if (!z10) {
                    this.f39924a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                    return;
                }
                this.f39924a.a(str, localRequestId, localRequestId + "label_second");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void a(String str, int i11) {
        int size;
        try {
            List<com.mbridge.msdk.foundation.entity.c> d11 = this.f39924a.d(str);
            if (d11 == null || d11.size() <= 0 || (size = d11.size() - i11) <= 0) {
                return;
            }
            for (int i12 = 0; i12 < size; i12++) {
                d(str, d11.get(i12).a());
                com.mbridge.msdk.foundation.same.buffer.b.c(str, d11.get(i12).a());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(String str, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String localRequestId = campaignEx.getLocalRequestId();
                if (TextUtils.isEmpty(localRequestId)) {
                    this.f39924a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                    return;
                }
                boolean z10 = true;
                if (campaignEx.getSecondRequestIndex() != 1 && !localRequestId.contains("label_second")) {
                    z10 = false;
                }
                if (localRequestId.contains("label_second")) {
                    localRequestId = localRequestId.replace("label_second", "");
                }
                if (!z10) {
                    this.f39924a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                    return;
                }
                this.f39924a.a(str, localRequestId, localRequestId + "label_second");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                List<com.mbridge.msdk.foundation.entity.c> d11 = this.f39924a.d(str);
                if (str2.contains("label_second")) {
                    String replace = str2.replace("label_second", "");
                    if (d11 != null && !d11.isEmpty() && !TextUtils.isEmpty(replace)) {
                        for (com.mbridge.msdk.foundation.entity.c cVar : d11) {
                            if (replace.equals(cVar.d())) {
                                d(str, cVar.a());
                                com.mbridge.msdk.foundation.same.buffer.b.c(str, cVar.a());
                                break;
                            }
                        }
                    }
                } else {
                    String str3 = str2 + "label_second";
                    if (d11 != null && !d11.isEmpty() && !TextUtils.isEmpty(str3)) {
                        Iterator<com.mbridge.msdk.foundation.entity.c> it = d11.iterator();
                        while (it.hasNext()) {
                            if (str3.equals(it.next().d())) {
                                for (com.mbridge.msdk.foundation.entity.c cVar2 : d11) {
                                    if (str2.equals(cVar2.d())) {
                                        d(str, cVar2.a());
                                        com.mbridge.msdk.foundation.same.buffer.b.c(str, cVar2.a());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            o0.b("videoCache", e11.getMessage());
        }
    }

    public void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (TextUtils.isEmpty(str2) || list == null || list.size() <= 0) {
                return;
            }
            this.f39924a.a(list, str, str2, 0);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(String str, List<CampaignEx> list) {
        e eVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (eVar = this.f39924a) == null) {
            return;
        }
        eVar.b(str, list);
    }

    public void a(String str, List<CampaignEx> list, String str2) {
        e eVar;
        try {
            if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (eVar = this.f39924a) == null) {
                return;
            }
            eVar.a(str, list, str2);
        } catch (Exception e11) {
            o0.b(f39922b, e11.getMessage());
        }
    }

    public void a(String str, List<CampaignEx> list, String str2, int i11) {
        e eVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || TextUtils.isEmpty(str2) || (eVar = this.f39924a) == null) {
            return;
        }
        eVar.a(str, list, str2, i11);
    }

    public List<CampaignEx> b(String str, int i11, boolean z10) {
        return b(str, i11, z10, "");
    }

    public CopyOnWriteArrayList<CampaignEx> b(String str, int i11, boolean z10, String str2) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            com.mbridge.msdk.videocommon.setting.a c11 = b.b().c();
            long e11 = c11 != null ? c11.e() : 0L;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            List<CampaignEx> a11 = z10 ? this.f39924a.a(str, 0, 0, i11, str2) : this.f39924a.a(str, 0, 0, i11, false);
            long currentTimeMillis = System.currentTimeMillis();
            if (a11 == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx campaignEx : a11) {
                    if (campaignEx != null) {
                        if (campaignEx.getReadyState() != 0 && campaignEx.getLoadTimeoutState() != 1) {
                        }
                        long plct = campaignEx.getPlct() * 1000;
                        long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                        if ((plct > 0 && plct >= timestamp) || (plct <= 0 && e11 >= timestamp)) {
                            copyOnWriteArrayList2.add(campaignEx);
                        }
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e12) {
                e = e12;
                copyOnWriteArrayList = copyOnWriteArrayList2;
                e.printStackTrace();
                return copyOnWriteArrayList;
            }
        } catch (Exception e13) {
            e = e13;
        }
    }

    public void b(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> f11;
        try {
            if (TextUtils.isEmpty(str) || (f11 = this.f39924a.f(str)) == null || f11.size() <= 0) {
                return;
            }
            com.mbridge.msdk.setting.g d11 = h.b().d(c.m().b());
            if (d11 == null) {
                d11 = h.b().a();
            }
            long a02 = d11 != null ? d11.a0() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            for (com.mbridge.msdk.foundation.entity.c cVar : f11.values()) {
                if (cVar != null) {
                    long e11 = cVar.e();
                    if (e11 <= 0) {
                        e11 = a02;
                    }
                    if (cVar.f() + (e11 * 1000) < currentTimeMillis && !TextUtils.isEmpty(cVar.a())) {
                        o0.b("HBOPTIMIZE", "不在有效期范围内 删除" + cVar.a());
                        d(str, cVar.a());
                    }
                }
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public synchronized void b(String str, int i11) {
        int f11;
        try {
            try {
                com.mbridge.msdk.setting.g d11 = h.b().d(c.m().b());
                if (d11 == null) {
                    d11 = h.b().a();
                }
                f11 = d11.f();
            } catch (Exception e11) {
                o0.b(f39922b, e11.getMessage());
            }
            if (f11 == 0) {
                return;
            }
            List<CampaignEx> b11 = this.f39924a.b(str, i11, f11 == 2);
            if (b11 != null && b11.size() > 0) {
                for (CampaignEx campaignEx : b11) {
                    String requestIdNotice = campaignEx.getRequestIdNotice();
                    String id2 = campaignEx.getId();
                    com.mbridge.msdk.videocommon.a.e(campaignEx.getCampaignUnitId() + "_" + id2 + "_" + requestIdNotice + "_" + campaignEx.getCMPTEntryUrl());
                }
            }
            this.f39924a.a(str, i11, f11 == 2);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void b(String str, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new RunnableC0574a(str, campaignEx));
    }

    public void b(String str, String str2) {
        if (this.f39924a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f39924a.a(str, str2);
    }

    public List<CampaignEx> c(String str, int i11, boolean z10) {
        return c(str, i11, z10, "");
    }

    public List<CampaignEx> c(String str, int i11, boolean z10, String str2) {
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.setting.g d11 = h.b().d(c.m().b());
            long a02 = (d11 != null ? d11.a0() : h.b().a().a0()) * 1000;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            List<CampaignEx> a11 = z10 ? this.f39924a.a(str, 0, 0, i11, str2) : this.f39924a.a(str, 0, 0, i11, false);
            long currentTimeMillis = System.currentTimeMillis();
            if (a11 == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx campaignEx : a11) {
                    if (campaignEx != null && campaignEx.getReadyState() == 0) {
                        long plctb = campaignEx.getPlctb() * 1000;
                        long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                        if ((plctb <= 0 && a02 >= timestamp) || (plctb > 0 && plctb >= timestamp)) {
                            arrayList2.add(campaignEx);
                        }
                    }
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

    public CopyOnWriteArrayList<CampaignEx> c(String str, int i11) {
        List<CampaignEx> a11;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (a11 = this.f39924a.a(str, 0, 0, i11)) == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx campaignEx : a11) {
                    if (campaignEx != null) {
                        copyOnWriteArrayList2.add(campaignEx);
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e11) {
                e = e11;
                copyOnWriteArrayList = copyOnWriteArrayList2;
                e.printStackTrace();
                return copyOnWriteArrayList;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public void c(String str, String str2) {
        e eVar = this.f39924a;
        if (eVar != null) {
            eVar.c(str, str2);
        }
    }

    public synchronized void d(String str, String str2) {
        try {
            this.f39924a.f(str2, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
