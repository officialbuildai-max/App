package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.b;

/* loaded from: classes.dex */
public abstract class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(androidx.compose.runtime.collection.b bVar, int i11) {
        int n11 = bVar.n() - 1;
        int i12 = 0;
        while (i12 < n11) {
            int i13 = ((n11 - i12) / 2) + i12;
            int b11 = ((b.a) bVar.m()[i13]).b();
            if (b11 == i11) {
                return i13;
            }
            if (b11 < i11) {
                i12 = i13 + 1;
                if (i11 < ((b.a) bVar.m()[i12]).b()) {
                    return i13;
                }
            } else {
                n11 = i13 - 1;
            }
        }
        return i12;
    }
}
