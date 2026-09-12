package androidx.datastore.preferences.protobuf;

import java.nio.Buffer;

/* loaded from: classes.dex */
abstract class y {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Buffer buffer, int i11) {
        buffer.limit(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Buffer buffer) {
        buffer.mark();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Buffer buffer, int i11) {
        buffer.position(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Buffer buffer) {
        buffer.reset();
    }
}
