package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class MultiParagraphIntrinsics implements o {

    /* renamed from: a, reason: collision with root package name */
    private final AnnotatedString f6110a;

    /* renamed from: b, reason: collision with root package name */
    private final List f6111b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f6112c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f6113d;

    /* renamed from: e, reason: collision with root package name */
    private final List f6114e;

    public MultiParagraphIntrinsics(AnnotatedString annotatedString, d0 d0Var, List list, o0.e eVar, h.b bVar) {
        AnnotatedString m11;
        List b11;
        this.f6110a = annotatedString;
        this.f6111b = list;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f6112c = LazyKt.a(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$minIntrinsicWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Object obj;
                o b12;
                List f11 = MultiParagraphIntrinsics.this.f();
                if (f11.isEmpty()) {
                    obj = null;
                } else {
                    Object obj2 = f11.get(0);
                    float c11 = ((n) obj2).b().c();
                    int n11 = CollectionsKt.n(f11);
                    int i11 = 1;
                    if (1 <= n11) {
                        while (true) {
                            Object obj3 = f11.get(i11);
                            float c12 = ((n) obj3).b().c();
                            if (Float.compare(c11, c12) < 0) {
                                obj2 = obj3;
                                c11 = c12;
                            }
                            if (i11 == n11) {
                                break;
                            }
                            i11++;
                        }
                    }
                    obj = obj2;
                }
                n nVar = (n) obj;
                return Float.valueOf((nVar == null || (b12 = nVar.b()) == null) ? 0.0f : b12.c());
            }
        });
        this.f6113d = LazyKt.a(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$maxIntrinsicWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Object obj;
                o b12;
                List f11 = MultiParagraphIntrinsics.this.f();
                if (f11.isEmpty()) {
                    obj = null;
                } else {
                    Object obj2 = f11.get(0);
                    float a11 = ((n) obj2).b().a();
                    int n11 = CollectionsKt.n(f11);
                    int i11 = 1;
                    if (1 <= n11) {
                        while (true) {
                            Object obj3 = f11.get(i11);
                            float a12 = ((n) obj3).b().a();
                            if (Float.compare(a11, a12) < 0) {
                                obj2 = obj3;
                                a11 = a12;
                            }
                            if (i11 == n11) {
                                break;
                            }
                            i11++;
                        }
                    }
                    obj = obj2;
                }
                n nVar = (n) obj;
                return Float.valueOf((nVar == null || (b12 = nVar.b()) == null) ? 0.0f : b12.a());
            }
        });
        r K = d0Var.K();
        List l11 = d.l(annotatedString, K);
        ArrayList arrayList = new ArrayList(l11.size());
        int size = l11.size();
        for (int i11 = 0; i11 < size; i11++) {
            AnnotatedString.c cVar = (AnnotatedString.c) l11.get(i11);
            m11 = d.m(annotatedString, cVar.f(), cVar.d());
            r h11 = h((r) cVar.e(), K);
            String i12 = m11.i();
            d0 H = d0Var.H(h11);
            List g11 = m11.g();
            b11 = h.b(g(), cVar.f(), cVar.d());
            arrayList.add(new n(p.a(i12, H, g11, b11, eVar, bVar), cVar.f(), cVar.d()));
        }
        this.f6114e = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r h(r rVar, r rVar2) {
        r a11;
        if (!androidx.compose.ui.text.style.j.j(rVar.i(), androidx.compose.ui.text.style.j.f6489b.f())) {
            return rVar;
        }
        a11 = rVar.a((r22 & 1) != 0 ? rVar.f6419a : 0, (r22 & 2) != 0 ? rVar.f6420b : rVar2.i(), (r22 & 4) != 0 ? rVar.f6421c : 0L, (r22 & 8) != 0 ? rVar.f6422d : null, (r22 & 16) != 0 ? rVar.f6423e : null, (r22 & 32) != 0 ? rVar.f6424f : null, (r22 & 64) != 0 ? rVar.f6425g : 0, (r22 & 128) != 0 ? rVar.f6426h : 0, (r22 & 256) != 0 ? rVar.f6427i : null);
        return a11;
    }

    @Override // androidx.compose.ui.text.o
    public float a() {
        return ((Number) this.f6113d.getValue()).floatValue();
    }

    @Override // androidx.compose.ui.text.o
    public boolean b() {
        List list = this.f6114e;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((n) list.get(i11)).b().b()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.text.o
    public float c() {
        return ((Number) this.f6112c.getValue()).floatValue();
    }

    public final AnnotatedString e() {
        return this.f6110a;
    }

    public final List f() {
        return this.f6114e;
    }

    public final List g() {
        return this.f6111b;
    }
}
