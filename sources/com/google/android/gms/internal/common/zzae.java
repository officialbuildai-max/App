package com.google.android.gms.internal.common;

/* loaded from: classes4.dex */
final class zzae extends zzz {
    private final zzag zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(zzag zzagVar, int i11) {
        super(zzagVar.size(), i11);
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    protected final Object zza(int i11) {
        return this.zza.get(i11);
    }
}
