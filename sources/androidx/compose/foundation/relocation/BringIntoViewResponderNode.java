package androidx.compose.foundation.relocation;

import androidx.compose.ui.f;
import androidx.compose.ui.layout.l;
import androidx.compose.ui.node.g;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.v;
import androidx.compose.ui.node.w;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.o0;
import y.i;

/* loaded from: classes.dex */
public final class BringIntoViewResponderNode extends f.c implements androidx.compose.foundation.relocation.a, w, m1 {

    /* renamed from: q, reason: collision with root package name */
    public static final a f3234q = new a(null);

    /* renamed from: r, reason: collision with root package name */
    public static final int f3235r = 8;

    /* renamed from: n, reason: collision with root package name */
    private d f3236n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f3237o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3238p;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BringIntoViewResponderNode(d dVar) {
        this.f3236n = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i E1(BringIntoViewResponderNode bringIntoViewResponderNode, l lVar, Function0 function0) {
        i iVar;
        i c11;
        if (!bringIntoViewResponderNode.k1() || !bringIntoViewResponderNode.f3238p) {
            return null;
        }
        l k11 = g.k(bringIntoViewResponderNode);
        if (!lVar.F()) {
            lVar = null;
        }
        if (lVar == null || (iVar = (i) function0.invoke()) == null) {
            return null;
        }
        c11 = c.c(k11, lVar, iVar);
        return c11;
    }

    @Override // androidx.compose.ui.node.m1
    public Object D() {
        return f3234q;
    }

    @Override // androidx.compose.ui.node.w
    public /* synthetic */ void F(long j11) {
        v.b(this, j11);
    }

    public final d F1() {
        return this.f3236n;
    }

    @Override // androidx.compose.ui.node.w
    public void I(l lVar) {
        this.f3238p = true;
    }

    @Override // androidx.compose.foundation.relocation.a
    public Object U(final l lVar, final Function0 function0, Continuation continuation) {
        Object e11 = o0.e(new BringIntoViewResponderNode$bringChildIntoView$2(this, lVar, function0, new Function0<i>() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$parentRect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final i invoke() {
                i E1;
                E1 = BringIntoViewResponderNode.E1(BringIntoViewResponderNode.this, lVar, function0);
                if (E1 != null) {
                    return BringIntoViewResponderNode.this.F1().Y(E1);
                }
                return null;
            }
        }, null), continuation);
        return e11 == IntrinsicsKt.f() ? e11 : Unit.f67184a;
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return this.f3237o;
    }
}
