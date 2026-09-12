package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbus extends zzajp {
    private final zzayo zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbus(zzayo zzayoVar) {
        this.zzc = zzayoVar;
    }

    @Override // com.google.android.libraries.places.internal.zzajp
    protected final String zze() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("clientCall", this.zzc);
        return zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzajp
    protected final void zzk() {
        this.zzc.zza("GrpcFuture was cancelled", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.places.internal.zzajp
    public final boolean zzl(Object obj) {
        return super.zzl(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.places.internal.zzajp
    public final boolean zzm(Throwable th2) {
        return super.zzm(th2);
    }
}
