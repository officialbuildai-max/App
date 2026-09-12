package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.report.g;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.nativex.listener.b;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class WindVaneWebViewForNV extends WindVaneWebView {

    /* renamed from: r, reason: collision with root package name */
    private b f36749r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f36750s;

    public WindVaneWebViewForNV(Context context) {
        super(context);
        this.f36750s = false;
    }

    public WindVaneWebViewForNV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36750s = false;
    }

    public WindVaneWebViewForNV(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f36750s = false;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        b bVar;
        if (i11 != 4 || (bVar = this.f36749r) == null) {
            return super.onKeyDown(i11, keyEvent);
        }
        bVar.a();
        return true;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f36750s) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void orientation(boolean z10) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (z10) {
                jSONObject.put("orientation", TmcStartParams.KEY_LANDSCAPE);
            } else {
                jSONObject.put("orientation", "portrait");
            }
            f.a().a((WebView) this, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void setBackListener(b bVar) {
        this.f36749r = bVar;
    }

    public void setInterceptTouch(boolean z10) {
        this.f36750s = z10;
    }

    public void webViewShow(CampaignEx campaignEx, String str) {
        try {
            f.a().a((WebView) this, "webviewshow", "");
            m mVar = new m();
            mVar.n(campaignEx.getRequestId());
            mVar.o(campaignEx.getRequestIdNotice());
            if (getContext() != null && getContext().getApplicationContext() != null) {
                mVar.b(campaignEx.getId());
                mVar.b(campaignEx.isMraid() ? m.N : m.O);
                g.d(mVar, getContext().getApplicationContext(), str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
