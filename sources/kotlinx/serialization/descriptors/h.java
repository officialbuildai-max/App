package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes7.dex */
public abstract class h {

    /* loaded from: classes7.dex */
    public static final class a extends h {

        /* renamed from: a, reason: collision with root package name */
        public static final a f68191a = new a();

        private a() {
            super(null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends h {

        /* renamed from: a, reason: collision with root package name */
        public static final b f68192a = new b();

        private b() {
            super(null);
        }
    }

    private h() {
    }

    public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String g11 = Reflection.b(getClass()).g();
        Intrinsics.e(g11);
        return g11;
    }
}
