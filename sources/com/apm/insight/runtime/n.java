package com.apm.insight.runtime;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static File f19910a;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f19911a;

        /* renamed from: b, reason: collision with root package name */
        private String f19912b;

        /* renamed from: c, reason: collision with root package name */
        private long f19913c;

        a(String str) {
            String[] split = str.split("\\s+");
            if (split.length != 3) {
                com.apm.insight.c.a();
                j.a(new RuntimeException("err ProcessTrack line:".concat(str)), "NPTH_CATCH");
                return;
            }
            this.f19912b = split[0];
            this.f19911a = split[1];
            try {
                this.f19913c = Long.parseLong(split[2]);
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                j.a(new RuntimeException("err ProcessTrack line:".concat(str), th2), "NPTH_CATCH");
            }
        }
    }

    public static File a(long j11) {
        return new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((j11 - (j11 % 86400000)) / 86400000));
    }

    @NonNull
    public static HashMap<String, a> a(long j11, String str) {
        File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((j11 - (j11 % 86400000)) / 86400000));
        String[] list = file.list();
        HashMap<String, a> hashMap = new HashMap<>();
        if (list != null) {
            for (String str2 : list) {
                File file2 = new File(file, str2);
                long length = file2.length();
                try {
                    JSONArray a11 = com.apm.insight.l.f.a(file2, length > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED ? length - PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : 0L);
                    int length2 = a11.length() - 1;
                    while (true) {
                        if (length2 >= 0) {
                            String optString = a11.optString(length2);
                            if (!TextUtils.isEmpty(optString) && optString.startsWith(str)) {
                                hashMap.put(str2.replace('_', ':').replace(".txt", ""), new a(optString));
                                break;
                            }
                            length2--;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0050 A[Catch: all -> 0x0077, TRY_LEAVE, TryCatch #0 {all -> 0x0077, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0050, B:13:0x000f, B:14:0x004c), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.lang.String r10, java.lang.String r11) {
        /*
            java.io.File r0 = com.apm.insight.runtime.n.f19910a     // Catch: java.lang.Throwable -> L77
            if (r0 != 0) goto L4c
            com.apm.insight.e.g()     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = com.apm.insight.l.a.b()     // Catch: java.lang.Throwable -> L77
            if (r0 != 0) goto Lf
            r0 = 0
            goto L4e
        Lf:
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L77
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L77
            android.content.Context r4 = com.apm.insight.e.g()     // Catch: java.lang.Throwable -> L77
            java.lang.String r4 = com.apm.insight.l.j.j(r4)     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            java.lang.String r6 = "apminsight/ProcessTrack/"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L77
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            long r8 = r1 % r6
            long r1 = r1 - r8
            long r1 = r1 / r6
            r5.append(r1)     // Catch: java.lang.Throwable -> L77
            r1 = 47
            r5.append(r1)     // Catch: java.lang.Throwable -> L77
            r1 = 58
            r2 = 95
            java.lang.String r0 = r0.replace(r1, r2)     // Catch: java.lang.Throwable -> L77
            r5.append(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = ".txt"
            r5.append(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L77
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L77
            com.apm.insight.runtime.n.f19910a = r3     // Catch: java.lang.Throwable -> L77
        L4c:
            java.io.File r0 = com.apm.insight.runtime.n.f19910a     // Catch: java.lang.Throwable -> L77
        L4e:
            if (r0 == 0) goto L77
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r1.<init>()     // Catch: java.lang.Throwable -> L77
            r1.append(r10)     // Catch: java.lang.Throwable -> L77
            r10 = 32
            r1.append(r10)     // Catch: java.lang.Throwable -> L77
            r1.append(r11)     // Catch: java.lang.Throwable -> L77
            r1.append(r10)     // Catch: java.lang.Throwable -> L77
            long r10 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L77
            r1.append(r10)     // Catch: java.lang.Throwable -> L77
            r10 = 10
            r1.append(r10)     // Catch: java.lang.Throwable -> L77
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L77
            r11 = 1
            com.apm.insight.l.f.a(r0, r10, r11)     // Catch: java.lang.Throwable -> L77
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.n.a(java.lang.String, java.lang.String):void");
    }
}
