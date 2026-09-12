package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzbnj extends zzbbm {
    private static final Logger zzf = Logger.getLogger(zzbnj.class.getName());
    private final zzbbd zzg;
    private zzbnd zzi;
    private zzbdv zzl;
    private zzaze zzm;
    private zzaze zzn;
    private final boolean zzo;
    private final Map zzh = new HashMap();
    private int zzj = 0;
    private boolean zzk = true;

    public zzbnj(zzbbd zzbbdVar) {
        zzaze zzazeVar = zzaze.IDLE;
        this.zzm = zzazeVar;
        this.zzn = zzazeVar;
        this.zzo = zzbjd.zzj("GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS", true);
        this.zzg = zzbbdVar;
    }

    private final void zzn() {
        zzbdv zzbdvVar = this.zzl;
        if (zzbdvVar != null) {
            zzbdvVar.zza();
            this.zzl = null;
        }
    }

    private final void zzo() {
        if (this.zzo) {
            zzbdv zzbdvVar = this.zzl;
            if (zzbdvVar == null || !zzbdvVar.zzb()) {
                try {
                    zzbdw zzb = this.zzg.zzb();
                    this.zzl = zzb.zza(new zzbna(this), 250L, TimeUnit.MILLISECONDS, this.zzg.zzc());
                } catch (NullPointerException unused) {
                }
            }
        }
    }

    private final void zzp(zzaze zzazeVar, zzbbk zzbbkVar) {
        if (zzazeVar == this.zzn && (zzazeVar == zzaze.IDLE || zzazeVar == zzaze.CONNECTING)) {
            return;
        }
        this.zzn = zzazeVar;
        this.zzg.zze(zzazeVar, zzbbkVar);
    }

    public final void zzq(zzbni zzbniVar) {
        zzaze zzazeVar;
        zzaze zza;
        zzaze zza2;
        zzaze zza3;
        zzbnc zzbncVar;
        zzazf zzazfVar;
        zzbbj zzbbjVar;
        zzazeVar = zzbniVar.zzb;
        zzaze zzazeVar2 = zzaze.READY;
        if (zzazeVar != zzazeVar2) {
            return;
        }
        zza = zzbnc.zzb(zzbniVar.zzc).zza();
        if (zza == zzazeVar2) {
            zzbbjVar = zzbniVar.zza;
            zzp(zzazeVar2, new zzbbc(zzbbe.zzd(zzbbjVar, null)));
            return;
        }
        zza2 = zzbnc.zzb(zzbniVar.zzc).zza();
        zzaze zzazeVar3 = zzaze.TRANSIENT_FAILURE;
        if (zza2 == zzazeVar3) {
            zzbncVar = zzbniVar.zzc;
            zzazfVar = zzbncVar.zzb;
            zzp(zzazeVar3, new zzbnf(zzbbe.zzb(zzazfVar.zzd())));
        } else if (this.zzn != zzazeVar3) {
            zza3 = zzbnc.zzb(zzbniVar.zzc).zza();
            zzp(zza3, new zzbnf(zzbbe.zzc()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
    
        if (r3.size() == 1) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.net.SocketAddress zzr(com.google.android.libraries.places.internal.zzbbj r3) {
        /*
            com.google.android.libraries.places.internal.zzblx r3 = (com.google.android.libraries.places.internal.zzblx) r3
            com.google.android.libraries.places.internal.zzbma r0 = r3.zzj
            com.google.android.libraries.places.internal.zzbdw r0 = r0.zzf
            r0.zzd()
            boolean r0 = r3.zzg
            java.lang.String r1 = "not started"
            com.google.android.libraries.places.internal.zzmt.zzp(r0, r1)
            java.util.List r3 = r3.zze
            r0 = 0
            if (r3 == 0) goto L1d
            int r1 = r3.size()
            r2 = 1
            if (r1 != r2) goto L1d
            goto L1e
        L1d:
            r2 = r0
        L1e:
            java.lang.String r1 = "%s does not have exactly one group"
            com.google.android.libraries.places.internal.zzmt.zzr(r2, r1, r3)
            java.lang.Object r3 = r3.get(r0)
            com.google.android.libraries.places.internal.zzazs r3 = (com.google.android.libraries.places.internal.zzazs) r3
            java.util.List r3 = r3.zzb()
            java.lang.Object r3 = r3.get(r0)
            java.net.SocketAddress r3 = (java.net.SocketAddress) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbnj.zzr(com.google.android.libraries.places.internal.zzbbj):java.net.SocketAddress");
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final zzbdo zza(zzbbi zzbbiVar) {
        zzaze zzazeVar;
        Boolean bool;
        if (this.zzm == zzaze.SHUTDOWN) {
            return zzbdo.zzk.zzg("Already shut down");
        }
        List zze = zzbbiVar.zze();
        if (zze.isEmpty()) {
            zzbdo zzg = zzbdo.zzp.zzg("NameResolver returned no usable address. addrs=" + String.valueOf(zzbbiVar.zze()) + ", attrs=" + zzbbiVar.zza().toString());
            zzb(zzg);
            return zzg;
        }
        Iterator it = zze.iterator();
        while (it.hasNext()) {
            if (((zzazs) it.next()) == null) {
                zzbdo zzg2 = zzbdo.zzp.zzg("NameResolver returned address list with null endpoint. addrs=" + String.valueOf(zzbbiVar.zze()) + ", attrs=" + zzbbiVar.zza().toString());
                zzb(zzg2);
                return zzg2;
            }
        }
        this.zzk = true;
        if ((zzbbiVar.zzd() instanceof zzbne) && (bool = ((zzbne) zzbbiVar.zzd()).zza) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(zze);
            Collections.shuffle(arrayList, new Random());
            zze = arrayList;
        }
        zznu zznuVar = new zznu();
        zznuVar.zzf(zze);
        zznx zzg3 = zznuVar.zzg();
        zzbnd zzbndVar = this.zzi;
        if (zzbndVar == null) {
            this.zzi = new zzbnd(zzg3);
        } else if (this.zzm == zzaze.READY) {
            SocketAddress zzc = zzbndVar.zzc();
            this.zzi.zze(zzg3);
            if (this.zzi.zzh(zzc)) {
                zzbbj zze2 = ((zzbni) this.zzh.get(zzc)).zze();
                zzbnd zzbndVar2 = this.zzi;
                zze2.zzd(Collections.singletonList(new zzazs(Collections.singletonList(zzbndVar2.zzc()), zzbndVar2.zzb())));
                return zzbdo.zza;
            }
            this.zzi.zzd();
        } else {
            zzbndVar.zze(zzg3);
        }
        HashSet<SocketAddress> hashSet = new HashSet(this.zzh.keySet());
        HashSet hashSet2 = new HashSet();
        int size = zzg3.size();
        for (int i11 = 0; i11 < size; i11++) {
            hashSet2.addAll(((zzazs) zzg3.get(i11)).zzb());
        }
        for (SocketAddress socketAddress : hashSet) {
            if (!hashSet2.contains(socketAddress)) {
                ((zzbni) this.zzh.remove(socketAddress)).zze().zzb();
            }
        }
        if (hashSet.size() == 0 || (zzazeVar = this.zzm) == zzaze.CONNECTING || zzazeVar == zzaze.READY) {
            zzaze zzazeVar2 = zzaze.CONNECTING;
            this.zzm = zzazeVar2;
            zzp(zzazeVar2, new zzbnf(zzbbe.zzc()));
            zzn();
            zzd();
        } else {
            zzaze zzazeVar3 = zzaze.IDLE;
            if (zzazeVar == zzazeVar3) {
                zzp(zzazeVar3, new zzbnh(this, this));
            } else if (zzazeVar == zzaze.TRANSIENT_FAILURE) {
                zzn();
                zzd();
            }
        }
        return zzbdo.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzb(zzbdo zzbdoVar) {
        Iterator it = this.zzh.values().iterator();
        while (it.hasNext()) {
            ((zzbni) it.next()).zze().zzb();
        }
        this.zzh.clear();
        zzp(zzaze.TRANSIENT_FAILURE, new zzbnf(zzbbe.zzb(zzbdoVar)));
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzd() {
        final zzbbj zza;
        zzbnd zzbndVar = this.zzi;
        if (zzbndVar == null || !zzbndVar.zzg() || this.zzm == zzaze.SHUTDOWN) {
            return;
        }
        SocketAddress zzc = this.zzi.zzc();
        if (this.zzh.containsKey(zzc)) {
            zza = ((zzbni) this.zzh.get(zzc)).zze();
        } else {
            zzaye zzb = this.zzi.zzb();
            zzbnc zzbncVar = new zzbnc(this, null);
            zzbbd zzbbdVar = this.zzg;
            zzbax zzb2 = zzbba.zzb();
            zzazs[] zzazsVarArr = {new zzazs(Collections.singletonList(zzc), zzb)};
            ArrayList arrayList = new ArrayList(6);
            Collections.addAll(arrayList, zzazsVarArr);
            zzb2.zzb(arrayList);
            zzb2.zza(zzbbm.zzb, zzbncVar);
            zza = zzbbdVar.zza(zzb2.zzc());
            zzbni zzbniVar = new zzbni(zza, zzaze.IDLE, zzbncVar);
            zzbncVar.zzc = zzbniVar;
            this.zzh.put(zzc, zzbniVar);
            if (((zzblx) zza).zza.zza().zzc(zzbbm.zzc) == null) {
                zzbncVar.zzb = zzazf.zzb(zzaze.READY);
            }
            zza.zzc(new zzbbl() { // from class: com.google.android.libraries.places.internal.zzbmz
                @Override // com.google.android.libraries.places.internal.zzbbl
                public final void zza(zzazf zzazfVar) {
                    zzbnj.this.zzm(zza, zzazfVar);
                }
            });
        }
        int ordinal = ((zzbni) this.zzh.get(zzc)).zzc().ordinal();
        if (ordinal == 0) {
            if (this.zzo) {
                zzo();
                return;
            } else {
                zza.zza();
                return;
            }
        }
        if (ordinal == 1) {
            zzf.logp(Level.WARNING, "io.grpc.internal.PickFirstLeafLoadBalancer", "requestConnection", "Requesting a connection even though we have a READY subchannel");
            return;
        }
        if (ordinal == 2) {
            this.zzi.zzf();
            zzd();
        } else {
            if (ordinal != 3) {
                return;
            }
            zza.zza();
            zzbni.zzg((zzbni) this.zzh.get(zzc), zzaze.CONNECTING);
            zzo();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zze() {
        zzf.logp(Level.FINE, "io.grpc.internal.PickFirstLeafLoadBalancer", "shutdown", "Shutting down, currently have {} subchannels created", Integer.valueOf(this.zzh.size()));
        zzaze zzazeVar = zzaze.SHUTDOWN;
        this.zzm = zzazeVar;
        this.zzn = zzazeVar;
        zzn();
        Iterator it = this.zzh.values().iterator();
        while (it.hasNext()) {
            ((zzbni) it.next()).zze().zzb();
        }
        this.zzh.clear();
    }

    public final void zzm(zzbbj zzbbjVar, zzazf zzazfVar) {
        zzbbj zzbbjVar2;
        zzbbj zzbbjVar3;
        zzaze zza = zzazfVar.zza();
        zzbni zzbniVar = (zzbni) this.zzh.get(zzr(zzbbjVar));
        if (zzbniVar == null || zzbniVar.zze() != zzbbjVar || zza == zzaze.SHUTDOWN) {
            return;
        }
        zzaze zzazeVar = zzaze.IDLE;
        if (zza == zzazeVar) {
            this.zzg.zzd();
        }
        zzbni.zzg(zzbniVar, zza);
        zzaze zzazeVar2 = this.zzm;
        zzaze zzazeVar3 = zzaze.TRANSIENT_FAILURE;
        if (zzazeVar2 == zzazeVar3 || this.zzn == zzazeVar3) {
            if (zza == zzaze.CONNECTING) {
                return;
            }
            if (zza == zzazeVar) {
                zzd();
                return;
            }
        }
        int ordinal = zza.ordinal();
        if (ordinal == 0) {
            zzaze zzazeVar4 = zzaze.CONNECTING;
            this.zzm = zzazeVar4;
            zzp(zzazeVar4, new zzbnf(zzbbe.zzc()));
            return;
        }
        if (ordinal == 1) {
            zzn();
            for (zzbni zzbniVar2 : this.zzh.values()) {
                zzbbj zze = zzbniVar2.zze();
                zzbbjVar3 = zzbniVar.zza;
                if (!zze.equals(zzbbjVar3)) {
                    zzbniVar2.zze().zzb();
                }
            }
            this.zzh.clear();
            zzaze zzazeVar5 = zzaze.READY;
            zzbni.zzg(zzbniVar, zzazeVar5);
            Map map = this.zzh;
            zzbbjVar2 = zzbniVar.zza;
            map.put(zzr(zzbbjVar2), zzbniVar);
            this.zzi.zzh(zzr(zzbbjVar));
            this.zzm = zzazeVar5;
            zzq(zzbniVar);
            return;
        }
        if (ordinal != 2) {
            if (ordinal != 3) {
                throw new IllegalArgumentException("Unsupported state:".concat(zza.toString()));
            }
            this.zzi.zzd();
            this.zzm = zzazeVar;
            zzp(zzazeVar, new zzbnh(this, this));
            return;
        }
        if (this.zzi.zzg() && ((zzbni) this.zzh.get(this.zzi.zzc())).zze() == zzbbjVar && this.zzi.zzf()) {
            zzn();
            zzd();
        }
        zzbnd zzbndVar = this.zzi;
        if (zzbndVar == null || zzbndVar.zzg() || this.zzh.size() < this.zzi.zza()) {
            return;
        }
        Iterator it = this.zzh.values().iterator();
        while (it.hasNext()) {
            if (!((zzbni) it.next()).zzh()) {
                return;
            }
        }
        zzaze zzazeVar6 = zzaze.TRANSIENT_FAILURE;
        this.zzm = zzazeVar6;
        zzp(zzazeVar6, new zzbnf(zzbbe.zzb(zzazfVar.zzd())));
        int i11 = this.zzj + 1;
        this.zzj = i11;
        if (i11 >= this.zzi.zza() || this.zzk) {
            this.zzk = false;
            this.zzj = 0;
            this.zzg.zzd();
        }
    }
}
