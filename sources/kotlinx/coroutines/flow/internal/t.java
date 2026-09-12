package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class t extends SharedFlowImpl implements i1 {
    public t(int i11) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        b(Integer.valueOf(i11));
    }

    @Override // kotlinx.coroutines.flow.i1
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(((Number) M()).intValue());
        }
        return valueOf;
    }

    public final boolean a0(int i11) {
        boolean b11;
        synchronized (this) {
            b11 = b(Integer.valueOf(((Number) M()).intValue() + i11));
        }
        return b11;
    }
}
