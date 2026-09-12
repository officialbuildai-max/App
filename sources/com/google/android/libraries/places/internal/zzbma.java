package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzbma extends zzbbr implements zzbao {
    static final Logger zza = Logger.getLogger(zzbma.class.getName());
    static final Pattern zzb = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");
    static final zzbdo zzc;
    static final zzbdo zzd;
    static final zzbdo zze;
    private static final zzbmj zzh;
    private static final zzbam zzi;
    private static final zzayo zzj;
    private final long zzA;
    private final zzbgh zzB;
    private final zzayk zzC;
    private final List zzD;
    private zzbcv zzE;
    private boolean zzF;
    private zzblg zzG;
    private volatile zzbbk zzH;
    private boolean zzI;
    private final Set zzJ;
    private Collection zzK;
    private final Object zzL;
    private final Set zzM;
    private final zzbhg zzN;
    private final zzblz zzO;
    private final AtomicBoolean zzP;
    private boolean zzQ;
    private volatile boolean zzR;
    private final CountDownLatch zzS;
    private final zzbff zzT;
    private final zzbfg zzU;
    private final zzbfi zzV;
    private final zzaym zzW;
    private final zzbah zzX;
    private final zzbls zzY;
    private zzbmj zzZ;
    private boolean zzaa;
    private final boolean zzab;
    private final zzbox zzac;
    private final long zzad;
    private final long zzae;
    private final boolean zzaf;
    private final zzazm zzag;
    private final zzbmk zzah;
    private final zzbkt zzai;
    private final zzboe zzaj;
    private int zzak;
    private final zzbqn zzal;
    private final zzbqn zzam;
    private final zzbij zzan;
    final zzbdw zzf;
    final zzbji zzg;
    private final zzbap zzk;
    private final String zzl;
    private final zzbdb zzm;
    private final zzbco zzn;
    private final zzbey zzo;
    private final zzbfw zzp;
    private final zzbfw zzq;
    private final zzbfw zzr;
    private final zzblu zzs;
    private final Executor zzt;
    private final zzbky zzu;
    private final zzbky zzv;
    private final zzbqt zzw;
    private final zzazq zzx;
    private final zzazd zzy;
    private final zznc zzz;

    static {
        zzbdo zzbdoVar = zzbdo.zzp;
        zzc = zzbdoVar.zzg("Channel shutdownNow invoked");
        zzd = zzbdoVar.zzg("Channel shutdown invoked");
        zze = zzbdoVar.zzg("Subchannel shutdown invoked");
        zzh = new zzbmj(null, new HashMap(), new HashMap(), null, null, null);
        zzi = new zzbkl();
        zzj = new zzbkp();
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [java.util.concurrent.Executor, java.lang.Object] */
    public zzbma(zzbmd zzbmdVar, zzbfw zzbfwVar, zzbij zzbijVar, zzbqn zzbqnVar, zznc zzncVar, List list, zzbqt zzbqtVar) {
        zzbdw zzbdwVar = new zzbdw(new zzbko(this));
        this.zzf = zzbdwVar;
        this.zzB = new zzbgh();
        this.zzJ = new HashSet(16, 0.75f);
        this.zzL = new Object();
        this.zzM = new HashSet(1, 0.75f);
        this.zzO = new zzblz(this, null);
        this.zzP = new AtomicBoolean(false);
        this.zzS = new CountDownLatch(1);
        this.zzak = 1;
        this.zzZ = zzh;
        this.zzaa = false;
        this.zzac = new zzbox();
        this.zzag = zzazn.zzc();
        zzbkx zzbkxVar = new zzbkx(this, null);
        this.zzah = zzbkxVar;
        this.zzg = new zzbla(this, null);
        this.zzai = new zzbkt(this, null);
        String str = zzbmdVar.zze;
        this.zzl = str;
        zzbap zzc2 = zzbap.zzc("Channel", str);
        this.zzk = zzc2;
        this.zzw = zzbqtVar;
        zzbqn zzbqnVar2 = zzbmdVar.zzk;
        zzmt.zzc(zzbqnVar2, "executorPool");
        this.zzal = zzbqnVar2;
        ?? zzb2 = zzbqnVar2.zzb();
        zzmt.zzc(zzb2, "executor");
        this.zzt = zzb2;
        this.zzp = zzbfwVar;
        zzbqn zzbqnVar3 = zzbmdVar.zzl;
        zzmt.zzc(zzbqnVar3, "offloadExecutorPool");
        zzbky zzbkyVar = new zzbky(zzbqnVar3);
        this.zzv = zzbkyVar;
        zzbfd zzbfdVar = new zzbfd(zzbfwVar, null, zzbkyVar);
        this.zzq = zzbfdVar;
        this.zzr = new zzbfd(zzbfwVar, null, zzbkyVar);
        zzblu zzbluVar = new zzblu(zzbfdVar.zzb(), null);
        this.zzs = zzbluVar;
        zzbfi zzbfiVar = new zzbfi(zzc2, 0, zzbqtVar.zza(), "Channel for '" + str + "'");
        this.zzV = zzbfiVar;
        zzbfh zzbfhVar = new zzbfh(zzbfiVar, zzbqtVar);
        this.zzW = zzbfhVar;
        zzbde zzbdeVar = zzbjd.zzm;
        this.zzaf = true;
        zzbey zzbeyVar = new zzbey(zzbbq.zzb(), zzbmdVar.zzf);
        this.zzo = zzbeyVar;
        zzbdb zzbdbVar = zzbmdVar.zzc;
        this.zzm = zzbdbVar;
        zzbpw zzbpwVar = new zzbpw(true, 5, 5, zzbeyVar);
        zzbcm zzb3 = zzbco.zzb();
        zzbmdVar.zzb();
        zzb3.zzb(443);
        zzb3.zzd(zzbdeVar);
        zzb3.zzg(zzbdwVar);
        zzb3.zze(zzbluVar);
        zzb3.zzf(zzbpwVar);
        zzb3.zza(zzbfhVar);
        zzb3.zzc(zzbkyVar);
        zzbco zzh2 = zzb3.zzh();
        this.zzn = zzh2;
        this.zzE = zzo(str, null, zzbdbVar, zzh2, Collections.singleton(InetSocketAddress.class));
        this.zzam = zzbqnVar;
        this.zzu = new zzbky(zzbqnVar);
        zzbhg zzbhgVar = new zzbhg(zzb2, zzbdwVar);
        this.zzN = zzbhgVar;
        zzbhgVar.zzj(zzbkxVar);
        this.zzan = zzbijVar;
        this.zzab = true;
        zzbls zzblsVar = new zzbls(this, this.zzE.zza(), null);
        this.zzY = zzblsVar;
        this.zzC = zzayt.zza(zzblsVar, list);
        this.zzD = new ArrayList(zzbmdVar.zzd);
        zzmt.zzc(zzncVar, "stopwatchSupplier");
        this.zzz = zzncVar;
        long j11 = zzbmdVar.zzi;
        if (j11 == -1) {
            this.zzA = -1L;
        } else {
            zzmt.zzi(j11 >= zzbmd.zzb, "invalid idleTimeoutMillis %s", j11);
            this.zzA = zzbmdVar.zzi;
        }
        this.zzaj = new zzboe(new zzblc(this, null), zzbdwVar, zzbfdVar.zzb(), zzna.zzb());
        zzazq zzazqVar = zzbmdVar.zzg;
        zzmt.zzc(zzazqVar, "decompressorRegistry");
        this.zzx = zzazqVar;
        zzazd zzazdVar = zzbmdVar.zzh;
        zzmt.zzc(zzazdVar, "compressorRegistry");
        this.zzy = zzazdVar;
        this.zzae = 16777216L;
        this.zzad = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        zzbkm zzbkmVar = new zzbkm(this, zzbqtVar);
        this.zzT = zzbkmVar;
        this.zzU = zzbkmVar.zza();
        zzbah zzbahVar = zzbmdVar.zzj;
        zzbahVar.getClass();
        this.zzX = zzbahVar;
        zzbahVar.zzd(this);
    }

    public static /* bridge */ /* synthetic */ Executor zzJ(zzbma zzbmaVar, zzayj zzayjVar) {
        Executor zzn = zzayjVar.zzn();
        return zzn == null ? zzbmaVar.zzt : zzn;
    }

    public static /* bridge */ /* synthetic */ void zzP(zzbma zzbmaVar) {
        zzbmaVar.zzah(true);
        zzbmaVar.zzN.zzm(null);
        zzbmaVar.zzW.zza(2, "Entering IDLE state");
        zzbmaVar.zzB.zza(zzaze.IDLE);
        if (zzbmaVar.zzg.zzd(zzbmaVar.zzL, zzbmaVar.zzN)) {
            zzbmaVar.zzV();
        }
    }

    public static /* bridge */ /* synthetic */ void zzQ(zzbma zzbmaVar) {
        if (!zzbmaVar.zzR && zzbmaVar.zzP.get() && zzbmaVar.zzJ.isEmpty() && zzbmaVar.zzM.isEmpty()) {
            zzbmaVar.zzW.zza(2, "Terminated");
            zzbmaVar.zzX.zzg(zzbmaVar);
            zzbmaVar.zzal.zzc(zzbmaVar.zzt);
            zzbmaVar.zzu.zzb();
            zzbmaVar.zzv.zzb();
            zzbmaVar.zzq.close();
            zzbmaVar.zzR = true;
            zzbmaVar.zzS.countDown();
        }
    }

    public static /* bridge */ /* synthetic */ void zzR(zzbma zzbmaVar) {
        zzbmaVar.zzf.zzd();
        if (zzbmaVar.zzF) {
            zzbmaVar.zzE.zzb();
        }
    }

    private static zzbcv zzaf(String str, zzbdb zzbdbVar, zzbco zzbcoVar, Collection collection) {
        URI uri;
        StringBuilder sb2 = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e11) {
            sb2.append(e11.getMessage());
            uri = null;
        }
        zzbcw zza2 = uri != null ? zzbdbVar.zza(uri.getScheme()) : null;
        String str2 = "";
        if (zza2 == null && !zzb.matcher(str).matches()) {
            try {
                uri = new URI(zzbdbVar.zzc(), "", "/" + str, null);
                zza2 = zzbdbVar.zza(uri.getScheme());
            } catch (URISyntaxException e12) {
                throw new IllegalArgumentException(e12);
            }
        }
        if (zza2 == null) {
            if (sb2.length() > 0) {
                str2 = " (" + sb2.toString() + ")";
            }
            throw new IllegalArgumentException(String.format("Could not find a NameResolverProvider for %s%s", str, str2));
        }
        if (collection != null && !collection.containsAll(zza2.zzd())) {
            throw new IllegalArgumentException(String.format("Address types of NameResolver '%s' for '%s' not supported by transport", uri.getScheme(), str));
        }
        zzbcv zza3 = zza2.zza(uri, zzbcoVar);
        if (zza3 != null) {
            return zza3;
        }
        if (sb2.length() > 0) {
            str2 = " (" + sb2.toString() + ")";
        }
        throw new IllegalArgumentException(String.format("cannot create a NameResolver for %s%s", str, str2));
    }

    public final void zzag() {
        long j11 = this.zzA;
        if (j11 == -1) {
            return;
        }
        this.zzaj.zzi(j11, TimeUnit.MILLISECONDS);
    }

    public final void zzah(boolean z10) {
        this.zzf.zzd();
        if (z10) {
            zzmt.zzp(this.zzF, "nameResolver is not started");
            zzmt.zzp(this.zzG != null, "lbHelper is null");
        }
        zzbcv zzbcvVar = this.zzE;
        if (zzbcvVar != null) {
            zzbcvVar.zzc();
            this.zzF = false;
            if (z10) {
                this.zzE = zzo(this.zzl, null, this.zzm, this.zzn, Collections.singleton(InetSocketAddress.class));
            } else {
                this.zzE = null;
            }
        }
        zzblg zzblgVar = this.zzG;
        if (zzblgVar != null) {
            zzblgVar.zza.zzc();
            this.zzG = null;
        }
        this.zzH = null;
    }

    public final void zzai(zzbbk zzbbkVar) {
        this.zzH = zzbbkVar;
        this.zzN.zzm(zzbbkVar);
    }

    static zzbcv zzo(String str, String str2, zzbdb zzbdbVar, zzbco zzbcoVar, Collection collection) {
        return new zzbpv(zzaf(str, zzbdbVar, zzbcoVar, collection), new zzbfa(new zzbij(), zzbcoVar.zzg(), zzbcoVar.zze()), zzbcoVar.zze());
    }

    public final String toString() {
        zzmm zzb2 = zzmn.zzb(this);
        zzb2.zzc("logId", this.zzk.zza());
        zzb2.zzd("target", this.zzl);
        return zzb2.toString();
    }

    public final void zzV() {
        this.zzf.zzd();
        if (this.zzP.get() || this.zzI) {
            return;
        }
        if (this.zzg.zze()) {
            this.zzaj.zzh(false);
        } else {
            zzag();
        }
        if (this.zzG == null) {
            this.zzW.zza(2, "Exiting idle mode");
            zzblg zzblgVar = new zzblg(this, null);
            zzblgVar.zza = new zzbeq(this.zzo, zzblgVar);
            this.zzG = zzblgVar;
            this.zzB.zza(zzaze.CONNECTING);
            this.zzE.zzd(new zzblj(this, zzblgVar, this.zzE));
            this.zzF = true;
        }
    }

    public final void zzW(Throwable th2) {
        if (this.zzI) {
            return;
        }
        this.zzI = true;
        this.zzaj.zzh(true);
        zzah(false);
        zzai(new zzbkn(this, th2));
        this.zzY.zzg(null);
        this.zzW.zza(4, "PANIC! Entering TRANSIENT_FAILURE");
        this.zzB.zza(zzaze.TRANSIENT_FAILURE);
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final zzayo zza(zzbcl zzbclVar, zzayj zzayjVar) {
        return this.zzC.zza(zzbclVar, zzayjVar);
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final String zzb() {
        return this.zzC.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbau
    public final zzbap zzc() {
        return this.zzk;
    }
}
