package androidx.compose.material.ripple;

import androidx.collection.n0;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.node.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p.k;

/* loaded from: classes.dex */
public final class CommonRippleNode extends RippleNode {

    /* renamed from: y, reason: collision with root package name */
    private final n0 f3516y;

    private CommonRippleNode(p.g gVar, boolean z10, float f11, x1 x1Var, Function0 function0) {
        super(gVar, z10, f11, x1Var, function0, null);
        this.f3516y = new n0(0, 1, null);
    }

    public /* synthetic */ CommonRippleNode(p.g gVar, boolean z10, float f11, x1 x1Var, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, z10, f11, x1Var, function0);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void I1(k.b bVar, long j11, float f11) {
        n0 n0Var = this.f3516y;
        Object[] objArr = n0Var.f2420b;
        Object[] objArr2 = n0Var.f2421c;
        long[] jArr = n0Var.f2419a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j12 = jArr[i11];
                if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j12) < 128) {
                            int i14 = (i11 << 3) + i13;
                            ((RippleAnimation) objArr2[i14]).h();
                        }
                        j12 >>= 8;
                    }
                    if (i12 != 8) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        RippleAnimation rippleAnimation = new RippleAnimation(K1() ? y.g.d(bVar.a()) : null, f11, K1(), null);
        this.f3516y.r(bVar, rippleAnimation);
        kotlinx.coroutines.k.d(d1(), null, null, new CommonRippleNode$addRipple$2(rippleAnimation, this, bVar, null), 3, null);
        o.a(this);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void J1(z.g gVar) {
        float f11;
        float f12;
        int i11;
        int i12;
        int i13;
        float d11 = ((c) L1().invoke()).d();
        if (d11 == 0.0f) {
            return;
        }
        n0 n0Var = this.f3516y;
        Object[] objArr = n0Var.f2420b;
        Object[] objArr2 = n0Var.f2421c;
        long[] jArr = n0Var.f2419a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i14 = 0;
        while (true) {
            long j11 = jArr[i14];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i15 = 8;
                int i16 = 8 - ((~(i14 - length)) >>> 31);
                long j12 = j11;
                int i17 = 0;
                while (i17 < i16) {
                    if ((j12 & 255) < 128) {
                        int i18 = (i14 << 3) + i17;
                        float f13 = d11;
                        i11 = i17;
                        i12 = i16;
                        f12 = d11;
                        i13 = i15;
                        ((RippleAnimation) objArr2[i18]).e(gVar, u1.k(M1(), f13, 0.0f, 0.0f, 0.0f, 14, null));
                    } else {
                        f12 = d11;
                        i11 = i17;
                        i12 = i16;
                        i13 = i15;
                    }
                    j12 >>= i13;
                    i17 = i11 + 1;
                    i15 = i13;
                    d11 = f12;
                    i16 = i12;
                }
                f11 = d11;
                if (i16 != i15) {
                    return;
                }
            } else {
                f11 = d11;
            }
            if (i14 == length) {
                return;
            }
            i14++;
            d11 = f11;
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void P1(k.b bVar) {
        RippleAnimation rippleAnimation = (RippleAnimation) this.f3516y.b(bVar);
        if (rippleAnimation != null) {
            rippleAnimation.h();
        }
    }

    @Override // androidx.compose.ui.f.c
    public void o1() {
        this.f3516y.h();
    }
}
