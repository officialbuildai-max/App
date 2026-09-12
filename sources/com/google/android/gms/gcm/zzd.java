package com.google.android.gms.gcm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
final class zzd {
    static zzd zzk;
    private final Context zzl;
    private String zzm;
    private final AtomicInteger zzn = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zzd(Context context) {
        this.zzl = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized zzd zzd(Context context) {
        zzd zzdVar;
        synchronized (zzd.class) {
            try {
                if (zzk == null) {
                    zzk = new zzd(context);
                }
                zzdVar = zzk;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzd(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private final String zze(Bundle bundle, String str) {
        String zzd = zzd(bundle, str);
        if (!TextUtils.isEmpty(zzd)) {
            return zzd;
        }
        String valueOf = String.valueOf(str);
        String zzd2 = zzd(bundle, "_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
        if (TextUtils.isEmpty(zzd2)) {
            return null;
        }
        Resources resources = this.zzl.getResources();
        int identifier = resources.getIdentifier(zzd2, "string", this.zzl.getPackageName());
        if (identifier == 0) {
            String valueOf2 = String.valueOf(str);
            String substring = ("_loc_key".length() != 0 ? valueOf2.concat("_loc_key") : new String(valueOf2)).substring(6);
            StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(zzd2).length());
            sb2.append(substring);
            sb2.append(" resource not found: ");
            sb2.append(zzd2);
            sb2.append(" Default value will be used.");
            Log.w("GcmNotification", sb2.toString());
            return null;
        }
        String valueOf3 = String.valueOf(str);
        String zzd3 = zzd(bundle, "_loc_args".length() != 0 ? valueOf3.concat("_loc_args") : new String(valueOf3));
        if (TextUtils.isEmpty(zzd3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(zzd3);
            int length = jSONArray.length();
            Object[] objArr = new String[length];
            for (int i11 = 0; i11 < length; i11++) {
                objArr[i11] = jSONArray.opt(i11);
            }
            return resources.getString(identifier, objArr);
        } catch (MissingFormatArgumentException e11) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzd2).length() + 58 + String.valueOf(zzd3).length());
            sb3.append("Missing format argument for ");
            sb3.append(zzd2);
            sb3.append(": ");
            sb3.append(zzd3);
            sb3.append(" Default value will be used.");
            Log.w("GcmNotification", sb3.toString(), e11);
            return null;
        } catch (JSONException unused) {
            String valueOf4 = String.valueOf(str);
            String substring2 = ("_loc_args".length() != 0 ? valueOf4.concat("_loc_args") : new String(valueOf4)).substring(6);
            StringBuilder sb4 = new StringBuilder(String.valueOf(substring2).length() + 41 + String.valueOf(zzd3).length());
            sb4.append("Malformed ");
            sb4.append(substring2);
            sb4.append(": ");
            sb4.append(zzd3);
            sb4.append("  Default value will be used.");
            Log.w("GcmNotification", sb4.toString());
            return null;
        }
    }

    private final Bundle zzf() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            applicationInfo = this.zzl.getPackageManager().getApplicationInfo(this.zzl.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? Bundle.EMPTY : bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zze(android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 655
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.zzd.zze(android.os.Bundle):boolean");
    }
}
