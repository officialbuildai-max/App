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
import kotlin.jvm.internal.Ref;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* loaded from: classes3.dex */
public final class AbsConfigStore$RequestRunnableConfigHeader$run$2 implements Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbsConfigStore.RequestRunnableConfigHeader f21292a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f21293b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f21294c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsConfigStore$RequestRunnableConfigHeader$run$2(AbsConfigStore.RequestRunnableConfigHeader requestRunnableConfigHeader, Ref.ObjectRef objectRef, String str) {
        this.f21292a = requestRunnableConfigHeader;
        this.f21293b = objectRef;
        this.f21294c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AbsConfigStore.RequestRunnableConfigHeader this$0) {
        Intrinsics.h(this$0, "this$0");
        s configResultListener = this$0.getConfigResultListener();
        if (configResultListener == null) {
            return;
        }
        configResultListener.onLoadDataFailure(1004, ConstantsKt.ERROR_1004_MESSAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AbsConfigStore.RequestRunnableConfigHeader this$0) {
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
        final AbsConfigStore.RequestRunnableConfigHeader requestRunnableConfigHeader = this.f21292a;
        main.execute(new Runnable() { // from class: com.cloud.config.j
            @Override // java.lang.Runnable
            public final void run() {
                AbsConfigStore$RequestRunnableConfigHeader$run$2.c(AbsConfigStore.RequestRunnableConfigHeader.this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        MMKV e11;
        MMKV e12;
        ConditionInfo conditionInfo;
        String matchCacheUrl;
        Intrinsics.h(call, "call");
        Intrinsics.h(response, "response");
        try {
            String header = response.header(ConstantsKt.CONTENT_MD5);
            e11 = this.f21292a.getStore().e();
            String str = (String) this.f21293b.element;
            String string = e11.getString(str == null ? null : ConstantsKt.toStoreMd5Name(str), "");
            e12 = this.f21292a.getStore().e();
            String str2 = (String) this.f21293b.element;
            String string2 = e12.getString(str2 == null ? null : ConstantsKt.toStoreConfigName(str2), "");
            XLogUtil.Companion companion = XLogUtil.INSTANCE;
            companion.getLog().i(XLogUtil.TAG, Intrinsics.q("contentMd5 --> ", header));
            companion.getLog().i(XLogUtil.TAG, Intrinsics.q("storeMd5 --> ", string));
            if (string != null && string.length() > 0 && header != null && header.length() > 0 && Intrinsics.c(string, header) && string2 != null && string2.length() > 0) {
                CloudConfigResponse cloudConfigResponse = (CloudConfigResponse) new Gson().fromJson(string2, new TypeToken<CloudConfigResponse>() { // from class: com.cloud.config.AbsConfigStore$RequestRunnableConfigHeader$run$2$onResponse$responseResult$1
                }.getType());
                if (cloudConfigResponse != null && (conditionInfo = cloudConfigResponse.getConditionInfo()) != null && (matchCacheUrl = conditionInfo.getMatchCacheUrl()) != null) {
                    AbsConfigStore.RequestRunnableConfigHeader requestRunnableConfigHeader = this.f21292a;
                    Ref.ObjectRef objectRef = this.f21293b;
                    AbsConfigStore store = requestRunnableConfigHeader.getStore();
                    ConditionParam conditionParam = cloudConfigResponse.getConditionInfo().get_conditionParam();
                    ShuntInfo shuntInfo = conditionParam != null ? conditionParam.getShuntInfo() : null;
                    String str3 = (String) objectRef.element;
                    AbsConfigStore store2 = requestRunnableConfigHeader.getStore();
                    requestRunnableConfigHeader.getConfigListener();
                    store.h(matchCacheUrl, shuntInfo, str3, store2, null, requestRunnableConfigHeader.getConfigResultListener());
                    return;
                }
                return;
            }
            ExecutorService io2 = ExecutorUtils.io();
            AbsConfigStore store3 = this.f21292a.getStore();
            String str4 = (String) this.f21293b.element;
            this.f21292a.getConfigListener();
            io2.execute(new AbsConfigStore.RequestRunnableConfig(store3, str4, null, this.f21292a.getConfigResultListener(), header, this.f21294c));
        } catch (Throwable th2) {
            XLogUtil.INSTANCE.getLog().e(XLogUtil.TAG, Intrinsics.q(Log.getStackTraceString(th2), Thread.currentThread().getName()));
            ExecutorService main = ExecutorUtils.main();
            final AbsConfigStore.RequestRunnableConfigHeader requestRunnableConfigHeader2 = this.f21292a;
            main.execute(new Runnable() { // from class: com.cloud.config.i
                @Override // java.lang.Runnable
                public final void run() {
                    AbsConfigStore$RequestRunnableConfigHeader$run$2.d(AbsConfigStore.RequestRunnableConfigHeader.this);
                }
            });
        }
    }
}
