package kotlinx.coroutines;

/* loaded from: classes7.dex */
public abstract class a2 extends i0 {
    public abstract a2 d();

    @Override // kotlinx.coroutines.i0
    public i0 limitedParallelism(int i11, String str) {
        kotlinx.coroutines.internal.i.a(i11);
        return kotlinx.coroutines.internal.i.b(this, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String p() {
        a2 a2Var;
        a2 c11 = y0.c();
        if (this == c11) {
            return "Dispatchers.Main";
        }
        try {
            a2Var = c11.d();
        } catch (UnsupportedOperationException unused) {
            a2Var = null;
        }
        if (this == a2Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        String p11 = p();
        if (p11 != null) {
            return p11;
        }
        return p0.a(this) + '@' + p0.b(this);
    }
}
