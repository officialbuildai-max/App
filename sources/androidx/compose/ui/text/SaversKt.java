package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.b0;
import androidx.compose.ui.text.f;
import androidx.compose.ui.text.font.p;
import androidx.compose.ui.text.style.a;
import androidx.compose.ui.text.style.i;
import androidx.compose.ui.text.style.m;
import androidx.compose.ui.text.style.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n0.h;
import n0.i;
import o0.w;
import y.g;

/* loaded from: classes.dex */
public abstract class SaversKt {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6115a = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, AnnotatedString, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, AnnotatedString annotatedString) {
            androidx.compose.runtime.saveable.d dVar;
            androidx.compose.runtime.saveable.d dVar2;
            androidx.compose.runtime.saveable.d dVar3;
            Object x10 = SaversKt.x(annotatedString.i());
            List g11 = annotatedString.g();
            dVar = SaversKt.f6116b;
            Object y10 = SaversKt.y(g11, dVar, eVar);
            List e11 = annotatedString.e();
            dVar2 = SaversKt.f6116b;
            Object y11 = SaversKt.y(e11, dVar2, eVar);
            List b11 = annotatedString.b();
            dVar3 = SaversKt.f6116b;
            return CollectionsKt.h(x10, y10, y11, SaversKt.y(b11, dVar3, eVar));
        }
    }, new Function1<Object, AnnotatedString>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString invoke(Object obj) {
            androidx.compose.runtime.saveable.d dVar;
            androidx.compose.runtime.saveable.d dVar2;
            List list;
            List list2;
            androidx.compose.runtime.saveable.d dVar3;
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list3 = (List) obj;
            Object obj2 = list3.get(1);
            dVar = SaversKt.f6116b;
            Boolean bool = Boolean.FALSE;
            List list4 = null;
            List list5 = ((!Intrinsics.c(obj2, bool) || (dVar instanceof j)) && obj2 != null) ? (List) dVar.b(obj2) : null;
            Object obj3 = list3.get(2);
            dVar2 = SaversKt.f6116b;
            List list6 = ((!Intrinsics.c(obj3, bool) || (dVar2 instanceof j)) && obj3 != null) ? (List) dVar2.b(obj3) : null;
            Object obj4 = list3.get(0);
            String str = obj4 != null ? (String) obj4 : null;
            Intrinsics.e(str);
            if (list5 != null) {
                List list7 = list5;
                if (list7.isEmpty()) {
                    list7 = null;
                }
                list = list7;
            } else {
                list = null;
            }
            if (list6 != null) {
                List list8 = list6;
                if (list8.isEmpty()) {
                    list8 = null;
                }
                list2 = list8;
            } else {
                list2 = null;
            }
            Object obj5 = list3.get(3);
            dVar3 = SaversKt.f6116b;
            if ((!Intrinsics.c(obj5, bool) || (dVar3 instanceof j)) && obj5 != null) {
                list4 = (List) dVar3.b(obj5);
            }
            return new AnnotatedString(str, list, list2, list4);
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6116b = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, List<? extends AnnotatedString.c>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, List<? extends AnnotatedString.c> list) {
            androidx.compose.runtime.saveable.d dVar;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                AnnotatedString.c cVar = list.get(i11);
                dVar = SaversKt.f6117c;
                arrayList.add(SaversKt.y(cVar, dVar, eVar));
            }
            return arrayList;
        }
    }, new Function1<Object, List<? extends AnnotatedString.c>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final List<AnnotatedString.c> invoke(Object obj) {
            androidx.compose.runtime.saveable.d dVar;
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object obj2 = list.get(i11);
                dVar = SaversKt.f6117c;
                AnnotatedString.c cVar = null;
                if ((!Intrinsics.c(obj2, Boolean.FALSE) || (dVar instanceof j)) && obj2 != null) {
                    cVar = (AnnotatedString.c) dVar.b(obj2);
                }
                Intrinsics.e(cVar);
                arrayList.add(cVar);
            }
            return arrayList;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6117c = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, AnnotatedString.c, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1

        /* loaded from: classes.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6137a;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f6137a = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, AnnotatedString.c cVar) {
            Object y10;
            androidx.compose.runtime.saveable.d dVar;
            androidx.compose.runtime.saveable.d dVar2;
            androidx.compose.runtime.saveable.d dVar3;
            androidx.compose.runtime.saveable.d dVar4;
            Object e11 = cVar.e();
            AnnotationType annotationType = e11 instanceof r ? AnnotationType.Paragraph : e11 instanceof x ? AnnotationType.Span : e11 instanceof h0 ? AnnotationType.VerbatimTts : e11 instanceof g0 ? AnnotationType.Url : e11 instanceof f.b ? AnnotationType.Link : e11 instanceof f.a ? AnnotationType.Clickable : AnnotationType.String;
            switch (a.f6137a[annotationType.ordinal()]) {
                case 1:
                    Object e12 = cVar.e();
                    Intrinsics.f(e12, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                    y10 = SaversKt.y((r) e12, SaversKt.i(), eVar);
                    break;
                case 2:
                    Object e13 = cVar.e();
                    Intrinsics.f(e13, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                    y10 = SaversKt.y((x) e13, SaversKt.v(), eVar);
                    break;
                case 3:
                    Object e14 = cVar.e();
                    Intrinsics.f(e14, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                    dVar = SaversKt.f6118d;
                    y10 = SaversKt.y((h0) e14, dVar, eVar);
                    break;
                case 4:
                    Object e15 = cVar.e();
                    Intrinsics.f(e15, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                    dVar2 = SaversKt.f6119e;
                    y10 = SaversKt.y((g0) e15, dVar2, eVar);
                    break;
                case 5:
                    Object e16 = cVar.e();
                    Intrinsics.f(e16, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                    dVar3 = SaversKt.f6120f;
                    y10 = SaversKt.y((f.b) e16, dVar3, eVar);
                    break;
                case 6:
                    Object e17 = cVar.e();
                    Intrinsics.f(e17, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                    dVar4 = SaversKt.f6121g;
                    y10 = SaversKt.y((f.a) e17, dVar4, eVar);
                    break;
                case 7:
                    y10 = SaversKt.x(cVar.e());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return CollectionsKt.h(SaversKt.x(annotationType), y10, SaversKt.x(Integer.valueOf(cVar.f())), SaversKt.x(Integer.valueOf(cVar.d())), SaversKt.x(cVar.g()));
        }
    }, new Function1<Object, AnnotatedString.c>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        /* loaded from: classes.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6138a;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f6138a = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString.c invoke(Object obj) {
            androidx.compose.runtime.saveable.d dVar;
            androidx.compose.runtime.saveable.d dVar2;
            androidx.compose.runtime.saveable.d dVar3;
            androidx.compose.runtime.saveable.d dVar4;
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
            Intrinsics.e(annotationType);
            Object obj3 = list.get(2);
            Integer num = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.e(num);
            int intValue = num.intValue();
            Object obj4 = list.get(3);
            Integer num2 = obj4 != null ? (Integer) obj4 : null;
            Intrinsics.e(num2);
            int intValue2 = num2.intValue();
            Object obj5 = list.get(4);
            String str = obj5 != null ? (String) obj5 : null;
            Intrinsics.e(str);
            switch (a.f6138a[annotationType.ordinal()]) {
                case 1:
                    Object obj6 = list.get(1);
                    androidx.compose.runtime.saveable.d i11 = SaversKt.i();
                    if ((!Intrinsics.c(obj6, Boolean.FALSE) || (i11 instanceof j)) && obj6 != null) {
                        r1 = (r) i11.b(obj6);
                    }
                    Intrinsics.e(r1);
                    return new AnnotatedString.c(r1, intValue, intValue2, str);
                case 2:
                    Object obj7 = list.get(1);
                    androidx.compose.runtime.saveable.d v11 = SaversKt.v();
                    if ((!Intrinsics.c(obj7, Boolean.FALSE) || (v11 instanceof j)) && obj7 != null) {
                        r1 = (x) v11.b(obj7);
                    }
                    Intrinsics.e(r1);
                    return new AnnotatedString.c(r1, intValue, intValue2, str);
                case 3:
                    Object obj8 = list.get(1);
                    dVar = SaversKt.f6118d;
                    if ((!Intrinsics.c(obj8, Boolean.FALSE) || (dVar instanceof j)) && obj8 != null) {
                        r1 = (h0) dVar.b(obj8);
                    }
                    Intrinsics.e(r1);
                    return new AnnotatedString.c(r1, intValue, intValue2, str);
                case 4:
                    Object obj9 = list.get(1);
                    dVar2 = SaversKt.f6119e;
                    if ((!Intrinsics.c(obj9, Boolean.FALSE) || (dVar2 instanceof j)) && obj9 != null) {
                        r1 = (g0) dVar2.b(obj9);
                    }
                    Intrinsics.e(r1);
                    return new AnnotatedString.c(r1, intValue, intValue2, str);
                case 5:
                    Object obj10 = list.get(1);
                    dVar3 = SaversKt.f6120f;
                    if ((!Intrinsics.c(obj10, Boolean.FALSE) || (dVar3 instanceof j)) && obj10 != null) {
                        r1 = (f.b) dVar3.b(obj10);
                    }
                    Intrinsics.e(r1);
                    return new AnnotatedString.c(r1, intValue, intValue2, str);
                case 6:
                    Object obj11 = list.get(1);
                    dVar4 = SaversKt.f6121g;
                    if ((!Intrinsics.c(obj11, Boolean.FALSE) || (dVar4 instanceof j)) && obj11 != null) {
                        r1 = (f.a) dVar4.b(obj11);
                    }
                    Intrinsics.e(r1);
                    return new AnnotatedString.c(r1, intValue, intValue2, str);
                case 7:
                    Object obj12 = list.get(1);
                    r1 = obj12 != null ? (String) obj12 : null;
                    Intrinsics.e(r1);
                    return new AnnotatedString.c(r1, intValue, intValue2, str);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6118d = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, h0, Object>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, h0 h0Var) {
            return SaversKt.x(h0Var.a());
        }
    }, new Function1<Object, h0>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final h0 invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.e(str);
            return new h0(str);
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6119e = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, g0, Object>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, g0 g0Var) {
            return SaversKt.x(g0Var.a());
        }
    }, new Function1<Object, g0>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final g0 invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.e(str);
            return new g0(str);
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6120f = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, f.b, Object>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, f.b bVar) {
            return CollectionsKt.h(SaversKt.x(bVar.c()), SaversKt.y(bVar.b(), SaversKt.w(), eVar));
        }
    }, new Function1<Object, f.b>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final f.b invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            a0 a0Var = null;
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.e(str);
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d w11 = SaversKt.w();
            if ((!Intrinsics.c(obj3, Boolean.FALSE) || (w11 instanceof j)) && obj3 != null) {
                a0Var = (a0) w11.b(obj3);
            }
            return new f.b(str, a0Var, null, 4, null);
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6121g = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, f.a, Object>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, f.a aVar) {
            return CollectionsKt.h(SaversKt.x(aVar.c()), SaversKt.y(aVar.b(), SaversKt.w(), eVar));
        }
    }, new Function1<Object, f.a>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final f.a invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.e(str);
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d w11 = SaversKt.w();
            return new f.a(str, ((!Intrinsics.c(obj3, Boolean.FALSE) || (w11 instanceof j)) && obj3 != null) ? (a0) w11.b(obj3) : null, null);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6122h = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, r, Object>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, r rVar) {
            return CollectionsKt.h(SaversKt.x(androidx.compose.ui.text.style.h.h(rVar.h())), SaversKt.x(androidx.compose.ui.text.style.j.g(rVar.i())), SaversKt.y(o0.w.b(rVar.e()), SaversKt.t(o0.w.f70751b), eVar), SaversKt.y(rVar.j(), SaversKt.q(androidx.compose.ui.text.style.n.f6504c), eVar));
        }
    }, new Function1<Object, r>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final r invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            androidx.compose.ui.text.style.h hVar = obj2 != null ? (androidx.compose.ui.text.style.h) obj2 : null;
            Intrinsics.e(hVar);
            int n11 = hVar.n();
            Object obj3 = list.get(1);
            androidx.compose.ui.text.style.j jVar = obj3 != null ? (androidx.compose.ui.text.style.j) obj3 : null;
            Intrinsics.e(jVar);
            int m11 = jVar.m();
            Object obj4 = list.get(2);
            androidx.compose.runtime.saveable.d t11 = SaversKt.t(o0.w.f70751b);
            Boolean bool = Boolean.FALSE;
            o0.w wVar = ((!Intrinsics.c(obj4, bool) || (t11 instanceof j)) && obj4 != null) ? (o0.w) t11.b(obj4) : null;
            Intrinsics.e(wVar);
            long k11 = wVar.k();
            Object obj5 = list.get(3);
            androidx.compose.runtime.saveable.d q11 = SaversKt.q(androidx.compose.ui.text.style.n.f6504c);
            return new r(n11, m11, k11, ((!Intrinsics.c(obj5, bool) || (q11 instanceof j)) && obj5 != null) ? (androidx.compose.ui.text.style.n) q11.b(obj5) : null, null, null, 0, 0, null, 496, null);
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6123i = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, x, Object>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, x xVar) {
            u1 g11 = u1.g(xVar.g());
            u1.a aVar = u1.f4733b;
            Object y10 = SaversKt.y(g11, SaversKt.j(aVar), eVar);
            o0.w b11 = o0.w.b(xVar.k());
            w.a aVar2 = o0.w.f70751b;
            return CollectionsKt.h(y10, SaversKt.y(b11, SaversKt.t(aVar2), eVar), SaversKt.y(xVar.n(), SaversKt.m(androidx.compose.ui.text.font.p.f6224b), eVar), SaversKt.x(xVar.l()), SaversKt.x(xVar.m()), SaversKt.x(-1), SaversKt.x(xVar.j()), SaversKt.y(o0.w.b(xVar.o()), SaversKt.t(aVar2), eVar), SaversKt.y(xVar.e(), SaversKt.n(androidx.compose.ui.text.style.a.f6429b), eVar), SaversKt.y(xVar.u(), SaversKt.p(androidx.compose.ui.text.style.m.f6500c), eVar), SaversKt.y(xVar.p(), SaversKt.s(n0.i.f70184c), eVar), SaversKt.y(u1.g(xVar.d()), SaversKt.j(aVar), eVar), SaversKt.y(xVar.s(), SaversKt.o(androidx.compose.ui.text.style.i.f6484b), eVar), SaversKt.y(xVar.r(), SaversKt.k(z4.f4996d), eVar));
        }
    }, new Function1<Object, x>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final x invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            u1.a aVar = u1.f4733b;
            androidx.compose.runtime.saveable.d j11 = SaversKt.j(aVar);
            Boolean bool = Boolean.FALSE;
            u1 u1Var = ((!Intrinsics.c(obj2, bool) || (j11 instanceof j)) && obj2 != null) ? (u1) j11.b(obj2) : null;
            Intrinsics.e(u1Var);
            long u11 = u1Var.u();
            Object obj3 = list.get(1);
            w.a aVar2 = o0.w.f70751b;
            androidx.compose.runtime.saveable.d t11 = SaversKt.t(aVar2);
            o0.w wVar = ((!Intrinsics.c(obj3, bool) || (t11 instanceof j)) && obj3 != null) ? (o0.w) t11.b(obj3) : null;
            Intrinsics.e(wVar);
            long k11 = wVar.k();
            Object obj4 = list.get(2);
            androidx.compose.runtime.saveable.d m11 = SaversKt.m(androidx.compose.ui.text.font.p.f6224b);
            androidx.compose.ui.text.font.p pVar = ((!Intrinsics.c(obj4, bool) || (m11 instanceof j)) && obj4 != null) ? (androidx.compose.ui.text.font.p) m11.b(obj4) : null;
            Object obj5 = list.get(3);
            androidx.compose.ui.text.font.n nVar = obj5 != null ? (androidx.compose.ui.text.font.n) obj5 : null;
            Object obj6 = list.get(4);
            androidx.compose.ui.text.font.o oVar = obj6 != null ? (androidx.compose.ui.text.font.o) obj6 : null;
            Object obj7 = list.get(6);
            String str = obj7 != null ? (String) obj7 : null;
            Object obj8 = list.get(7);
            androidx.compose.runtime.saveable.d t12 = SaversKt.t(aVar2);
            o0.w wVar2 = ((!Intrinsics.c(obj8, bool) || (t12 instanceof j)) && obj8 != null) ? (o0.w) t12.b(obj8) : null;
            Intrinsics.e(wVar2);
            long k12 = wVar2.k();
            Object obj9 = list.get(8);
            androidx.compose.runtime.saveable.d n11 = SaversKt.n(androidx.compose.ui.text.style.a.f6429b);
            androidx.compose.ui.text.style.a aVar3 = ((!Intrinsics.c(obj9, bool) || (n11 instanceof j)) && obj9 != null) ? (androidx.compose.ui.text.style.a) n11.b(obj9) : null;
            Object obj10 = list.get(9);
            androidx.compose.runtime.saveable.d p11 = SaversKt.p(androidx.compose.ui.text.style.m.f6500c);
            androidx.compose.ui.text.style.m mVar = ((!Intrinsics.c(obj10, bool) || (p11 instanceof j)) && obj10 != null) ? (androidx.compose.ui.text.style.m) p11.b(obj10) : null;
            Object obj11 = list.get(10);
            androidx.compose.runtime.saveable.d s11 = SaversKt.s(n0.i.f70184c);
            n0.i iVar = ((!Intrinsics.c(obj11, bool) || (s11 instanceof j)) && obj11 != null) ? (n0.i) s11.b(obj11) : null;
            Object obj12 = list.get(11);
            androidx.compose.runtime.saveable.d j12 = SaversKt.j(aVar);
            u1 u1Var2 = ((!Intrinsics.c(obj12, bool) || (j12 instanceof j)) && obj12 != null) ? (u1) j12.b(obj12) : null;
            Intrinsics.e(u1Var2);
            long u12 = u1Var2.u();
            Object obj13 = list.get(12);
            androidx.compose.runtime.saveable.d o11 = SaversKt.o(androidx.compose.ui.text.style.i.f6484b);
            androidx.compose.ui.text.style.i iVar2 = ((!Intrinsics.c(obj13, bool) || (o11 instanceof j)) && obj13 != null) ? (androidx.compose.ui.text.style.i) o11.b(obj13) : null;
            Object obj14 = list.get(13);
            androidx.compose.runtime.saveable.d k13 = SaversKt.k(z4.f4996d);
            return new x(u11, k11, pVar, nVar, oVar, null, str, k12, aVar3, mVar, iVar, u12, iVar2, ((!Intrinsics.c(obj14, bool) || (k13 instanceof j)) && obj14 != null) ? (z4) k13.b(obj14) : null, null, null, 49184, null);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6124j = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, a0, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, a0 a0Var) {
            return CollectionsKt.h(SaversKt.y(a0Var.d(), SaversKt.v(), eVar), SaversKt.y(a0Var.a(), SaversKt.v(), eVar), SaversKt.y(a0Var.b(), SaversKt.v(), eVar), SaversKt.y(a0Var.c(), SaversKt.v(), eVar));
        }
    }, new Function1<Object, a0>() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final a0 invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            androidx.compose.runtime.saveable.d v11 = SaversKt.v();
            Boolean bool = Boolean.FALSE;
            x xVar = null;
            x xVar2 = ((!Intrinsics.c(obj2, bool) || (v11 instanceof j)) && obj2 != null) ? (x) v11.b(obj2) : null;
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d v12 = SaversKt.v();
            x xVar3 = ((!Intrinsics.c(obj3, bool) || (v12 instanceof j)) && obj3 != null) ? (x) v12.b(obj3) : null;
            Object obj4 = list.get(2);
            androidx.compose.runtime.saveable.d v13 = SaversKt.v();
            x xVar4 = ((!Intrinsics.c(obj4, bool) || (v13 instanceof j)) && obj4 != null) ? (x) v13.b(obj4) : null;
            Object obj5 = list.get(3);
            androidx.compose.runtime.saveable.d v14 = SaversKt.v();
            if ((!Intrinsics.c(obj5, bool) || (v14 instanceof j)) && obj5 != null) {
                xVar = (x) v14.b(obj5);
            }
            return new a0(xVar2, xVar3, xVar4, xVar);
        }
    });

    /* renamed from: k, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6125k = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.style.i, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, androidx.compose.ui.text.style.i iVar) {
            return Integer.valueOf(iVar.e());
        }
    }, new Function1<Object, androidx.compose.ui.text.style.i>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.style.i invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Int");
            return new androidx.compose.ui.text.style.i(((Integer) obj).intValue());
        }
    });

    /* renamed from: l, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6126l = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.style.m, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, androidx.compose.ui.text.style.m mVar) {
            return CollectionsKt.h(Float.valueOf(mVar.b()), Float.valueOf(mVar.c()));
        }
    }, new Function1<Object, androidx.compose.ui.text.style.m>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.style.m invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
            List list = (List) obj;
            return new androidx.compose.ui.text.style.m(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });

    /* renamed from: m, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6127m = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.style.n, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, androidx.compose.ui.text.style.n nVar) {
            o0.w b11 = o0.w.b(nVar.b());
            w.a aVar = o0.w.f70751b;
            return CollectionsKt.h(SaversKt.y(b11, SaversKt.t(aVar), eVar), SaversKt.y(o0.w.b(nVar.c()), SaversKt.t(aVar), eVar));
        }
    }, new Function1<Object, androidx.compose.ui.text.style.n>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.style.n invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            w.a aVar = o0.w.f70751b;
            androidx.compose.runtime.saveable.d t11 = SaversKt.t(aVar);
            Boolean bool = Boolean.FALSE;
            o0.w wVar = null;
            o0.w wVar2 = ((!Intrinsics.c(obj2, bool) || (t11 instanceof j)) && obj2 != null) ? (o0.w) t11.b(obj2) : null;
            Intrinsics.e(wVar2);
            long k11 = wVar2.k();
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d t12 = SaversKt.t(aVar);
            if ((!Intrinsics.c(obj3, bool) || (t12 instanceof j)) && obj3 != null) {
                wVar = (o0.w) t12.b(obj3);
            }
            Intrinsics.e(wVar);
            return new androidx.compose.ui.text.style.n(k11, wVar.k(), null);
        }
    });

    /* renamed from: n, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6128n = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.font.p, Object>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, androidx.compose.ui.text.font.p pVar) {
            return Integer.valueOf(pVar.h());
        }
    }, new Function1<Object, androidx.compose.ui.text.font.p>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.font.p invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Int");
            return new androidx.compose.ui.text.font.p(((Integer) obj).intValue());
        }
    });

    /* renamed from: o, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6129o = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.style.a, Object>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m167invoke8a2Sb4w((androidx.compose.runtime.saveable.e) obj, ((androidx.compose.ui.text.style.a) obj2).h());
        }

        /* renamed from: invoke-8a2Sb4w, reason: not valid java name */
        public final Object m167invoke8a2Sb4w(androidx.compose.runtime.saveable.e eVar, float f11) {
            return Float.valueOf(f11);
        }
    }, new Function1<Object, androidx.compose.ui.text.style.a>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-jTk7eUs, reason: not valid java name and merged with bridge method [inline-methods] */
        public final androidx.compose.ui.text.style.a invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Float");
            return androidx.compose.ui.text.style.a.b(androidx.compose.ui.text.style.a.c(((Float) obj).floatValue()));
        }
    });

    /* renamed from: p, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6130p = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, b0, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m173invokeFDrldGo((androidx.compose.runtime.saveable.e) obj, ((b0) obj2).n());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke-FDrldGo, reason: not valid java name */
        public final Object m173invokeFDrldGo(androidx.compose.runtime.saveable.e eVar, long j11) {
            return CollectionsKt.h(SaversKt.x(Integer.valueOf(b0.k(j11))), SaversKt.x(Integer.valueOf(b0.g(j11))));
        }
    }, new Function1<Object, b0>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
        public final b0 invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Integer num = obj2 != null ? (Integer) obj2 : null;
            Intrinsics.e(num);
            int intValue = num.intValue();
            Object obj3 = list.get(1);
            Integer num2 = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.e(num2);
            return b0.b(c0.b(intValue, num2.intValue()));
        }
    });

    /* renamed from: q, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6131q = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, z4, Object>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, z4 z4Var) {
            return CollectionsKt.h(SaversKt.y(u1.g(z4Var.c()), SaversKt.j(u1.f4733b), eVar), SaversKt.y(y.g.d(z4Var.d()), SaversKt.u(y.g.f78593b), eVar), SaversKt.x(Float.valueOf(z4Var.b())));
        }
    }, new Function1<Object, z4>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final z4 invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            androidx.compose.runtime.saveable.d j11 = SaversKt.j(u1.f4733b);
            Boolean bool = Boolean.FALSE;
            u1 u1Var = ((!Intrinsics.c(obj2, bool) || (j11 instanceof j)) && obj2 != null) ? (u1) j11.b(obj2) : null;
            Intrinsics.e(u1Var);
            long u11 = u1Var.u();
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d u12 = SaversKt.u(y.g.f78593b);
            y.g gVar = ((!Intrinsics.c(obj3, bool) || (u12 instanceof j)) && obj3 != null) ? (y.g) u12.b(obj3) : null;
            Intrinsics.e(gVar);
            long v11 = gVar.v();
            Object obj4 = list.get(2);
            Float f11 = obj4 != null ? (Float) obj4 : null;
            Intrinsics.e(f11);
            return new z4(u11, v11, f11.floatValue(), null);
        }
    });

    /* renamed from: r, reason: collision with root package name */
    private static final j f6132r = a(new Function2<androidx.compose.runtime.saveable.e, u1, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m169invoke4WTKRHQ((androidx.compose.runtime.saveable.e) obj, ((u1) obj2).u());
        }

        /* renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m169invoke4WTKRHQ(androidx.compose.runtime.saveable.e eVar, long j11) {
            return j11 == 16 ? Boolean.FALSE : Integer.valueOf(w1.j(j11));
        }
    }, new Function1<Object, u1>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final u1 invoke(Object obj) {
            long b11;
            if (Intrinsics.c(obj, Boolean.FALSE)) {
                b11 = u1.f4733b.e();
            } else {
                Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Int");
                b11 = w1.b(((Integer) obj).intValue());
            }
            return u1.g(b11);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    private static final j f6133s = a(new Function2<androidx.compose.runtime.saveable.e, o0.w, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m175invokempE4wyQ((androidx.compose.runtime.saveable.e) obj, ((o0.w) obj2).k());
        }

        /* renamed from: invoke-mpE4wyQ, reason: not valid java name */
        public final Object m175invokempE4wyQ(androidx.compose.runtime.saveable.e eVar, long j11) {
            return o0.w.e(j11, o0.w.f70751b.a()) ? Boolean.FALSE : CollectionsKt.h(SaversKt.x(Float.valueOf(o0.w.h(j11))), SaversKt.x(o0.y.d(o0.w.g(j11))));
        }
    }, new Function1<Object, o0.w>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-XNhUCwk, reason: not valid java name and merged with bridge method [inline-methods] */
        public final o0.w invoke(Object obj) {
            if (Intrinsics.c(obj, Boolean.FALSE)) {
                return o0.w.b(o0.w.f70751b.a());
            }
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f11 = obj2 != null ? (Float) obj2 : null;
            Intrinsics.e(f11);
            float floatValue = f11.floatValue();
            Object obj3 = list.get(1);
            o0.y yVar = obj3 != null ? (o0.y) obj3 : null;
            Intrinsics.e(yVar);
            return o0.w.b(o0.x.a(floatValue, yVar.j()));
        }
    });

    /* renamed from: t, reason: collision with root package name */
    private static final j f6134t = a(new Function2<androidx.compose.runtime.saveable.e, y.g, Object>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m171invokeUv8p0NA((androidx.compose.runtime.saveable.e) obj, ((y.g) obj2).v());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final Object m171invokeUv8p0NA(androidx.compose.runtime.saveable.e eVar, long j11) {
            return y.g.j(j11, y.g.f78593b.b()) ? Boolean.FALSE : CollectionsKt.h(SaversKt.x(Float.valueOf(y.g.m(j11))), SaversKt.x(Float.valueOf(y.g.n(j11))));
        }
    }, new Function1<Object, y.g>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
        public final y.g invoke(Object obj) {
            if (Intrinsics.c(obj, Boolean.FALSE)) {
                return y.g.d(y.g.f78593b.b());
            }
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f11 = obj2 != null ? (Float) obj2 : null;
            Intrinsics.e(f11);
            float floatValue = f11.floatValue();
            Object obj3 = list.get(1);
            Float f12 = obj3 != null ? (Float) obj3 : null;
            Intrinsics.e(f12);
            return y.g.d(y.h.a(floatValue, f12.floatValue()));
        }
    });

    /* renamed from: u, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6135u = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, n0.i, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, n0.i iVar) {
            List f11 = iVar.f();
            ArrayList arrayList = new ArrayList(f11.size());
            int size = f11.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(SaversKt.y((n0.h) f11.get(i11), SaversKt.r(n0.h.f70182b), eVar));
            }
            return arrayList;
        }
    }, new Function1<Object, n0.i>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final n0.i invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object obj2 = list.get(i11);
                androidx.compose.runtime.saveable.d r11 = SaversKt.r(n0.h.f70182b);
                n0.h hVar = null;
                if ((!Intrinsics.c(obj2, Boolean.FALSE) || (r11 instanceof j)) && obj2 != null) {
                    hVar = (n0.h) r11.b(obj2);
                }
                Intrinsics.e(hVar);
                arrayList.add(hVar);
            }
            return new n0.i(arrayList);
        }
    });

    /* renamed from: v, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6136v = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, n0.h, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, n0.h hVar) {
            return hVar.b();
        }
    }, new Function1<Object, n0.h>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final n0.h invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.String");
            return new n0.h((String) obj);
        }
    });

    /* loaded from: classes.dex */
    public static final class a implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f6139a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f6140b;

        a(Function2 function2, Function1 function1) {
            this.f6139a = function2;
            this.f6140b = function1;
        }

        @Override // androidx.compose.runtime.saveable.d
        public Object a(androidx.compose.runtime.saveable.e eVar, Object obj) {
            return this.f6139a.invoke(eVar, obj);
        }

        @Override // androidx.compose.runtime.saveable.d
        public Object b(Object obj) {
            return this.f6140b.invoke(obj);
        }
    }

    private static final j a(Function2 function2, Function1 function1) {
        return new a(function2, function1);
    }

    public static final androidx.compose.runtime.saveable.d h() {
        return f6115a;
    }

    public static final androidx.compose.runtime.saveable.d i() {
        return f6122h;
    }

    public static final androidx.compose.runtime.saveable.d j(u1.a aVar) {
        return f6132r;
    }

    public static final androidx.compose.runtime.saveable.d k(z4.a aVar) {
        return f6131q;
    }

    public static final androidx.compose.runtime.saveable.d l(b0.a aVar) {
        return f6130p;
    }

    public static final androidx.compose.runtime.saveable.d m(p.a aVar) {
        return f6128n;
    }

    public static final androidx.compose.runtime.saveable.d n(a.C0057a c0057a) {
        return f6129o;
    }

    public static final androidx.compose.runtime.saveable.d o(i.a aVar) {
        return f6125k;
    }

    public static final androidx.compose.runtime.saveable.d p(m.a aVar) {
        return f6126l;
    }

    public static final androidx.compose.runtime.saveable.d q(n.a aVar) {
        return f6127m;
    }

    public static final androidx.compose.runtime.saveable.d r(h.a aVar) {
        return f6136v;
    }

    public static final androidx.compose.runtime.saveable.d s(i.a aVar) {
        return f6135u;
    }

    public static final androidx.compose.runtime.saveable.d t(w.a aVar) {
        return f6133s;
    }

    public static final androidx.compose.runtime.saveable.d u(g.a aVar) {
        return f6134t;
    }

    public static final androidx.compose.runtime.saveable.d v() {
        return f6123i;
    }

    public static final androidx.compose.runtime.saveable.d w() {
        return f6124j;
    }

    public static final Object x(Object obj) {
        return obj;
    }

    public static final Object y(Object obj, androidx.compose.runtime.saveable.d dVar, androidx.compose.runtime.saveable.e eVar) {
        Object a11;
        return (obj == null || (a11 = dVar.a(eVar, obj)) == null) ? Boolean.FALSE : a11;
    }
}
