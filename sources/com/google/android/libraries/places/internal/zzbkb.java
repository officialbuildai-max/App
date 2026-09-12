package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbkb implements zzbmk {
    final zzbgf zza;
    boolean zzb = false;
    final /* synthetic */ zzbkd zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkb(zzbkd zzbkdVar, zzbgf zzbgfVar) {
        this.zzc = zzbkdVar;
        this.zza = zzbgfVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbmk
    public final zzaye zza(zzaye zzayeVar) {
        List list;
        list = this.zzc.zzj;
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return zzayeVar;
        }
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbmk
    public final void zzb(boolean z10) {
        zzbkd.zzC(this.zzc, this.zza, z10);
    }

    @Override // com.google.android.libraries.places.internal.zzbmk
    public final void zzc() {
        zzaym zzaymVar;
        zzbdw zzbdwVar;
        zzaymVar = this.zzc.zzi;
        zzaymVar.zza(2, "READY");
        zzbdwVar = this.zzc.zzk;
        zzbdwVar.zzc(new zzbjy(this));
        zzbdwVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbmk
    public final void zzd(zzbdo zzbdoVar) {
        zzaym zzaymVar;
        String zzK;
        zzbdw zzbdwVar;
        zzaymVar = this.zzc.zzi;
        zzbap zzc = this.zza.zzc();
        zzbkd zzbkdVar = this.zzc;
        zzK = zzbkd.zzK(zzbdoVar);
        zzaymVar.zzb(2, "{0} SHUTDOWN with {1}", zzc, zzK);
        this.zzb = true;
        zzbdwVar = this.zzc.zzk;
        zzbdwVar.zzc(new zzbjz(this, zzbdoVar));
        zzbdwVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbmk
    public final void zze() {
        zzaym zzaymVar;
        zzbah zzbahVar;
        List list;
        zzbdw zzbdwVar;
        zzmt.zzp(this.zzb, "transportShutdown() must be called before transportTerminated().");
        zzaymVar = this.zzc.zzi;
        zzaymVar.zzb(2, "{0} Terminated", this.zza.zzc());
        zzbahVar = this.zzc.zzf;
        zzbahVar.zzf(this.zza);
        zzbkd.zzC(this.zzc, this.zza, false);
        list = this.zzc.zzj;
        Iterator it = list.iterator();
        if (it.hasNext()) {
            this.zza.zze();
            throw null;
        }
        zzbdwVar = this.zzc.zzk;
        zzbdwVar.zzc(new zzbka(this));
        zzbdwVar.zzb();
    }
}
