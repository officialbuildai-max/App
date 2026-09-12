package com.apm.insight.runtime.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f19819a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f19820b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f19821c = false;

    /* renamed from: d, reason: collision with root package name */
    private static int f19822d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f19823e = false;

    /* renamed from: f, reason: collision with root package name */
    private static long f19824f = -1;

    /* renamed from: z, reason: collision with root package name */
    private static volatile b f19825z;
    private int B;

    /* renamed from: g, reason: collision with root package name */
    private Application f19826g;

    /* renamed from: h, reason: collision with root package name */
    private Context f19827h;

    /* renamed from: n, reason: collision with root package name */
    private String f19833n;

    /* renamed from: o, reason: collision with root package name */
    private long f19834o;

    /* renamed from: p, reason: collision with root package name */
    private String f19835p;

    /* renamed from: q, reason: collision with root package name */
    private long f19836q;

    /* renamed from: r, reason: collision with root package name */
    private String f19837r;

    /* renamed from: s, reason: collision with root package name */
    private long f19838s;

    /* renamed from: t, reason: collision with root package name */
    private String f19839t;

    /* renamed from: u, reason: collision with root package name */
    private long f19840u;

    /* renamed from: v, reason: collision with root package name */
    private String f19841v;

    /* renamed from: w, reason: collision with root package name */
    private long f19842w;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f19828i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private List<Long> f19829j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private List<String> f19830k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private List<Long> f19831l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private LinkedList<a> f19832m = new LinkedList<>();

    /* renamed from: x, reason: collision with root package name */
    private boolean f19843x = false;

    /* renamed from: y, reason: collision with root package name */
    private long f19844y = -1;
    private int A = 50;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f19846a;

        /* renamed from: b, reason: collision with root package name */
        String f19847b;

        /* renamed from: c, reason: collision with root package name */
        long f19848c;

        a(String str, String str2, long j11) {
            this.f19847b = str2;
            this.f19848c = j11;
            this.f19846a = str;
        }

        public final String toString() {
            return com.apm.insight.l.b.a().format(new Date(this.f19848c)) + " : " + this.f19846a + ' ' + this.f19847b;
        }
    }

    private b(@NonNull Application application) {
        this.f19827h = application;
        this.f19826g = application;
        if (application != null) {
            try {
                this.f19826g.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.apm.insight.runtime.a.b.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityCreated(Activity activity, Bundle bundle) {
                        b.this.f19833n = activity.getClass().getName();
                        b.this.f19834o = System.currentTimeMillis();
                        boolean unused = b.f19820b = bundle != null;
                        boolean unused2 = b.f19821c = true;
                        b.this.f19828i.add(b.this.f19833n);
                        b.this.f19829j.add(Long.valueOf(b.this.f19834o));
                        b bVar = b.this;
                        b.a(bVar, bVar.f19833n, b.this.f19834o, "onCreate");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityDestroyed(Activity activity) {
                        String name = activity.getClass().getName();
                        int indexOf = b.this.f19828i.indexOf(name);
                        if (indexOf >= 0 && indexOf < b.this.f19828i.size()) {
                            b.this.f19828i.remove(indexOf);
                            b.this.f19829j.remove(indexOf);
                        }
                        b.this.f19830k.add(name);
                        long currentTimeMillis = System.currentTimeMillis();
                        b.this.f19831l.add(Long.valueOf(currentTimeMillis));
                        b.a(b.this, name, currentTimeMillis, "onDestroy");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityPaused(Activity activity) {
                        b.this.f19839t = activity.getClass().getName();
                        b.this.f19840u = System.currentTimeMillis();
                        b.l(b.this);
                        if (b.this.B == 0) {
                            b.this.f19843x = false;
                            boolean unused = b.f19821c = false;
                            b.this.f19844y = SystemClock.uptimeMillis();
                        } else if (b.this.B < 0) {
                            b.n(b.this);
                            b.this.f19843x = false;
                            boolean unused2 = b.f19821c = false;
                            b.this.f19844y = SystemClock.uptimeMillis();
                        }
                        b bVar = b.this;
                        b.a(bVar, bVar.f19839t, b.this.f19840u, "onPause");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityResumed(Activity activity) {
                        b.this.f19837r = activity.getClass().getName();
                        b.this.f19838s = System.currentTimeMillis();
                        b.g(b.this);
                        if (!b.this.f19843x) {
                            if (b.f19819a) {
                                b.k();
                                int unused = b.f19822d = 1;
                                long unused2 = b.f19824f = b.this.f19838s;
                            }
                            if (!b.this.f19837r.equals(b.this.f19839t)) {
                                return;
                            }
                            if (b.f19821c && !b.f19820b) {
                                int unused3 = b.f19822d = 4;
                                long unused4 = b.f19824f = b.this.f19838s;
                                return;
                            } else if (!b.f19821c) {
                                int unused5 = b.f19822d = 3;
                                long unused6 = b.f19824f = b.this.f19838s;
                                return;
                            }
                        }
                        b.this.f19843x = true;
                        b bVar = b.this;
                        b.a(bVar, bVar.f19837r, b.this.f19838s, "onResume");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityStarted(Activity activity) {
                        b.this.f19835p = activity.getClass().getName();
                        b.this.f19836q = System.currentTimeMillis();
                        b bVar = b.this;
                        b.a(bVar, bVar.f19835p, b.this.f19836q, TmcConstants.NAVIGATION_ON_START);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityStopped(Activity activity) {
                        b.this.f19841v = activity.getClass().getName();
                        b.this.f19842w = System.currentTimeMillis();
                        b bVar = b.this;
                        b.a(bVar, bVar.f19841v, b.this.f19842w, "onStop");
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    private static JSONObject a(String str, long j11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put(EventConstants.KEY_TIME, j11);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void a() {
        f19823e = true;
    }

    static /* synthetic */ void a(b bVar, String str, long j11, String str2) {
        a aVar;
        if (com.apm.insight.e.w()) {
            try {
                if (bVar.f19832m.size() >= bVar.A) {
                    aVar = bVar.f19832m.poll();
                    if (aVar != null) {
                        bVar.f19832m.add(aVar);
                    }
                } else {
                    aVar = null;
                }
                if (aVar == null) {
                    aVar = new a(str, str2, j11);
                    bVar.f19832m.add(aVar);
                }
                aVar.f19847b = str2;
                aVar.f19846a = str;
                aVar.f19848c = j11;
            } catch (Throwable unused) {
            }
        }
    }

    public static int b() {
        int i11 = f19822d;
        return i11 == 1 ? f19823e ? 2 : 1 : i11;
    }

    public static long c() {
        return f19824f;
    }

    public static b d() {
        if (f19825z == null) {
            synchronized (b.class) {
                try {
                    if (f19825z == null) {
                        f19825z = new b(com.apm.insight.e.h());
                    }
                } finally {
                }
            }
        }
        return f19825z;
    }

    static /* synthetic */ int g(b bVar) {
        int i11 = bVar.B;
        bVar.B = i11 + 1;
        return i11;
    }

    static /* synthetic */ boolean k() {
        f19819a = false;
        return false;
    }

    static /* synthetic */ int l(b bVar) {
        int i11 = bVar.B;
        bVar.B = i11 - 1;
        return i11;
    }

    static /* synthetic */ int n(b bVar) {
        bVar.B = 0;
        return 0;
    }

    private JSONArray n() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f19828i;
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < this.f19828i.size(); i11++) {
                try {
                    jSONArray.put(a(this.f19828i.get(i11), this.f19829j.get(i11).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray o() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f19830k;
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < this.f19830k.size(); i11++) {
                try {
                    jSONArray.put(a(this.f19830k.get(i11), this.f19831l.get(i11).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public final long e() {
        return SystemClock.uptimeMillis() - this.f19844y;
    }

    public final boolean f() {
        return this.f19843x;
    }

    public final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        if (com.apm.insight.e.w()) {
            try {
                jSONObject.put("last_create_activity", a(this.f19833n, this.f19834o));
                jSONObject.put("last_start_activity", a(this.f19835p, this.f19836q));
                jSONObject.put("last_resume_activity", a(this.f19837r, this.f19838s));
                jSONObject.put("last_pause_activity", a(this.f19839t, this.f19840u));
                jSONObject.put("last_stop_activity", a(this.f19841v, this.f19842w));
                jSONObject.put("alive_activities", n());
                jSONObject.put("finish_activities", o());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    @NonNull
    public final String h() {
        return String.valueOf(this.f19837r);
    }

    public final JSONArray i() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = new ArrayList(this.f19832m).iterator();
        while (it.hasNext()) {
            jSONArray.put(((a) it.next()).toString());
        }
        return jSONArray;
    }
}
