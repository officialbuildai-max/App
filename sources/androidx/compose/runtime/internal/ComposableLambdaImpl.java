package androidx.compose.runtime.internal;

import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.u1;
import androidx.compose.runtime.v1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
public final class ComposableLambdaImpl implements a {

    /* renamed from: a, reason: collision with root package name */
    private final int f3832a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3833b;

    /* renamed from: c, reason: collision with root package name */
    private Object f3834c;

    /* renamed from: d, reason: collision with root package name */
    private u1 f3835d;

    /* renamed from: e, reason: collision with root package name */
    private List f3836e;

    public ComposableLambdaImpl(int i11, boolean z10, Object obj) {
        this.f3832a = i11;
        this.f3833b = z10;
        this.f3834c = obj;
    }

    private final void g(i iVar) {
        u1 v11;
        if (!this.f3833b || (v11 = iVar.v()) == null) {
            return;
        }
        iVar.J(v11);
        if (b.e(this.f3835d, v11)) {
            this.f3835d = v11;
            return;
        }
        List list = this.f3836e;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.f3836e = arrayList;
            arrayList.add(v11);
            return;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (b.e((u1) list.get(i11), v11)) {
                list.set(i11, v11);
                return;
            }
        }
        list.add(v11);
    }

    private final void h() {
        if (this.f3833b) {
            u1 u1Var = this.f3835d;
            if (u1Var != null) {
                u1Var.invalidate();
                this.f3835d = null;
            }
            List list = this.f3836e;
            if (list != null) {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((u1) list.get(i11)).invalidate();
                }
                list.clear();
            }
        }
    }

    public Object a(i iVar, int i11) {
        i g11 = iVar.g(this.f3832a);
        g(g11);
        int c11 = i11 | (g11.O(this) ? b.c(0) : b.f(0));
        Object obj = this.f3834c;
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function2) TypeIntrinsics.e(obj, 2)).invoke(g11, Integer.valueOf(c11));
        g2 j11 = g11.j();
        if (j11 != null) {
            Intrinsics.f(this, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
            j11.a((Function2) TypeIntrinsics.e(this, 2));
        }
        return invoke;
    }

    public Object b(final Object obj, i iVar, final int i11) {
        i g11 = iVar.g(this.f3832a);
        g(g11);
        int c11 = g11.O(this) ? b.c(1) : b.f(1);
        Object obj2 = this.f3834c;
        Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function3) TypeIntrinsics.e(obj2, 3)).invoke(obj, g11, Integer.valueOf(c11 | i11));
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                    invoke((i) obj3, ((Number) obj4).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.b(obj, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return invoke;
    }

    public Object c(final Object obj, final Object obj2, i iVar, final int i11) {
        i g11 = iVar.g(this.f3832a);
        g(g11);
        int c11 = g11.O(this) ? b.c(2) : b.f(2);
        Object obj3 = this.f3834c;
        Intrinsics.f(obj3, "null cannot be cast to non-null type kotlin.Function4<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function4) TypeIntrinsics.e(obj3, 4)).invoke(obj, obj2, g11, Integer.valueOf(c11 | i11));
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                    invoke((i) obj4, ((Number) obj5).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.c(obj, obj2, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return invoke;
    }

    public Object d(final Object obj, final Object obj2, final Object obj3, i iVar, final int i11) {
        i g11 = iVar.g(this.f3832a);
        g(g11);
        int c11 = g11.O(this) ? b.c(3) : b.f(3);
        Object obj4 = this.f3834c;
        Intrinsics.f(obj4, "null cannot be cast to non-null type kotlin.Function5<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function5) TypeIntrinsics.e(obj4, 5)).invoke(obj, obj2, obj3, g11, Integer.valueOf(c11 | i11));
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj5, Object obj6) {
                    invoke((i) obj5, ((Number) obj6).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.d(obj, obj2, obj3, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return invoke;
    }

    public Object e(final Object obj, final Object obj2, final Object obj3, final Object obj4, i iVar, final int i11) {
        i g11 = iVar.g(this.f3832a);
        g(g11);
        int c11 = g11.O(this) ? b.c(4) : b.f(4);
        Object obj5 = this.f3834c;
        Intrinsics.f(obj5, "null cannot be cast to non-null type kotlin.Function6<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function6) TypeIntrinsics.e(obj5, 6)).invoke(obj, obj2, obj3, obj4, g11, Integer.valueOf(c11 | i11));
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj6, Object obj7) {
                    invoke((i) obj6, ((Number) obj7).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.e(obj, obj2, obj3, obj4, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return invoke;
    }

    public Object f(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, i iVar, final int i11) {
        i g11 = iVar.g(this.f3832a);
        g(g11);
        int c11 = g11.O(this) ? b.c(5) : b.f(5);
        Object obj6 = this.f3834c;
        Intrinsics.f(obj6, "null cannot be cast to non-null type kotlin.Function7<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function7) TypeIntrinsics.e(obj6, 7)).invoke(obj, obj2, obj3, obj4, obj5, g11, Integer.valueOf(i11 | c11));
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj7, Object obj8) {
                    invoke((i) obj7, ((Number) obj8).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.f(obj, obj2, obj3, obj4, obj5, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return invoke;
    }

    public final void i(Object obj) {
        if (Intrinsics.c(this.f3834c, obj)) {
            return;
        }
        boolean z10 = this.f3834c == null;
        this.f3834c = obj;
        if (z10) {
            return;
        }
        h();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a((i) obj, ((Number) obj2).intValue());
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return b(obj, (i) obj2, ((Number) obj3).intValue());
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return c(obj, obj2, (i) obj3, ((Number) obj4).intValue());
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return d(obj, obj2, obj3, (i) obj4, ((Number) obj5).intValue());
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return e(obj, obj2, obj3, obj4, (i) obj5, ((Number) obj6).intValue());
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return f(obj, obj2, obj3, obj4, obj5, (i) obj6, ((Number) obj7).intValue());
    }
}
