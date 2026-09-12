package yv;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import bw.g;
import bw.l;
import bw.n;
import com.transsion.upgradesdk.bean.UpgradeData;
import com.transsion.upgradesdk.manager.UpgradeDialogCallback;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class e implements UpgradeDialogCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f79188a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f79189b;

    public e(f fVar, boolean z10) {
        this.f79188a = fVar;
        this.f79189b = z10;
    }

    @Override // com.transsion.upgradesdk.manager.UpgradeDialogCallback
    public final void onDialogClick(int i11) {
        String str;
        String msg = "自定义弹窗按钮点击: " + i11;
        Intrinsics.h("UpgradeSdkManager", "tag");
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
        UpgradeData upgradeData = this.f79188a.f79193b;
        int i12 = (upgradeData == null || !upgradeData.isForceUpdate()) ? 1 : 2;
        f fVar = this.f79188a;
        boolean z12 = this.f79189b;
        fVar.getClass();
        if (i11 != 1) {
            str = i11 != 2 ? i11 != 3 ? i11 != 4 ? "back_exit" : "back" : "later" : "exitapp";
        } else {
            UpgradeData upgradeData2 = fVar.f79193b;
            if (upgradeData2 != null && fVar.f79194c) {
                n.c(upgradeData2.getPkg(), upgradeData2.getDirectDwl(), upgradeData2.getHoverBtn(), com.transsion.upgradesdk.manager.f.f56716a);
            }
            str = "update";
        }
        l.e(i12, z12, str, com.transsion.upgradesdk.bean.c.f56713d);
    }

    @Override // com.transsion.upgradesdk.manager.UpgradeDialogCallback
    public final void onDialogDismiss() {
        long a11 = vv.d.a("UpgradeSdkManager", "tag", "自定义弹窗关闭", NotificationCompat.CATEGORY_MESSAGE);
        int i11 = 1;
        if (!g.f17021a && a11 - g.f17022b >= 5000) {
            g.f17022b = a11;
            if (Log.isLoggable("upgradeSdkLog", 3)) {
                g.f17021a = true;
            }
            boolean z10 = g.f17021a;
        }
        boolean z11 = f.f79190o.a().f79195d;
        UpgradeData upgradeData = this.f79188a.f79193b;
        if (upgradeData != null && upgradeData.isForceUpdate()) {
            i11 = 2;
        }
        l.e(i11, this.f79189b, "dismiss", com.transsion.upgradesdk.bean.c.f56713d);
    }

    @Override // com.transsion.upgradesdk.manager.UpgradeDialogCallback
    public final void onDialogShow() {
        long a11 = vv.d.a("UpgradeSdkManager", "tag", "自定义弹窗显示", NotificationCompat.CATEGORY_MESSAGE);
        int i11 = 1;
        if (!g.f17021a && a11 - g.f17022b >= 5000) {
            g.f17022b = a11;
            if (Log.isLoggable("upgradeSdkLog", 3)) {
                g.f17021a = true;
            }
            boolean z10 = g.f17021a;
        }
        boolean z11 = f.f79190o.a().f79195d;
        UpgradeData upgradeData = this.f79188a.f79193b;
        if (upgradeData != null && upgradeData.isForceUpdate()) {
            i11 = 2;
        }
        l.d(i11, this.f79189b, com.transsion.upgradesdk.bean.c.f56713d);
    }
}
