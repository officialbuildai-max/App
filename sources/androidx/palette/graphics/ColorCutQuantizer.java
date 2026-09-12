package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.palette.graphics.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ColorCutQuantizer {

    /* renamed from: g, reason: collision with root package name */
    private static final Comparator f14048g = new Comparator<a>() { // from class: androidx.palette.graphics.ColorCutQuantizer.1
        @Override // java.util.Comparator
        public int compare(a aVar, a aVar2) {
            return aVar2.g() - aVar.g();
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final int[] f14049a;

    /* renamed from: b, reason: collision with root package name */
    final int[] f14050b;

    /* renamed from: c, reason: collision with root package name */
    final List f14051c;

    /* renamed from: e, reason: collision with root package name */
    final a.c[] f14053e;

    /* renamed from: f, reason: collision with root package name */
    private final float[] f14054f = new float[3];

    /* renamed from: d, reason: collision with root package name */
    final TimingLogger f14052d = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private int f14055a;

        /* renamed from: b, reason: collision with root package name */
        private int f14056b;

        /* renamed from: c, reason: collision with root package name */
        private int f14057c;

        /* renamed from: d, reason: collision with root package name */
        private int f14058d;

        /* renamed from: e, reason: collision with root package name */
        private int f14059e;

        /* renamed from: f, reason: collision with root package name */
        private int f14060f;

        /* renamed from: g, reason: collision with root package name */
        private int f14061g;

        /* renamed from: h, reason: collision with root package name */
        private int f14062h;

        /* renamed from: i, reason: collision with root package name */
        private int f14063i;

        a(int i11, int i12) {
            this.f14055a = i11;
            this.f14056b = i12;
            c();
        }

        final boolean a() {
            return e() > 1;
        }

        final int b() {
            int f11 = f();
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f14049a;
            int[] iArr2 = colorCutQuantizer.f14050b;
            ColorCutQuantizer.e(iArr, f11, this.f14055a, this.f14056b);
            Arrays.sort(iArr, this.f14055a, this.f14056b + 1);
            ColorCutQuantizer.e(iArr, f11, this.f14055a, this.f14056b);
            int i11 = this.f14057c / 2;
            int i12 = this.f14055a;
            int i13 = 0;
            while (true) {
                int i14 = this.f14056b;
                if (i12 > i14) {
                    return this.f14055a;
                }
                i13 += iArr2[iArr[i12]];
                if (i13 >= i11) {
                    return Math.min(i14 - 1, i12);
                }
                i12++;
            }
        }

        final void c() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f14049a;
            int[] iArr2 = colorCutQuantizer.f14050b;
            int i11 = Integer.MAX_VALUE;
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE;
            int i15 = 0;
            int i16 = Integer.MAX_VALUE;
            int i17 = Integer.MAX_VALUE;
            for (int i18 = this.f14055a; i18 <= this.f14056b; i18++) {
                int i19 = iArr[i18];
                i15 += iArr2[i19];
                int k11 = ColorCutQuantizer.k(i19);
                int j11 = ColorCutQuantizer.j(i19);
                int i20 = ColorCutQuantizer.i(i19);
                if (k11 > i12) {
                    i12 = k11;
                }
                if (k11 < i11) {
                    i11 = k11;
                }
                if (j11 > i13) {
                    i13 = j11;
                }
                if (j11 < i16) {
                    i16 = j11;
                }
                if (i20 > i14) {
                    i14 = i20;
                }
                if (i20 < i17) {
                    i17 = i20;
                }
            }
            this.f14058d = i11;
            this.f14059e = i12;
            this.f14060f = i16;
            this.f14061g = i13;
            this.f14062h = i17;
            this.f14063i = i14;
            this.f14057c = i15;
        }

        final a.e d() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f14049a;
            int[] iArr2 = colorCutQuantizer.f14050b;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = this.f14055a; i15 <= this.f14056b; i15++) {
                int i16 = iArr[i15];
                int i17 = iArr2[i16];
                i12 += i17;
                i11 += ColorCutQuantizer.k(i16) * i17;
                i13 += ColorCutQuantizer.j(i16) * i17;
                i14 += i17 * ColorCutQuantizer.i(i16);
            }
            float f11 = i12;
            return new a.e(ColorCutQuantizer.b(Math.round(i11 / f11), Math.round(i13 / f11), Math.round(i14 / f11)), i12);
        }

        final int e() {
            return (this.f14056b + 1) - this.f14055a;
        }

        final int f() {
            int i11 = this.f14059e - this.f14058d;
            int i12 = this.f14061g - this.f14060f;
            int i13 = this.f14063i - this.f14062h;
            if (i11 < i12 || i11 < i13) {
                return (i12 < i11 || i12 < i13) ? -1 : -2;
            }
            return -3;
        }

        final int g() {
            return ((this.f14059e - this.f14058d) + 1) * ((this.f14061g - this.f14060f) + 1) * ((this.f14063i - this.f14062h) + 1);
        }

        final a h() {
            if (!a()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int b11 = b();
            a aVar = new a(b11 + 1, this.f14056b);
            this.f14056b = b11;
            c();
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorCutQuantizer(int[] iArr, int i11, a.c[] cVarArr) {
        this.f14053e = cVarArr;
        int[] iArr2 = new int[32768];
        this.f14050b = iArr2;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            int g11 = g(iArr[i12]);
            iArr[i12] = g11;
            iArr2[g11] = iArr2[g11] + 1;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < 32768; i14++) {
            if (iArr2[i14] > 0 && l(i14)) {
                iArr2[i14] = 0;
            }
            if (iArr2[i14] > 0) {
                i13++;
            }
        }
        int[] iArr3 = new int[i13];
        this.f14049a = iArr3;
        int i15 = 0;
        for (int i16 = 0; i16 < 32768; i16++) {
            if (iArr2[i16] > 0) {
                iArr3[i15] = i16;
                i15++;
            }
        }
        if (i13 > i11) {
            this.f14051c = h(i11);
            return;
        }
        this.f14051c = new ArrayList();
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = iArr3[i17];
            this.f14051c.add(new a.e(a(i18), iArr2[i18]));
        }
    }

    private static int a(int i11) {
        return b(k(i11), j(i11), i(i11));
    }

    static int b(int i11, int i12, int i13) {
        return Color.rgb(f(i11, 5, 8), f(i12, 5, 8), f(i13, 5, 8));
    }

    private List c(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            a.e d11 = ((a) it.next()).d();
            if (!n(d11)) {
                arrayList.add(d11);
            }
        }
        return arrayList;
    }

    static void e(int[] iArr, int i11, int i12, int i13) {
        if (i11 == -2) {
            while (i12 <= i13) {
                int i14 = iArr[i12];
                iArr[i12] = i(i14) | (j(i14) << 10) | (k(i14) << 5);
                i12++;
            }
            return;
        }
        if (i11 != -1) {
            return;
        }
        while (i12 <= i13) {
            int i15 = iArr[i12];
            iArr[i12] = k(i15) | (i(i15) << 10) | (j(i15) << 5);
            i12++;
        }
    }

    private static int f(int i11, int i12, int i13) {
        return (i13 > i12 ? i11 << (i13 - i12) : i11 >> (i12 - i13)) & ((1 << i13) - 1);
    }

    private static int g(int i11) {
        return f(Color.blue(i11), 8, 5) | (f(Color.red(i11), 8, 5) << 10) | (f(Color.green(i11), 8, 5) << 5);
    }

    private List h(int i11) {
        PriorityQueue priorityQueue = new PriorityQueue(i11, f14048g);
        priorityQueue.offer(new a(0, this.f14049a.length - 1));
        o(priorityQueue, i11);
        return c(priorityQueue);
    }

    static int i(int i11) {
        return i11 & 31;
    }

    static int j(int i11) {
        return (i11 >> 5) & 31;
    }

    static int k(int i11) {
        return (i11 >> 10) & 31;
    }

    private boolean l(int i11) {
        int a11 = a(i11);
        z0.b.h(a11, this.f14054f);
        return m(a11, this.f14054f);
    }

    private boolean m(int i11, float[] fArr) {
        a.c[] cVarArr = this.f14053e;
        if (cVarArr != null && cVarArr.length > 0) {
            int length = cVarArr.length;
            for (int i12 = 0; i12 < length; i12++) {
                if (!this.f14053e[i12].a(i11, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean n(a.e eVar) {
        return m(eVar.e(), eVar.c());
    }

    private void o(PriorityQueue priorityQueue, int i11) {
        a aVar;
        while (priorityQueue.size() < i11 && (aVar = (a) priorityQueue.poll()) != null && aVar.a()) {
            priorityQueue.offer(aVar.h());
            priorityQueue.offer(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List d() {
        return this.f14051c;
    }
}
