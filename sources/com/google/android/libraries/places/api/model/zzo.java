package com.google.android.libraries.places.api.model;

/* loaded from: classes4.dex */
final class zzo extends zzcb {
    private int zza;
    private int zzb;
    private byte zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcb zza(int i11) {
        this.zza = i11;
        this.zzc = (byte) (this.zzc | 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.api.model.zzcb
    public final zzcb zzb(int i11) {
        this.zzb = i11;
        this.zzc = (byte) (this.zzc | 2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.api.model.zzcb
    public final LocalTime zzc() {
        if (this.zzc == 3) {
            return new zzbc(this.zza, this.zzb);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.zzc & 1) == 0) {
            sb2.append(" hours");
        }
        if ((this.zzc & 2) == 0) {
            sb2.append(" minutes");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
