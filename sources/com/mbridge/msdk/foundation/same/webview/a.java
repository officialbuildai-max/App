package com.mbridge.msdk.foundation.same.webview;

import android.webkit.DownloadListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes5.dex */
public class a implements DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    private String f35701a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f35702b;

    public a(CampaignEx campaignEx) {
        this.f35702b = campaignEx;
    }

    public void a(String str) {
        this.f35701a = str;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j11) {
    }
}
