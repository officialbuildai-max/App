package com.cloud.tmc.render.bean;

import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.render.BuildConfig;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/cloud/tmc/render/bean/WebviewCacheStrategyBean;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "systemWebView", "", "shellWebView", "(ZZ)V", "getShellWebView", "()Z", "setShellWebView", "(Z)V", "getSystemWebView", "setSystemWebView", "component1", "component2", "copy", "equals", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final /* data */ class WebviewCacheStrategyBean extends BaseBean {
    private boolean shellWebView;
    private boolean systemWebView;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public WebviewCacheStrategyBean() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.render.bean.WebviewCacheStrategyBean.<init>():void");
    }

    public WebviewCacheStrategyBean(boolean z10, boolean z11) {
        this.systemWebView = z10;
        this.shellWebView = z11;
    }

    public /* synthetic */ WebviewCacheStrategyBean(boolean z10, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? true : z11);
    }

    public static /* synthetic */ WebviewCacheStrategyBean copy$default(WebviewCacheStrategyBean webviewCacheStrategyBean, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = webviewCacheStrategyBean.systemWebView;
        }
        if ((i11 & 2) != 0) {
            z11 = webviewCacheStrategyBean.shellWebView;
        }
        return webviewCacheStrategyBean.copy(z10, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSystemWebView() {
        return this.systemWebView;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShellWebView() {
        return this.shellWebView;
    }

    public final WebviewCacheStrategyBean copy(boolean systemWebView, boolean shellWebView) {
        return new WebviewCacheStrategyBean(systemWebView, shellWebView);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebviewCacheStrategyBean)) {
            return false;
        }
        WebviewCacheStrategyBean webviewCacheStrategyBean = (WebviewCacheStrategyBean) other;
        return this.systemWebView == webviewCacheStrategyBean.systemWebView && this.shellWebView == webviewCacheStrategyBean.shellWebView;
    }

    public final boolean getShellWebView() {
        return this.shellWebView;
    }

    public final boolean getSystemWebView() {
        return this.systemWebView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.systemWebView;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i11 = r02 * 31;
        boolean z11 = this.shellWebView;
        return i11 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final void setShellWebView(boolean z10) {
        this.shellWebView = z10;
    }

    public final void setSystemWebView(boolean z10) {
        this.systemWebView = z10;
    }

    public String toString() {
        return "WebviewCacheStrategyBean(systemWebView=" + this.systemWebView + ", shellWebView=" + this.shellWebView + ')';
    }
}
