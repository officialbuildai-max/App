package com.iab.omid.library.mmadbridge.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.mmadbridge.adsession.h;
import com.iab.omid.library.mmadbridge.internal.j;
import com.iab.omid.library.mmadbridge.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ne.a;
import oe.f;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TreeWalker implements a.InterfaceC0877a {

    /* renamed from: i, reason: collision with root package name */
    private static TreeWalker f33791i = new TreeWalker();

    /* renamed from: j, reason: collision with root package name */
    private static Handler f33792j = new Handler(Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    private static Handler f33793k = null;

    /* renamed from: l, reason: collision with root package name */
    private static final Runnable f33794l = new b();

    /* renamed from: m, reason: collision with root package name */
    private static final Runnable f33795m = new c();

    /* renamed from: b, reason: collision with root package name */
    private int f33797b;

    /* renamed from: h, reason: collision with root package name */
    private long f33803h;

    /* renamed from: a, reason: collision with root package name */
    private List f33796a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f33798c = false;

    /* renamed from: d, reason: collision with root package name */
    private final List f33799d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.walking.a f33801f = new com.iab.omid.library.mmadbridge.walking.a();

    /* renamed from: e, reason: collision with root package name */
    private ne.b f33800e = new ne.b();

    /* renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.walking.b f33802g = new com.iab.omid.library.mmadbridge.walking.b(new pe.c());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f33802g.c();
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
            if (TreeWalker.f33793k != null) {
                TreeWalker.f33793k.post(TreeWalker.f33794l);
                TreeWalker.f33793k.postDelayed(TreeWalker.f33795m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void d(long j11) {
        if (this.f33796a.size() > 0) {
            Iterator it = this.f33796a.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                TimeUnit.NANOSECONDS.toMillis(j11);
                throw null;
            }
        }
    }

    private void e(View view, ne.a aVar, JSONObject jSONObject, com.iab.omid.library.mmadbridge.walking.c cVar, boolean z10) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.mmadbridge.walking.c.PARENT_VIEW, z10);
    }

    private void f(String str, View view, JSONObject jSONObject) {
        ne.a b11 = this.f33800e.b();
        String h11 = this.f33801f.h(str);
        if (h11 != null) {
            JSONObject a11 = b11.a(view);
            oe.c.h(a11, str);
            oe.c.o(a11, h11);
            oe.c.j(jSONObject, a11);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        a.C0463a g11 = this.f33801f.g(view);
        if (g11 == null) {
            return false;
        }
        oe.c.f(jSONObject, g11);
        return true;
    }

    private boolean j(View view, JSONObject jSONObject) {
        String j11 = this.f33801f.j(view);
        if (j11 == null) {
            return false;
        }
        oe.c.h(jSONObject, j11);
        oe.c.g(jSONObject, Boolean.valueOf(this.f33801f.p(view)));
        oe.c.n(jSONObject, Boolean.valueOf(this.f33801f.l(j11)));
        this.f33801f.n();
        return true;
    }

    private void l() {
        d(f.b() - this.f33803h);
    }

    private void m() {
        this.f33797b = 0;
        this.f33799d.clear();
        this.f33798c = false;
        Iterator it = com.iab.omid.library.mmadbridge.internal.c.e().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((h) it.next()).p()) {
                this.f33798c = true;
                break;
            }
        }
        this.f33803h = f.b();
    }

    public static TreeWalker p() {
        return f33791i;
    }

    private void r() {
        if (f33793k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f33793k = handler;
            handler.post(f33794l);
            f33793k.postDelayed(f33795m, 200L);
        }
    }

    private void t() {
        Handler handler = f33793k;
        if (handler != null) {
            handler.removeCallbacks(f33795m);
            f33793k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        m();
        n();
        l();
        j.f().a();
    }

    @Override // ne.a.InterfaceC0877a
    public void a(View view, ne.a aVar, JSONObject jSONObject, boolean z10) {
        com.iab.omid.library.mmadbridge.walking.c m11;
        if (oe.h.f(view) && (m11 = this.f33801f.m(view)) != com.iab.omid.library.mmadbridge.walking.c.UNDERLYING_VIEW) {
            JSONObject a11 = aVar.a(view);
            oe.c.j(jSONObject, a11);
            if (!j(view, a11)) {
                boolean z11 = z10 || g(view, a11);
                if (this.f33798c && m11 == com.iab.omid.library.mmadbridge.walking.c.OBSTRUCTION_VIEW && !z11) {
                    this.f33799d.add(new qe.a(view));
                }
                e(view, aVar, a11, m11, z11);
            }
            this.f33797b++;
        }
    }

    void n() {
        this.f33801f.o();
        long b11 = f.b();
        ne.a a11 = this.f33800e.a();
        if (this.f33801f.i().size() > 0) {
            Iterator it = this.f33801f.i().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject a12 = a11.a(null);
                f(str, this.f33801f.a(str), a12);
                oe.c.m(a12);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.f33802g.b(a12, hashSet, b11);
            }
        }
        if (this.f33801f.k().size() > 0) {
            JSONObject a13 = a11.a(null);
            e(null, a11, a13, com.iab.omid.library.mmadbridge.walking.c.PARENT_VIEW, false);
            oe.c.m(a13);
            this.f33802g.d(a13, this.f33801f.k(), b11);
            if (this.f33798c) {
                Iterator it2 = com.iab.omid.library.mmadbridge.internal.c.e().a().iterator();
                while (it2.hasNext()) {
                    ((h) it2.next()).j(this.f33799d);
                }
            }
        } else {
            this.f33802g.c();
        }
        this.f33801f.d();
    }

    public void o() {
        t();
    }

    public void q() {
        r();
    }

    public void s() {
        o();
        this.f33796a.clear();
        f33792j.post(new a());
    }
}
