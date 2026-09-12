package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class h<T> extends t<T> {
    protected static final String B = "h";
    private boolean A;

    /* renamed from: w, reason: collision with root package name */
    private final long f38632w;

    /* renamed from: x, reason: collision with root package name */
    private Map<String, String> f38633x;

    /* renamed from: y, reason: collision with root package name */
    private Map<String, String> f38634y;

    /* renamed from: z, reason: collision with root package name */
    private x f38635z;

    public h(int i11, String str, int i12, String str2, long j11) {
        super(i11, str, i12, str2);
        this.A = false;
        if (j11 > 0) {
            this.f38632w = j11;
        } else {
            this.f38632w = 60000L;
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (this.f38633x == null) {
            this.f38633x = new HashMap();
        }
        try {
            this.f38633x.putAll(map);
        } catch (Exception e11) {
            o0.b(B, "addParams error: " + e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public boolean a() {
        return this.A && com.mbridge.msdk.foundation.same.d.a(p(), t());
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f38634y == null) {
            this.f38634y = new HashMap();
        }
        try {
            this.f38634y.put(str, str2);
        } catch (Exception e11) {
            o0.b(B, "addHeader error: " + e11.getMessage());
        }
    }

    public void d(boolean z10) {
        this.A = z10;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public Map<String, String> f() {
        if (this.f38634y == null) {
            this.f38634y = new HashMap();
        }
        this.f38634y.put("Charset", "UTF-8");
        return this.f38634y;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    protected Map<String, String> i() {
        if (this.f38633x == null) {
            this.f38633x = new HashMap();
        }
        return this.f38633x;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public x o() {
        if (this.f38635z == null) {
            this.f38635z = new e(30000, this.f38632w, 3);
        }
        return this.f38635z;
    }
}
