package com.transsnet.downloader.viewmodel;

import androidx.view.u0;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public final class LocalFileViewModel extends MediaBaseViewModel {

    /* renamed from: d */
    private final androidx.view.b0 f60202d = new androidx.view.b0();

    public static /* synthetic */ void k(LocalFileViewModel localFileViewModel, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        localFileViewModel.j(z10);
    }

    public final androidx.view.b0 i() {
        return this.f60202d;
    }

    public final void j(boolean z10) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new LocalFileViewModel$getOutsideLocalVideoList$1(this, z10, null), 2, null);
    }
}
