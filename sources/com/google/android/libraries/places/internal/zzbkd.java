package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbkd implements zzbao, zzbqv {
    private final zzbap zza;
    private final String zzb;
    private final zzbjw zzc;
    private final zzbfw zzd;
    private final ScheduledExecutorService zze;
    private final zzbah zzf;
    private final zzbfg zzg;
    private final zzbfi zzh;
    private final zzaym zzi;
    private final List zzj;
    private final zzbdw zzk;
    private final zzbjx zzl;
    private volatile List zzm;
    private final zzna zzn;
    private zzbdv zzo;
    private zzbdv zzp;
    private zzbml zzq;
    private zzbgf zzt;
    private volatile zzbml zzu;
    private zzbdo zzw;
    private final zzbij zzx;
    private zzbik zzy;
    private final Collection zzr = new ArrayList();
    private final zzbji zzs = new zzbjk(this);
    private volatile zzazf zzv = zzazf.zzb(zzaze.IDLE);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkd(List list, String str, String str2, zzbij zzbijVar, zzbfw zzbfwVar, ScheduledExecutorService scheduledExecutorService, zznc zzncVar, zzbdw zzbdwVar, zzbjw zzbjwVar, zzbah zzbahVar, zzbfg zzbfgVar, zzbfi zzbfiVar, zzbap zzbapVar, zzaym zzaymVar, List list2) {
        zzmt.zzf(!list.isEmpty(), "addressGroups is empty");
        zzI(list, "addressGroups contains null entry");
        List unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.zzm = unmodifiableList;
        this.zzl = new zzbjx(unmodifiableList);
        this.zzb = str;
        this.zzx = zzbijVar;
        this.zzd = zzbfwVar;
        this.zze = scheduledExecutorService;
        this.zzn = zzna.zzb();
        this.zzk = zzbdwVar;
        this.zzc = zzbjwVar;
        this.zzf = zzbahVar;
        this.zzg = zzbfgVar;
        this.zzh = zzbfiVar;
        this.zza = zzbapVar;
        this.zzi = zzaymVar;
        this.zzj = list2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzA(zzbkd zzbkdVar, zzaze zzazeVar) {
        zzbkdVar.zzk.zzd();
        zzbkdVar.zzJ(zzazf.zzb(zzazeVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzB(zzbkd zzbkdVar) {
        zzbjq zzbjqVar = new zzbjq(zzbkdVar);
        zzbdw zzbdwVar = zzbkdVar.zzk;
        zzbdwVar.zzc(zzbjqVar);
        zzbdwVar.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzC(zzbkd zzbkdVar, zzbgf zzbgfVar, boolean z10) {
        zzbjr zzbjrVar = new zzbjr(zzbkdVar, zzbgfVar, z10);
        zzbdw zzbdwVar = zzbkdVar.zzk;
        zzbdwVar.zzc(zzbjrVar);
        zzbdwVar.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzD(zzbkd zzbkdVar, zzbdo zzbdoVar) {
        zzbkdVar.zzk.zzd();
        zzbkdVar.zzJ(zzazf.zzc(zzbdoVar));
        if (zzbkdVar.zzy == null) {
            zzbkdVar.zzy = new zzbik();
        }
        long zza = zzbkdVar.zzy.zza();
        zzna zznaVar = zzbkdVar.zzn;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long zza2 = zza - zznaVar.zza(timeUnit);
        zzbkdVar.zzi.zzb(2, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", zzK(zzbdoVar), Long.valueOf(zza2));
        zzmt.zzp(zzbkdVar.zzo == null, "previous reconnectTask is not done");
        zzbkdVar.zzo = zzbkdVar.zzk.zza(new zzbjl(zzbkdVar), zza2, timeUnit, zzbkdVar.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzE(zzbkd zzbkdVar) {
        zzbaa zzbaaVar;
        zzbkdVar.zzk.zzd();
        zzmt.zzp(zzbkdVar.zzo == null, "Should have no reconnectTask scheduled");
        if (zzbkdVar.zzl.zzf()) {
            zzna zznaVar = zzbkdVar.zzn;
            zznaVar.zzc();
            zznaVar.zzd();
        }
        SocketAddress zzb = zzbkdVar.zzl.zzb();
        zzbju zzbjuVar = null;
        if (zzb instanceof zzbaa) {
            zzbaa zzbaaVar2 = (zzbaa) zzb;
            zzbaaVar = zzbaaVar2;
            zzb = zzbaaVar2.zzd();
        } else {
            zzbaaVar = null;
        }
        zzaye zza = zzbkdVar.zzl.zza();
        String str = (String) zza.zzc(zzazs.zza);
        zzbfv zzbfvVar = new zzbfv();
        if (str == null) {
            str = zzbkdVar.zzb;
        }
        zzbfvVar.zzc(str);
        zzbfvVar.zzd(zza);
        zzbfvVar.zzf(null);
        zzbfvVar.zze(zzbaaVar);
        zzbkc zzbkcVar = new zzbkc();
        zzbkcVar.zza = zzbkdVar.zza;
        zzbjv zzbjvVar = new zzbjv(zzbkdVar.zzd.zza(zzb, zzbfvVar, zzbkcVar), zzbkdVar.zzg, zzbjuVar);
        zzbkcVar.zza = zzbjvVar.zzc();
        zzbkdVar.zzf.zzc(zzbjvVar);
        zzbkdVar.zzt = zzbjvVar;
        zzbkdVar.zzr.add(zzbjvVar);
        zzbjvVar.zzj(new zzbkb(zzbkdVar, zzbjvVar));
        zzbkdVar.zzi.zzb(2, "Started transport {0}", zzbkcVar.zza);
    }

    private static void zzI(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzmt.zzc(it.next(), str);
        }
    }

    private final void zzJ(zzazf zzazfVar) {
        this.zzk.zzd();
        if (this.zzv.zza() != zzazfVar.zza()) {
            zzmt.zzp(this.zzv.zza() != zzaze.SHUTDOWN, "Cannot transition out of SHUTDOWN to ".concat(zzazfVar.toString()));
            this.zzv = zzazfVar;
            ((zzblv) this.zzc).zza.zza(zzazfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String zzK(zzbdo zzbdoVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(zzbdoVar.zza());
        if (zzbdoVar.zzi() != null) {
            sb2.append("(");
            sb2.append(zzbdoVar.zzi());
            sb2.append(")");
        }
        if (zzbdoVar.zzj() != null) {
            sb2.append("[");
            sb2.append(zzbdoVar.zzj());
            sb2.append("]");
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzz(zzbkd zzbkdVar) {
        zzbkdVar.zzk.zzd();
        zzbdv zzbdvVar = zzbkdVar.zzo;
        if (zzbdvVar != null) {
            zzbdvVar.zza();
            zzbkdVar.zzo = null;
            zzbkdVar.zzy = null;
        }
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzc("logId", this.zza.zza());
        zzb.zzd("addressGroups", this.zzm);
        return zzb.toString();
    }

    public final void zzF(zzbdo zzbdoVar) {
        zzbjp zzbjpVar = new zzbjp(this, zzbdoVar);
        zzbdw zzbdwVar = this.zzk;
        zzbdwVar.zzc(zzbjpVar);
        zzbdwVar.zzb();
    }

    public final void zzG(List list) {
        zzmt.zzc(list, "newAddressGroups");
        zzI(list, "newAddressGroups contains null entry");
        zzmt.zzf(!list.isEmpty(), "newAddressGroups is empty");
        zzbjo zzbjoVar = new zzbjo(this, Collections.unmodifiableList(new ArrayList(list)));
        zzbdw zzbdwVar = this.zzk;
        zzbdwVar.zzc(zzbjoVar);
        zzbdwVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbau
    public final zzbap zzc() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzbqv
    public final zzbfu zzh() {
        zzbml zzbmlVar = this.zzu;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        zzbdw zzbdwVar = this.zzk;
        zzbdwVar.zzc(new zzbjm(this));
        zzbdwVar.zzb();
        return null;
    }
}
