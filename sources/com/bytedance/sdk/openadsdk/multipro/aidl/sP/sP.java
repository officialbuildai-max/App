package com.bytedance.sdk.openadsdk.multipro.aidl.sP;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import com.bytedance.sdk.openadsdk.TKC.TEQ;
import com.bytedance.sdk.openadsdk.core.TKC.EjP;
import com.bytedance.sdk.openadsdk.utils.JcM;

/* loaded from: classes3.dex */
public class sP extends IDislikeClosedListener.Stub {
    private final EjP.Sj Sj;
    private final String sP;

    public sP(String str, EjP.Sj sj2) {
        this.sP = str;
        this.Sj = sj2;
    }

    @Override // com.bytedance.sdk.openadsdk.IDislikeClosedListener
    public void onItemClickClosed() throws RemoteException {
        JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.sP.sP.1
            @Override // java.lang.Runnable
            public void run() {
                if (sP.this.Sj != null) {
                    sP.this.Sj.Sj();
                    TEQ.Sj(6, sP.this.sP);
                }
            }
        });
    }
}
