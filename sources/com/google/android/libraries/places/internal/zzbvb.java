package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public abstract class zzbvb extends zzbbm {
    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("delegate", zzg());
        return zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzb(zzbdo zzbdoVar) {
        zzg().zzb(zzbdoVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzc(zzbbi zzbbiVar) {
        zzg().zzc(zzbbiVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzd() {
        zzg().zzd();
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public void zze() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final boolean zzf() {
        zzg().zzf();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzbbm zzg();
}
