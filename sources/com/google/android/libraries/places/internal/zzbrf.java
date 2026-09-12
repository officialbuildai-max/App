package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
final class zzbrf extends zzbrl {
    final /* synthetic */ zzbri zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbrf(zzbri zzbriVar, zzbts zzbtsVar) {
        super(zzbtsVar);
        this.zza = zzbriVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbrl, com.google.android.libraries.places.internal.zzbts
    public final void zza(zzbue zzbueVar) throws IOException {
        int i11;
        zzbri zzbriVar = this.zza;
        i11 = zzbriVar.zzk;
        zzbriVar.zzk = i11 + 1;
        super.zza(zzbueVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbrl, com.google.android.libraries.places.internal.zzbts
    public final void zzb(boolean z10, int i11, int i12) throws IOException {
        int i13;
        if (z10) {
            zzbri zzbriVar = this.zza;
            i13 = zzbriVar.zzk;
            zzbriVar.zzk = i13 + 1;
        }
        super.zzb(z10, i11, i12);
    }

    @Override // com.google.android.libraries.places.internal.zzbrl, com.google.android.libraries.places.internal.zzbts
    public final void zzc(int i11, zzbtp zzbtpVar) throws IOException {
        int i12;
        zzbri zzbriVar = this.zza;
        i12 = zzbriVar.zzk;
        zzbriVar.zzk = i12 + 1;
        super.zzc(i11, zzbtpVar);
    }
}
