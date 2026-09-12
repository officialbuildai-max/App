package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    private static volatile b f39956f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f39957a = false;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, l> f39958b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> f39959c;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f39960d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<a>> f39961e;

    private b() {
    }

    private void a(l lVar, String str) {
        try {
            com.mbridge.msdk.videocommon.setting.c c11 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), str);
            if (c11 == null) {
                return;
            }
            if (c11.l() == 2) {
                lVar.e();
            } else {
                lVar.d();
            }
        } catch (Exception e11) {
            o0.b("DownLoadManager", e11.getMessage());
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.mbridge.msdk.setting.l e12 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), str);
                if (e12 == null) {
                    e12 = com.mbridge.msdk.setting.l.j(str);
                }
                if (e12.q() == 2) {
                    lVar.e();
                } else {
                    lVar.d();
                }
            } catch (Exception e13) {
                o0.b("DownLoadManager", e13.getMessage());
            }
        }
    }

    private void a(String str, CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2, CopyOnWriteArrayList<a> copyOnWriteArrayList3) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList4;
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
            CampaignEx campaignEx = copyOnWriteArrayList2.get(0);
            if (campaignEx.getSecondRequestIndex() == 1 && (concurrentHashMap = this.f39960d) != null && (copyOnWriteArrayList4 = concurrentHashMap.get(str)) != null && copyOnWriteArrayList4.size() > 0 && copyOnWriteArrayList4.get(0).getLocalRequestId().equals(campaignEx.getLocalRequestId())) {
                return;
            }
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> concurrentHashMap2 = this.f39959c;
        if (concurrentHashMap2 == null) {
            this.f39959c = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap2.remove(str);
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap3 = this.f39961e;
        if (concurrentHashMap3 == null) {
            this.f39961e = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap3.remove(str);
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap4 = this.f39960d;
        if (concurrentHashMap4 == null) {
            this.f39960d = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap4.remove(str);
        }
        this.f39959c.put(str, copyOnWriteArrayList);
        this.f39960d.put(str, copyOnWriteArrayList2);
        this.f39961e.put(str, copyOnWriteArrayList3);
    }

    public static b getInstance() {
        if (f39956f == null) {
            synchronized (b.class) {
                try {
                    if (f39956f == null) {
                        f39956f = new b();
                    }
                } finally {
                }
            }
        }
        return f39956f;
    }

    public a a(int i11, String str, boolean z10) {
        l c11 = c(str);
        if (c11 != null) {
            return c11.a(i11, z10);
        }
        return null;
    }

    public a a(String str, String str2) {
        l c11 = c(str);
        if (c11 != null) {
            return c11.a(str2);
        }
        return null;
    }

    public CopyOnWriteArrayList<a> a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.f39961e;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f39961e.get(str);
    }

    public void a() {
        ConcurrentHashMap<String, l> concurrentHashMap = this.f39958b;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, l> entry : concurrentHashMap.entrySet()) {
                a(entry.getValue(), entry.getKey());
            }
        }
    }

    public void a(boolean z10) {
        if (!z10) {
            this.f39957a = false;
        } else if (this.f39957a) {
            return;
        }
        ConcurrentHashMap<String, l> concurrentHashMap = this.f39958b;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, l>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().d();
            }
        }
    }

    public boolean a(int i11, String str, List<CampaignEx> list) {
        l c11 = c(str);
        if (c11 == null) {
            c11 = createUnitCache(com.mbridge.msdk.foundation.controller.c.m().d(), str, (CopyOnWriteArrayList<CampaignEx>) list, i11, (com.mbridge.msdk.videocommon.listener.a) null);
        }
        if (c11 != null) {
            return c11.a(list, str);
        }
        return false;
    }

    public boolean a(int i11, String str, boolean z10, int i12, boolean z11, int i13, List<CampaignEx> list) {
        return a(i11, str, z10, i12, z11, i13, list, false, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0197, code lost:
    
        if (r14.f39959c != null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0199, code lost:
    
        r14.f39959c = new java.util.concurrent.ConcurrentHashMap<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01a2, code lost:
    
        if (r14.f39961e != null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01a4, code lost:
    
        r14.f39961e = new java.util.concurrent.ConcurrentHashMap<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01ad, code lost:
    
        if (r14.f39960d != null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01af, code lost:
    
        r14.f39960d = new java.util.concurrent.ConcurrentHashMap<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01b6, code lost:
    
        if (r2 == null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01bc, code lost:
    
        if (r2.size() <= 0) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01be, code lost:
    
        r3 = new java.util.concurrent.CopyOnWriteArrayList<>();
        r4 = new java.util.concurrent.CopyOnWriteArrayList<>();
        r5 = new java.util.concurrent.CopyOnWriteArrayList<>();
        r2 = r2.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x01d5, code lost:
    
        if (r2.hasNext() == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01d7, code lost:
    
        r6 = r2.next();
        r7 = new java.util.concurrent.ConcurrentHashMap();
        r8 = r6.c();
        r7.put(r8.getId() + r8.getVideoUrlEncode() + r8.getBidToken(), r6);
        r3.add(r7);
        r4.add(r8);
        r5.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0211, code lost:
    
        a(r16, r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0131, code lost:
    
        if (r5.size() >= r18) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r15, java.lang.String r16, boolean r17, int r18, boolean r19, int r20, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r21, boolean r22, com.mbridge.msdk.foundation.same.report.metrics.e r23) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.b.a(int, java.lang.String, boolean, int, boolean, int, java.util.List, boolean, com.mbridge.msdk.foundation.same.report.metrics.e):boolean");
    }

    public int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> c11;
        a value;
        CampaignEx c12;
        ConcurrentHashMap<String, l> concurrentHashMap = this.f39958b;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, l>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                l value2 = it.next().getValue();
                if (value2 != null && (c11 = value2.c()) != null) {
                    int size = c11.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        Map<String, a> map = c11.get(i11);
                        if (map != null) {
                            Iterator<Map.Entry<String, a>> it2 = map.entrySet().iterator();
                            if (it2.hasNext() && (value = it2.next().getValue()) != null && (c12 = value.c()) != null) {
                                String videoUrlEncode = c12.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return value.j();
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public CopyOnWriteArrayList<CampaignEx> b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.f39960d;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f39960d.get(str);
    }

    public void b(boolean z10) {
        this.f39957a = z10;
        ConcurrentHashMap<String, l> concurrentHashMap = this.f39958b;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, l>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                l value = it.next().getValue();
                if (value != null) {
                    value.e();
                }
            }
        }
    }

    public boolean b(int i11, String str, boolean z10) {
        try {
            l c11 = c(str);
            if (c11 != null) {
                return c11.b(i11, z10) != null;
            }
            return false;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e11.printStackTrace();
            return false;
        }
    }

    public l c(String str) {
        ConcurrentHashMap<String, l> concurrentHashMap = this.f39958b;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f39958b.get(str);
    }

    public void c(String str, String str2) {
        l c11 = c(str);
        if (c11 != null) {
            try {
                c11.b(str2);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("DownLoadManager", e11.getMessage());
                }
            }
        }
    }

    public l createUnitCache(Context context, String str, CampaignEx campaignEx, int i11, com.mbridge.msdk.videocommon.listener.a aVar) {
        l lVar;
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.f39958b.containsKey(str)) {
            lVar = this.f39958b.get(str);
            if (lVar == null) {
                lVar = new l(context, campaignEx, str, i11);
                this.f39958b.put(str, lVar);
            }
            if (i11 == 94 || i11 == 287) {
                lVar.a(campaignEx.getRequestId() + "_" + campaignEx.getSecondRequestIndex(), aVar);
            } else {
                lVar.a(aVar);
            }
            lVar.f(campaignEx);
        } else {
            lVar = new l(context, campaignEx, str, i11);
            if (i11 == 94 || i11 == 287) {
                lVar.a(campaignEx.getRequestId() + "_" + campaignEx.getSecondRequestIndex(), aVar);
            } else {
                lVar.a(aVar);
            }
            this.f39958b.put(str, lVar);
        }
        return lVar;
    }

    public l createUnitCache(Context context, String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, int i11, com.mbridge.msdk.videocommon.listener.a aVar) {
        l lVar;
        if (TextUtils.isEmpty(str) || copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return null;
        }
        if (this.f39958b.containsKey(str)) {
            lVar = this.f39958b.get(str);
            if (lVar == null) {
                lVar = new l(context, copyOnWriteArrayList, str, i11);
                this.f39958b.put(str, lVar);
            }
            if (i11 == 94 || i11 == 287) {
                lVar.a(copyOnWriteArrayList.get(0).getRequestId() + "_" + copyOnWriteArrayList.get(0).getSecondRequestIndex(), aVar);
            } else {
                lVar.a(aVar);
            }
            lVar.b(copyOnWriteArrayList);
        } else {
            lVar = new l(context, copyOnWriteArrayList, str, i11);
            if (i11 == 94 || i11 == 287) {
                lVar.a(copyOnWriteArrayList.get(0).getRequestId() + "_" + copyOnWriteArrayList.get(0).getSecondRequestIndex(), aVar);
            } else {
                lVar.a(aVar);
            }
            this.f39958b.put(str, lVar);
        }
        return lVar;
    }

    public void load(String str) {
        l c11 = c(str);
        if (c11 != null) {
            c11.d();
        }
    }
}
