package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.push.PushConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzal extends zznr {
    private static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;"};
    private static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", PushConstants.SP_KEY_RETRY_COUNT, "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzf = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzat zzl;
    private final zznl zzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zznv zznvVar) {
        super(zznvVar);
        this.zzm = new zznl(zzb());
        this.zzl = new zzat(this, zza(), "google_app_measurement.db");
    }

    private final long zza(String str, String[] strArr, long j11) {
        Cursor cursor = null;
        try {
            try {
                cursor = e_().rawQuery(str, strArr);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return j11;
                }
                long j12 = cursor.getLong(0);
                cursor.close();
                return j12;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error", str, e11);
                throw e11;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    private final Object zza(Cursor cursor, int i11) {
        int type = cursor.getType(i11);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i11));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i11));
        }
        if (type == 3) {
            return cursor.getString(i11);
        }
        if (type != 4) {
            zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <T> T zza(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.zzau<T> r5) {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.e_()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            if (r4 != 0) goto L25
            com.google.android.gms.measurement.internal.zzgo r4 = r2.zzj()     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzp()     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            java.lang.String r5 = "No data found"
            r4.zza(r5)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            r3.close()
            return r0
        L20:
            r4 = move-exception
            r0 = r3
            goto L44
        L23:
            r4 = move-exception
            goto L31
        L25:
            java.lang.Object r4 = r5.zza(r3)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            r3.close()
            return r4
        L2d:
            r4 = move-exception
            goto L44
        L2f:
            r4 = move-exception
            r3 = r0
        L31:
            com.google.android.gms.measurement.internal.zzgo r5 = r2.zzj()     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = "Error querying database."
            r5.zza(r1, r4)     // Catch: java.lang.Throwable -> L20
            if (r3 == 0) goto L43
            r3.close()
        L43:
            return r0
        L44:
            if (r0 == 0) goto L49
            r0.close()
        L49:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzau):java.lang.Object");
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = e_().rawQuery(str, strArr);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return str2;
                }
                String string = cursor.getString(0);
                cursor.close();
                return string;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error", str, e11);
                throw e11;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Double) obj);
        }
    }

    private final void zza(String str, zzbb zzbbVar) {
        Preconditions.checkNotNull(zzbbVar);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbbVar.zza);
        contentValues.put("name", zzbbVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbbVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbbVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbbVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbbVar.zzg));
        contentValues.put("last_bundled_day", zzbbVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbbVar.zzi);
        contentValues.put("last_sampling_rate", zzbbVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbbVar.zze));
        Boolean bool = zzbbVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (e_().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzgo.zza(zzbbVar.zza));
            }
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzgo.zza(zzbbVar.zza), e11);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase e_ = e_();
            if (contentValues.getAsString(str2) == null) {
                zzj().zzm().zza("Value of the primary key is not set.", zzgo.zza(str2));
                return;
            }
            if (e_.update(str, contentValues, str2 + " = ?", new String[]{r1}) == 0 && e_.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzgo.zza(str), zzgo.zza(str2));
            }
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing into table. key", zzgo.zza(str), zzgo.zza(str2), e11);
        }
    }

    private final boolean zza(long j11, zzbc zzbcVar, long j12, boolean z10) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzbcVar);
        Preconditions.checkNotEmpty(zzbcVar.zza);
        byte[] zzca = g_().zza(zzbcVar).zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbcVar.zza);
        contentValues.put("name", zzbcVar.zzb);
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(zzbcVar.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j12));
        contentValues.put("data", zzca);
        contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        try {
            long update = e_().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j11)});
            if (update == 1) {
                return true;
            }
            zzj().zzg().zza("Failed to update raw event. appId, updatedRows", zzgo.zza(zzbcVar.zza), Long.valueOf(update));
            return false;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error updating raw event. appId", zzgo.zza(zzbcVar.zza), e11);
            return false;
        }
    }

    private final boolean zza(String str, int i11, zzfo.zzb zzbVar) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzu().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzgo.zza(str), Integer.valueOf(i11), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] zzca = zzbVar.zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i11));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put("data", zzca);
        try {
            if (e_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzgo.zza(str));
            return true;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing event filter. appId", zzgo.zza(str), e11);
            return false;
        }
    }

    private final boolean zza(String str, int i11, zzfo.zze zzeVar) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzu().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzgo.zza(str), Integer.valueOf(i11), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] zzca = zzeVar.zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i11));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", zzca);
        try {
            if (e_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing property filter. appId", zzgo.zza(str), e11);
            return false;
        }
    }

    private final String zzao() {
        long currentTimeMillis = zzb().currentTimeMillis();
        zznt zzntVar = zznt.GOOGLE_SIGNAL;
        return "(" + ("(upload_type = " + zzntVar.zza() + " AND (ABS(creation_timestamp - " + currentTimeMillis + ") > CAST(" + zzbh.zzaf.zza(null).longValue() + " AS INTEGER)))") + " OR " + ("(upload_type != " + zzntVar.zza() + " AND (ABS(creation_timestamp - " + currentTimeMillis + ") > CAST(" + zzag.zzm() + " AS INTEGER)))") + ")";
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = e_().rawQuery(str, strArr);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j11 = rawQuery.getLong(0);
                rawQuery.close();
                return j11;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error", str, e11);
                throw e11;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzal();
        zzt();
        SQLiteDatabase e_ = e_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zze().zzb(str, zzbh.zzah)));
            if (zzb2 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                Integer num = list.get(i11);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String str2 = "(" + TextUtils.join(",", arrayList) + ")";
            StringBuilder sb2 = new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb2.append(str2);
            sb2.append(" order by rowid desc limit -1 offset ?)");
            return e_.delete("audience_filter_values", sb2.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e11);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.measurement.internal.zzbb zzc(java.lang.String r29, java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbb");
    }

    private final void zzi(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error deleting snapshot. appId", zzgo.zza(str2), e11);
        }
    }

    public final long b_() {
        Cursor cursor = null;
        try {
            try {
                cursor = e_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return -1L;
                }
                long j11 = cursor.getLong(0);
                cursor.close();
                return j11;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Error querying raw events", e11);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final long c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SQLiteDatabase e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e11) {
            zzj().zzu().zza("Error opening database", e11);
            throw e11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003e  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.e_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L27
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L1e
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L3c
        L1c:
            r2 = move-exception
            goto L29
        L1e:
            r0.close()
            return r1
        L22:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3c
        L27:
            r2 = move-exception
            r0 = r1
        L29:
            com.google.android.gms.measurement.internal.zzgo r3 = r6.zzj()     // Catch: java.lang.Throwable -> L1a
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L3b
            r0.close()
        L3b:
            return r1
        L3c:
            if (r0 == 0) goto L41
            r0.close()
        L41:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.f_():java.lang.String");
    }

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            return e_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error deleting conditional property", zzgo.zza(str), zzi().zzc(str2), e11);
            return 0;
        }
    }

    public final long zza(zzfy.zzk zzkVar) throws IOException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzz());
        byte[] zzca = zzkVar.zzca();
        long zza2 = g_().zza(zzca);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkVar.zzz());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza2));
        contentValues.put(TtmlNode.TAG_METADATA, zzca);
        try {
            e_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return zza2;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzgo.zza(zzkVar.zzz()), e11);
            throw e11;
        }
    }

    public final long zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        try {
            return e_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zze().zzb(str, zzbh.zzp))))});
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzgo.zza(str), e11);
            return 0L;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0031: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x0031 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzfy.zzf, java.lang.Long> zza(java.lang.String r6, java.lang.Long r7) {
        /*
            r5 = this;
            r5.zzt()
            r5.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.e_()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            java.lang.String r3 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String[] r3 = new java.lang.String[]{r6, r3}     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            if (r2 != 0) goto L35
            com.google.android.gms.measurement.internal.zzgo r6 = r5.zzj()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzp()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.String r7 = "Main event not found"
            r6.zza(r7)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r1.close()
            return r0
        L30:
            r6 = move-exception
            r0 = r1
            goto L8a
        L33:
            r6 = move-exception
            goto L77
        L35:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r3 = 1
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r4 = com.google.android.gms.internal.measurement.zzfy.zzf.zze()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzlb r2 = com.google.android.gms.measurement.internal.zzoo.zza(r4, r2)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzlc r2 = r2.zzai()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzfy$zzf r2 = (com.google.android.gms.internal.measurement.zzfy.zzf) r2     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            android.util.Pair r6 = android.util.Pair.create(r2, r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r1.close()
            return r6
        L5d:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgo r3 = r5.zzj()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgo.zza(r6)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r3.zza(r4, r6, r7, r2)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r1.close()
            return r0
        L73:
            r6 = move-exception
            goto L8a
        L75:
            r6 = move-exception
            r1 = r0
        L77:
            com.google.android.gms.measurement.internal.zzgo r7 = r5.zzj()     // Catch: java.lang.Throwable -> L30
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzg()     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = "Error selecting main event"
            r7.zza(r2, r6)     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L89
            r1.close()
        L89:
            return r0
        L8a:
            if (r0 == 0) goto L8f
            r0.close()
        L8f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final zzaq zza(long j11, String str, long j12, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        String[] strArr = {str};
        zzaq zzaqVar = new zzaq();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase e_ = e_();
                Cursor query = e_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    zzj().zzu().zza("Not updating daily counts, app is not known. appId", zzgo.zza(str));
                    query.close();
                    return zzaqVar;
                }
                if (query.getLong(0) == j11) {
                    zzaqVar.zzb = query.getLong(1);
                    zzaqVar.zza = query.getLong(2);
                    zzaqVar.zzc = query.getLong(3);
                    zzaqVar.zzd = query.getLong(4);
                    zzaqVar.zze = query.getLong(5);
                    zzaqVar.zzf = query.getLong(6);
                    zzaqVar.zzg = query.getLong(7);
                }
                if (z10) {
                    zzaqVar.zzb += j12;
                }
                if (z11) {
                    zzaqVar.zza += j12;
                }
                if (z12) {
                    zzaqVar.zzc += j12;
                }
                if (z13) {
                    zzaqVar.zzd += j12;
                }
                if (z14) {
                    zzaqVar.zze += j12;
                }
                if (z15) {
                    zzaqVar.zzf += j12;
                }
                if (z16) {
                    zzaqVar.zzg += j12;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j11));
                contentValues.put("daily_public_events_count", Long.valueOf(zzaqVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzaqVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzaqVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzaqVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzaqVar.zze));
                contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzaqVar.zzf));
                contentValues.put("daily_registered_triggers_count", Long.valueOf(zzaqVar.zzg));
                e_.update("apps", contentValues, "app_id=?", strArr);
                query.close();
                return zzaqVar;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Error updating daily counts. appId", zzgo.zza(str), e11);
                if (0 != 0) {
                    cursor.close();
                }
                return zzaqVar;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final zzaq zza(long j11, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        return zza(j11, str, 1L, false, false, z12, false, z14, z15, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza(long r4) {
        /*
            r3 = this;
            r3.zzt()
            r3.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r3.e_()     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            android.database.Cursor r4 = r1.rawQuery(r2, r4)     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            boolean r5 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            if (r5 != 0) goto L35
            com.google.android.gms.measurement.internal.zzgo r5 = r3.zzj()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzp()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.String r1 = "No expired configs for apps with pending events"
            r5.zza(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r4.close()
            return r0
        L30:
            r5 = move-exception
            r0 = r4
            goto L55
        L33:
            r5 = move-exception
            goto L42
        L35:
            r5 = 0
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r4.close()
            return r5
        L3e:
            r5 = move-exception
            goto L55
        L40:
            r5 = move-exception
            r4 = r0
        L42:
            com.google.android.gms.measurement.internal.zzgo r1 = r3.zzj()     // Catch: java.lang.Throwable -> L30
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r5)     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L54
            r4.close()
        L54:
            return r0
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(long):java.lang.String");
    }

    public final List<Pair<zzfy.zzk, Long>> zza(String str, int i11, int i12) {
        byte[] zzc2;
        long j11;
        long j12;
        zzt();
        zzal();
        int i13 = 1;
        Preconditions.checkArgument(i11 > 0);
        Preconditions.checkArgument(i12 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = e_().query("queue", new String[]{"rowid", "data", PushConstants.SP_KEY_RETRY_COUNT}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i11));
                if (!query.moveToFirst()) {
                    List<Pair<zzfy.zzk, Long>> emptyList = Collections.emptyList();
                    query.close();
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i14 = 0;
                while (true) {
                    long j13 = query.getLong(0);
                    try {
                        zzc2 = g_().zzc(query.getBlob(i13));
                    } catch (IOException e11) {
                        zzj().zzg().zza("Failed to unzip queued bundle. appId", zzgo.zza(str), e11);
                    }
                    if (!arrayList.isEmpty() && zzc2.length + i14 > i12) {
                        break;
                    }
                    try {
                        zzfy.zzk.zza zzaVar = (zzfy.zzk.zza) zzoo.zza(zzfy.zzk.zzw(), zzc2);
                        if (!arrayList.isEmpty()) {
                            zzfy.zzk zzkVar = (zzfy.zzk) ((Pair) arrayList.get(0)).first;
                            zzfy.zzk zzkVar2 = (zzfy.zzk) ((com.google.android.gms.internal.measurement.zzjt) zzaVar.zzai());
                            if (!zzkVar.zzae().equals(zzkVar2.zzae()) || !zzkVar.zzad().equals(zzkVar2.zzad()) || zzkVar.zzau() != zzkVar2.zzau() || !zzkVar.zzaf().equals(zzkVar2.zzaf())) {
                                break;
                            }
                            Iterator<zzfy.zzo> it = zzkVar.zzas().iterator();
                            while (true) {
                                j11 = -1;
                                if (!it.hasNext()) {
                                    j12 = -1;
                                    break;
                                }
                                zzfy.zzo next = it.next();
                                if ("_npa".equals(next.zzg())) {
                                    j12 = next.zzc();
                                    break;
                                }
                            }
                            Iterator<zzfy.zzo> it2 = zzkVar2.zzas().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                zzfy.zzo next2 = it2.next();
                                if ("_npa".equals(next2.zzg())) {
                                    j11 = next2.zzc();
                                    break;
                                }
                            }
                            if (j12 != j11) {
                                break;
                            }
                        }
                        if (!query.isNull(2)) {
                            zzaVar.zzi(query.getInt(2));
                        }
                        i14 += zzc2.length;
                        arrayList.add(Pair.create((zzfy.zzk) ((com.google.android.gms.internal.measurement.zzjt) zzaVar.zzai()), Long.valueOf(j13)));
                    } catch (IOException e12) {
                        zzj().zzg().zza("Failed to merge queued bundle. appId", zzgo.zza(str), e12);
                    }
                    if (!query.moveToNext() || i14 > i12) {
                        break;
                    }
                    i13 = 1;
                }
                query.close();
                return arrayList;
            } catch (SQLiteException e13) {
                zzj().zzg().zza("Error querying bundles. appId", zzgo.zza(str), e13);
                List<Pair<zzfy.zzk, Long>> emptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyList2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final List<zzae> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb2.append(" and name glob ?");
        }
        return zza(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
    
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzae> zza(java.lang.String r27, java.lang.String[] r28) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final void zza(zzbb zzbbVar) {
        zza("events", zzbbVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0043, code lost:
    
        if (r7.zzg.zzb(r0).zza(com.google.android.gms.measurement.internal.zzje.zza.ANALYTICS_STORAGE) != false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.measurement.internal.zzg r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 845
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(com.google.android.gms.measurement.internal.zzg, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Long l11) {
        zzt();
        zzal();
        Preconditions.checkNotNull(l11);
        if ((!zzpu.zza() || zze().zza(zzbh.zzcb)) && zzaa()) {
            if (zzb("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l11 + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                e_().execSQL("UPDATE upload_queue SET retry_count = retry_count + 1 WHERE rowid = " + l11 + " AND retry_count < 2147483647");
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Error incrementing retry count. error", e11);
            }
        }
    }

    public final void zza(String str, Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        zzt();
        zzal();
        zzar zzarVar = new zzar(this, str);
        for (List<zzap> zza2 = zzarVar.zza(); !zza2.isEmpty(); zza2 = zzarVar.zza()) {
            for (zzap zzapVar : zza2) {
                zzoo g_ = g_();
                zzfy.zzf zzfVar = zzapVar.zzd;
                Bundle bundle2 = new Bundle();
                for (zzfy.zzh zzhVar : zzfVar.zzh()) {
                    if (zzhVar.zzj()) {
                        bundle2.putDouble(zzhVar.zzg(), zzhVar.zza());
                    } else if (zzhVar.zzk()) {
                        bundle2.putFloat(zzhVar.zzg(), zzhVar.zzb());
                    } else if (zzhVar.zzl()) {
                        bundle2.putLong(zzhVar.zzg(), zzhVar.zzd());
                    } else if (zzhVar.zzn()) {
                        bundle2.putString(zzhVar.zzg(), zzhVar.zzh());
                    } else if (zzhVar.zzi().isEmpty()) {
                        g_.zzj().zzg().zza("Unexpected parameter type for parameter", zzhVar);
                    } else {
                        bundle2.putParcelableArray(zzhVar.zzg(), zzoo.zzb(zzhVar.zzi()));
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String zzg = zzfVar.zzg();
                if (string == null) {
                    string = "";
                }
                zzgs zzgsVar = new zzgs(zzg, string, bundle2, zzfVar.zzd());
                zzq().zza(zzgsVar.zzc, bundle);
                zza(zzapVar.zza, new zzbc(this.zzu, zzgsVar.zzb, str, zzapVar.zzd.zzg(), zzapVar.zzd.zzd(), zzapVar.zzd.zzc(), zzgsVar.zzc), zzapVar.zzb, zzapVar.zzc);
            }
        }
    }

    public final void zza(String str, zzax zzaxVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzaxVar);
        zzt();
        zzal();
        if (zze().zza(zzbh.zzcr)) {
            zzje zzi2 = zzi(str);
            zzje zzjeVar = zzje.zza;
            if (zzi2 == zzjeVar) {
                zzb(str, zzjeVar);
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzaxVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(String str, zzje zzjeVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjeVar);
        zzt();
        zzal();
        zzb(str, zzi(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjeVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, List<zzfo.zza> list) {
        boolean z10;
        boolean z11;
        Preconditions.checkNotNull(list);
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzfo.zza.C0386zza zzcd = list.get(i11).zzcd();
            if (zzcd.zza() != 0) {
                for (int i12 = 0; i12 < zzcd.zza(); i12++) {
                    zzfo.zzb.zza zzcd2 = zzcd.zza(i12).zzcd();
                    zzfo.zzb.zza zzaVar = (zzfo.zzb.zza) ((zzjt.zzb) zzcd2.clone());
                    String zzb2 = zzji.zzb(zzcd2.zzb());
                    if (zzb2 != null) {
                        zzaVar.zza(zzb2);
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    for (int i13 = 0; i13 < zzcd2.zza(); i13++) {
                        zzfo.zzc zza2 = zzcd2.zza(i13);
                        String zza3 = zzjk.zza(zza2.zze());
                        if (zza3 != null) {
                            zzaVar.zza(i13, (zzfo.zzc) ((com.google.android.gms.internal.measurement.zzjt) zza2.zzcd().zza(zza3).zzai()));
                            z11 = true;
                        }
                    }
                    if (z11) {
                        zzfo.zza.C0386zza zza4 = zzcd.zza(i12, zzaVar);
                        list.set(i11, (zzfo.zza) ((com.google.android.gms.internal.measurement.zzjt) zza4.zzai()));
                        zzcd = zza4;
                    }
                }
            }
            if (zzcd.zzb() != 0) {
                for (int i14 = 0; i14 < zzcd.zzb(); i14++) {
                    zzfo.zze zzb3 = zzcd.zzb(i14);
                    String zza5 = zzjj.zza(zzb3.zze());
                    if (zza5 != null) {
                        zzcd = zzcd.zza(i14, zzb3.zzcd().zza(zza5));
                        list.set(i11, (zzfo.zza) ((com.google.android.gms.internal.measurement.zzjt) zzcd.zzai()));
                    }
                }
            }
        }
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase e_ = e_();
        e_.beginTransaction();
        try {
            zzal();
            zzt();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase e_2 = e_();
            e_2.delete("property_filters", "app_id=?", new String[]{str});
            e_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzfo.zza zzaVar2 : list) {
                zzal();
                zzt();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (zzaVar2.zzg()) {
                    int zza6 = zzaVar2.zza();
                    Iterator<zzfo.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zzl()) {
                                zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgo.zza(str), Integer.valueOf(zza6));
                                break;
                            }
                        } else {
                            Iterator<zzfo.zze> it2 = zzaVar2.zzf().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zzi()) {
                                        zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzgo.zza(str), Integer.valueOf(zza6));
                                        break;
                                    }
                                } else {
                                    Iterator<zzfo.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, zza6, it3.next())) {
                                                z10 = false;
                                                break;
                                            }
                                        } else {
                                            z10 = true;
                                            break;
                                        }
                                    }
                                    if (z10) {
                                        Iterator<zzfo.zze> it4 = zzaVar2.zzf().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, zza6, it4.next())) {
                                                    z10 = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z10) {
                                        zzal();
                                        zzt();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase e_3 = e_();
                                        e_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zza6)});
                                        e_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zza6)});
                                    }
                                }
                            }
                        }
                    }
                } else {
                    zzj().zzu().zza("Audience with no ID. appId", zzgo.zza(str));
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzfo.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zzg() ? Integer.valueOf(zzaVar3.zza()) : null);
            }
            zzb(str, arrayList);
            e_.setTransactionSuccessful();
            e_.endTransaction();
        } catch (Throwable th2) {
            e_.endTransaction();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(List<Long> list) {
        zzt();
        zzal();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzaa()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                e_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Error incrementing retry count. error", e11);
            }
        }
    }

    public final boolean zza(zzfy.zzk zzkVar, boolean z10) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzz());
        Preconditions.checkState(zzkVar.zzbj());
        zzv();
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzkVar.zzm() < currentTimeMillis - zzag.zzm() || zzkVar.zzm() > zzag.zzm() + currentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgo.zza(zzkVar.zzz()), Long.valueOf(currentTimeMillis), Long.valueOf(zzkVar.zzm()));
        }
        try {
            byte[] zzb2 = g_().zzb(zzkVar.zzca());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(zzb2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkVar.zzz());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzkVar.zzm()));
            contentValues.put("data", zzb2);
            contentValues.put("has_realtime", Integer.valueOf(z10 ? 1 : 0));
            if (zzkVar.zzbq()) {
                contentValues.put(PushConstants.SP_KEY_RETRY_COUNT, Integer.valueOf(zzkVar.zzg()));
            }
            try {
                if (e_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzgo.zza(zzkVar.zzz()));
                return false;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Error storing bundle. appId", zzgo.zza(zzkVar.zzz()), e11);
                return false;
            }
        } catch (IOException e12) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzgo.zza(zzkVar.zzz()), e12);
            return false;
        }
    }

    public final boolean zza(zzae zzaeVar) {
        Preconditions.checkNotNull(zzaeVar);
        zzt();
        zzal();
        String str = zzaeVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzaeVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaeVar.zzb);
        contentValues.put("name", zzaeVar.zzc.zza);
        zza(contentValues, AppMeasurementSdk.ConditionalUserProperty.VALUE, Preconditions.checkNotNull(zzaeVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzaeVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaeVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaeVar.zzh));
        zzq();
        contentValues.put("timed_out_event", zzos.zza((Parcelable) zzaeVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaeVar.zzd));
        zzq();
        contentValues.put("triggered_event", zzos.zza((Parcelable) zzaeVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaeVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaeVar.zzj));
        zzq();
        contentValues.put("expired_event", zzos.zza((Parcelable) zzaeVar.zzk));
        try {
            if (e_().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzgo.zza(str));
            return true;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing conditional user property", zzgo.zza(str), e11);
            return true;
        }
    }

    public final boolean zza(zzbc zzbcVar, long j11, boolean z10) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzbcVar);
        Preconditions.checkNotEmpty(zzbcVar.zza);
        byte[] zzca = g_().zza(zzbcVar).zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbcVar.zza);
        contentValues.put("name", zzbcVar.zzb);
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(zzbcVar.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j11));
        contentValues.put("data", zzca);
        contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        try {
            if (e_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzgo.zza(zzbcVar.zza));
            return false;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing raw event. appId", zzgo.zza(zzbcVar.zza), e11);
            return false;
        }
    }

    public final boolean zza(zzop zzopVar) {
        Preconditions.checkNotNull(zzopVar);
        zzt();
        zzal();
        if (zze(zzopVar.zza, zzopVar.zzc) == null) {
            if (zzos.zzh(zzopVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzopVar.zza}) >= zze().zza(zzopVar.zza, zzbh.zzai, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zzopVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzopVar.zza, zzopVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzopVar.zza);
        contentValues.put("origin", zzopVar.zzb);
        contentValues.put("name", zzopVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzopVar.zzd));
        zza(contentValues, AppMeasurementSdk.ConditionalUserProperty.VALUE, zzopVar.zze);
        try {
            if (e_().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzgo.zza(zzopVar.zza));
            return true;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing user property. appId", zzgo.zza(zzopVar.zza), e11);
            return true;
        }
    }

    public final boolean zza(String str, zzfy.zzj zzjVar, String str2, Map<String, String> map, zznt zzntVar) {
        int delete;
        zzt();
        zzal();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(str);
        if (zzpu.zza() && !zze().zza(zzbh.zzcb)) {
            return false;
        }
        zzt();
        zzal();
        if (zzaa()) {
            long zza2 = zzn().zzb.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzag.zzn()) {
                zzn().zzb.zza(elapsedRealtime);
                zzt();
                zzal();
                if (zzaa() && (delete = e_().delete("upload_queue", zzao(), new String[0])) > 0) {
                    zzj().zzp().zza("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + UrlUtils.EQUAL_MARK + entry.getValue());
        }
        byte[] zzca = zzjVar.zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", zzca);
        contentValues.put("upload_uri", str2);
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        if (size > 0) {
            sb2.append((CharSequence) arrayList.get(0));
            int i11 = 1;
            while (i11 < size) {
                sb2.append((CharSequence) "\r\n");
                Object obj = arrayList.get(i11);
                i11++;
                sb2.append((CharSequence) obj);
            }
        }
        contentValues.put("upload_headers", sb2.toString());
        contentValues.put("upload_type", Integer.valueOf(zzntVar.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzb().currentTimeMillis()));
        contentValues.put(PushConstants.SP_KEY_RETRY_COUNT, (Integer) 0);
        try {
            if (e_().insert("upload_queue", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return false;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing MeasurementBatch to upload_queue. appId", str, e11);
            return false;
        }
    }

    public final boolean zza(String str, zzno zznoVar) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zznoVar);
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzb().currentTimeMillis();
        long j11 = zznoVar.zzb;
        zzfz<Long> zzfzVar = zzbh.zzbh;
        if (j11 < currentTimeMillis - zzfzVar.zza(null).longValue() || zznoVar.zzb > zzfzVar.zza(null).longValue() + currentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgo.zza(str), Long.valueOf(currentTimeMillis), Long.valueOf(zznoVar.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zznoVar.zza);
        contentValues.put(EventConstants.KEY_SOURCE, Integer.valueOf(zznoVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zznoVar.zzb));
        try {
            if (e_().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzgo.zza(str), e11);
            return false;
        }
    }

    public final boolean zza(String str, Long l11, long j11, zzfy.zzf zzfVar) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzfVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l11);
        byte[] zzca = zzfVar.zzca();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(zzca.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l11);
        contentValues.put("children_to_process", Long.valueOf(j11));
        contentValues.put("main_event", zzca);
        try {
            if (e_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing complex main event. appId", zzgo.zza(str), e11);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzaa() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        return zza("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzb(String str, String str2) {
        long zza2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        SQLiteDatabase e_ = e_();
        e_.beginTransaction();
        long j11 = 0;
        try {
            try {
                zza2 = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (zza2 == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (e_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzj().zzg().zza("Failed to insert column (got -1). appId", zzgo.zza(str), str2);
                        return -1L;
                    }
                    zza2 = 0;
                }
            } finally {
                e_.endTransaction();
            }
        } catch (SQLiteException e11) {
            e = e11;
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put(str2, Long.valueOf(1 + zza2));
            if (e_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                zzj().zzg().zza("Failed to update column (got 0). appId", zzgo.zza(str), str2);
                return -1L;
            }
            e_.setTransactionSuccessful();
            return zza2;
        } catch (SQLiteException e12) {
            long j12 = zza2;
            e = e12;
            j11 = j12;
            zzj().zzg().zza("Error inserting column. appId", zzgo.zza(str), str2, e);
            e_.endTransaction();
            return j11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a1, code lost:
    
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzop> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void zzb(String str, zzje zzjeVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjeVar);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjeVar.zzf());
        contentValues.put("consent_source", Integer.valueOf(zzjeVar.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(String str, Bundle bundle) {
        zzt();
        zzal();
        byte[] zzca = g_().zza(new zzbc(this.zzu, "", str, "dep", 0L, 0L, bundle)).zzca();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(zzca.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzca);
        try {
            if (e_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzgo.zza(str), e11);
            return false;
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0053: MOVE (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:33:0x0053 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzae zzc(java.lang.String r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzae");
    }

    @Override // com.google.android.gms.measurement.internal.zznr
    protected final boolean zzc() {
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x002d */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle zzd(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzt()
            r5.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.e_()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r6}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            if (r2 != 0) goto L31
            com.google.android.gms.measurement.internal.zzgo r6 = r5.zzj()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzp()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            r1.close()
            return r0
        L2c:
            r6 = move-exception
            r0 = r1
            goto L84
        L2f:
            r6 = move-exception
            goto L71
        L31:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r3 = com.google.android.gms.internal.measurement.zzfy.zzf.zze()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            com.google.android.gms.internal.measurement.zzlb r2 = com.google.android.gms.measurement.internal.zzoo.zza(r3, r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            com.google.android.gms.internal.measurement.zzlc r2 = r2.zzai()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            com.google.android.gms.internal.measurement.zzfy$zzf r2 = (com.google.android.gms.internal.measurement.zzfy.zzf) r2     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            r5.g_()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            java.util.List r6 = r2.zzh()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zzoo.zza(r6)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            r1.close()
            return r6
        L57:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgo r3 = r5.zzj()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgo.zza(r6)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            r3.zza(r4, r6, r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            r1.close()
            return r0
        L6d:
            r6 = move-exception
            goto L84
        L6f:
            r6 = move-exception
            r1 = r0
        L71:
            com.google.android.gms.measurement.internal.zzgo r2 = r5.zzj()     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r6)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L83
            r1.close()
        L83:
            return r0
        L84:
            if (r0 == 0) goto L89
            r0.close()
        L89:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzd(java.lang.String):android.os.Bundle");
    }

    public final zzbb zzd(String str, String str2) {
        return zzc("events", str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02ee A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02c3 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d8 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0183 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b7 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e7 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ff A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0228 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x023d A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0287 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ad A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0307 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0333 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0351 A[Catch: all -> 0x00b4, SQLiteException -> 0x00b8, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x00b8, blocks: (B:5:0x007d, B:10:0x0087, B:12:0x0099, B:14:0x00a5, B:17:0x00c2, B:19:0x00d0, B:21:0x00dc, B:23:0x00f2, B:25:0x0134, B:29:0x013e, B:32:0x0188, B:34:0x01b7, B:38:0x01c1, B:41:0x01dc, B:43:0x01e7, B:44:0x01f9, B:46:0x01ff, B:48:0x020b, B:50:0x0222, B:52:0x0228, B:54:0x0234, B:56:0x023d, B:58:0x0245, B:61:0x024e, B:63:0x0266, B:65:0x026f, B:67:0x0287, B:69:0x0293, B:70:0x02a5, B:72:0x02ad, B:75:0x02b6, B:78:0x02ce, B:81:0x02f8, B:83:0x0307, B:85:0x030f, B:86:0x031a, B:88:0x0322, B:89:0x032d, B:91:0x0333, B:93:0x033f, B:94:0x0348, B:96:0x0351, B:100:0x02ee, B:101:0x02c3, B:104:0x02ca, B:106:0x0219, B:107:0x01d8, B:109:0x0183, B:111:0x00ea, B:112:0x00bb), top: B:4:0x007d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzg zze(java.lang.String r51) {
        /*
            Method dump skipped, instructions count: 903
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x006a */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzop zze(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r10.zzt()
            r10.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.e_()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            java.lang.String r2 = "user_attributes"
            java.lang.String r3 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            java.lang.String r4 = "app_id=? and name=?"
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            if (r2 != 0) goto L34
            r1.close()
            return r0
        L34:
            r2 = 0
            long r7 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            r2 = 1
            java.lang.Object r9 = r10.zza(r1, r2)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            if (r9 != 0) goto L44
            r1.close()
            return r0
        L44:
            r2 = 2
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            com.google.android.gms.measurement.internal.zzop r2 = new com.google.android.gms.measurement.internal.zzop     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            r3 = r2
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            if (r3 == 0) goto L6e
            com.google.android.gms.measurement.internal.zzgo r3 = r10.zzj()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            java.lang.String r4 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza(r11)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            r3.zza(r4, r5)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            goto L6e
        L69:
            r11 = move-exception
            r0 = r1
            goto L95
        L6c:
            r2 = move-exception
            goto L76
        L6e:
            r1.close()
            return r2
        L72:
            r11 = move-exception
            goto L95
        L74:
            r2 = move-exception
            r1 = r0
        L76:
            com.google.android.gms.measurement.internal.zzgo r3 = r10.zzj()     // Catch: java.lang.Throwable -> L69
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L69
            java.lang.String r4 = "Error querying user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgo.zza(r11)     // Catch: java.lang.Throwable -> L69
            com.google.android.gms.measurement.internal.zzgh r5 = r10.zzi()     // Catch: java.lang.Throwable -> L69
            java.lang.String r12 = r5.zzc(r12)     // Catch: java.lang.Throwable -> L69
            r3.zza(r4, r11, r12, r2)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L94
            r1.close()
        L94:
            return r0
        L95:
            if (r0 == 0) goto L9a
            r0.close()
        L9a:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzop");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0059: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:28:0x0059 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzan zzf(java.lang.String r10) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r9.zzt()
            r9.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.e_()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            java.lang.String r4 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            if (r2 != 0) goto L31
            r1.close()
            return r0
        L31:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r3 = 1
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r4 = 2
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            boolean r5 = r1.moveToNext()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            if (r5 == 0) goto L5d
            com.google.android.gms.measurement.internal.zzgo r5 = r9.zzj()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgo.zza(r10)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r5.zza(r6, r7)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            goto L5d
        L58:
            r10 = move-exception
            r0 = r1
            goto L87
        L5b:
            r2 = move-exception
            goto L70
        L5d:
            if (r2 != 0) goto L63
            r1.close()
            return r0
        L63:
            com.google.android.gms.measurement.internal.zzan r5 = new com.google.android.gms.measurement.internal.zzan     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r5.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r1.close()
            return r5
        L6c:
            r10 = move-exception
            goto L87
        L6e:
            r2 = move-exception
            r1 = r0
        L70:
            com.google.android.gms.measurement.internal.zzgo r3 = r9.zzj()     // Catch: java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L58
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgo.zza(r10)     // Catch: java.lang.Throwable -> L58
            r3.zza(r4, r10, r2)     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L86
            r1.close()
        L86:
            return r0
        L87:
            if (r0 == 0) goto L8c
            r0.close()
        L8c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzf(java.lang.String):com.google.android.gms.measurement.internal.zzan");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzfo.zzb>> zzf(String str, String str2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        androidx.collection.a aVar = new androidx.collection.a();
        Cursor cursor = null;
        try {
            try {
                Cursor query = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzfo.zzb>> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                do {
                    try {
                        zzfo.zzb zzbVar = (zzfo.zzb) ((com.google.android.gms.internal.measurement.zzjt) ((zzfo.zzb.zza) zzoo.zza(zzfo.zzb.zzc(), query.getBlob(1))).zzai());
                        int i11 = query.getInt(0);
                        List list = (List) aVar.get(Integer.valueOf(i11));
                        if (list == null) {
                            list = new ArrayList();
                            aVar.put(Integer.valueOf(i11), list);
                        }
                        list.add(zzbVar);
                    } catch (IOException e11) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e11);
                    }
                } while (query.moveToNext());
                query.close();
                return aVar;
            } catch (SQLiteException e12) {
                zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e12);
                Map<Integer, List<zzfo.zzb>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final zzax zzg(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzax.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzfo.zze>> zzg(String str, String str2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        androidx.collection.a aVar = new androidx.collection.a();
        Cursor cursor = null;
        try {
            try {
                Cursor query = e_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzfo.zze>> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                do {
                    try {
                        zzfo.zze zzeVar = (zzfo.zze) ((com.google.android.gms.internal.measurement.zzjt) ((zzfo.zze.zza) zzoo.zza(zzfo.zze.zzc(), query.getBlob(1))).zzai());
                        int i11 = query.getInt(0);
                        List list = (List) aVar.get(Integer.valueOf(i11));
                        if (list == null) {
                            list = new ArrayList();
                            aVar.put(Integer.valueOf(i11), list);
                        }
                        list.add(zzeVar);
                    } catch (IOException e11) {
                        zzj().zzg().zza("Failed to merge filter", zzgo.zza(str), e11);
                    }
                } while (query.moveToNext());
                query.close();
                return aVar;
            } catch (SQLiteException e12) {
                zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e12);
                Map<Integer, List<zzfo.zze>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final zzje zzh(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzje.zzb(zza("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error deleting user property. appId", zzgo.zza(str), zzi().zzc(str2), e11);
        }
    }

    public final zzje zzi(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        zzje zzjeVar = (zzje) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzau() { // from class: com.google.android.gms.measurement.internal.zzao
            @Override // com.google.android.gms.measurement.internal.zzau
            public final Object zza(Cursor cursor) {
                zzje zza2;
                zza2 = zzje.zza(cursor.getString(0), cursor.getInt(1));
                return zza2;
            }
        });
        return zzjeVar == null ? zzje.zza : zzjeVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4 A[Catch: all -> 0x007b, SQLiteException -> 0x007f, IOException -> 0x00a5, TryCatch #1 {IOException -> 0x00a5, blocks: (B:21:0x0082, B:23:0x00a0, B:26:0x00e7, B:28:0x00f4, B:30:0x00fe, B:32:0x0106, B:36:0x010f, B:34:0x011d, B:39:0x0128, B:43:0x00a8, B:45:0x00af, B:46:0x00bc, B:48:0x00c2, B:50:0x00e1), top: B:20:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017f  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzoj zzj(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzoj");
    }

    public final List<zzno> zzk(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = e_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", EventConstants.KEY_SOURCE}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzno(string, cursor.getLong(1), cursor.getInt(2)));
                } while (cursor.moveToNext());
                cursor.close();
                return arrayList;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Error querying trigger uris. appId", zzgo.zza(str), e11);
                List<zzno> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final List<zzop> zzl(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = e_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", AppMeasurementSdk.ConditionalUserProperty.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j11 = cursor.getLong(2);
                    Object zza2 = zza(cursor, 3);
                    if (zza2 == null) {
                        zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzgo.zza(str));
                    } else {
                        arrayList.add(new zzop(str, str2, string, j11, zza2));
                    }
                } while (cursor.moveToNext());
                cursor.close();
                return arrayList;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Error querying user properties. appId", zzgo.zza(str), e11);
                List<zzop> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, zzfy.zzm> zzm(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = e_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, zzfy.zzm> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                androidx.collection.a aVar = new androidx.collection.a();
                do {
                    int i11 = query.getInt(0);
                    try {
                        aVar.put(Integer.valueOf(i11), (zzfy.zzm) ((com.google.android.gms.internal.measurement.zzjt) ((zzfy.zzm.zza) zzoo.zza(zzfy.zzm.zze(), query.getBlob(1))).zzai()));
                    } catch (IOException e11) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzgo.zza(str), Integer.valueOf(i11), e11);
                    }
                } while (query.moveToNext());
                query.close();
                return aVar;
            } catch (SQLiteException e12) {
                zzj().zzg().zza("Database error querying filter results. appId", zzgo.zza(str), e12);
                Map<Integer, zzfy.zzm> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzfo.zzb>> zzn(String str) {
        Preconditions.checkNotEmpty(str);
        androidx.collection.a aVar = new androidx.collection.a();
        Cursor cursor = null;
        try {
            try {
                Cursor query = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzfo.zzb>> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                do {
                    try {
                        zzfo.zzb zzbVar = (zzfo.zzb) ((com.google.android.gms.internal.measurement.zzjt) ((zzfo.zzb.zza) zzoo.zza(zzfo.zzb.zzc(), query.getBlob(1))).zzai());
                        if (zzbVar.zzk()) {
                            int i11 = query.getInt(0);
                            List list = (List) aVar.get(Integer.valueOf(i11));
                            if (list == null) {
                                list = new ArrayList();
                                aVar.put(Integer.valueOf(i11), list);
                            }
                            list.add(zzbVar);
                        }
                    } catch (IOException e11) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e11);
                    }
                } while (query.moveToNext());
                query.close();
                return aVar;
            } catch (Throwable th2) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th2;
            }
        } catch (SQLiteException e12) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e12);
            Map<Integer, List<zzfo.zzb>> emptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return emptyMap2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<Integer>> zzo(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        androidx.collection.a aVar = new androidx.collection.a();
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = e_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!rawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                    rawQuery.close();
                    return emptyMap;
                }
                do {
                    int i11 = rawQuery.getInt(0);
                    List list = (List) aVar.get(Integer.valueOf(i11));
                    if (list == null) {
                        list = new ArrayList();
                        aVar.put(Integer.valueOf(i11), list);
                    }
                    list.add(Integer.valueOf(rawQuery.getInt(1)));
                } while (rawQuery.moveToNext());
                rawQuery.close();
                return aVar;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzgo.zza(str), e11);
                Map<Integer, List<Integer>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final void zzp() {
        zzal();
        e_().beginTransaction();
    }

    public final void zzp(String str) {
        zzt();
        zzal();
        try {
            e_().execSQL("delete from default_event_params where app_id=?", new String[]{str});
        } catch (SQLiteException e11) {
            zzj().zzg().zza("Error clearing default event params", e11);
        }
    }

    public final void zzq(String str) {
        zzbb zzd2;
        zzi("events_snapshot", str);
        Cursor cursor = null;
        try {
            try {
                cursor = e_().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return;
                }
                do {
                    String string = cursor.getString(0);
                    if (string != null && (zzd2 = zzd(str, string)) != null) {
                        zza("events_snapshot", zzd2);
                    }
                } while (cursor.moveToNext());
                cursor.close();
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Error creating snapshot. appId", zzgo.zza(str), e11);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x009f, code lost:
    
        if ("_v".equals(r0) != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzr(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzr(java.lang.String):void");
    }

    public final boolean zzs(String str) {
        if (zzpu.zza() && !zze().zza(zzbh.zzcb)) {
            return false;
        }
        String zzao = zzao();
        StringBuilder sb2 = new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ");
        sb2.append(zzao);
        return zzb(sb2.toString(), new String[]{str}) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzt(String str) {
        boolean z10;
        boolean z11;
        Cursor cursor = null;
        try {
            try {
                cursor = e_().rawQuery("select timestamp from raw_events where app_id=? and name = '_f' limit 1;", new String[]{str});
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (SQLiteException e11) {
            e = e11;
            z10 = false;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return false;
        }
        z10 = zzb().currentTimeMillis() < cursor.getLong(0) + MBInterstitialActivity.WEB_LOAD_TIME;
        try {
            z11 = zza("select count(*) from raw_events where app_id=? and name not like '!_%' escape '!' limit 1;", new String[]{str}, 0L) > 0;
            cursor.close();
        } catch (SQLiteException e12) {
            e = e12;
            zzj().zzg().zza("Error checking backfill conditions", e);
            z11 = false;
            if (z10) {
            }
        }
        return (z10 || z11) ? false : true;
    }

    public final void zzu() {
        zzal();
        e_().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv() {
        int delete;
        zzt();
        zzal();
        if (zzaa()) {
            long zza2 = zzn().zza.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzag.zzn()) {
                zzn().zza.zza(elapsedRealtime);
                zzt();
                zzal();
                if (!zzaa() || (delete = e_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzag.zzm())})) <= 0) {
                    return;
                }
                zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public final void zzw() {
        zzal();
        e_().setTransactionSuccessful();
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }
}
