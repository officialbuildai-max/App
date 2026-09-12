package com.apm.insight.nativecrash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.apm.insight.ICommonParams;
import com.apm.insight.runtime.j;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f19795a;

    /* renamed from: b, reason: collision with root package name */
    private ICommonParams f19796b;

    /* renamed from: c, reason: collision with root package name */
    private ICommonParams f19797c;

    /* loaded from: classes2.dex */
    public static class a extends c {
        a(File file) {
            super(file);
            this.f19799b = "Total FD Count:";
            this.f19800c = ":";
            this.f19801d = -2;
        }
    }

    /* renamed from: com.apm.insight.nativecrash.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0189b extends c {
        C0189b(File file) {
            super(file);
            this.f19799b = "VmSize:";
            this.f19800c = "\\s+";
            this.f19801d = -1;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        protected File f19798a;

        /* renamed from: b, reason: collision with root package name */
        protected String f19799b;

        /* renamed from: c, reason: collision with root package name */
        protected String f19800c;

        /* renamed from: d, reason: collision with root package name */
        protected int f19801d;

        public c(File file) {
            this.f19798a = file;
        }

        private int a(String str) {
            int i11 = this.f19801d;
            if (!str.startsWith(this.f19799b)) {
                return i11;
            }
            try {
                i11 = Integer.parseInt(str.split(this.f19800c)[1].trim());
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
            if (!this.f19798a.exists() || !this.f19798a.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f19798a));
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
    public static class d extends c {
        d(File file) {
            super(file);
        }

        @NonNull
        public final HashMap<String, List<String>> b() {
            JSONArray a11;
            HashMap<String, List<String>> hashMap = new HashMap<>();
            try {
                a11 = com.apm.insight.l.f.a(this.f19798a.getAbsolutePath());
            } catch (IOException unused) {
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                j.a(th2, "NPTH_CATCH");
            }
            if (a11 == null) {
                return hashMap;
            }
            for (int i11 = 0; i11 < a11.length(); i11++) {
                String optString = a11.optString(i11);
                if (!TextUtils.isEmpty(optString) && optString.startsWith("[tid:0") && optString.endsWith("sigstack:0x0]")) {
                    int indexOf = optString.indexOf("[routine:0x");
                    int i12 = indexOf + 11;
                    String substring = indexOf > 0 ? optString.substring(i12, optString.indexOf(93, i12)) : "unknown addr";
                    List<String> list = hashMap.get(substring);
                    if (list == null) {
                        list = new ArrayList<>();
                        hashMap.put(substring, list);
                    }
                    list.add(optString);
                }
            }
            return hashMap;
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends c {
        e(File file) {
            super(file);
        }

        @NonNull
        public final JSONArray a(HashMap<String, List<String>> hashMap) {
            JSONArray a11;
            int indexOf;
            List<String> list;
            JSONArray jSONArray = new JSONArray();
            if (hashMap.isEmpty()) {
                return jSONArray;
            }
            try {
                a11 = com.apm.insight.l.f.a(this.f19798a.getAbsolutePath());
            } catch (IOException unused) {
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                j.a(th2, "NPTH_CATCH");
            }
            if (a11 == null) {
                return jSONArray;
            }
            for (int i11 = 0; i11 < a11.length(); i11++) {
                String optString = a11.optString(i11);
                if (!TextUtils.isEmpty(optString) && (indexOf = optString.indexOf(":")) > 2) {
                    String substring = optString.substring(2, indexOf);
                    if (hashMap.containsKey(substring) && (list = hashMap.get(substring)) != null) {
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next() + " " + optString);
                        }
                        hashMap.remove(substring);
                    }
                }
            }
            Iterator<List<String>> it2 = hashMap.values().iterator();
            while (it2.hasNext()) {
                Iterator<String> it3 = it2.next().iterator();
                while (it3.hasNext()) {
                    jSONArray.put(it3.next() + "  0x000000:unknown");
                }
            }
            return jSONArray;
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends c {
        f(File file) {
            super(file);
            this.f19799b = "Total Threads Count:";
            this.f19800c = ":";
            this.f19801d = -2;
        }
    }

    public b(Context context, ICommonParams iCommonParams) {
        this(context, iCommonParams, null);
    }

    public b(Context context, ICommonParams iCommonParams, b bVar) {
        this.f19795a = context;
        this.f19796b = iCommonParams;
        this.f19797c = bVar == null ? null : bVar.f19796b;
    }

    public static int a(String str) {
        return new a(com.apm.insight.l.j.b(str)).a();
    }

    @NonNull
    public static JSONArray a(File file, File file2) {
        return new e(file2).a(new d(file).b());
    }

    public static boolean a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey("version_name")) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    public static int b(String str) {
        return new f(com.apm.insight.l.j.c(str)).a();
    }

    public static int c(String str) {
        return new C0189b(com.apm.insight.l.j.d(str)).a();
    }

    public final Map<String, Object> a() {
        Object obj;
        Map<String, Object> b11 = b();
        if (((b11 == null || (obj = b11.get("aid")) == null) ? null : String.valueOf(obj)) == null) {
            b11.put("aid", 4444);
        }
        return b11;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.String, java.lang.Object> b() {
        /*
            r9 = this;
            java.lang.String r0 = "version_name"
            java.lang.String r1 = "update_version_code"
            java.lang.String r2 = "version_code"
            r3 = 0
            com.apm.insight.ICommonParams r4 = r9.f19797c     // Catch: java.lang.Throwable -> L10
            if (r4 == 0) goto L13
            java.util.Map r4 = r4.getCommonParams()     // Catch: java.lang.Throwable -> L10
            goto L18
        L10:
            r4 = move-exception
            r5 = r3
            goto L27
        L13:
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L10
            r4.<init>()     // Catch: java.lang.Throwable -> L10
        L18:
            com.apm.insight.ICommonParams r5 = r9.f19796b     // Catch: java.lang.Throwable -> L23
            java.util.Map r5 = r5.getCommonParams()     // Catch: java.lang.Throwable -> L23
            r4.putAll(r5)     // Catch: java.lang.Throwable -> L23
            r5 = r3
            goto L2a
        L23:
            r5 = move-exception
            r8 = r5
            r5 = r4
            r4 = r8
        L27:
            r8 = r5
            r5 = r4
            r4 = r8
        L2a:
            if (r4 != 0) goto L3d
            java.util.HashMap r4 = new java.util.HashMap
            r6 = 4
            r4.<init>(r6)
            if (r5 == 0) goto L3d
            java.lang.String r6 = "err_info"
            java.lang.String r5 = com.apm.insight.l.m.a(r5)     // Catch: java.lang.Throwable -> L3d
            r4.put(r6, r5)     // Catch: java.lang.Throwable -> L3d
        L3d:
            boolean r5 = a(r4)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 == 0) goto La3
            android.content.Context r5 = r9.f19795a     // Catch: java.lang.Throwable -> L7f
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L7f
            android.content.Context r7 = r9.f19795a     // Catch: java.lang.Throwable -> L7f
            java.lang.String r7 = r7.getPackageName()     // Catch: java.lang.Throwable -> L7f
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r7, r6)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r6 = r5.versionName     // Catch: java.lang.Throwable -> L7f
            r4.put(r0, r6)     // Catch: java.lang.Throwable -> L7f
            int r6 = r5.versionCode     // Catch: java.lang.Throwable -> L7f
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L7f
            r4.put(r2, r6)     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r6 = r4.get(r1)     // Catch: java.lang.Throwable -> L7f
            if (r6 != 0) goto Le9
            android.content.pm.ApplicationInfo r5 = r5.applicationInfo     // Catch: java.lang.Throwable -> L7f
            android.os.Bundle r5 = r5.metaData     // Catch: java.lang.Throwable -> L7f
            if (r5 == 0) goto L75
            java.lang.String r3 = "UPDATE_VERSION_CODE"
            java.lang.Object r3 = r5.get(r3)     // Catch: java.lang.Throwable -> L7f
        L75:
            if (r3 != 0) goto L7b
            java.lang.Object r3 = r4.get(r2)     // Catch: java.lang.Throwable -> L7f
        L7b:
            r4.put(r1, r3)     // Catch: java.lang.Throwable -> L7f
            goto Le9
        L7f:
            android.content.Context r3 = r9.f19795a
            java.lang.String r3 = com.apm.insight.l.a.c(r3)
            r4.put(r0, r3)
            android.content.Context r0 = r9.f19795a
            int r0 = com.apm.insight.l.a.d(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.put(r2, r0)
            java.lang.Object r0 = r4.get(r1)
            if (r0 != 0) goto Le9
            java.lang.Object r0 = r4.get(r2)
            r4.put(r1, r0)
            goto Le9
        La3:
            android.content.Context r0 = r9.f19795a     // Catch: java.lang.Throwable -> Le9
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> Le9
            android.content.Context r1 = r9.f19795a     // Catch: java.lang.Throwable -> Le9
            java.lang.String r1 = r1.getPackageName()     // Catch: java.lang.Throwable -> Le9
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r6)     // Catch: java.lang.Throwable -> Le9
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Throwable -> Le9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le9
            r1.<init>()     // Catch: java.lang.Throwable -> Le9
            android.content.Context r2 = r9.f19795a     // Catch: java.lang.Throwable -> Le9
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Throwable -> Le9
            r1.append(r2)     // Catch: java.lang.Throwable -> Le9
            java.lang.String r2 = ".BuildConfig"
            r1.append(r2)     // Catch: java.lang.Throwable -> Le9
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Le9
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> Le9
            java.lang.String r2 = "VERSION_NAME"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch: java.lang.Throwable -> Le9
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> Le9
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> Le9
            if (r0 == 0) goto Le9
            boolean r1 = r0.equals(r1)     // Catch: java.lang.Throwable -> Le9
            if (r1 != 0) goto Le9
            java.lang.String r1 = "manifest_version"
            r4.put(r1, r0)     // Catch: java.lang.Throwable -> Le9
        Le9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.b.b():java.util.Map");
    }

    @NonNull
    public final ICommonParams c() {
        return this.f19796b;
    }

    public final String d() {
        try {
            return this.f19796b.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String e() {
        try {
            return String.valueOf(this.f19796b.getCommonParams().get("aid"));
        } catch (Throwable unused) {
            return "4444";
        }
    }

    public final long f() {
        try {
            return this.f19796b.getUserId();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
