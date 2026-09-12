package com.google.android.gms.internal.identity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzev extends zzet {
    private final zzex zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzev(zzex zzexVar, int i11) {
        super(zzexVar.size(), i11);
        this.zza = zzexVar;
    }

    @Override // com.google.android.gms.internal.identity.zzet
    protected final Object zza(int i11) {
        return this.zza.get(i11);
    }
}
