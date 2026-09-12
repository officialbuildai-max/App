package org.apache.tools.ant.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: classes7.dex */
public class g extends FilterOutputStream {
    public g(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
