package com.google.android.gms.internal.play_billing;

/* loaded from: classes4.dex */
final class zzgl implements zzfz {
    private final zzgc zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgl(zzgc zzgcVar, String str, Object[] objArr) {
        this.zza = zzgcVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i11 = charAt & 8191;
        int i12 = 1;
        int i13 = 13;
        while (true) {
            int i14 = i12 + 1;
            char charAt2 = str.charAt(i12);
            if (charAt2 < 55296) {
                this.zzd = i11 | (charAt2 << i13);
                return;
            } else {
                i11 |= (charAt2 & 8191) << i13;
                i13 += 13;
                i12 = i14;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final zzgc zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final int zzc() {
        int i11 = this.zzd;
        if ((i11 & 1) != 0) {
            return 1;
        }
        return (i11 & 4) == 4 ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}
