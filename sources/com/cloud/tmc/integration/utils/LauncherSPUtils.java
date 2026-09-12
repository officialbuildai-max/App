package com.cloud.tmc.integration.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0001H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0012J&\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0012J&\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/cloud/tmc/integration/utils/LauncherSPUtils;", "", "()V", "REPLACE_STR", "", "TAG", "getTAG", "()Ljava/lang/String;", "buildUri", "Landroid/net/Uri;", EventConstants.KEY_ACTION, "spName", "key", AppMeasurementSdk.ConditionalUserProperty.VALUE, "checkStr", "str", "getAuthorStr", "getBoolean", "", "context", "Landroid/content/Context;", "defaultValue", "getString", "putBoolean", "putSting", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class LauncherSPUtils {
    private static final String REPLACE_STR = "_spPH_";
    public static final LauncherSPUtils INSTANCE = new LauncherSPUtils();
    private static final String TAG = "SelectLanguageUtils";

    private LauncherSPUtils() {
    }

    private final Uri buildUri(String action, String spName, String key, Object value) {
        TmcLogger.d(TAG, getAuthorStr());
        String str = "content://" + getAuthorStr() + ".spProvider/";
        String checkStr = checkStr(spName);
        String checkStr2 = checkStr(key);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(value);
        return Uri.parse(str + action + "/" + checkStr + "/" + checkStr2 + "/" + checkStr(sb2.toString()));
    }

    private final String checkStr(String str) {
        return new Regex("/").replace(str, REPLACE_STR);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (r0.equals(com.cloud.tmc.kernel.constants.TmcConstants.HI_LAUNCHER_PACKAGE_NAME_UPGRADE) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (r0.equals(com.cloud.tmc.kernel.constants.TmcConstants.HI_LAUNCHER_PACKAGE_NAME) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        return "com.transsion.xlauncher.library.hios";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String getAuthorStr() {
        /*
            r4 = this;
            android.app.Application r0 = com.cloud.tmc.miniutils.util.Utils.getApp()
            java.lang.String r0 = r0.getPackageName()
            if (r0 == 0) goto L54
            int r1 = r0.hashCode()
            java.lang.String r2 = "com.transsion.xlauncher.library.xos"
            java.lang.String r3 = "com.transsion.xlauncher.library.hios"
            switch(r1) {
                case -1863309634: goto L48;
                case -1766538675: goto L3f;
                case -221831106: goto L36;
                case 310235112: goto L2a;
                case 1323871340: goto L21;
                case 1683203871: goto L16;
                default: goto L15;
            }
        L15:
            goto L54
        L16:
            java.lang.String r1 = "com.transsion.hilauncher"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1f
            goto L54
        L1f:
            r2 = r3
            goto L56
        L21:
            java.lang.String r1 = "com.transsion.XOSLauncher.upgrade"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L56
            goto L54
        L2a:
            java.lang.String r1 = "com.transsion.walauncher"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L33
            goto L54
        L33:
            java.lang.String r2 = "com.transsion.xlauncher.library.quick"
            goto L56
        L36:
            java.lang.String r1 = "com.transsion.XOSLauncher"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L56
            goto L54
        L3f:
            java.lang.String r1 = "com.transsion.hilauncher.upgrade"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1f
            goto L54
        L48:
            java.lang.String r1 = "com.transsion.itel.launcher"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L51
            goto L54
        L51:
            java.lang.String r2 = "com.transsion.xlauncher.library.itel"
            goto L56
        L54:
            java.lang.String r2 = ""
        L56:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.LauncherSPUtils.getAuthorStr():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r0 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean getBoolean(android.content.Context r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.h(r10, r0)
            java.lang.String r0 = "spName"
            kotlin.jvm.internal.Intrinsics.h(r11, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.h(r12, r0)
            r0 = 0
            java.lang.String r1 = "boolean"
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r13)     // Catch: java.lang.Throwable -> L43
            android.net.Uri r4 = r9.buildUri(r1, r11, r12, r2)     // Catch: java.lang.Throwable -> L43
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L43
            kotlin.jvm.internal.Intrinsics.e(r4)     // Catch: java.lang.Throwable -> L43
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L2c
            return r13
        L2c:
            boolean r10 = r0.moveToNext()     // Catch: java.lang.Throwable -> L43
            if (r10 == 0) goto L45
            java.lang.String r10 = "SPCOLUMNNAME"
            int r10 = r0.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L43
            if (r10 < 0) goto L45
            java.lang.String r10 = r0.getString(r10)     // Catch: java.lang.Throwable -> L43
            boolean r13 = java.lang.Boolean.parseBoolean(r10)     // Catch: java.lang.Throwable -> L43
            goto L45
        L43:
            r10 = move-exception
            goto L49
        L45:
            r0.close()
            goto L51
        L49:
            java.lang.String r11 = com.cloud.tmc.integration.utils.LauncherSPUtils.TAG     // Catch: java.lang.Throwable -> L52
            com.cloud.tmc.kernel.log.TmcLogger.e(r11, r10)     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L51
            goto L45
        L51:
            return r13
        L52:
            r10 = move-exception
            if (r0 == 0) goto L58
            r0.close()
        L58:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.LauncherSPUtils.getBoolean(android.content.Context, java.lang.String, java.lang.String, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        if (r0 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getString(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            java.lang.String r0 = "spName"
            kotlin.jvm.internal.Intrinsics.h(r10, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.h(r11, r0)
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.h(r12, r0)
            r0 = 0
            java.lang.String r1 = "string"
            android.net.Uri r3 = r8.buildUri(r1, r10, r11, r12)     // Catch: java.lang.Throwable -> L2f
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r9 = "context.contentResolver"
            kotlin.jvm.internal.Intrinsics.g(r2, r9)     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L31
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2f
            goto L31
        L2f:
            r9 = move-exception
            goto L51
        L31:
            if (r0 == 0) goto L4b
            boolean r9 = r0.moveToNext()     // Catch: java.lang.Throwable -> L2f
            if (r9 == 0) goto L4b
            java.lang.String r9 = "SPCOLUMNNAME"
            int r9 = r0.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L2f
            if (r9 < 0) goto L4b
            java.lang.String r9 = r0.getString(r9)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r10 = "it.getString(index)"
            kotlin.jvm.internal.Intrinsics.g(r9, r10)     // Catch: java.lang.Throwable -> L2f
            r12 = r9
        L4b:
            if (r0 == 0) goto L59
        L4d:
            r0.close()
            goto L59
        L51:
            java.lang.String r10 = com.cloud.tmc.integration.utils.LauncherSPUtils.TAG     // Catch: java.lang.Throwable -> L5a
            com.cloud.tmc.kernel.log.TmcLogger.e(r10, r9)     // Catch: java.lang.Throwable -> L5a
            if (r0 == 0) goto L59
            goto L4d
        L59:
            return r12
        L5a:
            r9 = move-exception
            if (r0 == 0) goto L60
            r0.close()
        L60:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.LauncherSPUtils.getString(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public final String getTAG() {
        return TAG;
    }

    public final boolean putBoolean(Context context, String spName, String key, boolean value) {
        Intrinsics.h(context, "context");
        Intrinsics.h(spName, "spName");
        Intrinsics.h(key, "key");
        try {
            Uri buildUri = buildUri("boolean", spName, key, Boolean.valueOf(value));
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(key, Boolean.valueOf(value));
            if (buildUri == null) {
                return true;
            }
            contentResolver.insert(buildUri, contentValues);
            return true;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return false;
        }
    }

    public final boolean putSting(Context context, String spName, String key, String value) {
        Intrinsics.h(context, "context");
        Intrinsics.h(spName, "spName");
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        try {
            Uri buildUri = buildUri("string", spName, key, value);
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(key, value);
            if (buildUri == null) {
                return true;
            }
            contentResolver.insert(buildUri, contentValues);
            return true;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return false;
        }
    }
}
