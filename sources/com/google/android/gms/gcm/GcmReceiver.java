package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.gms.common.util.PlatformVersion;
import org.mvel2.ast.ASTNode;

@Deprecated
/* loaded from: classes3.dex */
public class GcmReceiver extends WakefulBroadcastReceiver {
    private static boolean zzr;
    private static com.google.android.gms.iid.zzk zzs;
    private static com.google.android.gms.iid.zzk zzt;

    private final int zzd(Context context, Intent intent) {
        Log.isLoggable("GcmReceiver", 3);
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
        zzd(context, intent.getAction()).zzd(intent, goAsync());
        return -1;
    }

    private final synchronized com.google.android.gms.iid.zzk zzd(Context context, String str) {
        try {
            if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
                if (zzt == null) {
                    zzt = new com.google.android.gms.iid.zzk(context, str);
                }
                return zzt;
            }
            if (zzs == null) {
                zzs = new com.google.android.gms.iid.zzk(context, str);
            }
            return zzs;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static int zze(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        Log.isLoggable("GcmReceiver", 3);
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null || (serviceInfo = resolveService.serviceInfo) == null) {
            Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
        } else if (!context.getPackageName().equals(serviceInfo.packageName) || (str = serviceInfo.name) == null) {
            String str2 = serviceInfo.packageName;
            String str3 = serviceInfo.name;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 94 + String.valueOf(str3).length());
            sb2.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb2.append(str2);
            sb2.append("/");
            sb2.append(str3);
            Log.e("GcmReceiver", sb2.toString());
        } else {
            if (str.startsWith(".")) {
                String valueOf = String.valueOf(context.getPackageName());
                str = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
            }
            if (Log.isLoggable("GcmReceiver", 3)) {
                String valueOf2 = String.valueOf(str);
                if (valueOf2.length() != 0) {
                    "Restricting intent to a specific service: ".concat(valueOf2);
                }
            }
            intent.setClassName(context.getPackageName(), str);
        }
        try {
            if ((context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0 ? WakefulBroadcastReceiver.startWakefulService(context, intent) : context.startService(intent)) != null) {
                return -1;
            }
            Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
            return TTAdConstant.DEEPLINK_FALLBACK_CODE;
        } catch (IllegalStateException e11) {
            String valueOf3 = String.valueOf(e11);
            StringBuilder sb3 = new StringBuilder(valueOf3.length() + 45);
            sb3.append("Failed to start service while in background: ");
            sb3.append(valueOf3);
            Log.e("GcmReceiver", sb3.toString());
            return TTAdConstant.AD_ID_IS_NULL_CODE;
        } catch (SecurityException e12) {
            Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", e12);
            return 401;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i11;
        Log.isLoggable("GcmReceiver", 3);
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (isOrderedBroadcast()) {
            setResultCode(500);
        }
        boolean z10 = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        boolean z11 = (intent.getFlags() & ASTNode.DEOP) != 0;
        if (!z10 || z11) {
            int zze = "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction()) ? zze(context, intent) : zze(context, intent);
            if (PlatformVersion.isAtLeastO() && zze == 402) {
                zzd(context, intent);
                i11 = TTAdConstant.DEEPLINK_UNAVAILABLE_CODE;
            } else {
                i11 = zze;
            }
        } else {
            i11 = zzd(context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(i11);
        }
    }
}
