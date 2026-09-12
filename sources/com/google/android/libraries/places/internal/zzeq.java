package com.google.android.libraries.places.internal;

import android.content.Context;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzeq {
    public static final /* synthetic */ int zza = 0;
    private static final long zzb = TimeUnit.MINUTES.toMicros(1);
    private final zzdv zzc;
    private final Context zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeq(Context context, zzdv zzdvVar) {
        this.zzd = context;
        this.zzc = zzdvVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
    
        if (r10.contains("_optout") == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.libraries.places.internal.zznx zza(@androidx.annotation.Nullable java.lang.String r14) {
        /*
            r13 = this;
            android.content.Context r14 = r13.zzd
            java.lang.String r0 = "wifi"
            java.lang.Object r14 = r14.getSystemService(r0)
            android.net.wifi.WifiManager r14 = (android.net.wifi.WifiManager) r14
            if (r14 == 0) goto La8
            boolean r0 = r14.isWifiEnabled()
            if (r0 != 0) goto L14
            goto La8
        L14:
            java.util.List r0 = r14.getScanResults()
            if (r0 == 0) goto La3
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L22
            goto La3
        L22:
            com.google.android.libraries.places.internal.zzep r1 = new com.google.android.libraries.places.internal.zzep
            r1.<init>()
            com.google.android.libraries.places.internal.zzoj r1 = com.google.android.libraries.places.internal.zzoj.zza(r1)
            com.google.android.libraries.places.internal.zznx r0 = com.google.android.libraries.places.internal.zznx.zzp(r1, r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.wifi.WifiInfo r14 = r14.getConnectionInfo()
            int r2 = r0.size()
            r3 = 0
            r4 = r3
        L3e:
            if (r4 >= r2) goto L9e
            java.lang.Object r5 = r0.get(r4)
            android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
            if (r5 == 0) goto L9b
            java.lang.String r6 = r5.SSID
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L51
            goto L9b
        L51:
            com.google.android.libraries.places.internal.zzdv r6 = r13.zzc
            long r6 = r6.zza()
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r8
            long r8 = r5.timestamp
            long r6 = r6 - r8
            long r8 = com.google.android.libraries.places.internal.zzeq.zzb
            java.lang.String r10 = r5.SSID
            if (r10 == 0) goto L93
            r11 = 95
            int r11 = r10.indexOf(r11)
            if (r11 >= 0) goto L6d
        L6b:
            r12 = r3
            goto L84
        L6d:
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r10 = r10.toLowerCase(r11)
            java.lang.String r11 = "_nomap"
            boolean r11 = r10.contains(r11)
            r12 = 1
            if (r11 != 0) goto L84
            java.lang.String r11 = "_optout"
            boolean r10 = r10.contains(r11)
            if (r10 == 0) goto L6b
        L84:
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 > 0) goto L9b
            if (r12 != 0) goto L9b
            com.google.android.libraries.places.internal.zzeo r6 = new com.google.android.libraries.places.internal.zzeo
            r6.<init>(r14, r5)
            r1.add(r6)
            goto L9b
        L93:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Null SSID."
            r14.<init>(r0)
            throw r14
        L9b:
            int r4 = r4 + 1
            goto L3e
        L9e:
            com.google.android.libraries.places.internal.zznx r14 = com.google.android.libraries.places.internal.zznx.zzj(r1)
            return r14
        La3:
            com.google.android.libraries.places.internal.zznx r14 = com.google.android.libraries.places.internal.zznx.zzl()
            return r14
        La8:
            com.google.android.libraries.places.internal.zznx r14 = com.google.android.libraries.places.internal.zznx.zzl()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzeq.zza(java.lang.String):com.google.android.libraries.places.internal.zznx");
    }
}
