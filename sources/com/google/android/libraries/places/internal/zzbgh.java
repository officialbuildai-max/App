package com.google.android.libraries.places.internal;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbgh {
    private ArrayList zza = new ArrayList();
    private volatile zzaze zzb = zzaze.IDLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzaze zzazeVar) {
        zzmt.zzc(zzazeVar, "newState");
        if (this.zzb == zzazeVar || this.zzb == zzaze.SHUTDOWN) {
            return;
        }
        this.zzb = zzazeVar;
        if (this.zza.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.zza;
        this.zza = new ArrayList();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }
}
