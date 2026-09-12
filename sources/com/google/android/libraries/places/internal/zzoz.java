package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public class zzoz extends zzpb {
    private final char[][] zza;
    private final int zzb;
    private final char zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzoz(zzpa zzpaVar, char c11, char c12) {
        char[][] zzb = zzpaVar.zzb();
        this.zza = zzb;
        this.zzb = zzb.length;
        this.zzc = (char) 65535;
    }

    @Override // com.google.android.libraries.places.internal.zzpb, com.google.android.libraries.places.internal.zzpd
    public final String zza(String str) {
        str.getClass();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if ((charAt < this.zzb && this.zza[charAt] != null) || charAt > this.zzc) {
                return zzc(str, i11);
            }
        }
        return str;
    }

    @Override // com.google.android.libraries.places.internal.zzpb
    protected final char[] zzb(char c11) {
        char[] cArr;
        if (c11 >= this.zzb || (cArr = this.zza[c11]) == null) {
            return null;
        }
        return cArr;
    }
}
