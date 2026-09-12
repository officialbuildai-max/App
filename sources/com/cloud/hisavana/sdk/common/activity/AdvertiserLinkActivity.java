package com.cloud.hisavana.sdk.common.activity;

import android.R;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.common.widget.webview.ActionWebView;
import com.cloud.hisavana.sdk.e4;

/* loaded from: classes3.dex */
public class AdvertiserLinkActivity extends AppCompatActivity {

    /* renamed from: b, reason: collision with root package name */
    private static final String f21813b = "AdvertiserLinkActivity";

    /* renamed from: a, reason: collision with root package name */
    private ActionWebView f21814a;

    private void T() {
        if (a7.c.n() == 1) {
            setRequestedOrientation(1);
        } else if (a7.c.n() == 0) {
            setRequestedOrientation(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) {
        onBackPressed();
    }

    private void V() {
        try {
            this.f21814a = new ActionWebView(this);
            ((FrameLayout) findViewById(R$id.webview_container)).addView(this.f21814a);
        } catch (Throwable th2) {
            e4.b().e(f21813b, "create webview error: " + Log.getStackTraceString(th2));
            this.f21814a = null;
            finish();
        }
        ActionWebView actionWebView = this.f21814a;
        if (actionWebView != null) {
            actionWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f21814a.getSettings().setSupportZoom(true);
            this.f21814a.getSettings().setUseWideViewPort(true);
            this.f21814a.getSettings().setLoadWithOverviewMode(true);
            this.f21814a.getSettings().setDisplayZoomControls(true);
            this.f21814a.getSettings().setCacheMode(-1);
            this.f21814a.getSettings().setDomStorageEnabled(true);
            this.f21814a.setWebViewClient(new e7.j());
        }
    }

    private void W() {
        if (this.f21814a == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra)) {
            e4.b().w(f21813b, "url is null");
            return;
        }
        e4.b().d(f21813b, "url is: " + stringExtra);
        this.f21814a.loadUrl(stringExtra);
    }

    private void X() {
        ImageView imageView = (ImageView) findViewById(R$id.im_back);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdvertiserLinkActivity.this.U(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        T();
        super.onCreate(bundle);
        setContentView(R$layout.activity_advertiser_link);
        View childAt = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
        X();
        V();
        W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            ActionWebView actionWebView = this.f21814a;
            if (actionWebView != null) {
                ViewParent parent = actionWebView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f21814a);
                }
                this.f21814a.stopLoading();
                this.f21814a.getSettings().setJavaScriptEnabled(false);
                this.f21814a.setWebChromeClient(null);
                this.f21814a.clearHistory();
                this.f21814a.removeAllViews();
                this.f21814a.destroy();
                this.f21814a = null;
            }
        } catch (Throwable th2) {
            e4.b().d(f21813b, Log.getStackTraceString(th2));
        }
        super.onDestroy();
    }
}
