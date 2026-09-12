package com.transsion.transfer.wifi.qrcode;

import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.transfer.wifi.util.e;
import com.transsion.transfer.wifi.util.g;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class QrCodeUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final QrCodeUtil f56030a = new QrCodeUtil();

    private QrCodeUtil() {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0042. Please report as an issue. */
    private final lv.a a(Map map) {
        lv.a aVar;
        lv.a aVar2 = r15;
        lv.a aVar3 = new lv.a(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 131071, null);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            switch (str.hashCode()) {
                case -1627415939:
                    aVar = aVar2;
                    if (str.equals("mb_wifi_pwd")) {
                        aVar.G((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case -1086077885:
                    aVar = aVar2;
                    if (str.equals("mb_wifi_channel")) {
                        aVar.E((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case -1080938842:
                    aVar = aVar2;
                    if (str.equals("mb_uid")) {
                        aVar.z((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case -72536842:
                    aVar = aVar2;
                    if (str.equals("mb_version_release")) {
                        aVar.C((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 103677969:
                    aVar = aVar2;
                    if (str.equals("mb_ip")) {
                        aVar.F((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 103678184:
                    aVar = aVar2;
                    if (str.equals("mb_pn")) {
                        aVar.v((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 103678359:
                    aVar = aVar2;
                    if (str.equals("mb_vc")) {
                        aVar.A((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 103678370:
                    aVar = aVar2;
                    if (str.equals("mb_vn")) {
                        aVar.B((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 426966230:
                    aVar = aVar2;
                    if (str.equals("mb_avatar_index")) {
                        aVar.r((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 582580317:
                    aVar = aVar2;
                    if (str.equals("mb_brand")) {
                        aVar.s((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 785242969:
                    aVar = aVar2;
                    if (str.equals("mb_version_sdk_int")) {
                        aVar.D((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 925994048:
                    aVar = aVar2;
                    if (str.equals("mb_device")) {
                        aVar.u((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 1066736709:
                    aVar = aVar2;
                    if (str.equals("mb_product")) {
                        aVar.w((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 1089799227:
                    aVar = aVar2;
                    if (str.equals("mb_wifi_ssid")) {
                        aVar.H((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 1420622267:
                    aVar = aVar2;
                    if (str.equals("mb_unique")) {
                        aVar.y((String) entry.getValue());
                        break;
                    }
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
                case 2115161177:
                    if (str.equals("mb_channel")) {
                        aVar = aVar2;
                        aVar.t((String) entry.getValue());
                        break;
                    }
                default:
                    aVar = aVar2;
                    g.b(g.f56093a, f56030a.c() + " --> analysis() --> 没有匹配上 --> key = " + entry.getKey() + " --> value = " + entry.getValue(), false, 2, null);
                    break;
            }
            aVar2 = aVar;
        }
        lv.a aVar4 = aVar2;
        g.b(g.f56093a, c() + " --> analysis() --> wifiInfoModel = " + aVar4, false, 2, null);
        return aVar4;
    }

    private final String c() {
        String simpleName = QrCodeUtil.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public static /* synthetic */ Object g(QrCodeUtil qrCodeUtil, String str, int i11, int i12, Continuation continuation, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 400;
        }
        if ((i13 & 4) != 0) {
            i12 = 400;
        }
        return qrCodeUtil.f(str, i11, i12, continuation);
    }

    public final String b(lv.a aVar) {
        g gVar = g.f56093a;
        g.b(gVar, c() + " --> createTransferQrStr() --> wifiInfoModel = " + aVar, false, 2, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d());
        sb2.append("mb_unique");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append("mb_unique");
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_device");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.e() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_brand");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.c() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_product");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.g() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_version_release");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.k() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_version_sdk_int");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.l() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_vc");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.i() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_vn");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.j() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_pn");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.f() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_uid");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.h() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_avatar_index");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.b() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_channel");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.d() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_wifi_ssid");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.p() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_wifi_pwd");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.o() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_wifi_channel");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.m() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("mb_ip");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.n() : null);
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        g.b(gVar, c() + " --> createTransferQrStr() --> 二维码创建完成 --> qrCode = " + sb3, false, 2, null);
        return sb3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d() {
        /*
            r6 = this;
            java.lang.String r0 = "https://h5.aoneroom.com/download?type=/transfer/wifi_connect&"
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1c
            sm.f$a r1 = sm.f.f75530c     // Catch: java.lang.Throwable -> L1c
            sm.f r1 = r1.a()     // Catch: java.lang.Throwable -> L1c
            java.lang.String r2 = "transfer_share_link_url"
            r3 = 2
            r4 = 0
            r5 = 0
            com.transsion.mb.config.manager.ConfigBean r1 = sm.f.d(r1, r2, r5, r3, r4)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L1e
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> L1c
            if (r1 != 0) goto L1f
            goto L1e
        L1c:
            r1 = move-exception
            goto L24
        L1e:
            r1 = r0
        L1f:
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)     // Catch: java.lang.Throwable -> L1c
            goto L2e
        L24:
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.a(r1)
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)
        L2e:
            java.lang.Throwable r2 = kotlin.Result.m1188exceptionOrNullimpl(r1)
            if (r2 != 0) goto L35
            r0 = r1
        L35:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.qrcode.QrCodeUtil.d():java.lang.String");
    }

    public final void e(String text, Function1 function1) {
        Intrinsics.h(text, "text");
        Map a11 = e.f56089a.a(text);
        if (a11.isEmpty()) {
            if (function1 != null) {
            }
        } else if (!TextUtils.equals((CharSequence) a11.get("mb_unique"), "mb_unique")) {
            if (function1 != null) {
            }
        } else {
            lv.a a12 = a(a11);
            if (function1 != null) {
            }
        }
    }

    public final Object f(String str, int i11, int i12, Continuation continuation) {
        return i.g(y0.b(), new QrCodeUtil$syncEncodeQRCode$2(str, i11, i12, null), continuation);
    }
}
