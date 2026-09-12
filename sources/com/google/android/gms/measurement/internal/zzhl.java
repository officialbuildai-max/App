package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.measurement.internal.zzje;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzhl extends zznr implements zzai {
    final z zza;
    final com.google.android.gms.internal.measurement.zzv zzb;
    private final Map<String, Map<String, String>> zzc;
    private final Map<String, Set<String>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, Map<String, Boolean>> zzf;
    private final Map<String, zzfr.zzd> zzh;
    private final Map<String, Map<String, Integer>> zzi;
    private final Map<String, String> zzj;
    private final Map<String, String> zzk;
    private final Map<String, String> zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhl(zznv zznvVar) {
        super(zznvVar);
        this.zzc = new androidx.collection.a();
        this.zzd = new androidx.collection.a();
        this.zze = new androidx.collection.a();
        this.zzf = new androidx.collection.a();
        this.zzh = new androidx.collection.a();
        this.zzj = new androidx.collection.a();
        this.zzk = new androidx.collection.a();
        this.zzl = new androidx.collection.a();
        this.zzi = new androidx.collection.a();
        this.zza = new zzho(this, 20);
        this.zzb = new zzhr(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.android.gms.internal.measurement.zzb zza(zzhl zzhlVar, String str) {
        zzhlVar.zzal();
        Preconditions.checkNotEmpty(str);
        if (!zzhlVar.zzk(str)) {
            return null;
        }
        if (!zzhlVar.zzh.containsKey(str) || zzhlVar.zzh.get(str) == null) {
            zzhlVar.zzu(str);
        } else {
            zzhlVar.zza(str, zzhlVar.zzh.get(str));
        }
        return (com.google.android.gms.internal.measurement.zzb) zzhlVar.zza.snapshot().get(str);
    }

    private final zzfr.zzd zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzfr.zzd.zzg();
        }
        try {
            zzfr.zzd zzdVar = (zzfr.zzd) ((com.google.android.gms.internal.measurement.zzjt) ((zzfr.zzd.zza) zzoo.zza(zzfr.zzd.zze(), bArr)).zzai());
            zzj().zzp().zza("Parsed config. version, gmp_app_id", zzdVar.zzr() ? Long.valueOf(zzdVar.zzc()) : null, zzdVar.zzp() ? zzdVar.zzi() : null);
            return zzdVar;
        } catch (com.google.android.gms.internal.measurement.zzkb e11) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzgo.zza(str), e11);
            return zzfr.zzd.zzg();
        } catch (RuntimeException e12) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzgo.zza(str), e12);
            return zzfr.zzd.zzg();
        }
    }

    private static zzje.zza zza(zzfr.zza.zze zzeVar) {
        int i11 = zzht.zzb[zzeVar.ordinal()];
        if (i11 == 1) {
            return zzje.zza.AD_STORAGE;
        }
        if (i11 == 2) {
            return zzje.zza.ANALYTICS_STORAGE;
        }
        if (i11 == 3) {
            return zzje.zza.AD_USER_DATA;
        }
        if (i11 != 4) {
            return null;
        }
        return zzje.zza.AD_PERSONALIZATION;
    }

    private static Map<String, String> zza(zzfr.zzd zzdVar) {
        androidx.collection.a aVar = new androidx.collection.a();
        if (zzdVar != null) {
            for (zzfr.zzh zzhVar : zzdVar.zzn()) {
                aVar.put(zzhVar.zzb(), zzhVar.zzc());
            }
        }
        return aVar;
    }

    private final void zza(String str, zzfr.zzd.zza zzaVar) {
        HashSet hashSet = new HashSet();
        androidx.collection.a aVar = new androidx.collection.a();
        androidx.collection.a aVar2 = new androidx.collection.a();
        androidx.collection.a aVar3 = new androidx.collection.a();
        if (zzaVar != null) {
            Iterator<zzfr.zzb> it = zzaVar.zze().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().zzb());
            }
            for (int i11 = 0; i11 < zzaVar.zza(); i11++) {
                zzfr.zzc.zza zzcd = zzaVar.zza(i11).zzcd();
                if (zzcd.zzb().isEmpty()) {
                    zzj().zzu().zza("EventConfig contained null event name");
                } else {
                    String zzb = zzcd.zzb();
                    String zzb2 = zzji.zzb(zzcd.zzb());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zzcd = zzcd.zza(zzb2);
                        zzaVar.zza(i11, zzcd);
                    }
                    if (zzcd.zze() && zzcd.zzc()) {
                        aVar.put(zzb, Boolean.TRUE);
                    }
                    if (zzcd.zzf() && zzcd.zzd()) {
                        aVar2.put(zzcd.zzb(), Boolean.TRUE);
                    }
                    if (zzcd.zzg()) {
                        if (zzcd.zza() < 2 || zzcd.zza() > 65535) {
                            zzj().zzu().zza("Invalid sampling rate. Event name, sample rate", zzcd.zzb(), Integer.valueOf(zzcd.zza()));
                        } else {
                            aVar3.put(zzcd.zzb(), Integer.valueOf(zzcd.zza()));
                        }
                    }
                }
            }
        }
        this.zzd.put(str, hashSet);
        this.zze.put(str, aVar);
        this.zzf.put(str, aVar2);
        this.zzi.put(str, aVar3);
    }

    private final void zza(final String str, zzfr.zzd zzdVar) {
        if (zzdVar.zza() == 0) {
            this.zza.remove(str);
            return;
        }
        zzj().zzp().zza("EES programs found", Integer.valueOf(zzdVar.zza()));
        zzgd.zzc zzcVar = zzdVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzb zzbVar = new com.google.android.gms.internal.measurement.zzb();
            zzbVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhn
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzm("internal.remoteConfig", new zzhq(zzhl.this, str));
                }
            });
            zzbVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhm
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzhl zzhlVar = zzhl.this;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzx("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhk
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzhl zzhlVar2 = zzhl.this;
                            String str3 = str2;
                            zzg zze = zzhlVar2.zzh().zze(str3);
                            HashMap hashMap = new HashMap();
                            hashMap.put(TrackingKey.PLATFORM, "android");
                            hashMap.put("package_name", str3);
                            hashMap.put("gmp_version", 106000L);
                            if (zze != null) {
                                String zzaf = zze.zzaf();
                                if (zzaf != null) {
                                    hashMap.put("app_version", zzaf);
                                }
                                hashMap.put("app_version_int", Long.valueOf(zze.zze()));
                                hashMap.put("dynamite_version", Long.valueOf(zze.zzo()));
                            }
                            return hashMap;
                        }
                    });
                }
            });
            zzbVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhp
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzr(zzhl.this.zzb);
                }
            });
            zzbVar.zza(zzcVar);
            this.zza.put(str, zzbVar);
            zzj().zzp().zza("EES program loaded for appId, activities", str, Integer.valueOf(zzcVar.zza().zza()));
            Iterator<zzgd.zzb> it = zzcVar.zza().zzd().iterator();
            while (it.hasNext()) {
                zzj().zzp().zza("EES program activity", it.next().zzb());
            }
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            zzj().zzg().zza("Failed to load EES program. appId", str);
        }
    }

    private final void zzu(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        if (this.zzh.get(str) == null) {
            zzan zzf = zzh().zzf(str);
            if (zzf != null) {
                zzfr.zzd.zza zzcd = zza(str, zzf.zza).zzcd();
                zza(str, zzcd);
                this.zzc.put(str, zza((zzfr.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzcd.zzai())));
                this.zzh.put(str, (zzfr.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzcd.zzai()));
                zza(str, (zzfr.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzcd.zzai()));
                this.zzj.put(str, zzcd.zzc());
                this.zzk.put(str, zzf.zzb);
                this.zzl.put(str, zzf.zzc);
                return;
            }
            this.zzc.put(str, null);
            this.zze.put(str, null);
            this.zzd.put(str, null);
            this.zzf.put(str, null);
            this.zzh.put(str, null);
            this.zzj.put(str, null);
            this.zzk.put(str, null);
            this.zzl.put(str, null);
            this.zzi.put(str, null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzns
    public final /* bridge */ /* synthetic */ zzoo g_() {
        return super.g_();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0L;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e11) {
            zzj().zzu().zza("Unable to parse timezone offset. appId", zzgo.zza(str), e11);
            return 0L;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjh zza(String str, zzje.zza zzaVar) {
        zzt();
        zzu(str);
        zzfr.zza zzb = zzb(str);
        if (zzb == null) {
            return zzjh.UNINITIALIZED;
        }
        for (zzfr.zza.C0387zza c0387zza : zzb.zzf()) {
            if (zza(c0387zza.zzc()) == zzaVar) {
                int i11 = zzht.zzc[c0387zza.zzb().ordinal()];
                return i11 != 1 ? i11 != 2 ? zzjh.UNINITIALIZED : zzjh.GRANTED : zzjh.DENIED;
            }
        }
        return zzjh.UNINITIALIZED;
    }

    @Override // com.google.android.gms.measurement.internal.zzai
    public final String zza(String str, String str2) {
        zzt();
        zzu(str);
        Map<String, String> map = this.zzc.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(String str, byte[] bArr, String str2, String str3) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzfr.zzd.zza zzcd = zza(str, bArr).zzcd();
        if (zzcd == null) {
            return false;
        }
        zza(str, zzcd);
        zza(str, (zzfr.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzcd.zzai()));
        this.zzh.put(str, (zzfr.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzcd.zzai()));
        this.zzj.put(str, zzcd.zzc());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzc.put(str, zza((zzfr.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzcd.zzai())));
        zzh().zza(str, new ArrayList(zzcd.zzd()));
        try {
            zzcd.zzb();
            bArr = ((zzfr.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzcd.zzai())).zzca();
        } catch (RuntimeException e11) {
            zzj().zzu().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzgo.zza(str), e11);
        }
        zzal zzh = zzh();
        Preconditions.checkNotEmpty(str);
        zzh.zzt();
        zzh.zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzh.e_().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzh.zzj().zzg().zza("Failed to update remote config (got 0). appId", zzgo.zza(str));
            }
        } catch (SQLiteException e12) {
            zzh.zzj().zzg().zza("Error storing remote config. appId", zzgo.zza(str), e12);
        }
        this.zzh.put(str, (zzfr.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzcd.zzai()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(String str, String str2) {
        Integer num;
        zzt();
        zzu(str);
        Map<String, Integer> map = this.zzi.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfr.zza zzb(String str) {
        zzt();
        zzu(str);
        zzfr.zzd zzc = zzc(str);
        if (zzc == null || !zzc.zzo()) {
            return null;
        }
        return zzc.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzje.zza zzb(String str, zzje.zza zzaVar) {
        zzt();
        zzu(str);
        zzfr.zza zzb = zzb(str);
        if (zzb == null) {
            return null;
        }
        for (zzfr.zza.zzc zzcVar : zzb.zze()) {
            if (zzaVar == zza(zzcVar.zzc())) {
                return zza(zzcVar.zzb());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzfr.zzd zzc(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzu(str);
        return this.zzh.get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zznr
    protected final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(String str, zzje.zza zzaVar) {
        zzt();
        zzu(str);
        zzfr.zza zzb = zzb(str);
        if (zzb == null) {
            return false;
        }
        Iterator<zzfr.zza.C0387zza> it = zzb.zzd().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfr.zza.C0387zza next = it.next();
            if (zzaVar == zza(next.zzc())) {
                if (next.zzb() == zzfr.zza.zzd.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(String str, String str2) {
        Boolean bool;
        zzt();
        zzu(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzf.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzd(String str) {
        zzt();
        return this.zzl.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(String str, String str2) {
        Boolean bool;
        zzt();
        zzu(str);
        if (zzl(str) && zzos.zzg(str2)) {
            return true;
        }
        if (zzn(str) && zzos.zzh(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zze(String str) {
        zzt();
        return this.zzk.get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzf(String str) {
        zzt();
        zzu(str);
        return this.zzj.get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzns
    public final /* bridge */ /* synthetic */ zzt zzg() {
        return super.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<String> zzg(String str) {
        zzt();
        zzu(str);
        return this.zzd.get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzns
    public final /* bridge */ /* synthetic */ zzal zzh() {
        return super.zzh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SortedSet<String> zzh(String str) {
        zzt();
        zzu(str);
        TreeSet treeSet = new TreeSet();
        zzfr.zza zzb = zzb(str);
        if (zzb == null) {
            return treeSet;
        }
        Iterator<zzfr.zza.zzf> it = zzb.zzc().iterator();
        while (it.hasNext()) {
            treeSet.add(it.next().zzb());
        }
        return treeSet;
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzgh zzi() {
        return super.zzi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi(String str) {
        zzt();
        this.zzk.put(str, null);
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(String str) {
        zzt();
        this.zzh.remove(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    public final boolean zzk(String str) {
        zzfr.zzd zzdVar;
        return (TextUtils.isEmpty(str) || (zzdVar = this.zzh.get(str)) == null || zzdVar.zza() == 0) ? false : true;
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzl(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    @Override // com.google.android.gms.measurement.internal.zzns
    public final /* bridge */ /* synthetic */ zzhl zzm() {
        return super.zzm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzm(String str) {
        zzt();
        zzu(str);
        zzfr.zza zzb = zzb(str);
        return zzb == null || !zzb.zzh() || zzb.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzns
    public final /* bridge */ /* synthetic */ zzmw zzn() {
        return super.zzn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzn(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.zzns
    public final /* bridge */ /* synthetic */ zznu zzo() {
        return super.zzo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzo(String str) {
        zzt();
        zzu(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("app_instance_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzp(String str) {
        zzt();
        zzu(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains("device_model") || this.zzd.get(str).contains("device_info");
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzos zzq() {
        return super.zzq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzq(String str) {
        zzt();
        zzu(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("enhanced_user_id");
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzr(String str) {
        zzt();
        zzu(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("google_signals");
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzs(String str) {
        zzt();
        zzu(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains("os_version") || this.zzd.get(str).contains("device_info");
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzt(String str) {
        zzt();
        zzu(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("user_id");
    }
}
