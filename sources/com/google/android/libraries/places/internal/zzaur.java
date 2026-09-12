package com.google.android.libraries.places.internal;

import java.util.List;

/* loaded from: classes4.dex */
final class zzaur extends zzaut {
    private zzaur() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaur(zzauq zzauqVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzaut
    public final List zza(Object obj, long j11) {
        zzauc zzaucVar = (zzauc) zzawx.zzf(obj, j11);
        if (zzaucVar.zzc()) {
            return zzaucVar;
        }
        int size = zzaucVar.size();
        zzauc zzd = zzaucVar.zzd(size == 0 ? 10 : size + size);
        zzawx.zzs(obj, j11, zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzaut
    public final void zzb(Object obj, long j11) {
        ((zzauc) zzawx.zzf(obj, j11)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzaut
    public final void zzc(Object obj, Object obj2, long j11) {
        zzauc zzaucVar = (zzauc) zzawx.zzf(obj, j11);
        zzauc zzaucVar2 = (zzauc) zzawx.zzf(obj2, j11);
        int size = zzaucVar.size();
        int size2 = zzaucVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzaucVar.zzc()) {
                zzaucVar = zzaucVar.zzd(size2 + size);
            }
            zzaucVar.addAll(zzaucVar2);
        }
        if (size > 0) {
            zzaucVar2 = zzaucVar;
        }
        zzawx.zzs(obj, j11, zzaucVar2);
    }
}
