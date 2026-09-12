package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.l0;

/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray f26240a = new SparseArray();

    public l0 a(int i11) {
        l0 l0Var = (l0) this.f26240a.get(i11);
        if (l0Var != null) {
            return l0Var;
        }
        l0 l0Var2 = new l0(9223372036854775806L);
        this.f26240a.put(i11, l0Var2);
        return l0Var2;
    }

    public void b() {
        this.f26240a.clear();
    }
}
