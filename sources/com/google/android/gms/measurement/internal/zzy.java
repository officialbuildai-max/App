package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzy {
    private zzfy.zzf zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzt zzd;

    private zzy(zzt zztVar) {
        this.zzd = zztVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfy.zzf zza(String str, zzfy.zzf zzfVar) {
        Object obj;
        String zzg = zzfVar.zzg();
        List<zzfy.zzh> zzh = zzfVar.zzh();
        this.zzd.g_();
        Long l11 = (Long) zzoo.zzb(zzfVar, "_eid");
        boolean z10 = l11 != null;
        if (z10 && zzg.equals("_ep")) {
            Preconditions.checkNotNull(l11);
            this.zzd.g_();
            zzg = (String) zzoo.zzb(zzfVar, "_en");
            if (TextUtils.isEmpty(zzg)) {
                this.zzd.zzj().zzn().zza("Extra parameter without an event name. eventId", l11);
                return null;
            }
            if (this.zza == null || this.zzb == null || l11.longValue() != this.zzb.longValue()) {
                Pair<zzfy.zzf, Long> zza = this.zzd.zzh().zza(str, l11);
                if (zza == null || (obj = zza.first) == null) {
                    this.zzd.zzj().zzn().zza("Extra parameter without existing main event. eventName, eventId", zzg, l11);
                    return null;
                }
                this.zza = (zzfy.zzf) obj;
                this.zzc = ((Long) zza.second).longValue();
                this.zzd.g_();
                this.zzb = (Long) zzoo.zzb(this.zza, "_eid");
            }
            long j11 = this.zzc - 1;
            this.zzc = j11;
            if (j11 <= 0) {
                zzal zzh2 = this.zzd.zzh();
                zzh2.zzt();
                zzh2.zzj().zzp().zza("Clearing complex main event info. appId", str);
                try {
                    zzh2.e_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e11) {
                    zzh2.zzj().zzg().zza("Error clearing complex main event", e11);
                }
            } else {
                this.zzd.zzh().zza(str, l11, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzfy.zzh zzhVar : this.zza.zzh()) {
                this.zzd.g_();
                if (zzoo.zza(zzfVar, zzhVar.zzg()) == null) {
                    arrayList.add(zzhVar);
                }
            }
            if (arrayList.isEmpty()) {
                this.zzd.zzj().zzn().zza("No unique parameters in main event. eventName", zzg);
            } else {
                arrayList.addAll(zzh);
                zzh = arrayList;
            }
        } else if (z10) {
            this.zzb = l11;
            this.zza = zzfVar;
            this.zzd.g_();
            long longValue = ((Long) zzoo.zza(zzfVar, "_epc", (Object) 0L)).longValue();
            this.zzc = longValue;
            if (longValue <= 0) {
                this.zzd.zzj().zzn().zza("Complex event with zero extra param count. eventName", zzg);
            } else {
                this.zzd.zzh().zza(str, (Long) Preconditions.checkNotNull(l11), this.zzc, zzfVar);
            }
        }
        return (zzfy.zzf) ((com.google.android.gms.internal.measurement.zzjt) zzfVar.zzcd().zza(zzg).zzd().zza(zzh).zzai());
    }
}
