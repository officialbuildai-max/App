package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class a implements kotlinx.serialization.b {
    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void i(a aVar, e00.c cVar, int i11, Object obj, boolean z10, int i12, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        aVar.h(cVar, i11, obj, z10);
    }

    private final int j(e00.c cVar, Object obj) {
        int k11 = cVar.k(getDescriptor());
        c(obj, k11);
        return k11;
    }

    protected abstract Object a();

    protected abstract int b(Object obj);

    protected abstract void c(Object obj, int i11);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Iterator d(Object obj);

    @Override // kotlinx.serialization.a
    public Object deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        return f(decoder, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int e(Object obj);

    public final Object f(e00.e decoder, Object obj) {
        Object a11;
        Intrinsics.h(decoder, "decoder");
        if (obj == null || (a11 = k(obj)) == null) {
            a11 = a();
        }
        int b11 = b(a11);
        e00.c b12 = decoder.b(getDescriptor());
        if (!b12.p()) {
            while (true) {
                int o11 = b12.o(getDescriptor());
                if (o11 == -1) {
                    break;
                }
                i(this, b12, b11 + o11, a11, false, 8, null);
            }
        } else {
            g(b12, a11, b11, j(b12, a11));
        }
        b12.c(getDescriptor());
        return l(a11);
    }

    protected abstract void g(e00.c cVar, Object obj, int i11, int i12);

    protected abstract void h(e00.c cVar, int i11, Object obj, boolean z10);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object k(Object obj);

    protected abstract Object l(Object obj);
}
