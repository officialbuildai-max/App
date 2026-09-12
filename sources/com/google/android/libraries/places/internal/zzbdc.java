package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
abstract class zzbdc extends zzayo {
    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("delegate", zzf());
        return zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public void zza(String str, Throwable th2) {
        zzf().zza(str, th2);
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzb() {
        zzf().zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public void zzc(int i11) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzayo zzf();
}
