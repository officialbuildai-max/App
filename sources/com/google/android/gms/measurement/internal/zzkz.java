package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzkz implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzjq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkz(zzjq zzjqVar) {
        this.zza = zzjqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b0 A[Catch: RuntimeException -> 0x0029, TRY_ENTER, TryCatch #0 {RuntimeException -> 0x0029, blocks: (B:3:0x000d, B:5:0x0019, B:8:0x002d, B:14:0x00b0, B:16:0x00bc, B:19:0x00d1, B:21:0x00d7, B:24:0x00e4, B:26:0x00ea, B:27:0x0102, B:28:0x0111, B:32:0x0118, B:36:0x013b, B:37:0x0157, B:39:0x0148, B:40:0x015e, B:42:0x0164, B:44:0x016a, B:46:0x0170, B:48:0x0176, B:50:0x017e, B:52:0x0186, B:54:0x018c, B:57:0x0192, B:62:0x0041, B:65:0x0049, B:67:0x0051, B:69:0x0057, B:71:0x005d, B:73:0x0063, B:75:0x006b, B:77:0x0073, B:79:0x007b, B:81:0x0083, B:82:0x008f, B:84:0x00a7), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0117 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0118 A[Catch: RuntimeException -> 0x0029, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0029, blocks: (B:3:0x000d, B:5:0x0019, B:8:0x002d, B:14:0x00b0, B:16:0x00bc, B:19:0x00d1, B:21:0x00d7, B:24:0x00e4, B:26:0x00ea, B:27:0x0102, B:28:0x0111, B:32:0x0118, B:36:0x013b, B:37:0x0157, B:39:0x0148, B:40:0x015e, B:42:0x0164, B:44:0x016a, B:46:0x0170, B:48:0x0176, B:50:0x017e, B:52:0x0186, B:54:0x018c, B:57:0x0192, B:62:0x0041, B:65:0x0049, B:67:0x0051, B:69:0x0057, B:71:0x005d, B:73:0x0063, B:75:0x006b, B:77:0x0073, B:79:0x007b, B:81:0x0083, B:82:0x008f, B:84:0x00a7), top: B:2:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void zza(com.google.android.gms.measurement.internal.zzkz r17, boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkz.zza(com.google.android.gms.measurement.internal.zzkz, boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            try {
                this.zza.zzj().zzp().zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    this.zza.zzn().zza(activity, bundle);
                    return;
                }
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        String string = extras.getString("com.android.vending.referral_url");
                        if (!TextUtils.isEmpty(string)) {
                            data = Uri.parse(string);
                        }
                    }
                    data = null;
                }
                Uri uri = data;
                if (uri != null && uri.isHierarchical()) {
                    this.zza.zzq();
                    this.zza.zzl().zzb(new zzlc(this, bundle == null, uri, zzos.zza(intent) ? "gs" : "auto", uri.getQueryParameter("referrer")));
                    this.zza.zzn().zza(activity, bundle);
                }
            } catch (RuntimeException e11) {
                this.zza.zzj().zzg().zza("Throwable caught in onActivityCreated", e11);
                this.zza.zzn().zza(activity, bundle);
            }
        } finally {
            this.zza.zzn().zza(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzn().zza(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zza.zzn().zzb(activity);
        zznb zzp = this.zza.zzp();
        zzp.zzl().zzb(new zznd(zzp, zzp.zzb().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zznb zzp = this.zza.zzp();
        zzp.zzl().zzb(new zzne(zzp, zzp.zzb().elapsedRealtime()));
        this.zza.zzn().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzn().zzb(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
