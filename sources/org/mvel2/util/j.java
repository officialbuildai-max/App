package org.mvel2.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private char[] f72178a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList f72179b;

    /* renamed from: c, reason: collision with root package name */
    private Set f72180c;

    /* loaded from: classes7.dex */
    class a implements b {
        a() {
        }

        @Override // org.mvel2.util.j.b
        public int a(int i11) {
            Iterator it = j.this.f72179b.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.d(i11)) {
                    return cVar.b();
                }
            }
            return -1;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        int a(int i11);
    }

    /* loaded from: classes7.dex */
    private static class c implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        private int f72182a;

        /* renamed from: b, reason: collision with root package name */
        private int f72183b;

        /* renamed from: c, reason: collision with root package name */
        private int f72184c;

        private c(int i11, int i12, int i13) {
            this.f72182a = i11;
            this.f72183b = i12;
            this.f72184c = i13;
        }

        /* synthetic */ c(int i11, int i12, int i13, a aVar) {
            this(i11, i12, i13);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            if (cVar.f72182a >= this.f72183b) {
                return 1;
            }
            return cVar.f72183b < this.f72182a ? -1 : 0;
        }

        public int b() {
            return this.f72184c;
        }

        public boolean d(int i11) {
            return i11 >= this.f72182a && i11 <= this.f72183b;
        }
    }

    public j(char[] cArr) {
        this.f72178a = cArr;
    }

    public b b() {
        a aVar;
        this.f72179b = new ArrayList();
        this.f72180c = new TreeSet();
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (true) {
            char[] cArr = this.f72178a;
            aVar = null;
            if (i11 >= cArr.length) {
                break;
            }
            if (cArr[i11] == '\n') {
                this.f72180c.add(Integer.valueOf(i12));
                this.f72179b.add(new c(i13, i11, i12, aVar));
                i13 = i11 + 1;
                i12++;
            }
            i11++;
        }
        if (i11 > i13) {
            this.f72180c.add(Integer.valueOf(i12));
            this.f72179b.add(new c(i13, i11, i12, aVar));
        }
        return new a();
    }
}
