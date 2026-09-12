package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zznv extends zzni {
    private final zznx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznv(zznx zznxVar, int i11) {
        super(zznxVar.size(), i11);
        this.zza = zznxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzni
    protected final Object zza(int i11) {
        return this.zza.get(i11);
    }
}
