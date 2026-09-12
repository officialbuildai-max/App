package com.transsion.ga;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.taaneh.aethna;
import com.transsion.athena.taaneh.anehat;
import com.transsion.push.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes5.dex */
public class athena implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b, reason: collision with root package name */
    private int f44243b;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f44245d;

    /* renamed from: h, reason: collision with root package name */
    private long f44249h;

    /* renamed from: k, reason: collision with root package name */
    private long f44252k;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f44242a = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private boolean f44244c = true;

    /* renamed from: e, reason: collision with root package name */
    private long f44246e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f44247f = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f44248g = null;

    /* renamed from: i, reason: collision with root package name */
    private int f44250i = 0;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedList f44251j = new LinkedList();

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        int f44253a;

        /* renamed from: b, reason: collision with root package name */
        String f44254b;

        /* renamed from: c, reason: collision with root package name */
        long f44255c;

        a(int i11, String str, long j11) {
            this.f44253a = i11;
            this.f44254b = str;
            this.f44255c = j11;
        }
    }

    /* renamed from: com.transsion.ga.athena$athena, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class RunnableC0620athena implements Runnable {
        RunnableC0620athena() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                athena.this.f44250i = 0;
                athena.this.f44251j.clear();
                athena.this.f44244c = true;
                athena.this.f44246e = 0L;
                ehanat.d("");
            } catch (Exception unused) {
            }
        }
    }

    private boolean e(Activity activity) {
        Window window;
        if (activity == null || AthenaAnalytics.r(activity.getClass()) || (window = activity.getWindow()) == null) {
            return false;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        return (attributes.width == 1 && attributes.height == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(long j11) {
        this.f44252k = j11;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        com.transsion.athena.taaneh.athena.b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        com.transsion.athena.taaneh.athena.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        String valueOf;
        if (e(activity)) {
            try {
                String simpleName = activity.getClass().getSimpleName();
                int i11 = 1;
                if (ehanat.s()) {
                    int i12 = this.f44250i + 1;
                    this.f44250i = i12;
                    this.f44251j.addLast(new a(i12, simpleName, SystemClock.elapsedRealtime()));
                }
                int i13 = this.f44243b + 1;
                this.f44243b = i13;
                if (i13 <= 1) {
                    this.f44249h = SystemClock.elapsedRealtime();
                    if (this.f44244c) {
                        try {
                            valueOf = UUID.randomUUID().toString();
                        } catch (Exception unused) {
                            valueOf = String.valueOf(System.currentTimeMillis());
                        }
                        ehanat.d(valueOf);
                        this.f44246e = System.currentTimeMillis();
                        try {
                            Uri referrer = activity.getReferrer();
                            if (referrer != null) {
                                this.f44248g = referrer.getAuthority();
                            }
                            Intent intent = activity.getIntent();
                            String str = this.f44248g;
                            int i14 = anehat.f42857e;
                            if (intent != null) {
                                Set<String> categories = intent.getCategories();
                                if (!"android.intent.action.MAIN".equals(intent.getAction()) || categories == null || !categories.contains("android.intent.category.LAUNCHER")) {
                                    i11 = TextUtils.isEmpty(str) ? 0 : 2;
                                }
                            }
                            this.f44247f = i11;
                            if (TextUtils.equals(this.f44248g, activity.getPackageName())) {
                                this.f44247f = 3;
                            }
                        } catch (Exception e11) {
                            aethna.b(Log.getStackTraceString(e11));
                        }
                        Iterator<Integer> it = com.transsion.athena.data.athena.a().iterator();
                        while (it.hasNext()) {
                            Integer next = it.next();
                            if (next.intValue() != 9999) {
                                AthenaAnalytics.K(next.intValue()).g0("page_enter", new TrackData().add("purl", simpleName), next.intValue());
                            }
                        }
                    }
                }
                this.f44244c = false;
                Runnable runnable = this.f44245d;
                if (runnable != null) {
                    this.f44242a.removeCallbacks(runnable);
                    this.f44245d = null;
                }
            } catch (Exception e12) {
                aethna.b(Log.getStackTraceString(e12));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Bundle bundleExtra;
        if (e(activity)) {
            try {
                if (ehanat.s() && this.f44251j.size() > 0) {
                    String simpleName = activity.getClass().getSimpleName();
                    Iterator it = this.f44251j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a aVar = (a) it.next();
                        if (simpleName.equals(aVar.f44254b)) {
                            long elapsedRealtime = SystemClock.elapsedRealtime() - aVar.f44255c;
                            TrackData add = new TrackData().add("s_id", ehanat.m()).add("url", aVar.f44254b).add("no", aVar.f44253a);
                            if (elapsedRealtime <= 0) {
                                elapsedRealtime = 0;
                            }
                            TrackData add2 = add.add("t", elapsedRealtime).add("ext", "");
                            if (activity.getIntent() != null && (bundleExtra = activity.getIntent().getBundleExtra("athena")) != null) {
                                add2.add("ext", bundleExtra);
                            }
                            AthenaAnalytics.L(this.f44252k).h0("page_view", add2, this.f44252k);
                            this.f44251j.remove(aVar);
                        }
                    }
                }
                int i11 = this.f44243b - 1;
                this.f44243b = i11;
                if (i11 == 0) {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - this.f44249h;
                    if (elapsedRealtime2 > 1000 && elapsedRealtime2 < 86400000) {
                        Iterator<Integer> it2 = com.transsion.athena.data.athena.a().iterator();
                        while (it2.hasNext()) {
                            Integer next = it2.next();
                            if (next.intValue() != 9999) {
                                AthenaAnalytics.K(next.intValue()).g0("app_active", new TrackData().add("s_id", ehanat.m()).add("s_t", this.f44247f).add(PushConstants.PROVIDER_FIELD_PKG, this.f44247f == 2 ? this.f44248g : "").add("s_s", this.f44246e).add("t", elapsedRealtime2), next.intValue());
                            }
                        }
                    }
                    Runnable runnable = this.f44245d;
                    if (runnable != null) {
                        this.f44242a.removeCallbacks(runnable);
                    }
                    Handler handler = this.f44242a;
                    RunnableC0620athena runnableC0620athena = new RunnableC0620athena();
                    this.f44245d = runnableC0620athena;
                    handler.postDelayed(runnableC0620athena, ehanat.n());
                    AthenaAnalytics.X();
                }
            } catch (Exception e11) {
                aethna.b(Log.getStackTraceString(e11));
            }
        }
    }
}
