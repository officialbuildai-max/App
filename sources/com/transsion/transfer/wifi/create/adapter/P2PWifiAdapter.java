package com.transsion.transfer.wifi.create.adapter;

import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.transsion.transfer.wifi.util.WifiUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class P2PWifiAdapter extends b {

    /* renamed from: e, reason: collision with root package name */
    private int f56010e;

    /* renamed from: f, reason: collision with root package name */
    private int f56011f;

    /* renamed from: h, reason: collision with root package name */
    private WifiP2pManager.Channel f56013h;

    /* renamed from: d, reason: collision with root package name */
    private final int f56009d = 10;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f56012g = LazyKt.b(new Function0() { // from class: com.transsion.transfer.wifi.create.adapter.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            WifiP2pManager G;
            G = P2PWifiAdapter.G();
            return G;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a implements WifiP2pManager.ActionListener {
        a() {
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i11) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, P2PWifiAdapter.this.b() + " --> setDeviceName() --> 反射创建 --> onFailure() --> reason = " + com.transsion.transfer.wifi.util.i.f56094a.b(i11) + " --> 失败重试", false, 2, null);
            P2PWifiAdapter.this.E();
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            String string = Settings.Global.getString(Utils.a().getApplicationContext().getContentResolver(), "wifi_p2p_device_name");
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, P2PWifiAdapter.this.b() + " --> setDeviceName() --> 反射创建 --> onSuccess() --> deviceName = " + string, false, 2, null);
            P2PWifiAdapter.this.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(P2PWifiAdapter p2PWifiAdapter, WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo) {
        if (wifiP2pInfo == null) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, p2PWifiAdapter.b() + " --> requestConnectionInfo() --> 获取可连接信息失败 (p2pInfo == null)", false, 2, null);
            p2PWifiAdapter.D();
            return;
        }
        InetAddress inetAddress = wifiP2pInfo.groupOwnerAddress;
        com.transsion.transfer.wifi.util.g gVar = com.transsion.transfer.wifi.util.g.f56093a;
        com.transsion.transfer.wifi.util.g.b(gVar, p2PWifiAdapter.b() + " --> requestConnectionInfo() --> Group Owner Address = " + inetAddress, false, 2, null);
        String v11 = p2PWifiAdapter.v(inetAddress);
        if (TextUtils.isEmpty(v11)) {
            com.transsion.transfer.wifi.util.g.b(gVar, p2PWifiAdapter.b() + " --> requestConnectionInfo() --> 获取可连接Ip失败 --> correctIp 为空", false, 2, null);
            p2PWifiAdapter.D();
            return;
        }
        lv.a e11 = p2PWifiAdapter.e();
        if (e11 != null) {
            e11.H(wifiP2pGroup.getNetworkName());
        }
        lv.a e12 = p2PWifiAdapter.e();
        if (e12 != null) {
            e12.G(wifiP2pGroup.getPassphrase());
        }
        lv.a e13 = p2PWifiAdapter.e();
        if (e13 != null) {
            e13.F(v11);
        }
        com.transsion.transfer.wifi.util.g.b(gVar, p2PWifiAdapter.b() + " --> requestConnectionInfo() --> 最终ip为 correctIp = " + v11, false, 2, null);
        n0 c11 = p2PWifiAdapter.c();
        if (c11 != null) {
            kotlinx.coroutines.k.d(c11, null, null, new P2PWifiAdapter$requestConnectionInfo$1$1$1(p2PWifiAdapter, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x008c, code lost:
    
        if (r10 == null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$requestGroupInfo$1
            if (r0 == 0) goto L13
            r0 = r10
            com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$requestGroupInfo$1 r0 = (com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$requestGroupInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$requestGroupInfo$1 r0 = new com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$requestGroupInfo$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L34
            if (r2 != r5) goto L2c
            kotlin.ResultKt.b(r10)
            goto L74
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L34:
            kotlin.ResultKt.b(r10)
            int r10 = r9.f56011f
            int r2 = r9.f56009d
            if (r10 < r2) goto L45
            r10 = 101(0x65, float:1.42E-43)
            r9.x(r10)
            kotlin.Unit r10 = kotlin.Unit.f67184a
            return r10
        L45:
            com.transsion.transfer.wifi.util.g r10 = com.transsion.transfer.wifi.util.g.f56093a
            java.lang.String r2 = r9.b()
            int r7 = r9.f56011f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            java.lang.String r2 = " --> requestGroupInfo() --> Wi-Fi P2P 创建成功之后，将自己添加到群组 --> 第"
            r8.append(r2)
            r8.append(r7)
            java.lang.String r2 = " 次获取热点相关信息"
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            com.transsion.transfer.wifi.util.g.b(r10, r2, r4, r3, r6)
            r0.label = r5
            r7 = 300(0x12c, double:1.48E-321)
            java.lang.Object r10 = kotlinx.coroutines.u0.a(r7, r0)
            if (r10 != r1) goto L74
            return r1
        L74:
            android.net.wifi.p2p.WifiP2pManager$Channel r10 = r9.f56013h
            if (r10 == 0) goto L8e
            android.net.wifi.p2p.WifiP2pManager r10 = r9.w()
            if (r10 == 0) goto L8b
            android.net.wifi.p2p.WifiP2pManager$Channel r0 = r9.f56013h
            com.transsion.transfer.wifi.create.adapter.k r1 = new com.transsion.transfer.wifi.create.adapter.k
            r1.<init>()
            r10.requestGroupInfo(r0, r1)
            kotlin.Unit r10 = kotlin.Unit.f67184a
            goto L8c
        L8b:
            r10 = r6
        L8c:
            if (r10 != 0) goto Lab
        L8e:
            com.transsion.transfer.wifi.util.g r10 = com.transsion.transfer.wifi.util.g.f56093a
            java.lang.String r0 = r9.b()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " --> requestGroupInfo() --> p2pChannel == null --> 失败重试 --> retryCreate()"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.transsion.transfer.wifi.util.g.b(r10, r0, r4, r3, r6)
            r9.E()
        Lab:
            kotlin.Unit r10 = kotlin.Unit.f67184a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter.B(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(P2PWifiAdapter p2PWifiAdapter, WifiP2pGroup wifiP2pGroup) {
        if (wifiP2pGroup != null) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, p2PWifiAdapter.b() + " --> requestGroupInfo() --> requestGroupInfo() --> 获取Group信息成功,开始获取连接信息", false, 2, null);
            p2PWifiAdapter.z(wifiP2pGroup);
            return;
        }
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, p2PWifiAdapter.b() + " --> requestGroupInfo() --> 获取Group信息失败 --> wifiP2pGroup == null", false, 2, null);
        p2PWifiAdapter.D();
    }

    private final void D() {
        n0 c11 = c();
        if (c11 != null) {
            kotlinx.coroutines.k.d(c11, null, null, new P2PWifiAdapter$retry$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        int i11 = this.f56010e + 1;
        this.f56010e = i11;
        if (i11 > this.f56009d) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> retryCreate() --> 重试次数 = " + this.f56010e + "，判定创建热点失败", false, 2, null);
            x(102);
            return;
        }
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> retryCreate() --> 重新创建热点 -- 失败次数 = " + this.f56010e, false, 2, null);
        int i12 = this.f56010e;
        if (i12 <= 1 || i12 == 5) {
            r();
            return;
        }
        n0 c11 = c();
        if (c11 != null) {
            kotlinx.coroutines.k.d(c11, null, null, new P2PWifiAdapter$retryCreate$1(this, null), 3, null);
        }
    }

    private final void F() {
        Object m1185constructorimpl;
        a aVar = new a();
        try {
            Result.Companion companion = Result.INSTANCE;
            WifiP2pManager w11 = w();
            if (w11 != null) {
                Method declaredMethod = w11.getClass().getDeclaredMethod("setDeviceName", WifiP2pManager.Channel.class, String.class, WifiP2pManager.ActionListener.class);
                com.transsion.transfer.wifi.util.g gVar = com.transsion.transfer.wifi.util.g.f56093a;
                String b11 = b();
                int i11 = Build.VERSION.SDK_INT;
                lv.a e11 = e();
                String p11 = e11 != null ? e11.p() : null;
                lv.a e12 = e();
                com.transsion.transfer.wifi.util.g.b(gVar, b11 + " --> setDeviceName() --> API < 29 -- Android" + i11 + "设备(Q以上下) 创建 --> WIFI名称 = " + p11 + " -- WIFI频段 = " + (e12 != null ? e12.m() : null), false, 2, null);
                WifiP2pManager w12 = w();
                WifiP2pManager.Channel channel = this.f56013h;
                lv.a e13 = e();
                declaredMethod.invoke(w12, channel, e13 != null ? e13.p() : null, aVar);
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> setDeviceName() --> Build.VERSION.SDK_INT < Q --> 反射创建失败 -->exception = " + m1188exceptionOrNullimpl + " --> 失败重试", false, 2, null);
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiP2pManager G() {
        Object systemService = Utils.a().getApplicationContext().getSystemService("wifip2p");
        if (systemService instanceof WifiP2pManager) {
            return (WifiP2pManager) systemService;
        }
        return null;
    }

    private final void r() {
        Ref.IntRef intRef = new Ref.IntRef();
        n0 c11 = c();
        if (c11 != null) {
            kotlinx.coroutines.k.d(c11, y0.b(), null, new P2PWifiAdapter$closeWifiAndReCreateHot$1(intRef, this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        Unit unit;
        WifiP2pManager.Channel channel = this.f56013h;
        if (channel != null) {
            WifiP2pManager w11 = w();
            if (w11 != null) {
                w11.createGroup(channel, new WifiP2pManager.ActionListener() { // from class: com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$createGroup$1$1
                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onFailure(int i11) {
                        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, P2PWifiAdapter.this.b() + " --> setDeviceName() --> createGroup() --> onFailure() --> reason = " + com.transsion.transfer.wifi.util.i.f56094a.b(i11) + " --> 失败重试", false, 2, null);
                        P2PWifiAdapter.this.E();
                    }

                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onSuccess() {
                        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, P2PWifiAdapter.this.b() + " --> setDeviceName() --> createGroup() --> onSuccess()", false, 2, null);
                        n0 c11 = P2PWifiAdapter.this.c();
                        if (c11 != null) {
                            kotlinx.coroutines.k.d(c11, null, null, new P2PWifiAdapter$createGroup$1$1$onSuccess$1(P2PWifiAdapter.this, null), 3, null);
                        }
                    }
                });
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> createGroup() --> p2pChannel == null --> 失败重试", false, 2, null);
        E();
    }

    private final void t(WifiP2pConfig.Builder builder) {
        Unit unit;
        WifiP2pConfig build;
        WifiP2pManager.Channel channel = this.f56013h;
        if (channel != null) {
            WifiP2pManager w11 = w();
            if (w11 != null) {
                build = builder.build();
                w11.createGroup(channel, build, new WifiP2pManager.ActionListener() { // from class: com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$createGroupQ$1$1
                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onFailure(int i11) {
                        com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f56093a, P2PWifiAdapter.this.b() + " --> createWifiP2pGroup() --> createGroup() --> 创建群组失败 -- reason = " + com.transsion.transfer.wifi.util.i.f56094a.b(i11) + " --> 失败重试", false, 2, null);
                        P2PWifiAdapter.this.E();
                    }

                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onSuccess() {
                        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, P2PWifiAdapter.this.b() + " --> createWifiP2pGroup() --> createGroup() --> onSuccess() --> 创建群组成功", false, 2, null);
                        n0 c11 = P2PWifiAdapter.this.c();
                        if (c11 != null) {
                            kotlinx.coroutines.k.d(c11, null, null, new P2PWifiAdapter$createGroupQ$1$1$onSuccess$1(P2PWifiAdapter.this, null), 3, null);
                        }
                    }
                });
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> createGroupQ() --> p2pChannel == null --> 失败重试", false, 2, null);
        E();
    }

    private final void u() {
        String str;
        Object obj;
        WifiP2pConfig.Builder networkName;
        WifiP2pConfig.Builder passphrase;
        String str2;
        lv.a e11 = e();
        if (e11 == null || (str = e11.p()) == null) {
            str = "";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String substring = com.transsion.transfer.wifi.util.b.f56086a.a(str).substring(0, 8);
            Intrinsics.g(substring, "substring(...)");
            obj = Result.m1185constructorimpl(substring);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        String str3 = (String) (Result.m1188exceptionOrNullimpl(obj) == null ? obj : "");
        networkName = d.a().setNetworkName(str);
        passphrase = networkName.setPassphrase(str3);
        Intrinsics.g(passphrase, "setPassphrase(...)");
        lv.a e12 = e();
        if (e12 == null || !e12.a()) {
            passphrase.setGroupOperatingBand(1);
            str2 = "2.4G";
        } else {
            passphrase.setGroupOperatingBand(2);
            str2 = NetworkUtil.NETWORK_TYPE_5G;
        }
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> createWifiP2pGroup() --> API >= 29 -- Android" + Build.VERSION.SDK_INT + "设备(Q及其以上) 创建 --> WIFI名称 = " + str + " -- 密码 = " + str3 + " -- WIFI频段 = " + str2, false, 2, null);
        t(passphrase);
    }

    private final String v(InetAddress inetAddress) {
        WifiUtils wifiUtils = WifiUtils.f56083a;
        String g11 = wifiUtils.g(inetAddress);
        if (!TextUtils.isEmpty(g11)) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> getCorrectIp() --> ip --> getCorrectOwnerAddress() = " + g11, false, 2, null);
            return g11;
        }
        String l11 = wifiUtils.l();
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> getCorrectIp() --> ip --> localIP() = " + l11, false, 2, null);
        return l11;
    }

    private final WifiP2pManager w() {
        return (WifiP2pManager) this.f56012g.getValue();
    }

    private final void x(int i11) {
        n0 c11 = c();
        if (c11 != null) {
            kotlinx.coroutines.k.d(c11, null, null, new P2PWifiAdapter$onFail$1(this, i11, null), 3, null);
        }
    }

    private final void z(final WifiP2pGroup wifiP2pGroup) {
        Unit unit;
        WifiP2pManager.Channel channel = this.f56013h;
        if (channel != null) {
            WifiP2pManager w11 = w();
            if (w11 != null) {
                w11.requestConnectionInfo(channel, new WifiP2pManager.ConnectionInfoListener() { // from class: com.transsion.transfer.wifi.create.adapter.l
                    @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
                    public final void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
                        P2PWifiAdapter.A(P2PWifiAdapter.this, wifiP2pGroup, wifiP2pInfo);
                    }
                });
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> requestConnectionInfo() --> p2pChannel == null --> 失败重试 --> retryCreate()", false, 2, null);
        E();
    }

    @Override // com.transsion.transfer.wifi.create.adapter.b
    public Object a(Continuation continuation) {
        com.transsion.transfer.wifi.util.g gVar = com.transsion.transfer.wifi.util.g.f56093a;
        com.transsion.transfer.wifi.util.g.b(gVar, b() + " --> createWifiHot() --> start", false, 2, null);
        WifiP2pManager w11 = w();
        this.f56013h = w11 != null ? w11.initialize(Utils.a().getApplicationContext(), Looper.getMainLooper(), null) : null;
        int i11 = Build.VERSION.SDK_INT;
        if (WifiUtils.f56083a.s()) {
            com.transsion.transfer.wifi.util.g.b(gVar, b() + " --> createWifiHot() --> Android" + i11 + "设备(Q以下) 开始创建P2P WIFI热点", false, 2, null);
            F();
        } else {
            com.transsion.transfer.wifi.util.g.b(gVar, b() + " --> createWifiHot() --> Android" + i11 + "设备(Q及其以上) 开始创建P2P WIFI热点", false, 2, null);
            u();
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.transfer.wifi.create.adapter.b
    public void f() {
        y();
        g(null);
        h(null);
        this.f56013h = null;
    }

    public void y() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            com.transsion.transfer.wifi.util.i.f56094a.d(w(), this.f56013h, true, false, false, true);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f56093a, b() + " --> releaseWifiP2P() --> 关闭P2P频段异常 -- it = " + m1188exceptionOrNullimpl, false, 2, null);
    }
}
