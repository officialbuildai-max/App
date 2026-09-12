package com.google.android.gms.measurement.internal;

import androidx.collection.z;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzho extends z {
    private final /* synthetic */ zzhl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzho(zzhl zzhlVar, int i11) {
        super(20);
        this.zza = zzhlVar;
    }

    @Override // androidx.collection.z
    protected final /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzhl.zza(this.zza, str);
    }
}
