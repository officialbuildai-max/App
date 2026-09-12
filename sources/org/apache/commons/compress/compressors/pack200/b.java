package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: classes7.dex */
abstract class b extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final Object f71314a;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(OutputStream outputStream) {
        super(outputStream);
        this.f71314a = new Object();
    }
}
