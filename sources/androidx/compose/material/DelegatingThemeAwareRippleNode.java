package androidx.compose.material;

import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
final class DelegatingThemeAwareRippleNode extends androidx.compose.ui.node.i implements androidx.compose.ui.node.d, u0 {

    /* renamed from: p, reason: collision with root package name */
    private final p.g f3425p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f3426q;

    /* renamed from: r, reason: collision with root package name */
    private final float f3427r;

    /* renamed from: s, reason: collision with root package name */
    private final x1 f3428s;

    /* renamed from: t, reason: collision with root package name */
    private androidx.compose.ui.node.f f3429t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements x1 {
        a() {
        }

        @Override // androidx.compose.ui.graphics.x1
        public final long a() {
            long a11 = DelegatingThemeAwareRippleNode.this.f3428s.a();
            if (a11 != 16) {
                return a11;
            }
            g gVar = (g) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, RippleKt.d());
            return (gVar == null || gVar.a() == 16) ? h.f3487a.b(((u1) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, ContentColorKt.a())).u(), ((b) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, ColorsKt.c())).m()) : gVar.a();
        }
    }

    private DelegatingThemeAwareRippleNode(p.g gVar, boolean z10, float f11, x1 x1Var) {
        this.f3425p = gVar;
        this.f3426q = z10;
        this.f3427r = f11;
        this.f3428s = x1Var;
    }

    public /* synthetic */ DelegatingThemeAwareRippleNode(p.g gVar, boolean z10, float f11, x1 x1Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, z10, f11, x1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1() {
        this.f3429t = D1(androidx.compose.material.ripple.h.c(this.f3425p, this.f3426q, this.f3427r, new a(), new Function0<androidx.compose.material.ripple.c>() { // from class: androidx.compose.material.DelegatingThemeAwareRippleNode$attachNewRipple$calculateRippleAlpha$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.compose.material.ripple.c invoke() {
                androidx.compose.material.ripple.c b11;
                g gVar = (g) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, RippleKt.d());
                return (gVar == null || (b11 = gVar.b()) == null) ? h.f3487a.a(((u1) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, ContentColorKt.a())).u(), ((b) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, ColorsKt.c())).m()) : b11;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1() {
        androidx.compose.ui.node.f fVar = this.f3429t;
        if (fVar != null) {
            G1(fVar);
        }
    }

    private final void P1() {
        v0.a(this, new Function0<Unit>() { // from class: androidx.compose.material.DelegatingThemeAwareRippleNode$updateConfiguration$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m74invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m74invoke() {
                androidx.compose.ui.node.f fVar;
                if (((g) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, RippleKt.d())) == null) {
                    DelegatingThemeAwareRippleNode.this.O1();
                    return;
                }
                fVar = DelegatingThemeAwareRippleNode.this.f3429t;
                if (fVar == null) {
                    DelegatingThemeAwareRippleNode.this.N1();
                }
            }
        });
    }

    @Override // androidx.compose.ui.node.u0
    public void Z() {
        P1();
    }

    @Override // androidx.compose.ui.f.c
    public void n1() {
        P1();
    }
}
