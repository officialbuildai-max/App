package com.iab.omid.library.bytedance2.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.bytedance2.processor.a;
import com.iab.omid.library.bytedance2.utils.f;
import com.iab.omid.library.bytedance2.utils.h;
import com.iab.omid.library.bytedance2.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TreeWalker implements a.InterfaceC0456a {

    /* renamed from: i, reason: collision with root package name */
    private static TreeWalker f33549i = new TreeWalker();

    /* renamed from: j, reason: collision with root package name */
    private static Handler f33550j = new Handler(Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    private static Handler f33551k = null;

    /* renamed from: l, reason: collision with root package name */
    private static final Runnable f33552l = new b();

    /* renamed from: m, reason: collision with root package name */
    private static final Runnable f33553m = new c();

    /* renamed from: b, reason: collision with root package name */
    private int f33555b;

    /* renamed from: h, reason: collision with root package name */
    private long f33561h;

    /* renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f33554a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f33556c = false;

    /* renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.bytedance2.weakreference.a> f33557d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.walking.a f33559f = new com.iab.omid.library.bytedance2.walking.a();

    /* renamed from: e, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.processor.b f33558e = new com.iab.omid.library.bytedance2.processor.b();

    /* renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.walking.b f33560g = new com.iab.omid.library.bytedance2.walking.b(new com.iab.omid.library.bytedance2.walking.async.c());

    /* loaded from: classes4.dex */
    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i11, long j11);
    }

    /* loaded from: classes4.dex */
    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i11, long j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f33560g.b();
        }
    }

    /* loaded from: classes4.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().l();
        }
    }

    /* loaded from: classes4.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.f33551k != null) {
                TreeWalker.f33551k.post(TreeWalker.f33552l);
                TreeWalker.f33551k.postDelayed(TreeWalker.f33553m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void a(long j11) {
        if (this.f33554a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f33554a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f33555b, TimeUnit.NANOSECONDS.toMillis(j11));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f33555b, j11);
                }
            }
        }
    }

    private void a(View view, com.iab.omid.library.bytedance2.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.bytedance2.walking.c cVar, boolean z10) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.bytedance2.walking.c.PARENT_VIEW, z10);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.bytedance2.processor.a b11 = this.f33558e.b();
        String b12 = this.f33559f.b(str);
        if (b12 != null) {
            JSONObject a11 = b11.a(view);
            com.iab.omid.library.bytedance2.utils.c.a(a11, str);
            com.iab.omid.library.bytedance2.utils.c.b(a11, b12);
            com.iab.omid.library.bytedance2.utils.c.a(jSONObject, a11);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0458a c11 = this.f33559f.c(view);
        if (c11 == null) {
            return false;
        }
        com.iab.omid.library.bytedance2.utils.c.a(jSONObject, c11);
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        String d11 = this.f33559f.d(view);
        if (d11 == null) {
            return false;
        }
        com.iab.omid.library.bytedance2.utils.c.a(jSONObject, d11);
        com.iab.omid.library.bytedance2.utils.c.a(jSONObject, Boolean.valueOf(this.f33559f.f(view)));
        this.f33559f.d();
        return true;
    }

    private void d() {
        a(f.b() - this.f33561h);
    }

    private void e() {
        this.f33555b = 0;
        this.f33557d.clear();
        this.f33556c = false;
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = com.iab.omid.library.bytedance2.internal.c.c().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().e()) {
                this.f33556c = true;
                break;
            }
        }
        this.f33561h = f.b();
    }

    public static TreeWalker getInstance() {
        return f33549i;
    }

    private void i() {
        if (f33551k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f33551k = handler;
            handler.post(f33552l);
            f33551k.postDelayed(f33553m, 200L);
        }
    }

    private void k() {
        Handler handler = f33551k;
        if (handler != null) {
            handler.removeCallbacks(f33553m);
            f33551k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
    }

    @Override // com.iab.omid.library.bytedance2.processor.a.InterfaceC0456a
    public void a(View view, com.iab.omid.library.bytedance2.processor.a aVar, JSONObject jSONObject, boolean z10) {
        com.iab.omid.library.bytedance2.walking.c e11;
        if (h.d(view) && (e11 = this.f33559f.e(view)) != com.iab.omid.library.bytedance2.walking.c.UNDERLYING_VIEW) {
            JSONObject a11 = aVar.a(view);
            com.iab.omid.library.bytedance2.utils.c.a(jSONObject, a11);
            if (!b(view, a11)) {
                boolean z11 = z10 || a(view, a11);
                if (this.f33556c && e11 == com.iab.omid.library.bytedance2.walking.c.OBSTRUCTION_VIEW && !z11) {
                    this.f33557d.add(new com.iab.omid.library.bytedance2.weakreference.a(view));
                }
                a(view, aVar, a11, e11, z11);
            }
            this.f33555b++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f33554a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f33554a.add(treeWalkerTimeLogger);
    }

    void f() {
        this.f33559f.e();
        long b11 = f.b();
        com.iab.omid.library.bytedance2.processor.a a11 = this.f33558e.a();
        if (this.f33559f.b().size() > 0) {
            Iterator<String> it = this.f33559f.b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a12 = a11.a(null);
                a(next, this.f33559f.a(next), a12);
                com.iab.omid.library.bytedance2.utils.c.b(a12);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(next);
                this.f33560g.a(a12, hashSet, b11);
            }
        }
        if (this.f33559f.c().size() > 0) {
            JSONObject a13 = a11.a(null);
            a(null, a11, a13, com.iab.omid.library.bytedance2.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.bytedance2.utils.c.b(a13);
            this.f33560g.b(a13, this.f33559f.c(), b11);
            if (this.f33556c) {
                Iterator<com.iab.omid.library.bytedance2.adsession.a> it2 = com.iab.omid.library.bytedance2.internal.c.c().a().iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.f33557d);
                }
            }
        } else {
            this.f33560g.b();
        }
        this.f33559f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f33554a.clear();
        f33550j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f33554a.contains(treeWalkerTimeLogger)) {
            this.f33554a.remove(treeWalkerTimeLogger);
        }
    }
}
