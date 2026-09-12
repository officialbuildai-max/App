package com.github.lzyzsd.jsbridge;

/* loaded from: classes3.dex */
public interface WebViewJavascriptBridge {
    void sendToWeb(String str);

    void sendToWeb(String str, OnBridgeCallback onBridgeCallback);

    void sendToWeb(String str, Object... objArr);
}
