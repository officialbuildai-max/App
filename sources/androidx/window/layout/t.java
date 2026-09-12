package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.core.Version;
import androidx.window.layout.n;
import androidx.window.layout.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class t implements v {

    /* renamed from: d, reason: collision with root package name */
    private static volatile t f15446d;

    /* renamed from: a, reason: collision with root package name */
    private n f15448a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f15449b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static final a f15445c = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final ReentrantLock f15447e = new ReentrantLock();

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t a(Context context) {
            Intrinsics.h(context, "context");
            if (t.f15446d == null) {
                ReentrantLock reentrantLock = t.f15447e;
                reentrantLock.lock();
                try {
                    if (t.f15446d == null) {
                        t.f15446d = new t(t.f15445c.b(context));
                    }
                    Unit unit = Unit.f67184a;
                    reentrantLock.unlock();
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            }
            t tVar = t.f15446d;
            Intrinsics.e(tVar);
            return tVar;
        }

        public final n b(Context context) {
            Intrinsics.h(context, "context");
            try {
                if (!c(SidecarCompat.f15393f.c())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (sidecarCompat.l()) {
                    return sidecarCompat;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(Version version) {
            return version != null && version.compareTo(Version.f15360f.a()) >= 0;
        }
    }

    /* loaded from: classes2.dex */
    public final class b implements n.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f15450a;

        public b(t this$0) {
            Intrinsics.h(this$0, "this$0");
            this.f15450a = this$0;
        }

        @Override // androidx.window.layout.n.a
        public void a(Activity activity, a0 newLayout) {
            Intrinsics.h(activity, "activity");
            Intrinsics.h(newLayout, "newLayout");
            Iterator it = this.f15450a.h().iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (Intrinsics.c(cVar.d(), activity)) {
                    cVar.b(newLayout);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f15451a;

        /* renamed from: b, reason: collision with root package name */
        private final Executor f15452b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.core.util.a f15453c;

        /* renamed from: d, reason: collision with root package name */
        private a0 f15454d;

        public c(Activity activity, Executor executor, androidx.core.util.a callback) {
            Intrinsics.h(activity, "activity");
            Intrinsics.h(executor, "executor");
            Intrinsics.h(callback, "callback");
            this.f15451a = activity;
            this.f15452b = executor;
            this.f15453c = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(c this$0, a0 newLayoutInfo) {
            Intrinsics.h(this$0, "this$0");
            Intrinsics.h(newLayoutInfo, "$newLayoutInfo");
            this$0.f15453c.accept(newLayoutInfo);
        }

        public final void b(final a0 newLayoutInfo) {
            Intrinsics.h(newLayoutInfo, "newLayoutInfo");
            this.f15454d = newLayoutInfo;
            this.f15452b.execute(new Runnable() { // from class: androidx.window.layout.u
                @Override // java.lang.Runnable
                public final void run() {
                    t.c.c(t.c.this, newLayoutInfo);
                }
            });
        }

        public final Activity d() {
            return this.f15451a;
        }

        public final androidx.core.util.a e() {
            return this.f15453c;
        }

        public final a0 f() {
            return this.f15454d;
        }
    }

    public t(n nVar) {
        this.f15448a = nVar;
        n nVar2 = this.f15448a;
        if (nVar2 == null) {
            return;
        }
        nVar2.a(new b(this));
    }

    private final void f(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f15449b;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.c(((c) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        n nVar = this.f15448a;
        if (nVar == null) {
            return;
        }
        nVar.c(activity);
    }

    private final boolean i(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f15449b;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.c(((c) it.next()).d(), activity)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.window.layout.v
    public void a(Activity activity, Executor executor, androidx.core.util.a callback) {
        a0 a0Var;
        Object obj;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(executor, "executor");
        Intrinsics.h(callback, "callback");
        ReentrantLock reentrantLock = f15447e;
        reentrantLock.lock();
        try {
            n g11 = g();
            if (g11 == null) {
                callback.accept(new a0(CollectionsKt.l()));
                return;
            }
            boolean i11 = i(activity);
            c cVar = new c(activity, executor, callback);
            h().add(cVar);
            if (i11) {
                Iterator it = h().iterator();
                while (true) {
                    a0Var = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (Intrinsics.c(activity, ((c) obj).d())) {
                            break;
                        }
                    }
                }
                c cVar2 = (c) obj;
                if (cVar2 != null) {
                    a0Var = cVar2.f();
                }
                if (a0Var != null) {
                    cVar.b(a0Var);
                }
            } else {
                g11.b(activity);
            }
            Unit unit = Unit.f67184a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.window.layout.v
    public void b(androidx.core.util.a callback) {
        Intrinsics.h(callback, "callback");
        synchronized (f15447e) {
            try {
                if (g() == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = h().iterator();
                while (it.hasNext()) {
                    c callbackWrapper = (c) it.next();
                    if (callbackWrapper.e() == callback) {
                        Intrinsics.g(callbackWrapper, "callbackWrapper");
                        arrayList.add(callbackWrapper);
                    }
                }
                h().removeAll(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f(((c) it2.next()).d());
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final n g() {
        return this.f15448a;
    }

    public final CopyOnWriteArrayList h() {
        return this.f15449b;
    }
}
