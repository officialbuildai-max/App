package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: classes3.dex */
final class zzaf extends zzah {
    final /* synthetic */ zzag zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzag zzagVar) {
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void zzc(boolean z10) {
        this.zza.setResult((zzag) new zzak(z10 ? Status.RESULT_SUCCESS : zzal.zza));
    }
}
