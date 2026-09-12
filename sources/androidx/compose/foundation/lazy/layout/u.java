package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class u implements a3 {

    /* renamed from: e, reason: collision with root package name */
    private static final a f3147e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f3148a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3149b;

    /* renamed from: c, reason: collision with root package name */
    private final i1 f3150c;

    /* renamed from: d, reason: collision with root package name */
    private int f3151d;

    /* loaded from: classes.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IntRange b(int i11, int i12, int i13) {
            int i14 = (i11 / i12) * i12;
            return RangesKt.t(Math.max(i14 - i13, 0), i14 + i12 + i13);
        }
    }

    public u(int i11, int i12, int i13) {
        this.f3148a = i12;
        this.f3149b = i13;
        this.f3150c = r2.e(f3147e.b(i11, i12, i13), r2.j());
        this.f3151d = i11;
    }

    private void d(IntRange intRange) {
        this.f3150c.setValue(intRange);
    }

    @Override // androidx.compose.runtime.a3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public IntRange getValue() {
        return (IntRange) this.f3150c.getValue();
    }

    public final void e(int i11) {
        if (i11 != this.f3151d) {
            this.f3151d = i11;
            d(f3147e.b(i11, this.f3148a, this.f3149b));
        }
    }
}
