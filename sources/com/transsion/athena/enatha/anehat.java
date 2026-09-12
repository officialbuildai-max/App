package com.transsion.athena.enatha;

import android.os.Handler;

/* loaded from: classes5.dex */
public class anehat implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f42774a;

    public anehat(Handler handler) {
        this.f42774a = handler;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = "%s"
            android.content.Context r3 = com.transsion.ga.AthenaAnalytics.J()
            k4.a r4 = k4.a.a(r3)
            java.lang.String r5 = "athena_id"
            java.lang.String r6 = r4.i(r5)
            com.transsion.athena.taaneh.athena$aethna r7 = com.transsion.athena.taaneh.athena.a(r3)     // Catch: java.lang.Exception -> L1b
            java.lang.String r7 = r7.a()     // Catch: java.lang.Exception -> L1b
            goto L28
        L1b:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            java.lang.Object[] r8 = new java.lang.Object[r1]
            r8[r0] = r7
            com.transsion.athena.taaneh.aethna.a(r2, r8)
            r7 = 0
        L28:
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto La7
            boolean r8 = android.text.TextUtils.equals(r6, r7)
            if (r8 != 0) goto La7
            r4.g(r5, r7)
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 != 0) goto La6
            java.lang.String r4 = "android.permission.READ_PHONE_STATE"
            boolean r4 = com.transsion.athena.taaneh.anehat.a(r3, r4)     // Catch: java.lang.Exception -> L5d
            if (r4 != 0) goto L50
            java.lang.String r4 = "android.permission.READ_PRIVILEGED_PHONE_STATE"
            boolean r4 = com.transsion.athena.taaneh.anehat.a(r3, r4)     // Catch: java.lang.Exception -> L5d
            if (r4 == 0) goto L4e
            goto L50
        L4e:
            r4 = r0
            goto L5e
        L50:
            boolean r4 = com.transsion.ga.AthenaAnalytics.S()     // Catch: java.lang.Exception -> L5d
            if (r4 == 0) goto L57
            goto L5d
        L57:
            boolean r4 = com.transsion.athena.taaneh.anehat.c(r3)     // Catch: java.lang.Exception -> L5d
            r4 = r4 ^ r1
            goto L5e
        L5d:
            r4 = r1
        L5e:
            if (r4 == 0) goto La6
            java.lang.String r4 = com.transsion.athena.taaneh.athena.c()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r5 = "device_id_transfer"
            r8 = 9999(0x270f, float:1.4012E-41)
            if (r4 == 0) goto L8a
            com.transsion.athena.data.TrackData r4 = new com.transsion.athena.data.TrackData
            r4.<init>()
            java.lang.String r6 = "en"
            r9 = 2
            com.transsion.athena.data.TrackData r4 = r4.add(r6, r5, r9)
            java.lang.String r5 = "cnt"
            com.transsion.athena.data.TrackData r4 = r4.add(r5, r1, r1)
            com.transsion.ga.AthenaAnalytics r5 = com.transsion.ga.AthenaAnalytics.K(r8)
            java.lang.String r6 = "data_discard"
            r5.g0(r6, r4, r8)
            goto La6
        L8a:
            com.transsion.athena.data.TrackData r4 = new com.transsion.athena.data.TrackData
            r4.<init>()
            java.lang.String r9 = "pre_gaid"
            com.transsion.athena.data.TrackData r4 = r4.add(r9, r6)
            java.lang.String r6 = com.transsion.athena.taaneh.athena.c()
            java.lang.String r9 = "sn"
            com.transsion.athena.data.TrackData r4 = r4.add(r9, r6)
            com.transsion.ga.AthenaAnalytics r6 = com.transsion.ga.AthenaAnalytics.K(r8)
            r6.g0(r5, r4, r8)
        La6:
            r6 = r7
        La7:
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 != 0) goto Lb0
            com.transsion.athena.taaneh.anehat.b(r6)
        Lb0:
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 == 0) goto Lc3
            java.lang.String r3 = com.transsion.athena.taaneh.athena.a(r3, r0)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto Lc1
            goto Lc3
        Lc1:
            r3 = r0
            goto Lc4
        Lc3:
            r3 = r1
        Lc4:
            if (r3 != 0) goto Lcf
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "device gaid and iid are null"
            r1[r0] = r3
            com.transsion.athena.taaneh.aethna.a(r2, r1)
        Lcf:
            android.os.Handler r0 = r10.f42774a
            r1 = 7200000(0x6ddd00, double:3.5572727E-317)
            r0.postDelayed(r10, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.enatha.anehat.run():void");
    }
}
