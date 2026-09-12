package com.google.android.gms.internal.play_billing;

/* loaded from: classes4.dex */
final class zzfo extends zzfq {
    private zzfo() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfo(zzfn zzfnVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzfq
    public final void zza(Object obj, long j11) {
        ((zzfc) zzhn.zzf(obj, j11)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzfq
    public final void zzb(Object obj, Object obj2, long j11) {
        zzfc zzfcVar = (zzfc) zzhn.zzf(obj, j11);
        zzfc zzfcVar2 = (zzfc) zzhn.zzf(obj2, j11);
        int size = zzfcVar.size();
        int size2 = zzfcVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzfcVar.zzc()) {
                zzfcVar = zzfcVar.zzd(size2 + size);
            }
            zzfcVar.addAll(zzfcVar2);
        }
        if (size > 0) {
            zzfcVar2 = zzfcVar;
        }
        zzhn.zzs(obj, j11, zzfcVar2);
    }
}
