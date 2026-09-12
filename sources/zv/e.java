package zv;

import android.net.ConnectivityManager;
import android.net.Network;
import com.transsion.upgradesdk.bean.UpgradeData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class e extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f79599a;

    public e(f fVar) {
        this.f79599a = fVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        Intrinsics.h(network, "network");
        super.onAvailable(network);
        try {
            f fVar = this.f79599a;
            bw.g.b(fVar.f79604d, "CDNConfigNet step1-1:start");
            yv.d dVar = yv.f.f79190o;
            if (dVar.a().f79203l) {
                bw.g.b(fVar.f79604d, "CDNConfigNet step1-2: cached");
                return;
            }
            if (((d) d.f79595d.getValue()).f79598c == 1) {
                bw.g.b(fVar.f79604d, "CDNConfigNet step1-3: requesting");
                return;
            }
            UpgradeData upgradeData = dVar.a().f79193b;
            int cdnRequestIntervalHours = upgradeData != null ? upgradeData.getCdnRequestIntervalHours() : 6;
            if (fVar.f79603c > 0 && System.currentTimeMillis() - fVar.f79603c < cdnRequestIntervalHours * 3600 * 1000) {
                bw.g.b(fVar.f79604d, "CDNConfigNet step1-3: request interval");
            } else {
                fVar.f79603c = System.currentTimeMillis();
                dVar.a().b(2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        Intrinsics.h(network, "network");
        super.onLost(network);
    }
}
