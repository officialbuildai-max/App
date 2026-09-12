package o;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final i1 f70717a;

    /* renamed from: o.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0883a {

        /* renamed from: o.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0884a extends AbstractC0883a {

            /* renamed from: a, reason: collision with root package name */
            public static final C0884a f70718a = new C0884a();

            private C0884a() {
                super(null);
            }

            public String toString() {
                return "Closed";
            }
        }

        private AbstractC0883a() {
        }

        public /* synthetic */ AbstractC0883a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(AbstractC0883a abstractC0883a) {
        i1 c11;
        c11 = u2.c(abstractC0883a, null, 2, null);
        this.f70717a = c11;
    }

    public /* synthetic */ a(AbstractC0883a abstractC0883a, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AbstractC0883a.C0884a.f70718a : abstractC0883a);
    }

    public final AbstractC0883a a() {
        return (AbstractC0883a) this.f70717a.getValue();
    }

    public final void b(AbstractC0883a abstractC0883a) {
        this.f70717a.setValue(abstractC0883a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return Intrinsics.c(((a) obj).a(), a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "ContextMenuState(status=" + a() + ')';
    }
}
