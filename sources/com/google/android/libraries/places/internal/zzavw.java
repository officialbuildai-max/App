package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzavw extends zzawg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavw(int i11) {
        super(i11, null);
    }

    @Override // com.google.android.libraries.places.internal.zzawg
    public final void zza() {
        if (!zzj()) {
            for (int i11 = 0; i11 < zzb(); i11++) {
                Map.Entry zzg = zzg(i11);
                if (((zzatj) zzg.getKey()).zzg()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzatj) entry.getKey()).zzg()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
