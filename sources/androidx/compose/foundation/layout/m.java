package androidx.compose.foundation.layout;

import androidx.compose.ui.b;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2936a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final m f2937b = a.f2940e;

    /* renamed from: c, reason: collision with root package name */
    private static final m f2938c = e.f2943e;

    /* renamed from: d, reason: collision with root package name */
    private static final m f2939d = c.f2941e;

    /* loaded from: classes.dex */
    private static final class a extends m {

        /* renamed from: e, reason: collision with root package name */
        public static final a f2940e = new a();

        private a() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i11, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i12) {
            return i11 / 2;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m a(b.InterfaceC0044b interfaceC0044b) {
            return new d(interfaceC0044b);
        }
    }

    /* loaded from: classes.dex */
    private static final class c extends m {

        /* renamed from: e, reason: collision with root package name */
        public static final c f2941e = new c();

        private c() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i11, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i12) {
            if (layoutDirection == LayoutDirection.Ltr) {
                return i11;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    private static final class d extends m {

        /* renamed from: e, reason: collision with root package name */
        private final b.InterfaceC0044b f2942e;

        public d(b.InterfaceC0044b interfaceC0044b) {
            super(null);
            this.f2942e = interfaceC0044b;
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i11, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i12) {
            return this.f2942e.a(0, i11, layoutDirection);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.c(this.f2942e, ((d) obj).f2942e);
        }

        public int hashCode() {
            return this.f2942e.hashCode();
        }

        public String toString() {
            return "HorizontalCrossAxisAlignment(horizontal=" + this.f2942e + ')';
        }
    }

    /* loaded from: classes.dex */
    private static final class e extends m {

        /* renamed from: e, reason: collision with root package name */
        public static final e f2943e = new e();

        private e() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i11, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i12) {
            if (layoutDirection == LayoutDirection.Ltr) {
                return 0;
            }
            return i11;
        }
    }

    private m() {
    }

    public /* synthetic */ m(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int a(int i11, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i12);

    public Integer b(androidx.compose.ui.layout.g0 g0Var) {
        return null;
    }

    public boolean c() {
        return false;
    }
}
