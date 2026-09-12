package i4;

import android.content.Context;
import androidx.work.t;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private final j4.c f65072a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f65073b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f65074c;

    /* renamed from: d, reason: collision with root package name */
    private final LinkedHashSet f65075d;

    /* renamed from: e, reason: collision with root package name */
    private Object f65076e;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j4.c taskExecutor) {
        Intrinsics.h(context, "context");
        Intrinsics.h(taskExecutor, "taskExecutor");
        this.f65072a = taskExecutor;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        this.f65073b = applicationContext;
        this.f65074c = new Object();
        this.f65075d = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List list, g gVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((androidx.work.impl.constraints.a) it.next()).a(gVar.f65076e);
        }
    }

    public final void c(androidx.work.impl.constraints.a listener) {
        String str;
        Intrinsics.h(listener, "listener");
        synchronized (this.f65074c) {
            try {
                if (this.f65075d.add(listener)) {
                    if (this.f65075d.size() == 1) {
                        this.f65076e = f();
                        t e11 = t.e();
                        str = h.f65077a;
                        e11.a(str, getClass().getSimpleName() + ": initial state = " + this.f65076e);
                        i();
                    }
                    listener.a(this.f65076e);
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context d() {
        return this.f65073b;
    }

    public final Object e() {
        Object obj = this.f65076e;
        return obj == null ? f() : obj;
    }

    public abstract Object f();

    public final void g(androidx.work.impl.constraints.a listener) {
        Intrinsics.h(listener, "listener");
        synchronized (this.f65074c) {
            try {
                if (this.f65075d.remove(listener) && this.f65075d.isEmpty()) {
                    j();
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void h(Object obj) {
        synchronized (this.f65074c) {
            Object obj2 = this.f65076e;
            if (obj2 == null || !Intrinsics.c(obj2, obj)) {
                this.f65076e = obj;
                final List R0 = CollectionsKt.R0(this.f65075d);
                this.f65072a.a().execute(new Runnable() { // from class: i4.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.b(R0, this);
                    }
                });
                Unit unit = Unit.f67184a;
            }
        }
    }

    public abstract void i();

    public abstract void j();
}
