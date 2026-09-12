package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class k4 {

    /* loaded from: classes.dex */
    public static final class a extends k4 {

        /* renamed from: a, reason: collision with root package name */
        private final Path f4539a;

        public a(Path path) {
            super(null);
            this.f4539a = path;
        }

        @Override // androidx.compose.ui.graphics.k4
        public y.i a() {
            return this.f4539a.getBounds();
        }

        public final Path b() {
            return this.f4539a;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends k4 {

        /* renamed from: a, reason: collision with root package name */
        private final y.i f4540a;

        public b(y.i iVar) {
            super(null);
            this.f4540a = iVar;
        }

        @Override // androidx.compose.ui.graphics.k4
        public y.i a() {
            return this.f4540a;
        }

        public final y.i b() {
            return this.f4540a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.c(this.f4540a, ((b) obj).f4540a);
        }

        public int hashCode() {
            return this.f4540a.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends k4 {

        /* renamed from: a, reason: collision with root package name */
        private final y.k f4541a;

        /* renamed from: b, reason: collision with root package name */
        private final Path f4542b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(y.k kVar) {
            super(0 == true ? 1 : 0);
            Path path = null;
            this.f4541a = kVar;
            if (!y.l.e(kVar)) {
                Path a11 = x0.a();
                o4.b(a11, kVar, null, 2, null);
                path = a11;
            }
            this.f4542b = path;
        }

        @Override // androidx.compose.ui.graphics.k4
        public y.i a() {
            return y.l.d(this.f4541a);
        }

        public final y.k b() {
            return this.f4541a;
        }

        public final Path c() {
            return this.f4542b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.c(this.f4541a, ((c) obj).f4541a);
        }

        public int hashCode() {
            return this.f4541a.hashCode();
        }
    }

    private k4() {
    }

    public /* synthetic */ k4(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract y.i a();
}
