package androidx.compose.ui.input.pointer;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.collection.x f5144a = new androidx.collection.x(0, 1, null);

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f5145a;

        /* renamed from: b, reason: collision with root package name */
        private final long f5146b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f5147c;

        /* renamed from: d, reason: collision with root package name */
        private final int f5148d;

        private a(long j11, long j12, boolean z10, int i11) {
            this.f5145a = j11;
            this.f5146b = j12;
            this.f5147c = z10;
            this.f5148d = i11;
        }

        public /* synthetic */ a(long j11, long j12, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(j11, j12, z10, i11);
        }

        public final boolean a() {
            return this.f5147c;
        }

        public final long b() {
            return this.f5146b;
        }

        public final long c() {
            return this.f5145a;
        }
    }

    public final void a() {
        this.f5144a.b();
    }

    public final g b(y yVar, i0 i0Var) {
        long j11;
        boolean a11;
        long mo117screenToLocalMKHz9U;
        androidx.collection.x xVar = new androidx.collection.x(yVar.b().size());
        List b11 = yVar.b();
        int size = b11.size();
        for (int i11 = 0; i11 < size; i11++) {
            z zVar = (z) b11.get(i11);
            a aVar = (a) this.f5144a.e(zVar.d());
            if (aVar == null) {
                j11 = zVar.k();
                mo117screenToLocalMKHz9U = zVar.f();
                a11 = false;
            } else {
                long c11 = aVar.c();
                j11 = c11;
                a11 = aVar.a();
                mo117screenToLocalMKHz9U = i0Var.mo117screenToLocalMKHz9U(aVar.b());
            }
            xVar.k(zVar.d(), new w(zVar.d(), zVar.k(), zVar.f(), zVar.b(), zVar.h(), j11, mo117screenToLocalMKHz9U, a11, false, zVar.j(), zVar.c(), zVar.i(), zVar.e(), null));
            if (zVar.b()) {
                this.f5144a.k(zVar.d(), new a(zVar.k(), zVar.g(), zVar.b(), zVar.j(), null));
            } else {
                this.f5144a.l(zVar.d());
            }
        }
        return new g(xVar, yVar);
    }
}
