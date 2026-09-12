package com.cloud.tmc.kernel.proxy.renderprocess;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;

@DefaultImpl("com.cloud.tmc.integration.defaultImpl.OnRenderProcessGoneManager")
/* loaded from: classes3.dex */
public interface IOnRenderProcessGoneProxy extends Proxiable {

    /* loaded from: classes3.dex */
    public interface Listener {
        void onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);
    }

    void received(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);

    void register(Listener listener);

    void unRegister(Listener listener);
}
