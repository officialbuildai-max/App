package androidx.media3.exoplayer.upstream;

import androidx.media3.exoplayer.upstream.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class t {

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator f13102h = new Comparator() { // from class: androidx.media3.exoplayer.upstream.r
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g11;
            g11 = t.g((t.b) obj, (t.b) obj2);
            return g11;
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static final Comparator f13103i = new Comparator() { // from class: androidx.media3.exoplayer.upstream.s
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h11;
            h11 = t.h((t.b) obj, (t.b) obj2);
            return h11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f13104a;

    /* renamed from: e, reason: collision with root package name */
    private int f13108e;

    /* renamed from: f, reason: collision with root package name */
    private int f13109f;

    /* renamed from: g, reason: collision with root package name */
    private int f13110g;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f13106c = new b[5];

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f13105b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private int f13107d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f13111a;

        /* renamed from: b, reason: collision with root package name */
        public int f13112b;

        /* renamed from: c, reason: collision with root package name */
        public float f13113c;

        private b() {
        }
    }

    public t(int i11) {
        this.f13104a = i11;
    }

    private void d() {
        if (this.f13107d != 1) {
            Collections.sort(this.f13105b, f13102h);
            this.f13107d = 1;
        }
    }

    private void e() {
        if (this.f13107d != 0) {
            Collections.sort(this.f13105b, f13103i);
            this.f13107d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f13111a - bVar2.f13111a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f13113c, bVar2.f13113c);
    }

    public void c(int i11, float f11) {
        b bVar;
        d();
        int i12 = this.f13110g;
        if (i12 > 0) {
            b[] bVarArr = this.f13106c;
            int i13 = i12 - 1;
            this.f13110g = i13;
            bVar = bVarArr[i13];
        } else {
            bVar = new b();
        }
        int i14 = this.f13108e;
        this.f13108e = i14 + 1;
        bVar.f13111a = i14;
        bVar.f13112b = i11;
        bVar.f13113c = f11;
        this.f13105b.add(bVar);
        this.f13109f += i11;
        while (true) {
            int i15 = this.f13109f;
            int i16 = this.f13104a;
            if (i15 <= i16) {
                return;
            }
            int i17 = i15 - i16;
            b bVar2 = (b) this.f13105b.get(0);
            int i18 = bVar2.f13112b;
            if (i18 <= i17) {
                this.f13109f -= i18;
                this.f13105b.remove(0);
                int i19 = this.f13110g;
                if (i19 < 5) {
                    b[] bVarArr2 = this.f13106c;
                    this.f13110g = i19 + 1;
                    bVarArr2[i19] = bVar2;
                }
            } else {
                bVar2.f13112b = i18 - i17;
                this.f13109f -= i17;
            }
        }
    }

    public float f(float f11) {
        e();
        float f12 = f11 * this.f13109f;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f13105b.size(); i12++) {
            b bVar = (b) this.f13105b.get(i12);
            i11 += bVar.f13112b;
            if (i11 >= f12) {
                return bVar.f13113c;
            }
        }
        if (this.f13105b.isEmpty()) {
            return Float.NaN;
        }
        return ((b) this.f13105b.get(r5.size() - 1)).f13113c;
    }

    public void i() {
        this.f13105b.clear();
        this.f13107d = -1;
        this.f13108e = 0;
        this.f13109f = 0;
    }
}
