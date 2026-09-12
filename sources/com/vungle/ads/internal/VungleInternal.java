package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.SdkVersionTooLow;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.bidding.BidTokenEncoder;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.n;
import com.vungle.ads.internal.util.v;
import com.vungle.ads.x;
import com.vungle.ads.z;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class VungleInternal {
    /* renamed from: getAvailableBidTokens$lambda-0, reason: not valid java name */
    private static final com.vungle.ads.internal.util.c m1036getAvailableBidTokens$lambda0(Lazy<com.vungle.ads.internal.util.c> lazy) {
        return (com.vungle.ads.internal.util.c) lazy.getValue();
    }

    /* renamed from: getAvailableBidTokens$lambda-1, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.d m1037getAvailableBidTokens$lambda1(Lazy<com.vungle.ads.internal.executor.d> lazy) {
        return (com.vungle.ads.internal.executor.d) lazy.getValue();
    }

    /* renamed from: getAvailableBidTokens$lambda-2, reason: not valid java name */
    private static final BidTokenEncoder m1038getAvailableBidTokens$lambda2(Lazy<BidTokenEncoder> lazy) {
        return (BidTokenEncoder) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAvailableBidTokens$lambda-3, reason: not valid java name */
    public static final String m1039getAvailableBidTokens$lambda3(Lazy bidTokenEncoder$delegate) {
        Intrinsics.h(bidTokenEncoder$delegate, "$bidTokenEncoder$delegate");
        return m1038getAvailableBidTokens$lambda2(bidTokenEncoder$delegate).encode().getBidToken();
    }

    /* renamed from: getAvailableBidTokensAsync$lambda-4, reason: not valid java name */
    private static final BidTokenEncoder m1040getAvailableBidTokensAsync$lambda4(Lazy<BidTokenEncoder> lazy) {
        return (BidTokenEncoder) lazy.getValue();
    }

    /* renamed from: getAvailableBidTokensAsync$lambda-5, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.d m1041getAvailableBidTokensAsync$lambda5(Lazy<com.vungle.ads.internal.executor.d> lazy) {
        return (com.vungle.ads.internal.executor.d) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAvailableBidTokensAsync$lambda-6, reason: not valid java name */
    public static final void m1042getAvailableBidTokensAsync$lambda6(com.vungle.ads.i callback, Lazy bidTokenEncoder$delegate) {
        Intrinsics.h(callback, "$callback");
        Intrinsics.h(bidTokenEncoder$delegate, "$bidTokenEncoder$delegate");
        x xVar = new x(Sdk$SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS);
        xVar.markStart();
        BidTokenEncoder.b encode = m1040getAvailableBidTokensAsync$lambda4(bidTokenEncoder$delegate).encode();
        xVar.markEnd();
        if (encode.getBidToken().length() > 0) {
            callback.b(encode.getBidToken());
        } else {
            xVar.setMetricType(Sdk$SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS);
            xVar.setMeta(encode.getErrorMessage());
            callback.a(encode.getErrorMessage());
        }
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, xVar, (n) null, (String) null, 6, (Object) null);
    }

    public final String getAvailableBidTokens(final Context context) {
        Intrinsics.h(context, "context");
        if (v.INSTANCE.isOSVersionInvalid()) {
            new SdkVersionTooLow("Deprecated RTB: SDK is supported only for API versions 25 and above.").logErrorNoReturnValue$vungle_ads_release();
            return null;
        }
        x xVar = new x(Sdk$SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS);
        xVar.markStart();
        if (!z.Companion.isInitialized()) {
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "context.applicationContext");
            privacyManager.init(applicationContext);
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        Lazy a11 = LazyKt.a(lazyThreadSafetyMode, new Function0<com.vungle.ads.internal.util.c>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokens$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.vungle.ads.internal.util.c] */
            @Override // kotlin.jvm.functions.Function0
            public final com.vungle.ads.internal.util.c invoke() {
                return ServiceLocator.Companion.getInstance(context).getService(com.vungle.ads.internal.util.c.class);
            }
        });
        Lazy a12 = LazyKt.a(lazyThreadSafetyMode, new Function0<com.vungle.ads.internal.executor.d>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokens$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.vungle.ads.internal.executor.d] */
            @Override // kotlin.jvm.functions.Function0
            public final com.vungle.ads.internal.executor.d invoke() {
                return ServiceLocator.Companion.getInstance(context).getService(com.vungle.ads.internal.executor.d.class);
            }
        });
        final Lazy a13 = LazyKt.a(lazyThreadSafetyMode, new Function0<BidTokenEncoder>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokens$$inlined$inject$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.bidding.BidTokenEncoder, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BidTokenEncoder invoke() {
                return ServiceLocator.Companion.getInstance(context).getService(BidTokenEncoder.class);
            }
        });
        String str = (String) new com.vungle.ads.internal.executor.b(m1037getAvailableBidTokens$lambda1(a12).getApiExecutor().submit(new Callable() { // from class: com.vungle.ads.internal.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String m1039getAvailableBidTokens$lambda3;
                m1039getAvailableBidTokens$lambda3 = VungleInternal.m1039getAvailableBidTokens$lambda3(Lazy.this);
                return m1039getAvailableBidTokens$lambda3;
            }
        })).get(m1036getAvailableBidTokens$lambda0(a11).getTimeout(), TimeUnit.MILLISECONDS);
        if (str == null || str.length() == 0) {
            xVar.setMetricType(Sdk$SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS);
            xVar.setMeta("Bid token is null or empty");
        }
        xVar.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, xVar, (n) null, (String) null, 6, (Object) null);
        return str;
    }

    public final void getAvailableBidTokensAsync(final Context context, final com.vungle.ads.i callback) {
        Intrinsics.h(context, "context");
        Intrinsics.h(callback, "callback");
        if (v.INSTANCE.isOSVersionInvalid()) {
            new SdkVersionTooLow("RTB: SDK is supported only for API versions 25 and above.").logErrorNoReturnValue$vungle_ads_release();
            callback.a("RTB: SDK is supported only for API versions 25 and above.");
            return;
        }
        if (!z.Companion.isInitialized()) {
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "context.applicationContext");
            privacyManager.init(applicationContext);
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Lazy a11 = LazyKt.a(lazyThreadSafetyMode, new Function0<BidTokenEncoder>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokensAsync$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.bidding.BidTokenEncoder, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BidTokenEncoder invoke() {
                return ServiceLocator.Companion.getInstance(context).getService(BidTokenEncoder.class);
            }
        });
        m1041getAvailableBidTokensAsync$lambda5(LazyKt.a(lazyThreadSafetyMode, new Function0<com.vungle.ads.internal.executor.d>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokensAsync$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.vungle.ads.internal.executor.d] */
            @Override // kotlin.jvm.functions.Function0
            public final com.vungle.ads.internal.executor.d invoke() {
                return ServiceLocator.Companion.getInstance(context).getService(com.vungle.ads.internal.executor.d.class);
            }
        })).getApiExecutor().execute(new Runnable(callback, a11) { // from class: com.vungle.ads.internal.k

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Lazy f60729a;

            {
                this.f60729a = a11;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VungleInternal.m1042getAvailableBidTokensAsync$lambda6(null, this.f60729a);
            }
        });
    }

    public final String getSdkVersion() {
        return "7.5.0";
    }
}
