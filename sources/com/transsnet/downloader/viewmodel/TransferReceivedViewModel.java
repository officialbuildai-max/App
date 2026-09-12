package com.transsnet.downloader.viewmodel;

import androidx.view.u0;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public final class TransferReceivedViewModel extends MediaBaseViewModel {

    /* renamed from: d */
    private final androidx.view.b0 f60206d = new androidx.view.b0();

    public static /* synthetic */ void i(TransferReceivedViewModel transferReceivedViewModel, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        transferReceivedViewModel.h(z10);
    }

    public final void h(boolean z10) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new TransferReceivedViewModel$getTransferReceivedList$1(z10, this, null), 2, null);
    }

    public final androidx.view.b0 j() {
        return this.f60206d;
    }
}
