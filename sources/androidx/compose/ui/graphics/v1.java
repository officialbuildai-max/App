package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class v1 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4750b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final ColorFilter f4751a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ v1 b(a aVar, long j11, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i11 = c1.f4367a.z();
            }
            return aVar.a(j11, i11);
        }

        public final v1 a(long j11, int i11) {
            return new d1(j11, i11, (DefaultConstructorMarker) null);
        }
    }

    public v1(ColorFilter colorFilter) {
        this.f4751a = colorFilter;
    }

    public final ColorFilter a() {
        return this.f4751a;
    }
}
