package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class zzmx extends zzlt {
    final CharSequence zzb;
    final zzma zzc;
    int zzd = 0;
    int zze;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzmx(zzmy zzmyVar, CharSequence charSequence) {
        zzma zzmaVar;
        zzmaVar = zzmyVar.zza;
        this.zzc = zzmaVar;
        this.zze = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    protected final /* bridge */ /* synthetic */ Object zza() {
        int zzc;
        int i11 = this.zzd;
        while (true) {
            int i12 = this.zzd;
            if (i12 == -1) {
                zzb();
                return null;
            }
            int zzd = zzd(i12);
            if (zzd == -1) {
                zzd = this.zzb.length();
                this.zzd = -1;
                zzc = -1;
            } else {
                zzc = zzc(zzd);
                this.zzd = zzc;
            }
            if (zzc != i11) {
                while (i11 < zzd && this.zzc.zza(this.zzb.charAt(i11))) {
                    i11++;
                }
                while (zzd > i11) {
                    int i13 = zzd - 1;
                    if (!this.zzc.zza(this.zzb.charAt(i13))) {
                        break;
                    }
                    zzd = i13;
                }
                int i14 = this.zze;
                if (i14 == 1) {
                    zzd = this.zzb.length();
                    this.zzd = -1;
                    while (zzd > i11) {
                        int i15 = zzd - 1;
                        if (!this.zzc.zza(this.zzb.charAt(i15))) {
                            break;
                        }
                        zzd = i15;
                    }
                } else {
                    this.zze = i14 - 1;
                }
                return this.zzb.subSequence(i11, zzd).toString();
            }
            int i16 = zzc + 1;
            this.zzd = i16;
            if (i16 > this.zzb.length()) {
                this.zzd = -1;
            }
        }
    }

    abstract int zzc(int i11);

    abstract int zzd(int i11);
}
