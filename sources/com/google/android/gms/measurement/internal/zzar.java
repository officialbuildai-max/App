package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfy;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzar {
    private final String zza;
    private long zzb = -1;
    private final /* synthetic */ zzal zzc;

    public zzar(zzal zzalVar, String str) {
        this.zzc = zzalVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    public final List<zzap> zza() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                Cursor query = this.zzc.e_().query("raw_events", new String[]{"rowid", "name", CampaignEx.JSON_KEY_TIMESTAMP, "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.zza, String.valueOf(this.zzb)}, null, null, "rowid", "1000");
                if (!query.moveToFirst()) {
                    List<zzap> emptyList = Collections.emptyList();
                    query.close();
                    return emptyList;
                }
                do {
                    long j11 = query.getLong(0);
                    long j12 = query.getLong(3);
                    boolean z10 = query.getLong(5) == 1;
                    byte[] blob = query.getBlob(4);
                    if (j11 > this.zzb) {
                        this.zzb = j11;
                    }
                    try {
                        zzfy.zzf.zza zzaVar = (zzfy.zzf.zza) zzoo.zza(zzfy.zzf.zze(), blob);
                        String string = query.getString(1);
                        if (string == null) {
                            string = "";
                        }
                        zzaVar.zza(string).zzb(query.getLong(2));
                        arrayList.add(new zzap(j11, j12, z10, (zzfy.zzf) ((com.google.android.gms.internal.measurement.zzjt) zzaVar.zzai())));
                    } catch (IOException e11) {
                        this.zzc.zzj().zzg().zza("Data loss. Failed to merge raw event. appId", zzgo.zza(this.zza), e11);
                    }
                } while (query.moveToNext());
                query.close();
            } catch (SQLiteException e12) {
                this.zzc.zzj().zzg().zza("Data loss. Error querying raw events batch. appId", zzgo.zza(this.zza), e12);
                if (0 != 0) {
                    cursor.close();
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }
}
