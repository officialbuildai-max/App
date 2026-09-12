package com.iab.omid.library.bytedance2.walking;

import android.view.View;
import com.iab.omid.library.bytedance2.internal.e;
import com.iab.omid.library.bytedance2.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f33563a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0458a> f33564b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f33565c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<View> f33566d = new HashSet<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashSet<String> f33567e = new HashSet<>();

    /* renamed from: f, reason: collision with root package name */
    private final HashSet<String> f33568f = new HashSet<>();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f33569g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final Map<View, Boolean> f33570h = new WeakHashMap();

    /* renamed from: i, reason: collision with root package name */
    private boolean f33571i;

    /* renamed from: com.iab.omid.library.bytedance2.walking.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0458a {

        /* renamed from: a, reason: collision with root package name */
        private final e f33572a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f33573b = new ArrayList<>();

        public C0458a(e eVar, String str) {
            this.f33572a = eVar;
            a(str);
        }

        public e a() {
            return this.f33572a;
        }

        public void a(String str) {
            this.f33573b.add(str);
        }

        public ArrayList<String> b() {
            return this.f33573b;
        }
    }

    private String a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue()) {
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
        this.f33566d.addAll(hashSet);
        return null;
    }

    private void a(com.iab.omid.library.bytedance2.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.bytedance2.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0458a c0458a = this.f33564b.get(view);
        if (c0458a != null) {
            c0458a.a(aVar.getAdSessionId());
        } else {
            this.f33564b.put(view, new C0458a(eVar, aVar.getAdSessionId()));
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f33570h.remove(view);
            return Boolean.FALSE;
        }
        if (this.f33570h.containsKey(view)) {
            return this.f33570h.get(view);
        }
        Map<View, Boolean> map = this.f33570h;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public View a(String str) {
        return this.f33565c.get(str);
    }

    public void a() {
        this.f33563a.clear();
        this.f33564b.clear();
        this.f33565c.clear();
        this.f33566d.clear();
        this.f33567e.clear();
        this.f33568f.clear();
        this.f33569g.clear();
        this.f33571i = false;
    }

    public String b(String str) {
        return this.f33569g.get(str);
    }

    public HashSet<String> b() {
        return this.f33568f;
    }

    public C0458a c(View view) {
        C0458a c0458a = this.f33564b.get(view);
        if (c0458a != null) {
            this.f33564b.remove(view);
        }
        return c0458a;
    }

    public HashSet<String> c() {
        return this.f33567e;
    }

    public String d(View view) {
        if (this.f33563a.size() == 0) {
            return null;
        }
        String str = this.f33563a.get(view);
        if (str != null) {
            this.f33563a.remove(view);
        }
        return str;
    }

    public void d() {
        this.f33571i = true;
    }

    public c e(View view) {
        return this.f33566d.contains(view) ? c.PARENT_VIEW : this.f33571i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        com.iab.omid.library.bytedance2.internal.c c11 = com.iab.omid.library.bytedance2.internal.c.c();
        if (c11 != null) {
            for (com.iab.omid.library.bytedance2.adsession.a aVar : c11.a()) {
                View c12 = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (c12 != null) {
                        String a11 = a(c12);
                        if (a11 == null) {
                            this.f33567e.add(adSessionId);
                            this.f33563a.put(c12, adSessionId);
                            a(aVar);
                        } else if (a11 != "noWindowFocus") {
                            this.f33568f.add(adSessionId);
                            this.f33565c.put(adSessionId, c12);
                            this.f33569g.put(adSessionId, a11);
                        }
                    } else {
                        this.f33568f.add(adSessionId);
                        this.f33569g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public boolean f(View view) {
        if (!this.f33570h.containsKey(view)) {
            return true;
        }
        this.f33570h.put(view, Boolean.TRUE);
        return false;
    }
}
