package com.cloud.config;

import android.util.Log;
import com.cloud.config.AbsConfigStore;
import com.cloud.config.bean.CloudConfigResponse;
import com.cloud.config.bean.ConditionInfo;
import com.cloud.config.bean.ConditionParam;
import com.cloud.config.bean.ShuntInfo;
import com.cloud.config.utils.ConstantsKt;
import com.cloud.config.utils.ExecutorUtils;
import com.cloud.config.utils.XLogUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public final class AbsConfigStore$RequestRunnableConfig$run$1 implements Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbsConfigStore.RequestRunnableConfig f21291a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsConfigStore$RequestRunnableConfig$run$1(AbsConfigStore.RequestRunnableConfig requestRunnableConfig) {
        this.f21291a = requestRunnableConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AbsConfigStore.RequestRunnableConfig this$0) {
        Intrinsics.h(this$0, "this$0");
        s configResultListener = this$0.getConfigResultListener();
        if (configResultListener == null) {
            return;
        }
        configResultListener.onLoadDataFailure(1004, ConstantsKt.ERROR_1004_MESSAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AbsConfigStore.RequestRunnableConfig this$0) {
        Intrinsics.h(this$0, "this$0");
        s configResultListener = this$0.getConfigResultListener();
        if (configResultListener == null) {
            return;
        }
        configResultListener.onLoadDataFailure(1003, ConstantsKt.ERROR_1003_MESSAGE);
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e11) {
        Intrinsics.h(call, "call");
        Intrinsics.h(e11, "e");
        XLogUtil log = XLogUtil.INSTANCE.getLog();
        String stackTraceString = Log.getStackTraceString(e11);
        Intrinsics.g(stackTraceString, "getStackTraceString(e)");
        log.e(XLogUtil.TAG, stackTraceString);
        ExecutorService main = ExecutorUtils.main();
        final AbsConfigStore.RequestRunnableConfig requestRunnableConfig = this.f21291a;
        main.execute(new Runnable() { // from class: com.cloud.config.e
            @Override // java.lang.Runnable
            public final void run() {
                AbsConfigStore$RequestRunnableConfig$run$1.c(AbsConfigStore.RequestRunnableConfig.this);
            }
        });
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        MMKV e11;
        String str;
        MMKV e12;
        String str2;
        ConditionInfo conditionInfo;
        String matchCacheUrl;
        String str3;
        Intrinsics.h(call, "call");
        Intrinsics.h(response, "response");
        try {
            if (response.body() == null) {
                return;
            }
            AbsConfigStore.RequestRunnableConfig requestRunnableConfig = this.f21291a;
            ResponseBody body = response.body();
            Intrinsics.e(body);
            String string = body.string();
            e11 = requestRunnableConfig.getStore().e();
            str = requestRunnableConfig.packageName;
            e11.putString(str == null ? null : ConstantsKt.toStoreConfigName(str), string);
            e12 = requestRunnableConfig.getStore().e();
            str2 = requestRunnableConfig.packageName;
            e12.putString(str2 == null ? null : ConstantsKt.toStoreMd5Name(str2), requestRunnableConfig.getContentMd5());
            XLogUtil.INSTANCE.getLog().i(XLogUtil.TAG, Intrinsics.q("response --> ", string));
            CloudConfigResponse cloudConfigResponse = (CloudConfigResponse) new Gson().fromJson(string, new TypeToken<CloudConfigResponse>() { // from class: com.cloud.config.AbsConfigStore$RequestRunnableConfig$run$1$onResponse$1$responseResult$1
            }.getType());
            if (cloudConfigResponse != null && (conditionInfo = cloudConfigResponse.getConditionInfo()) != null && (matchCacheUrl = conditionInfo.getMatchCacheUrl()) != null) {
                AbsConfigStore store = requestRunnableConfig.getStore();
                ConditionParam conditionParam = cloudConfigResponse.getConditionInfo().get_conditionParam();
                ShuntInfo shuntInfo = conditionParam != null ? conditionParam.getShuntInfo() : null;
                str3 = requestRunnableConfig.packageName;
                AbsConfigStore store2 = requestRunnableConfig.getStore();
                requestRunnableConfig.getConfigListener();
                store.h(matchCacheUrl, shuntInfo, str3, store2, null, requestRunnableConfig.getConfigResultListener());
            }
        } catch (Throwable th2) {
            XLogUtil log = XLogUtil.INSTANCE.getLog();
            String stackTraceString = Log.getStackTraceString(th2);
            Intrinsics.g(stackTraceString, "getStackTraceString(e)");
            log.e(XLogUtil.TAG, stackTraceString);
            ExecutorService main = ExecutorUtils.main();
            final AbsConfigStore.RequestRunnableConfig requestRunnableConfig2 = this.f21291a;
            main.execute(new Runnable() { // from class: com.cloud.config.f
                @Override // java.lang.Runnable
                public final void run() {
                    AbsConfigStore$RequestRunnableConfig$run$1.d(AbsConfigStore.RequestRunnableConfig.this);
                }
            });
        }
    }
}
