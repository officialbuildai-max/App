package com.cloud.hisavana.sdk.common.http;

import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    protected final int f22166a = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

    /* renamed from: b, reason: collision with root package name */
    protected ResponseBaseListener f22167b = null;

    protected abstract void a();

    public void b() {
        if (NetStateManager.checkNetworkState(true)) {
            a();
            return;
        }
        ResponseBaseListener responseBaseListener = this.f22167b;
        if (responseBaseListener != null) {
            responseBaseListener.e(TaErrorCode.ERROR_NETWORK_NOT_CONNECTED);
        }
    }
}
