package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.i1;

/* loaded from: classes7.dex */
abstract /* synthetic */ class l {
    public static final void a(q qVar, Throwable th2) {
        if (th2 != null) {
            r0 = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            if (r0 == null) {
                r0 = i1.a("Channel was consumed, consumer had failed", th2);
            }
        }
        qVar.cancel(r0);
    }
}
