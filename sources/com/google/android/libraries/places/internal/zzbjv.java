package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbjv extends zzbip {
    private final zzbgf zza;
    private final zzbfg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbjv(zzbgf zzbgfVar, zzbfg zzbfgVar, zzbju zzbjuVar) {
        this.zza = zzbgfVar;
        this.zzb = zzbfgVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbip, com.google.android.libraries.places.internal.zzbfu
    public final zzbfr zza(zzbcl zzbclVar, zzbcf zzbcfVar, zzayj zzayjVar, zzayx[] zzayxVarArr) {
        return new zzbjt(this, this.zza.zza(zzbclVar, zzbcfVar, zzayjVar, zzayxVarArr));
    }

    @Override // com.google.android.libraries.places.internal.zzbip
    protected final zzbgf zzb() {
        return this.zza;
    }
}
