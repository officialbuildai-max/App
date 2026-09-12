package androidx.work.impl.constraints;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public abstract class b {

    /* loaded from: classes2.dex */
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15674a = new a();

        private a() {
            super(null);
        }
    }

    /* renamed from: androidx.work.impl.constraints.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0142b extends b {

        /* renamed from: a, reason: collision with root package name */
        private final int f15675a;

        public C0142b(int i11) {
            super(null);
            this.f15675a = i11;
        }

        public final int a() {
            return this.f15675a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0142b) && this.f15675a == ((C0142b) obj).f15675a;
        }

        public int hashCode() {
            return this.f15675a;
        }

        public String toString() {
            return "ConstraintsNotMet(reason=" + this.f15675a + ')';
        }
    }

    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
