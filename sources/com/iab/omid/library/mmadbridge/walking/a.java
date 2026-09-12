package com.iab.omid.library.mmadbridge.walking;

import android.view.View;
import com.iab.omid.library.mmadbridge.internal.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import oe.h;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f33805a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f33806b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f33807c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet f33808d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private final HashSet f33809e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private final HashSet f33810f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap f33811g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final HashSet f33812h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    private final Map f33813i = new WeakHashMap();

    /* renamed from: j, reason: collision with root package name */
    private boolean f33814j;

    /* renamed from: com.iab.omid.library.mmadbridge.walking.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0463a {

        /* renamed from: a, reason: collision with root package name */
        private final e f33815a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList f33816b = new ArrayList();

        public C0463a(e eVar, String str) {
            this.f33815a = eVar;
            b(str);
        }

        public e a() {
            return this.f33815a;
        }

        public void b(String str) {
            this.f33816b.add(str);
        }

        public ArrayList c() {
            return this.f33816b;
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f33813i.remove(view);
            return Boolean.FALSE;
        }
        if (this.f33813i.containsKey(view)) {
            return (Boolean) this.f33813i.get(view);
        }
        Map map = this.f33813i;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    private String c(View view, boolean z10) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue() && !z10) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String a11 = h.a(view);
            if (a11 != null) {
                return a11;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f33808d.addAll(hashSet);
        return null;
    }

    private void e(com.iab.omid.library.mmadbridge.adsession.h hVar) {
        Iterator it = hVar.o().iterator();
        while (it.hasNext()) {
            f((e) it.next(), hVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f(e eVar, com.iab.omid.library.mmadbridge.adsession.h hVar) {
        View view = (View) eVar.c().get();
        if (view == null) {
            return;
        }
        C0463a c0463a = (C0463a) this.f33806b.get(view);
        if (c0463a != null) {
            c0463a.b(hVar.s());
        } else {
            this.f33806b.put(view, new C0463a(eVar, hVar.s()));
        }
    }

    public View a(String str) {
        return (View) this.f33807c.get(str);
    }

    public void d() {
        this.f33805a.clear();
        this.f33806b.clear();
        this.f33807c.clear();
        this.f33808d.clear();
        this.f33809e.clear();
        this.f33810f.clear();
        this.f33811g.clear();
        this.f33814j = false;
        this.f33812h.clear();
    }

    public C0463a g(View view) {
        C0463a c0463a = (C0463a) this.f33806b.get(view);
        if (c0463a != null) {
            this.f33806b.remove(view);
        }
        return c0463a;
    }

    public String h(String str) {
        return (String) this.f33811g.get(str);
    }

    public HashSet i() {
        return this.f33810f;
    }

    public String j(View view) {
        if (this.f33805a.size() == 0) {
            return null;
        }
        String str = (String) this.f33805a.get(view);
        if (str != null) {
            this.f33805a.remove(view);
        }
        return str;
    }

    public HashSet k() {
        return this.f33809e;
    }

    public boolean l(String str) {
        return this.f33812h.contains(str);
    }

    public c m(View view) {
        return this.f33808d.contains(view) ? c.PARENT_VIEW : this.f33814j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void n() {
        this.f33814j = true;
    }

    public void o() {
        com.iab.omid.library.mmadbridge.internal.c e11 = com.iab.omid.library.mmadbridge.internal.c.e();
        if (e11 != null) {
            for (com.iab.omid.library.mmadbridge.adsession.h hVar : e11.a()) {
                View n11 = hVar.n();
                if (hVar.q()) {
                    String s11 = hVar.s();
                    if (n11 != null) {
                        boolean e12 = h.e(n11);
                        if (e12) {
                            this.f33812h.add(s11);
                        }
                        String c11 = c(n11, e12);
                        if (c11 == null) {
                            this.f33809e.add(s11);
                            this.f33805a.put(n11, s11);
                            e(hVar);
                        } else if (c11 != "noWindowFocus") {
                            this.f33810f.add(s11);
                            this.f33807c.put(s11, n11);
                            this.f33811g.put(s11, c11);
                        }
                    } else {
                        this.f33810f.add(s11);
                        this.f33811g.put(s11, "noAdView");
                    }
                }
            }
        }
    }

    public boolean p(View view) {
        if (!this.f33813i.containsKey(view)) {
            return true;
        }
        this.f33813i.put(view, Boolean.TRUE);
        return false;
    }
}
