package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6521c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final u f6522d = new u();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6523a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6524b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u() {
        this(e.f6167b.b(), false, null);
    }

    private u(int i11, boolean z10) {
        this.f6523a = z10;
        this.f6524b = i11;
    }

    public /* synthetic */ u(int i11, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, z10);
    }

    public u(boolean z10) {
        this.f6523a = z10;
        this.f6524b = e.f6167b.b();
    }

    public final int a() {
        return this.f6524b;
    }

    public final boolean b() {
        return this.f6523a;
    }

    public final u c(u uVar) {
        return uVar == null ? this : uVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f6523a == uVar.f6523a && e.g(this.f6524b, uVar.f6524b);
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.f6523a) * 31) + e.h(this.f6524b);
    }

    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.f6523a + ", emojiSupportMatch=" + ((Object) e.i(this.f6524b)) + ')';
    }
}
