package com.cloud.hisavana.sdk;

import com.cloud.hisavana.abtestkit.ABTestKit;
import com.cloud.hisavana.abtestkit.bean.ABVariant;
import com.cloud.hisavana.abtestkit.bean.ABVariantState;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ABTest;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ClientABTestDTOKt;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigManager;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class v1 {

    /* renamed from: a, reason: collision with root package name */
    public static final v1 f23105a = new v1();

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f23106b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static volatile long f23107c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f23108d = new AtomicBoolean(false);

    private v1() {
    }

    public final long a() {
        return f23107c;
    }

    public final int b() {
        return f23106b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        int i11;
        Long subExpId;
        Boolean m12;
        Map<String, String> info;
        int i12 = 0;
        int i13 = 1;
        if (f23108d.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ABTest aBTestData = CustomConfigManager.getABTestData(ClientABTestDTOKt.DCDN_NET);
                long j11 = 0;
                Unit unit = null;
                r6 = null;
                String str = null;
                if (aBTestData != null) {
                    ABVariantState aBTestVariant = ABTestKit.getABTestVariant(aBTestData.getLayerId(), aBTestData.getReqInterval(), aBTestData.getSwitch());
                    if (aBTestVariant.isOpen()) {
                        ABVariantState.Open open = aBTestVariant instanceof ABVariantState.Open ? (ABVariantState.Open) aBTestVariant : null;
                        ABVariant variant = open != null ? open.getVariant() : null;
                        if (variant != null && (info = variant.getInfo()) != null) {
                            str = info.get("isSupportDcdn");
                        }
                        boolean booleanValue = (str == null || (m12 = StringsKt.m1(str)) == null) ? 0 : m12.booleanValue();
                        if (variant != null && (subExpId = variant.getSubExpId()) != null) {
                            j11 = subExpId.longValue();
                        }
                        e4.b().d("DCDNManager", "dcdn abtest is open, isSupportDcdn is " + booleanValue + ", varid is " + j11);
                        i13 = booleanValue;
                    } else {
                        if (aBTestVariant.isClosed()) {
                            e4.b().d("DCDNManager", "dcdn abtest is closed");
                        } else if (aBTestVariant.isPushAll()) {
                            e4.b().d("DCDNManager", "dcdn abtest is push all");
                        }
                        i13 = 0;
                    }
                    unit = Unit.f67184a;
                    i11 = i13;
                } else {
                    i11 = 0;
                }
                if (unit == null) {
                    e4.b().d("DCDNManager", "dcdn abtest config data is null");
                } else {
                    i12 = i11;
                }
                j7.a.e().p("support_dcdn_status", i12);
                j7.a.e().q("dcdn_var_id", j11);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    public final void d() {
        if (f23106b == -1) {
            f23106b = j7.a.e().g("support_dcdn_status", 0);
        }
        if (f23107c == -1) {
            f23107c = j7.a.e().i("dcdn_var_id", 0L);
        }
    }
}
