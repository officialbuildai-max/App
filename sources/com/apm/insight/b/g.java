package com.apm.insight.b;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.apm.insight.runtime.p;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.Settings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: r, reason: collision with root package name */
    private static int f19454r = 2;

    /* renamed from: a, reason: collision with root package name */
    private c f19455a;

    /* renamed from: b, reason: collision with root package name */
    private int f19456b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f19457c;

    /* renamed from: d, reason: collision with root package name */
    private int f19458d;

    /* renamed from: e, reason: collision with root package name */
    private int f19459e;

    /* renamed from: f, reason: collision with root package name */
    private f f19460f;

    /* renamed from: g, reason: collision with root package name */
    private long f19461g;

    /* renamed from: h, reason: collision with root package name */
    private long f19462h;

    /* renamed from: i, reason: collision with root package name */
    private int f19463i;

    /* renamed from: j, reason: collision with root package name */
    private long f19464j;

    /* renamed from: k, reason: collision with root package name */
    private String f19465k;

    /* renamed from: l, reason: collision with root package name */
    private String f19466l;

    /* renamed from: m, reason: collision with root package name */
    private com.apm.insight.b.e f19467m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f19468n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f19469o;

    /* renamed from: p, reason: collision with root package name */
    private final p f19470p;

    /* renamed from: q, reason: collision with root package name */
    private volatile boolean f19471q;

    /* renamed from: s, reason: collision with root package name */
    private Runnable f19472s;

    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        long f19481a;

        /* renamed from: b, reason: collision with root package name */
        long f19482b;

        /* renamed from: c, reason: collision with root package name */
        long f19483c;

        /* renamed from: d, reason: collision with root package name */
        boolean f19484d;

        /* renamed from: e, reason: collision with root package name */
        int f19485e;

        /* renamed from: f, reason: collision with root package name */
        StackTraceElement[] f19486f;

        private a() {
        }

        /* synthetic */ a(byte b11) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        a f19487a;

        /* renamed from: b, reason: collision with root package name */
        private int f19488b;

        final void a(a aVar) {
            throw null;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
    }

    /* loaded from: classes2.dex */
    public static class d {
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public long f19489a;

        /* renamed from: b, reason: collision with root package name */
        long f19490b;

        /* renamed from: c, reason: collision with root package name */
        long f19491c;

        /* renamed from: d, reason: collision with root package name */
        int f19492d;

        /* renamed from: e, reason: collision with root package name */
        int f19493e;

        /* renamed from: f, reason: collision with root package name */
        long f19494f;

        /* renamed from: g, reason: collision with root package name */
        long f19495g;

        /* renamed from: h, reason: collision with root package name */
        String f19496h;

        /* renamed from: i, reason: collision with root package name */
        public String f19497i;

        /* renamed from: j, reason: collision with root package name */
        private String f19498j;

        /* renamed from: k, reason: collision with root package name */
        private d f19499k;

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, g.a(this.f19496h));
                jSONObject.put("cpuDuration", this.f19495g);
                jSONObject.put("duration", this.f19494f);
                jSONObject.put(NativeComponentConstants.KEY_COMPONENT_TYPE, this.f19492d);
                jSONObject.put("count", this.f19493e);
                jSONObject.put("messageCount", this.f19493e);
                jSONObject.put("lastDuration", this.f19490b - this.f19491c);
                jSONObject.put("start", this.f19489a);
                jSONObject.put(TtmlNode.END, this.f19490b);
                jSONObject.put("block_uuid", (Object) null);
                jSONObject.put("sblock_uuid", (Object) null);
                jSONObject.put("belong_frame", false);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        final void b() {
            this.f19492d = -1;
            this.f19493e = -1;
            this.f19494f = -1L;
            this.f19496h = null;
            this.f19498j = null;
            this.f19499k = null;
            this.f19497i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private int f19500a;

        /* renamed from: b, reason: collision with root package name */
        private int f19501b;

        /* renamed from: c, reason: collision with root package name */
        private e f19502c;

        /* renamed from: d, reason: collision with root package name */
        private List<e> f19503d = new ArrayList();

        f(int i11) {
            this.f19500a = i11;
        }

        final e a(int i11) {
            e eVar = this.f19502c;
            if (eVar != null) {
                eVar.f19492d = i11;
                this.f19502c = null;
                return eVar;
            }
            e eVar2 = new e();
            eVar2.f19492d = i11;
            return eVar2;
        }

        final List<e> a() {
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            if (this.f19503d.size() == this.f19500a) {
                for (int i12 = this.f19501b; i12 < this.f19503d.size(); i12++) {
                    arrayList.add(this.f19503d.get(i12));
                }
                while (i11 < this.f19501b - 1) {
                    arrayList.add(this.f19503d.get(i11));
                    i11++;
                }
            } else {
                while (i11 < this.f19503d.size()) {
                    arrayList.add(this.f19503d.get(i11));
                    i11++;
                }
            }
            return arrayList;
        }

        final void a(e eVar) {
            int size = this.f19503d.size();
            int i11 = this.f19500a;
            if (size < i11) {
                this.f19503d.add(eVar);
                this.f19501b = this.f19503d.size();
                return;
            }
            int i12 = this.f19501b % i11;
            this.f19501b = i12;
            e eVar2 = this.f19503d.set(i12, eVar);
            eVar2.b();
            this.f19502c = eVar2;
            this.f19501b++;
        }
    }

    public g() {
        this((byte) 0);
    }

    private g(byte b11) {
        this.f19456b = 0;
        this.f19457c = 0;
        this.f19458d = 100;
        this.f19459e = 200;
        this.f19461g = -1L;
        this.f19462h = -1L;
        this.f19463i = -1;
        this.f19464j = -1L;
        this.f19468n = false;
        this.f19469o = false;
        this.f19471q = false;
        this.f19472s = new Runnable() { // from class: com.apm.insight.b.g.2

            /* renamed from: b, reason: collision with root package name */
            private long f19475b;

            /* renamed from: a, reason: collision with root package name */
            private long f19474a = 0;

            /* renamed from: c, reason: collision with root package name */
            private int f19476c = -1;

            /* renamed from: d, reason: collision with root package name */
            private int f19477d = 0;

            /* renamed from: e, reason: collision with root package name */
            private int f19478e = 0;

            @Override // java.lang.Runnable
            public final void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (g.c().f19487a != null) {
                    throw null;
                }
                a aVar = new a((byte) 0);
                if (this.f19476c == g.this.f19457c) {
                    this.f19477d++;
                } else {
                    this.f19477d = 0;
                    this.f19478e = 0;
                    this.f19475b = uptimeMillis;
                }
                this.f19476c = g.this.f19457c;
                int i11 = this.f19477d;
                if (i11 > 0 && i11 - this.f19478e >= g.f19454r && this.f19474a != 0 && uptimeMillis - this.f19475b > 700 && g.this.f19471q) {
                    aVar.f19486f = Looper.getMainLooper().getThread().getStackTrace();
                    this.f19478e = this.f19477d;
                }
                aVar.f19484d = g.this.f19471q;
                aVar.f19483c = (uptimeMillis - this.f19474a) - 300;
                aVar.f19481a = uptimeMillis;
                long uptimeMillis2 = SystemClock.uptimeMillis();
                this.f19474a = uptimeMillis2;
                aVar.f19482b = uptimeMillis2 - uptimeMillis;
                aVar.f19485e = g.this.f19457c;
                g.e().a(g.this.f19472s, 300L);
                g.c().a(aVar);
            }
        };
        this.f19455a = new c() { // from class: com.apm.insight.b.g.1
        };
        this.f19470p = null;
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "unknown message";
        }
        try {
            String[] split = str.split(":");
            String str3 = split.length == 2 ? split[1] : "";
            if (str.contains("{") && str.contains("}")) {
                str2 = str.split("\\{")[0];
                try {
                    str = str2 + str.split("\\}")[1];
                } catch (Throwable unused) {
                    return str2;
                }
            } else {
                str2 = str;
            }
            if (str.contains("@")) {
                String[] split2 = str.split("@");
                if (split2.length > 1) {
                    str = split2[0];
                }
            }
            if (str.contains("(") && str.contains(")") && !str.endsWith(" null")) {
                String[] split3 = str.split("\\(");
                if (split3.length > 1) {
                    str = split3[1];
                }
                str = str.replace(")", "");
            }
            if (str.startsWith(" ")) {
                str = str.replace(" ", "");
            }
            return str + str3;
        } catch (Throwable unused2) {
            return str;
        }
    }

    private void a(int i11, long j11, String str) {
        a(i11, j11, str, true);
    }

    private void a(int i11, long j11, String str, boolean z10) {
        this.f19469o = true;
        e a11 = this.f19460f.a(i11);
        a11.f19494f = j11 - this.f19461g;
        if (z10) {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            a11.f19495g = currentThreadTimeMillis - this.f19464j;
            this.f19464j = currentThreadTimeMillis;
        } else {
            a11.f19495g = -1L;
        }
        a11.f19493e = this.f19456b;
        a11.f19496h = str;
        a11.f19497i = this.f19465k;
        a11.f19489a = this.f19461g;
        a11.f19490b = j11;
        a11.f19491c = this.f19462h;
        this.f19460f.a(a11);
        this.f19456b = 0;
        this.f19461g = j11;
    }

    static /* synthetic */ void a(g gVar, boolean z10, long j11) {
        int i11 = gVar.f19457c + 1;
        gVar.f19457c = i11;
        gVar.f19457c = i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        gVar.f19469o = false;
        if (gVar.f19461g < 0) {
            gVar.f19461g = j11;
        }
        if (gVar.f19462h < 0) {
            gVar.f19462h = j11;
        }
        if (gVar.f19463i < 0) {
            gVar.f19463i = Process.myTid();
            gVar.f19464j = SystemClock.currentThreadTimeMillis();
        }
        long j12 = j11 - gVar.f19461g;
        int i12 = gVar.f19459e;
        if (j12 > i12) {
            long j13 = gVar.f19462h;
            if (j11 - j13 <= i12) {
                gVar.a(9, j11, gVar.f19466l);
            } else if (z10) {
                if (gVar.f19456b == 0) {
                    gVar.a(1, j11, "no message running");
                } else {
                    gVar.a(9, j13, gVar.f19465k);
                    gVar.a(1, j11, "no message running", false);
                }
            } else if (gVar.f19456b == 0) {
                gVar.a(8, j11, gVar.f19466l, true);
            } else {
                gVar.a(9, j13, gVar.f19465k, false);
                gVar.a(8, j11, gVar.f19466l, true);
            }
        }
        gVar.f19462h = j11;
    }

    static /* synthetic */ b c() {
        return null;
    }

    static /* synthetic */ int d(g gVar) {
        int i11 = gVar.f19456b;
        gVar.f19456b = i11 + 1;
        return i11;
    }

    static /* synthetic */ p e() {
        return null;
    }

    public final e a(long j11) {
        e eVar = new e();
        eVar.f19496h = this.f19466l;
        eVar.f19497i = this.f19465k;
        eVar.f19494f = j11 - this.f19462h;
        eVar.f19495g = 0 - this.f19464j;
        eVar.f19493e = this.f19456b;
        return eVar;
    }

    public final void a() {
        if (this.f19468n) {
            return;
        }
        this.f19468n = true;
        this.f19458d = 100;
        this.f19459e = 300;
        this.f19460f = new f(100);
        this.f19467m = new com.apm.insight.b.e() { // from class: com.apm.insight.b.g.3
            @Override // com.apm.insight.b.e
            public final void a(String str) {
                g.this.f19471q = true;
                g.this.f19466l = str;
                super.a(str);
                g.a(g.this, true, com.apm.insight.b.e.f19448a);
            }

            @Override // com.apm.insight.b.e
            public final boolean a() {
                return true;
            }

            @Override // com.apm.insight.b.e
            public final void b(String str) {
                super.b(str);
                g.d(g.this);
                g.a(g.this, false, com.apm.insight.b.e.f19448a);
                g gVar = g.this;
                gVar.f19465k = gVar.f19466l;
                g.this.f19466l = "no message running";
                g.this.f19471q = false;
            }
        };
        h.a();
        h.a(this.f19467m);
        j.a(j.a());
    }

    public final JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            int i11 = 0;
            for (e eVar : this.f19460f.a()) {
                if (eVar != null) {
                    i11++;
                    jSONArray.put(eVar.a().put("id", i11));
                }
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }
}
