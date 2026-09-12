package androidx.activity.contextaware;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Set f949a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f950b;

    public final void a(d listener) {
        Intrinsics.h(listener, "listener");
        Context context = this.f950b;
        if (context != null) {
            listener.a(context);
        }
        this.f949a.add(listener);
    }

    public final void b() {
        this.f950b = null;
    }

    public final void c(Context context) {
        Intrinsics.h(context, "context");
        this.f950b = context;
        Iterator it = this.f949a.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(context);
        }
    }

    public final Context d() {
        return this.f950b;
    }

    public final void e(d listener) {
        Intrinsics.h(listener, "listener");
        this.f949a.remove(listener);
    }
}
