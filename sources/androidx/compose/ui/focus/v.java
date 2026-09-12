package androidx.compose.ui.focus;

import androidx.collection.n0;
import androidx.collection.v0;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a */
    private final n0 f4328a = v0.d();

    /* renamed from: b */
    private final androidx.compose.runtime.collection.b f4329b = new androidx.compose.runtime.collection.b(new Function0[16], 0);

    /* renamed from: c */
    private boolean f4330c;

    public static final /* synthetic */ void a(v vVar) {
        vVar.f();
    }

    public static final /* synthetic */ void b(v vVar) {
        vVar.g();
    }

    public static final /* synthetic */ void c(v vVar) {
        vVar.h();
    }

    public static final /* synthetic */ boolean e(v vVar) {
        return vVar.f4330c;
    }

    public final void f() {
        this.f4330c = true;
    }

    public final void g() {
        this.f4328a.h();
        int i11 = 0;
        this.f4330c = false;
        androidx.compose.runtime.collection.b bVar = this.f4329b;
        int n11 = bVar.n();
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            do {
                ((Function0) m11[i11]).invoke();
                i11++;
            } while (i11 < n11);
        }
        this.f4329b.h();
    }

    public final void h() {
        n0 n0Var = this.f4328a;
        Object[] objArr = n0Var.f2420b;
        long[] jArr = n0Var.f2419a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            ((FocusTargetNode) objArr[(i11 << 3) + i13]).H1();
                        }
                        j11 >>= 8;
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
        this.f4328a.h();
        this.f4330c = false;
        this.f4329b.h();
    }

    public final FocusStateImpl i(FocusTargetNode focusTargetNode) {
        return (FocusStateImpl) this.f4328a.b(focusTargetNode);
    }

    public final void j(FocusTargetNode focusTargetNode, FocusStateImpl focusStateImpl) {
        n0 n0Var = this.f4328a;
        if (focusStateImpl != null) {
            n0Var.r(focusTargetNode, focusStateImpl);
        } else {
            g0.a.c("requires a non-null focus state");
            throw new KotlinNothingValueException();
        }
    }
}
