package com.cloud.tmc.integration.resource.processor;

import android.app.Activity;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.resource.BaseResourceProcessor;
import com.cloud.tmc.integration.structure.PageContext;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.render.bean.JSConfig;
import com.cloud.tmc.render.proxy.InjectJSProxy;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J)\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J3\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u001f\u0010\f\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J)\u0010\f\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/cloud/tmc/integration/resource/processor/InjectJavaScriptResourceProcessor;", "Lcom/cloud/tmc/kernel/resource/IResourceProcessor;", "()V", "TAG", "", "appId", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "fuzzySearch", "", "get", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "node", "Lcom/cloud/tmc/kernel/node/Node;", "commonResId", "Ljava/io/File;", "url", TmcConstants.KEY_MINI_COMMONRES_ID, "shouldIntercept", "", "shouldInterceptFuzzySearch", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class InjectJavaScriptResourceProcessor implements IResourceProcessor {
    public static final String ASSET_INJECT_JS_FOLDER_NAME = "injectjavascript";
    private String TAG = "InjectJavaScriptResourceProcessor";
    private String appId = "";

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public List<String> fuzzySearch(String appId, String fuzzySearch) {
        return new ArrayList();
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest request, String appId, Node node) {
        Uri url;
        List S0;
        String str;
        PageContext pageContext;
        Activity activity;
        if (request != null) {
            try {
                url = request.getUrl();
            } catch (Throwable unused) {
            }
        } else {
            url = null;
        }
        if (url == null) {
            return null;
        }
        String uri = url.toString();
        Intrinsics.g(uri, "uri.toString()");
        if (TextUtils.isEmpty(uri)) {
            return null;
        }
        TmcLogger.i(this.TAG, "InjectJavaScriptResourceProcessor requestUrl:" + uri);
        String path = UrlUtils.getPath(uri);
        if (path != null && (S0 = StringsKt.S0(path, new String[]{"/"}, false, 0, 6, null)) != null && !S0.isEmpty()) {
            String str2 = (String) CollectionsKt.u0(S0);
            PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
            AssetManager assets = (pageNode == null || (pageContext = pageNode.getPageContext()) == null || (activity = pageContext.getActivity()) == null) ? null : activity.getAssets();
            if (assets != null) {
                String[] list = assets.list(ASSET_INJECT_JS_FOLDER_NAME);
                if (list != null && list.length != 0) {
                    int length = list.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            str = null;
                            break;
                        }
                        str = list[i11];
                        if (Intrinsics.c(str, str2)) {
                            break;
                        }
                        i11++;
                    }
                    if (str == null) {
                        return null;
                    }
                    TmcLogger.i(this.TAG, "InjectJavaScriptResourceProcessor filePath:injectjavascript/" + str);
                    InputStream open = assets.open("injectjavascript/" + str);
                    Intrinsics.g(open, "assetManager.open(\"$ASSE…S_FOLDER_NAME/$fileName\")");
                    return BaseResourceProcessor.addCommonWebRespHeaders(new WebResourceResponse(UrlUtils.getContentTypeFromUrl(uri), BaseResourceProcessor.getResourceResponseEncoding(), open));
                }
                TmcLogger.i(this.TAG, "InjectJavaScriptResourceProcessor Folder must have js file");
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest request, String appId, String commonResId, Node node) {
        return get(request, appId, node);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String url, String appId) {
        return null;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String url, String appId, String commonresId) {
        return get(url, appId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x001c, code lost:
    
        if (r0 != null) goto L10;
     */
    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean shouldIntercept(android.webkit.WebResourceRequest r8, java.lang.String r9) {
        /*
            r7 = this;
            if (r8 == 0) goto L1e
            android.net.Uri r0 = r8.getUrl()     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto L1e
            java.lang.String r1 = r0.getPath()     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto L1e
            java.lang.String r0 = "/"
            java.lang.String[] r2 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L9b
            r5 = 6
            r6 = 0
            r3 = 0
            r4 = 0
            java.util.List r0 = kotlin.text.StringsKt.S0(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9b
            if (r0 != 0) goto L22
        L1e:
            java.util.List r0 = kotlin.collections.CollectionsKt.l()     // Catch: java.lang.Throwable -> L9b
        L22:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L9b
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = ""
            if (r1 != 0) goto L34
            java.lang.Object r1 = kotlin.collections.CollectionsKt.u0(r0)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L9b
            goto L35
        L34:
            r1 = r2
        L35:
            java.lang.Class<com.cloud.tmc.render.proxy.InjectJSProxy> r3 = com.cloud.tmc.render.proxy.InjectJSProxy.class
            java.lang.Object r3 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r3)     // Catch: java.lang.Throwable -> L9b
            com.cloud.tmc.render.proxy.InjectJSProxy r3 = (com.cloud.tmc.render.proxy.InjectJSProxy) r3     // Catch: java.lang.Throwable -> L9b
            if (r9 != 0) goto L40
            goto L41
        L40:
            r2 = r9
        L41:
            java.util.List r2 = r3.getTartgetInjectJSData(r2)     // Catch: java.lang.Throwable -> L9b
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L9b
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L9b
        L4b:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L9b
            if (r3 == 0) goto L9b
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L9b
            com.cloud.tmc.render.bean.JSConfig r3 = (com.cloud.tmc.render.bean.JSConfig) r3     // Catch: java.lang.Throwable -> L9b
            java.lang.String r3 = r3.getJsName()     // Catch: java.lang.Throwable -> L9b
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r3, r1)     // Catch: java.lang.Throwable -> L9b
            if (r3 == 0) goto L4b
            com.cloud.tmc.integration.resource.processor.ShellResourceProcessor$Companion r3 = com.cloud.tmc.integration.resource.processor.ShellResourceProcessor.INSTANCE     // Catch: java.lang.Throwable -> L9b
            kotlin.text.Regex r3 = r3.getRegex()     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r4 = kotlin.collections.CollectionsKt.u0(r0)     // Catch: java.lang.Throwable -> L9b
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch: java.lang.Throwable -> L9b
            kotlin.text.MatchResult r3 = r3.matchEntire(r4)     // Catch: java.lang.Throwable -> L9b
            if (r3 != 0) goto L4b
            java.lang.String r0 = r7.TAG     // Catch: java.lang.Throwable -> L9b
            if (r8 == 0) goto L7c
            android.net.Uri r8 = r8.getUrl()     // Catch: java.lang.Throwable -> L9b
            goto L7d
        L7c:
            r8 = 0
        L7d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r1.<init>()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = "InjectJavaScriptResourceProcessor shouldIntercept -> appId:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L9b
            r1.append(r9)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r9 = ", requestUrl:"
            r1.append(r9)     // Catch: java.lang.Throwable -> L9b
            r1.append(r8)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L9b
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r8)     // Catch: java.lang.Throwable -> L9b
            r8 = 1
            return r8
        L9b:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.resource.processor.InjectJavaScriptResourceProcessor.shouldIntercept(android.webkit.WebResourceRequest, java.lang.String):boolean");
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(String url, String appId) {
        List l11;
        try {
            String path = UrlUtils.getPath(url);
            if (path == null || (l11 = StringsKt.S0(path, new String[]{"/"}, false, 0, 6, null)) == null) {
                l11 = CollectionsKt.l();
            }
            String str = "";
            String str2 = !l11.isEmpty() ? (String) CollectionsKt.u0(l11) : "";
            InjectJSProxy injectJSProxy = (InjectJSProxy) TmcProxy.get(InjectJSProxy.class);
            if (appId != null) {
                str = appId;
            }
            Iterator<T> it = injectJSProxy.getTartgetInjectJSData(str).iterator();
            while (it.hasNext()) {
                if (Intrinsics.c(((JSConfig) it.next()).getJsName(), str2) && ShellResourceProcessor.INSTANCE.getRegex().matchEntire((CharSequence) CollectionsKt.u0(l11)) == null) {
                    TmcLogger.d(this.TAG, "InjectJavaScriptResourceProcessor shouldIntercept -> appId:" + appId + ", requestUrl:" + url);
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldInterceptFuzzySearch(String fuzzySearch) {
        return false;
    }
}
