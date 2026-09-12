package com.apm.insight.k;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.entity.b;
import com.apm.insight.k.c;
import com.apm.insight.l.n;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.o;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f19656b;

    /* renamed from: a, reason: collision with root package name */
    private Context f19657a;

    /* renamed from: f, reason: collision with root package name */
    private C0187b f19661f;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, C0187b> f19662g;

    /* renamed from: c, reason: collision with root package name */
    private List<File> f19658c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<File> f19659d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private int f19660e = -1;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f19663h = false;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f19664i = new Runnable() { // from class: com.apm.insight.k.b.1
        @Override // java.lang.Runnable
        public final void run() {
            b.this.f();
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private Runnable f19665j = new Runnable() { // from class: com.apm.insight.k.b.2
        @Override // java.lang.Runnable
        public final void run() {
            b.this.d();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        File f19675a;

        /* renamed from: b, reason: collision with root package name */
        long f19676b;

        /* renamed from: c, reason: collision with root package name */
        long f19677c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        CrashType f19678d;

        /* renamed from: e, reason: collision with root package name */
        String f19679e;

        a(File file, long j11, @Nullable CrashType crashType) {
            this.f19677c = -1L;
            this.f19675a = file;
            this.f19676b = j11;
            this.f19678d = crashType;
            this.f19679e = file.getName();
        }

        a(File file, @Nullable CrashType crashType) {
            this.f19676b = -1L;
            this.f19677c = -1L;
            this.f19675a = file;
            this.f19678d = crashType;
            this.f19679e = file.getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apm.insight.k.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0187b {

        /* renamed from: a, reason: collision with root package name */
        String f19680a;

        /* renamed from: d, reason: collision with root package name */
        a f19683d;

        /* renamed from: e, reason: collision with root package name */
        a f19684e;

        /* renamed from: b, reason: collision with root package name */
        List<a> f19681b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        List<a> f19682c = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        boolean f19685f = false;

        /* renamed from: g, reason: collision with root package name */
        int f19686g = 0;

        C0187b(String str) {
            this.f19680a = str;
        }
    }

    private b(Context context) {
        this.f19657a = context;
    }

    @Nullable
    private com.apm.insight.f.b a(File file, CrashType crashType, String str, long j11, long j12) {
        com.apm.insight.f.b bVar;
        try {
            try {
                if (file.isFile()) {
                    com.apm.insight.l.f.a(file);
                    return null;
                }
                boolean z10 = crashType == CrashType.LAUNCH;
                if (crashType == null) {
                    try {
                        return com.apm.insight.l.f.b(new File(file, file.getName()).getAbsolutePath());
                    } catch (Throwable th2) {
                        th = th2;
                        bVar = null;
                        com.apm.insight.l.f.a(file);
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        return bVar;
                    }
                }
                com.apm.insight.f.b a11 = com.apm.insight.l.f.a(file, crashType);
                try {
                    JSONObject b11 = a11.b();
                    try {
                        if (a11.b() == null) {
                            com.apm.insight.l.f.a(file);
                        } else {
                            if (crashType == CrashType.ANR) {
                                return a11;
                            }
                            b11.put("crash_time", j11);
                            b11.put("app_start_time", j12);
                            JSONObject optJSONObject = b11.optJSONObject("header");
                            if (optJSONObject == null) {
                                optJSONObject = Header.a(j11).f();
                            } else if (z10) {
                                b11.remove("header");
                            }
                            String optString = optJSONObject.optString("sdk_version_name", null);
                            if (optString == null) {
                                optString = "2008-20250701130429";
                            }
                            com.apm.insight.entity.a.a(b11, "filters", "sdk_version", optString);
                            JSONArray optJSONArray = b11.optJSONArray("logcat");
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                b11.put("logcat", com.apm.insight.runtime.h.a(str));
                            }
                            com.apm.insight.entity.a.a(b11, "filters", "has_dump", "true");
                            com.apm.insight.entity.a.a(b11, "filters", "has_logcat", String.valueOf(!com.apm.insight.a.a(b11, "logcat")));
                            com.apm.insight.entity.a.a(b11, "filters", "memory_leak", String.valueOf(com.apm.insight.entity.a.a(str)));
                            com.apm.insight.entity.a.a(b11, "filters", "fd_leak", String.valueOf(com.apm.insight.entity.a.b(str)));
                            com.apm.insight.entity.a.a(b11, "filters", "threads_leak", String.valueOf(com.apm.insight.entity.a.c(str)));
                            com.apm.insight.entity.a.a(b11, "filters", "is_64_devices", String.valueOf(Header.a()));
                            com.apm.insight.entity.a.a(b11, "filters", "is_64_runtime", String.valueOf(NativeImpl.f()));
                            com.apm.insight.entity.a.a(b11, "filters", "is_x86_devices", String.valueOf(Header.b()));
                            com.apm.insight.entity.a.a(b11, "filters", "has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(str).exists()));
                            com.apm.insight.entity.a.a(b11, "filters", "is_root", String.valueOf(com.apm.insight.nativecrash.a.k()));
                            b11.put("launch_did", com.apm.insight.i.a.a(this.f19657a));
                            b11.put("crash_uuid", file.getName());
                            try {
                                long parseLong = Long.parseLong(com.apm.insight.runtime.b.a(j11, str));
                                com.apm.insight.entity.a.a(b11, "filters", "lastAliveTime", Math.abs(parseLong - j11) < 60000 ? "< 60s" : "> 60s");
                                b11.put("lastAliveTime", String.valueOf(parseLong));
                            } catch (Throwable unused) {
                                b11.put("lastAliveTime", TmcConstants.ROUTE_UNKNOWN);
                                com.apm.insight.entity.a.a(b11, "filters", "lastAliveTime", TmcConstants.ROUTE_UNKNOWN);
                            }
                            b11.put("has_dump", "true");
                            if (b11.opt(PlaceTypes.STORAGE) == null) {
                                com.apm.insight.e.g();
                                com.apm.insight.entity.a.a(b11, n.a());
                            }
                            if (Header.b(optJSONObject)) {
                                com.apm.insight.entity.a.a(b11, "filters", "unauthentic_version", "unauthentic_version");
                            }
                            com.apm.insight.entity.d.b(b11);
                            a11.b().put("upload_scene", "launch_scan");
                            if (z10) {
                                JSONObject jSONObject = new JSONObject();
                                b11.put("event_type", "start_crash");
                                b11.put("stack", b11.remove("data"));
                                jSONObject.put("data", new JSONArray().put(b11));
                                jSONObject.put("header", optJSONObject);
                                a11.a(jSONObject);
                            } else {
                                b11.put("isJava", 1);
                            }
                        }
                        return a11;
                    } catch (Throwable th3) {
                        th = th3;
                        bVar = a11;
                        com.apm.insight.l.f.a(file);
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        return bVar;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            bVar = null;
        }
    }

    public static b a() {
        if (f19656b == null) {
            synchronized (b.class) {
                try {
                    if (f19656b == null) {
                        f19656b = new b(com.apm.insight.e.g());
                    }
                } finally {
                }
            }
        }
        return f19656b;
    }

    private static JSONObject a(com.apm.insight.nativecrash.a aVar) {
        JSONObject b11 = aVar.b();
        if (b11 != null && b11.length() != 0) {
            return b11;
        }
        if (com.apm.insight.e.d()) {
            aVar.j();
        }
        if (!aVar.a()) {
            aVar.i();
            return null;
        }
        if (!aVar.d()) {
            aVar.i();
            return null;
        }
        if (aVar.e()) {
            aVar.i();
            return null;
        }
        aVar.c();
        return aVar.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0155 A[Catch: all -> 0x0167, TryCatch #3 {all -> 0x0167, blocks: (B:55:0x0149, B:57:0x0155, B:59:0x0169), top: B:54:0x0149 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(final com.apm.insight.k.b.C0187b r21, boolean r22, @androidx.annotation.Nullable com.apm.insight.runtime.f r23) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.b.a(com.apm.insight.k.b$b, boolean, com.apm.insight.runtime.f):void");
    }

    private void a(HashMap<String, C0187b> hashMap) {
        File[] listFiles = com.apm.insight.l.j.f(this.f19657a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (int i11 = 0; i11 < listFiles.length && i11 < 5; i11++) {
            File file = listFiles[i11];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith("G")) {
                    String name = file.getName();
                    C0187b c0187b = hashMap.get(name);
                    if (c0187b == null) {
                        c0187b = new C0187b(name);
                        hashMap.put(name, c0187b);
                    }
                    JSONArray a11 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.l(file), com.apm.insight.l.j.m(file));
                    int length = a11.length();
                    c0187b.f19686g = length;
                    if (length > 0) {
                        try {
                            com.apm.insight.l.f.a(com.apm.insight.l.j.n(file), a11);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:10:0x0023, B:12:0x0031, B:15:0x0039, B:19:0x0041, B:23:0x0051, B:25:0x0057, B:27:0x005c, B:29:0x0068, B:31:0x0073, B:36:0x008d, B:50:0x00d7, B:52:0x00df, B:53:0x00e7, B:55:0x00f2, B:57:0x010a, B:60:0x00fc, B:62:0x0100, B:64:0x0108, B:65:0x00cf, B:66:0x00d2, B:67:0x00d5, B:68:0x00a6, B:71:0x00b0, B:74:0x00ba, B:78:0x0110, B:80:0x012d, B:34:0x007f), top: B:9:0x0023, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f2 A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:10:0x0023, B:12:0x0031, B:15:0x0039, B:19:0x0041, B:23:0x0051, B:25:0x0057, B:27:0x005c, B:29:0x0068, B:31:0x0073, B:36:0x008d, B:50:0x00d7, B:52:0x00df, B:53:0x00e7, B:55:0x00f2, B:57:0x010a, B:60:0x00fc, B:62:0x0100, B:64:0x0108, B:65:0x00cf, B:66:0x00d2, B:67:0x00d5, B:68:0x00a6, B:71:0x00b0, B:74:0x00ba, B:78:0x0110, B:80:0x012d, B:34:0x007f), top: B:9:0x0023, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d5 A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:10:0x0023, B:12:0x0031, B:15:0x0039, B:19:0x0041, B:23:0x0051, B:25:0x0057, B:27:0x005c, B:29:0x0068, B:31:0x0073, B:36:0x008d, B:50:0x00d7, B:52:0x00df, B:53:0x00e7, B:55:0x00f2, B:57:0x010a, B:60:0x00fc, B:62:0x0100, B:64:0x0108, B:65:0x00cf, B:66:0x00d2, B:67:0x00d5, B:68:0x00a6, B:71:0x00b0, B:74:0x00ba, B:78:0x0110, B:80:0x012d, B:34:0x007f), top: B:9:0x0023, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.util.HashMap<java.lang.String, com.apm.insight.k.b.C0187b> r17, com.apm.insight.k.b.C0187b r18) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.b.a(java.util.HashMap, com.apm.insight.k.b$b):void");
    }

    private static boolean a(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    private void b(final C0187b c0187b, boolean z10, @Nullable com.apm.insight.runtime.f fVar) {
        Iterator<a> it;
        boolean z11;
        JSONObject a11;
        a aVar;
        if (c0187b.f19682c.size() <= 1 && c0187b.f19682c.isEmpty()) {
            c0187b.f19684e = c0187b.f19683d;
            return;
        }
        boolean b11 = com.apm.insight.l.k.b(this.f19657a);
        c0187b.f19684e = c0187b.f19683d;
        com.apm.insight.nativecrash.a aVar2 = new com.apm.insight.nativecrash.a(this.f19657a);
        Iterator<a> it2 = c0187b.f19682c.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            final File file = next.f19675a;
            try {
                aVar2.a(file);
                a11 = a(aVar2);
            } catch (Throwable th2) {
                th = th2;
                it = it2;
            }
            if (a11 == null || a11.length() == 0) {
                it = it2;
                z11 = b11;
                aVar2.i();
            } else if (a11.length() != 0) {
                if (z10) {
                    it = it2;
                    z11 = b11;
                    if (fVar != null && !fVar.a("default")) {
                        aVar2.i();
                    }
                } else {
                    long optLong = a11.optLong("crash_time");
                    try {
                        aVar = c0187b.f19684e;
                    } catch (Throwable th3) {
                        th = th3;
                        it = it2;
                        z11 = b11;
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        com.apm.insight.l.f.a(file);
                        b11 = z11;
                        it2 = it;
                    }
                    if (aVar == null) {
                        c0187b.f19684e = next;
                        c0187b.f19685f = true;
                        if (fVar == null || fVar.a("default")) {
                            it = it2;
                            z11 = b11;
                        } else {
                            aVar2.i();
                        }
                    } else {
                        it = it2;
                        try {
                        } catch (Throwable th4) {
                            th = th4;
                            z11 = b11;
                        }
                        if (c0187b.f19685f) {
                            z11 = b11;
                        } else {
                            z11 = b11;
                            try {
                            } catch (Throwable th5) {
                                th = th5;
                                com.apm.insight.c.a();
                                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                                com.apm.insight.l.f.a(file);
                                b11 = z11;
                                it2 = it;
                            }
                            if (optLong < aVar.f19676b) {
                                c0187b.f19684e = next;
                                if (fVar == null || fVar.a("default")) {
                                    a(file);
                                    c0187b.f19685f = true;
                                } else {
                                    aVar2.i();
                                    b11 = z11;
                                    it2 = it;
                                }
                            }
                        }
                        com.apm.insight.entity.a.a(a11, "filters", "aid", String.valueOf(a11.optJSONObject("header").opt("aid")));
                        a11.optJSONObject("header").put("aid", Sdk$SDKMetric.SDKMetricType.AD_WILL_CLOSE_VALUE);
                    }
                }
                com.apm.insight.entity.a.a(a11, "filters", "start_uuid", c0187b.f19680a);
                com.apm.insight.entity.a.a(a11, "filters", "crash_thread_name", a11.optString("crash_thread_name", TmcConstants.ROUTE_UNKNOWN));
                if (z11) {
                    try {
                        c.a aVar3 = new c.a(a11, CrashType.NATIVE);
                        com.apm.insight.entity.b.a(a11, com.apm.insight.entity.b.a(aVar3.c(), aVar3.a(), o.a().b(aVar3.b() == -1 ? System.currentTimeMillis() : aVar3.b())), new b.a() { // from class: com.apm.insight.k.b.4
                            @Override // com.apm.insight.entity.b.a
                            public final void a(JSONObject jSONObject) {
                                d.a();
                                d.a(jSONObject, file, com.apm.insight.l.j.a(b.this.f19657a, c0187b.f19680a));
                            }
                        });
                        if (!aVar2.i()) {
                            aVar2.f();
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        com.apm.insight.l.f.a(file);
                        b11 = z11;
                        it2 = it;
                    }
                }
                c.a(CrashType.NATIVE, a11);
            } else {
                it = it2;
                z11 = b11;
            }
            b11 = z11;
            it2 = it;
        }
    }

    private void b(HashMap<String, C0187b> hashMap) {
        File[] listFiles = com.apm.insight.l.j.d(this.f19657a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (int i11 = 0; i11 < listFiles.length && i11 < 5; i11++) {
            File file = listFiles[i11];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith("G")) {
                    String name = file.getName();
                    C0187b c0187b = hashMap.get(name);
                    if (c0187b == null) {
                        c0187b = new C0187b(name);
                        hashMap.put(name, c0187b);
                    }
                    c0187b.f19682c.add(new a(file, CrashType.NATIVE));
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f19663h || this.f19662g == null) {
            return;
        }
        if (!com.apm.insight.l.k.b(this.f19657a)) {
            e();
        }
        if (this.f19660e == -1) {
            if (com.apm.insight.runtime.a.a() && com.apm.insight.runtime.a.f()) {
                this.f19660e = 1;
            } else {
                this.f19660e = 0;
            }
        }
        boolean z10 = this.f19660e == 1;
        com.apm.insight.runtime.f fVar = new com.apm.insight.runtime.f(this.f19657a);
        Iterator<C0187b> it = this.f19662g.values().iterator();
        while (it.hasNext()) {
            b(it.next(), z10, fVar);
        }
        Iterator<C0187b> it2 = this.f19662g.values().iterator();
        while (it2.hasNext()) {
            a(it2.next(), z10, fVar);
        }
        Iterator<C0187b> it3 = this.f19662g.values().iterator();
        while (it3.hasNext()) {
            com.apm.insight.l.f.a(com.apm.insight.l.j.a(this.f19657a, it3.next().f19680a));
        }
        fVar.a();
        com.apm.insight.runtime.b.a();
        e();
    }

    private void e() {
        this.f19663h = true;
        this.f19662g = null;
        NativeImpl.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f19663h) {
            return;
        }
        if (!com.apm.insight.l.k.b(this.f19657a) || (System.currentTimeMillis() - com.apm.insight.e.j() <= 5000 && com.apm.insight.e.i().isApmExists() && !Npth.hasCrash())) {
            m.a().a(this.f19664i, 5000L);
        } else {
            d();
        }
    }

    private void g() {
        File[] listFiles = com.apm.insight.l.j.i(this.f19657a).listFiles();
        if (listFiles == null) {
            return;
        }
        for (int i11 = 0; i11 < listFiles.length && i11 < 5; i11++) {
            File file = listFiles[i11];
            if (file.getName().endsWith(".atmp")) {
                com.apm.insight.a.a.a();
                file.getAbsolutePath();
            } else {
                try {
                    com.apm.insight.f.b c11 = com.apm.insight.l.f.c(file.getAbsolutePath());
                    if (c11 != null) {
                        if (c11.b() != null) {
                            c11.b().put("upload_scene", "launch_scan");
                        }
                        if (e.a(e.d(), c11.e(), c11.d(), c11.f(), c11.g())) {
                            com.apm.insight.l.f.a(file);
                            String c12 = c11.c();
                            if (!TextUtils.isEmpty(c12)) {
                                com.apm.insight.l.f.a(new File(c12));
                            }
                        }
                    } else {
                        com.apm.insight.l.f.a(file);
                    }
                } catch (Throwable th2) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
                }
            }
        }
    }

    public final void a(boolean z10) {
        if (!Npth.isStopUpload() && z10) {
            if (this.f19661f == null) {
                this.f19661f = new C0187b("old_uuid");
                HashMap<String, C0187b> hashMap = new HashMap<>();
                this.f19662g = hashMap;
                a(hashMap);
                a(this.f19662g, this.f19661f);
                com.apm.insight.l.f.a(com.apm.insight.l.j.b(this.f19657a));
                b(this.f19662g);
                b(this.f19661f, true, null);
                a(this.f19661f, true, null);
                this.f19661f = null;
                if (this.f19662g.isEmpty()) {
                    e();
                } else {
                    f();
                }
            }
            g();
            com.apm.insight.a.c();
        }
    }

    public final void b() {
        try {
            if (!this.f19663h && com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                m.a().a(this.f19665j);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean c() {
        return this.f19663h;
    }
}
