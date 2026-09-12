package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66259a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f66260b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f66261c;

    /* renamed from: d, reason: collision with root package name */
    public final Button f66262d;

    /* renamed from: e, reason: collision with root package name */
    public final Button f66263e;

    /* renamed from: f, reason: collision with root package name */
    public final WebView f66264f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f66265g;

    /* renamed from: h, reason: collision with root package name */
    public final EditText f66266h;

    /* renamed from: i, reason: collision with root package name */
    public final BridgeWebView f66267i;

    private l(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, WebView webView, TextView textView, EditText editText, BridgeWebView bridgeWebView) {
        this.f66259a = linearLayout;
        this.f66260b = button;
        this.f66261c = button2;
        this.f66262d = button3;
        this.f66263e = button4;
        this.f66264f = webView;
        this.f66265g = textView;
        this.f66266h = editText;
        this.f66267i = bridgeWebView;
    }

    public static l a(View view) {
        int i11 = R$id.btnLoadAd;
        Button button = (Button) g4.b.a(view, i11);
        if (button != null) {
            i11 = R$id.btnLoadPre;
            Button button2 = (Button) g4.b.a(view, i11);
            if (button2 != null) {
                i11 = R$id.btnLoadSplashAd;
                Button button3 = (Button) g4.b.a(view, i11);
                if (button3 != null) {
                    i11 = R$id.btnLoadSystemAd;
                    Button button4 = (Button) g4.b.a(view, i11);
                    if (button4 != null) {
                        i11 = R$id.sysWebview;
                        WebView webView = (WebView) g4.b.a(view, i11);
                        if (webView != null) {
                            i11 = R$id.tvStatus;
                            TextView textView = (TextView) g4.b.a(view, i11);
                            if (textView != null) {
                                i11 = R$id.webInput;
                                EditText editText = (EditText) g4.b.a(view, i11);
                                if (editText != null) {
                                    i11 = R$id.webview;
                                    BridgeWebView bridgeWebView = (BridgeWebView) g4.b.a(view, i11);
                                    if (bridgeWebView != null) {
                                        return new l((LinearLayout) view, button, button2, button3, button4, webView, textView, editText, bridgeWebView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_h5_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f66259a;
    }
}
