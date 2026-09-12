package com.iab.omid.library.vungle.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.vungle.adsession.h;
import com.iab.omid.library.vungle.internal.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import te.a;
import ue.f;

/* loaded from: classes4.dex */
public class TreeWalker implements a.InterfaceC0951a {

    /* renamed from: i, reason: collision with root package name */
    private static TreeWalker f33901i = new TreeWalker();

    /* renamed from: j, reason: collision with root package name */
    private static Handler f33902j = new Handler(Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    private static Handler f33903k = null;

    /* renamed from: l, reason: collision with root package name */
    private static final Runnable f33904l = new b();

    /* renamed from: m, reason: collision with root package name */
    private static final Runnable f33905m = new c();

    /* renamed from: b, reason: collision with root package name */
    private int f33907b;

    /* renamed from: h, reason: collision with root package name */
    private long f33913h;

    /* renamed from: a, reason: collision with root package name */
    private List f33906a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f33908c = false;

    /* renamed from: d, reason: collision with root package name */
    private final List f33909d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.vungle.walking.a f33911f = new com.iab.omid.library.vungle.walking.a();

    /* renamed from: e, reason: collision with root package name */
    private te.b f33910e = new te.b();

    /* renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.vungle.walking.b f33912g = new com.iab.omid.library.vungle.walking.b(new ve.c());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f33912g.c();
        }
    }

    /* loaded from: classes4.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.p().u();
        }
    }

    /* loaded from: classes4.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.f33903k != null) {
                TreeWalker.f33903k.post(TreeWalker.f33904l);
                TreeWalker.f33903k.postDelayed(TreeWalker.f33905m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void d(long j11) {
        if (this.f33906a.size() > 0) {
            Iterator it = this.f33906a.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                TimeUnit.NANOSECONDS.toMillis(j11);
                throw null;
            }
        }
    }

    private void e(View view, te.a aVar, JSONObject jSONObject, com.iab.omid.library.vungle.walking.c cVar, boolean z10) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.vungle.walking.c.PARENT_VIEW, z10);
    }

    private void f(String str, View view, JSONObject jSONObject) {
        te.a b11 = this.f33910e.b();
        String h11 = this.f33911f.h(str);
        if (h11 != null) {
            JSONObject a11 = b11.a(view);
            ue.c.h(a11, str);
            ue.c.o(a11, h11);
            ue.c.j(jSONObject, a11);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        this.f33911f.g(view);
        return false;
    }

    private boolean j(View view, JSONObject jSONObject) {
        String j11 = this.f33911f.j(view);
        if (j11 == null) {
            return false;
        }
        ue.c.h(jSONObject, j11);
        ue.c.g(jSONObject, Boolean.valueOf(this.f33911f.p(view)));
        ue.c.n(jSONObject, Boolean.valueOf(this.f33911f.l(j11)));
        this.f33911f.n();
        return true;
    }

    private void l() {
        d(f.b() - this.f33913h);
    }

    private void m() {
        this.f33907b = 0;
        this.f33909d.clear();
        this.f33908c = false;
        Iterator it = com.iab.omid.library.vungle.internal.c.e().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((h) it.next()).n()) {
                this.f33908c = true;
                break;
            }
        }
        this.f33913h = f.b();
    }

    public static TreeWalker p() {
        return f33901i;
    }

    private void r() {
        if (f33903k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f33903k = handler;
            handler.post(f33904l);
            f33903k.postDelayed(f33905m, 200L);
        }
    }

    private void t() {
        Handler handler = f33903k;
        if (handler != null) {
            handler.removeCallbacks(f33905m);
            f33903k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        m();
        n();
        l();
        j.f().a();
    }

    @Override // te.a.InterfaceC0951a
    public void a(View view, te.a aVar, JSONObject jSONObject, boolean z10) {
        com.iab.omid.library.vungle.walking.c m11;
        if (ue.h.f(view) && (m11 = this.f33911f.m(view)) != com.iab.omid.library.vungle.walking.c.UNDERLYING_VIEW) {
            JSONObject a11 = aVar.a(view);
            ue.c.j(jSONObject, a11);
            if (!j(view, a11)) {
                boolean z11 = z10 || g(view, a11);
                if (this.f33908c && m11 == com.iab.omid.library.vungle.walking.c.OBSTRUCTION_VIEW && !z11) {
                    this.f33909d.add(new we.a(view));
                }
                e(view, aVar, a11, m11, z11);
            }
            this.f33907b++;
        }
    }

    void n() {
        this.f33911f.o();
        long b11 = f.b();
        te.a a11 = this.f33910e.a();
        if (this.f33911f.i().size() > 0) {
            Iterator it = this.f33911f.i().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject a12 = a11.a(null);
                f(str, this.f33911f.a(str), a12);
                ue.c.m(a12);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.f33912g.b(a12, hashSet, b11);
            }
        }
        if (this.f33911f.k().size() > 0) {
            JSONObject a13 = a11.a(null);
            e(null, a11, a13, com.iab.omid.library.vungle.walking.c.PARENT_VIEW, false);
            ue.c.m(a13);
            this.f33912g.d(a13, this.f33911f.k(), b11);
            if (this.f33908c) {
                Iterator it2 = com.iab.omid.library.vungle.internal.c.e().a().iterator();
                while (it2.hasNext()) {
                    ((h) it2.next()).g(this.f33909d);
                }
            }
        } else {
            this.f33912g.c();
        }
        this.f33911f.d();
    }

    public void o() {
        t();
    }

    public void q() {
        r();
    }

    public void s() {
        o();
        this.f33906a.clear();
        f33902j.post(new a());
    }
}
