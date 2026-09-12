package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzays extends zzayk {
    private final zzayk zza;
    private final zzayp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzays(zzayk zzaykVar, zzayp zzaypVar, zzayr zzayrVar) {
        this.zza = zzaykVar;
        zzmt.zzc(zzaypVar, "interceptor");
        this.zzb = zzaypVar;
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final zzayo zza(zzbcl zzbclVar, zzayj zzayjVar) {
        return this.zzb.zza(zzbclVar, zzayjVar, this.zza);
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final String zzb() {
        return this.zza.zzb();
    }
}
