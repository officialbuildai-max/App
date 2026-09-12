package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzov;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class zzhy implements zzjc {
    private static volatile zzhy zzb;
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    private Boolean zzad;
    private Boolean zzae;
    private volatile boolean zzaf;
    private int zzag;
    private int zzah;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzab zzh;
    private final zzag zzi;
    private final zzha zzj;
    private final zzgo zzk;
    private final zzhv zzl;
    private final zznb zzm;
    private final zzos zzn;
    private final zzgh zzo;
    private final Clock zzp;
    private final zzlj zzq;
    private final zzjq zzr;
    private final zzb zzs;
    private final zzle zzt;
    private final String zzu;
    private zzgf zzv;
    private zzls zzw;
    private zzaz zzx;
    private zzgg zzy;
    private boolean zzz = false;
    private AtomicInteger zzai = new AtomicInteger(0);

    private zzhy(zzjo zzjoVar) {
        Bundle bundle;
        boolean z10 = false;
        Preconditions.checkNotNull(zzjoVar);
        zzab zzabVar = new zzab(zzjoVar.zza);
        this.zzh = zzabVar;
        zzga.zza = zzabVar;
        Context context = zzjoVar.zza;
        this.zzc = context;
        this.zzd = zzjoVar.zzb;
        this.zze = zzjoVar.zzc;
        this.zzf = zzjoVar.zzd;
        this.zzg = zzjoVar.zzh;
        this.zzac = zzjoVar.zze;
        this.zzu = zzjoVar.zzj;
        this.zzaf = true;
        com.google.android.gms.internal.measurement.zzdw zzdwVar = zzjoVar.zzg;
        if (zzdwVar != null && (bundle = zzdwVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzdwVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzhj.zzb(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        Long l11 = zzjoVar.zzi;
        this.zza = l11 != null ? l11.longValue() : defaultClock.currentTimeMillis();
        this.zzi = new zzag(this);
        zzha zzhaVar = new zzha(this);
        zzhaVar.zzad();
        this.zzj = zzhaVar;
        zzgo zzgoVar = new zzgo(this);
        zzgoVar.zzad();
        this.zzk = zzgoVar;
        zzos zzosVar = new zzos(this);
        zzosVar.zzad();
        this.zzn = zzosVar;
        this.zzo = new zzgh(new zzjn(zzjoVar, this));
        this.zzs = new zzb(this);
        zzlj zzljVar = new zzlj(this);
        zzljVar.zzv();
        this.zzq = zzljVar;
        zzjq zzjqVar = new zzjq(this);
        zzjqVar.zzv();
        this.zzr = zzjqVar;
        zznb zznbVar = new zznb(this);
        zznbVar.zzv();
        this.zzm = zznbVar;
        zzle zzleVar = new zzle(this);
        zzleVar.zzad();
        this.zzt = zzleVar;
        zzhv zzhvVar = new zzhv(this);
        zzhvVar.zzad();
        this.zzl = zzhvVar;
        com.google.android.gms.internal.measurement.zzdw zzdwVar2 = zzjoVar.zzg;
        if (zzdwVar2 != null && zzdwVar2.zzb != 0) {
            z10 = true;
        }
        boolean z11 = !z10;
        if (context.getApplicationContext() instanceof Application) {
            zzp().zzb(z11);
        } else {
            zzj().zzu().zza("Application context is not an Application");
        }
        zzhvVar.zzb(new zzid(this, zzjoVar));
    }

    public static zzhy zza(Context context, com.google.android.gms.internal.measurement.zzdw zzdwVar, Long l11) {
        Bundle bundle;
        if (zzdwVar != null && (zzdwVar.zze == null || zzdwVar.zzf == null)) {
            zzdwVar = new com.google.android.gms.internal.measurement.zzdw(zzdwVar.zza, zzdwVar.zzb, zzdwVar.zzc, zzdwVar.zzd, null, null, zzdwVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzhy.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzhy(new zzjo(context, zzdwVar, l11));
                    }
                } finally {
                }
            }
        } else if (zzdwVar != null && (bundle = zzdwVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzb);
            zzb.zza(zzdwVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    private static void zza(zzh zzhVar) {
        if (zzhVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzhVar.zzy()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(zzhVar.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzhy zzhyVar, zzjo zzjoVar) {
        zzhyVar.zzl().zzt();
        zzaz zzazVar = new zzaz(zzhyVar);
        zzazVar.zzad();
        zzhyVar.zzx = zzazVar;
        zzgg zzggVar = new zzgg(zzhyVar, zzjoVar.zzf);
        zzggVar.zzv();
        zzhyVar.zzy = zzggVar;
        zzgf zzgfVar = new zzgf(zzhyVar);
        zzgfVar.zzv();
        zzhyVar.zzv = zzgfVar;
        zzls zzlsVar = new zzls(zzhyVar);
        zzlsVar.zzv();
        zzhyVar.zzw = zzlsVar;
        zzhyVar.zzn.zzae();
        zzhyVar.zzj.zzae();
        zzhyVar.zzy.zzw();
        zzhyVar.zzj().zzo().zza("App measurement initialized, version", 106000L);
        zzhyVar.zzj().zzo().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzad = zzggVar.zzad();
        if (TextUtils.isEmpty(zzhyVar.zzd)) {
            if (zzhyVar.zzt().zzd(zzad, zzhyVar.zzi.zzu())) {
                zzhyVar.zzj().zzo().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzhyVar.zzj().zzo().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + zzad);
            }
        }
        zzhyVar.zzj().zzc().zza("Debug-level message logging enabled");
        if (zzhyVar.zzag != zzhyVar.zzai.get()) {
            zzhyVar.zzj().zzg().zza("Not all components initialized", Integer.valueOf(zzhyVar.zzag), Integer.valueOf(zzhyVar.zzai.get()));
        }
        zzhyVar.zzz = true;
    }

    private static void zza(zzja zzjaVar) {
        if (zzjaVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzjd zzjdVar) {
        if (zzjdVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzjdVar.zzaf()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(zzjdVar.getClass()));
    }

    private final zzle zzai() {
        zza((zzjd) this.zzt);
        return this.zzt;
    }

    @Override // com.google.android.gms.measurement.internal.zzjc
    public final Context zza() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00da, code lost:
    
        if (r1.zzi() != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdw r12) {
        /*
            Method dump skipped, instructions count: 1084
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhy.zza(com.google.android.gms.internal.measurement.zzdw):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, int i11, Throwable th2, byte[] bArr, Map map) {
        if ((i11 != 200 && i11 != 204 && i11 != 304) || th2 != null) {
            zzj().zzu().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i11), th2);
            return;
        }
        zzn().zzo.zza(true);
        if (bArr == null || bArr.length == 0) {
            zzj().zzc().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            if (TextUtils.isEmpty(optString)) {
                zzj().zzc().zza("Deferred Deep Link is empty.");
                return;
            }
            String optString2 = jSONObject.optString("gclid", "");
            String optString3 = jSONObject.optString("gbraid", "");
            String optString4 = jSONObject.optString("gad_source", "");
            double optDouble = jSONObject.optDouble(CampaignEx.JSON_KEY_TIMESTAMP, 0.0d);
            Bundle bundle = new Bundle();
            if (zzov.zza() && this.zzi.zza(zzbh.zzct)) {
                if (!zzt().zzi(optString)) {
                    zzj().zzu().zza("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                    return;
                }
                if (!TextUtils.isEmpty(optString3)) {
                    bundle.putString("gbraid", optString3);
                }
                if (!TextUtils.isEmpty(optString4)) {
                    bundle.putString("gad_source", optString4);
                }
            } else if (!zzt().zzi(optString)) {
                zzj().zzu().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            if (zzov.zza()) {
                this.zzi.zza(zzbh.zzct);
            }
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zzc("auto", "_cmp", bundle);
            zzos zzt = zzt();
            if (TextUtils.isEmpty(optString) || !zzt.zza(optString, optDouble)) {
                return;
            }
            zzt.zza().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e11) {
            zzj().zzg().zza("Failed to parse the Deferred Deep Link response. exception", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(boolean z10) {
        this.zzac = Boolean.valueOf(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaa() {
        this.zzag++;
    }

    public final boolean zzab() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    public final boolean zzac() {
        return zzc() == 0;
    }

    public final boolean zzad() {
        zzl().zzt();
        return this.zzaf;
    }

    public final boolean zzae() {
        return TextUtils.isEmpty(this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzaf() {
        if (!this.zzz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzl().zzt();
        Boolean bool = this.zzaa;
        if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
            this.zzab = this.zzp.elapsedRealtime();
            boolean z10 = true;
            Boolean valueOf = Boolean.valueOf(zzt().zze("android.permission.INTERNET") && zzt().zze("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzy() || (zzos.zza(this.zzc) && zzos.zza(this.zzc, false))));
            this.zzaa = valueOf;
            if (valueOf.booleanValue()) {
                if (!zzt().zza(zzh().zzae(), zzh().zzac()) && TextUtils.isEmpty(zzh().zzac())) {
                    z10 = false;
                }
                this.zzaa = Boolean.valueOf(z10);
            }
        }
        return this.zzaa.booleanValue();
    }

    public final boolean zzag() {
        return this.zzg;
    }

    public final boolean zzah() {
        zzl().zzt();
        zza((zzjd) zzai());
        String zzad = zzh().zzad();
        if (!this.zzi.zzv()) {
            zzj().zzp().zza("ADID collection is disabled from Manifest. Skipping");
            return false;
        }
        Pair<String, Boolean> zza = zzn().zza(zzad);
        if (((Boolean) zza.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza.first)) {
            zzj().zzp().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        if (!zzai().zzc()) {
            zzj().zzu().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        zzls zzr = zzr();
        zzr.zzt();
        zzr.zzu();
        if (!zzr.zzap() || zzr.zzq().zzg() >= 234200) {
            zzaj zzab = zzp().zzab();
            Bundle bundle = zzab != null ? zzab.zza : null;
            if (bundle == null) {
                int i11 = this.zzah;
                this.zzah = i11 + 1;
                boolean z10 = i11 < 10;
                zzj().zzc().zza("Failed to retrieve DMA consent from the service, " + (z10 ? "Retrying." : "Skipping.") + " retryCount", Integer.valueOf(this.zzah));
                return z10;
            }
            zzje zza2 = zzje.zza(bundle, 100);
            sb2.append("&gcs=");
            sb2.append(zza2.zze());
            zzax zza3 = zzax.zza(bundle, 100);
            sb2.append("&dma=");
            sb2.append(zza3.zzd() == Boolean.FALSE ? 0 : 1);
            if (!TextUtils.isEmpty(zza3.zze())) {
                sb2.append("&dma_cps=");
                sb2.append(zza3.zze());
            }
            int i12 = zzax.zza(bundle) == Boolean.TRUE ? 0 : 1;
            sb2.append("&npa=");
            sb2.append(i12);
            zzj().zzp().zza("Consent query parameters to Bow", sb2);
        }
        zzos zzt = zzt();
        zzh();
        URL zza4 = zzt.zza(106000L, zzad, (String) zza.first, zzn().zzp.zza() - 1, sb2.toString());
        if (zza4 != null) {
            zzle zzai = zzai();
            zzld zzldVar = new zzld() { // from class: com.google.android.gms.measurement.internal.zzia
                @Override // com.google.android.gms.measurement.internal.zzld
                public final void zza(String str, int i13, Throwable th2, byte[] bArr, Map map) {
                    zzhy.this.zza(str, i13, th2, bArr, map);
                }
            };
            zzai.zzt();
            zzai.zzac();
            Preconditions.checkNotNull(zza4);
            Preconditions.checkNotNull(zzldVar);
            zzai.zzl().zza(new zzlg(zzai, zzad, zza4, null, null, zzldVar));
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzjc
    public final Clock zzb() {
        return this.zzp;
    }

    public final void zzb(boolean z10) {
        zzl().zzt();
        this.zzaf = z10;
    }

    public final int zzc() {
        zzl().zzt();
        if (this.zzi.zzx()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!zzad()) {
            return 8;
        }
        Boolean zzv = zzn().zzv();
        if (zzv != null) {
            return zzv.booleanValue() ? 0 : 3;
        }
        Boolean zze = this.zzi.zze("firebase_analytics_collection_enabled");
        if (zze != null) {
            return zze.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zzad;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.zzac == null || this.zzac.booleanValue()) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzjc
    public final zzab zzd() {
        return this.zzh;
    }

    public final zzb zze() {
        zzb zzbVar = this.zzs;
        if (zzbVar != null) {
            return zzbVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public final zzag zzf() {
        return this.zzi;
    }

    public final zzaz zzg() {
        zza((zzjd) this.zzx);
        return this.zzx;
    }

    public final zzgg zzh() {
        zza((zzh) this.zzy);
        return this.zzy;
    }

    public final zzgf zzi() {
        zza((zzh) this.zzv);
        return this.zzv;
    }

    @Override // com.google.android.gms.measurement.internal.zzjc
    public final zzgo zzj() {
        zza((zzjd) this.zzk);
        return this.zzk;
    }

    public final zzgh zzk() {
        return this.zzo;
    }

    @Override // com.google.android.gms.measurement.internal.zzjc
    public final zzhv zzl() {
        zza((zzjd) this.zzl);
        return this.zzl;
    }

    public final zzgo zzm() {
        zzgo zzgoVar = this.zzk;
        if (zzgoVar == null || !zzgoVar.zzaf()) {
            return null;
        }
        return this.zzk;
    }

    public final zzha zzn() {
        zza((zzja) this.zzj);
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzhv zzo() {
        return this.zzl;
    }

    public final zzjq zzp() {
        zza((zzh) this.zzr);
        return this.zzr;
    }

    public final zzlj zzq() {
        zza((zzh) this.zzq);
        return this.zzq;
    }

    public final zzls zzr() {
        zza((zzh) this.zzw);
        return this.zzw;
    }

    public final zznb zzs() {
        zza((zzh) this.zzm);
        return this.zzm;
    }

    public final zzos zzt() {
        zza((zzja) this.zzn);
        return this.zzn;
    }

    public final String zzu() {
        return this.zzd;
    }

    public final String zzv() {
        return this.zze;
    }

    public final String zzw() {
        return this.zzf;
    }

    public final String zzx() {
        return this.zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzy() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzz() {
        this.zzai.incrementAndGet();
    }
}
