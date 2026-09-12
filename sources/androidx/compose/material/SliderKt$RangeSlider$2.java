package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.r0;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.c1;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.i;
import androidx.compose.runtime.p1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.v;
import androidx.compose.ui.f;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/layout/g;", "", "invoke", "(Landroidx/compose/foundation/layout/g;Landroidx/compose/runtime/i;I)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@SourceDebugExtension
/* loaded from: classes.dex */
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<androidx.compose.foundation.layout.g, androidx.compose.runtime.i, Integer, Unit> {
    final /* synthetic */ j $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ p.i $endInteractionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ a3 $onValueChangeState;
    final /* synthetic */ p.i $startInteractionSource;
    final /* synthetic */ int $steps;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$2(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, List<Float> list, Function0<Unit> function0, a3 a3Var, p.i iVar, p.i iVar2, boolean z10, int i11, j jVar) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$value = closedFloatingPointRange2;
        this.$tickFractions = list;
        this.$onValueChangeFinished = function0;
        this.$onValueChangeState = a3Var;
        this.$startInteractionSource = iVar;
        this.$endInteractionSource = iVar2;
        this.$enabled = z10;
        this.$steps = i11;
        this.$colors = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float a(ClosedFloatingPointRange closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f11) {
        return SliderKt.v(((Number) closedFloatingPointRange.j()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue(), f11, floatRef.element, floatRef2.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange b(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange closedFloatingPointRange, ClosedFloatingPointRange closedFloatingPointRange2) {
        return SliderKt.w(floatRef.element, floatRef2.element, closedFloatingPointRange2, ((Number) closedFloatingPointRange.j()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((androidx.compose.foundation.layout.g) obj, (androidx.compose.runtime.i) obj2, ((Number) obj3).intValue());
        return Unit.f67184a;
    }

    public final void invoke(androidx.compose.foundation.layout.g gVar, androidx.compose.runtime.i iVar, int i11) {
        int i12;
        if ((i11 & 6) == 0) {
            i12 = i11 | (iVar.O(gVar) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i12 & 19) == 18 && iVar.h()) {
            iVar.G();
            return;
        }
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(652589923, i12, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:320)");
        }
        boolean z10 = iVar.l(CompositionLocalsKt.g()) == LayoutDirection.Rtl;
        float l11 = o0.b.l(gVar.a());
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        o0.e eVar = (o0.e) iVar.l(CompositionLocalsKt.c());
        floatRef.element = l11 - eVar.E0(SliderKt.t());
        floatRef2.element = eVar.E0(SliderKt.t());
        ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$value;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
        Object y10 = iVar.y();
        i.a aVar = androidx.compose.runtime.i.f3811a;
        if (y10 == aVar.a()) {
            y10 = p1.a(a(closedFloatingPointRange2, floatRef2, floatRef, ((Number) closedFloatingPointRange.j()).floatValue()));
            iVar.p(y10);
        }
        final c1 c1Var = (c1) y10;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$value;
        ClosedFloatingPointRange<Float> closedFloatingPointRange4 = this.$valueRange;
        Object y11 = iVar.y();
        if (y11 == aVar.a()) {
            y11 = p1.a(a(closedFloatingPointRange4, floatRef2, floatRef, ((Number) closedFloatingPointRange3.e()).floatValue()));
            iVar.p(y11);
        }
        final c1 c1Var2 = (c1) y11;
        boolean O = iVar.O(this.$valueRange) | iVar.b(floatRef2.element) | iVar.b(floatRef.element);
        ClosedFloatingPointRange<Float> closedFloatingPointRange5 = this.$valueRange;
        Object y12 = iVar.y();
        if (O || y12 == aVar.a()) {
            y12 = new SliderKt$RangeSlider$2$2$1(closedFloatingPointRange5, floatRef2, floatRef);
            iVar.p(y12);
        }
        SliderKt.a((Function1) ((KFunction) y12), this.$valueRange, RangesKt.b(floatRef2.element, floatRef.element), c1Var, ((Number) this.$value.j()).floatValue(), iVar, 3072);
        boolean O2 = iVar.O(this.$valueRange) | iVar.b(floatRef2.element) | iVar.b(floatRef.element);
        ClosedFloatingPointRange<Float> closedFloatingPointRange6 = this.$valueRange;
        Object y13 = iVar.y();
        if (O2 || y13 == aVar.a()) {
            y13 = new SliderKt$RangeSlider$2$3$1(closedFloatingPointRange6, floatRef2, floatRef);
            iVar.p(y13);
        }
        SliderKt.a((Function1) ((KFunction) y13), this.$valueRange, RangesKt.b(floatRef2.element, floatRef.element), c1Var2, ((Number) this.$value.e()).floatValue(), iVar, 3072);
        Object y14 = iVar.y();
        if (y14 == aVar.a()) {
            Object vVar = new v(g0.g(EmptyCoroutineContext.INSTANCE, iVar));
            iVar.p(vVar);
            y14 = vVar;
        }
        final n0 a11 = ((v) y14).a();
        boolean A = iVar.A(this.$tickFractions) | iVar.b(floatRef2.element) | iVar.b(floatRef.element) | iVar.O(this.$onValueChangeFinished) | iVar.A(a11) | iVar.O(this.$onValueChangeState) | iVar.O(this.$valueRange);
        final List<Float> list = this.$tickFractions;
        final Function0<Unit> function0 = this.$onValueChangeFinished;
        final a3 a3Var = this.$onValueChangeState;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange7 = this.$valueRange;
        Object y15 = iVar.y();
        if (A || y15 == aVar.a()) {
            y15 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
                @DebugMetadata(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1", f = "Slider.kt", l = {366}, m = "invokeSuspend")
                /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ float $current;
                    final /* synthetic */ boolean $isStart;
                    final /* synthetic */ Ref.FloatRef $maxPx;
                    final /* synthetic */ Ref.FloatRef $minPx;
                    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                    final /* synthetic */ a3 $onValueChangeState;
                    final /* synthetic */ c1 $rawOffsetEnd;
                    final /* synthetic */ c1 $rawOffsetStart;
                    final /* synthetic */ float $target;
                    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(float f11, float f12, Function0<Unit> function0, boolean z10, c1 c1Var, c1 c1Var2, a3 a3Var, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$current = f11;
                        this.$target = f12;
                        this.$onValueChangeFinished = function0;
                        this.$isStart = z10;
                        this.$rawOffsetStart = c1Var;
                        this.$rawOffsetEnd = c1Var2;
                        this.$onValueChangeState = a3Var;
                        this.$minPx = floatRef;
                        this.$maxPx = floatRef2;
                        this.$valueRange = closedFloatingPointRange;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        r0 r0Var;
                        Object f11 = IntrinsicsKt.f();
                        int i11 = this.label;
                        if (i11 == 0) {
                            ResultKt.b(obj);
                            Animatable b11 = androidx.compose.animation.core.a.b(this.$current, 0.0f, 2, null);
                            Float c11 = Boxing.c(this.$target);
                            r0Var = SliderKt.f3458i;
                            Float c12 = Boxing.c(0.0f);
                            final boolean z10 = this.$isStart;
                            final c1 c1Var = this.$rawOffsetStart;
                            final c1 c1Var2 = this.$rawOffsetEnd;
                            final a3 a3Var = this.$onValueChangeState;
                            final Ref.FloatRef floatRef = this.$minPx;
                            final Ref.FloatRef floatRef2 = this.$maxPx;
                            final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
                            Function1<Animatable, Unit> function1 = new Function1<Animatable, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.2.gestureEndAction.1.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((Animatable) obj2);
                                    return Unit.f67184a;
                                }

                                public final void invoke(Animatable animatable) {
                                    ClosedFloatingPointRange b12;
                                    (z10 ? c1Var : c1Var2).setFloatValue(((Number) animatable.k()).floatValue());
                                    Function1 function12 = (Function1) a3Var.getValue();
                                    b12 = SliderKt$RangeSlider$2.b(floatRef, floatRef2, closedFloatingPointRange, RangesKt.b(c1Var.getFloatValue(), c1Var2.getFloatValue()));
                                    function12.invoke(b12);
                                }
                            };
                            this.label = 1;
                            if (b11.e(c11, r0Var, c12, function1, this) == f11) {
                                return f11;
                            }
                        } else {
                            if (i11 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                        }
                        Function0<Unit> function0 = this.$onValueChangeFinished;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.f67184a;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.f67184a;
                }

                public final void invoke(boolean z11) {
                    float y16;
                    float floatValue = (z11 ? c1.this : c1Var2).getFloatValue();
                    y16 = SliderKt.y(floatValue, list, floatRef2.element, floatRef.element);
                    if (floatValue != y16) {
                        kotlinx.coroutines.k.d(a11, null, null, new AnonymousClass1(floatValue, y16, function0, z11, c1.this, c1Var2, a3Var, floatRef2, floatRef, closedFloatingPointRange7, null), 3, null);
                        return;
                    }
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }
            };
            iVar.p(y15);
        }
        a3 i13 = r2.i((Function1) y15, iVar, 0);
        boolean O3 = iVar.O(this.$valueRange) | iVar.b(floatRef2.element) | iVar.b(floatRef.element) | iVar.O(this.$value) | iVar.O(this.$onValueChangeState);
        final ClosedFloatingPointRange<Float> closedFloatingPointRange8 = this.$value;
        final a3 a3Var2 = this.$onValueChangeState;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange9 = this.$valueRange;
        Object y16 = iVar.y();
        if (O3 || y16 == aVar.a()) {
            y16 = new Function2<Boolean, Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Boolean) obj).booleanValue(), ((Number) obj2).floatValue());
                    return Unit.f67184a;
                }

                public final void invoke(boolean z11, float f11) {
                    float a12;
                    ClosedFloatingPointRange b11;
                    ClosedFloatingPointRange b12;
                    float a13;
                    if (z11) {
                        c1 c1Var3 = c1.this;
                        c1Var3.setFloatValue(c1Var3.getFloatValue() + f11);
                        c1 c1Var4 = c1Var2;
                        a13 = SliderKt$RangeSlider$2.a(closedFloatingPointRange9, floatRef2, floatRef, ((Number) closedFloatingPointRange8.e()).floatValue());
                        c1Var4.setFloatValue(a13);
                        float floatValue = c1Var2.getFloatValue();
                        b11 = RangesKt.b(RangesKt.l(c1.this.getFloatValue(), floatRef2.element, floatValue), floatValue);
                    } else {
                        c1 c1Var5 = c1Var2;
                        c1Var5.setFloatValue(c1Var5.getFloatValue() + f11);
                        c1 c1Var6 = c1.this;
                        a12 = SliderKt$RangeSlider$2.a(closedFloatingPointRange9, floatRef2, floatRef, ((Number) closedFloatingPointRange8.j()).floatValue());
                        c1Var6.setFloatValue(a12);
                        float floatValue2 = c1.this.getFloatValue();
                        b11 = RangesKt.b(floatValue2, RangesKt.l(c1Var2.getFloatValue(), floatValue2, floatRef.element));
                    }
                    Function1 function1 = (Function1) a3Var2.getValue();
                    b12 = SliderKt$RangeSlider$2.b(floatRef2, floatRef, closedFloatingPointRange9, b11);
                    function1.invoke(b12);
                }
            };
            iVar.p(y16);
        }
        a3 i14 = r2.i((Function2) y16, iVar, 0);
        f.a aVar2 = androidx.compose.ui.f.f4253a;
        androidx.compose.ui.f u11 = SliderKt.u(aVar2, this.$startInteractionSource, this.$endInteractionSource, c1Var, c1Var2, this.$enabled, z10, l11, this.$valueRange, i13, i14);
        final float l12 = RangesKt.l(((Number) this.$value.j()).floatValue(), ((Number) this.$valueRange.j()).floatValue(), ((Number) this.$value.e()).floatValue());
        final float l13 = RangesKt.l(((Number) this.$value.e()).floatValue(), ((Number) this.$value.j()).floatValue(), ((Number) this.$valueRange.e()).floatValue());
        float s11 = SliderKt.s(((Number) this.$valueRange.j()).floatValue(), ((Number) this.$valueRange.e()).floatValue(), l12);
        float s12 = SliderKt.s(((Number) this.$valueRange.j()).floatValue(), ((Number) this.$valueRange.e()).floatValue(), l13);
        int floor = (int) Math.floor(this.$steps * s12);
        int floor2 = (int) Math.floor(this.$steps * (1.0f - s11));
        boolean z11 = this.$enabled;
        boolean O4 = iVar.O(this.$onValueChangeState) | iVar.b(l13);
        final a3 a3Var3 = this.$onValueChangeState;
        Object y17 = iVar.y();
        if (O4 || y17 == aVar.a()) {
            y17 = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).floatValue());
                    return Unit.f67184a;
                }

                public final void invoke(float f11) {
                    ((Function1) a3.this.getValue()).invoke(RangesKt.b(f11, l13));
                }
            };
            iVar.p(y17);
        }
        androidx.compose.ui.f x10 = SliderKt.x(aVar2, l12, z11, (Function1) y17, this.$onValueChangeFinished, RangesKt.b(((Number) this.$valueRange.j()).floatValue(), l13), floor);
        boolean z12 = this.$enabled;
        boolean O5 = iVar.O(this.$onValueChangeState) | iVar.b(l12);
        final a3 a3Var4 = this.$onValueChangeState;
        Object y18 = iVar.y();
        if (O5 || y18 == aVar.a()) {
            y18 = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).floatValue());
                    return Unit.f67184a;
                }

                public final void invoke(float f11) {
                    ((Function1) a3.this.getValue()).invoke(RangesKt.b(l12, f11));
                }
            };
            iVar.p(y18);
        }
        SliderKt.c(this.$enabled, s11, s12, this.$tickFractions, this.$colors, floatRef.element - floatRef2.element, this.$startInteractionSource, this.$endInteractionSource, u11, x10, SliderKt.x(aVar2, l13, z12, (Function1) y18, this.$onValueChangeFinished, RangesKt.b(l12, ((Number) this.$valueRange.e()).floatValue()), floor2), iVar, 14155776, 0);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
    }
}
