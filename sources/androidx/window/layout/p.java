package androidx.window.layout;

import android.app.Activity;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class p implements v {

    /* renamed from: a, reason: collision with root package name */
    private final WindowLayoutComponent f15424a;

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantLock f15425b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f15426c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f15427d;

    /* loaded from: classes2.dex */
    private static final class a implements Consumer {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f15428a;

        /* renamed from: b, reason: collision with root package name */
        private final ReentrantLock f15429b;

        /* renamed from: c, reason: collision with root package name */
        private a0 f15430c;

        /* renamed from: d, reason: collision with root package name */
        private final Set f15431d;

        public a(Activity activity) {
            Intrinsics.h(activity, "activity");
            this.f15428a = activity;
            this.f15429b = new ReentrantLock();
            this.f15431d = new LinkedHashSet();
        }

        @Override // java.util.function.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(WindowLayoutInfo value) {
            Intrinsics.h(value, "value");
            ReentrantLock reentrantLock = this.f15429b;
            reentrantLock.lock();
            try {
                this.f15430c = q.f15432a.b(this.f15428a, value);
                Iterator it = this.f15431d.iterator();
                while (it.hasNext()) {
                    ((androidx.core.util.a) it.next()).accept(this.f15430c);
                }
                Unit unit = Unit.f67184a;
                reentrantLock.unlock();
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }

        public final void b(androidx.core.util.a listener) {
            Intrinsics.h(listener, "listener");
            ReentrantLock reentrantLock = this.f15429b;
            reentrantLock.lock();
            try {
                a0 a0Var = this.f15430c;
                if (a0Var != null) {
                    listener.accept(a0Var);
                }
                this.f15431d.add(listener);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean c() {
            return this.f15431d.isEmpty();
        }

        public final void d(androidx.core.util.a listener) {
            Intrinsics.h(listener, "listener");
            ReentrantLock reentrantLock = this.f15429b;
            reentrantLock.lock();
            try {
                this.f15431d.remove(listener);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public p(WindowLayoutComponent component) {
        Intrinsics.h(component, "component");
        this.f15424a = component;
        this.f15425b = new ReentrantLock();
        this.f15426c = new LinkedHashMap();
        this.f15427d = new LinkedHashMap();
    }

    @Override // androidx.window.layout.v
    public void a(Activity activity, Executor executor, androidx.core.util.a callback) {
        Unit unit;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(executor, "executor");
        Intrinsics.h(callback, "callback");
        ReentrantLock reentrantLock = this.f15425b;
        reentrantLock.lock();
        try {
            a aVar = (a) this.f15426c.get(activity);
            if (aVar == null) {
                unit = null;
            } else {
                aVar.b(callback);
                this.f15427d.put(callback, activity);
                unit = Unit.f67184a;
            }
            if (unit == null) {
                a aVar2 = new a(activity);
                this.f15426c.put(activity, aVar2);
                this.f15427d.put(callback, activity);
                aVar2.b(callback);
                this.f15424a.addWindowLayoutInfoListener(activity, o.a(aVar2));
            }
            Unit unit2 = Unit.f67184a;
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // androidx.window.layout.v
    public void b(androidx.core.util.a callback) {
        Intrinsics.h(callback, "callback");
        ReentrantLock reentrantLock = this.f15425b;
        reentrantLock.lock();
        try {
            Activity activity = (Activity) this.f15427d.get(callback);
            if (activity == null) {
                reentrantLock.unlock();
                return;
            }
            a aVar = (a) this.f15426c.get(activity);
            if (aVar == null) {
                reentrantLock.unlock();
                return;
            }
            aVar.d(callback);
            if (aVar.c()) {
                this.f15424a.removeWindowLayoutInfoListener(o.a(aVar));
            }
            Unit unit = Unit.f67184a;
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }
}
