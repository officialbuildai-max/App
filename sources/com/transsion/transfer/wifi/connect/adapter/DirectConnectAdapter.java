package com.transsion.transfer.wifi.connect.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Handler;
import android.os.Looper;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.g;
import com.transsion.transfer.wifi.util.i;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.net.InetAddress;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;

/* loaded from: classes6.dex */
public final class DirectConnectAdapter extends BaseWifiConnectAdapter {

    /* renamed from: f, reason: collision with root package name */
    private WifiP2PReceive f55984f;

    /* renamed from: g, reason: collision with root package name */
    private WifiP2pManager.Channel f55985g;

    /* renamed from: h, reason: collision with root package name */
    private WifiP2pDevice f55986h;

    /* renamed from: i, reason: collision with root package name */
    private InetAddress f55987i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f55988j;

    /* renamed from: k, reason: collision with root package name */
    private int f55989k;

    /* renamed from: o, reason: collision with root package name */
    private boolean f55993o;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f55983e = LazyKt.b(new Function0() { // from class: com.transsion.transfer.wifi.connect.adapter.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            WifiP2pManager z10;
            z10 = DirectConnectAdapter.z();
            return z10;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    private int f55990l = 10;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f55991m = new Handler(Looper.getMainLooper());

    /* renamed from: n, reason: collision with root package name */
    private Runnable f55992n = new Runnable() { // from class: com.transsion.transfer.wifi.connect.adapter.c
        @Override // java.lang.Runnable
        public final void run() {
            DirectConnectAdapter.I(DirectConnectAdapter.this);
        }
    };

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\r\u001a\u00020\u000b2<\u0010\f\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010RN\u0010\u0012\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/transsion/transfer/wifi/connect/adapter/DirectConnectAdapter$WifiP2PReceive;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Lkotlin/Function2;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "Landroid/content/Intent;", "intent", "", "callback", "a", "(Lkotlin/jvm/functions/Function2;)V", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lkotlin/jvm/functions/Function2;", "mCallback", "Transfer_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes6.dex */
    public static final class WifiP2PReceive extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Function2 mCallback;

        public final void a(Function2 callback) {
            Intrinsics.h(callback, "callback");
            this.mCallback = callback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Function2 function2 = this.mCallback;
            if (function2 != null) {
            }
        }
    }

    public DirectConnectAdapter() {
        WifiP2pManager y10 = y();
        this.f55985g = y10 != null ? y10.initialize(Utils.a(), Looper.getMainLooper(), null) : null;
    }

    private final void A(int i11) {
        g.d(g.f56093a, e() + " --> onFail() --> reason = " + i11, false, 2, null);
        this.f55991m.removeCallbacks(this.f55992n);
        com.transsion.transfer.wifi.connect.b h11 = h();
        if (h11 != null) {
            h11.b(i11);
        }
    }

    private final void B() {
        g.b(g.f56093a, e() + " --> onSuccess() --> mAddress = " + this.f55987i, false, 2, null);
        this.f55993o = true;
        this.f55991m.removeCallbacks(this.f55992n);
        com.transsion.transfer.wifi.connect.b h11 = h();
        if (h11 != null) {
            h11.c(this.f55987i);
        }
    }

    private final void C(Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -1772632330:
                    if (action.equals("android.net.wifi.p2p.CONNECTION_STATE_CHANGE")) {
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        g gVar = g.f56093a;
                        g.b(gVar, e() + " --> registerReceiver() --> onReceive() --> networkInfo = " + networkInfo, false, 2, null);
                        if (networkInfo == null || !networkInfo.isConnected()) {
                            if ((networkInfo != null ? networkInfo.getState() : null) == NetworkInfo.State.DISCONNECTED) {
                                this.f55988j = false;
                                F();
                                return;
                            }
                            return;
                        }
                        g.b(gVar, e() + " --> registerReceiver() --> onReceive() --> 已连接到对等设备 --> requestConnectionInfo()", false, 2, null);
                        WifiP2pGroup wifiP2pGroup = (WifiP2pGroup) intent.getParcelableExtra("p2pGroupInfo");
                        if (wifiP2pGroup != null) {
                            this.f55986h = wifiP2pGroup.getOwner();
                        }
                        WifiP2pInfo wifiP2pInfo = (WifiP2pInfo) intent.getParcelableExtra("wifiP2pInfo");
                        if (wifiP2pInfo == null || !wifiP2pInfo.groupFormed) {
                            G();
                            return;
                        } else {
                            this.f55987i = wifiP2pInfo.groupOwnerAddress;
                            B();
                            return;
                        }
                    }
                    return;
                case -1566767901:
                    if (action.equals("android.net.wifi.p2p.THIS_DEVICE_CHANGED")) {
                        WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) intent.getParcelableExtra("wifiP2pDevice");
                        g.b(g.f56093a, e() + " --> registerReceiver() --> onReceive() --> 本设备的 Wi-Fi 状态已更改 --> CONNECTED = 0｜INVITED = 1｜FAILED = 2｜AVAILABLE = 3｜UNAVAILABLE = 4 --> " + (wifiP2pDevice != null ? Integer.valueOf(wifiP2pDevice.status) : null) + " ", false, 2, null);
                        return;
                    }
                    return;
                case -1394739139:
                    action.equals("android.net.wifi.p2p.PEERS_CHANGED");
                    return;
                case 1695662461:
                    if (action.equals("android.net.wifi.p2p.STATE_CHANGED")) {
                        if (intent.getIntExtra("wifi_p2p_state", -1) == 2) {
                            g.b(g.f56093a, e() + " --> registerReceiver() --> onReceive() --> Wi-Fi P2P 已启用 -- Wi-Fi P2P is enabled.", false, 2, null);
                            return;
                        }
                        g.b(g.f56093a, e() + " --> registerReceiver() --> onReceive() --> Wi-Fi P2P 未启用 -- Wi-Fi P2P is not enabled.", false, 2, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void D() {
        if (this.f55984f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.PEERS_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
            WifiP2PReceive wifiP2PReceive = new WifiP2PReceive();
            this.f55984f = wifiP2PReceive;
            wifiP2PReceive.a(new Function2() { // from class: com.transsion.transfer.wifi.connect.adapter.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit E;
                    E = DirectConnectAdapter.E(DirectConnectAdapter.this, (Context) obj, (Intent) obj2);
                    return E;
                }
            });
            Utils.a().registerReceiver(this.f55984f, intentFilter);
            g.b(g.f56093a, e() + " --> registerReceiver() --> 广播注册成功", false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(DirectConnectAdapter directConnectAdapter, Context context, Intent intent) {
        if (directConnectAdapter.f55993o) {
            g.b(g.f56093a, directConnectAdapter.e() + " --> isSuccess = " + directConnectAdapter.f55993o + " --> 如果已经连接成功了，后续的广播就不再处理了， 这一个操作是为了兼容业务 --> 这里将导致断开重连功能失效", false, 2, null);
        } else {
            directConnectAdapter.C(intent);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        if (this.f55988j) {
            g.d(g.f56093a, e() + " --> requestConnect() --> mConnecting = " + this.f55988j, false, 2, null);
            return;
        }
        int i11 = this.f55989k;
        if (i11 >= this.f55990l) {
            g.b(g.f56093a, e() + " --> requestConnect() --> connectRetry = " + this.f55989k + " --> retryCount = " + this.f55990l + " --> 重试次数用完了,请求失败", false, 2, null);
            A(2020);
            return;
        }
        int i12 = i11 + 1;
        this.f55989k = i12;
        if (i12 == 5) {
            n0 g11 = g();
            if (g11 != null) {
                k.d(g11, null, null, new DirectConnectAdapter$requestConnect$1(this, null), 3, null);
                return;
            }
            return;
        }
        g.b(g.f56093a, e() + " --> requestConnect() --> connectRetry = " + this.f55989k + " --> retryCount = " + this.f55990l, false, 2, null);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        Unit unit = null;
        g.b(g.f56093a, e() + " --> requestConnectionInfo() --> start...", false, 2, null);
        WifiP2pManager.Channel channel = this.f55985g;
        if (channel != null) {
            WifiP2pManager y10 = y();
            if (y10 != null) {
                y10.requestConnectionInfo(channel, new WifiP2pManager.ConnectionInfoListener() { // from class: com.transsion.transfer.wifi.connect.adapter.a
                    @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
                    public final void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
                        DirectConnectAdapter.H(DirectConnectAdapter.this, wifiP2pInfo);
                    }
                });
                unit = Unit.f67184a;
            }
            if (unit != null) {
                return;
            }
        }
        A(2023);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(DirectConnectAdapter directConnectAdapter, WifiP2pInfo wifiP2pInfo) {
        g gVar = g.f56093a;
        g.b(gVar, directConnectAdapter.e() + " --> requestConnectionInfo() --> start --> info = " + wifiP2pInfo, false, 2, null);
        if (wifiP2pInfo == null) {
            n0 g11 = directConnectAdapter.g();
            if (g11 != null) {
                k.d(g11, null, null, new DirectConnectAdapter$requestConnectionInfo$1$1$2(directConnectAdapter, null), 3, null);
                return;
            }
            return;
        }
        if (!wifiP2pInfo.groupFormed) {
            n0 g12 = directConnectAdapter.g();
            if (g12 != null) {
                k.d(g12, null, null, new DirectConnectAdapter$requestConnectionInfo$1$1$1(directConnectAdapter, null), 3, null);
                return;
            }
            return;
        }
        directConnectAdapter.f55987i = wifiP2pInfo.groupOwnerAddress;
        g.b(gVar, directConnectAdapter.e() + " --> requestConnectionInfo() --> start --> 11111", false, 2, null);
        directConnectAdapter.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(DirectConnectAdapter directConnectAdapter) {
        directConnectAdapter.A(2022);
    }

    private final void J() {
        WifiP2PReceive wifiP2PReceive = this.f55984f;
        if (wifiP2PReceive != null) {
            Utils.a().unregisterReceiver(wifiP2PReceive);
            g.b(g.f56093a, e() + " --> unregisterReceiver() --> success", false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        this.f55988j = true;
        WifiP2pManager.Channel channel = this.f55985g;
        if (channel != null) {
            WifiP2pManager y10 = y();
            Unit unit = null;
            if (y10 != null) {
                y10.cancelConnect(channel, null);
            }
            WifiP2pConfig f11 = WifiUtils.f56083a.f(i(), this.f55986h);
            if (f11 == null) {
                A(2021);
                return;
            }
            g.b(g.f56093a, e() + " --> connectP2P() --> 开始连接 --> mWifiP2pManager.connect()", false, 2, null);
            WifiP2pManager y11 = y();
            if (y11 != null) {
                y11.connect(channel, f11, new WifiP2pManager.ActionListener() { // from class: com.transsion.transfer.wifi.connect.adapter.DirectConnectAdapter$connectP2P$1$1
                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onFailure(int i11) {
                        g.d(g.f56093a, DirectConnectAdapter.this.e() + " --> connectP2P() --> onFailure() --> reason = " + i11 + " --> 重试", false, 2, null);
                        DirectConnectAdapter.this.f55988j = false;
                        n0 g11 = DirectConnectAdapter.this.g();
                        if (g11 != null) {
                            k.d(g11, null, null, new DirectConnectAdapter$connectP2P$1$1$onFailure$1(DirectConnectAdapter.this, null), 3, null);
                        }
                    }

                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onSuccess() {
                        g.b(g.f56093a, DirectConnectAdapter.this.e() + " --> connectP2P() --> onSuccess() --> 等待广播通知", false, 2, null);
                    }
                });
                unit = Unit.f67184a;
            }
            if (unit != null) {
                return;
            }
        }
        A(2023);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WifiP2pManager y() {
        return (WifiP2pManager) this.f55983e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiP2pManager z() {
        Object systemService = Utils.a().getApplicationContext().getSystemService("wifip2p");
        if (systemService instanceof WifiP2pManager) {
            return (WifiP2pManager) systemService;
        }
        return null;
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void c() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.f55991m.removeCallbacksAndMessages(null);
            this.f55986h = null;
            this.f55987i = null;
            this.f55989k = 0;
            this.f55988j = false;
            i.f56094a.d(y(), this.f55985g, (r16 & 4) != 0, (r16 & 8) != 0, (r16 & 16) != 0, (r16 & 32) != 0);
            this.f55985g = null;
            J();
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f56093a, e() + " --> stop() --> p2p stop Exception = " + m1188exceptionOrNullimpl, false, 2, null);
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void d() {
        g.b(g.f56093a, e() + " --> start() --> 开启直连....", false, 2, null);
        D();
        F();
        this.f55991m.postDelayed(this.f55992n, 90000L);
    }
}
