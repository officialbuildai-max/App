package com.mbridge.msdk.videocommon;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39910a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39911b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39912c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39913d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39914e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39915f = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39916g = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39917h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39918i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0573a> f39919j = new ConcurrentHashMap<>();

    /* renamed from: com.mbridge.msdk.videocommon.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0573a {

        /* renamed from: a, reason: collision with root package name */
        private WindVaneWebView f39920a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f39921b;

        public String a() {
            WindVaneWebView windVaneWebView = this.f39920a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        public void a(WindVaneWebView windVaneWebView) {
            this.f39920a = windVaneWebView;
        }

        public void a(String str) {
            WindVaneWebView windVaneWebView = this.f39920a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public void a(boolean z10) {
            this.f39921b = z10;
        }

        public WindVaneWebView b() {
            return this.f39920a;
        }

        public boolean c() {
            return this.f39921b;
        }
    }

    public static C0573a a(int i11, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i11 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i11 != 94) {
                if (i11 != 287) {
                    if (i11 != 288) {
                        ConcurrentHashMap<String, C0573a> concurrentHashMap = f39910a;
                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                            return f39910a.get(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0573a> concurrentHashMap2 = f39913d;
                        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                            return f39913d.get(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0573a> concurrentHashMap3 = f39912c;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return f39912c.get(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0573a> concurrentHashMap4 = f39915f;
                    if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                        return f39915f.get(requestIdNotice);
                    }
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0573a> concurrentHashMap5 = f39911b;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return f39911b.get(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C0573a> concurrentHashMap6 = f39914e;
                if (concurrentHashMap6 != null && concurrentHashMap6.size() > 0) {
                    return f39914e.get(requestIdNotice);
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public static void a() {
        f39918i.clear();
        f39919j.clear();
    }

    public static void a(int i11, String str, C0573a c0573a) {
        try {
            if (i11 == 94) {
                if (f39911b == null) {
                    f39911b = new ConcurrentHashMap<>();
                }
                f39911b.put(str, c0573a);
            } else {
                if (i11 != 287) {
                    return;
                }
                if (f39912c == null) {
                    f39912c = new ConcurrentHashMap<>();
                }
                f39912c.put(str, c0573a);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            f39916g.clear();
        } else {
            for (String str2 : f39916g.keySet()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    f39916g.remove(str2);
                }
            }
        }
        f39917h.clear();
    }

    public static void a(String str, C0573a c0573a, boolean z10, boolean z11) {
        if (z10) {
            if (z11) {
                f39917h.put(str, c0573a);
                return;
            } else {
                f39916g.put(str, c0573a);
                return;
            }
        }
        if (z11) {
            f39919j.put(str, c0573a);
        } else {
            f39918i.put(str, c0573a);
        }
    }

    public static C0573a b(String str) {
        if (f39916g.containsKey(str)) {
            return f39916g.get(str);
        }
        if (f39917h.containsKey(str)) {
            return f39917h.get(str);
        }
        if (f39918i.containsKey(str)) {
            return f39918i.get(str);
        }
        if (f39919j.containsKey(str)) {
            return f39919j.get(str);
        }
        return null;
    }

    public static void b(int i11, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i11 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i11 == 94) {
                if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0573a> concurrentHashMap = f39911b;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0573a> concurrentHashMap2 = f39914e;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.remove(requestIdNotice);
                    return;
                }
                return;
            }
            if (i11 != 287) {
                if (i11 != 288) {
                    ConcurrentHashMap<String, C0573a> concurrentHashMap3 = f39910a;
                    if (concurrentHashMap3 != null) {
                        concurrentHashMap3.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0573a> concurrentHashMap4 = f39913d;
                if (concurrentHashMap4 != null) {
                    concurrentHashMap4.remove(requestIdNotice);
                    return;
                }
                return;
            }
            if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0573a> concurrentHashMap5 = f39912c;
                if (concurrentHashMap5 != null) {
                    concurrentHashMap5.remove(requestIdNotice);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, C0573a> concurrentHashMap6 = f39915f;
            if (concurrentHashMap6 != null) {
                concurrentHashMap6.remove(requestIdNotice);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public static void b(int i11, String str, C0573a c0573a) {
        try {
            if (i11 == 94) {
                if (f39914e == null) {
                    f39914e = new ConcurrentHashMap<>();
                }
                f39914e.put(str, c0573a);
            } else if (i11 == 287) {
                if (f39915f == null) {
                    f39915f = new ConcurrentHashMap<>();
                }
                f39915f.put(str, c0573a);
            } else if (i11 != 288) {
                if (f39910a == null) {
                    f39910a = new ConcurrentHashMap<>();
                }
                f39910a.put(str, c0573a);
            } else {
                if (f39913d == null) {
                    f39913d = new ConcurrentHashMap<>();
                }
                f39913d.put(str, c0573a);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public static void c(String str) {
        for (Map.Entry<String, C0573a> entry : f39916g.entrySet()) {
            if (entry.getKey().contains(str)) {
                f39916g.remove(entry.getKey());
            }
        }
    }

    public static void d(String str) {
        for (Map.Entry<String, C0573a> entry : f39917h.entrySet()) {
            if (entry.getKey().contains(str)) {
                f39917h.remove(entry.getKey());
            }
        }
    }

    public static void e(String str) {
        if (f39916g.containsKey(str)) {
            f39916g.remove(str);
        }
        if (f39918i.containsKey(str)) {
            f39918i.remove(str);
        }
        if (f39917h.containsKey(str)) {
            f39917h.remove(str);
        }
        if (f39919j.containsKey(str)) {
            f39919j.remove(str);
        }
    }
}
