package androidx.compose.foundation.lazy.layout;

import androidx.collection.p0;
import androidx.collection.q0;
import androidx.compose.foundation.lazy.layout.b;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
public final class NearestRangeKeyIndexMap implements p {

    /* renamed from: b, reason: collision with root package name */
    private final p0 f3083b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f3084c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3085d;

    public NearestRangeKeyIndexMap(IntRange intRange, j jVar) {
        b c11 = jVar.c();
        final int first = intRange.getFirst();
        if (first < 0) {
            throw new IllegalStateException("negative nearestRange.first");
        }
        final int min = Math.min(intRange.getLast(), c11.getSize() - 1);
        if (min < first) {
            this.f3083b = q0.a();
            this.f3084c = new Object[0];
            this.f3085d = 0;
        } else {
            int i11 = (min - first) + 1;
            this.f3084c = new Object[i11];
            this.f3085d = first;
            final androidx.collection.k0 k0Var = new androidx.collection.k0(i11);
            c11.a(first, min, new Function1<b.a, Unit>() { // from class: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((b.a) obj);
                    return Unit.f67184a;
                }

                /* JADX WARN: Code restructure failed: missing block: B:5:0x0037, code lost:
                
                    if (r3 == null) goto L7;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.foundation.lazy.layout.b.a r7) {
                    /*
                        r6 = this;
                        java.lang.Object r0 = r7.c()
                        androidx.compose.foundation.lazy.layout.j$a r0 = (androidx.compose.foundation.lazy.layout.j.a) r0
                        kotlin.jvm.functions.Function1 r0 = r0.getKey()
                        int r1 = r1
                        int r2 = r7.b()
                        int r1 = java.lang.Math.max(r1, r2)
                        int r2 = r2
                        int r3 = r7.b()
                        int r4 = r7.a()
                        int r3 = r3 + r4
                        int r3 = r3 + (-1)
                        int r2 = java.lang.Math.min(r2, r3)
                        if (r1 > r2) goto L57
                    L27:
                        if (r0 == 0) goto L39
                        int r3 = r7.b()
                        int r3 = r1 - r3
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                        java.lang.Object r3 = r0.invoke(r3)
                        if (r3 != 0) goto L3d
                    L39:
                        java.lang.Object r3 = androidx.compose.foundation.lazy.layout.b0.a(r1)
                    L3d:
                        androidx.collection.k0 r4 = r3
                        r4.r(r3, r1)
                        androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r4 = r4
                        java.lang.Object[] r4 = androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap.c(r4)
                        androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r5 = r4
                        int r5 = androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap.d(r5)
                        int r5 = r1 - r5
                        r4[r5] = r3
                        if (r1 == r2) goto L57
                        int r1 = r1 + 1
                        goto L27
                    L57:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$2$1.invoke(androidx.compose.foundation.lazy.layout.b$a):void");
                }
            });
            this.f3083b = k0Var;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.p
    public int a(Object obj) {
        p0 p0Var = this.f3083b;
        int a11 = p0Var.a(obj);
        if (a11 >= 0) {
            return p0Var.f2391c[a11];
        }
        return -1;
    }

    @Override // androidx.compose.foundation.lazy.layout.p
    public Object b(int i11) {
        Object[] objArr = this.f3084c;
        int i12 = i11 - this.f3085d;
        if (i12 < 0 || i12 > ArraysKt.b0(objArr)) {
            return null;
        }
        return objArr[i12];
    }
}
