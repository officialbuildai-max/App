package k0;

/* loaded from: classes2.dex */
final class c0 {

    /* renamed from: a, reason: collision with root package name */
    private final e1 f66618a;

    /* renamed from: b, reason: collision with root package name */
    private int f66619b = -1;

    /* renamed from: c, reason: collision with root package name */
    private float f66620c;

    public c0(e1 e1Var) {
        this.f66618a = e1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final float a(int r6, boolean r7, boolean r8, boolean r9) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L1f
            k0.e1 r2 = r5.f66618a
            android.text.Layout r2 = r2.h()
            int r2 = k0.e0.a(r2, r6, r7)
            k0.e1 r3 = r5.f66618a
            int r3 = r3.u(r2)
            k0.e1 r4 = r5.f66618a
            int r2 = r4.o(r2)
            if (r6 == r3) goto L21
            if (r6 != r2) goto L1f
            goto L21
        L1f:
            r2 = r1
            goto L22
        L21:
            r2 = r0
        L22:
            int r3 = r6 * 4
            if (r9 == 0) goto L2a
            if (r2 == 0) goto L2f
            r0 = r1
            goto L2f
        L2a:
            if (r2 == 0) goto L2e
            r0 = 2
            goto L2f
        L2e:
            r0 = 3
        L2f:
            int r3 = r3 + r0
            int r0 = r5.f66619b
            if (r0 != r3) goto L37
            float r6 = r5.f66620c
            return r6
        L37:
            if (r9 == 0) goto L40
            k0.e1 r9 = r5.f66618a
            float r6 = r9.y(r6, r7)
            goto L46
        L40:
            k0.e1 r9 = r5.f66618a
            float r6 = r9.A(r6, r7)
        L46:
            if (r8 == 0) goto L4c
            r5.f66619b = r3
            r5.f66620c = r6
        L4c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.c0.a(int, boolean, boolean, boolean):float");
    }

    public final float b(int i11) {
        return a(i11, false, false, true);
    }

    public final float c(int i11) {
        return a(i11, true, true, true);
    }

    public final float d(int i11) {
        return a(i11, false, false, false);
    }

    public final float e(int i11) {
        return a(i11, true, true, false);
    }
}
