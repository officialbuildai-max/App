package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzhe extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhe(zzhc zzhcVar, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        zzhj.zzc();
    }
}
