package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.k;

/* loaded from: classes3.dex */
public abstract class v2 implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final k.a f27856a = new k.a() { // from class: com.google.android.exoplayer2.u2
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            v2 b11;
            b11 = v2.b(bundle);
            return b11;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static v2 b(Bundle bundle) {
        int i11 = bundle.getInt(c(0), -1);
        if (i11 == 0) {
            return (v2) r1.f25673d.a(bundle);
        }
        if (i11 == 1) {
            return (v2) j2.f25200c.a(bundle);
        }
        if (i11 == 2) {
            return (v2) e3.f25092d.a(bundle);
        }
        if (i11 == 3) {
            return (v2) i3.f25193d.a(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i11);
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }
}
