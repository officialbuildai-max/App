package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static o f19914a;

    /* renamed from: b, reason: collision with root package name */
    private File f19915b;

    /* renamed from: c, reason: collision with root package name */
    private File f19916c;

    /* renamed from: d, reason: collision with root package name */
    private File f19917d;

    /* renamed from: e, reason: collision with root package name */
    private Context f19918e;

    /* renamed from: f, reason: collision with root package name */
    private a f19919f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private long f19922a;

        /* renamed from: b, reason: collision with root package name */
        private long f19923b;

        /* renamed from: c, reason: collision with root package name */
        private File f19924c;

        /* renamed from: d, reason: collision with root package name */
        private JSONObject f19925d;

        private a(File file) {
            this.f19925d = null;
            this.f19924c = file;
            String[] split = file.getName().split("-|\\.");
            if (split.length >= 2) {
                this.f19922a = Long.parseLong(split[0]);
                this.f19923b = Long.parseLong(split[1]);
                return;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name) || name.length() < 13) {
                return;
            }
            String substring = name.substring(0, 13);
            if (TextUtils.isDigitsOnly(substring)) {
                long parseLong = Long.parseLong(substring);
                this.f19922a = parseLong;
                this.f19923b = parseLong;
            }
        }

        /* synthetic */ a(File file, byte b11) {
            this(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject a() {
            if (this.f19925d == null) {
                try {
                    this.f19925d = new JSONObject(com.apm.insight.l.f.a(this.f19924c.getAbsolutePath(), "\n"));
                } catch (Throwable unused) {
                }
                if (this.f19925d == null) {
                    this.f19925d = new JSONObject();
                }
            }
            return this.f19925d;
        }

        static /* synthetic */ boolean a(a aVar, long j11) {
            long j12 = aVar.f19922a;
            if (j12 > j11 && j12 - j11 > 604800000) {
                return true;
            }
            long j13 = aVar.f19923b;
            if (j13 >= j11 || j11 - j13 <= 604800000) {
                return aVar.f19924c.lastModified() < j11 && j11 - aVar.f19924c.lastModified() > 604800000;
            }
            return true;
        }

        static /* synthetic */ void d(a aVar) {
            aVar.f19924c.delete();
        }
    }

    private o(Context context) {
        File c11 = com.apm.insight.l.j.c(context);
        if (!c11.exists() || (!c11.isDirectory() && c11.delete())) {
            c11.mkdirs();
            com.apm.insight.runtime.a.b.a();
        }
        this.f19915b = c11;
        this.f19916c = new File(c11, "did");
        this.f19917d = new File(c11, "device_uuid");
        this.f19918e = context;
    }

    public static o a() {
        if (f19914a == null) {
            f19914a = new o(com.apm.insight.e.g());
        }
        return f19914a;
    }

    private void a(long j11, long j12, JSONObject jSONObject, JSONArray jSONArray) {
        File file = new File(this.f19915b, j11 + "-" + j12 + ".ctx");
        File file2 = new File(this.f19915b, j11 + "-" + j12 + ".allData");
        try {
            com.apm.insight.l.f.a(file, jSONObject);
            com.apm.insight.l.f.a(file2, jSONArray);
            this.f19919f = new a(file, (byte) 0);
        } catch (IOException e11) {
            com.apm.insight.c.a();
            j.a(e11, "NPTH_CATCH");
        }
    }

    private ArrayList<a> c(final String str) {
        File[] listFiles = this.f19915b.listFiles(new FilenameFilter() { // from class: com.apm.insight.runtime.o.1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return str2.endsWith(str) && Pattern.compile("^\\d{1,13}-\\d{1,13}.*").matcher(str2).matches();
            }
        });
        ArrayList<a> arrayList = new ArrayList<>();
        if (listFiles == null) {
            return arrayList;
        }
        com.apm.insight.a.a((Object) ("foundRuntimeContextFiles " + listFiles.length));
        byte b11 = 0;
        a aVar = null;
        for (File file : listFiles) {
            try {
                a aVar2 = new a(file, b11);
                arrayList.add(aVar2);
                if (this.f19919f == null && ".ctx".equals(str) && (aVar == null || aVar2.f19923b >= aVar.f19923b)) {
                    aVar = aVar2;
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                j.a(th2, "NPTH_CATCH");
            }
        }
        if (this.f19919f == null && aVar != null) {
            this.f19919f = aVar;
        }
        return arrayList;
    }

    @Nullable
    public final JSONObject a(long j11) {
        JSONObject jSONObject;
        File file;
        boolean z10;
        String str;
        Iterator<a> it = c(".ctx").iterator();
        while (true) {
            jSONObject = null;
            if (!it.hasNext()) {
                file = null;
                break;
            }
            a next = it.next();
            if (j11 >= next.f19922a && j11 <= next.f19923b) {
                file = next.f19924c;
                break;
            }
        }
        if (file == null) {
            Iterator<a> it2 = c(".ctx").iterator();
            a aVar = null;
            while (it2.hasNext()) {
                a next2 = it2.next();
                if (aVar == null || Math.abs(aVar.f19923b - j11) > Math.abs(next2.f19923b - j11)) {
                    aVar = next2;
                }
            }
            file = aVar == null ? null : aVar.f19924c;
            z10 = true;
        } else {
            z10 = false;
        }
        if (file != null) {
            try {
                str = com.apm.insight.l.f.a(file.getAbsolutePath(), "\n");
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable th2) {
                    th = th2;
                    com.apm.insight.c.a();
                    j.a(new IOException("content :".concat(String.valueOf(str)), th), "NPTH_CATCH");
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("unauthentic_version", 1);
                        } catch (JSONException e11) {
                            com.apm.insight.c.a();
                            j.a(e11, "NPTH_CATCH");
                        }
                    }
                    return jSONObject;
                }
            } catch (Throwable th3) {
                th = th3;
                str = null;
            }
        }
        if (jSONObject != null && z10) {
            jSONObject.put("unauthentic_version", 1);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        try {
            com.apm.insight.l.f.a(this.f19916c, str, false);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[Catch: all -> 0x00a5, TryCatch #0 {all -> 0x00a5, blocks: (B:21:0x007d, B:24:0x008b, B:25:0x008f, B:27:0x0095, B:30:0x00a1), top: B:20:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.util.Map<java.lang.String, java.lang.Object> r11, org.json.JSONArray r12) {
        /*
            r10 = this;
            android.content.Context r0 = r10.f19918e
            com.apm.insight.entity.Header r0 = com.apm.insight.entity.Header.a(r0)
            org.json.JSONObject r6 = r0.a(r11)
            boolean r11 = com.apm.insight.entity.Header.c(r6)
            if (r11 == 0) goto L11
            return
        L11:
            long r8 = java.lang.System.currentTimeMillis()
            com.apm.insight.runtime.o$a r11 = r10.f19919f
            if (r11 != 0) goto L1e
            java.lang.String r11 = ".ctx"
            r10.c(r11)
        L1e:
            com.apm.insight.runtime.o$a r11 = r10.f19919f
            if (r11 != 0) goto L2a
            r1 = r10
            r2 = r8
            r4 = r8
            r7 = r12
            r1.a(r2, r4, r6, r7)
            return
        L2a:
            org.json.JSONObject r0 = com.apm.insight.runtime.o.a.a(r11)
            boolean r1 = com.apm.insight.entity.Header.c(r0)
            r2 = 1
            r3 = 2
            if (r1 != 0) goto L5e
            boolean r1 = com.apm.insight.entity.Header.c(r6)
            if (r1 == 0) goto L3e
            r0 = 0
            goto L5f
        L3e:
            java.lang.String r1 = "update_version_code"
            java.lang.Object r4 = r6.opt(r1)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.Object r1 = r0.opt(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L5e
            boolean r0 = com.apm.insight.entity.Header.d(r0)
            if (r0 == 0) goto L5e
            r0 = r2
            goto L5f
        L5e:
            r0 = r3
        L5f:
            if (r0 == r2) goto L6c
            if (r0 == r3) goto L64
            goto L7d
        L64:
            r1 = r10
            r2 = r8
            r4 = r8
            r7 = r12
            r1.a(r2, r4, r6, r7)
            goto L7d
        L6c:
            long r2 = com.apm.insight.runtime.o.a.b(r11)
            r1 = r10
            r4 = r8
            r7 = r12
            r1.a(r2, r4, r6, r7)
            java.io.File r11 = com.apm.insight.runtime.o.a.c(r11)
            com.apm.insight.l.f.a(r11)
        L7d:
            java.lang.String r11 = ""
            java.util.ArrayList r11 = r10.c(r11)     // Catch: java.lang.Throwable -> La5
            int r12 = r11.size()     // Catch: java.lang.Throwable -> La5
            r0 = 6
            if (r12 > r0) goto L8b
            return
        L8b:
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Throwable -> La5
        L8f:
            boolean r12 = r11.hasNext()     // Catch: java.lang.Throwable -> La5
            if (r12 == 0) goto La7
            java.lang.Object r12 = r11.next()     // Catch: java.lang.Throwable -> La5
            com.apm.insight.runtime.o$a r12 = (com.apm.insight.runtime.o.a) r12     // Catch: java.lang.Throwable -> La5
            boolean r0 = com.apm.insight.runtime.o.a.a(r12, r8)     // Catch: java.lang.Throwable -> La5
            if (r0 == 0) goto L8f
            com.apm.insight.runtime.o.a.d(r12)     // Catch: java.lang.Throwable -> La5
            goto L8f
        La5:
            r11 = move-exception
            goto La8
        La7:
            return
        La8:
            com.apm.insight.c.a()
            java.lang.String r12 = "NPTH_CATCH"
            com.apm.insight.runtime.j.a(r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.o.a(java.util.Map, org.json.JSONArray):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b() {
        try {
            return com.apm.insight.l.f.a(this.f19916c.getAbsolutePath(), "\n");
        } catch (Throwable unused) {
            return "0";
        }
    }

    @Nullable
    public final JSONArray b(long j11) {
        File file;
        String str;
        Iterator<a> it = c(".allData").iterator();
        while (true) {
            if (!it.hasNext()) {
                file = null;
                break;
            }
            a next = it.next();
            if (j11 >= next.f19922a && j11 <= next.f19923b) {
                file = next.f19924c;
                break;
            }
        }
        if (file == null) {
            Iterator<a> it2 = c(".allData").iterator();
            a aVar = null;
            while (it2.hasNext()) {
                a next2 = it2.next();
                if (aVar == null || Math.abs(aVar.f19923b - j11) > Math.abs(next2.f19923b - j11)) {
                    aVar = next2;
                }
            }
            file = aVar == null ? null : aVar.f19924c;
        }
        if (file == null) {
            return null;
        }
        try {
            str = com.apm.insight.l.f.a(file.getAbsolutePath(), "\n");
            try {
                return new JSONArray(str);
            } catch (Throwable th2) {
                th = th2;
                com.apm.insight.c.a();
                j.a(new IOException("content :".concat(String.valueOf(str)), th), "NPTH_CATCH");
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    public final void b(String str) {
        try {
            com.apm.insight.l.f.a(this.f19917d, str, false);
        } catch (Throwable unused) {
        }
    }

    public final String c() {
        try {
            return com.apm.insight.l.f.a(this.f19917d.getAbsolutePath(), "\n");
        } catch (Throwable unused) {
            return null;
        }
    }
}
