package androidx.compose.ui.draganddrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import androidx.compose.ui.graphics.h0;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import y.m;
import z.a;

/* loaded from: classes.dex */
public final class a extends View.DragShadowBuilder {

    /* renamed from: a, reason: collision with root package name */
    private final o0.e f4215a;

    /* renamed from: b, reason: collision with root package name */
    private final long f4216b;

    /* renamed from: c, reason: collision with root package name */
    private final Function1 f4217c;

    private a(o0.e eVar, long j11, Function1 function1) {
        this.f4215a = eVar;
        this.f4216b = j11;
        this.f4217c = function1;
    }

    public /* synthetic */ a(o0.e eVar, long j11, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, j11, function1);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        z.a aVar = new z.a();
        o0.e eVar = this.f4215a;
        long j11 = this.f4216b;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        m1 b11 = h0.b(canvas);
        Function1 function1 = this.f4217c;
        a.C1001a F = aVar.F();
        o0.e a11 = F.a();
        LayoutDirection b12 = F.b();
        m1 c11 = F.c();
        long d11 = F.d();
        a.C1001a F2 = aVar.F();
        F2.j(eVar);
        F2.k(layoutDirection);
        F2.i(b11);
        F2.l(j11);
        b11.n();
        function1.invoke(aVar);
        b11.j();
        a.C1001a F3 = aVar.F();
        F3.j(a11);
        F3.k(b12);
        F3.i(c11);
        F3.l(d11);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point point, Point point2) {
        o0.e eVar = this.f4215a;
        point.set(eVar.c0(eVar.y0(m.i(this.f4216b))), eVar.c0(eVar.y0(m.g(this.f4216b))));
        point2.set(point.x / 2, point.y / 2);
    }
}
