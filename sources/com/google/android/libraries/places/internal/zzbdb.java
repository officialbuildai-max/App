package com.google.android.libraries.places.internal;

import com.cloud.tmc.kernel.constants.TmcConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzbdb {
    private static final Logger zza = Logger.getLogger(zzbdb.class.getName());
    private static zzbdb zzb;
    private final zzbcq zzc = new zzbcy(this, null);
    private String zzd = TmcConstants.ROUTE_UNKNOWN;
    private final LinkedHashSet zze = new LinkedHashSet();
    private zzoa zzf = zzoa.zzd();

    public static synchronized zzbdb zzb() {
        zzbdb zzbdbVar;
        synchronized (zzbdb.class) {
            if (zzb == null) {
                ArrayList arrayList = new ArrayList();
                try {
                    int i11 = zzbii.f28222a;
                    arrayList.add(zzbii.class);
                } catch (ClassNotFoundException e11) {
                    zza.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getHardCodedClasses", "Unable to find DNS NameResolver", (Throwable) e11);
                }
                List<zzbcw> zza2 = zzbdi.zza(zzbcw.class, Collections.unmodifiableList(arrayList), zzbcw.class.getClassLoader(), new zzbda(null));
                if (zza2.isEmpty()) {
                    zza.logp(Level.WARNING, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                zzb = new zzbdb();
                for (zzbcw zzbcwVar : zza2) {
                    zza.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(zzbcwVar)));
                    zzb.zze(zzbcwVar);
                }
                zzb.zzf();
            }
            zzbdbVar = zzb;
        }
        return zzbdbVar;
    }

    private final synchronized void zze(zzbcw zzbcwVar) {
        zzbcwVar.zze();
        this.zze.add(zzbcwVar);
    }

    private final synchronized void zzf() {
        try {
            HashMap hashMap = new HashMap();
            Iterator it = this.zze.iterator();
            String str = TmcConstants.ROUTE_UNKNOWN;
            char c11 = 0;
            while (it.hasNext()) {
                zzbcw zzbcwVar = (zzbcw) it.next();
                String zzb2 = zzbcwVar.zzb();
                if (((zzbcw) hashMap.get(zzb2)) != null) {
                    zzbcwVar.zzc();
                } else {
                    hashMap.put(zzb2, zzbcwVar);
                }
                zzbcwVar.zzc();
                if (c11 < 5) {
                    zzbcwVar.zzc();
                    str = zzbcwVar.zzb();
                }
                c11 = 5;
            }
            this.zzf = zzoa.zzc(hashMap.entrySet());
            this.zzd = str;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final zzbcw zza(String str) {
        if (str == null) {
            return null;
        }
        return (zzbcw) zzd().get(str.toLowerCase(Locale.US));
    }

    public final synchronized String zzc() {
        return this.zzd;
    }

    final synchronized Map zzd() {
        return this.zzf;
    }
}
