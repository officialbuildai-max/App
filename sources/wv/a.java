package wv;

import android.app.Application;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import bw.g;
import bw.h;
import bw.i;
import bw.l;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tencent.mmkv.MMKV;
import com.transsion.upgradesdk.bean.UpgradeData;
import kotlin.jvm.internal.Intrinsics;
import vv.d;
import yv.f;

/* loaded from: classes7.dex */
public abstract class a {
    public static boolean a(UpgradeData upgradeData) {
        Application application;
        Intrinsics.h(upgradeData, "upgradeData");
        if (upgradeData.isForceUpdate()) {
            return true;
        }
        try {
            h hVar = i.f17023b;
            Application application2 = xv.a.f78570a;
            if (application2 != null) {
                application = application2;
            } else {
                Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
                application = null;
            }
            i a11 = hVar.a(application);
            Intrinsics.h("KV_UPGRADE_LAST_TARGET_VERSION", "key");
            MMKV mmkv = a11.f17025a;
            long h11 = mmkv != null ? mmkv.h("KV_UPGRADE_LAST_TARGET_VERSION", 0L) : 0L;
            if (h11 != upgradeData.getPkgVersion()) {
                String msg = "filter  ->> 目标版本变化，重置弹窗次数。last=" + h11 + ", current=" + upgradeData.getPkgVersion();
                Intrinsics.h("ValidateCheckUtils", "tag");
                Intrinsics.h(msg, "msg");
                long currentTimeMillis = System.currentTimeMillis();
                if (!g.f17021a && currentTimeMillis - g.f17022b >= 5000) {
                    g.f17022b = currentTimeMillis;
                    if (Log.isLoggable("upgradeSdkLog", 3)) {
                        g.f17021a = true;
                    }
                    boolean z10 = g.f17021a;
                }
                boolean z11 = f.f79190o.a().f79195d;
                Application application3 = xv.a.f78570a;
                if (application3 == null) {
                    Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
                    application3 = null;
                }
                i a12 = hVar.a(application3);
                long pkgVersion = upgradeData.getPkgVersion();
                Intrinsics.h("KV_UPGRADE_LAST_TARGET_VERSION", "key");
                MMKV mmkv2 = a12.f17025a;
                if (mmkv2 != null) {
                    mmkv2.t("KV_UPGRADE_LAST_TARGET_VERSION", pkgVersion);
                }
                Application application4 = xv.a.f78570a;
                if (application4 == null) {
                    Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
                    application4 = null;
                }
                i a13 = hVar.a(application4);
                Intrinsics.h("KV_UPGRADE_POPUP_TIMES", "key");
                MMKV mmkv3 = a13.f17025a;
                if (mmkv3 != null) {
                    mmkv3.s("KV_UPGRADE_POPUP_TIMES", 0);
                }
                l.a(2, 3, "reset_target_version", null, 24);
            }
        } catch (Exception unused) {
            long a14 = d.a("ValidateCheckUtils", "tag", "目标版本频控检查异常", NotificationCompat.CATEGORY_MESSAGE);
            boolean z12 = g.f17021a;
            if (!z12 && a14 - g.f17022b >= 5000) {
                g.f17022b = a14;
                if (Log.isLoggable("upgradeSdkLog", 3)) {
                    g.f17021a = true;
                }
                z12 = g.f17021a;
            }
            if (f.f79190o.a().f79195d || z12) {
                Log.e("ValidateCheckUtils", "目标版本频控检查异常");
            }
        }
        if (!upgradeData.checkDialogPopInterval()) {
            l.a(2, 6, "1", null, 24);
            return false;
        }
        if (upgradeData.checkDialogPopTimes()) {
            return true;
        }
        long a15 = d.a("ValidateCheckUtils", "tag", "filter  ->> 弹窗次数", NotificationCompat.CATEGORY_MESSAGE);
        if (!g.f17021a && a15 - g.f17022b >= 5000) {
            g.f17022b = a15;
            if (Log.isLoggable("upgradeSdkLog", 3)) {
                g.f17021a = true;
            }
            boolean z13 = g.f17021a;
        }
        boolean z14 = f.f79190o.a().f79195d;
        l.a(2, 6, "2", null, 24);
        return false;
    }
}
