package m4;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import java.util.ArrayList;
import java.util.List;
import n4.a;

/* loaded from: classes2.dex */
public class q implements s, a.b {

    /* renamed from: a, reason: collision with root package name */
    private final LottieDrawable f69414a;

    /* renamed from: b, reason: collision with root package name */
    private final String f69415b;

    /* renamed from: c, reason: collision with root package name */
    private final n4.a f69416c;

    /* renamed from: d, reason: collision with root package name */
    private r4.i f69417d;

    public q(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, r4.h hVar) {
        this.f69414a = lottieDrawable;
        this.f69415b = hVar.c();
        n4.a a11 = hVar.b().a();
        this.f69416c = a11;
        aVar.i(a11);
        a11.a(this);
    }

    private static int b(int i11, int i12) {
        int i13 = i11 / i12;
        return ((i11 ^ i12) >= 0 || i12 * i13 == i11) ? i13 : i13 - 1;
    }

    private static int d(int i11, int i12) {
        return i11 - (b(i11, i12) * i12);
    }

    private r4.i i(r4.i iVar) {
        List a11 = iVar.a();
        boolean d11 = iVar.d();
        int size = a11.size() - 1;
        int i11 = 0;
        while (size >= 0) {
            p4.a aVar = (p4.a) a11.get(size);
            p4.a aVar2 = (p4.a) a11.get(d(size - 1, a11.size()));
            PointF c11 = (size != 0 || d11) ? aVar2.c() : iVar.b();
            i11 = (((size != 0 || d11) ? aVar2.b() : c11).equals(c11) && aVar.a().equals(c11) && !(!iVar.d() && (size == 0 || size == a11.size() - 1))) ? i11 + 2 : i11 + 1;
            size--;
        }
        r4.i iVar2 = this.f69417d;
        if (iVar2 == null || iVar2.a().size() != i11) {
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList.add(new p4.a());
            }
            this.f69417d = new r4.i(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f69417d.e(d11);
        return this.f69417d;
    }

    @Override // n4.a.b
    public void a() {
        this.f69414a.invalidateSelf();
    }

    @Override // m4.c
    public void c(List list, List list2) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009c, code lost:
    
        if (r7 != (r0.size() - 1)) goto L27;
     */
    @Override // m4.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r4.i e(r4.i r19) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.q.e(r4.i):r4.i");
    }

    public n4.a g() {
        return this.f69416c;
    }
}
