package com.transsion.transfer.wifi.create;

import android.provider.Settings;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter;
import com.transsion.transfer.wifi.create.adapter.b;
import com.transsion.transfer.wifi.create.adapter.c;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.f;
import com.transsion.transfer.wifi.util.g;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;

/* loaded from: classes6.dex */
public final class WifiCreateManager implements a {

    /* renamed from: a, reason: collision with root package name */
    public static final WifiCreateManager f56005a = new WifiCreateManager();

    /* renamed from: b, reason: collision with root package name */
    private static a f56006b;

    /* renamed from: c, reason: collision with root package name */
    private static b f56007c;

    /* renamed from: d, reason: collision with root package name */
    private static long f56008d;

    private WifiCreateManager() {
    }

    private final String h() {
        String simpleName = WifiCreateManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b i() {
        if (WifiUtils.f56083a.q()) {
            g.b(g.f56093a, h() + " --> initWifiAdapterWithAndroidVersion() --> wifiManager.isP2pSupported -> P2pWifiAdapter()", false, 2, null);
            return new P2PWifiAdapter();
        }
        if (Settings.System.canWrite(Utils.a().getApplicationContext())) {
            g.b(g.f56093a, h() + " --> initWifiAdapterWithAndroidVersion() --> checkCanWriteSetting(TransBaseApplication.CONTEXT) -> ApWifiAdapter()", false, 2, null);
            return new com.transsion.transfer.wifi.create.adapter.a();
        }
        g.b(g.f56093a, h() + " --> initWifiAdapterWithAndroidVersion() --> else -> LocalHostWifiAdapter()", false, 2, null);
        return new c();
    }

    @Override // com.transsion.transfer.wifi.create.a
    public void a(lv.a aVar, long j11) {
        a aVar2 = f56006b;
        if (aVar2 != null) {
            aVar2.a(aVar, System.currentTimeMillis() - f56008d);
        }
    }

    @Override // com.transsion.transfer.wifi.create.a
    public void b(int i11, long j11) {
        a aVar = f56006b;
        if (aVar != null) {
            aVar.b(i11, System.currentTimeMillis() - f56008d);
        }
        j();
    }

    public final void g(lv.a wifiInfoModel, n0 scope, a listener) {
        Intrinsics.h(wifiInfoModel, "wifiInfoModel");
        Intrinsics.h(scope, "scope");
        Intrinsics.h(listener, "listener");
        k.d(scope, null, null, new WifiCreateManager$createWifi$1(listener, wifiInfoModel, scope, null), 3, null);
    }

    public final void j() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            f56006b = null;
            g gVar = g.f56093a;
            WifiCreateManager wifiCreateManager = f56005a;
            g.h(gVar, wifiCreateManager.h() + " --> releaseWifi() --> 发送端开始释放资源", false, 2, null);
            WifiUtils.f56083a.x();
            kv.a.f68516a.b();
            f.f56090a.c();
            b bVar = f56007c;
            if (bVar != null) {
                bVar.f();
            } else {
                g.b(gVar, wifiCreateManager.h() + " --> releaseWifi() --> wifiAdapter == null", false, 2, null);
            }
            f56007c = null;
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f56093a, f56005a.h() + " --> releaseWifi() --> exception = " + m1188exceptionOrNullimpl, false, 2, null);
    }

    @Override // com.transsion.transfer.wifi.create.a
    public void onStart() {
        f56008d = System.currentTimeMillis();
        kv.c.f68519a.k();
        a aVar = f56006b;
        if (aVar != null) {
            aVar.onStart();
        }
    }
}
