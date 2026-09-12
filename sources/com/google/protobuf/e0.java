package com.google.protobuf;

import java.nio.Buffer;

/* loaded from: classes4.dex */
final class e0 {
    private e0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clear(Buffer buffer) {
        buffer.clear();
    }

    static void flip(Buffer buffer) {
        buffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void limit(Buffer buffer, int i11) {
        buffer.limit(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void mark(Buffer buffer) {
        buffer.mark();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void position(Buffer buffer, int i11) {
        buffer.position(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reset(Buffer buffer) {
        buffer.reset();
    }
}
