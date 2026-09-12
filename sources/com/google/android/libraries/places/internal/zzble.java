package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzble implements Runnable {
    final /* synthetic */ zzbbk zza;
    final /* synthetic */ zzaze zzb;
    final /* synthetic */ zzblg zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzble(zzblg zzblgVar, zzbbk zzbbkVar, zzaze zzazeVar) {
        this.zza = zzbbkVar;
        this.zzb = zzazeVar;
        this.zzc = zzblgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzblg zzblgVar;
        zzaym zzaymVar;
        zzbgh zzbghVar;
        zzblg zzblgVar2 = this.zzc;
        zzbma zzbmaVar = zzblgVar2.zzb;
        zzblgVar = zzbmaVar.zzG;
        if (zzblgVar2 != zzblgVar) {
            return;
        }
        zzbmaVar.zzai(this.zza);
        zzaze zzazeVar = this.zzb;
        if (zzazeVar != zzaze.SHUTDOWN) {
            zzaymVar = this.zzc.zzb.zzW;
            zzaymVar.zzb(2, "Entering {0} state with picker: {1}", zzazeVar, this.zza);
            zzblg zzblgVar3 = this.zzc;
            zzaze zzazeVar2 = this.zzb;
            zzbghVar = zzblgVar3.zzb.zzB;
            zzbghVar.zza(zzazeVar2);
        }
    }
}
