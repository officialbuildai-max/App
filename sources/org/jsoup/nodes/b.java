package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;

/* loaded from: classes7.dex */
public class b implements Iterable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f71876d = new String[0];

    /* renamed from: a, reason: collision with root package name */
    private int f71877a = 0;

    /* renamed from: b, reason: collision with root package name */
    String[] f71878b;

    /* renamed from: c, reason: collision with root package name */
    String[] f71879c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        int f71880a = 0;

        a() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.jsoup.nodes.a next() {
            b bVar = b.this;
            String[] strArr = bVar.f71878b;
            int i11 = this.f71880a;
            org.jsoup.nodes.a aVar = new org.jsoup.nodes.a(strArr[i11], bVar.f71879c[i11], bVar);
            this.f71880a++;
            return aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f71880a < b.this.f71877a;
        }

        @Override // java.util.Iterator
        public void remove() {
            b bVar = b.this;
            int i11 = this.f71880a - 1;
            this.f71880a = i11;
            bVar.z(i11);
        }
    }

    public b() {
        String[] strArr = f71876d;
        this.f71878b = strArr;
        this.f71879c = strArr;
    }

    private void c(String str, String str2) {
        g(this.f71877a + 1);
        String[] strArr = this.f71878b;
        int i11 = this.f71877a;
        strArr[i11] = str;
        this.f71879c[i11] = str2;
        this.f71877a = i11 + 1;
    }

    private void g(int i11) {
        org.jsoup.helper.d.d(i11 >= this.f71877a);
        String[] strArr = this.f71878b;
        int length = strArr.length;
        if (length >= i11) {
            return;
        }
        int i12 = length >= 4 ? this.f71877a * 2 : 4;
        if (i11 <= i12) {
            i11 = i12;
        }
        this.f71878b = m(strArr, i11);
        this.f71879c = m(this.f71879c, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(String str) {
        return str == null ? "" : str;
    }

    private static String[] m(String[] strArr, int i11) {
        String[] strArr2 = new String[i11];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i11));
        return strArr2;
    }

    private int u(String str) {
        org.jsoup.helper.d.j(str);
        for (int i11 = 0; i11 < this.f71877a; i11++) {
            if (str.equalsIgnoreCase(this.f71878b[i11])) {
                return i11;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i11) {
        org.jsoup.helper.d.b(i11 >= this.f71877a);
        int i12 = (this.f71877a - i11) - 1;
        if (i12 > 0) {
            String[] strArr = this.f71878b;
            int i13 = i11 + 1;
            System.arraycopy(strArr, i13, strArr, i11, i12);
            String[] strArr2 = this.f71879c;
            System.arraycopy(strArr2, i13, strArr2, i11, i12);
        }
        int i14 = this.f71877a - 1;
        this.f71877a = i14;
        this.f71878b[i14] = null;
        this.f71879c[i14] = null;
    }

    public void A(String str) {
        int t11 = t(str);
        if (t11 != -1) {
            z(t11);
        }
    }

    public void B(String str) {
        int u11 = u(str);
        if (u11 != -1) {
            z(u11);
        }
    }

    public void e(b bVar) {
        if (bVar.size() == 0) {
            return;
        }
        g(this.f71877a + bVar.f71877a);
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            x((org.jsoup.nodes.a) it.next());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f71877a == bVar.f71877a && Arrays.equals(this.f71878b, bVar.f71878b)) {
            return Arrays.equals(this.f71879c, bVar.f71879c);
        }
        return false;
    }

    public List f() {
        ArrayList arrayList = new ArrayList(this.f71877a);
        for (int i11 = 0; i11 < this.f71877a; i11++) {
            arrayList.add(this.f71879c[i11] == null ? new c(this.f71878b[i11]) : new org.jsoup.nodes.a(this.f71878b[i11], this.f71879c[i11], this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int hashCode() {
        return (((this.f71877a * 31) + Arrays.hashCode(this.f71878b)) * 31) + Arrays.hashCode(this.f71879c);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f71877a = this.f71877a;
            this.f71878b = m(this.f71878b, this.f71877a);
            this.f71879c = m(this.f71879c, this.f71877a);
            return bVar;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public String n(String str) {
        int t11 = t(str);
        return t11 == -1 ? "" : j(this.f71879c[t11]);
    }

    public String o(String str) {
        int u11 = u(str);
        return u11 == -1 ? "" : j(this.f71879c[u11]);
    }

    public boolean p(String str) {
        return t(str) != -1;
    }

    public boolean q(String str) {
        return u(str) != -1;
    }

    public String r() {
        StringBuilder sb2 = new StringBuilder();
        try {
            s(sb2, new Document("").g1());
            return sb2.toString();
        } catch (IOException e11) {
            throw new SerializationException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(Appendable appendable, Document.OutputSettings outputSettings) {
        int i11 = this.f71877a;
        for (int i12 = 0; i12 < i11; i12++) {
            String str = this.f71878b[i12];
            String str2 = this.f71879c[i12];
            appendable.append(' ').append(str);
            if (!org.jsoup.nodes.a.k(str, str2, outputSettings)) {
                appendable.append("=\"");
                if (str2 == null) {
                    str2 = "";
                }
                Entities.e(appendable, str2, outputSettings, true, false, false);
                appendable.append('\"');
            }
        }
    }

    public int size() {
        return this.f71877a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(String str) {
        org.jsoup.helper.d.j(str);
        for (int i11 = 0; i11 < this.f71877a; i11++) {
            if (str.equals(this.f71878b[i11])) {
                return i11;
            }
        }
        return -1;
    }

    public String toString() {
        return r();
    }

    public void v() {
        for (int i11 = 0; i11 < this.f71877a; i11++) {
            String[] strArr = this.f71878b;
            strArr[i11] = e10.b.a(strArr[i11]);
        }
    }

    public b w(String str, String str2) {
        int t11 = t(str);
        if (t11 != -1) {
            this.f71879c[t11] = str2;
        } else {
            c(str, str2);
        }
        return this;
    }

    public b x(org.jsoup.nodes.a aVar) {
        org.jsoup.helper.d.j(aVar);
        w(aVar.getKey(), aVar.getValue());
        aVar.f71875c = this;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, String str2) {
        int u11 = u(str);
        if (u11 == -1) {
            c(str, str2);
            return;
        }
        this.f71879c[u11] = str2;
        if (this.f71878b[u11].equals(str)) {
            return;
        }
        this.f71878b[u11] = str;
    }
}
