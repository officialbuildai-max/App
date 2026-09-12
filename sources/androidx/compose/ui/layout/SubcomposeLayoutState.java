package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class SubcomposeLayoutState {

    /* renamed from: f, reason: collision with root package name */
    public static final int f5227f = 8;

    /* renamed from: a, reason: collision with root package name */
    private final p0 f5228a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutNodeSubcompositionsState f5229b;

    /* renamed from: c, reason: collision with root package name */
    private final Function2 f5230c;

    /* renamed from: d, reason: collision with root package name */
    private final Function2 f5231d;

    /* renamed from: e, reason: collision with root package name */
    private final Function2 f5232e;

    /* loaded from: classes.dex */
    public interface a {
        void a(Object obj, Function1 function1);

        int b();

        void c(int i11, long j11);

        void dispose();
    }

    public SubcomposeLayoutState() {
        this(a0.f5235a);
    }

    public SubcomposeLayoutState(p0 p0Var) {
        this.f5228a = p0Var;
        this.f5230c = new Function2<LayoutNode, SubcomposeLayoutState, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (SubcomposeLayoutState) obj2);
                return Unit.f67184a;
            }

            public final void invoke(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
                LayoutNodeSubcompositionsState h11;
                LayoutNodeSubcompositionsState h12;
                p0 p0Var2;
                p0 p0Var3;
                SubcomposeLayoutState subcomposeLayoutState2 = SubcomposeLayoutState.this;
                LayoutNodeSubcompositionsState k02 = layoutNode.k0();
                if (k02 == null) {
                    p0Var3 = SubcomposeLayoutState.this.f5228a;
                    k02 = new LayoutNodeSubcompositionsState(layoutNode, p0Var3);
                    layoutNode.t1(k02);
                }
                subcomposeLayoutState2.f5229b = k02;
                h11 = SubcomposeLayoutState.this.h();
                h11.y();
                h12 = SubcomposeLayoutState.this.h();
                p0Var2 = SubcomposeLayoutState.this.f5228a;
                h12.G(p0Var2);
            }
        };
        this.f5231d = new Function2<LayoutNode, androidx.compose.runtime.m, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setCompositionContext$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (androidx.compose.runtime.m) obj2);
                return Unit.f67184a;
            }

            public final void invoke(LayoutNode layoutNode, androidx.compose.runtime.m mVar) {
                LayoutNodeSubcompositionsState h11;
                h11 = SubcomposeLayoutState.this.h();
                h11.F(mVar);
            }
        };
        this.f5232e = new Function2<LayoutNode, Function2<? super o0, ? super o0.b, ? extends v>, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setMeasurePolicy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (Function2<? super o0, ? super o0.b, ? extends v>) obj2);
                return Unit.f67184a;
            }

            public final void invoke(LayoutNode layoutNode, Function2<? super o0, ? super o0.b, ? extends v> function2) {
                LayoutNodeSubcompositionsState h11;
                h11 = SubcomposeLayoutState.this.h();
                layoutNode.g(h11.r(function2));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNodeSubcompositionsState h() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.f5229b;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout");
    }

    public final void d() {
        h().w();
    }

    public final Function2 e() {
        return this.f5231d;
    }

    public final Function2 f() {
        return this.f5232e;
    }

    public final Function2 g() {
        return this.f5230c;
    }

    public final a i(Object obj, Function2 function2) {
        return h().D(obj, function2);
    }
}
