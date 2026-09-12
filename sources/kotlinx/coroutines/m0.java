package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class m0 extends AbstractCoroutineContextElement {

    /* renamed from: b, reason: collision with root package name */
    public static final a f68022b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f68023a;

    /* loaded from: classes7.dex */
    public static final class a implements CoroutineContext.Key {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m0(String str) {
        super(f68022b);
        this.f68023a = str;
    }

    public final String d() {
        return this.f68023a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m0) && Intrinsics.c(this.f68023a, ((m0) obj).f68023a);
    }

    public int hashCode() {
        return this.f68023a.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.f68023a + ')';
    }
}
