package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class CollapsibleWebView extends CommonWebView {

    /* renamed from: v, reason: collision with root package name */
    private CopyOnWriteArrayList<CommonWebView.h> f36497v;

    /* renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList<CommonWebView.h> f36498w;

    /* renamed from: x, reason: collision with root package name */
    private CopyOnWriteArrayList<e> f36499x;

    /* renamed from: y, reason: collision with root package name */
    private String f36500y;

    /* renamed from: z, reason: collision with root package name */
    private String f36501z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollapsibleWebView.this.hideToolBarButton("doCollapse");
            CollapsibleWebView.this.showToolBarButton("doSpand");
            CollapsibleWebView.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollapsibleWebView.this.hideToolBarButton("doSpand");
            CollapsibleWebView.this.showToolBarButton("doCollapse");
            CollapsibleWebView.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements CommonWebView.i {
        c() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.i
        public void a(String str) {
            CollapsibleWebView collapsibleWebView = CollapsibleWebView.this;
            collapsibleWebView.b(collapsibleWebView.f36517j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        Boolean f36505a = Boolean.FALSE;

        /* renamed from: b, reason: collision with root package name */
        String f36506b = "";

        d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (this.f36505a.booleanValue()) {
                return;
            }
            CollapsibleWebView.this.a((View) webView, str);
            this.f36505a = Boolean.FALSE;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f36506b = str;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "error");
            hashMap.put("url", str2);
            hashMap.put(TrackingKey.DESCRIPTION, str);
            if (!this.f36505a.booleanValue() && this.f36506b.equals(str2)) {
                this.f36505a = Boolean.TRUE;
                CollapsibleWebView.this.b(webView, hashMap);
            }
            CollapsibleWebView.this.a(webView, hashMap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            HashMap hashMap = new HashMap();
            hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "http");
            String str = webResourceRequest.getUrl() + "";
            hashMap.put("url", str);
            hashMap.put("statusCode", webResourceResponse.getStatusCode() + "");
            hashMap.put(TrackingKey.DESCRIPTION, "http error");
            if (!this.f36505a.booleanValue() && (this.f36506b.equals(str) || TextUtils.isEmpty(this.f36506b))) {
                this.f36505a = Boolean.TRUE;
                CollapsibleWebView.this.b(webView, hashMap);
            }
            CollapsibleWebView.this.a(webView, hashMap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            HashMap hashMap = new HashMap();
            hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "ssl");
            hashMap.put("url", sslError.getUrl());
            hashMap.put(TrackingKey.DESCRIPTION, "ssl error");
            if (!this.f36505a.booleanValue()) {
                if (this.f36506b.equals(sslError.getUrl() + "")) {
                    this.f36505a = Boolean.TRUE;
                    CollapsibleWebView.this.b(webView, hashMap);
                }
            }
            CollapsibleWebView.this.a(webView, hashMap);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            o0.b("CollapsibleWebView", "WebView called onRenderProcessGone");
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(View view, String str);

        void a(View view, Map<String, String> map);

        void b(View view, String str);

        void b(View view, Map<String, String> map);
    }

    public CollapsibleWebView(Context context) {
        super(context);
    }

    public CollapsibleWebView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CollapsibleWebView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str) {
        Iterator<e> it = this.f36499x.iterator();
        while (it.hasNext()) {
            it.next().a(view, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Map<String, String> map) {
        Iterator<e> it = this.f36499x.iterator();
        while (it.hasNext()) {
            it.next().a(view, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, String str) {
        Iterator<e> it = this.f36499x.iterator();
        while (it.hasNext()) {
            it.next().b(view, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, Map<String, String> map) {
        Iterator<e> it = this.f36499x.iterator();
        while (it.hasNext()) {
            it.next().b(view, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Iterator<CommonWebView.h> it = this.f36497v.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Iterator<CommonWebView.h> it = this.f36498w.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private ToolBar.b getCollapseButton() {
        return new ToolBar.b("doCollapse").a(false).a("mbridge_arrow_down_white_blackbg").a(new a());
    }

    private ToolBar.b getExpandButton() {
        return new ToolBar.b("doSpand").a("mbridge_arrow_up_black").a(new b());
    }

    public String getCollapseIconName() {
        return this.f36500y;
    }

    public String getExpandIconName() {
        return this.f36501z;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView
    public void init() {
        super.init();
        this.f36497v = new CopyOnWriteArrayList<>();
        this.f36498w = new CopyOnWriteArrayList<>();
        this.f36499x = new CopyOnWriteArrayList<>();
        this.f36500y = "mbridge_arrow_down_white_blackbg";
        this.f36501z = "mbridge_arrow_up_white";
        useDeeplink();
        initWebViewListener();
        useProgressBar();
        ArrayList<ToolBar.b> arrayList = new ArrayList<>();
        arrayList.add(getCollapseButton());
        arrayList.add(getExpandButton());
        useDefaultToolBar();
        useCustomizedToolBar(arrayList, true);
    }

    public void initWebViewListener() {
        setPageLoadTimtoutListener(new c());
        setPageLoadTimtout(CommonWebView.DEFAULT_JUMP_TIMEOUT);
        addWebViewClient(new d());
    }

    public void setCollapseIconName(String str) {
        this.f36500y = str;
    }

    public void setCollapseListener(CommonWebView.h hVar) {
        this.f36497v.add(hVar);
    }

    public void setCustomizedToolBarMarginWidthPixel(int i11, int i12, int i13, int i14) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f36510c.getLayoutParams();
        layoutParams.setMargins(i11, i12, i13, i14);
        this.f36510c.setLayoutParams(layoutParams);
    }

    public void setExpandIconName(String str) {
        this.f36501z = str;
    }

    public void setExpandListener(CommonWebView.h hVar) {
        this.f36498w.add(hVar);
    }

    public void setPageLoadListener(e eVar) {
        this.f36499x.add(eVar);
    }
}
