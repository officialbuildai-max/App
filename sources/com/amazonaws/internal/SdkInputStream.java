package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class SdkInputStream extends InputStream implements MetricAware {
    @Override // com.amazonaws.internal.MetricAware
    public final boolean d() {
        Closeable l11 = l();
        if (l11 instanceof MetricAware) {
            return ((MetricAware) l11).d();
        }
        return false;
    }

    protected void h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        if (Thread.interrupted()) {
            try {
                h();
            } catch (IOException e11) {
                LogFactory.b(getClass()).g("FYI", e11);
            }
            throw new AbortedException();
        }
    }

    protected abstract InputStream l();
}
