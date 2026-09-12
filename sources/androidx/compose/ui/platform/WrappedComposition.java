package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R$id;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.view.Lifecycle;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class WrappedComposition implements androidx.compose.runtime.l, androidx.view.r {

    /* renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f5797a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.compose.runtime.l f5798b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5799c;

    /* renamed from: d, reason: collision with root package name */
    private Lifecycle f5800d;

    /* renamed from: e, reason: collision with root package name */
    private Function2 f5801e = ComposableSingletons$Wrapper_androidKt.f5683a.a();

    public WrappedComposition(AndroidComposeView androidComposeView, androidx.compose.runtime.l lVar) {
        this.f5797a = androidComposeView;
        this.f5798b = lVar;
    }

    @Override // androidx.compose.runtime.l
    public void d(final Function2 function2) {
        this.f5797a.setOnViewTreeOwnersAvailable(new Function1<AndroidComposeView.b, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AndroidComposeView.b) obj);
                return Unit.f67184a;
            }

            public final void invoke(AndroidComposeView.b bVar) {
                boolean z10;
                Lifecycle lifecycle;
                z10 = WrappedComposition.this.f5799c;
                if (z10) {
                    return;
                }
                Lifecycle lifecycle2 = bVar.a().getLifecycle();
                WrappedComposition.this.f5801e = function2;
                lifecycle = WrappedComposition.this.f5800d;
                if (lifecycle == null) {
                    WrappedComposition.this.f5800d = lifecycle2;
                    lifecycle2.a(WrappedComposition.this);
                } else if (lifecycle2.b().isAtLeast(Lifecycle.State.CREATED)) {
                    androidx.compose.runtime.l x10 = WrappedComposition.this.x();
                    final WrappedComposition wrappedComposition = WrappedComposition.this;
                    final Function2<androidx.compose.runtime.i, Integer, Unit> function22 = function2;
                    x10.d(androidx.compose.runtime.internal.b.b(-2000640158, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                            return Unit.f67184a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar, int i11) {
                            if ((i11 & 3) == 2 && iVar.h()) {
                                iVar.G();
                                return;
                            }
                            if (androidx.compose.runtime.k.H()) {
                                androidx.compose.runtime.k.Q(-2000640158, i11, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:134)");
                            }
                            Object tag = WrappedComposition.this.y().getTag(R$id.inspection_slot_table_set);
                            Set set = TypeIntrinsics.n(tag) ? (Set) tag : null;
                            if (set == null) {
                                Object parent = WrappedComposition.this.y().getParent();
                                View view = parent instanceof View ? (View) parent : null;
                                Object tag2 = view != null ? view.getTag(R$id.inspection_slot_table_set) : null;
                                set = TypeIntrinsics.n(tag2) ? (Set) tag2 : null;
                            }
                            if (set != null) {
                                set.add(iVar.z());
                                iVar.u();
                            }
                            AndroidComposeView y10 = WrappedComposition.this.y();
                            boolean A = iVar.A(WrappedComposition.this);
                            WrappedComposition wrappedComposition2 = WrappedComposition.this;
                            Object y11 = iVar.y();
                            if (A || y11 == androidx.compose.runtime.i.f3811a.a()) {
                                y11 = new WrappedComposition$setContent$1$1$1$1(wrappedComposition2, null);
                                iVar.p(y11);
                            }
                            androidx.compose.runtime.g0.d(y10, (Function2) y11, iVar, 0);
                            AndroidComposeView y12 = WrappedComposition.this.y();
                            boolean A2 = iVar.A(WrappedComposition.this);
                            WrappedComposition wrappedComposition3 = WrappedComposition.this;
                            Object y13 = iVar.y();
                            if (A2 || y13 == androidx.compose.runtime.i.f3811a.a()) {
                                y13 = new WrappedComposition$setContent$1$1$2$1(wrappedComposition3, null);
                                iVar.p(y13);
                            }
                            androidx.compose.runtime.g0.d(y12, (Function2) y13, iVar, 0);
                            androidx.compose.runtime.t1 d11 = InspectionTablesKt.a().d(set);
                            final WrappedComposition wrappedComposition4 = WrappedComposition.this;
                            final Function2<androidx.compose.runtime.i, Integer, Unit> function23 = function22;
                            CompositionLocalKt.a(d11, androidx.compose.runtime.internal.b.d(-1193460702, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition.setContent.1.1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                                    return Unit.f67184a;
                                }

                                public final void invoke(androidx.compose.runtime.i iVar2, int i12) {
                                    if ((i12 & 3) == 2 && iVar2.h()) {
                                        iVar2.G();
                                        return;
                                    }
                                    if (androidx.compose.runtime.k.H()) {
                                        androidx.compose.runtime.k.Q(-1193460702, i12, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:154)");
                                    }
                                    AndroidCompositionLocals_androidKt.a(WrappedComposition.this.y(), function23, iVar2, 0);
                                    if (androidx.compose.runtime.k.H()) {
                                        androidx.compose.runtime.k.P();
                                    }
                                }
                            }, iVar, 54), iVar, androidx.compose.runtime.t1.f4116i | 48);
                            if (androidx.compose.runtime.k.H()) {
                                androidx.compose.runtime.k.P();
                            }
                        }
                    }));
                }
            }
        });
    }

    @Override // androidx.compose.runtime.l
    public void dispose() {
        if (!this.f5799c) {
            this.f5799c = true;
            this.f5797a.getView().setTag(R$id.wrapped_composition_tag, null);
            Lifecycle lifecycle = this.f5800d;
            if (lifecycle != null) {
                lifecycle.d(this);
            }
        }
        this.f5798b.dispose();
    }

    @Override // androidx.view.r
    public void onStateChanged(androidx.view.u uVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event != Lifecycle.Event.ON_CREATE || this.f5799c) {
                return;
            }
            d(this.f5801e);
        }
    }

    public final androidx.compose.runtime.l x() {
        return this.f5798b;
    }

    public final AndroidComposeView y() {
        return this.f5797a;
    }
}
