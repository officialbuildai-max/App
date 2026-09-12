package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.tracker.x;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class k {

    /* renamed from: o, reason: collision with root package name */
    private static volatile String f38583o = "";

    /* renamed from: a, reason: collision with root package name */
    private final String f38584a;

    /* renamed from: b, reason: collision with root package name */
    private final m f38585b;

    /* renamed from: c, reason: collision with root package name */
    private Context f38586c;

    /* renamed from: d, reason: collision with root package name */
    private x f38587d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f38588e;

    /* renamed from: f, reason: collision with root package name */
    private List<String> f38589f;

    /* renamed from: g, reason: collision with root package name */
    private List<String> f38590g;

    /* renamed from: h, reason: collision with root package name */
    private volatile c f38591h;

    /* renamed from: i, reason: collision with root package name */
    private volatile l f38592i;

    /* renamed from: j, reason: collision with root package name */
    private volatile d f38593j;

    /* renamed from: k, reason: collision with root package name */
    private volatile j f38594k;

    /* renamed from: l, reason: collision with root package name */
    private volatile s f38595l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f38596m = true;

    /* renamed from: n, reason: collision with root package name */
    private volatile o f38597n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, m mVar) {
        this.f38584a = str;
        this.f38585b = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        this.f38586c = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x xVar) {
        this.f38587d = xVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        this.f38588e = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() throws IllegalStateException {
        if (y.b(b())) {
            throw new IllegalStateException("config can not be null");
        }
        if (y.b(f())) {
            throw new IllegalStateException("decorate can not be null");
        }
        if (y.b(r())) {
            throw new IllegalStateException("responseHandler can not be null");
        }
        if (y.b(n()) || y.b(n().b())) {
            throw new IllegalStateException("networkStackConfig or stack can not be null");
        }
        if (TextUtils.isEmpty(n().c())) {
            throw new IllegalStateException("report url is null");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(e eVar) {
        if (y.b(eVar)) {
            return false;
        }
        f fVar = b().f38803j;
        if (y.a(fVar)) {
            try {
                return fVar.a(eVar);
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "event filter apply exception", e11);
                }
            }
        }
        String b11 = eVar.b();
        if (TextUtils.isEmpty(b11)) {
            return false;
        }
        if (this.f38590g != null) {
            try {
                return !r0.contains(b11);
            } catch (Exception e12) {
                if (a.f38550a) {
                    Log.e("TrackManager", "disallowTrackEventNames contains exception", e12);
                }
            }
        }
        List<String> list = this.f38589f;
        if (list != null) {
            try {
                return list.contains(b11);
            } catch (Exception e13) {
                if (a.f38550a) {
                    Log.e("TrackManager", "allowTrackEventNames contains exception", e13);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x b() {
        x xVar = this.f38587d;
        if (xVar != null) {
            return xVar;
        }
        x a11 = new x.b().a();
        this.f38587d = a11;
        return a11;
    }

    Context c() {
        return this.f38586c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        if (y.b(this.f38591h)) {
            synchronized (k.class) {
                try {
                    if (y.b(this.f38591h)) {
                        String t11 = t();
                        this.f38591h = new c(new b(c(), e(), t11), t11);
                    }
                } finally {
                }
            }
        }
        return this.f38591h;
    }

    String e() {
        return TextUtils.isEmpty(v()) ? String.format("track_manager_%s.db", "default") : String.format("track_manager_%s.db", v());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d f() {
        if (y.b(this.f38593j)) {
            this.f38593j = b().f38801h;
        }
        return this.f38593j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l g() {
        if (y.b(this.f38592i)) {
            synchronized (k.class) {
                try {
                    if (y.b(this.f38592i)) {
                        this.f38592i = new q(new g(d(), p()));
                    }
                } finally {
                }
            }
        }
        return this.f38592i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j h() {
        if (y.b(this.f38594k)) {
            synchronized (k.class) {
                try {
                    if (y.b(this.f38594k)) {
                        this.f38594k = new j();
                    }
                } finally {
                }
            }
        }
        return this.f38594k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        if (b().f38794a < 0) {
            return 50;
        }
        return b().f38794a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return Math.max(b().f38798e, 0);
    }

    int k() {
        if (b().f38797d <= 0) {
            return 2;
        }
        return b().f38797d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return Math.max(b().f38795b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o m() {
        if (y.b(this.f38597n)) {
            synchronized (k.class) {
                try {
                    if (y.b(this.f38597n)) {
                        this.f38597n = new o(k(), n(), r(), q());
                    }
                } finally {
                }
            }
        }
        return this.f38597n;
    }

    p n() {
        return b().f38800g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject o() {
        JSONObject jSONObject = this.f38588e;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f38588e = jSONObject2;
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s p() {
        if (y.b(this.f38595l)) {
            synchronized (k.class) {
                try {
                    if (y.b(this.f38595l)) {
                        this.f38595l = new s(this);
                    }
                } finally {
                }
            }
        }
        return this.f38595l;
    }

    int q() {
        return b().f38796c;
    }

    w r() {
        return b().f38802i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String s() {
        if (!TextUtils.isEmpty(f38583o)) {
            return f38583o;
        }
        String uuid = UUID.randomUUID().toString();
        f38583o = uuid;
        return uuid;
    }

    String t() {
        return "event_table";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m u() {
        return this.f38585b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String v() {
        return this.f38584a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f38596m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String x() {
        if (!y.b(this.f38586c) && !y.b(this.f38587d)) {
            try {
                p().j();
                this.f38596m = false;
                if (TextUtils.isEmpty(f38583o)) {
                    f38583o = UUID.randomUUID().toString();
                }
                return f38583o;
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "start error", e11);
                }
                this.f38596m = true;
            }
        }
        return "";
    }
}
