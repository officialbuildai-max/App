package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: r, reason: collision with root package name */
    private static IThreadPoolCallback f20679r;

    /* renamed from: s, reason: collision with root package name */
    private static ThreadPoolExecutor f20680s;

    /* renamed from: a, reason: collision with root package name */
    private final Context f20681a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.geckox.a.a.c f20682b;

    /* renamed from: c, reason: collision with root package name */
    private final IStatisticMonitor f20683c;

    /* renamed from: d, reason: collision with root package name */
    private final INetWork f20684d;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f20685e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f20686f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.geckox.a.a.a f20687g;

    /* renamed from: h, reason: collision with root package name */
    private final Long f20688h;

    /* renamed from: i, reason: collision with root package name */
    private final String f20689i;

    /* renamed from: j, reason: collision with root package name */
    private final String f20690j;

    /* renamed from: k, reason: collision with root package name */
    private final String f20691k;

    /* renamed from: l, reason: collision with root package name */
    private final String f20692l;

    /* renamed from: m, reason: collision with root package name */
    private final String f20693m;

    /* renamed from: n, reason: collision with root package name */
    private final File f20694n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f20695o;

    /* renamed from: p, reason: collision with root package name */
    private final long f20696p;

    /* renamed from: q, reason: collision with root package name */
    private JSONObject f20697q;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private INetWork f20698a;

        /* renamed from: b, reason: collision with root package name */
        private List<String> f20699b;

        /* renamed from: c, reason: collision with root package name */
        private List<String> f20700c;

        /* renamed from: d, reason: collision with root package name */
        private Context f20701d;

        /* renamed from: e, reason: collision with root package name */
        private com.bykv.vk.openvk.preload.geckox.a.a.c f20702e;

        /* renamed from: f, reason: collision with root package name */
        private IStatisticMonitor f20703f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f20704g = true;

        /* renamed from: h, reason: collision with root package name */
        private com.bykv.vk.openvk.preload.geckox.a.a.a f20705h;

        /* renamed from: i, reason: collision with root package name */
        private Long f20706i;

        /* renamed from: j, reason: collision with root package name */
        private String f20707j;

        /* renamed from: k, reason: collision with root package name */
        private String f20708k;

        /* renamed from: l, reason: collision with root package name */
        private String f20709l;

        /* renamed from: m, reason: collision with root package name */
        private File f20710m;

        /* renamed from: n, reason: collision with root package name */
        private String f20711n;

        /* renamed from: o, reason: collision with root package name */
        private String f20712o;

        /* renamed from: p, reason: collision with root package name */
        private long f20713p;

        public a(Context context) {
            this.f20701d = context.getApplicationContext();
        }

        public final a a() {
            this.f20704g = false;
            return this;
        }

        public final a a(long j11) {
            this.f20713p = j11;
            return this;
        }

        public final a a(com.bykv.vk.openvk.preload.geckox.a.a.a aVar) {
            this.f20705h = aVar;
            return this;
        }

        public final a a(INetWork iNetWork) {
            this.f20698a = iNetWork;
            return this;
        }

        public final a a(IStatisticMonitor iStatisticMonitor) {
            this.f20703f = iStatisticMonitor;
            return this;
        }

        public final a a(File file) {
            this.f20710m = file;
            return this;
        }

        public final a a(String str) {
            this.f20707j = str;
            return this;
        }

        public final a a(String... strArr) {
            this.f20700c = Arrays.asList(strArr);
            return this;
        }

        public final a b() {
            this.f20706i = 38L;
            return this;
        }

        public final a b(String str) {
            this.f20708k = str;
            return this;
        }

        public final a b(String... strArr) {
            this.f20699b = Arrays.asList(strArr);
            return this;
        }

        public final a c(String str) {
            this.f20709l = str;
            return this;
        }
    }

    private b(a aVar) {
        Context context = aVar.f20701d;
        this.f20681a = context;
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        List<String> list = aVar.f20699b;
        this.f20685e = list;
        this.f20686f = aVar.f20700c;
        this.f20682b = aVar.f20702e;
        this.f20687g = aVar.f20705h;
        Long l11 = aVar.f20706i;
        this.f20688h = l11;
        if (TextUtils.isEmpty(aVar.f20707j)) {
            this.f20689i = com.bykv.vk.openvk.preload.geckox.utils.a.a(context);
        } else {
            this.f20689i = aVar.f20707j;
        }
        String str = aVar.f20708k;
        this.f20690j = str;
        this.f20692l = aVar.f20711n;
        this.f20693m = aVar.f20712o;
        this.f20696p = aVar.f20713p;
        if (aVar.f20710m == null) {
            this.f20694n = new File(context.getFilesDir(), "gecko_offline_res_x");
        } else {
            this.f20694n = aVar.f20710m;
        }
        String str2 = aVar.f20709l;
        this.f20691k = str2;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("host == null");
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        if (l11 == null) {
            throw new IllegalArgumentException("appId == null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("deviceId key empty");
        }
        this.f20684d = aVar.f20698a;
        this.f20683c = aVar.f20703f;
        this.f20695o = aVar.f20704g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, byte b11) {
        this(aVar);
    }

    public static void a(IThreadPoolCallback iThreadPoolCallback) {
        f20679r = iThreadPoolCallback;
    }

    public static Executor g() {
        return t();
    }

    public static Executor h() {
        return t();
    }

    public static ExecutorService t() {
        IThreadPoolCallback iThreadPoolCallback = f20679r;
        ExecutorService threadPool = iThreadPoolCallback != null ? iThreadPoolCallback.getThreadPool() : null;
        if (threadPool != null) {
            return threadPool;
        }
        if (f20680s == null) {
            synchronized (b.class) {
                try {
                    if (f20680s == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        f20680s = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f20680s;
    }

    public final Context a() {
        return this.f20681a;
    }

    public final void a(JSONObject jSONObject) {
        this.f20697q = jSONObject;
    }

    public final com.bykv.vk.openvk.preload.geckox.a.a.a b() {
        return this.f20687g;
    }

    public final boolean c() {
        return this.f20695o;
    }

    public final List<String> d() {
        return this.f20686f;
    }

    public final List<String> e() {
        return this.f20685e;
    }

    public final JSONObject f() {
        return this.f20697q;
    }

    public final INetWork i() {
        return this.f20684d;
    }

    public final String j() {
        return this.f20691k;
    }

    public final long k() {
        return this.f20688h.longValue();
    }

    public final String l() {
        return this.f20693m;
    }

    public final String m() {
        return this.f20692l;
    }

    public final File n() {
        return this.f20694n;
    }

    public final String o() {
        return this.f20689i;
    }

    public final com.bykv.vk.openvk.preload.geckox.a.a.c p() {
        return this.f20682b;
    }

    public final IStatisticMonitor q() {
        return this.f20683c;
    }

    public final String r() {
        return this.f20690j;
    }

    public final long s() {
        return this.f20696p;
    }
}
