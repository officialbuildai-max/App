package com.iab.omid.library.hisavana.walking;

import android.view.View;
import com.iab.omid.library.hisavana.adsession.h;
import com.iab.omid.library.hisavana.internal.e;
import ie.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f33685a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f33686b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f33687c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet f33688d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private final HashSet f33689e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private final HashSet f33690f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap f33691g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final HashSet f33692h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    private final Map f33693i = new WeakHashMap();

    /* renamed from: j, reason: collision with root package name */
    private boolean f33694j;

    /* renamed from: com.iab.omid.library.hisavana.walking.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0461a {

        /* renamed from: a, reason: collision with root package name */
        private final e f33695a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList f33696b = new ArrayList();

        public C0461a(e eVar, String str) {
            this.f33695a = eVar;
            b(str);
        }

        public e a() {
            return this.f33695a;
        }

        public void b(String str) {
            this.f33696b.add(str);
        }

        public ArrayList c() {
            return this.f33696b;
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f33693i.remove(view);
            return Boolean.FALSE;
        }
        if (this.f33693i.containsKey(view)) {
            return (Boolean) this.f33693i.get(view);
        }
        Map map = this.f33693i;
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
            String a11 = i.a(view);
            if (a11 != null) {
                return a11;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f33688d.addAll(hashSet);
        return null;
    }

    private void e(h hVar) {
        Iterator it = hVar.n().iterator();
        while (it.hasNext()) {
            f((e) it.next(), hVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f(e eVar, h hVar) {
        View view = (View) eVar.c().get();
        if (view == null) {
            return;
        }
        C0461a c0461a = (C0461a) this.f33686b.get(view);
        if (c0461a != null) {
            c0461a.b(hVar.k());
        } else {
            this.f33686b.put(view, new C0461a(eVar, hVar.k()));
        }
    }

    public View a(String str) {
        return (View) this.f33687c.get(str);
    }

    public void d() {
        this.f33685a.clear();
        this.f33686b.clear();
        this.f33687c.clear();
        this.f33688d.clear();
        this.f33689e.clear();
        this.f33690f.clear();
        this.f33691g.clear();
        this.f33694j = false;
        this.f33692h.clear();
    }

    public C0461a g(View view) {
        C0461a c0461a = (C0461a) this.f33686b.get(view);
        if (c0461a != null) {
            this.f33686b.remove(view);
        }
        return c0461a;
    }

    public String h(String str) {
        return (String) this.f33691g.get(str);
    }

    public HashSet i() {
        return this.f33690f;
    }

    public String j(View view) {
        if (this.f33685a.size() == 0) {
            return null;
        }
        String str = (String) this.f33685a.get(view);
        if (str != null) {
            this.f33685a.remove(view);
        }
        return str;
    }

    public HashSet k() {
        return this.f33689e;
    }

    public boolean l(String str) {
        return this.f33692h.contains(str);
    }

    public c m(View view) {
        return this.f33688d.contains(view) ? c.PARENT_VIEW : this.f33694j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void n() {
        this.f33694j = true;
    }

    public void o() {
        com.iab.omid.library.hisavana.internal.c e11 = com.iab.omid.library.hisavana.internal.c.e();
        if (e11 != null) {
            for (h hVar : e11.a()) {
                View m11 = hVar.m();
                if (hVar.p()) {
                    String k11 = hVar.k();
                    if (m11 != null) {
                        boolean e12 = i.e(m11);
                        if (e12) {
                            this.f33692h.add(k11);
                        }
                        String c11 = c(m11, e12);
                        if (c11 == null) {
                            this.f33689e.add(k11);
                            this.f33685a.put(m11, k11);
                            e(hVar);
                        } else if (c11 != "noWindowFocus") {
                            this.f33690f.add(k11);
                            this.f33687c.put(k11, m11);
                            this.f33691g.put(k11, c11);
                        }
                    } else {
                        this.f33690f.add(k11);
                        this.f33691g.put(k11, "noAdView");
                    }
                }
            }
        }
    }

    public boolean p(View view) {
        if (!this.f33693i.containsKey(view)) {
            return true;
        }
        this.f33693i.put(view, Boolean.TRUE);
        return false;
    }
}
