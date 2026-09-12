package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzbvr {
    public static final /* synthetic */ int zza = 0;
    private static final zzbvp zzb;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    static {
        /*
            r0 = 2
            r1 = 3
            r2 = 0
            r3 = 1
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r5 = 0
            java.lang.String r6 = "io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch: java.lang.Throwable -> Lf
            r7 = r5
            goto L12
        Lf:
            r6 = move-exception
            r7 = r6
            r6 = r5
        L12:
            if (r6 == 0) goto L33
            java.lang.Class<com.google.android.libraries.places.internal.zzbvp> r8 = com.google.android.libraries.places.internal.zzbvp.class
            java.lang.Class r6 = r6.asSubclass(r8)     // Catch: java.lang.Throwable -> L31
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L31
            java.lang.Class<com.google.android.libraries.places.internal.zzbvs> r9 = com.google.android.libraries.places.internal.zzbvs.class
            r8[r2] = r9     // Catch: java.lang.Throwable -> L31
            java.lang.reflect.Constructor r6 = r6.getConstructor(r8)     // Catch: java.lang.Throwable -> L31
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L31
            com.google.android.libraries.places.internal.zzbvs r9 = com.google.android.libraries.places.internal.zzbvp.zza     // Catch: java.lang.Throwable -> L31
            r8[r2] = r9     // Catch: java.lang.Throwable -> L31
            java.lang.Object r6 = r6.newInstance(r8)     // Catch: java.lang.Throwable -> L31
            com.google.android.libraries.places.internal.zzbvp r6 = (com.google.android.libraries.places.internal.zzbvp) r6     // Catch: java.lang.Throwable -> L31
            goto L34
        L31:
            r6 = move-exception
            r7 = r6
        L33:
            r6 = r5
        L34:
            if (r6 == 0) goto L39
            com.google.android.libraries.places.internal.zzbvr.zzb = r6
            goto L42
        L39:
            com.google.android.libraries.places.internal.zzbvp r6 = new com.google.android.libraries.places.internal.zzbvp
            com.google.android.libraries.places.internal.zzbvs r8 = com.google.android.libraries.places.internal.zzbvp.zza
            r6.<init>(r8)
            com.google.android.libraries.places.internal.zzbvr.zzb = r6
        L42:
            if (r7 == 0) goto L97
            java.lang.String r6 = "io.perfmark.PerfMark.debug"
            boolean r6 = java.lang.Boolean.getBoolean(r6)     // Catch: java.lang.Throwable -> L97
            if (r6 == 0) goto L97
            java.lang.String r6 = "java.util.logging.Logger"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch: java.lang.Throwable -> L97
            java.lang.String r8 = "getLogger"
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L97
            r9[r2] = r4     // Catch: java.lang.Throwable -> L97
            java.lang.reflect.Method r8 = r6.getMethod(r8, r9)     // Catch: java.lang.Throwable -> L97
            java.lang.Class<com.google.android.libraries.places.internal.zzbvr> r9 = com.google.android.libraries.places.internal.zzbvr.class
            java.lang.String r9 = r9.getName()     // Catch: java.lang.Throwable -> L97
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L97
            r10[r2] = r9     // Catch: java.lang.Throwable -> L97
            java.lang.Object r8 = r8.invoke(r5, r10)     // Catch: java.lang.Throwable -> L97
            java.lang.String r9 = "java.util.logging.Level"
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch: java.lang.Throwable -> L97
            java.lang.String r10 = "FINE"
            java.lang.reflect.Field r10 = r9.getField(r10)     // Catch: java.lang.Throwable -> L97
            java.lang.Object r5 = r10.get(r5)     // Catch: java.lang.Throwable -> L97
            java.lang.String r10 = "log"
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L97
            r11[r2] = r9     // Catch: java.lang.Throwable -> L97
            r11[r3] = r4     // Catch: java.lang.Throwable -> L97
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            r11[r0] = r4     // Catch: java.lang.Throwable -> L97
            java.lang.reflect.Method r4 = r6.getMethod(r10, r11)     // Catch: java.lang.Throwable -> L97
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L97
            r1[r2] = r5     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = "Error during PerfMark.<clinit>"
            r1[r3] = r2     // Catch: java.lang.Throwable -> L97
            r1[r0] = r7     // Catch: java.lang.Throwable -> L97
            r4.invoke(r8, r1)     // Catch: java.lang.Throwable -> L97
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbvr.<clinit>():void");
    }

    private zzbvr() {
    }

    public static zzbvq zza() {
        return zzbvp.zzb;
    }

    public static zzbvs zzb(String str) {
        return zzbvp.zza;
    }

    public static zzbvs zzc(String str, long j11) {
        return zzbvp.zza;
    }
}
