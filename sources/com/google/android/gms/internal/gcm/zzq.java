package com.google.android.gms.internal.gcm;

import java.io.PrintStream;

/* loaded from: classes4.dex */
public final class zzq {
    private static final zzr zzdq;
    private static final int zzdr;

    /* loaded from: classes4.dex */
    static final class zzd extends zzr {
        zzd() {
        }

        @Override // com.google.android.gms.internal.gcm.zzr
        public final void zzd(Throwable th2, Throwable th3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    static {
        /*
            java.lang.Integer r0 = zzac()     // Catch: java.lang.Throwable -> L2a
            if (r0 == 0) goto L16
            int r1 = r0.intValue()     // Catch: java.lang.Throwable -> L14
            r2 = 19
            if (r1 < r2) goto L16
            com.google.android.gms.internal.gcm.zzv r1 = new com.google.android.gms.internal.gcm.zzv     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L5b
        L14:
            r1 = move-exception
            goto L2c
        L16:
            java.lang.String r1 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r1 = java.lang.Boolean.getBoolean(r1)     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L24
            com.google.android.gms.internal.gcm.zzu r1 = new com.google.android.gms.internal.gcm.zzu     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L5b
        L24:
            com.google.android.gms.internal.gcm.zzq$zzd r1 = new com.google.android.gms.internal.gcm.zzq$zzd     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L5b
        L2a:
            r1 = move-exception
            r0 = 0
        L2c:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.gcm.zzq$zzd> r3 = com.google.android.gms.internal.gcm.zzq.zzd.class
            java.lang.String r3 = r3.getName()
            int r4 = r3.length()
            int r4 = r4 + 133
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = "will be used. The error is: "
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.println(r3)
            r1.printStackTrace(r2)
            com.google.android.gms.internal.gcm.zzq$zzd r1 = new com.google.android.gms.internal.gcm.zzq$zzd
            r1.<init>()
        L5b:
            com.google.android.gms.internal.gcm.zzq.zzdq = r1
            if (r0 != 0) goto L61
            r0 = 1
            goto L65
        L61:
            int r0 = r0.intValue()
        L65:
            com.google.android.gms.internal.gcm.zzq.zzdr = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gcm.zzq.<clinit>():void");
    }

    private static Integer zzac() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e11) {
            PrintStream printStream = System.err;
            printStream.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e11.printStackTrace(printStream);
            return null;
        }
    }

    public static void zzd(Throwable th2, Throwable th3) {
        zzdq.zzd(th2, th3);
    }
}
