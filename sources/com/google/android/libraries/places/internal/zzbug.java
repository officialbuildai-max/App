package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzbug {
    String zza;
    String zzb;
    int zzc = -1;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c0, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.InetAddress zzf(java.lang.String r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbug.zzf(java.lang.String, int, int):java.net.InetAddress");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.zza);
        sb2.append("://");
        if (this.zzb.indexOf(58) != -1) {
            sb2.append('[');
            sb2.append(this.zzb);
            sb2.append(']');
        } else {
            sb2.append(this.zzb);
        }
        int zza = zza();
        if (zza != zzbui.zzb(this.zza)) {
            sb2.append(':');
            sb2.append(zza);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() {
        int i11 = this.zzc;
        return i11 != -1 ? i11 : zzbui.zzb(this.zza);
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0114, code lost:
    
        r9.zzb = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0116, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.libraries.places.internal.zzbug zzb(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbug.zzb(java.lang.String):com.google.android.libraries.places.internal.zzbug");
    }

    public final zzbug zzc(int i11) {
        if (i11 > 0 && i11 <= 65535) {
            this.zzc = i11;
            return this;
        }
        throw new IllegalArgumentException("unexpected port: " + i11);
    }

    public final zzbug zzd(String str) {
        this.zza = "https";
        return this;
    }

    public final zzbui zze() {
        if (this.zza == null) {
            throw new IllegalStateException("scheme == null");
        }
        if (this.zzb != null) {
            return new zzbui(this, null);
        }
        throw new IllegalStateException("host == null");
    }
}
