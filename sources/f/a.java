package f;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: f.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0777a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f62232a;

        public C0777a(Object obj) {
            this.f62232a = obj;
        }

        public final Object a() {
            return this.f62232a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0777a b(Context context, Object obj) {
        Intrinsics.h(context, "context");
        return null;
    }

    public abstract Object c(int i11, Intent intent);
}
