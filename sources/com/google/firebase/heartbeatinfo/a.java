package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.core.os.t;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import gc.h;
import gc.p;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import mb.b0;
import mb.r;
import mb.u;
import org.json.JSONArray;
import org.json.JSONObject;
import xc.i;

/* loaded from: classes4.dex */
public class a implements h, HeartBeatInfo {

    /* renamed from: a, reason: collision with root package name */
    private final ic.b f31913a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f31914b;

    /* renamed from: c, reason: collision with root package name */
    private final ic.b f31915c;

    /* renamed from: d, reason: collision with root package name */
    private final Set f31916d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f31917e;

    private a(final Context context, final String str, Set set, ic.b bVar, Executor executor) {
        this(new u(new ic.b() { // from class: gc.c
            @Override // ic.b
            public final Object get() {
                com.google.firebase.heartbeatinfo.f j11;
                j11 = com.google.firebase.heartbeatinfo.a.j(context, str);
                return j11;
            }
        }), set, executor, bVar, context);
    }

    a(ic.b bVar, Set set, Executor executor, ic.b bVar2, Context context) {
        this.f31913a = bVar;
        this.f31916d = set;
        this.f31917e = executor;
        this.f31915c = bVar2;
        this.f31914b = context;
    }

    public static mb.c g() {
        final b0 a11 = b0.a(lb.a.class, Executor.class);
        return mb.c.d(a.class, h.class, HeartBeatInfo.class).b(r.k(Context.class)).b(r.k(com.google.firebase.f.class)).b(r.o(gc.f.class)).b(r.m(i.class)).b(r.l(a11)).f(new mb.h() { // from class: gc.b
            @Override // mb.h
            public final Object a(mb.e eVar) {
                com.google.firebase.heartbeatinfo.a h11;
                h11 = com.google.firebase.heartbeatinfo.a.h(b0.this, eVar);
                return h11;
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a h(b0 b0Var, mb.e eVar) {
        return new a((Context) eVar.a(Context.class), ((com.google.firebase.f) eVar.a(com.google.firebase.f.class)).o(), eVar.d(gc.f.class), eVar.f(i.class), (Executor) eVar.c(b0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String i() {
        String byteArrayOutputStream;
        synchronized (this) {
            try {
                f fVar = (f) this.f31913a.get();
                List g11 = fVar.g();
                fVar.f();
                JSONArray jSONArray = new JSONArray();
                for (int i11 = 0; i11 < g11.size(); i11++) {
                    p pVar = (p) g11.get(i11);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", pVar.c());
                    jSONObject.put("dates", new JSONArray((Collection) pVar.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
                    } finally {
                    }
                } catch (Throwable th2) {
                    try {
                        base64OutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        return byteArrayOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f j(Context context, String str) {
        return new f(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void k() {
        synchronized (this) {
            ((f) this.f31913a.get()).s(System.currentTimeMillis(), ((i) this.f31915c.get()).getUserAgent());
        }
        return null;
    }

    @Override // gc.h
    public Task a() {
        return !t.a(this.f31914b) ? Tasks.forResult("") : Tasks.call(this.f31917e, new Callable() { // from class: gc.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String i11;
                i11 = com.google.firebase.heartbeatinfo.a.this.i();
                return i11;
            }
        });
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public synchronized HeartBeatInfo.HeartBeat b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = (f) this.f31913a.get();
        if (!fVar.q(currentTimeMillis)) {
            return HeartBeatInfo.HeartBeat.NONE;
        }
        fVar.o();
        return HeartBeatInfo.HeartBeat.GLOBAL;
    }

    public Task l() {
        if (this.f31916d.size() > 0 && t.a(this.f31914b)) {
            return Tasks.call(this.f31917e, new Callable() { // from class: gc.e
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void k11;
                    k11 = com.google.firebase.heartbeatinfo.a.this.k();
                    return k11;
                }
            });
        }
        return Tasks.forResult(null);
    }
}
