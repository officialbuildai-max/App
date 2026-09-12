package com.transsion.api.gateway;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import com.transsion.api.gateway.config.WorkMode;
import com.transsion.api.gateway.interceptor.GatewayInterceptor;
import com.transsion.api.gateway.utils.ContextUtils;
import com.transsion.api.gateway.utils.GatewayUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.api.gateway.utils.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class GateWaySdk {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f42524a;

    /* renamed from: b, reason: collision with root package name */
    public static OkHttpClient f42525b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f42526c;

    /* renamed from: d, reason: collision with root package name */
    public static CopyOnWriteArrayList<String> f42527d = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public static CopyOnWriteArrayList<String> f42528e = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public static WorkMode f42529f = WorkMode.MODE_ONLINE;

    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f42530a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f42531b;

        public a(Context context, String str) {
            this.f42530a = context;
            this.f42531b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeStringUtils.getInstance(this.f42530a).saveString(SafeStringUtils.SP_APPID, this.f42531b);
        }
    }

    public static void a(Context context) {
        if (!f42526c && isOkhttpIntegrated()) {
            f42526c = true;
            try {
                context.registerReceiver(new com.transsion.api.gateway.receiver.a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e11) {
                GatewayUtils.L.e("registerReceiver fail, e:" + e11.getMessage());
            }
        }
    }

    public static List<String> getActivateSigHosts() {
        return f42527d;
    }

    public static List<String> getActivateSigPaths() {
        return f42528e;
    }

    public static String getHost() {
        int ordinal = f42529f.ordinal();
        return (ordinal == 0 || ordinal == 1) ? "apigateway.tmctool.com" : "";
    }

    public static boolean getIsInited() {
        return f42524a;
    }

    public static OkHttpClient getOkHttpClient() {
        if (f42525b == null) {
            f42525b = new OkHttpClient().newBuilder().addInterceptor(new GatewayInterceptor()).build();
        }
        return f42525b;
    }

    public static String getSecret() {
        try {
            if (ContextUtils.getContext() == null) {
                return "";
            }
            ApplicationInfo applicationInfo = ContextUtils.getContext().getPackageManager().getApplicationInfo(ContextUtils.getContext().getPackageName(), 128);
            int ordinal = f42529f.ordinal();
            return ordinal != 0 ? ordinal != 1 ? "" : applicationInfo.metaData.getString("gateway_secret_online") : applicationInfo.metaData.getString("gateway_secret_test");
        } catch (Exception e11) {
            GatewayUtils.L.e(e11);
            return "";
        }
    }

    public static WorkMode getWorkMode() {
        return f42529f;
    }

    public static void init(Context context, String str) {
        ContextUtils.init(context);
        a(context);
        f42529f = WorkMode.MODE_ONLINE;
        f42524a = true;
    }

    public static void init(Context context, String str, WorkMode workMode) {
        ContextUtils.init(context);
        a(context);
        f42529f = workMode;
        ThreadManager.executeInBackground(new a(context, str));
        ArrayList arrayList = new ArrayList();
        arrayList.add("/gateway/metric/add");
        arrayList.add("/gateway/sdk/v1/config");
        setActivateSignConfig(null, arrayList);
        f42524a = true;
    }

    public static boolean isOkhttpIntegrated() {
        try {
            OkHttpClient.Companion companion = OkHttpClient.INSTANCE;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void setActivateSignConfig(List<String> list, List<String> list2) {
        if (list != null && list.size() > 0) {
            f42527d.addAllAbsent(list);
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        f42528e.addAllAbsent(list2);
    }

    public static void setOkHttpClient(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            f42525b = okHttpClient;
        }
    }
}
