package com.google.android.gms.internal.fido;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzar extends zzao {
    private final zzat zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzat zzatVar, int i11) {
        super(zzatVar.size(), i11);
        this.zza = zzatVar;
    }

    @Override // com.google.android.gms.internal.fido.zzao
    protected final Object zza(int i11) {
        return this.zza.get(i11);
    }
}
