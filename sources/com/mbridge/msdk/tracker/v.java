package com.mbridge.msdk.tracker;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.tracker.network.t;
import com.mbridge.msdk.tracker.network.v;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class v<T> extends com.mbridge.msdk.tracker.network.t<T> {
    private com.mbridge.msdk.tracker.network.e A;

    /* renamed from: w, reason: collision with root package name */
    private Map<String, String> f38790w;

    /* renamed from: x, reason: collision with root package name */
    private t.a f38791x;

    /* renamed from: y, reason: collision with root package name */
    private v.b<T> f38792y;

    /* renamed from: z, reason: collision with root package name */
    private w f38793z;

    public v(String str, int i11) {
        super(i11, str);
    }

    public v(String str, int i11, int i12) {
        super(i11, str, i12);
    }

    public v.b<T> C() {
        return this.f38792y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    public com.mbridge.msdk.tracker.network.v<T> a(com.mbridge.msdk.tracker.network.q qVar) {
        return this.f38793z.a(qVar);
    }

    public void a(t.a aVar) {
        this.f38791x = aVar;
    }

    public void a(v.b<T> bVar) {
        this.f38792y = bVar;
    }

    public void a(w wVar) {
        this.f38793z = wVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    public void a(T t11) {
        v.b<T> C = C();
        this.f38792y = C;
        if (C != null) {
            C.a(t11);
        }
    }

    public void a(Map<String, String> map) {
        this.f38790w = map;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public boolean a() {
        return false;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        hashMap.put("Charset", "UTF-8");
        return hashMap;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    protected Map<String, String> i() {
        return this.f38790w;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public t.a l() {
        return this.f38791x;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public com.mbridge.msdk.tracker.network.x o() {
        if (y.b(this.A)) {
            this.A = new com.mbridge.msdk.tracker.network.e(30000, 0);
        }
        return this.A;
    }
}
