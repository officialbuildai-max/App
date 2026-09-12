package com.bytedance.sdk.component.utils;

import android.annotation.TargetApi;
import android.webkit.WebView;

/* loaded from: classes2.dex */
public class sef {
    private static final Sj Sj = new sP();

    /* loaded from: classes2.dex */
    private static class Sj {
        private Sj() {
        }

        public void Sj(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    @TargetApi(19)
    /* loaded from: classes2.dex */
    private static class sP extends Sj {
        private sP() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.sef.Sj
        public void Sj(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    return;
                } catch (Throwable th2) {
                    boolean z10 = th2 instanceof IllegalStateException;
                }
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void Sj(WebView webView, String str) {
        Sj.Sj(webView, str);
    }
}
