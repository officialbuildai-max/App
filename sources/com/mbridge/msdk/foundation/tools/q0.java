package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f35845a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f35846b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f35847c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f35848d;

    /* renamed from: e, reason: collision with root package name */
    public volatile JSONObject f35849e;

    /* renamed from: f, reason: collision with root package name */
    private String f35850f;

    /* renamed from: g, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, Boolean> f35851g;

    /* renamed from: h, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, Integer> f35852h;

    /* renamed from: i, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, String> f35853i;

    /* renamed from: j, reason: collision with root package name */
    private volatile com.mbridge.msdk.setting.g f35854j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final q0 f35855a = new q0();
    }

    private q0() {
        this.f35845a = new Object();
        this.f35846b = new Object();
        this.f35847c = new Object();
        this.f35848d = new Object();
    }

    private int a(String str, int i11) {
        if (a(true)) {
            return i11;
        }
        try {
            return this.f35849e.optInt(str, i11);
        } catch (Exception unused) {
            return i11;
        }
    }

    private int a(String str, String str2, int i11) {
        if (a(true)) {
            return i11;
        }
        try {
            String optString = this.f35849e.optString(str, "");
            if (TextUtils.isEmpty(optString)) {
                return i11;
            }
            String a11 = i0.a(optString);
            return TextUtils.isEmpty(a11) ? i11 : new JSONObject(a11).optInt(str2, i11);
        } catch (Exception unused) {
            return i11;
        }
    }

    public static q0 a() {
        return b.f35855a;
    }

    private static Boolean a(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private String a(String str, String str2, boolean z10) {
        if (a(z10)) {
            return str2;
        }
        try {
            return this.f35849e.optString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    private boolean a(String str, boolean z10, boolean z11) {
        if (a(z11)) {
            return z10;
        }
        try {
            return this.f35849e.optInt(str, z10 ? 1 : 0) != 0;
        } catch (Exception unused) {
            return z10;
        }
    }

    private boolean a(boolean z10) {
        synchronized (this.f35848d) {
            if (this.f35854j == null || e() || !z10) {
                try {
                    if (TextUtils.isEmpty(this.f35850f)) {
                        String b11 = com.mbridge.msdk.foundation.controller.c.m().b();
                        this.f35850f = b11;
                        if (TextUtils.isEmpty(b11)) {
                            this.f35850f = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("app_id");
                        }
                    }
                    this.f35854j = com.mbridge.msdk.setting.h.b().b(this.f35850f);
                } catch (Exception unused) {
                    this.f35854j = null;
                }
            }
            if (this.f35854j != null) {
                this.f35849e = this.f35854j.j0();
            }
        }
        return this.f35854j == null || this.f35849e == null;
    }

    private static Integer b(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private ConcurrentHashMap<String, Boolean> b() {
        synchronized (this.f35847c) {
            try {
                if (this.f35851g == null) {
                    this.f35851g = new ConcurrentHashMap<>();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f35851g;
    }

    private static String c(String str, ConcurrentHashMap<String, String> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private ConcurrentHashMap<String, Integer> c() {
        synchronized (this.f35845a) {
            try {
                if (this.f35852h == null) {
                    this.f35852h = new ConcurrentHashMap<>();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f35852h;
    }

    private ConcurrentHashMap<String, String> d() {
        synchronized (this.f35846b) {
            try {
                if (this.f35853i == null) {
                    this.f35853i = new ConcurrentHashMap<>();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f35853i;
    }

    private boolean e() {
        return this.f35854j.D() == 1;
    }

    public boolean a(String str, boolean z10) {
        try {
            return b(str, z10, true);
        } catch (Exception unused) {
            return z10;
        }
    }

    public int b(String str, int i11) {
        Integer valueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return i11;
            }
            ConcurrentHashMap<String, Integer> c11 = c();
            Integer b11 = b(str, c11);
            if (b11 != null) {
                return b11.intValue();
            }
            try {
                valueOf = Integer.valueOf(a(str, i11));
            } catch (Exception unused) {
                valueOf = Integer.valueOf(i11);
            }
            c11.put(str, valueOf);
            return valueOf.intValue();
        } catch (Exception unused2) {
            return i11;
        }
    }

    public int b(String str, String str2, int i11) {
        Integer valueOf;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String str3 = str + "_" + str2;
                ConcurrentHashMap<String, Integer> c11 = c();
                Integer b11 = b(str3, c11);
                if (b11 != null) {
                    return b11.intValue();
                }
                try {
                    valueOf = Integer.valueOf(a(str, str2, i11));
                } catch (Exception unused) {
                    valueOf = Integer.valueOf(i11);
                }
                c11.put(str3, valueOf);
                return valueOf.intValue();
            }
            return b(str2, i11);
        } catch (Exception unused2) {
            return i11;
        }
    }

    public String b(String str, String str2, boolean z10) {
        String str3;
        String c11;
        try {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            ConcurrentHashMap<String, String> d11 = d();
            if (z10 && (c11 = c(str, d11)) != null) {
                return c11;
            }
            try {
                str3 = a(str, str2, z10);
            } catch (Exception unused) {
                str3 = str2;
            }
            d11.put(str, str3);
            return str3;
        } catch (Exception unused2) {
            return str2;
        }
    }

    public boolean b(String str, boolean z10, boolean z11) {
        Boolean valueOf;
        Boolean a11;
        try {
            if (TextUtils.isEmpty(str)) {
                return z10;
            }
            ConcurrentHashMap<String, Boolean> b11 = b();
            if (z11 && (a11 = a(str, b11)) != null) {
                return a11.booleanValue();
            }
            try {
                valueOf = Boolean.valueOf(a(str, z10, z11));
            } catch (Exception unused) {
                valueOf = Boolean.valueOf(z10);
            }
            b11.put(str, valueOf);
            return valueOf.booleanValue();
        } catch (Exception unused2) {
            return z10;
        }
    }
}
