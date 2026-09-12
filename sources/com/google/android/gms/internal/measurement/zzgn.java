package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzgn implements zzgk {
    private final AtomicBoolean zza = new AtomicBoolean();

    @Nullable
    private HashMap<String, String> zzb = null;
    private final HashMap<String, Boolean> zzc = new HashMap<>(16, 1.0f);
    private final HashMap<String, Integer> zzd = new HashMap<>(16, 1.0f);
    private final HashMap<String, Long> zze = new HashMap<>(16, 1.0f);
    private final HashMap<String, Float> zzf = new HashMap<>(16, 1.0f);

    @Nullable
    private Object zzg = null;
    private boolean zzh = false;
    private String[] zzi = new String[0];
    private final zzgq zzj = new zzgo();

    @Override // com.google.android.gms.internal.measurement.zzgk
    @Nullable
    public final String zza(@Nullable ContentResolver contentResolver, String str, @Nullable String str2) {
        if (contentResolver == null) {
            throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
        }
        synchronized (this) {
            try {
                if (this.zzb == null) {
                    this.zza.set(false);
                    this.zzb = new HashMap<>(16, 1.0f);
                    this.zzg = new Object();
                    contentResolver.registerContentObserver(zzgi.zza, true, new zzgp(this, null));
                } else if (this.zza.getAndSet(false)) {
                    this.zzb.clear();
                    this.zzc.clear();
                    this.zzd.clear();
                    this.zze.clear();
                    this.zzf.clear();
                    this.zzg = new Object();
                    this.zzh = false;
                }
                Object obj = this.zzg;
                if (this.zzb.containsKey(str)) {
                    String str3 = this.zzb.get(str);
                    return str3 != null ? str3 : null;
                }
                for (String str4 : this.zzi) {
                    if (str.startsWith(str4)) {
                        if (!this.zzh) {
                            try {
                                HashMap<String, String> hashMap = (HashMap) this.zzj.zza(contentResolver, this.zzi, new zzgr() { // from class: com.google.android.gms.internal.measurement.zzgm
                                    @Override // com.google.android.gms.internal.measurement.zzgr
                                    public final Map zza(int i11) {
                                        return new HashMap(i11, 1.0f);
                                    }
                                });
                                if (!hashMap.isEmpty()) {
                                    Set<String> keySet = hashMap.keySet();
                                    keySet.removeAll(this.zzc.keySet());
                                    keySet.removeAll(this.zzd.keySet());
                                    keySet.removeAll(this.zze.keySet());
                                    keySet.removeAll(this.zzf.keySet());
                                }
                                if (!hashMap.isEmpty()) {
                                    if (this.zzb.isEmpty()) {
                                        this.zzb = hashMap;
                                    } else {
                                        this.zzb.putAll(hashMap);
                                    }
                                }
                                this.zzh = true;
                            } catch (zzgt unused) {
                            }
                            if (this.zzb.containsKey(str)) {
                                String str5 = this.zzb.get(str);
                                return str5 != null ? str5 : null;
                            }
                        }
                        return null;
                    }
                }
                try {
                    String zza = this.zzj.zza(contentResolver, str);
                    if (zza != null && zza.equals(null)) {
                        zza = null;
                    }
                    synchronized (this) {
                        try {
                            if (obj == this.zzg) {
                                this.zzb.put(str, zza);
                            }
                        } finally {
                        }
                    }
                    if (zza != null) {
                        return zza;
                    }
                    return null;
                } catch (zzgt unused2) {
                    return null;
                }
            } finally {
            }
        }
    }
}
