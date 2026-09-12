package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.b;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
/* loaded from: classes3.dex */
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;
    private static Boolean zzj;

    /* JADX WARN: Can't wrap try/catch for region: R(25:1|(2:2|3)|4|(22:54|55|7|8|9|10|11|12|13|(13:46|47|16|(10:41|42|19|(7:36|37|22|(6:28|29|31|32|25|26)|24|25|26)|21|22|(0)|24|25|26)|18|19|(0)|21|22|(0)|24|25|26)|15|16|(0)|18|19|(0)|21|22|(0)|24|25|26)|6|7|8|9|10|11|12|13|(0)|15|16|(0)|18|19|(0)|21|22|(0)|24|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x004b, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x003b, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            r0 = 2
            r1 = 0
            r2 = 1
            java.lang.String r3 = "add"
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            int r5 = android.os.Process.myUid()
            com.google.android.gms.common.util.WorkSourceUtil.zza = r5
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L19
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L19
            r6[r1] = r7     // Catch: java.lang.Exception -> L19
            java.lang.reflect.Method r6 = r4.getMethod(r3, r6)     // Catch: java.lang.Exception -> L19
            goto L1a
        L19:
            r6 = r5
        L1a:
            com.google.android.gms.common.util.WorkSourceUtil.zzb = r6
            boolean r6 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r6 == 0) goto L31
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L31
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L31
            r6[r1] = r8     // Catch: java.lang.Exception -> L31
            r6[r2] = r7     // Catch: java.lang.Exception -> L31
            java.lang.reflect.Method r3 = r4.getMethod(r3, r6)     // Catch: java.lang.Exception -> L31
            goto L32
        L31:
            r3 = r5
        L32:
            com.google.android.gms.common.util.WorkSourceUtil.zzc = r3
            java.lang.String r3 = "size"
            java.lang.reflect.Method r3 = r4.getMethod(r3, r5)     // Catch: java.lang.Exception -> L3b
            goto L3c
        L3b:
            r3 = r5
        L3c:
            com.google.android.gms.common.util.WorkSourceUtil.zzd = r3
            java.lang.String r3 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L4b
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L4b
            r6[r1] = r8     // Catch: java.lang.Exception -> L4b
            java.lang.reflect.Method r3 = r4.getMethod(r3, r6)     // Catch: java.lang.Exception -> L4b
            goto L4c
        L4b:
            r3 = r5
        L4c:
            com.google.android.gms.common.util.WorkSourceUtil.zze = r3
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r3 == 0) goto L61
            java.lang.String r3 = "getName"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L61
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L61
            r6[r1] = r8     // Catch: java.lang.Exception -> L61
            java.lang.reflect.Method r3 = r4.getMethod(r3, r6)     // Catch: java.lang.Exception -> L61
            goto L62
        L61:
            r3 = r5
        L62:
            com.google.android.gms.common.util.WorkSourceUtil.zzf = r3
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r6 = "WorkSourceUtil"
            if (r3 == 0) goto L79
            java.lang.String r3 = "createWorkChain"
            java.lang.reflect.Method r3 = r4.getMethod(r3, r5)     // Catch: java.lang.Exception -> L73
            goto L7a
        L73:
            r3 = move-exception
            java.lang.String r8 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r6, r8, r3)
        L79:
            r3 = r5
        L7a:
            com.google.android.gms.common.util.WorkSourceUtil.zzg = r3
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r3 == 0) goto L9d
            java.lang.String r3 = "android.os.WorkSource$WorkChain"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L97
            java.lang.String r8 = "addNode"
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L97
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L97
            r0[r1] = r9     // Catch: java.lang.Exception -> L97
            r0[r2] = r7     // Catch: java.lang.Exception -> L97
            java.lang.reflect.Method r0 = r3.getMethod(r8, r0)     // Catch: java.lang.Exception -> L97
            goto L9e
        L97:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r6, r1, r0)
        L9d:
            r0 = r5
        L9e:
            com.google.android.gms.common.util.WorkSourceUtil.zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto Lb0
            java.lang.String r0 = "isEmpty"
            java.lang.reflect.Method r0 = r4.getMethod(r0, r5)     // Catch: java.lang.Exception -> Lb0
            r0.setAccessible(r2)     // Catch: java.lang.Exception -> Lb1
            goto Lb1
        Lb0:
            r0 = r5
        Lb1:
            com.google.android.gms.common.util.WorkSourceUtil.zzi = r0
            com.google.android.gms.common.util.WorkSourceUtil.zzj = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    @KeepForSdk
    public static void add(@NonNull WorkSource workSource, int i11, @NonNull String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i11), str);
                return;
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
                return;
            }
        }
        Method method2 = zzb;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i11));
            } catch (Exception e12) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e12);
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static WorkSource fromPackage(@NonNull Context context, @NonNull String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i11 = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i11, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public static WorkSource fromPackageAndModuleExperimentalPi(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i11 = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
            } else {
                i11 = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
        }
        if (i11 < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            add(workSource, i11, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, null);
                int i12 = zza;
                if (i11 != i12) {
                    method.invoke(invoke, Integer.valueOf(i11), str);
                }
                method.invoke(invoke, Integer.valueOf(i12), str2);
            } catch (Exception e11) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e11);
            }
        }
        return workSource;
    }

    @KeepForSdk
    public static int get(@NonNull WorkSource workSource, int i11) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, Integer.valueOf(i11));
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            }
        }
        return 0;
    }

    @NonNull
    @KeepForSdk
    public static String getName(@NonNull WorkSource workSource, int i11) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i11));
        } catch (Exception e11) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            return null;
        }
    }

    @NonNull
    @KeepForSdk
    public static List<String> getNames(@NonNull WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int size = workSource == null ? 0 : size(workSource);
        if (size != 0) {
            for (int i11 = 0; i11 < size; i11++) {
                String name = getName(workSource, i11);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static synchronized boolean hasWorkSourcePermission(@NonNull Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (context == null) {
                return false;
            }
            boolean z10 = b.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0;
            zzj = Boolean.valueOf(z10);
            return z10;
        }
    }

    @KeepForSdk
    public static boolean isEmpty(@NonNull WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, null);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e11) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e11);
            }
        }
        return size(workSource) == 0;
    }

    @KeepForSdk
    public static int size(@NonNull WorkSource workSource) {
        Method method = zzd;
        if (method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(workSource, null);
            Preconditions.checkNotNull(invoke);
            return ((Integer) invoke).intValue();
        } catch (Exception e11) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            return 0;
        }
    }
}
