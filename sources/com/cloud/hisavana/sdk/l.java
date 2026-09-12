package com.cloud.hisavana.sdk;

import com.cloud.hisavana.abtestkit.ABTestKit;
import com.cloud.hisavana.abtestkit.bean.ABVariant;
import com.cloud.hisavana.abtestkit.bean.ABVariantState;
import com.cloud.hisavana.net.NetGroup;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ABTest;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ClientABTestDTOKt;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigManager;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f22691a = new l();

    /* renamed from: b, reason: collision with root package name */
    private static int f22692b = -1;

    private l() {
    }

    public final void a() {
        Long subExpId;
        Integer v11;
        Map<String, String> info;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (f22692b != -1) {
                return;
            }
            ABTest aBTestData = CustomConfigManager.getABTestData(ClientABTestDTOKt.AB_NETWORK);
            Unit unit = null;
            r1 = null;
            String str = null;
            if (aBTestData != null) {
                try {
                    ABVariantState aBTestVariant = ABTestKit.getABTestVariant(aBTestData.getLayerId(), aBTestData.getReqInterval(), aBTestData.getSwitch());
                    int i11 = 0;
                    if (aBTestVariant.isOpen()) {
                        ABVariantState.Open open = aBTestVariant instanceof ABVariantState.Open ? (ABVariantState.Open) aBTestVariant : null;
                        ABVariant variant = open != null ? open.getVariant() : null;
                        if (variant != null && (info = variant.getInfo()) != null) {
                            str = info.get("netGroupBucketId");
                        }
                        if (str != null && (v11 = StringsKt.v(str)) != null) {
                            i11 = v11.intValue();
                        }
                        switch (i11) {
                            case 2013:
                            case 2014:
                            case 2015:
                            case 2016:
                                f22692b = i11;
                                long longValue = (variant == null || (subExpId = variant.getSubExpId()) == null) ? 0L : subExpId.longValue();
                                com.cloud.sdk.commonutil.util.c.netLog("NetGroup gets the groupBucketId in the api = " + f22692b + ", save it in the cache");
                                String q11 = k1.o().q();
                                if (!NetGroup.a(q11)) {
                                    com.cloud.sdk.commonutil.util.c.netLog("url is not in the white list, so it will not save groupBucketId in the cache. url = " + q11);
                                    break;
                                } else {
                                    j7.a.e().p("bucketV2", f22692b);
                                    j7.a.e().q("bucketVarId", longValue);
                                    break;
                                }
                        }
                    } else if (aBTestVariant.isClosed()) {
                        f22692b = 0;
                        j7.a.e().p("bucketV2", 0);
                        com.cloud.sdk.commonutil.util.c.netLog("network abtest is closed");
                    } else if (aBTestVariant.isPushAll()) {
                        f22692b = 2016;
                        j7.a.e().p("bucketV2", 2016);
                        com.cloud.sdk.commonutil.util.c.netLog("network abtest is push all");
                    }
                } catch (Throwable unused) {
                }
                unit = Unit.f67184a;
            }
            if (unit == null) {
                com.cloud.sdk.commonutil.util.c.netLog("network abtest config data is null");
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }
}
