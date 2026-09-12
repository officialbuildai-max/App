package f3;

import com.google.common.primitives.ImmutableIntArray;
import l2.q0;

/* loaded from: classes2.dex */
public final class x implements q0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f62457a;

    /* renamed from: b, reason: collision with root package name */
    public final ImmutableIntArray f62458b;

    public x(int i11, int[] iArr) {
        this.f62457a = i11;
        this.f62458b = iArr != null ? ImmutableIntArray.copyOf(iArr) : ImmutableIntArray.of();
    }
}
