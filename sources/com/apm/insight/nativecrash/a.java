package com.apm.insight.nativecrash;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashFilter;
import com.apm.insight.entity.Header;
import com.apm.insight.l.h;
import com.apm.insight.l.m;
import com.apm.insight.l.n;
import com.apm.insight.runtime.j;
import com.apm.insight.runtime.o;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f19778d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f19779a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f19780b = null;

    /* renamed from: c, reason: collision with root package name */
    private b f19781c;

    /* renamed from: com.apm.insight.nativecrash.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0188a {
        /* JADX INFO: Access modifiers changed from: private */
        public static String b(File file) {
            BufferedReader bufferedReader;
            String readLine;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader;
                try {
                    com.apm.insight.c.a();
                    j.a(th, "NPTH_CATCH");
                    return "";
                } finally {
                    com.apm.insight.a.a((Closeable) bufferedReader2);
                }
            }
            if (readLine == null) {
                com.apm.insight.a.a((Closeable) bufferedReader);
                return "";
            }
            if (!readLine.startsWith("[FATAL:jni_android.cc") || !readLine.contains("Please include Java exception stack in crash report ttwebview:")) {
                com.apm.insight.a.a((Closeable) bufferedReader);
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            int indexOf = readLine.indexOf(" ttwebview:");
            sb2.append("Caused by: ");
            sb2.append("Please include Java exception stack in crash report");
            sb2.append("\n");
            sb2.append(readLine.substring(indexOf + 11));
            sb2.append("\n");
            while (true) {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 == null) {
                    String sb3 = sb2.toString();
                    com.apm.insight.a.a((Closeable) bufferedReader);
                    return sb3;
                }
                sb2.append(readLine2);
                sb2.append("\n");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private final com.apm.insight.nativecrash.c f19782a;

        /* renamed from: b, reason: collision with root package name */
        private final com.apm.insight.h.b f19783b;

        /* renamed from: c, reason: collision with root package name */
        private final File f19784c;

        /* renamed from: d, reason: collision with root package name */
        private final File f19785d;

        public b(File file) {
            this.f19784c = file;
            this.f19785d = com.apm.insight.l.j.a(com.apm.insight.e.g(), file.getName());
            com.apm.insight.h.b bVar = new com.apm.insight.h.b(file);
            this.f19783b = bVar;
            com.apm.insight.nativecrash.c cVar = new com.apm.insight.nativecrash.c(file);
            this.f19782a = cVar;
            if (bVar.d() && cVar.a() == null) {
                cVar.a(file);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001c A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:15:0x0008, B:17:0x000e, B:5:0x001c), top: B:14:0x0008 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final long a() {
            /*
                r2 = this;
                com.apm.insight.h.b r0 = r2.f19783b
                java.util.Map r0 = r0.f()
                if (r0 == 0) goto L19
                boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> L17
                if (r1 != 0) goto L19
                java.lang.String r1 = "start_time"
                java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L17
                java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L17
                goto L1a
            L17:
                r0 = move-exception
                goto L21
            L19:
                r0 = 0
            L1a:
                if (r0 == 0) goto L29
                long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L17
                return r0
            L21:
                com.apm.insight.c.a()
                java.lang.String r1 = "NPTH_CATCH"
                com.apm.insight.runtime.j.a(r0, r1)
            L29:
                long r0 = java.lang.System.currentTimeMillis()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.a.b.a():long");
        }

        public final File b() {
            return this.f19784c;
        }

        public final boolean c() {
            return this.f19783b.d();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends e {
        c() {
            super();
            this.f19790b = "Total FD Count:";
            this.f19789a = com.apm.insight.l.j.i(a.this.f19781c.b());
            this.f19791c = ":";
            this.f19792d = -2;
        }
    }

    /* loaded from: classes2.dex */
    public class d extends e {
        d() {
            super();
            this.f19790b = "VmSize:";
            this.f19789a = com.apm.insight.l.j.k(a.this.f19781c.b());
            this.f19791c = "\\s+";
            this.f19792d = -1;
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        protected File f19789a;

        /* renamed from: b, reason: collision with root package name */
        protected String f19790b;

        /* renamed from: c, reason: collision with root package name */
        protected String f19791c;

        /* renamed from: d, reason: collision with root package name */
        protected int f19792d;

        public e() {
        }

        private int a(String str) {
            int i11 = this.f19792d;
            if (!str.startsWith(this.f19790b)) {
                return i11;
            }
            try {
                i11 = Integer.parseInt(str.split(this.f19791c)[1].trim());
            } catch (NumberFormatException e11) {
                com.apm.insight.c.a();
                j.a(e11, "NPTH_CATCH");
            }
            if (i11 < 0) {
                return -2;
            }
            return i11;
        }

        public final int a() {
            int i11;
            Throwable th2;
            if (!this.f19789a.exists() || !this.f19789a.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f19789a));
                int i12 = -1;
                do {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        i12 = a(readLine);
                    } catch (Throwable th3) {
                        th2 = th3;
                        i11 = i12;
                        bufferedReader = bufferedReader2;
                        try {
                            com.apm.insight.c.a();
                            j.a(th2, "NPTH_CATCH");
                            return i11;
                        } finally {
                            if (bufferedReader != null) {
                                com.apm.insight.a.a((Closeable) bufferedReader);
                            }
                        }
                    }
                } while (i12 == -1);
                com.apm.insight.a.a((Closeable) bufferedReader2);
                return i12;
            } catch (Throwable th4) {
                i11 = -1;
                th2 = th4;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends e {
        f() {
            super();
            this.f19790b = "Total Threads Count:";
            this.f19789a = com.apm.insight.l.j.j(a.this.f19781c.b());
            this.f19791c = ":";
            this.f19792d = -2;
        }
    }

    public a(Context context) {
        this.f19779a = context;
    }

    private static String a(String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            if (str.length() < 16) {
                sb2.append(str);
            } else {
                sb2.append(str.charAt(6));
                sb2.append(str.charAt(7));
                sb2.append(str.charAt(4));
                sb2.append(str.charAt(5));
                sb2.append(str.charAt(2));
                sb2.append(str.charAt(3));
                sb2.append(str.charAt(0));
                sb2.append(str.charAt(1));
                sb2.append(str.charAt(10));
                sb2.append(str.charAt(11));
                sb2.append(str.charAt(8));
                sb2.append(str.charAt(9));
                sb2.append(str.charAt(14));
                sb2.append(str.charAt(15));
                sb2.append(str.charAt(12));
                sb2.append(str.charAt(13));
                if (str.length() >= 32) {
                    sb2.append((CharSequence) str, 16, 32);
                    sb2.append('0');
                }
            }
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
        }
        return sb2.toString().toUpperCase();
    }

    private void a(com.apm.insight.entity.a aVar) {
        File a11 = com.apm.insight.l.j.a(this.f19781c.b());
        if (a11.exists()) {
            try {
                String a12 = com.apm.insight.l.f.a(a11.getAbsolutePath(), "\n");
                JSONArray jSONArray = new JSONArray();
                if (a12 != null) {
                    for (String str : a12.split("\n")) {
                        jSONArray.put(str);
                    }
                }
                aVar.a("native_log", (Object) jSONArray);
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                j.a(th2, "NPTH_CATCH");
            }
        }
    }

    private void b(com.apm.insight.entity.a aVar) {
        BufferedReader bufferedReader;
        File h11 = com.apm.insight.l.j.h(this.f19781c.b());
        if (!h11.exists()) {
            NativeImpl.a(h11.getAbsolutePath(), String.valueOf(com.apm.insight.e.i().getLogcatDumpCount()), String.valueOf(com.apm.insight.e.i().getLogcatLevel()));
        }
        JSONArray jSONArray = new JSONArray();
        String str = " " + this.f19781c.f19783b.f().get("pid") + " ";
        try {
            bufferedReader = new BufferedReader(new FileReader(h11));
            try {
                if (h11.length() > 512000) {
                    bufferedReader.skip(h11.length() - 512000);
                }
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if ((readLine.length() > 32 ? readLine.substring(0, 31) : readLine).contains(str)) {
                        jSONArray.put(readLine);
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        com.apm.insight.a.a((Closeable) bufferedReader);
        aVar.a("logcat", (Object) jSONArray);
    }

    public static long g() {
        if (NativeImpl.f()) {
            return Long.MAX_VALUE;
        }
        return Header.a() ? 3891200L : 2867200L;
    }

    public static boolean k() {
        Boolean bool = f19778d;
        if (bool != null) {
            return bool.booleanValue();
        }
        String[] strArr = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        for (int i11 = 0; i11 < 11; i11++) {
            try {
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                j.a(th2, "NPTH_CATCH");
            }
            if (new File(strArr[i11]).exists()) {
                f19778d = Boolean.TRUE;
                return true;
            }
            continue;
        }
        f19778d = Boolean.FALSE;
        return false;
    }

    @Nullable
    private String l() {
        b bVar = this.f19781c;
        if (bVar == null) {
            return null;
        }
        String c11 = bVar.f19782a.c();
        return (c11 == null || c11.isEmpty()) ? this.f19781c.f19783b.e() : c11;
    }

    public final void a(File file) {
        this.f19781c = new b(file);
    }

    public final boolean a() {
        b bVar = this.f19781c;
        if (bVar != null) {
            return bVar.c();
        }
        return false;
    }

    public final JSONObject b() {
        File f11 = com.apm.insight.l.j.f(this.f19781c.b());
        if (!f11.exists()) {
            return null;
        }
        try {
            String a11 = com.apm.insight.l.f.a(f11.getAbsolutePath(), "\n");
            if (a11 != null && !a11.isEmpty()) {
                return new JSONObject(a11);
            }
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
        }
        return null;
    }

    public final void c() {
        BufferedWriter bufferedWriter;
        Throwable th2;
        try {
            File e11 = com.apm.insight.l.j.e(this.f19781c.b());
            File file = new File(e11.getAbsolutePath() + ".tmp'");
            if (file.exists()) {
                file.delete();
            }
            int i11 = 0;
            if (e11.exists()) {
                while (i11 < NativeCrashCollector.a()) {
                    File file2 = new File(e11.getAbsolutePath() + '.' + i11);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    i11++;
                }
                return;
            }
            com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
            for (int i12 = 0; i12 < NativeCrashCollector.a(); i12++) {
                File file3 = new File(e11.getAbsolutePath() + '.' + i12);
                if (file3.exists()) {
                    try {
                        String a11 = com.apm.insight.l.f.a(file3.getAbsolutePath(), "\n");
                        if (!TextUtils.isEmpty(a11)) {
                            JSONObject jSONObject = new JSONObject(a11);
                            if (jSONObject.length() > 0) {
                                aVar.c(jSONObject);
                            }
                        }
                    } catch (JSONException e12) {
                        com.apm.insight.c.a();
                        j.a(e12, "NPTH_CATCH");
                    }
                }
            }
            JSONObject c11 = aVar.c();
            try {
                if (c11.length() != 0 && c11.opt(PlaceTypes.STORAGE) == null) {
                    com.apm.insight.e.g();
                    com.apm.insight.entity.a.a(c11, n.a());
                }
            } catch (Throwable unused) {
            }
            if (c11.length() == 0) {
                return;
            }
            this.f19780b = c11;
            file.getParentFile().mkdirs();
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
            } catch (Throwable th3) {
                bufferedWriter = null;
                th2 = th3;
            }
            try {
                h.a(c11, bufferedWriter);
                if (file.renameTo(e11)) {
                    while (i11 < NativeCrashCollector.a()) {
                        File file4 = new File(e11.getAbsolutePath() + '.' + i11);
                        if (file4.exists()) {
                            file4.delete();
                        }
                        i11++;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                try {
                    try {
                        c11.put("err_write", th2.toString());
                        com.apm.insight.entity.a.a(c11, "filters", "err_write", th2.getLocalizedMessage());
                    } catch (JSONException unused2) {
                        com.apm.insight.c.a();
                        j.a(th2, "NPTH_CATCH");
                    }
                } finally {
                    com.apm.insight.a.a((Closeable) bufferedWriter);
                }
            }
        } catch (IOException e13) {
            com.apm.insight.c.a();
            j.a(e13, "NPTH_CATCH");
        }
    }

    public final boolean d() {
        ICrashFilter b11 = com.apm.insight.e.b().b();
        if (b11 == null) {
            return true;
        }
        try {
            return b11.onNativeCrashFilter(l(), "");
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
            return true;
        }
    }

    public final boolean e() {
        return com.apm.insight.e.a.a().a(com.apm.insight.l.j.f(this.f19781c.b()).getAbsolutePath());
    }

    public final void f() {
        com.apm.insight.e.a.a().a(com.apm.insight.d.a.b(com.apm.insight.l.j.f(this.f19781c.b()).getAbsolutePath()));
    }

    public final JSONObject h() {
        try {
            com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
            Header header = new Header(this.f19779a);
            JSONObject a11 = o.a().a(this.f19781c.a());
            if (a11 != null) {
                header.a(a11);
                header.d();
                header.e();
            }
            Header.b(header);
            aVar.a(header);
            boolean z10 = true;
            aVar.a("is_native_crash", (Object) 1);
            aVar.a("repack_time", Long.valueOf(System.currentTimeMillis()));
            aVar.a("crash_uuid", this.f19781c.b().getName());
            b bVar = this.f19781c;
            Map<String, String> f11 = bVar != null ? bVar.f19783b.f() : null;
            if (f11 != null) {
                Object obj = (String) f11.get("process_name");
                if (obj != null) {
                    aVar.a("process_name", obj);
                }
                String str = f11.get("start_time");
                if (str != null) {
                    try {
                        aVar.a(Long.decode(str).longValue());
                    } catch (Throwable th2) {
                        com.apm.insight.c.a();
                        j.a(th2, "NPTH_CATCH");
                    }
                }
                String str2 = f11.get("pid");
                if (str2 != null) {
                    try {
                        aVar.a("pid", Long.decode(str2));
                    } catch (Throwable th3) {
                        com.apm.insight.c.a();
                        j.a(th3, "NPTH_CATCH");
                    }
                }
                Object obj2 = (String) f11.get("crash_thread_name");
                if (obj2 != null) {
                    aVar.a("crash_thread_name", obj2);
                }
                String str3 = f11.get("crash_time");
                if (str3 != null) {
                    try {
                        aVar.a("crash_time", Long.decode(str3));
                    } catch (Throwable th4) {
                        com.apm.insight.c.a();
                        j.a(th4, "NPTH_CATCH");
                    }
                }
                aVar.a("data", l());
            }
            Map<String, String> b11 = this.f19781c.f19782a.b();
            if (!b11.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str4 : b11.keySet()) {
                    String a12 = a(b11.get(str4));
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lib_name", str4);
                        jSONObject.put("lib_uuid", a12);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e11) {
                        com.apm.insight.c.a();
                        j.a(e11, "NPTH_CATCH");
                    }
                }
                aVar.a("crash_lib_uuid", (Object) jSONArray);
            }
            File e12 = com.apm.insight.l.j.e(this.f19781c.b());
            if (e12.exists() || this.f19780b != null) {
                try {
                    JSONObject jSONObject2 = this.f19780b;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject(com.apm.insight.l.f.a(e12.getAbsolutePath(), "\n"));
                    }
                    aVar.c(jSONObject2);
                    aVar.a("has_callback", "true");
                    if (aVar.c().opt(PlaceTypes.STORAGE) == null) {
                        com.apm.insight.e.g();
                        aVar.b(n.a());
                    }
                    com.apm.insight.a.a(aVar, aVar.d(), CrashType.NATIVE);
                } catch (Throwable th5) {
                    com.apm.insight.c.a();
                    j.a(th5, "NPTH_CATCH");
                }
                long j11 = -1;
                long optLong = aVar.c().optLong("crash_time", -1L);
                long optLong2 = aVar.c().optLong("java_end", -1L);
                if (optLong2 != -1 && optLong != -1) {
                    j11 = optLong2 - optLong;
                }
                try {
                    aVar.b("total_cost", String.valueOf(j11));
                    aVar.a("total_cost", String.valueOf(j11 / 1000));
                } catch (Throwable unused) {
                }
            } else {
                com.apm.insight.e.g();
                aVar.b(n.a());
                aVar.a("has_callback", "false");
            }
            File g11 = com.apm.insight.l.j.g(this.f19781c.b());
            String str5 = "";
            if (g11.exists()) {
                try {
                    str5 = m.a(g11.getAbsolutePath());
                } catch (Throwable th6) {
                    com.apm.insight.c.a();
                    j.a(th6, "NPTH_CATCH");
                }
            }
            File o11 = com.apm.insight.l.j.o(this.f19781c.b());
            if (o11.exists()) {
                String b12 = C0188a.b(o11);
                str5 = str5.isEmpty() ? b12 : str5 + "\n" + b12;
            }
            try {
                if (!str5.isEmpty()) {
                    aVar.a("java_data", (Object) str5);
                }
            } catch (Throwable th7) {
                com.apm.insight.c.a();
                j.a(th7, "NPTH_CATCH");
            }
            b(aVar);
            a(aVar);
            com.apm.insight.entity.d.b(aVar.c());
            Map<? extends String, ? extends String> hashMap = new HashMap<>();
            if (k()) {
                hashMap.put("is_root", "true");
                aVar.a("is_root", "true");
            } else {
                hashMap.put("is_root", "false");
                aVar.a("is_root", "false");
            }
            hashMap.put("has_fds_file", com.apm.insight.l.j.i(this.f19781c.b()).exists() ? "true" : "false");
            File h11 = com.apm.insight.l.j.h(this.f19781c.b());
            hashMap.put("has_logcat_file", (!h11.exists() || h11.length() <= 128) ? "false" : "true");
            hashMap.put("has_maps_file", com.apm.insight.l.j.d(this.f19781c.b()).exists() ? "true" : "false");
            hashMap.put("has_tombstone_file", com.apm.insight.l.j.b(this.f19781c.b()).exists() ? "true" : "false");
            hashMap.put("has_meminfo_file", com.apm.insight.l.j.k(this.f19781c.b()).exists() ? "true" : "false");
            hashMap.put("has_threads_file", com.apm.insight.l.j.j(this.f19781c.b()).exists() ? "true" : "false");
            int a13 = new c().a();
            if (a13 > 0) {
                if (a13 > 960) {
                    hashMap.put("fd_leak", "true");
                } else {
                    hashMap.put("fd_leak", "false");
                }
                aVar.a("fd_count", Integer.valueOf(a13));
            }
            int a14 = new f().a();
            if (a14 > 0) {
                if (a14 > 350) {
                    hashMap.put("threads_leak", "true");
                } else {
                    hashMap.put("threads_leak", "false");
                }
                aVar.a("threads_count", Integer.valueOf(a14));
            }
            int a15 = new d().a();
            if (a15 > 0) {
                if (a15 > g()) {
                    hashMap.put("memory_leak", "true");
                } else {
                    hashMap.put("memory_leak", "false");
                }
                aVar.a("memory_size", Integer.valueOf(a15));
            }
            hashMap.put("sdk_version", "2008-20250701130429");
            if (aVar.c().opt("java_data") == null) {
                z10 = false;
            }
            hashMap.put("has_java_stack", String.valueOf(z10));
            JSONArray a16 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.l(this.f19781c.f19784c), com.apm.insight.l.j.m(this.f19781c.f19784c));
            hashMap.put("leak_threads_count", String.valueOf(a16.length()));
            if (a16.length() > 0) {
                try {
                    com.apm.insight.l.f.a(com.apm.insight.l.j.n(this.f19781c.f19784c), a16);
                } catch (Throwable unused2) {
                }
            }
            aVar.b();
            aVar.a("is_64_devices", String.valueOf(Header.a()));
            aVar.a("is_64_runtime", String.valueOf(NativeImpl.f()));
            aVar.a("is_x86_devices", String.valueOf(Header.b()));
            aVar.c(hashMap);
            File f12 = com.apm.insight.l.j.f(this.f19781c.b());
            JSONObject c11 = aVar.c();
            com.apm.insight.l.f.a(f12, c11);
            return c11;
        } catch (Throwable th8) {
            com.apm.insight.c.a();
            j.a(th8, "NPTH_CATCH");
            return null;
        }
    }

    public final boolean i() {
        return com.apm.insight.l.f.a(this.f19781c.b());
    }

    public final void j() {
        try {
            com.apm.insight.l.f.b(this.f19781c.b().getAbsolutePath(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/localDebug/" + com.apm.insight.e.g().getPackageName() + "/" + this.f19781c.b().getName() + ".zip");
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
        }
    }
}
