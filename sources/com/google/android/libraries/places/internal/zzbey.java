package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzbey {
    private final zzbbq zza;
    private final String zzb;

    public zzbey(zzbbq zzbbqVar, String str) {
        zzmt.zzc(zzbbqVar, "registry");
        this.zza = zzbbqVar;
        this.zzb = "pick_first";
    }

    public static /* bridge */ /* synthetic */ zzbbo zza(zzbey zzbeyVar, String str, String str2) {
        zzbbo zza = zzbeyVar.zza.zza("pick_first");
        if (zza != null) {
            return zza;
        }
        throw new zzbex("Trying to load 'pick_first' because using default policy, but it's unavailable", null);
    }

    public static /* bridge */ /* synthetic */ zzbbq zzb(zzbey zzbeyVar) {
        return zzbeyVar.zza;
    }

    public static /* bridge */ /* synthetic */ String zzd(zzbey zzbeyVar) {
        return zzbeyVar.zzb;
    }

    public final zzbcp zzc(Map map) {
        List<zzbqf> unmodifiableList;
        String zze;
        if (map != null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (map.containsKey("loadBalancingConfig")) {
                    arrayList.addAll(zzbkg.zzh(map, "loadBalancingConfig"));
                }
                if (arrayList.isEmpty() && (zze = zzbkg.zze(map, "loadBalancingPolicy")) != null) {
                    arrayList.add(Collections.singletonMap(zze.toLowerCase(Locale.ROOT), Collections.emptyMap()));
                }
                List<Map> unmodifiableList2 = Collections.unmodifiableList(arrayList);
                if (unmodifiableList2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Map map2 : unmodifiableList2) {
                        if (map2.size() != 1) {
                            throw new RuntimeException("There are " + map2.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + String.valueOf(map2));
                        }
                        String str = (String) ((Map.Entry) map2.entrySet().iterator().next()).getKey();
                        arrayList2.add(new zzbqf(str, zzbkg.zzj(map2, str)));
                    }
                    unmodifiableList = Collections.unmodifiableList(arrayList2);
                    if (unmodifiableList != null || unmodifiableList.isEmpty()) {
                        return null;
                    }
                    zzbbq zzbbqVar = this.zza;
                    ArrayList arrayList3 = new ArrayList();
                    for (zzbqf zzbqfVar : unmodifiableList) {
                        String zza = zzbqfVar.zza();
                        zzbbo zza2 = zzbbqVar.zza(zza);
                        if (zza2 != null) {
                            if (!arrayList3.isEmpty()) {
                                Logger.getLogger(zzbqh.class.getName()).logp(Level.FINEST, "io.grpc.internal.ServiceConfigUtil", "selectLbPolicyFromList", "{0} specified by Service Config are not available", arrayList3);
                            }
                            zzbcp zzc = zza2.zzc(zzbqfVar.zzb());
                            return zzc.zzc() == null ? zzbcp.zza(new zzbqg(zza2, zzc.zzd())) : zzc;
                        }
                        arrayList3.add(zza);
                    }
                    return zzbcp.zzb(zzbdo.zzc.zzg("None of " + arrayList3.toString() + " specified by Service Config are available."));
                }
            } catch (RuntimeException e11) {
                return zzbcp.zzb(zzbdo.zzc.zzg("can't parse load balancer configuration").zzf(e11));
            }
        }
        unmodifiableList = null;
        if (unmodifiableList != null) {
        }
        return null;
    }
}
