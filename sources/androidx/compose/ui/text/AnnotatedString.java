package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AnnotatedString implements CharSequence {

    /* renamed from: e, reason: collision with root package name */
    public static final b f6083e = new b(null);

    /* renamed from: f, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6084f = SaversKt.h();

    /* renamed from: a, reason: collision with root package name */
    private final String f6085a;

    /* renamed from: b, reason: collision with root package name */
    private final List f6086b;

    /* renamed from: c, reason: collision with root package name */
    private final List f6087c;

    /* renamed from: d, reason: collision with root package name */
    private final List f6088d;

    /* loaded from: classes.dex */
    public static final class a implements Appendable {

        /* renamed from: a, reason: collision with root package name */
        private final StringBuilder f6089a;

        /* renamed from: b, reason: collision with root package name */
        private final List f6090b;

        /* renamed from: c, reason: collision with root package name */
        private final List f6091c;

        /* renamed from: d, reason: collision with root package name */
        private final List f6092d;

        /* renamed from: e, reason: collision with root package name */
        private final List f6093e;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: androidx.compose.ui.text.AnnotatedString$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0053a {

            /* renamed from: a, reason: collision with root package name */
            private final Object f6094a;

            /* renamed from: b, reason: collision with root package name */
            private final int f6095b;

            /* renamed from: c, reason: collision with root package name */
            private int f6096c;

            /* renamed from: d, reason: collision with root package name */
            private final String f6097d;

            public C0053a(Object obj, int i11, int i12, String str) {
                this.f6094a = obj;
                this.f6095b = i11;
                this.f6096c = i12;
                this.f6097d = str;
            }

            public /* synthetic */ C0053a(Object obj, int i11, int i12, String str, int i13, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i11, (i13 & 4) != 0 ? Integer.MIN_VALUE : i12, (i13 & 8) != 0 ? "" : str);
            }

            public final c a(int i11) {
                int i12 = this.f6096c;
                if (i12 != Integer.MIN_VALUE) {
                    i11 = i12;
                }
                if (i11 != Integer.MIN_VALUE) {
                    return new c(this.f6094a, this.f6095b, i11, this.f6097d);
                }
                throw new IllegalStateException("Item.end should be set first");
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0053a)) {
                    return false;
                }
                C0053a c0053a = (C0053a) obj;
                return Intrinsics.c(this.f6094a, c0053a.f6094a) && this.f6095b == c0053a.f6095b && this.f6096c == c0053a.f6096c && Intrinsics.c(this.f6097d, c0053a.f6097d);
            }

            public int hashCode() {
                Object obj = this.f6094a;
                return ((((((obj == null ? 0 : obj.hashCode()) * 31) + this.f6095b) * 31) + this.f6096c) * 31) + this.f6097d.hashCode();
            }

            public String toString() {
                return "MutableRange(item=" + this.f6094a + ", start=" + this.f6095b + ", end=" + this.f6096c + ", tag=" + this.f6097d + ')';
            }
        }

        public a() {
            this(0, 1, null);
        }

        public a(int i11) {
            this.f6089a = new StringBuilder(i11);
            this.f6090b = new ArrayList();
            this.f6091c = new ArrayList();
            this.f6092d = new ArrayList();
            this.f6093e = new ArrayList();
        }

        public /* synthetic */ a(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 16 : i11);
        }

        public a(AnnotatedString annotatedString) {
            this(0, 1, null);
            f(annotatedString);
        }

        public final void a(r rVar, int i11, int i12) {
            this.f6091c.add(new C0053a(rVar, i11, i12, null, 8, null));
        }

        public final void b(x xVar, int i11, int i12) {
            this.f6090b.add(new C0053a(xVar, i11, i12, null, 8, null));
        }

        @Override // java.lang.Appendable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a append(char c11) {
            this.f6089a.append(c11);
            return this;
        }

        @Override // java.lang.Appendable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a append(CharSequence charSequence) {
            if (charSequence instanceof AnnotatedString) {
                f((AnnotatedString) charSequence);
            } else {
                this.f6089a.append(charSequence);
            }
            return this;
        }

        @Override // java.lang.Appendable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a append(CharSequence charSequence, int i11, int i12) {
            if (charSequence instanceof AnnotatedString) {
                g((AnnotatedString) charSequence, i11, i12);
            } else {
                this.f6089a.append(charSequence, i11, i12);
            }
            return this;
        }

        public final void f(AnnotatedString annotatedString) {
            int length = this.f6089a.length();
            this.f6089a.append(annotatedString.i());
            List h11 = annotatedString.h();
            if (h11 != null) {
                int size = h11.size();
                for (int i11 = 0; i11 < size; i11++) {
                    c cVar = (c) h11.get(i11);
                    b((x) cVar.e(), cVar.f() + length, cVar.d() + length);
                }
            }
            List f11 = annotatedString.f();
            if (f11 != null) {
                int size2 = f11.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    c cVar2 = (c) f11.get(i12);
                    a((r) cVar2.e(), cVar2.f() + length, cVar2.d() + length);
                }
            }
            List b11 = annotatedString.b();
            if (b11 != null) {
                int size3 = b11.size();
                for (int i13 = 0; i13 < size3; i13++) {
                    c cVar3 = (c) b11.get(i13);
                    this.f6092d.add(new C0053a(cVar3.e(), cVar3.f() + length, cVar3.d() + length, cVar3.g()));
                }
            }
        }

        public final void g(AnnotatedString annotatedString, int i11, int i12) {
            int length = this.f6089a.length();
            this.f6089a.append((CharSequence) annotatedString.i(), i11, i12);
            List d11 = d.d(annotatedString, i11, i12);
            if (d11 != null) {
                int size = d11.size();
                for (int i13 = 0; i13 < size; i13++) {
                    c cVar = (c) d11.get(i13);
                    b((x) cVar.e(), cVar.f() + length, cVar.d() + length);
                }
            }
            List c11 = d.c(annotatedString, i11, i12);
            if (c11 != null) {
                int size2 = c11.size();
                for (int i14 = 0; i14 < size2; i14++) {
                    c cVar2 = (c) c11.get(i14);
                    a((r) cVar2.e(), cVar2.f() + length, cVar2.d() + length);
                }
            }
            List b11 = d.b(annotatedString, i11, i12);
            if (b11 != null) {
                int size3 = b11.size();
                for (int i15 = 0; i15 < size3; i15++) {
                    c cVar3 = (c) b11.get(i15);
                    this.f6092d.add(new C0053a(cVar3.e(), cVar3.f() + length, cVar3.d() + length, cVar3.g()));
                }
            }
        }

        public final AnnotatedString h() {
            String sb2 = this.f6089a.toString();
            List list = this.f6090b;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(((C0053a) list.get(i11)).a(this.f6089a.length()));
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            List list2 = this.f6091c;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                arrayList2.add(((C0053a) list2.get(i12)).a(this.f6089a.length()));
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            List list3 = this.f6092d;
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size3 = list3.size();
            for (int i13 = 0; i13 < size3; i13++) {
                arrayList3.add(((C0053a) list3.get(i13)).a(this.f6089a.length()));
            }
            return new AnnotatedString(sb2, arrayList, arrayList2, arrayList3.isEmpty() ? null : arrayList3);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Object f6098a;

        /* renamed from: b, reason: collision with root package name */
        private final int f6099b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6100c;

        /* renamed from: d, reason: collision with root package name */
        private final String f6101d;

        public c(Object obj, int i11, int i12) {
            this(obj, i11, i12, "");
        }

        public c(Object obj, int i11, int i12, String str) {
            this.f6098a = obj;
            this.f6099b = i11;
            this.f6100c = i12;
            this.f6101d = str;
            if (i11 > i12) {
                throw new IllegalArgumentException("Reversed range is not supported");
            }
        }

        public final Object a() {
            return this.f6098a;
        }

        public final int b() {
            return this.f6099b;
        }

        public final int c() {
            return this.f6100c;
        }

        public final int d() {
            return this.f6100c;
        }

        public final Object e() {
            return this.f6098a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.c(this.f6098a, cVar.f6098a) && this.f6099b == cVar.f6099b && this.f6100c == cVar.f6100c && Intrinsics.c(this.f6101d, cVar.f6101d);
        }

        public final int f() {
            return this.f6099b;
        }

        public final String g() {
            return this.f6101d;
        }

        public int hashCode() {
            Object obj = this.f6098a;
            return ((((((obj == null ? 0 : obj.hashCode()) * 31) + this.f6099b) * 31) + this.f6100c) * 31) + this.f6101d.hashCode();
        }

        public String toString() {
            return "Range(item=" + this.f6098a + ", start=" + this.f6099b + ", end=" + this.f6100c + ", tag=" + this.f6101d + ')';
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AnnotatedString(java.lang.String r3, java.util.List r4, java.util.List r5) {
        /*
            r2 = this;
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r0 = r4.isEmpty()
            r1 = 0
            if (r0 == 0) goto La
            r4 = r1
        La:
            java.util.List r4 = (java.util.List) r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L15
            r5 = r1
        L15:
            java.util.List r5 = (java.util.List) r5
            r2.<init>(r3, r4, r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedString.<init>(java.lang.String, java.util.List, java.util.List):void");
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? CollectionsKt.l() : list, (i11 & 4) != 0 ? CollectionsKt.l() : list2);
    }

    public AnnotatedString(String str, List list, List list2, List list3) {
        List I0;
        this.f6085a = str;
        this.f6086b = list;
        this.f6087c = list2;
        this.f6088d = list3;
        if (list2 == null || (I0 = CollectionsKt.I0(list2, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(Integer.valueOf(((AnnotatedString.c) t11).f()), Integer.valueOf(((AnnotatedString.c) t12).f()));
            }
        })) == null) {
            return;
        }
        int size = I0.size();
        int i11 = -1;
        for (int i12 = 0; i12 < size; i12++) {
            c cVar = (c) I0.get(i12);
            if (cVar.f() < i11) {
                throw new IllegalArgumentException("ParagraphStyle should not overlap");
            }
            if (cVar.d() > this.f6085a.length()) {
                throw new IllegalArgumentException(("ParagraphStyle range [" + cVar.f() + ", " + cVar.d() + ") is out of boundary").toString());
            }
            i11 = cVar.d();
        }
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : list2, (i11 & 8) != 0 ? null : list3);
    }

    public char a(int i11) {
        return this.f6085a.charAt(i11);
    }

    public final List b() {
        return this.f6088d;
    }

    public int c() {
        return this.f6085a.length();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i11) {
        return a(i11);
    }

    public final List d(int i11, int i12) {
        List l11;
        List list = this.f6088d;
        if (list != null) {
            l11 = new ArrayList(list.size());
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                Object obj = list.get(i13);
                c cVar = (c) obj;
                if ((cVar.e() instanceof f) && d.k(i11, i12, cVar.f(), cVar.d())) {
                    l11.add(obj);
                }
            }
        } else {
            l11 = CollectionsKt.l();
        }
        Intrinsics.f(l11, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return l11;
    }

    public final List e() {
        List list = this.f6087c;
        return list == null ? CollectionsKt.l() : list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        return Intrinsics.c(this.f6085a, annotatedString.f6085a) && Intrinsics.c(this.f6086b, annotatedString.f6086b) && Intrinsics.c(this.f6087c, annotatedString.f6087c) && Intrinsics.c(this.f6088d, annotatedString.f6088d);
    }

    public final List f() {
        return this.f6087c;
    }

    public final List g() {
        List list = this.f6086b;
        return list == null ? CollectionsKt.l() : list;
    }

    public final List h() {
        return this.f6086b;
    }

    public int hashCode() {
        int hashCode = this.f6085a.hashCode() * 31;
        List list = this.f6086b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List list2 = this.f6087c;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List list3 = this.f6088d;
        return hashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    public final String i() {
        return this.f6085a;
    }

    public final List j(int i11, int i12) {
        List l11;
        List list = this.f6088d;
        if (list != null) {
            l11 = new ArrayList(list.size());
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                Object obj = list.get(i13);
                c cVar = (c) obj;
                if ((cVar.e() instanceof f0) && d.k(i11, i12, cVar.f(), cVar.d())) {
                    l11.add(obj);
                }
            }
        } else {
            l11 = CollectionsKt.l();
        }
        Intrinsics.f(l11, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return l11;
    }

    public final List k(int i11, int i12) {
        List l11;
        List list = this.f6088d;
        if (list != null) {
            l11 = new ArrayList(list.size());
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                Object obj = list.get(i13);
                c cVar = (c) obj;
                if ((cVar.e() instanceof g0) && d.k(i11, i12, cVar.f(), cVar.d())) {
                    l11.add(obj);
                }
            }
        } else {
            l11 = CollectionsKt.l();
        }
        Intrinsics.f(l11, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return l11;
    }

    public final boolean l(AnnotatedString annotatedString) {
        return Intrinsics.c(this.f6088d, annotatedString.f6088d);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return c();
    }

    public final boolean m(int i11, int i12) {
        List list = this.f6088d;
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            c cVar = (c) list.get(i13);
            if ((cVar.e() instanceof f) && d.k(i11, i12, cVar.f(), cVar.d())) {
                return true;
            }
        }
        return false;
    }

    public final AnnotatedString n(AnnotatedString annotatedString) {
        a aVar = new a(this);
        aVar.f(annotatedString);
        return aVar.h();
    }

    @Override // java.lang.CharSequence
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public AnnotatedString subSequence(int i11, int i12) {
        if (i11 <= i12) {
            if (i11 == 0 && i12 == this.f6085a.length()) {
                return this;
            }
            String substring = this.f6085a.substring(i11, i12);
            Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return new AnnotatedString(substring, d.a(this.f6086b, i11, i12), d.a(this.f6087c, i11, i12), d.a(this.f6088d, i11, i12));
        }
        throw new IllegalArgumentException(("start (" + i11 + ") should be less or equal to end (" + i12 + ')').toString());
    }

    public final AnnotatedString p(long j11) {
        return subSequence(b0.j(j11), b0.i(j11));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f6085a;
    }
}
