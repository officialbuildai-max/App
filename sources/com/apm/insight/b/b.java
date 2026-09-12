package com.apm.insight.b;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.Npth;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.l;
import com.apm.insight.runtime.n;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: z, reason: collision with root package name */
    private static volatile boolean f19407z = true;

    /* renamed from: a, reason: collision with root package name */
    private c f19408a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f19409b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f19410c;

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f19414g;

    /* renamed from: h, reason: collision with root package name */
    private JSONObject f19415h;

    /* renamed from: m, reason: collision with root package name */
    private JSONArray f19420m;

    /* renamed from: n, reason: collision with root package name */
    private JSONObject f19421n;

    /* renamed from: q, reason: collision with root package name */
    private JSONArray f19424q;

    /* renamed from: r, reason: collision with root package name */
    private JSONArray f19425r;

    /* renamed from: s, reason: collision with root package name */
    private JSONObject f19426s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f19427t;

    /* renamed from: v, reason: collision with root package name */
    private volatile boolean f19429v;

    /* renamed from: d, reason: collision with root package name */
    private long f19411d = -1;

    /* renamed from: e, reason: collision with root package name */
    private File f19412e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f19413f = true;

    /* renamed from: i, reason: collision with root package name */
    private String f19416i = TmcConstants.ROUTE_UNKNOWN;

    /* renamed from: j, reason: collision with root package name */
    private String f19417j = TmcConstants.ROUTE_UNKNOWN;

    /* renamed from: k, reason: collision with root package name */
    private String f19418k = TmcConstants.ROUTE_UNKNOWN;

    /* renamed from: l, reason: collision with root package name */
    private String f19419l = "npth_inner_default";

    /* renamed from: o, reason: collision with root package name */
    private int f19422o = 0;

    /* renamed from: p, reason: collision with root package name */
    private long f19423p = -1;

    /* renamed from: u, reason: collision with root package name */
    private final Object f19428u = new Object();

    /* renamed from: w, reason: collision with root package name */
    private long f19430w = -1;

    /* renamed from: x, reason: collision with root package name */
    private long f19431x = 0;

    /* renamed from: y, reason: collision with root package name */
    private final Runnable f19432y = new Runnable() { // from class: com.apm.insight.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.this.g();
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
            }
        }
    };
    private int A = 0;
    private List<Pattern> B = null;
    private Pattern C = null;
    private File D = null;

    public b(Context context) {
        this.f19409b = context;
    }

    private static String a(float f11) {
        return f11 <= 0.0f ? "0%" : f11 <= 0.1f ? "0% - 10%" : f11 <= 0.3f ? "10% - 30%" : f11 <= 0.6f ? "30% - 60%" : f11 <= 0.9f ? "60% - 90%" : "90% - 100%";
    }

    private static String a(float f11, float f12) {
        return f12 > 0.0f ? a(f11 / f12) : f11 > 0.0f ? "100%" : "0%";
    }

    private JSONObject a(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray b11 = com.apm.insight.a.b(jSONArray);
        if (b11.length() != jSONArray.length()) {
            this.f19422o++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", b11);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x01fa, code lost:
    
        if (r3 != 5) goto L137;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02b0 A[LOOP:2: B:91:0x01e4->B:120:0x02b0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b8 A[EDGE_INSN: B:121:0x02b8->B:122:0x02b8 BREAK  A[LOOP:2: B:91:0x01e4->B:120:0x02b0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x03cc A[EDGE_INSN: B:19:0x03cc->B:20:0x03cc BREAK  A[LOOP:0: B:2:0x0044->B:37:0x03e2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x03e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r29, org.json.JSONObject r30) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1138
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(java.lang.String, org.json.JSONObject):void");
    }

    private static void a(HashMap<String, Float> hashMap, JSONObject jSONObject, String str) throws JSONException {
        String concat = "npth_anr_".concat(String.valueOf(str));
        if (hashMap.isEmpty()) {
            jSONObject.put(concat + "_total", "not found");
            return;
        }
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (Map.Entry<String, Float> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (key.endsWith("user")) {
                f11 += entry.getValue().floatValue();
            } else if (key.endsWith("kernel")) {
                f12 += entry.getValue().floatValue();
            } else if (key.endsWith("iowait")) {
                f13 += entry.getValue().floatValue();
            } else if (key.endsWith("irq")) {
                f14 += entry.getValue().floatValue();
            } else if (key.endsWith("softirq")) {
                f15 += entry.getValue().floatValue();
            }
        }
        float f16 = f11 + f12 + f13 + f14 + f15;
        jSONObject.put(concat + "_total", b(f16));
        jSONObject.put(concat + "_kernel_user_ratio", a(f12, f16));
        jSONObject.put(concat + "_iowait_user_ratio", a(f13, f16));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(org.json.JSONArray r17) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(org.json.JSONArray):void");
    }

    private boolean a(long j11) {
        if (this.f19429v) {
            this.f19429v = false;
            b(j11);
        }
        return false;
    }

    private boolean a(String str) {
        if (this.B == null) {
            JSONArray b11 = com.apm.insight.runtime.a.b();
            if (b11 != null) {
                this.B = new LinkedList();
                this.f19419l = b11.optString(0);
                for (int i11 = 1; i11 < b11.length(); i11++) {
                    try {
                        this.B.add(Pattern.compile(b11.optString(i11)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.B == null) {
                LinkedList linkedList = new LinkedList();
                this.B = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.B.add(Pattern.compile("^default_npth_thread$"));
                this.B.add(Pattern.compile("^RenderThread$"));
                this.B.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        Iterator<Pattern> it = this.B.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private static String b(float f11) {
        return a(f11 / 100.0f);
    }

    private void b(long j11) {
        if (this.f19431x != this.f19430w) {
            try {
                this.f19423p = System.currentTimeMillis();
                if (com.apm.insight.e.x()) {
                    this.f19425r = f.b().b();
                    this.f19424q = j.a(j11);
                    this.f19415h = f.b().a(j11).a();
                }
                JSONObject jSONObject = new JSONObject();
                this.f19426s = jSONObject;
                com.apm.insight.l.a.a(this.f19409b, jSONObject);
                this.f19427t = h();
                this.f19413f = !Npth.hasCrash();
            } catch (Throwable unused) {
            }
            try {
                this.f19411d = this.f19423p;
                String b11 = com.apm.insight.l.j.b();
                File file = new File(new File(com.apm.insight.l.j.f(this.f19409b), b11), "trace_" + com.apm.insight.l.a.b().replace(':', '_') + ".txt");
                file.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                n.a("anr_trace", b11);
                NativeImpl.i(file.getAbsolutePath());
                try {
                    JSONArray a11 = com.apm.insight.l.f.a(file.getAbsolutePath());
                    this.f19420m = a11;
                    a(a11);
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
                }
                if (this.f19414g == null) {
                    this.f19414g = d.a();
                }
            } catch (Throwable th3) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th3, "NPTH_CATCH");
            }
            com.apm.insight.a.d();
        } else {
            try {
                this.f19411d = this.f19423p;
                String b12 = com.apm.insight.l.j.b();
                File file2 = new File(new File(com.apm.insight.l.j.f(this.f19409b), b12), "trace" + com.apm.insight.l.a.b().replace(':', '_') + ".txt");
                file2.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file2, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                n.a("anr_trace", b12);
                NativeImpl.i(file2.getAbsolutePath());
                try {
                    JSONArray a12 = com.apm.insight.l.f.a(file2.getAbsolutePath());
                    this.f19420m = a12;
                    a(a12);
                } catch (IOException unused3) {
                } catch (Throwable th4) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th4, "NPTH_CATCH");
                }
                if (this.f19414g == null) {
                    this.f19414g = d.a();
                }
            } catch (Throwable th5) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th5, "NPTH_CATCH");
            }
        }
        long j12 = this.f19430w;
        this.f19431x = j12;
        this.f19430w = -1L;
        if (j12 == -1) {
            this.f19431x = (-1) - 1;
        }
    }

    private static void b(String str, JSONArray jSONArray) {
        for (ICrashCallback iCrashCallback : l.a().e()) {
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(CrashType.ANR, str, (Thread) null, jSONArray);
                } else {
                    iCrashCallback.onCrash(CrashType.ANR, str, null);
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
            }
        }
    }

    @Nullable
    private int[] b(@NonNull JSONArray jSONArray) throws IllegalArgumentException {
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            String optString = jSONArray.optString(i11);
            int indexOf = (optString == null || optString.isEmpty()) ? -1 : optString.indexOf("utm=");
            if (indexOf > 0) {
                if (this.C == null) {
                    this.C = Pattern.compile("[^0-9]+");
                }
                String[] split = this.C.split(optString.substring(indexOf));
                if (split == null || split.length < 2) {
                    return null;
                }
                int intValue = Integer.decode(split[1]).intValue();
                int intValue2 = Integer.decode(split[2]).intValue();
                return new int[]{intValue, intValue2, intValue + intValue2};
            }
        }
        return null;
    }

    private JSONObject c(@NonNull JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray b11 = com.apm.insight.a.b(jSONArray);
        if (b11.length() != jSONArray.length()) {
            this.f19422o++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < b11.length(); i11++) {
                sb2.append(b11.getString(i11));
                sb2.append('\n');
            }
            jSONObject.put("mainStackFromTrace", sb2.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static boolean h() {
        boolean a11 = com.apm.insight.l.a.a();
        boolean z10 = !a11;
        if (a11 || com.apm.insight.runtime.a.b.d().e() > 2000) {
            return z10;
        }
        return false;
    }

    private File i() {
        if (this.D == null) {
            this.D = new File(this.f19409b.getFilesDir(), "has_anr_signal_" + com.apm.insight.l.a.b().replaceAll(":", "_"));
        }
        return this.D;
    }

    public final void a() {
        if (this.f19410c) {
            return;
        }
        this.f19408a = new c(this);
        this.f19411d = com.apm.insight.e.j();
        this.f19410c = true;
    }

    public final void b() {
        if (this.f19410c) {
            this.f19410c = false;
            c cVar = this.f19408a;
            if (cVar != null) {
                cVar.b();
            }
            this.f19408a = null;
        }
    }

    public final void c() {
        c cVar = this.f19408a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d() {
        synchronized (this.f19428u) {
        }
        this.f19432y.run();
    }

    public final void e() {
        if (NativeImpl.h()) {
            try {
                com.apm.insight.l.f.a(i(), String.valueOf(this.A + 1), false);
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
            }
        }
        this.f19430w = SystemClock.uptimeMillis();
        this.f19429v = true;
    }

    public final void f() {
        File i11 = i();
        try {
            int intValue = Integer.decode(com.apm.insight.l.f.a(i11.getAbsolutePath(), "\n")).intValue();
            this.A = intValue;
            if (intValue >= 2) {
                NativeImpl.a(false);
            } else {
                NativeImpl.a(true);
            }
        } catch (IOException unused) {
            NativeImpl.a(true);
        } catch (Throwable unused2) {
            com.apm.insight.l.f.a(i11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0196 A[Catch: all -> 0x01a6, TryCatch #3 {all -> 0x01a6, blocks: (B:42:0x0147, B:44:0x0196, B:45:0x01a9, B:47:0x01cc, B:48:0x01d1, B:50:0x01d7, B:52:0x01df, B:53:0x01e6, B:70:0x03c3, B:81:0x0412, B:120:0x01e2), top: B:41:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01cc A[Catch: all -> 0x01a6, TryCatch #3 {all -> 0x01a6, blocks: (B:42:0x0147, B:44:0x0196, B:45:0x01a9, B:47:0x01cc, B:48:0x01d1, B:50:0x01d7, B:52:0x01df, B:53:0x01e6, B:70:0x03c3, B:81:0x0412, B:120:0x01e2), top: B:41:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03aa A[Catch: all -> 0x0238, TRY_LEAVE, TryCatch #5 {all -> 0x0238, blocks: (B:117:0x0232, B:56:0x023c, B:59:0x02a8, B:62:0x0355, B:65:0x037b, B:67:0x03aa, B:88:0x03b9, B:69:0x03b3), top: B:116:0x0232, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03d9 A[Catch: all -> 0x03e0, TRY_LEAVE, TryCatch #0 {all -> 0x03e0, blocks: (B:72:0x03cb, B:74:0x03d9), top: B:71:0x03cb }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0407 A[Catch: all -> 0x0412, TRY_LEAVE, TryCatch #1 {all -> 0x0412, blocks: (B:77:0x03e0, B:79:0x0407), top: B:76:0x03e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x026a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean g() {
        /*
            Method dump skipped, instructions count: 1079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.g():boolean");
    }
}
