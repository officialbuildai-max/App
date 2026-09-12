package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class f {

    /* loaded from: classes.dex */
    public static final class a extends f {

        /* renamed from: a, reason: collision with root package name */
        private final String f6173a;

        /* renamed from: b, reason: collision with root package name */
        private final a0 f6174b;

        public a(String str, a0 a0Var, g gVar) {
            super(null);
            this.f6173a = str;
            this.f6174b = a0Var;
        }

        @Override // androidx.compose.ui.text.f
        public g a() {
            return null;
        }

        public a0 b() {
            return this.f6174b;
        }

        public final String c() {
            return this.f6173a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Intrinsics.c(this.f6173a, aVar.f6173a) || !Intrinsics.c(b(), aVar.b())) {
                return false;
            }
            a();
            aVar.a();
            return Intrinsics.c(null, null);
        }

        public int hashCode() {
            int hashCode = this.f6173a.hashCode() * 31;
            a0 b11 = b();
            int hashCode2 = (hashCode + (b11 != null ? b11.hashCode() : 0)) * 31;
            a();
            return hashCode2;
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.f6173a + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends f {

        /* renamed from: a, reason: collision with root package name */
        private final String f6175a;

        /* renamed from: b, reason: collision with root package name */
        private final a0 f6176b;

        public b(String str, a0 a0Var, g gVar) {
            super(null);
            this.f6175a = str;
            this.f6176b = a0Var;
        }

        public /* synthetic */ b(String str, a0 a0Var, g gVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i11 & 2) != 0 ? null : a0Var, (i11 & 4) != 0 ? null : gVar);
        }

        @Override // androidx.compose.ui.text.f
        public g a() {
            return null;
        }

        public a0 b() {
            return this.f6176b;
        }

        public final String c() {
            return this.f6175a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!Intrinsics.c(this.f6175a, bVar.f6175a) || !Intrinsics.c(b(), bVar.b())) {
                return false;
            }
            a();
            bVar.a();
            return Intrinsics.c(null, null);
        }

        public int hashCode() {
            int hashCode = this.f6175a.hashCode() * 31;
            a0 b11 = b();
            int hashCode2 = (hashCode + (b11 != null ? b11.hashCode() : 0)) * 31;
            a();
            return hashCode2;
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.f6175a + ')';
        }
    }

    private f() {
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract g a();
}
