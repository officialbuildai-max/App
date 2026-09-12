package androidx.compose.ui.graphics.layer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4587a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f4588b = d(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f4589c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f4590d = d(2);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return b.f4588b;
        }

        public final int b() {
            return b.f4590d;
        }

        public final int c() {
            return b.f4589c;
        }
    }

    public static int d(int i11) {
        return i11;
    }

    public static final boolean e(int i11, int i12) {
        return i11 == i12;
    }
}
