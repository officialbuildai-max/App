package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.e;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.d;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class f implements androidx.compose.ui.modifier.j, androidx.compose.ui.layout.d {

    /* renamed from: g, reason: collision with root package name */
    public static final b f3116g = new b(null);

    /* renamed from: h, reason: collision with root package name */
    private static final a f3117h = new a();

    /* renamed from: b, reason: collision with root package name */
    private final h f3118b;

    /* renamed from: c, reason: collision with root package name */
    private final e f3119c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f3120d;

    /* renamed from: e, reason: collision with root package name */
    private final LayoutDirection f3121e;

    /* renamed from: f, reason: collision with root package name */
    private final Orientation f3122f;

    /* loaded from: classes.dex */
    public static final class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f3123a;

        a() {
        }

        @Override // androidx.compose.ui.layout.d.a
        public boolean a() {
            return this.f3123a;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3124a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f3124a = iArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements d.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f3126b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3127c;

        d(Ref.ObjectRef objectRef, int i11) {
            this.f3126b = objectRef;
            this.f3127c = i11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.compose.ui.layout.d.a
        public boolean a() {
            return f.this.l((e.a) this.f3126b.element, this.f3127c);
        }
    }

    public f(h hVar, e eVar, boolean z10, LayoutDirection layoutDirection, Orientation orientation) {
        this.f3118b = hVar;
        this.f3119c = eVar;
        this.f3120d = z10;
        this.f3121e = layoutDirection;
        this.f3122f = orientation;
    }

    private final e.a j(e.a aVar, int i11) {
        int b11 = aVar.b();
        int a11 = aVar.a();
        if (m(i11)) {
            a11++;
        } else {
            b11--;
        }
        return this.f3119c.a(b11, a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(e.a aVar, int i11) {
        if (o(i11)) {
            return false;
        }
        if (m(i11)) {
            if (aVar.a() >= this.f3118b.getItemCount() - 1) {
                return false;
            }
        } else if (aVar.b() <= 0) {
            return false;
        }
        return true;
    }

    private final boolean m(int i11) {
        d.b.a aVar = d.b.f5243a;
        if (d.b.h(i11, aVar.c())) {
            return false;
        }
        if (!d.b.h(i11, aVar.b())) {
            if (d.b.h(i11, aVar.a())) {
                return this.f3120d;
            }
            if (d.b.h(i11, aVar.d())) {
                if (this.f3120d) {
                    return false;
                }
            } else if (d.b.h(i11, aVar.e())) {
                int i12 = c.f3124a[this.f3121e.ordinal()];
                if (i12 == 1) {
                    return this.f3120d;
                }
                if (i12 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.f3120d) {
                    return false;
                }
            } else {
                if (!d.b.h(i11, aVar.f())) {
                    g.c();
                    throw new KotlinNothingValueException();
                }
                int i13 = c.f3124a[this.f3121e.ordinal()];
                if (i13 != 1) {
                    if (i13 == 2) {
                        return this.f3120d;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (this.f3120d) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean o(int i11) {
        d.b.a aVar = d.b.f5243a;
        if (!(d.b.h(i11, aVar.a()) ? true : d.b.h(i11, aVar.d()))) {
            if (!(d.b.h(i11, aVar.e()) ? true : d.b.h(i11, aVar.f()))) {
                if (!(d.b.h(i11, aVar.c()) ? true : d.b.h(i11, aVar.b()))) {
                    g.c();
                    throw new KotlinNothingValueException();
                }
            } else if (this.f3122f == Orientation.Vertical) {
                return true;
            }
        } else if (this.f3122f == Orientation.Horizontal) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [T, androidx.compose.foundation.lazy.layout.e$a] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, androidx.compose.foundation.lazy.layout.e$a] */
    @Override // androidx.compose.ui.layout.d
    public Object a(int i11, Function1 function1) {
        if (this.f3118b.getItemCount() <= 0 || !this.f3118b.b()) {
            return function1.invoke(f3117h);
        }
        int d11 = m(i11) ? this.f3118b.d() : this.f3118b.c();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.f3119c.a(d11, d11);
        Object obj = null;
        while (obj == null && l((e.a) objectRef.element, i11)) {
            ?? j11 = j((e.a) objectRef.element, i11);
            this.f3119c.e((e.a) objectRef.element);
            objectRef.element = j11;
            this.f3118b.a();
            obj = function1.invoke(new d(objectRef, i11));
        }
        this.f3119c.e((e.a) objectRef.element);
        this.f3118b.a();
        return obj;
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ Object b(Object obj, Function2 function2) {
        return androidx.compose.ui.g.b(this, obj, function2);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ boolean c(Function1 function1) {
        return androidx.compose.ui.g.a(this, function1);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ androidx.compose.ui.f e(androidx.compose.ui.f fVar) {
        return androidx.compose.ui.e.a(this, fVar);
    }

    @Override // androidx.compose.ui.modifier.j
    public androidx.compose.ui.modifier.l getKey() {
        return BeyondBoundsLayoutKt.a();
    }

    @Override // androidx.compose.ui.modifier.j
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public androidx.compose.ui.layout.d getValue() {
        return this;
    }
}
