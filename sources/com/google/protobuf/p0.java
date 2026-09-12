package com.google.protobuf;

/* loaded from: classes4.dex */
final class p0 {
    private static final n0 FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final n0 LITE_SCHEMA = new o0();

    p0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n0 full() {
        return FULL_SCHEMA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n0 lite() {
        return LITE_SCHEMA;
    }

    private static n0 loadSchemaForFullRuntime() {
        try {
            return (n0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
