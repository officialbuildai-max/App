package ak;

/* loaded from: classes5.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f725a = new r();

    private r() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:3:0x000f, B:5:0x0015, B:8:0x0025, B:10:0x002b, B:11:0x003a, B:13:0x0042, B:14:0x0046, B:16:0x0053, B:18:0x0073, B:23:0x0034, B:25:0x0038, B:26:0x001c), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[Catch: all -> 0x007d, LOOP:0: B:15:0x0051->B:16:0x0053, LOOP_END, TryCatch #0 {all -> 0x007d, blocks: (B:3:0x000f, B:5:0x0015, B:8:0x0025, B:10:0x002b, B:11:0x003a, B:13:0x0042, B:14:0x0046, B:16:0x0053, B:18:0x0073, B:23:0x0034, B:25:0x0038, B:26:0x001c), top: B:2:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(android.content.Context r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.h(r9, r2)
            android.content.pm.PackageManager r2 = r9.getPackageManager()
            java.lang.String r9 = r9.getPackageName()
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L7d
            r4 = 28
            if (r3 < r4) goto L1c
            r5 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r9 = r2.getPackageInfo(r9, r5)     // Catch: java.lang.Throwable -> L7d
            goto L22
        L1c:
            r5 = 64
            android.content.pm.PackageInfo r9 = r2.getPackageInfo(r9, r5)     // Catch: java.lang.Throwable -> L7d
        L22:
            r2 = 0
            if (r3 < r4) goto L34
            android.content.pm.SigningInfo r9 = com.cloud.tmc.miniutils.util.a.a(r9)     // Catch: java.lang.Throwable -> L7d
            if (r9 == 0) goto L32
            android.content.pm.Signature[] r9 = com.cloud.tmc.miniutils.util.c.a(r9)     // Catch: java.lang.Throwable -> L7d
            r9 = r9[r0]     // Catch: java.lang.Throwable -> L7d
            goto L3a
        L32:
            r9 = r2
            goto L3a
        L34:
            android.content.pm.Signature[] r9 = r9.signatures     // Catch: java.lang.Throwable -> L7d
            if (r9 == 0) goto L32
            r9 = r9[r0]     // Catch: java.lang.Throwable -> L7d
        L3a:
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch: java.lang.Throwable -> L7d
            if (r9 == 0) goto L46
            byte[] r2 = r9.toByteArray()     // Catch: java.lang.Throwable -> L7d
        L46:
            byte[] r9 = r3.digest(r2)     // Catch: java.lang.Throwable -> L7d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d
            r2.<init>()     // Catch: java.lang.Throwable -> L7d
            int r3 = r9.length     // Catch: java.lang.Throwable -> L7d
            r4 = r0
        L51:
            if (r4 >= r3) goto L73
            r5 = r9[r4]     // Catch: java.lang.Throwable -> L7d
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.f67412a     // Catch: java.lang.Throwable -> L7d
            java.lang.String r6 = "%02X"
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)     // Catch: java.lang.Throwable -> L7d
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L7d
            r7[r0] = r5     // Catch: java.lang.Throwable -> L7d
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r7, r1)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r5 = java.lang.String.format(r6, r5)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r6 = "format(...)"
            kotlin.jvm.internal.Intrinsics.g(r5, r6)     // Catch: java.lang.Throwable -> L7d
            r2.append(r5)     // Catch: java.lang.Throwable -> L7d
            int r4 = r4 + r1
            goto L51
        L73:
            java.lang.String r9 = r2.toString()     // Catch: java.lang.Throwable -> L7d
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.g(r9, r0)     // Catch: java.lang.Throwable -> L7d
            return r9
        L7d:
            java.lang.String r9 = ""
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ak.r.a(android.content.Context):java.lang.String");
    }
}
