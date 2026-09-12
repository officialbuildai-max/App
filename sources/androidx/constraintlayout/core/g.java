package androidx.constraintlayout.core;

/* loaded from: classes.dex */
class g implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f6774a;

    /* renamed from: b, reason: collision with root package name */
    private int f6775b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f6774a = new Object[i11];
    }

    @Override // androidx.constraintlayout.core.f
    public void a(Object[] objArr, int i11) {
        if (i11 > objArr.length) {
            i11 = objArr.length;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            Object obj = objArr[i12];
            int i13 = this.f6775b;
            Object[] objArr2 = this.f6774a;
            if (i13 < objArr2.length) {
                objArr2[i13] = obj;
                this.f6775b = i13 + 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.f
    public Object acquire() {
        int i11 = this.f6775b;
        if (i11 <= 0) {
            return null;
        }
        int i12 = i11 - 1;
        Object[] objArr = this.f6774a;
        Object obj = objArr[i12];
        objArr[i12] = null;
        this.f6775b = i11 - 1;
        return obj;
    }

    @Override // androidx.constraintlayout.core.f
    public boolean release(Object obj) {
        int i11 = this.f6775b;
        Object[] objArr = this.f6774a;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = obj;
        this.f6775b = i11 + 1;
        return true;
    }
}
