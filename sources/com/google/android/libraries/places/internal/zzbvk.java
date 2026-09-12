package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzbvk extends zzbbm {
    private static final Logger zzi = Logger.getLogger(zzbvk.class.getName());
    protected boolean zzf;
    protected zzaze zzh;
    private final zzbbd zzk;
    private final Map zzj = new LinkedHashMap();
    protected final zzbbo zzg = new zzbnq();

    public zzbvk(zzbbd zzbbdVar) {
        this.zzk = zzbbdVar;
        zzi.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "<init>", "Created");
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final zzbdo zza(zzbbi zzbbiVar) {
        zzbdo zzbdoVar;
        zzbvj zzbvjVar;
        zzazs zzazsVar;
        boolean z10;
        zzbvg zzbvgVar;
        try {
            this.zzf = true;
            zzi.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "acceptResolvedAddressesInternal", "Received resolution result: {0}", zzbbiVar);
            HashMap hashMap = new HashMap();
            Iterator it = zzbbiVar.zze().iterator();
            while (it.hasNext()) {
                zzbvj zzbvjVar2 = new zzbvj((zzazs) it.next());
                zzbvi zzbviVar = (zzbvi) this.zzj.get(zzbvjVar2);
                if (zzbviVar != null) {
                    hashMap.put(zzbvjVar2, zzbviVar);
                } else {
                    hashMap.put(zzbvjVar2, new zzbvi(this, zzbvjVar2, this.zzg, null, new zzbbc(zzbbe.zzc()), null, false));
                }
            }
            ArrayList arrayList = null;
            if (hashMap.isEmpty()) {
                zzbdoVar = zzbdo.zzp.zzg("NameResolver returned no usable address. ".concat(zzbbiVar.toString()));
                zzb(zzbdoVar);
            } else {
                ArrayList<zzbvi> arrayList2 = new ArrayList();
                for (Map.Entry entry : hashMap.entrySet()) {
                    Object key = entry.getKey();
                    if (this.zzj.containsKey(key)) {
                        zzbvi zzbviVar2 = (zzbvi) this.zzj.get(key);
                        if (zzbviVar2.zzm()) {
                            arrayList2.add(zzbviVar2);
                        }
                    } else {
                        this.zzj.put(key, (zzbvi) entry.getValue());
                    }
                }
                for (zzbvi zzbviVar3 : arrayList2) {
                    zzbviVar3.zzi(zzbviVar3.zzc());
                }
                for (Map.Entry entry2 : hashMap.entrySet()) {
                    zzbvi zzbviVar4 = (zzbvi) this.zzj.get(entry2.getKey());
                    Object key2 = entry2.getKey();
                    if (key2 instanceof zzazs) {
                        zzbvjVar = new zzbvj((zzazs) key2);
                    } else {
                        zzmt.zzf(key2 instanceof zzbvj, "key is wrong type");
                        zzbvjVar = (zzbvj) key2;
                    }
                    Iterator it2 = zzbbiVar.zze().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            zzazsVar = null;
                            break;
                        }
                        zzazsVar = (zzazs) it2.next();
                        if (zzbvjVar.equals(new zzbvj(zzazsVar))) {
                            break;
                        }
                    }
                    zzmt.zzc(zzazsVar, String.valueOf(key2).concat(" no longer present in load balancer children"));
                    zzbbg zzc = zzbbiVar.zzc();
                    zzc.zza(Collections.singletonList(zzazsVar));
                    zzayb zza = zzaye.zza();
                    zza.zzb(zzbbm.zzd, Boolean.TRUE);
                    zzc.zzb(zza.zzc());
                    zzc.zzc(null);
                    zzbbi zzd = zzc.zzd();
                    zzbviVar4.zzj(zzd);
                    z10 = zzbviVar4.zzh;
                    if (!z10) {
                        zzbvgVar = zzbviVar4.zzd;
                        zzbvgVar.zzg().zzc(zzd);
                    }
                }
                zzbdoVar = zzbdo.zza;
                Set keySet = hashMap.keySet();
                arrayList = new ArrayList();
                zznx zzj = zznx.zzj(this.zzj.keySet());
                int size = zzj.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Object obj = zzj.get(i11);
                    if (!keySet.contains(obj)) {
                        zzbvi zzbviVar5 = (zzbvi) this.zzj.get(obj);
                        zzbviVar5.zzh();
                        arrayList.add(zzbviVar5);
                    }
                }
            }
            if (zzbdoVar.zzl()) {
                zzl();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((zzbvi) it3.next()).zzk();
                }
            }
            return zzbdoVar;
        } finally {
            this.zzf = false;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzb(zzbdo zzbdoVar) {
        if (this.zzh != zzaze.READY) {
            this.zzk.zze(zzaze.TRANSIENT_FAILURE, new zzbbc(zzbbe.zzb(zzbdoVar)));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zze() {
        zzi.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "shutdown", "Shutdown");
        Iterator it = this.zzj.values().iterator();
        while (it.hasNext()) {
            ((zzbvi) it.next()).zzk();
        }
        this.zzj.clear();
    }

    public final zzbbd zzh() {
        return this.zzk;
    }

    public final Collection zzi() {
        return this.zzj.values();
    }

    public abstract void zzl();
}
