package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.WrapContentElement;
import androidx.compose.ui.b;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.z0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class SizeKt {

    /* renamed from: a */
    private static final FillElement f2853a;

    /* renamed from: b */
    private static final FillElement f2854b;

    /* renamed from: c */
    private static final FillElement f2855c;

    /* renamed from: d */
    private static final WrapContentElement f2856d;

    /* renamed from: e */
    private static final WrapContentElement f2857e;

    /* renamed from: f */
    private static final WrapContentElement f2858f;

    /* renamed from: g */
    private static final WrapContentElement f2859g;

    /* renamed from: h */
    private static final WrapContentElement f2860h;

    /* renamed from: i */
    private static final WrapContentElement f2861i;

    static {
        FillElement.Companion companion = FillElement.INSTANCE;
        f2853a = companion.c(1.0f);
        f2854b = companion.a(1.0f);
        f2855c = companion.b(1.0f);
        WrapContentElement.Companion companion2 = WrapContentElement.INSTANCE;
        b.a aVar = androidx.compose.ui.b.f4162a;
        f2856d = companion2.c(aVar.f(), false);
        f2857e = companion2.c(aVar.i(), false);
        f2858f = companion2.a(aVar.h(), false);
        f2859g = companion2.a(aVar.j(), false);
        f2860h = companion2.b(aVar.d(), false);
        f2861i = companion2.b(aVar.m(), false);
    }

    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, float f11) {
        return fVar.e(f11 == 1.0f ? f2855c : FillElement.INSTANCE.b(f11));
    }

    public static /* synthetic */ androidx.compose.ui.f b(androidx.compose.ui.f fVar, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        return a(fVar, f11);
    }

    public static final androidx.compose.ui.f c(androidx.compose.ui.f fVar, float f11) {
        return fVar.e(f11 == 1.0f ? f2853a : FillElement.INSTANCE.c(f11));
    }

    public static /* synthetic */ androidx.compose.ui.f d(androidx.compose.ui.f fVar, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        return c(fVar, f11);
    }

    public static final androidx.compose.ui.f e(androidx.compose.ui.f fVar, final float f11) {
        return fVar.e(new SizeElement(0.0f, f11, 0.0f, f11, true, InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z0) obj);
                return Unit.f67184a;
            }

            public final void invoke(z0 z0Var) {
                z0Var.b("height");
                z0Var.c(o0.i.d(f11));
            }
        } : InspectableValueKt.a(), 5, null));
    }

    public static final androidx.compose.ui.f f(androidx.compose.ui.f fVar, final float f11, final float f12) {
        return fVar.e(new SizeElement(0.0f, f11, 0.0f, f12, true, InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z0) obj);
                return Unit.f67184a;
            }

            public final void invoke(z0 z0Var) {
                z0Var.b("heightIn");
                z0Var.a().c("min", o0.i.d(f11));
                z0Var.a().c("max", o0.i.d(f12));
            }
        } : InspectableValueKt.a(), 5, null));
    }

    public static /* synthetic */ androidx.compose.ui.f g(androidx.compose.ui.f fVar, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = o0.i.f70726b.b();
        }
        if ((i11 & 2) != 0) {
            f12 = o0.i.f70726b.b();
        }
        return f(fVar, f11, f12);
    }

    public static final androidx.compose.ui.f h(androidx.compose.ui.f fVar, final float f11, final float f12, final float f13, final float f14) {
        return fVar.e(new SizeElement(f11, f12, f13, f14, false, InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z0) obj);
                return Unit.f67184a;
            }

            public final void invoke(z0 z0Var) {
                z0Var.b("requiredSizeIn");
                z0Var.a().c("minWidth", o0.i.d(f11));
                z0Var.a().c("minHeight", o0.i.d(f12));
                z0Var.a().c("maxWidth", o0.i.d(f13));
                z0Var.a().c("maxHeight", o0.i.d(f14));
            }
        } : InspectableValueKt.a(), null));
    }

    public static /* synthetic */ androidx.compose.ui.f i(androidx.compose.ui.f fVar, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = o0.i.f70726b.b();
        }
        if ((i11 & 2) != 0) {
            f12 = o0.i.f70726b.b();
        }
        if ((i11 & 4) != 0) {
            f13 = o0.i.f70726b.b();
        }
        if ((i11 & 8) != 0) {
            f14 = o0.i.f70726b.b();
        }
        return h(fVar, f11, f12, f13, f14);
    }

    public static final androidx.compose.ui.f j(androidx.compose.ui.f fVar, final float f11) {
        return fVar.e(new SizeElement(f11, f11, f11, f11, true, InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z0) obj);
                return Unit.f67184a;
            }

            public final void invoke(z0 z0Var) {
                z0Var.b("size");
                z0Var.c(o0.i.d(f11));
            }
        } : InspectableValueKt.a(), null));
    }

    public static final androidx.compose.ui.f k(androidx.compose.ui.f fVar, final float f11, final float f12) {
        return fVar.e(new SizeElement(f11, f12, f11, f12, true, InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z0) obj);
                return Unit.f67184a;
            }

            public final void invoke(z0 z0Var) {
                z0Var.b("size");
                z0Var.a().c("width", o0.i.d(f11));
                z0Var.a().c("height", o0.i.d(f12));
            }
        } : InspectableValueKt.a(), null));
    }

    public static final androidx.compose.ui.f l(androidx.compose.ui.f fVar, final float f11) {
        return fVar.e(new SizeElement(f11, 0.0f, f11, 0.0f, true, InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z0) obj);
                return Unit.f67184a;
            }

            public final void invoke(z0 z0Var) {
                z0Var.b("width");
                z0Var.c(o0.i.d(f11));
            }
        } : InspectableValueKt.a(), 10, null));
    }

    public static final androidx.compose.ui.f m(androidx.compose.ui.f fVar, final float f11, final float f12) {
        return fVar.e(new SizeElement(f11, 0.0f, f12, 0.0f, true, InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z0) obj);
                return Unit.f67184a;
            }

            public final void invoke(z0 z0Var) {
                z0Var.b("widthIn");
                z0Var.a().c("min", o0.i.d(f11));
                z0Var.a().c("max", o0.i.d(f12));
            }
        } : InspectableValueKt.a(), 10, null));
    }

    public static /* synthetic */ androidx.compose.ui.f n(androidx.compose.ui.f fVar, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = o0.i.f70726b.b();
        }
        if ((i11 & 2) != 0) {
            f12 = o0.i.f70726b.b();
        }
        return m(fVar, f11, f12);
    }

    public static final androidx.compose.ui.f o(androidx.compose.ui.f fVar, b.c cVar, boolean z10) {
        b.a aVar = androidx.compose.ui.b.f4162a;
        return fVar.e((!Intrinsics.c(cVar, aVar.h()) || z10) ? (!Intrinsics.c(cVar, aVar.j()) || z10) ? WrapContentElement.INSTANCE.a(cVar, z10) : f2859g : f2858f);
    }

    public static /* synthetic */ androidx.compose.ui.f p(androidx.compose.ui.f fVar, b.c cVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cVar = androidx.compose.ui.b.f4162a.h();
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return o(fVar, cVar, z10);
    }
}
