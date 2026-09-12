package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.c0;
import com.google.firebase.crashlytics.internal.common.d0;
import com.google.firebase.crashlytics.internal.common.g0;
import com.google.firebase.crashlytics.internal.common.x0;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.settings.e;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e implements wb.b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f31805a;

    /* renamed from: b, reason: collision with root package name */
    private final h f31806b;

    /* renamed from: c, reason: collision with root package name */
    private final f f31807c;

    /* renamed from: d, reason: collision with root package name */
    private final c0 f31808d;

    /* renamed from: e, reason: collision with root package name */
    private final wb.a f31809e;

    /* renamed from: f, reason: collision with root package name */
    private final i f31810f;

    /* renamed from: g, reason: collision with root package name */
    private final d0 f31811g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicReference f31812h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicReference f31813i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements SuccessContinuation {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CrashlyticsWorkers f31814a;

        a(CrashlyticsWorkers crashlyticsWorkers) {
            this.f31814a = crashlyticsWorkers;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ JSONObject b() {
            return e.this.f31810f.a(e.this.f31806b, true);
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Task then(Void r52) {
            JSONObject jSONObject = (JSONObject) this.f31814a.f31354d.c().submit(new Callable() { // from class: com.google.firebase.crashlytics.internal.settings.d
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    JSONObject b11;
                    b11 = e.a.this.b();
                    return b11;
                }
            }).get();
            if (jSONObject != null) {
                c b11 = e.this.f31807c.b(jSONObject);
                e.this.f31809e.c(b11.f31793c, jSONObject);
                e.this.q(jSONObject, "Loaded settings: ");
                e eVar = e.this;
                eVar.r(eVar.f31806b.f31822f);
                e.this.f31812h.set(b11);
                ((TaskCompletionSource) e.this.f31813i.get()).trySetResult(b11);
            }
            return Tasks.forResult(null);
        }
    }

    e(Context context, h hVar, c0 c0Var, f fVar, wb.a aVar, i iVar, d0 d0Var) {
        AtomicReference atomicReference = new AtomicReference();
        this.f31812h = atomicReference;
        this.f31813i = new AtomicReference(new TaskCompletionSource());
        this.f31805a = context;
        this.f31806b = hVar;
        this.f31808d = c0Var;
        this.f31807c = fVar;
        this.f31809e = aVar;
        this.f31810f = iVar;
        this.f31811g = d0Var;
        atomicReference.set(com.google.firebase.crashlytics.internal.settings.a.b(c0Var));
    }

    public static e l(Context context, String str, g0 g0Var, ub.b bVar, String str2, String str3, vb.g gVar, d0 d0Var) {
        String g11 = g0Var.g();
        x0 x0Var = new x0();
        return new e(context, new h(str, g0Var.h(), g0Var.i(), g0Var.j(), g0Var, CommonUtils.h(CommonUtils.m(context), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(g11).getId()), x0Var, new f(x0Var), new wb.a(gVar), new b(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), bVar), d0Var);
    }

    private c m(SettingsCacheBehavior settingsCacheBehavior) {
        c cVar = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject b11 = this.f31809e.b();
                if (b11 != null) {
                    c b12 = this.f31807c.b(b11);
                    if (b12 != null) {
                        q(b11, "Loaded cached settings: ");
                        long a11 = this.f31808d.a();
                        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && b12.a(a11)) {
                            ob.g.f().i("Cached settings have expired.");
                        }
                        try {
                            ob.g.f().i("Returning cached settings.");
                            cVar = b12;
                        } catch (Exception e11) {
                            e = e11;
                            cVar = b12;
                            ob.g.f().e("Failed to get cached settings", e);
                            return cVar;
                        }
                    } else {
                        ob.g.f().e("Failed to parse cached settings data.", null);
                    }
                } else {
                    ob.g.f().b("No cached settings data found.");
                }
            }
        } catch (Exception e12) {
            e = e12;
        }
        return cVar;
    }

    private String n() {
        return CommonUtils.q(this.f31805a).getString("existing_instance_identifier", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONObject jSONObject, String str) {
        ob.g.f().b(str + jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(String str) {
        SharedPreferences.Editor edit = CommonUtils.q(this.f31805a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }

    @Override // wb.b
    public Task a() {
        return ((TaskCompletionSource) this.f31813i.get()).getTask();
    }

    @Override // wb.b
    public c b() {
        return (c) this.f31812h.get();
    }

    boolean k() {
        return !n().equals(this.f31806b.f31822f);
    }

    public Task o(CrashlyticsWorkers crashlyticsWorkers) {
        return p(SettingsCacheBehavior.USE_CACHE, crashlyticsWorkers);
    }

    public Task p(SettingsCacheBehavior settingsCacheBehavior, CrashlyticsWorkers crashlyticsWorkers) {
        c m11;
        if (!k() && (m11 = m(settingsCacheBehavior)) != null) {
            this.f31812h.set(m11);
            ((TaskCompletionSource) this.f31813i.get()).trySetResult(m11);
            return Tasks.forResult(null);
        }
        c m12 = m(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (m12 != null) {
            this.f31812h.set(m12);
            ((TaskCompletionSource) this.f31813i.get()).trySetResult(m12);
        }
        return this.f31811g.k().onSuccessTask(crashlyticsWorkers.f31351a, new a(crashlyticsWorkers));
    }
}
