package qm;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class d {
    public static final void a(io.reactivex.rxjava3.disposables.c cVar) {
        Intrinsics.h(cVar, "<this>");
        if (cVar.isDisposed()) {
            return;
        }
        try {
            cVar.dispose();
        } catch (Exception unused) {
        }
    }
}
