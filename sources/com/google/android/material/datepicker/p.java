package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
abstract class p extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    protected final LinkedHashSet f28962a = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean V(o oVar) {
        return this.f28962a.add(oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W() {
        this.f28962a.clear();
    }
}
