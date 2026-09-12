package com.google.android.datatransport.runtime;

import android.content.Context;
import java.io.Closeable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class u implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        a a(Context context);

        u build();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d().close();
    }

    abstract a9.d d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract t h();
}
