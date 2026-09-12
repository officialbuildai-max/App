package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
final class zzawp extends zzawn {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* synthetic */ int zza(Object obj) {
        return ((zzawo) obj).zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzawo) obj).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzatu zzatuVar = (zzatu) obj;
        zzawo zzawoVar = zzatuVar.zzc;
        if (zzawoVar != zzawo.zzc()) {
            return zzawoVar;
        }
        zzawo zzf = zzawo.zzf();
        zzatuVar.zzc = zzf;
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzatu) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzawo.zzc().equals(obj2)) {
            return obj;
        }
        if (zzawo.zzc().equals(obj)) {
            return zzawo.zze((zzawo) obj, (zzawo) obj2);
        }
        ((zzawo) obj).zzd((zzawo) obj2);
        return obj;
    }

    @Override // com.google.android.libraries.places.internal.zzawn
    final /* synthetic */ Object zzf() {
        return zzawo.zzf();
    }

    @Override // com.google.android.libraries.places.internal.zzawn
    final /* synthetic */ Object zzg(Object obj) {
        ((zzawo) obj).zzh();
        return obj;
    }

    @Override // com.google.android.libraries.places.internal.zzawn
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i11, int i12) {
        ((zzawo) obj).zzj((i11 << 3) | 5, Integer.valueOf(i12));
    }

    @Override // com.google.android.libraries.places.internal.zzawn
    final /* bridge */ /* synthetic */ void zzi(Object obj, int i11, long j11) {
        ((zzawo) obj).zzj((i11 << 3) | 1, Long.valueOf(j11));
    }

    @Override // com.google.android.libraries.places.internal.zzawn
    final /* bridge */ /* synthetic */ void zzj(Object obj, int i11, Object obj2) {
        ((zzawo) obj).zzj((i11 << 3) | 3, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i11, zzask zzaskVar) {
        ((zzawo) obj).zzj((i11 << 3) | 2, zzaskVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* bridge */ /* synthetic */ void zzl(Object obj, int i11, long j11) {
        ((zzawo) obj).zzj(i11 << 3, Long.valueOf(j11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final void zzm(Object obj) {
        ((zzatu) obj).zzc.zzh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzatu) obj).zzc = (zzawo) obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzatu) obj).zzc = (zzawo) obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final boolean zzq(zzavs zzavsVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* synthetic */ void zzr(Object obj, zzasy zzasyVar) throws IOException {
        ((zzawo) obj).zzk(zzasyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzawn
    public final /* synthetic */ void zzs(Object obj, zzasy zzasyVar) throws IOException {
        ((zzawo) obj).zzl(zzasyVar);
    }
}
