package com.tn.tranpay.report;

import android.app.Application;
import android.os.Bundle;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.meituan.android.walle.ChannelReader;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.TranPayConfiguration;
import com.tn.tranpay.device.TNDeviceHelper;
import com.transsion.startup.pref.consume.AppStartDotState;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name */
    private HashSet f41738a;

    public g() {
        HashSet hashSet = new HashSet();
        this.f41738a = hashSet;
        hashSet.add(AppStartDotState.APP_START);
        this.f41738a.add("app_stop");
    }

    private final void c(Bundle bundle) {
        bundle.putString("device_id", TNDeviceHelper.f41584a.c());
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.f41544a;
        bundle.putString("app_id", tranPayConfiguration.h());
        bundle.putString(ChannelReader.CHANNEL_KEY, tranPayConfiguration.j());
        bundle.putString("app_version", d());
        bundle.putString("sdk_version", TranPay.f41540a.e());
        String l11 = tranPayConfiguration.l();
        if (l11 == null) {
            l11 = "";
        }
        bundle.putString("m_id", l11);
        String s11 = tranPayConfiguration.s();
        if (s11 == null) {
            s11 = "";
        }
        bundle.putString("pay_order_id", s11);
        String t11 = tranPayConfiguration.t();
        if (t11 == null) {
            t11 = "";
        }
        bundle.putString("txn_id", t11);
        String k11 = tranPayConfiguration.k();
        if (k11 == null) {
            k11 = "";
        }
        bundle.putString(PlaceTypes.COUNTRY, k11);
        String m11 = tranPayConfiguration.m();
        if (m11 == null) {
            m11 = "";
        }
        bundle.putString("currency", m11);
        String g11 = tranPayConfiguration.g();
        bundle.putString(RewardPlus.AMOUNT, g11 != null ? g11 : "");
        bundle.putString(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
    }

    private final String d() {
        try {
            Application d11 = TranPay.f41540a.d();
            String str = d11.getPackageManager().getPackageInfo(d11.getPackageName(), 0).versionName;
            Intrinsics.g(str, "{\n            // 使用 Tran… 0).versionName\n        }");
            return str;
        } catch (Exception unused) {
            return TmcConstants.ROUTE_UNKNOWN;
        }
    }

    @Override // com.tn.tranpay.report.f
    public Bundle a(String event, Bundle bundle) {
        Intrinsics.h(event, "event");
        Intrinsics.h(bundle, "bundle");
        c(bundle);
        return bundle;
    }

    @Override // com.tn.tranpay.report.f
    public void b(String pageName, String event, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
    }
}
