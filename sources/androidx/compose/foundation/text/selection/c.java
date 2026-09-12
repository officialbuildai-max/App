package androidx.compose.foundation.text.selection;

import y.g;
import y.i;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final i f3419a = new i(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public static final boolean a(i iVar, long j11) {
        float f11 = iVar.f();
        float g11 = iVar.g();
        float m11 = g.m(j11);
        if (f11 <= m11 && m11 <= g11) {
            float i11 = iVar.i();
            float c11 = iVar.c();
            float n11 = g.n(j11);
            if (i11 <= n11 && n11 <= c11) {
                return true;
            }
        }
        return false;
    }
}
