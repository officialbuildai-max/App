package kotlinx.coroutines.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final b f67813b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    private static final c f67814c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final Object f67815a;

    /* loaded from: classes7.dex */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f67816a;

        public a(Throwable th2) {
            this.f67816a = th2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics.c(this.f67816a, ((a) obj).f67816a);
        }

        public int hashCode() {
            Throwable th2 = this.f67816a;
            if (th2 != null) {
                return th2.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.h.c
        public String toString() {
            return "Closed(" + this.f67816a + ')';
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object a(Throwable th2) {
            return h.c(new a(th2));
        }

        public final Object b() {
            return h.c(h.f67814c);
        }

        public final Object c(Object obj) {
            return h.c(obj);
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ h(Object obj) {
        this.f67815a = obj;
    }

    public static final /* synthetic */ h b(Object obj) {
        return new h(obj);
    }

    public static Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof h) && Intrinsics.c(obj, ((h) obj2).k());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f67816a;
        }
        return null;
    }

    public static final Object f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f67815a, obj);
    }

    public int hashCode() {
        return g(this.f67815a);
    }

    public final /* synthetic */ Object k() {
        return this.f67815a;
    }

    public String toString() {
        return j(this.f67815a);
    }
}
