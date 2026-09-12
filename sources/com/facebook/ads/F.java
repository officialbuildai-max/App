package com.facebook.ads;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* loaded from: classes.dex */
class F implements DialogInterface.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f24145a;

    F(boolean z10) {
        this.f24145a = z10;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public native boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent);
}
