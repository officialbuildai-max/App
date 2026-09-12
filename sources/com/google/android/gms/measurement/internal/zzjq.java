package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzje;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.r;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzjq extends zzh {
    final zzu zza;
    private zzkz zzb;
    private zzjm zzc;
    private final Set<zzjl> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;
    private final Object zzg;
    private boolean zzh;
    private int zzi;
    private zzav zzj;
    private PriorityQueue<zzno> zzk;
    private boolean zzl;
    private zzje zzm;
    private final AtomicLong zzn;
    private long zzo;
    private boolean zzp;
    private zzav zzq;
    private SharedPreferences.OnSharedPreferenceChangeListener zzr;
    private zzav zzs;
    private final zzor zzt;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjq(zzhy zzhyVar) {
        super(zzhyVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzg = new Object();
        this.zzh = false;
        this.zzi = 1;
        this.zzp = true;
        this.zzt = new zzkr(this);
        this.zzf = new AtomicReference<>();
        this.zzm = zzje.zza;
        this.zzo = -1L;
        this.zzn = new AtomicLong(0L);
        this.zza = new zzu(zzhyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(zzjq zzjqVar, Throwable th2) {
        String message = th2.getMessage();
        zzjqVar.zzl = false;
        if (message == null) {
            return 2;
        }
        if (!(th2 instanceof IllegalStateException) && !message.contains("garbage collected") && !th2.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return (!(th2 instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
        }
        if (message.contains("Background")) {
            zzjqVar.zzl = true;
        }
        return 1;
    }

    public static int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    private final void zza(Bundle bundle, int i11, long j11) {
        zzu();
        String zza = zzje.zza(bundle);
        if (zza != null) {
            zzj().zzv().zza("Ignoring invalid consent setting", zza);
            zzj().zzv().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zzg = zzl().zzg();
        zzje zza2 = zzje.zza(bundle, i11);
        if (zza2.zzi()) {
            zza(zza2, j11, zzg);
        }
        zzax zza3 = zzax.zza(bundle, i11);
        if (zza3.zzg()) {
            zza(zza3, zzg);
        }
        Boolean zza4 = zzax.zza(bundle);
        if (zza4 != null) {
            String str = i11 == -30 ? "tcf" : "app";
            if (zze().zza(zzbh.zzcs) && zzg) {
                zza(str, "allow_personalized_ads", zza4.toString(), j11);
            } else {
                zza(str, "allow_personalized_ads", (Object) zza4.toString(), false, j11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzjq zzjqVar, Bundle bundle) {
        zzjqVar.zzt();
        zzjqVar.zzu();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzjqVar.zzu.zzac()) {
            zzjqVar.zzj().zzp().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzjqVar.zzo().zza(new zzae(bundle.getString("app_id"), "", new zzon(checkNotEmpty, 0L, null, ""), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzjqVar.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzjq zzjqVar, zzje zzjeVar, long j11, boolean z10, boolean z11) {
        zzjqVar.zzt();
        zzjqVar.zzu();
        zzje zzo = zzjqVar.zzk().zzo();
        if (j11 <= zzjqVar.zzo && zzje.zza(zzo.zza(), zzjeVar.zza())) {
            zzjqVar.zzj().zzo().zza("Dropped out-of-date consent setting, proposed settings", zzjeVar);
            return;
        }
        if (!zzjqVar.zzk().zza(zzjeVar)) {
            zzjqVar.zzj().zzo().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjeVar.zza()));
            return;
        }
        zzjqVar.zzj().zzp().zza("Setting storage consent(FE)", zzjeVar);
        zzjqVar.zzo = j11;
        if (zzjqVar.zzo().zzao()) {
            zzjqVar.zzo().zzb(z10);
        } else {
            zzjqVar.zzo().zza(z10);
        }
        if (z11) {
            zzjqVar.zzo().zza(new AtomicReference<>());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzjq zzjqVar, zzje zzjeVar, zzje zzjeVar2) {
        if (com.google.android.gms.internal.measurement.zznm.zza() && zzjqVar.zze().zza(zzbh.zzcx)) {
            return;
        }
        zzje.zza zzaVar = zzje.zza.ANALYTICS_STORAGE;
        zzje.zza zzaVar2 = zzje.zza.AD_STORAGE;
        boolean zza = zzjeVar.zza(zzjeVar2, zzaVar, zzaVar2);
        boolean zzb = zzjeVar.zzb(zzjeVar2, zzaVar, zzaVar2);
        if (zza || zzb) {
            zzjqVar.zzg().zzag();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z10) {
        zzt();
        zzu();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z10) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzad() || !(bool == null || bool.booleanValue())) {
            zzav();
        }
    }

    private final void zza(String str, String str2, long j11, Object obj) {
        zzl().zzb(new zzkh(this, str, str2, obj, j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzav() {
        zzt();
        String zza = zzk().zzh.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                zza("app", "_npa", (Object) null, zzb().currentTimeMillis());
            } else {
                zza("app", "_npa", Long.valueOf("true".equals(zza) ? 1L : 0L), zzb().currentTimeMillis());
            }
        }
        if (!this.zzu.zzac() || !this.zzp) {
            zzj().zzc().zza("Updating Scion state (FE)");
            zzo().zzak();
        } else {
            zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzan();
            zzp().zza.zza();
            zzl().zzb(new zzkd(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(zzjq zzjqVar, int i11) {
        if (zzjqVar.zzj == null) {
            zzjqVar.zzj = new zzkb(zzjqVar, zzjqVar.zzu);
        }
        zzjqVar.zzj.zza(i11 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(zzjq zzjqVar, Bundle bundle) {
        zzjqVar.zzt();
        zzjqVar.zzu();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        if (!zzjqVar.zzu.zzac()) {
            zzjqVar.zzj().zzp().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzon zzonVar = new zzon(string, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get(AppMeasurementSdk.ConditionalUserProperty.VALUE), string2);
        try {
            zzbf zza = zzjqVar.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0L, true, true);
            zzjqVar.zzo().zza(new zzae(bundle.getString("app_id"), string2, zzonVar, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzjqVar.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0L, true, true), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzjqVar.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    private final void zzb(String str, String str2, long j11, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        zzl().zzb(new zzki(this, str, str2, j11, zzos.zza(bundle), z10, z11, z12, str3));
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get conditional user properties", new zzkq(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzos.zzb((List<zzae>) list);
        }
        zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
        return new ArrayList<>();
    }

    public final List<zzon> zza(boolean z10) {
        zzu();
        zzj().zzp().zza("Getting user properties (FE)");
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzkk(this, atomicReference, z10));
        List<zzon> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z10));
        return Collections.emptyList();
    }

    public final Map<String, Object> zza(String str, String str2, boolean z10) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzkp(this, atomicReference, null, str, str2, z10));
        List<zzon> list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z10));
            return Collections.emptyMap();
        }
        androidx.collection.a aVar = new androidx.collection.a(list.size());
        for (zzon zzonVar : list) {
            Object zza = zzonVar.zza();
            if (zza != null) {
                aVar.put(zzonVar.zza, zza);
            }
        }
        return aVar;
    }

    public final void zza(long j11) {
        zzc((String) null);
        zzl().zzb(new zzkl(this, j11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j11, boolean z10) {
        zzt();
        zzu();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zznb zzp = zzp();
        zzp.zzt();
        zzp.zzb.zza();
        zzg().zzag();
        boolean zzac = this.zzu.zzac();
        zzha zzk = zzk();
        zzk.zzc.zza(j11);
        if (!TextUtils.isEmpty(zzk.zzk().zzq.zza())) {
            zzk.zzq.zza(null);
        }
        zzk.zzk.zza(0L);
        zzk.zzl.zza(0L);
        if (!zzk.zze().zzx()) {
            zzk.zzb(!zzac);
        }
        zzk.zzr.zza(null);
        zzk.zzs.zza(0L);
        zzk.zzt.zza(null);
        if (z10) {
            zzo().zzai();
        }
        zzp().zza.zza();
        this.zzp = !zzac;
    }

    public final void zza(Intent intent) {
        if (zzpu.zza() && zze().zza(zzbh.zzby)) {
            Uri data = intent.getData();
            if (data == null) {
                zzj().zzo().zza("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals("1")) {
                zzj().zzo().zza("Preview Mode was not enabled.");
                zze().zzh(null);
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zzj().zzo().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zze().zzh(queryParameter2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            zzj().zzp().zza("IABTCF_TCString change picked up in listener.");
            ((zzav) Preconditions.checkNotNull(this.zzs)).zza(500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bundle bundle) {
        Bundle zza;
        if (bundle.isEmpty()) {
            zza = bundle;
        } else {
            zza = zzk().zzt.zza();
            if (zze().zza(zzbh.zzdh)) {
                zza = new Bundle(zza);
            }
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzq();
                    if (zzos.zza(obj)) {
                        zzq();
                        zzos.zza(this.zzt, 27, (String) null, (String) null, 0);
                    }
                    zzj().zzv().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzos.zzg(str)) {
                    zzj().zzv().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    zza.remove(str);
                } else if (zzq().zza("param", str, zze().zza((String) null, false), obj)) {
                    zzq().zza(zza, str, obj);
                }
            }
            zzq();
            if (zzos.zza(zza, zze().zzc())) {
                zzq();
                zzos.zza(this.zzt, 26, (String) null, (String) null, 0);
                zzj().zzv().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzk().zzt.zza(zza);
        if (!bundle.isEmpty() || zze().zza(zzbh.zzdf)) {
            zzo().zza(zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bundle bundle, long j11) {
        if (TextUtils.isEmpty(zzg().zzae())) {
            zza(bundle, 0, j11);
        } else {
            zzj().zzv().zza("Using developer consent only; google app id found");
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdo zzdoVar) throws RemoteException {
        zzl().zzb(new zzks(this, zzdoVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzax zzaxVar, boolean z10) {
        zzky zzkyVar = new zzky(this, zzaxVar);
        if (!z10) {
            zzl().zzb(zzkyVar);
        } else {
            zzt();
            zzkyVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzje zzjeVar) {
        zzt();
        boolean z10 = (zzjeVar.zzh() && zzjeVar.zzg()) || zzo().zzan();
        if (z10 != this.zzu.zzad()) {
            this.zzu.zzb(z10);
            Boolean zzu = zzk().zzu();
            if (!z10 || zzu == null || zzu.booleanValue()) {
                zza(Boolean.valueOf(z10), false);
            }
        }
    }

    public final void zza(zzje zzjeVar, long j11, boolean z10) {
        zzje zzjeVar2;
        boolean z11;
        boolean z12;
        boolean z13;
        zzje zzjeVar3 = zzjeVar;
        zzu();
        int zza = zzjeVar.zza();
        if (zza != -10) {
            zzjh zzc = zzjeVar.zzc();
            zzjh zzjhVar = zzjh.UNINITIALIZED;
            if (zzc == zzjhVar && zzjeVar.zzd() == zzjhVar) {
                zzj().zzv().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.zzg) {
            try {
                zzjeVar2 = this.zzm;
                z11 = false;
                if (zzje.zza(zza, zzjeVar2.zza())) {
                    z12 = zzjeVar.zzc(this.zzm);
                    if (zzjeVar.zzh() && !this.zzm.zzh()) {
                        z11 = true;
                    }
                    zzjeVar3 = zzjeVar.zzb(this.zzm);
                    this.zzm = zzjeVar3;
                    z13 = z11;
                    z11 = true;
                } else {
                    z12 = false;
                    z13 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!z11) {
            zzj().zzo().zza("Ignoring lower-priority consent settings, proposed settings", zzjeVar3);
            return;
        }
        long andIncrement = this.zzn.getAndIncrement();
        if (z12) {
            zzc((String) null);
            zzkx zzkxVar = new zzkx(this, zzjeVar3, j11, andIncrement, z13, zzjeVar2);
            if (!z10) {
                zzl().zzc(zzkxVar);
                return;
            } else {
                zzt();
                zzkxVar.run();
                return;
            }
        }
        zzla zzlaVar = new zzla(this, zzjeVar3, andIncrement, z13, zzjeVar2);
        if (z10) {
            zzt();
            zzlaVar.run();
        } else if (zza == 30 || zza == -10) {
            zzl().zzc(zzlaVar);
        } else {
            zzl().zzb(zzlaVar);
        }
    }

    public final void zza(zzjl zzjlVar) {
        zzu();
        Preconditions.checkNotNull(zzjlVar);
        if (this.zzd.add(zzjlVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener already registered");
    }

    public final void zza(zzjm zzjmVar) {
        zzjm zzjmVar2;
        zzt();
        zzu();
        if (zzjmVar != null && zzjmVar != (zzjmVar2 = this.zzc)) {
            Preconditions.checkState(zzjmVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzjmVar;
    }

    public final void zza(Boolean bool) {
        zzu();
        zzl().zzb(new zzkv(this, bool));
    }

    public final void zza(final String str, long j11) {
        if (str != null && TextUtils.isEmpty(str)) {
            this.zzu.zzj().zzu().zza("User ID must be non-empty or null");
        } else {
            zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjx
                @Override // java.lang.Runnable
                public final void run() {
                    zzjq.this.zzb(str);
                }
            });
            zza((String) null, "_id", (Object) str, true, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j11, Bundle bundle) {
        zzt();
        zza(str, str2, j11, bundle, true, this.zzc == null || zzos.zzg(str2), true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, String str2, long j11, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        String str4;
        long j12;
        int i11;
        int length;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzt();
        zzu();
        if (!this.zzu.zzac()) {
            zzj().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> zzaf = zzg().zzaf();
        if (zzaf != null && !zzaf.contains(str2)) {
            zzj().zzc().zza("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.zze) {
            this.zze = true;
            try {
                try {
                    (!this.zzu.zzag() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, zza());
                } catch (Exception e11) {
                    zzj().zzu().zza("Failed to invoke Tag Manager's initialize() method", e11);
                }
            } catch (ClassNotFoundException unused) {
                zzj().zzo().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            zza("auto", "_lgclid", bundle.getString("gclid"), zzb().currentTimeMillis());
        }
        if (z10 && zzos.zzj(str2)) {
            zzq().zza(bundle, zzk().zzt.zza());
        }
        if (!z12 && !"_iap".equals(str2)) {
            zzos zzt = this.zzu.zzt();
            int i12 = 2;
            if (zzt.zzc(NotificationCompat.CATEGORY_EVENT, str2)) {
                if (!zzt.zza(NotificationCompat.CATEGORY_EVENT, zzji.zza, zzji.zzb, str2)) {
                    i12 = 13;
                } else if (zzt.zza(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                    i12 = 0;
                }
            }
            if (i12 != 0) {
                zzj().zzm().zza("Invalid public event name. Event will not be logged (FE)", zzi().zza(str2));
                this.zzu.zzt();
                String zza = zzos.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zzos.zza(this.zzt, i12, "_ev", zza, length);
                return;
            }
        }
        zzlk zza2 = zzn().zza(false);
        if (zza2 != null && !bundle.containsKey("_sc")) {
            zza2.zzd = true;
        }
        zzos.zza(zza2, bundle, z10 && !z12);
        boolean equals = "am".equals(str);
        boolean zzg = zzos.zzg(str2);
        if (z10 && this.zzc != null && !zzg && !equals) {
            zzj().zzc().zza("Passing event to registered event handler (FE)", zzi().zza(str2), zzi().zza(bundle));
            Preconditions.checkNotNull(this.zzc);
            this.zzc.interceptEvent(str, str2, bundle, j11);
            return;
        }
        if (this.zzu.zzaf()) {
            int zza3 = zzq().zza(str2);
            if (zza3 != 0) {
                zzj().zzm().zza("Invalid event name. Event will not be logged (FE)", zzi().zza(str2));
                zzq();
                String zza4 = zzos.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zzos.zza(this.zzt, str3, zza3, "_ev", zza4, length);
                return;
            }
            Bundle zza5 = zzq().zza(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z12);
            Preconditions.checkNotNull(zza5);
            if (zzn().zza(false) != null && "_ae".equals(str2)) {
                zznh zznhVar = zzp().zzb;
                long elapsedRealtime = zznhVar.zzb.zzb().elapsedRealtime();
                long j13 = elapsedRealtime - zznhVar.zza;
                zznhVar.zza = elapsedRealtime;
                if (j13 > 0) {
                    zzq().zza(zza5, j13);
                }
            }
            if (!"auto".equals(str) && "_ssr".equals(str2)) {
                zzos zzq = zzq();
                String string = zza5.getString("_ffr");
                if (Strings.isEmptyOrWhitespace(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, zzq.zzk().zzq.zza())) {
                    zzq.zzj().zzc().zza("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                zzq.zzk().zzq.zza(string);
            } else if ("_ae".equals(str2)) {
                String zza6 = zzq().zzk().zzq.zza();
                if (!TextUtils.isEmpty(zza6)) {
                    zza5.putString("_ffr", zza6);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza5);
            boolean zzaa = zze().zza(zzbh.zzco) ? zzp().zzaa() : zzk().zzn.zza();
            if (zzk().zzk.zza() > 0 && zzk().zza(j11) && zzaa) {
                zzj().zzp().zza("Current session is expired, remove the session number, ID, and engagement time");
                j12 = 0;
                str4 = "_ae";
                zza("auto", "_sid", (Object) null, zzb().currentTimeMillis());
                zza("auto", "_sno", (Object) null, zzb().currentTimeMillis());
                zza("auto", "_se", (Object) null, zzb().currentTimeMillis());
                zzk().zzl.zza(0L);
            } else {
                str4 = "_ae";
                j12 = 0;
            }
            if (zza5.getLong("extend_session", j12) == 1) {
                zzj().zzp().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                i11 = 1;
                this.zzu.zzs().zza.zza(j11, true);
            } else {
                i11 = 1;
            }
            ArrayList arrayList2 = new ArrayList(zza5.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj = arrayList2.get(i13);
                i13 += i11;
                String str5 = (String) obj;
                if (str5 != null) {
                    zzq();
                    Bundle[] zzb = zzos.zzb(zza5.get(str5));
                    if (zzb != null) {
                        zza5.putParcelableArray(str5, zzb);
                    }
                }
                i11 = 1;
            }
            int i14 = 0;
            while (i14 < arrayList.size()) {
                Bundle bundle2 = (Bundle) arrayList.get(i14);
                String str6 = i14 != 0 ? "_ep" : str2;
                bundle2.putString("_o", str);
                if (z11) {
                    bundle2 = zzq().zza(bundle2, (String) null);
                }
                Bundle bundle3 = bundle2;
                zzo().zza(new zzbf(str6, new zzbe(bundle3), str, j11), str3);
                if (!equals) {
                    Iterator<zzjl> it = this.zzd.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str2, new Bundle(bundle3), j11);
                    }
                }
                i14++;
            }
            if (zzn().zza(false) == null || !str4.equals(str2)) {
                return;
            }
            zzp().zza(true, true, zzb().elapsedRealtime());
        }
    }

    public final void zza(String str, String str2, Bundle bundle) {
        long currentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb(new zzkn(this, bundle2));
    }

    public final void zza(String str, String str2, Bundle bundle, long j11) {
        zza(str, str2, bundle, true, false, j11);
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zzs();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j11) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, "screen_view")) {
            zzn().zza(bundle2, j11);
        } else {
            zzb(str3, str2, j11, bundle2, z11, !z11 || this.zzc == null || zzos.zzg(str2), z10, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, String str2, Object obj, long j11) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzu();
        if ("allow_personalized_ads".equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    Long valueOf = Long.valueOf("false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 1L : 0L);
                    zzk().zzh.zza(valueOf.longValue() == 1 ? "true" : "false");
                    obj = valueOf;
                    str2 = "_npa";
                    zzj().zzp().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                zzk().zzh.zza("unset");
                str2 = "_npa";
            }
            zzj().zzp().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str4 = str2;
        Object obj2 = obj;
        if (!this.zzu.zzac()) {
            zzj().zzp().zza("User property not set since app measurement is disabled");
        } else if (this.zzu.zzaf()) {
            zzo().zza(new zzon(str4, j11, obj2, str));
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z10) {
        zza(str, str2, obj, z10, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z10, long j11) {
        int i11;
        int length;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z10) {
            i11 = zzq().zzb(str2);
        } else {
            zzos zzq = zzq();
            if (zzq.zzc("user property", str2)) {
                if (!zzq.zza("user property", zzjj.zza, str2)) {
                    i11 = 15;
                } else if (zzq.zza("user property", 24, str2)) {
                    i11 = 0;
                }
            }
            i11 = 6;
        }
        if (i11 != 0) {
            zzq();
            String zza = zzos.zza(str2, 24, true);
            length = str2 != null ? str2.length() : 0;
            this.zzu.zzt();
            zzos.zza(this.zzt, i11, "_ev", zza, length);
            return;
        }
        if (obj == null) {
            zza(str3, str2, j11, (Object) null);
            return;
        }
        int zza2 = zzq().zza(str2, obj);
        if (zza2 == 0) {
            Object zzc = zzq().zzc(str2, obj);
            if (zzc != null) {
                zza(str3, str2, j11, zzc);
                return;
            }
            return;
        }
        zzq();
        String zza3 = zzos.zza(str2, 24, true);
        length = ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0;
        this.zzu.zzt();
        zzos.zza(this.zzt, zza2, "_ev", zza3, length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(List list) {
        boolean contains;
        zzt();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> zzm = zzk().zzm();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzno zznoVar = (zzno) it.next();
                contains = zzm.contains(zznoVar.zzc);
                if (!contains || zzm.get(zznoVar.zzc).longValue() < zznoVar.zzb) {
                    zzal().add(zznoVar);
                }
            }
            zzas();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(AtomicReference atomicReference) {
        Bundle zza = zzk().zzi.zza();
        zzls zzo = zzo();
        if (zza == null) {
            zza = new Bundle();
        }
        zzo.zza((AtomicReference<List<zzno>>) atomicReference, zza);
    }

    public final Application.ActivityLifecycleCallbacks zzaa() {
        return this.zzb;
    }

    public final zzaj zzab() {
        zzt();
        return zzo().zzaa();
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, MBInterstitialActivity.WEB_LOAD_TIME, "boolean test flag value", new zzka(this, atomicReference));
    }

    public final Double zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, MBInterstitialActivity.WEB_LOAD_TIME, "double test flag value", new zzkw(this, atomicReference));
    }

    public final Integer zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, MBInterstitialActivity.WEB_LOAD_TIME, "int test flag value", new zzkt(this, atomicReference));
    }

    public final Long zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, MBInterstitialActivity.WEB_LOAD_TIME, "long test flag value", new zzku(this, atomicReference));
    }

    public final String zzag() {
        return this.zzf.get();
    }

    public final String zzah() {
        zzlk zzaa = this.zzu.zzq().zzaa();
        if (zzaa != null) {
            return zzaa.zzb;
        }
        return null;
    }

    public final String zzai() {
        zzlk zzaa = this.zzu.zzq().zzaa();
        if (zzaa != null) {
            return zzaa.zza;
        }
        return null;
    }

    public final String zzaj() {
        if (this.zzu.zzu() != null) {
            return this.zzu.zzu();
        }
        try {
            return new zzhs(zza(), this.zzu.zzx()).zza("google_app_id");
        } catch (IllegalStateException e11) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e11);
            return null;
        }
    }

    public final String zzak() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, MBInterstitialActivity.WEB_LOAD_TIME, "String test flag value", new zzkj(this, atomicReference));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(30)
    public final PriorityQueue<zzno> zzal() {
        Comparator comparing;
        if (this.zzk == null) {
            f.a();
            comparing = Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzjp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Long valueOf;
                    valueOf = Long.valueOf(((zzno) obj).zzb);
                    return valueOf;
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzjs
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int compare;
                    compare = Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                    return compare;
                }
            });
            this.zzk = e.a(comparing);
        }
        return this.zzk;
    }

    public final void zzam() {
        zzt();
        zzu();
        if (zze().zza(zzbh.zzdd)) {
            zzls zzo = zzo();
            zzo.zzt();
            zzo.zzu();
            if (zzo.zzap() && zzo.zzq().zzg() < 242600) {
                return;
            }
            zzo().zzac();
        }
    }

    public final void zzan() {
        zzt();
        zzu();
        if (this.zzu.zzaf()) {
            Boolean zze = zze().zze("google_analytics_deferred_deep_link_enabled");
            if (zze != null && zze.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjv
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzjq.this.zzaq();
                    }
                });
            }
            zzo().zzad();
            this.zzp = false;
            String zzw = zzk().zzw();
            if (TextUtils.isEmpty(zzw)) {
                return;
            }
            zzf().zzac();
            if (zzw.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", zzw);
            zzc("auto", "_ou", bundle);
        }
    }

    public final void zzao() {
        if (!(zza().getApplicationContext() instanceof Application) || this.zzb == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzap() {
        if (zzpn.zza() && zze().zza(zzbh.zzci)) {
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzab.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzu();
            zzj().zzp().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().zza(atomicReference, 5000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjr
                @Override // java.lang.Runnable
                public final void run() {
                    zzjq.this.zza(atomicReference);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get trigger URIs");
            } else {
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzju
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzjq.this.zza(list);
                    }
                });
            }
        }
    }

    public final void zzaq() {
        zzt();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza = zzk().zzp.zza();
        zzk().zzp.zza(1 + zza);
        if (zza >= 5) {
            zzj().zzu().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
        } else {
            if (this.zzq == null) {
                this.zzq = new zzkm(this, this.zzu);
            }
            this.zzq.zza(0L);
        }
    }

    public final void zzar() {
        zzt();
        zzj().zzc().zza("Handle tcf update.");
        zznm zza = zznm.zza(zzk().zzc());
        zzj().zzp().zza("Tcf preferences read", zza);
        if (zzk().zza(zza)) {
            Bundle zza2 = zza.zza();
            zzj().zzp().zza("Consent generated from Tcf", zza2);
            if (zza2 != Bundle.EMPTY) {
                zza(zza2, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zza.zzb());
            zzc("auto", "_tcf", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(30)
    public final void zzas() {
        zzno poll;
        MeasurementManagerFutures zzo;
        zzt();
        this.zzl = false;
        if (zzal().isEmpty() || this.zzh || (poll = zzal().poll()) == null || (zzo = zzq().zzo()) == null) {
            return;
        }
        this.zzh = true;
        zzj().zzp().zza("Registering trigger URI", poll.zza);
        r c11 = zzo.c(Uri.parse(poll.zza));
        if (c11 == null) {
            this.zzh = false;
            zzal().add(poll);
            return;
        }
        if (!zze().zza(zzbh.zzcn)) {
            SparseArray<Long> zzm = zzk().zzm();
            zzm.put(poll.zzc, Long.valueOf(poll.zzb));
            zzk().zza(zzm);
        }
        Futures.a(c11, new zzkc(this, poll), new zzjz(this));
    }

    public final void zzat() {
        zzt();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzr == null) {
            this.zzs = new zzkf(this, this.zzu);
            this.zzr = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzjy
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzjq.this.zza(sharedPreferences, str);
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzau() {
        return this.zzl;
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j11) {
        zza(j11, true);
    }

    public final void zzb(Bundle bundle) {
        zzb(bundle, zzb().currentTimeMillis());
    }

    public final void zzb(Bundle bundle, long j11) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzu().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjf.zza(bundle2, "app_id", String.class, null);
        zzjf.zza(bundle2, "origin", String.class, null);
        zzjf.zza(bundle2, "name", String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.VALUE, Object.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j11);
        String string = bundle2.getString("name");
        Object obj = bundle2.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (zzq().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
            return;
        }
        if (zzq().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
            return;
        }
        Object zzc = zzq().zzc(string, obj);
        if (zzc == null) {
            zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
            return;
        }
        zzjf.zza(bundle2, zzc);
        long j12 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j12 > 15552000000L || j12 < 1)) {
            zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j12));
            return;
        }
        long j13 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j13 > 15552000000L || j13 < 1) {
            zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j13));
        } else {
            zzl().zzb(new zzko(this, bundle2));
        }
    }

    public final void zzb(zzjl zzjlVar) {
        zzu();
        Preconditions.checkNotNull(zzjlVar);
        if (this.zzd.remove(zzjlVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener had not been registered");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str) {
        if (zzg().zzb(str)) {
            zzg().zzag();
        }
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    public final void zzb(boolean z10) {
        if (zza().getApplicationContext() instanceof Application) {
            Application application = (Application) zza().getApplicationContext();
            if (this.zzb == null) {
                this.zzb = new zzkz(this);
            }
            if (z10) {
                application.unregisterActivityLifecycleCallbacks(this.zzb);
                application.registerActivityLifecycleCallbacks(this.zzb);
                zzj().zzp().zza("Registered activity lifecycle callback");
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    public final void zzc(long j11) {
        zzl().zzb(new zzkg(this, j11));
    }

    public final void zzc(Bundle bundle) {
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjt
            @Override // java.lang.Runnable
            public final void run() {
                zzjq.this.zza(bundle2);
            }
        });
    }

    public final void zzc(final Bundle bundle, final long j11) {
        zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjw
            @Override // java.lang.Runnable
            public final void run() {
                zzjq.this.zza(bundle, j11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(String str) {
        this.zzf.set(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(String str, String str2, Bundle bundle) {
        zzt();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    public final void zzc(boolean z10) {
        zzu();
        zzl().zzb(new zzke(this, z10));
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    public final void zzd(Bundle bundle, long j11) {
        zza(bundle, -20, j11);
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzgf zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzgh zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzjq zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzlj zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zznb zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzos zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzh
    protected final boolean zzz() {
        return false;
    }
}
