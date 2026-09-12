package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, m> f38598b = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final k f38599a;

    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                u.a().b();
                m.this.f38599a.p().b();
            } catch (Exception e11) {
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    Log.e("TrackManager", "flush error", e11);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f38601a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f38602b;

        b(e eVar, JSONObject jSONObject) {
            this.f38601a = eVar;
            this.f38602b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                m.this.f38599a.g().a(this.f38601a);
                JSONObject jSONObject = this.f38602b;
                if (jSONObject != null) {
                    jSONObject.put("session_id", m.this.d());
                    long[] e11 = m.this.e();
                    this.f38602b.put("track_time", e11[0]);
                    this.f38602b.put("track_count", e11[1]);
                    this.f38601a.a(this.f38602b);
                }
                this.f38601a.b(m.this.f38599a.b().f38799f);
                m.this.f38599a.g().b(this.f38601a);
            } catch (Exception unused) {
            }
        }
    }

    private m(String str, Context context, x xVar) {
        k kVar = new k(str, this);
        this.f38599a = kVar;
        kVar.a(context);
        kVar.a(xVar);
    }

    public static m a(String str, Context context, x xVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, m> concurrentHashMap = f38598b;
        m mVar = concurrentHashMap.get(str);
        if (!y.b(mVar)) {
            return mVar;
        }
        m mVar2 = new m(str, context, xVar);
        concurrentHashMap.put(str, mVar2);
        return mVar2;
    }

    private boolean b(e eVar) {
        if (y.b(eVar) || TextUtils.isEmpty(eVar.b())) {
            return false;
        }
        return this.f38599a.a(eVar);
    }

    public static m[] b() {
        ConcurrentHashMap<String, m> concurrentHashMap = f38598b;
        m[] mVarArr = new m[concurrentHashMap.size()];
        try {
            Iterator<Map.Entry<String, m>> it = concurrentHashMap.entrySet().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                mVarArr[i11] = it.next().getValue();
                i11++;
            }
        } catch (Exception e11) {
            if (com.mbridge.msdk.tracker.a.f38550a) {
                Log.e("TrackManager", "getAllTrackManager error", e11);
            }
        }
        return mVarArr;
    }

    public void a() {
        try {
            this.f38599a.h().a(new a());
        } catch (Exception e11) {
            if (com.mbridge.msdk.tracker.a.f38550a) {
                Log.e("TrackManager", "flush error", e11);
            }
        }
    }

    public void a(JSONObject jSONObject) {
        this.f38599a.a(jSONObject);
    }

    public boolean a(e eVar) {
        try {
            return b(eVar);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(String str) {
        return a(new e(str));
    }

    public JSONObject c() {
        return this.f38599a.o();
    }

    public void c(e eVar) {
        d(eVar);
    }

    public String d() {
        return this.f38599a.s();
    }

    public void d(e eVar) {
        if (this.f38599a.w()) {
            boolean z10 = com.mbridge.msdk.tracker.a.f38550a;
            return;
        }
        if (eVar != null && b(eVar)) {
            JSONObject d11 = eVar.d();
            if (d11 != null && !d11.has("ts")) {
                try {
                    d11.put("ts", System.currentTimeMillis());
                } catch (Exception e11) {
                    Log.e("TrackManager", "trackEvent error", e11);
                }
            }
            try {
                this.f38599a.h().a(new b(eVar, d11));
            } catch (Exception e12) {
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    Log.e("TrackManager", "trackEvent error", e12);
                }
            }
        }
    }

    public long[] e() {
        return this.f38599a.g().a();
    }

    public String f() {
        return this.f38599a.v();
    }

    public boolean g() {
        return !this.f38599a.w();
    }

    public String h() {
        if (!g()) {
            return this.f38599a.x();
        }
        if (com.mbridge.msdk.tracker.a.f38550a) {
            Log.e("TrackManager", "MBridgeTrackManager is already running");
        }
        return d();
    }
}
