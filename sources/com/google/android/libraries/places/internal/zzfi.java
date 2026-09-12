package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationToken;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class zzfi {
    private final zzjt zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzfi(zzjt zzjtVar) {
        this.zza = zzjtVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final CancellationToken zza() {
        return this.zza.getCancellationToken();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzjt zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String zzc();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map zzd();
}
