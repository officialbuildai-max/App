package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class b extends c {

    /* renamed from: a, reason: collision with root package name */
    final ArrayList f72014a;

    /* renamed from: b, reason: collision with root package name */
    int f72015b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a extends b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Collection collection) {
            super(collection);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(c... cVarArr) {
            this(Arrays.asList(cVarArr));
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            for (int i11 = 0; i11 < this.f72015b; i11++) {
                if (!((c) this.f72014a.get(i11)).a(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return org.jsoup.helper.c.i(this.f72014a, " ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.jsoup.select.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0899b extends b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C0899b() {
        }

        C0899b(Collection collection) {
            if (this.f72015b > 1) {
                this.f72014a.add(new a(collection));
            } else {
                this.f72014a.addAll(collection);
            }
            d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0899b(c... cVarArr) {
            this(Arrays.asList(cVarArr));
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            for (int i11 = 0; i11 < this.f72015b; i11++) {
                if (((c) this.f72014a.get(i11)).a(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public void e(c cVar) {
            this.f72014a.add(cVar);
            d();
        }

        public String toString() {
            return org.jsoup.helper.c.i(this.f72014a, ", ");
        }
    }

    b() {
        this.f72015b = 0;
        this.f72014a = new ArrayList();
    }

    b(Collection collection) {
        this();
        this.f72014a.addAll(collection);
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(c cVar) {
        this.f72014a.set(this.f72015b - 1, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c() {
        int i11 = this.f72015b;
        if (i11 > 0) {
            return (c) this.f72014a.get(i11 - 1);
        }
        return null;
    }

    void d() {
        this.f72015b = this.f72014a.size();
    }
}
