package yv;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import aw.i;
import bw.g;
import bw.h;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tencent.mmkv.MMKV;
import com.transsion.upgradesdk.bean.UpgradeData;
import com.transsion.upgradesdk.manager.UpgradeDialogCallback;
import com.transsion.upgradesdk.manager.UpgradeInfoCallback;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class f {

    /* renamed from: o, reason: collision with root package name */
    public static final d f79190o = new d();

    /* renamed from: p, reason: collision with root package name */
    public static volatile f f79191p;

    /* renamed from: a, reason: collision with root package name */
    public vv.b f79192a;

    /* renamed from: b, reason: collision with root package name */
    public UpgradeData f79193b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f79194c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f79195d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f79196e;

    /* renamed from: f, reason: collision with root package name */
    public UpgradeInfoCallback f79197f;

    /* renamed from: g, reason: collision with root package name */
    public UpgradeDialogCallback f79198g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f79199h = true;

    /* renamed from: i, reason: collision with root package name */
    public com.transsion.upgradesdk.page.f f79200i;

    /* renamed from: j, reason: collision with root package name */
    public i f79201j;

    /* renamed from: k, reason: collision with root package name */
    public long f79202k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f79203l;

    /* renamed from: m, reason: collision with root package name */
    public List f79204m;

    /* renamed from: n, reason: collision with root package name */
    public long f79205n;

    public final void a() {
        h hVar = bw.i.f17023b;
        Application application = xv.a.f78570a;
        Application application2 = null;
        if (application == null) {
            Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
            application = null;
        }
        bw.i a11 = hVar.a(application);
        Intrinsics.h("KV_UPGRADE_LAST_SUCCESS_VERSION", "key");
        MMKV mmkv = a11.f17025a;
        long h11 = mmkv != null ? mmkv.h("KV_UPGRADE_LAST_SUCCESS_VERSION", 0L) : 0L;
        long j11 = e().f77574d;
        if (h11 != j11) {
            Application application3 = xv.a.f78570a;
            if (application3 == null) {
                Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
                application3 = null;
            }
            bw.i a12 = hVar.a(application3);
            Intrinsics.h("KV_UPGRADE_LAST_SUCCESS_VERSION", "key");
            MMKV mmkv2 = a12.f17025a;
            if (mmkv2 != null) {
                mmkv2.t("KV_UPGRADE_LAST_SUCCESS_VERSION", j11);
            }
            Application application4 = xv.a.f78570a;
            if (application4 != null) {
                application2 = application4;
            } else {
                Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
            }
            bw.i a13 = hVar.a(application2);
            Intrinsics.h("KV_UPGRADE_POPUP_TIMES", "key");
            MMKV mmkv3 = a13.f17025a;
            if (mmkv3 != null) {
                mmkv3.s("KV_UPGRADE_POPUP_TIMES", 0);
            }
            String msg = "检测到版本变化，更新存储版本: " + h11 + " -> " + j11;
            Intrinsics.h("UpgradeSdkManager", "tag");
            Intrinsics.h(msg, "msg");
            long currentTimeMillis = System.currentTimeMillis();
            if (!g.f17021a && currentTimeMillis - g.f17022b >= 5000) {
                g.f17022b = currentTimeMillis;
                if (Log.isLoggable("upgradeSdkLog", 3)) {
                    g.f17021a = true;
                }
            }
            boolean z10 = f79190o.a().f79195d;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r2.isConnected() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(int r11) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yv.f.b(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0380  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.List r32) {
        /*
            Method dump skipped, instructions count: 1420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yv.f.c(java.util.List):void");
    }

    public final void d() {
        com.transsion.upgradesdk.page.f fVar = this.f79200i;
        if (fVar != null && fVar.isVisible()) {
            fVar.dismiss();
        }
        i iVar = this.f79201j;
        if (iVar == null || !iVar.isVisible()) {
            return;
        }
        iVar.dismiss();
    }

    public final vv.b e() {
        vv.b bVar = this.f79192a;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.z("currentPackageInfo");
        return null;
    }

    public final List f() {
        h hVar = bw.i.f17023b;
        Application application = xv.a.f78570a;
        if (application == null) {
            Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
            application = null;
        }
        String a11 = hVar.a(application).a("KV_UPGRADE_LOCAL_CDN_DATA", "");
        g.b("UpgradeSdkManager", "getLocalUpgradeInfo step1 : 请求本地CDN数据");
        if (TextUtils.isEmpty(a11)) {
            g.b("UpgradeSdkManager", "getLocalUpgradeInfo step1-1: 本地无数据");
            return null;
        }
        Gson gson = bw.f.f17020a;
        Type type = new TypeToken<List<? extends UpgradeData>>() { // from class: com.transsion.upgradesdk.manager.UpgradeRealManager$getLocalUpgradeInfo$$inlined$fromJsonToList$1
        }.getType();
        Intrinsics.g(type, "getType(...)");
        List upgradeData = (List) bw.f.f17020a.fromJson(a11, type);
        if (upgradeData == null || upgradeData.isEmpty()) {
            g.b("UpgradeSdkManager", "getLocalUpgradeInfo step1-2: 本地数据为空");
            return null;
        }
        if (this.f79196e) {
            Intrinsics.h(upgradeData, "upgradeData");
            Iterator it = upgradeData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                UpgradeData upgradeData2 = (UpgradeData) it.next();
                if (upgradeData2.isForceUpdate() && !upgradeData2.checkNeedUpgrade(f79190o.a().e().f77574d)) {
                    this.f79196e = false;
                    h hVar2 = bw.i.f17023b;
                    Application application2 = xv.a.f78570a;
                    if (application2 == null) {
                        Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
                        application2 = null;
                    }
                    bw.i a12 = hVar2.a(application2);
                    Intrinsics.h("KV_UPGRADE_IS_FORCE", "key");
                    MMKV mmkv = a12.f17025a;
                    if (mmkv != null) {
                        mmkv.x("KV_UPGRADE_IS_FORCE", false);
                    }
                }
            }
        }
        this.f79204m = upgradeData;
        UpgradeData upgradeData3 = (UpgradeData) upgradeData.get(0);
        h hVar3 = bw.i.f17023b;
        Application application3 = xv.a.f78570a;
        if (application3 == null) {
            Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
            application3 = null;
        }
        bw.i a13 = hVar3.a(application3);
        Intrinsics.h("KV_UPGRADE_CDN_DATA_LAST_REQUEST_TIME", "key");
        MMKV mmkv2 = a13.f17025a;
        if (System.currentTimeMillis() - (mmkv2 != null ? mmkv2.h("KV_UPGRADE_CDN_DATA_LAST_REQUEST_TIME", 0L) : 0L) < upgradeData3.getSdkRefreshTime() * 86400000) {
            return upgradeData;
        }
        long a14 = vv.d.a("UpgradeSdkManager", "tag", "getLocalUpgradeInfo step1-3: 本地数据过期", NotificationCompat.CATEGORY_MESSAGE);
        if (!g.f17021a && a14 - g.f17022b >= 5000) {
            g.f17022b = a14;
            if (Log.isLoggable("upgradeSdkLog", 3)) {
                g.f17021a = true;
            }
        }
        boolean z10 = f79190o.a().f79195d;
        return null;
    }
}
