package com.cloud.tmc.integration.utils;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.net.TmcResponseCallback;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.google.gson.reflect.TypeToken;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016J<\u0010\u000f\u001a\u00020\b2\u001c\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\n2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¨\u0006\u0011"}, d2 = {"com/cloud/tmc/integration/utils/MiniRequestUtils$requestRecommendMiniApp$1", "Lcom/cloud/tmc/integration/net/TmcResponseCallback;", "Ljava/util/ArrayList;", "Lcom/cloud/tmc/integration/model/AppModel;", "Lkotlin/collections/ArrayList;", "getType", "Ljava/lang/reflect/Type;", "onFail", "", "fail", "Lcom/cloud/tmc/integration/net/BaseResponse;", "", "headers", "", "", "onSuccess", "bean", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class MiniRequestUtils$requestRecommendMiniApp$1 extends TmcResponseCallback<ArrayList<AppModel>> {
    final /* synthetic */ Function1<ArrayList<AppModel>, Unit> $block;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public MiniRequestUtils$requestRecommendMiniApp$1(Function1<? super ArrayList<AppModel>, Unit> function1) {
        this.$block = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFail$lambda$2(Function1 function1) {
        if (function1 != null) {
            function1.invoke(new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$1$lambda$0(Function1 function1, ArrayList it) {
        Intrinsics.h(it, "$it");
        if (function1 != null) {
            function1.invoke(it);
        }
    }

    @Override // com.cloud.tmc.integration.net.TmcResponseCallback
    public Type getType() {
        Type type = new TypeToken<BaseResponse<? extends ArrayList<AppModel>>>() { // from class: com.cloud.tmc.integration.utils.MiniRequestUtils$requestRecommendMiniApp$1$getType$1
        }.getType();
        Intrinsics.g(type, "object : TypeToken<BaseR…ist<AppModel>>>() {}.type");
        return type;
    }

    @Override // com.cloud.tmc.integration.net.TmcResponseCallback
    public void onFail(BaseResponse<? extends Object> fail, Map<String, String> headers) {
        Intrinsics.h(fail, "fail");
        TmcLogger.d("TmcApp: MiniRequestUtils", "onFail: " + TmcGsonUtilsKt.toJson(fail));
        ExecutorType executorType = ExecutorType.UI;
        final Function1<ArrayList<AppModel>, Unit> function1 = this.$block;
        ExecutorUtils.execute(executorType, new Runnable() { // from class: com.cloud.tmc.integration.utils.m
            @Override // java.lang.Runnable
            public final void run() {
                MiniRequestUtils$requestRecommendMiniApp$1.onFail$lambda$2(Function1.this);
            }
        });
    }

    @Override // com.cloud.tmc.integration.net.TmcResponseCallback
    public void onSuccess(BaseResponse<? extends ArrayList<AppModel>> bean, Map<String, String> headers) {
        Intrinsics.h(bean, "bean");
        TmcLogger.d("TmcApp: MiniRequestUtils", "onSuccess: " + TmcGsonUtilsKt.toJson(bean));
        final ArrayList<AppModel> data = bean.getData();
        if (data != null) {
            final Function1<ArrayList<AppModel>, Unit> function1 = this.$block;
            ExecutorUtils.execute(ExecutorType.UI, new Runnable() { // from class: com.cloud.tmc.integration.utils.l
                @Override // java.lang.Runnable
                public final void run() {
                    MiniRequestUtils$requestRecommendMiniApp$1.onSuccess$lambda$1$lambda$0(Function1.this, data);
                }
            });
        }
    }
}
