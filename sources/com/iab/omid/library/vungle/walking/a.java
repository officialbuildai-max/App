package com.iab.omid.library.vungle.walking;

import android.view.View;
import com.iab.omid.library.vungle.internal.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import ue.h;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f33915a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f33916b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f33917c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet f33918d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private final HashSet f33919e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private final HashSet f33920f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap f33921g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final HashSet f33922h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    private final Map f33923i = new WeakHashMap();

    /* renamed from: j, reason: collision with root package name */
    private boolean f33924j;

    /* renamed from: com.iab.omid.library.vungle.walking.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0465a {
        public abstract e a();

        public abstract ArrayList b();
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f33923i.remove(view);
            return Boolean.FALSE;
        }
        if (this.f33923i.containsKey(view)) {
            return (Boolean) this.f33923i.get(view);
        }
        Map map = this.f33923i;
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
        this.f33918d.addAll(hashSet);
        return null;
    }

    private void e(com.iab.omid.library.vungle.adsession.h hVar) {
        Iterator it = hVar.m().iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            f(null, hVar);
        }
    }

    private void f(e eVar, com.iab.omid.library.vungle.adsession.h hVar) {
        throw null;
    }

    public View a(String str) {
        return (View) this.f33917c.get(str);
    }

    public void d() {
        this.f33915a.clear();
        this.f33916b.clear();
        this.f33917c.clear();
        this.f33918d.clear();
        this.f33919e.clear();
        this.f33920f.clear();
        this.f33921g.clear();
        this.f33924j = false;
        this.f33922h.clear();
    }

    public C0465a g(View view) {
        return (C0465a) this.f33916b.get(view);
    }

    public String h(String str) {
        return (String) this.f33921g.get(str);
    }

    public HashSet i() {
        return this.f33920f;
    }

    public String j(View view) {
        if (this.f33915a.size() == 0) {
            return null;
        }
        String str = (String) this.f33915a.get(view);
        if (str != null) {
            this.f33915a.remove(view);
        }
        return str;
    }

    public HashSet k() {
        return this.f33919e;
    }

    public boolean l(String str) {
        return this.f33922h.contains(str);
    }

    public c m(View view) {
        return this.f33918d.contains(view) ? c.PARENT_VIEW : this.f33924j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void n() {
        this.f33924j = true;
    }

    public void o() {
        com.iab.omid.library.vungle.internal.c e11 = com.iab.omid.library.vungle.internal.c.e();
        if (e11 != null) {
            for (com.iab.omid.library.vungle.adsession.h hVar : e11.a()) {
                View l11 = hVar.l();
                if (hVar.o()) {
                    String j11 = hVar.j();
                    if (l11 != null) {
                        boolean e12 = h.e(l11);
                        if (e12) {
                            this.f33922h.add(j11);
                        }
                        String c11 = c(l11, e12);
                        if (c11 == null) {
                            this.f33919e.add(j11);
                            this.f33915a.put(l11, j11);
                            e(hVar);
                        } else if (c11 != "noWindowFocus") {
                            this.f33920f.add(j11);
                            this.f33917c.put(j11, l11);
                            this.f33921g.put(j11, c11);
                        }
                    } else {
                        this.f33920f.add(j11);
                        this.f33921g.put(j11, "noAdView");
                    }
                }
            }
        }
    }

    public boolean p(View view) {
        if (!this.f33923i.containsKey(view)) {
            return true;
        }
        this.f33923i.put(view, Boolean.TRUE);
        return false;
    }
}
