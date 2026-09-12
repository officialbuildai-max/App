package com.iab.omid.library.hisavana.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.hisavana.adsession.h;
import com.iab.omid.library.hisavana.internal.j;
import com.iab.omid.library.hisavana.walking.a;
import he.a;
import ie.f;
import ie.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TreeWalker implements a.InterfaceC0805a {

    /* renamed from: i, reason: collision with root package name */
    private static TreeWalker f33671i = new TreeWalker();

    /* renamed from: j, reason: collision with root package name */
    private static Handler f33672j = new Handler(Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    private static Handler f33673k = null;

    /* renamed from: l, reason: collision with root package name */
    private static final Runnable f33674l = new b();

    /* renamed from: m, reason: collision with root package name */
    private static final Runnable f33675m = new c();

    /* renamed from: b, reason: collision with root package name */
    private int f33677b;

    /* renamed from: h, reason: collision with root package name */
    private long f33683h;

    /* renamed from: a, reason: collision with root package name */
    private List f33676a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f33678c = false;

    /* renamed from: d, reason: collision with root package name */
    private final List f33679d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.hisavana.walking.a f33681f = new com.iab.omid.library.hisavana.walking.a();

    /* renamed from: e, reason: collision with root package name */
    private he.b f33680e = new he.b();

    /* renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.hisavana.walking.b f33682g = new com.iab.omid.library.hisavana.walking.b(new je.c());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f33682g.c();
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
            if (TreeWalker.f33673k != null) {
                TreeWalker.f33673k.post(TreeWalker.f33674l);
                TreeWalker.f33673k.postDelayed(TreeWalker.f33675m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void d(long j11) {
        if (this.f33676a.size() > 0) {
            Iterator it = this.f33676a.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                TimeUnit.NANOSECONDS.toMillis(j11);
                throw null;
            }
        }
    }

    private void e(View view, he.a aVar, JSONObject jSONObject, com.iab.omid.library.hisavana.walking.c cVar, boolean z10) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.hisavana.walking.c.PARENT_VIEW, z10);
    }

    private void f(String str, View view, JSONObject jSONObject) {
        he.a b11 = this.f33680e.b();
        String h11 = this.f33681f.h(str);
        if (h11 != null) {
            JSONObject a11 = b11.a(view);
            ie.c.h(a11, str);
            ie.c.o(a11, h11);
            ie.c.j(jSONObject, a11);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        a.C0461a g11 = this.f33681f.g(view);
        if (g11 == null) {
            return false;
        }
        ie.c.f(jSONObject, g11);
        return true;
    }

    private boolean j(View view, JSONObject jSONObject) {
        String j11 = this.f33681f.j(view);
        if (j11 == null) {
            return false;
        }
        ie.c.h(jSONObject, j11);
        ie.c.g(jSONObject, Boolean.valueOf(this.f33681f.p(view)));
        ie.c.n(jSONObject, Boolean.valueOf(this.f33681f.l(j11)));
        this.f33681f.n();
        return true;
    }

    private void l() {
        d(f.b() - this.f33683h);
    }

    private void m() {
        this.f33677b = 0;
        this.f33679d.clear();
        this.f33678c = false;
        Iterator it = com.iab.omid.library.hisavana.internal.c.e().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((h) it.next()).o()) {
                this.f33678c = true;
                break;
            }
        }
        this.f33683h = f.b();
    }

    public static TreeWalker p() {
        return f33671i;
    }

    private void r() {
        if (f33673k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f33673k = handler;
            handler.post(f33674l);
            f33673k.postDelayed(f33675m, 200L);
        }
    }

    private void t() {
        Handler handler = f33673k;
        if (handler != null) {
            handler.removeCallbacks(f33675m);
            f33673k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        m();
        n();
        l();
        j.f().a();
    }

    @Override // he.a.InterfaceC0805a
    public void a(View view, he.a aVar, JSONObject jSONObject, boolean z10) {
        com.iab.omid.library.hisavana.walking.c m11;
        if (i.f(view) && (m11 = this.f33681f.m(view)) != com.iab.omid.library.hisavana.walking.c.UNDERLYING_VIEW) {
            JSONObject a11 = aVar.a(view);
            ie.c.j(jSONObject, a11);
            if (!j(view, a11)) {
                boolean z11 = z10 || g(view, a11);
                if (this.f33678c && m11 == com.iab.omid.library.hisavana.walking.c.OBSTRUCTION_VIEW && !z11) {
                    this.f33679d.add(new ke.a(view));
                }
                e(view, aVar, a11, m11, z11);
            }
            this.f33677b++;
        }
    }

    void n() {
        this.f33681f.o();
        long b11 = f.b();
        he.a a11 = this.f33680e.a();
        if (this.f33681f.i().size() > 0) {
            Iterator it = this.f33681f.i().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject a12 = a11.a(null);
                f(str, this.f33681f.a(str), a12);
                ie.c.m(a12);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.f33682g.b(a12, hashSet, b11);
            }
        }
        if (this.f33681f.k().size() > 0) {
            JSONObject a13 = a11.a(null);
            e(null, a11, a13, com.iab.omid.library.hisavana.walking.c.PARENT_VIEW, false);
            ie.c.m(a13);
            this.f33682g.d(a13, this.f33681f.k(), b11);
            if (this.f33678c) {
                Iterator it2 = com.iab.omid.library.hisavana.internal.c.e().a().iterator();
                while (it2.hasNext()) {
                    ((h) it2.next()).h(this.f33679d);
                }
            }
        } else {
            this.f33682g.c();
        }
        this.f33681f.d();
    }

    public void o() {
        t();
    }

    public void q() {
        r();
    }

    public void s() {
        o();
        this.f33676a.clear();
        f33672j.post(new a());
    }
}
