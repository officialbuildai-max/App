package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class zzasu extends IOException {
    zzasu() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasu(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasu(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
