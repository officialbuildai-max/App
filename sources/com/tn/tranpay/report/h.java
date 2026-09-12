package com.tn.tranpay.report;

import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f41739a = new h();

    private h() {
    }

    public static /* synthetic */ void f(h hVar, int i11, Boolean bool, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            bool = null;
        }
        hVar.e(i11, bool);
    }

    public final void a(String paymentMethod, boolean z10, boolean z11, boolean z12) {
        Intrinsics.h(paymentMethod, "paymentMethod");
        HashMap hashMap = new HashMap();
        hashMap.put("payment_method", paymentMethod);
        hashMap.put("need_phone", String.valueOf(z10));
        hashMap.put("need_cnic", String.valueOf(z11));
        hashMap.put("auto", String.valueOf(z12));
        e.f41734a.e("cashier_page", "choose_payment_method", hashMap);
    }

    public final void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", "true");
        if (str == null) {
            str = "";
        }
        hashMap.put(TtmlNode.TAG_REGION, str);
        e.f41734a.e("pay_sdk", "init", hashMap);
    }

    public final void c(boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", String.valueOf(z10));
        e.f41734a.e("pay_sdk", "load_config", hashMap);
    }

    public final void d(int i11, String str, String str2, String str3, boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", String.valueOf(i11));
        if (str == null) {
            str = "";
        }
        hashMap.put("webUrl", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("rnUrl", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("packageName", str3);
        hashMap.put("auto", String.valueOf(z10));
        e.f41734a.e("cashier_page", "open_link", hashMap);
    }

    public final void e(int i11, Boolean bool) {
        HashMap hashMap = new HashMap();
        hashMap.put("resultType", String.valueOf(i11));
        if (bool != null) {
            hashMap.put("reason", bool.booleanValue() ? "cancel" : OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER);
        }
        e.f41734a.e("cashier_page", "pay", hashMap);
    }

    public final void g() {
        e.f41734a.e("retention_dialog", "click_cancel", MapsKt.h());
    }

    public final void h() {
        e.f41734a.e("retention_dialog", "pt", MapsKt.h());
    }

    public final void i() {
        e.f41734a.e("retention_dialog", "click_query", MapsKt.h());
    }

    public final void j(boolean z10, String orderDesc, boolean z11, String txnId) {
        Intrinsics.h(orderDesc, "orderDesc");
        Intrinsics.h(txnId, "txnId");
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", String.valueOf(z10));
        hashMap.put("order_desc", orderDesc);
        hashMap.put("pay_by_local_currency", String.valueOf(z11));
        hashMap.put("txn_id", txnId);
        e.f41734a.e("pay_sdk", "start_pay", hashMap);
    }

    public final void k(boolean z10, String str, String str2, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", String.valueOf(z10));
        if (str != null) {
            hashMap.put("phone", str);
        }
        if (str2 != null) {
            hashMap.put("cnic", str2);
        }
        hashMap.put("auto", String.valueOf(z11));
        e.f41734a.e("cashier_page", "submit", hashMap);
    }

    public final void l(String pageName) {
        Intrinsics.h(pageName, "pageName");
        e.f41734a.e(pageName, "pt", MapsKt.h());
    }
}
