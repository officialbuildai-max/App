package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.abt.AbtException;
import com.google.firebase.concurrent.FirebaseExecutors;
import com.google.firebase.f;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.e;
import com.google.firebase.remoteconfig.internal.m;
import com.google.firebase.remoteconfig.internal.n;
import com.google.firebase.remoteconfig.internal.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yc.i;
import yc.j;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: n, reason: collision with root package name */
    public static final byte[] f32460n = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private final Context f32461a;

    /* renamed from: b, reason: collision with root package name */
    private final f f32462b;

    /* renamed from: c, reason: collision with root package name */
    private final hb.b f32463c;

    /* renamed from: d, reason: collision with root package name */
    private final Executor f32464d;

    /* renamed from: e, reason: collision with root package name */
    private final e f32465e;

    /* renamed from: f, reason: collision with root package name */
    private final e f32466f;

    /* renamed from: g, reason: collision with root package name */
    private final e f32467g;

    /* renamed from: h, reason: collision with root package name */
    private final ConfigFetchHandler f32468h;

    /* renamed from: i, reason: collision with root package name */
    private final m f32469i;

    /* renamed from: j, reason: collision with root package name */
    private final n f32470j;

    /* renamed from: k, reason: collision with root package name */
    private final jc.e f32471k;

    /* renamed from: l, reason: collision with root package name */
    private final o f32472l;

    /* renamed from: m, reason: collision with root package name */
    private final zc.e f32473m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, f fVar, jc.e eVar, hb.b bVar, Executor executor, e eVar2, e eVar3, e eVar4, ConfigFetchHandler configFetchHandler, m mVar, n nVar, o oVar, zc.e eVar5) {
        this.f32461a = context;
        this.f32462b = fVar;
        this.f32471k = eVar;
        this.f32463c = bVar;
        this.f32464d = executor;
        this.f32465e = eVar2;
        this.f32466f = eVar3;
        this.f32467g = eVar4;
        this.f32468h = configFetchHandler;
        this.f32469i = mVar;
        this.f32470j = nVar;
        this.f32472l = oVar;
        this.f32473m = eVar5;
    }

    public static a k() {
        return l(f.l());
    }

    public static a l(f fVar) {
        return ((c) fVar.j(c.class)).g();
    }

    private static boolean q(com.google.firebase.remoteconfig.internal.f fVar, com.google.firebase.remoteconfig.internal.f fVar2) {
        return fVar2 == null || !fVar.h().equals(fVar2.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task r(Task task, Task task2, Task task3) {
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(Boolean.FALSE);
        }
        com.google.firebase.remoteconfig.internal.f fVar = (com.google.firebase.remoteconfig.internal.f) task.getResult();
        return (!task2.isSuccessful() || q(fVar, (com.google.firebase.remoteconfig.internal.f) task2.getResult())) ? this.f32466f.k(fVar).continueWith(this.f32464d, new Continuation() { // from class: yc.g
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task4) {
                boolean v11;
                v11 = com.google.firebase.remoteconfig.a.this.v(task4);
                return Boolean.valueOf(v11);
            }
        }) : Tasks.forResult(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task s(ConfigFetchHandler.a aVar) {
        return Tasks.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task t(Void r12) {
        return f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void u(j jVar) {
        this.f32470j.l(jVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(Task task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.f32465e.d();
        com.google.firebase.remoteconfig.internal.f fVar = (com.google.firebase.remoteconfig.internal.f) task.getResult();
        if (fVar == null) {
            Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
            return true;
        }
        A(fVar.e());
        this.f32473m.g(fVar);
        return true;
    }

    static List z(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    void A(JSONArray jSONArray) {
        if (this.f32463c == null) {
            return;
        }
        try {
            this.f32463c.m(z(jSONArray));
        } catch (AbtException e11) {
            Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e11);
        } catch (JSONException e12) {
            Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e12);
        }
    }

    public Task f() {
        final Task e11 = this.f32465e.e();
        final Task e12 = this.f32466f.e();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{e11, e12}).continueWithTask(this.f32464d, new Continuation() { // from class: yc.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task r11;
                r11 = com.google.firebase.remoteconfig.a.this.r(e11, e12, task);
                return r11;
            }
        });
    }

    public Task g() {
        return this.f32468h.i().onSuccessTask(FirebaseExecutors.a(), new SuccessContinuation() { // from class: yc.f
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task s11;
                s11 = com.google.firebase.remoteconfig.a.s((ConfigFetchHandler.a) obj);
                return s11;
            }
        });
    }

    public Task h() {
        return g().onSuccessTask(this.f32464d, new SuccessContinuation() { // from class: yc.d
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task t11;
                t11 = com.google.firebase.remoteconfig.a.this.t((Void) obj);
                return t11;
            }
        });
    }

    public Map i() {
        return this.f32469i.d();
    }

    public i j() {
        return this.f32470j.c();
    }

    public Set m(String str) {
        return this.f32469i.g(str);
    }

    public long n(String str) {
        return this.f32469i.i(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zc.e o() {
        return this.f32473m;
    }

    public String p(String str) {
        return this.f32469i.k(str);
    }

    public Task w(final j jVar) {
        return Tasks.call(this.f32464d, new Callable() { // from class: yc.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void u11;
                u11 = com.google.firebase.remoteconfig.a.this.u(jVar);
                return u11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(boolean z10) {
        this.f32472l.b(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        this.f32466f.e();
        this.f32467g.e();
        this.f32465e.e();
    }
}
