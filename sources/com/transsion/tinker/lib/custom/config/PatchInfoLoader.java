package com.transsion.tinker.lib.custom.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.transsion.tinker.lib.custom.check.BffCheckUpdateData;
import com.transsion.tinker.lib.custom.check.BffPatchInfo;
import com.transsion.tinker.lib.custom.check.CheckUpdateResponse;
import java.util.List;
import ou.d;
import zg.c;

/* loaded from: classes6.dex */
public abstract class PatchInfoLoader {

    /* loaded from: classes6.dex */
    public enum LoadStatus {
        AVAILABLE,
        REVOKED_BY_SERVER,
        NETWORK_ERROR
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final LoadStatus f55199a;

        /* renamed from: b, reason: collision with root package name */
        public final d f55200b;

        private a(LoadStatus loadStatus, d dVar) {
            this.f55199a = loadStatus;
            this.f55200b = dVar;
        }

        public static a a(d dVar) {
            return new a(LoadStatus.AVAILABLE, dVar);
        }

        public static a b() {
            return new a(LoadStatus.NETWORK_ERROR, null);
        }

        public static a c() {
            return new a(LoadStatus.REVOKED_BY_SERVER, null);
        }
    }

    private static d a(BffPatchInfo bffPatchInfo) {
        String str;
        String str2 = bffPatchInfo.bundleUrl;
        if (str2 == null || str2.trim().isEmpty()) {
            ShareTinkerLog.i("Tinker.PatchInfoLoader", "patchInfo.bundleUrl is empty, skip", new Object[0]);
            return null;
        }
        if (!str2.toLowerCase().startsWith("https://")) {
            ShareTinkerLog.w("Tinker.PatchInfoLoader", "patchInfo.bundleUrl must be HTTPS, skip: %s", str2);
            return null;
        }
        String str3 = bffPatchInfo.tinkerId;
        if (str3 == null || str3.trim().isEmpty()) {
            ShareTinkerLog.w("Tinker.PatchInfoLoader", "patchInfo.tinkerId is empty, Tinker install will fail, skip", new Object[0]);
            return null;
        }
        String str4 = bffPatchInfo.f55198id;
        if (str4 == null || str4.trim().isEmpty()) {
            str = "hotfix_bff";
        } else {
            str = "hotfix_" + bffPatchInfo.f55198id.trim();
        }
        d.b x10 = new d.b(str2.trim(), str).y(str3.trim()).x(bffPatchInfo.patchSize);
        String str5 = bffPatchInfo.bundleMd5;
        if (str5 != null && !str5.trim().isEmpty()) {
            x10.u(bffPatchInfo.bundleMd5);
        }
        d q11 = x10.q();
        ShareTinkerLog.i("Tinker.PatchInfoLoader", "loaded pending patch: patchId=%s tinkerId=%s", q11.f(), q11.j());
        return q11;
    }

    private static long b(Context context) {
        long longVersionCode;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (Build.VERSION.SDK_INT < 28) {
                return packageInfo.versionCode;
            }
            longVersionCode = packageInfo.getLongVersionCode();
            return longVersionCode;
        } catch (Throwable th2) {
            ShareTinkerLog.e("Tinker.PatchInfoLoader", "getVersionCode failed: %s", th2.getMessage());
            return -1L;
        }
    }

    private static boolean c(String str) {
        try {
            String F = ou.a.s().F();
            if (F != null && !F.trim().isEmpty()) {
                boolean equalsIgnoreCase = str.trim().equalsIgnoreCase(F.trim());
                ShareTinkerLog.i("Tinker.PatchInfoLoader", "isAbiExactMatch: patch.abiFilter=%s local.ndkFilter=%s matched=%b", str, F, Boolean.valueOf(equalsIgnoreCase));
                return equalsIgnoreCase;
            }
            ShareTinkerLog.w("Tinker.PatchInfoLoader", "isAbiExactMatch: ndkFilter not set in HotfixConfig, treat as matched", new Object[0]);
            return true;
        } catch (Throwable th2) {
            ShareTinkerLog.w("Tinker.PatchInfoLoader", "isAbiExactMatch failed: %s, treat as matched", th2.getMessage());
            return true;
        }
    }

    public static a d(Context context) {
        BffCheckUpdateData bffCheckUpdateData;
        String t11 = ou.a.s().t();
        try {
            pu.a aVar = (pu.a) c.f79537e.a().h(pu.a.class);
            String u11 = ou.a.s().u();
            ShareTinkerLog.i("Tinker.PatchInfoLoader", "loadPatchInfo: appPath=%s channel=%s", t11, u11);
            CheckUpdateResponse checkUpdateResponse = (CheckUpdateResponse) aVar.a(t11, "", u11).execute().a();
            if (checkUpdateResponse != null && checkUpdateResponse.code == 0 && (bffCheckUpdateData = checkUpdateResponse.data) != null) {
                List<BffPatchInfo> list = bffCheckUpdateData.hotUpdates;
                if (list != null && !list.isEmpty()) {
                    long b11 = b(context);
                    d dVar = null;
                    d dVar2 = null;
                    for (BffPatchInfo bffPatchInfo : list) {
                        if (bffPatchInfo != null && bffPatchInfo.targetVersionCode == b11) {
                            String str = bffPatchInfo.abiFilter;
                            String trim = str == null ? "" : str.trim();
                            if (!trim.isEmpty()) {
                                if (c(trim) && (dVar2 = a(bffPatchInfo)) != null) {
                                    break;
                                }
                            } else if (dVar == null) {
                                dVar = a(bffPatchInfo);
                            }
                        }
                    }
                    if (dVar2 != null) {
                        dVar = dVar2;
                    }
                    if (dVar != null) {
                        ShareTinkerLog.i("Tinker.PatchInfoLoader", "check-update: selected patch patchId=%s (exactMatch=%b)", dVar.f(), Boolean.valueOf(dVar2 != null));
                        return a.a(dVar);
                    }
                    ShareTinkerLog.i("Tinker.PatchInfoLoader", "check-update: no patch matched versionCode=%d, server revoked patch", Long.valueOf(b11));
                    return a.c();
                }
                ShareTinkerLog.i("Tinker.PatchInfoLoader", "check-update: hotUpdates empty, server revoked patch", new Object[0]);
                return a.c();
            }
            ShareTinkerLog.i("Tinker.PatchInfoLoader", "check-update: no valid response, treat as network error", new Object[0]);
            return a.b();
        } catch (Exception e11) {
            ShareTinkerLog.e("Tinker.PatchInfoLoader", "loadPatchInfo failed: %s", e11.getMessage());
            return a.b();
        }
    }
}
