package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.view.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    private final h f9558a;

    /* renamed from: b, reason: collision with root package name */
    private final ClassLoader f9559b;

    /* renamed from: c, reason: collision with root package name */
    ArrayList f9560c;

    /* renamed from: d, reason: collision with root package name */
    int f9561d;

    /* renamed from: e, reason: collision with root package name */
    int f9562e;

    /* renamed from: f, reason: collision with root package name */
    int f9563f;

    /* renamed from: g, reason: collision with root package name */
    int f9564g;

    /* renamed from: h, reason: collision with root package name */
    int f9565h;

    /* renamed from: i, reason: collision with root package name */
    boolean f9566i;

    /* renamed from: j, reason: collision with root package name */
    boolean f9567j;

    /* renamed from: k, reason: collision with root package name */
    String f9568k;

    /* renamed from: l, reason: collision with root package name */
    int f9569l;

    /* renamed from: m, reason: collision with root package name */
    CharSequence f9570m;

    /* renamed from: n, reason: collision with root package name */
    int f9571n;

    /* renamed from: o, reason: collision with root package name */
    CharSequence f9572o;

    /* renamed from: p, reason: collision with root package name */
    ArrayList f9573p;

    /* renamed from: q, reason: collision with root package name */
    ArrayList f9574q;

    /* renamed from: r, reason: collision with root package name */
    boolean f9575r;

    /* renamed from: s, reason: collision with root package name */
    ArrayList f9576s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f9577a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f9578b;

        /* renamed from: c, reason: collision with root package name */
        boolean f9579c;

        /* renamed from: d, reason: collision with root package name */
        int f9580d;

        /* renamed from: e, reason: collision with root package name */
        int f9581e;

        /* renamed from: f, reason: collision with root package name */
        int f9582f;

        /* renamed from: g, reason: collision with root package name */
        int f9583g;

        /* renamed from: h, reason: collision with root package name */
        Lifecycle.State f9584h;

        /* renamed from: i, reason: collision with root package name */
        Lifecycle.State f9585i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i11, Fragment fragment) {
            this.f9577a = i11;
            this.f9578b = fragment;
            this.f9579c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f9584h = state;
            this.f9585i = state;
        }

        a(int i11, Fragment fragment, Lifecycle.State state) {
            this.f9577a = i11;
            this.f9578b = fragment;
            this.f9579c = false;
            this.f9584h = fragment.mMaxState;
            this.f9585i = state;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i11, Fragment fragment, boolean z10) {
            this.f9577a = i11;
            this.f9578b = fragment;
            this.f9579c = z10;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f9584h = state;
            this.f9585i = state;
        }

        a(a aVar) {
            this.f9577a = aVar.f9577a;
            this.f9578b = aVar.f9578b;
            this.f9579c = aVar.f9579c;
            this.f9580d = aVar.f9580d;
            this.f9581e = aVar.f9581e;
            this.f9582f = aVar.f9582f;
            this.f9583g = aVar.f9583g;
            this.f9584h = aVar.f9584h;
            this.f9585i = aVar.f9585i;
        }
    }

    @Deprecated
    public w() {
        this.f9560c = new ArrayList();
        this.f9567j = true;
        this.f9575r = false;
        this.f9558a = null;
        this.f9559b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(h hVar, ClassLoader classLoader) {
        this.f9560c = new ArrayList();
        this.f9567j = true;
        this.f9575r = false;
        this.f9558a = hVar;
        this.f9559b = classLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(h hVar, ClassLoader classLoader, w wVar) {
        this(hVar, classLoader);
        Iterator it = wVar.f9560c.iterator();
        while (it.hasNext()) {
            this.f9560c.add(new a((a) it.next()));
        }
        this.f9561d = wVar.f9561d;
        this.f9562e = wVar.f9562e;
        this.f9563f = wVar.f9563f;
        this.f9564g = wVar.f9564g;
        this.f9565h = wVar.f9565h;
        this.f9566i = wVar.f9566i;
        this.f9567j = wVar.f9567j;
        this.f9568k = wVar.f9568k;
        this.f9571n = wVar.f9571n;
        this.f9572o = wVar.f9572o;
        this.f9569l = wVar.f9569l;
        this.f9570m = wVar.f9570m;
        if (wVar.f9573p != null) {
            ArrayList arrayList = new ArrayList();
            this.f9573p = arrayList;
            arrayList.addAll(wVar.f9573p);
        }
        if (wVar.f9574q != null) {
            ArrayList arrayList2 = new ArrayList();
            this.f9574q = arrayList2;
            arrayList2.addAll(wVar.f9574q);
        }
        this.f9575r = wVar.f9575r;
    }

    public w b(int i11, Fragment fragment) {
        o(i11, fragment, null, 1);
        return this;
    }

    public w c(int i11, Fragment fragment, String str) {
        o(i11, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public w e(Fragment fragment, String str) {
        o(0, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a aVar) {
        this.f9560c.add(aVar);
        aVar.f9580d = this.f9561d;
        aVar.f9581e = this.f9562e;
        aVar.f9582f = this.f9563f;
        aVar.f9583g = this.f9564g;
    }

    public w g(String str) {
        if (!this.f9567j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f9566i = true;
        this.f9568k = str;
        return this;
    }

    public w h(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int i();

    public abstract int j();

    public abstract void k();

    public abstract void l();

    public w m(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public w n() {
        if (this.f9566i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f9567j = false;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i11, Fragment fragment, String str, int i12) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i11 != 0) {
            if (i11 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i13 = fragment.mFragmentId;
            if (i13 != 0 && i13 != i11) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i11);
            }
            fragment.mFragmentId = i11;
            fragment.mContainerId = i11;
        }
        f(new a(i12, fragment));
    }

    public w p(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public boolean q() {
        return this.f9560c.isEmpty();
    }

    public w r(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public w s(int i11, Fragment fragment) {
        return t(i11, fragment, null);
    }

    public w t(int i11, Fragment fragment, String str) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        o(i11, fragment, str, 2);
        return this;
    }

    public w u(int i11, int i12, int i13, int i14) {
        this.f9561d = i11;
        this.f9562e = i12;
        this.f9563f = i13;
        this.f9564g = i14;
        return this;
    }

    public w v(Fragment fragment, Lifecycle.State state) {
        f(new a(10, fragment, state));
        return this;
    }

    public w w(Fragment fragment) {
        f(new a(8, fragment));
        return this;
    }

    public w x(boolean z10) {
        this.f9575r = z10;
        return this;
    }

    public w y(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
