package com.google.common.hash;

import java.nio.Buffer;

/* loaded from: classes4.dex */
abstract class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Buffer buffer) {
        buffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Buffer buffer, int i11) {
        buffer.position(i11);
    }
}
