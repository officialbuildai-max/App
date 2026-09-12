package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbrx extends zzbjg implements zzbsp {
    final /* synthetic */ zzbry zza;
    private final int zzb;
    private final Object zzc;
    private List zzd;
    private final zzbwb zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private final zzbrk zzk;
    private final zzbsu zzl;
    private final zzbsf zzm;
    private boolean zzn;
    private final zzbvs zzo;
    private zzbsq zzp;
    private int zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbrx(zzbry zzbryVar, int i11, zzbqo zzbqoVar, Object obj, zzbrk zzbrkVar, zzbsu zzbsuVar, zzbsf zzbsfVar, int i12, String str, zzayj zzayjVar) {
        super(i11, zzbqoVar, zzbry.zzB(zzbryVar), zzayjVar);
        this.zza = zzbryVar;
        this.zze = new zzbwb();
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzn = true;
        this.zzq = -1;
        this.zzc = obj;
        this.zzk = zzbrkVar;
        this.zzl = zzbsuVar;
        this.zzm = zzbsfVar;
        this.zzi = i12;
        this.zzj = i12;
        this.zzb = i12;
        this.zzo = zzbvr.zzb(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzL(zzbrx zzbrxVar, zzbwb zzbwbVar, boolean z10, boolean z11) {
        if (zzbrxVar.zzh) {
            return;
        }
        if (!zzbrxVar.zzn) {
            zzmt.zzp(zzbrxVar.zzq != -1, "streamId should be set");
            zzbrxVar.zzl.zze(z10, zzbrxVar.zzp, zzbwbVar, z11);
        } else {
            zzbrxVar.zze.zzn(zzbwbVar, (int) zzbwbVar.zzg());
            zzbrxVar.zzf |= z10;
            zzbrxVar.zzg |= z11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzM(zzbrx zzbrxVar, zzbcf zzbcfVar, String str) {
        zzbry zzbryVar = zzbrxVar.zza;
        String zzE = zzbry.zzE(zzbryVar);
        String zzF = zzbry.zzF(zzbryVar);
        boolean zzT = zzbrxVar.zzm.zzT();
        zzmt.zzc(zzbcfVar, "headers");
        zzmt.zzc(zzE, "authority");
        zzbcfVar.zzd(zzbjd.zzh);
        zzbcfVar.zzd(zzbjd.zzi);
        zzbca zzbcaVar = zzbjd.zzj;
        zzbcfVar.zzd(zzbcaVar);
        ArrayList arrayList = new ArrayList(zzbar.zza(zzbcfVar) + 7);
        if (zzT) {
            arrayList.add(zzbrm.zzb);
        } else {
            arrayList.add(zzbrm.zza);
        }
        arrayList.add(zzbrm.zzc);
        zzbwf zzbwfVar = zzbtt.zze;
        zzbwe zzbweVar = zzbwf.zza;
        arrayList.add(new zzbtt(zzbwfVar, zzbwe.zza(zzE)));
        arrayList.add(new zzbtt(zzbtt.zzc, zzbwe.zza(str)));
        arrayList.add(new zzbtt(zzbcaVar.zzd(), zzF));
        arrayList.add(zzbrm.zze);
        arrayList.add(zzbrm.zzf);
        byte[][] zza = zzbqu.zza(zzbcfVar);
        for (int i11 = 0; i11 < zza.length; i11 += 2) {
            zzbwf zzb = zzbwe.zzb(zza[i11]);
            if (zzb.zzn().length != 0 && zzb.zzn()[0] != 58) {
                arrayList.add(new zzbtt(zzb, zzbwe.zzb(zza[i11 + 1])));
            }
        }
        zzbrxVar.zzd = arrayList;
        zzbrxVar.zzm.zzR(zzbrxVar.zza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzQ(zzbdo zzbdoVar, boolean z10, zzbcf zzbcfVar) {
        if (this.zzh) {
            return;
        }
        this.zzh = true;
        if (!this.zzn) {
            this.zzm.zzP(this.zzq, zzbdoVar, zzbfs.PROCESSED, z10, zzbtp.CANCEL, zzbcfVar);
            return;
        }
        this.zzm.zzQ(this.zza);
        this.zzd = null;
        zzbwb zzbwbVar = this.zze;
        zzbwbVar.zzF(zzbwbVar.zzg());
        this.zzn = false;
        if (zzbcfVar == null) {
            zzbcfVar = new zzbcf();
        }
        zzj(zzbdoVar, zzbfs.PROCESSED, true, zzbcfVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbjg
    protected final void zzA(zzbdo zzbdoVar, boolean z10, zzbcf zzbcfVar) {
        zzQ(zzbdoVar, false, zzbcfVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbmm
    public final void zzE(int i11) {
        int i12 = this.zzj - i11;
        this.zzj = i12;
        int i13 = this.zzb;
        if (i12 <= i13 * 0.5f) {
            int i14 = i13 - i12;
            this.zzi += i14;
            this.zzj = i12 + i14;
            this.zzk.zzk(this.zzq, i14);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmm
    public final void zzF(Throwable th2) {
        zzQ(zzbdo.zze(th2), true, new zzbcf());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzG() {
        return this.zzq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbsq zzH() {
        zzbsq zzbsqVar;
        synchronized (this.zzc) {
            zzbsqVar = this.zzp;
        }
        return zzbsqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbvs zzI() {
        return this.zzo;
    }

    public final void zzN(int i11) {
        zzmt.zzq(this.zzq == -1, "the stream has been started with id %s", i11);
        this.zzq = i11;
        this.zzp = this.zzl.zzc(this, i11);
        zzbrx zzC = zzbry.zzC(this.zza);
        super.zzt();
        zzC.zzm().zzb();
        if (this.zzn) {
            this.zzk.zzj(false, false, this.zzq, 0, this.zzd);
            zzbry.zzz(this.zza).zzd();
            this.zzd = null;
            if (this.zze.zzg() > 0) {
                this.zzl.zze(this.zzf, this.zzp, this.zze, this.zzg);
            }
            this.zzn = false;
        }
    }

    public final void zzO(zzbwb zzbwbVar, boolean z10, int i11) {
        int zzg = this.zzi - (((int) zzbwbVar.zzg()) + i11);
        this.zzi = zzg;
        this.zzj -= i11;
        if (zzg >= 0) {
            super.zzB(new zzbsl(zzbwbVar), z10);
        } else {
            this.zzk.zzc(this.zzq, zzbtp.FLOW_CONTROL_ERROR);
            this.zzm.zzP(this.zzq, zzbdo.zzo.zzg("Received data size exceeded our receiving window size"), zzbfs.PROCESSED, false, null, null);
        }
    }

    public final void zzP(List list, boolean z10) {
        if (z10) {
            zzD(zzbsv.zzb(list));
        } else {
            zzC(zzbsv.zza(list));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbee, com.google.android.libraries.places.internal.zzbmm
    public final void zze(boolean z10) {
        if (zzk()) {
            this.zzm.zzP(this.zzq, null, zzbfs.PROCESSED, false, null, null);
        } else {
            this.zzm.zzP(this.zzq, null, zzbfs.PROCESSED, false, zzbtp.CANCEL, null);
        }
        super.zze(z10);
    }

    @Override // com.google.android.libraries.places.internal.zzbel
    public final void zzz(Runnable runnable) {
        synchronized (this.zzc) {
            runnable.run();
        }
    }
}
