package com.cloud.tmc.integration.resource.processor;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.resource.BaseResourceProcessor;
import com.cloud.tmc.integration.resource.ResourceAnalyseType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.miniutils.util.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/* loaded from: classes3.dex */
public class PackageResourceProcessor implements IResourceProcessor {
    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public List<String> fuzzySearch(String str, String str2) {
        IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class);
        return iPackageResourceManager.fuzzySearchByVUrl(iPackageResourceManager.getVhost(str), str2);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    @Nullable
    public WebResourceResponse get(WebResourceRequest webResourceRequest, String str, Node node) {
        String filePath;
        Uri url = webResourceRequest.getUrl();
        if (url == null) {
            return null;
        }
        String uri = url.toString();
        if (TextUtils.isEmpty(uri)) {
            return null;
        }
        if (uri.contains(UrlUtils.QUESTION_MARK)) {
            uri = uri.substring(0, uri.indexOf(UrlUtils.QUESTION_MARK));
        }
        IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class);
        if (uri.contains(".miniapp.transsion.com")) {
            filePath = iPackageResourceManager.getFilePath(str, uri);
            if (TextUtils.isEmpty(filePath)) {
                String replace = uri.replace("100000", str);
                if (replace.endsWith("/")) {
                    replace = replace.substring(0, replace.length() - 1);
                }
                filePath = iPackageResourceManager.getFilePath(str, replace);
            }
        } else {
            String str2 = "";
            String replace2 = uri.replace("https://", "");
            String str3 = "https://100000.miniapp.transsion.com/" + replace2;
            if (str3.endsWith("/")) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            filePath = iPackageResourceManager.getFilePath(str, str3);
            if (TextUtils.isEmpty(filePath)) {
                String str4 = "https://" + str + ".miniapp.transsion.com/" + replace2;
                if (str4.endsWith("/")) {
                    str4 = str4.substring(0, str4.length() - 1);
                }
                str2 = str4;
                filePath = iPackageResourceManager.getFilePath(str, str2);
            }
            Log.e("xujiaddd", "url: " + uri + "; realPath: " + filePath + "; appResUrl: " + str2 + ";frameResUrl: " + str3);
        }
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(str, ResourceAnalyseType.INTERCEPT_RESOURCE, " " + filePath);
        TmcLogger.d("PackageResourceManager", filePath);
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        try {
            return BaseResourceProcessor.addCommonWebRespHeaders(new WebResourceResponse(UrlUtils.getContentTypeFromUrl(uri), BaseResourceProcessor.getResourceResponseEncoding(), new FileInputStream(new File(filePath))));
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest webResourceRequest, String str, String str2, Node node) {
        Uri url = webResourceRequest.getUrl();
        if (url == null) {
            return null;
        }
        String uri = url.toString();
        if (TextUtils.isEmpty(uri)) {
            return null;
        }
        try {
            if (uri.contains(UrlUtils.QUESTION_MARK)) {
                uri = uri.substring(0, uri.indexOf(UrlUtils.QUESTION_MARK));
            }
        } catch (Throwable unused) {
        }
        IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class);
        String str3 = "";
        try {
            if (uri.contains(".miniapp.transsion.com")) {
                str3 = iPackageResourceManager.getFilePath(str, uri);
                if (TextUtils.isEmpty(str3)) {
                    String replace = uri.replace("100000", str);
                    if (replace.endsWith("/")) {
                        replace = replace.substring(0, replace.length() - 1);
                    }
                    str3 = iPackageResourceManager.getFilePath(str, replace);
                }
                if (TextUtils.isEmpty(str3)) {
                    String replace2 = uri.replace("100000", str2);
                    if (replace2.endsWith("/")) {
                        replace2 = replace2.substring(0, replace2.length() - 1);
                    }
                    str3 = iPackageResourceManager.getFilePath(str2, replace2);
                }
            } else {
                String replace3 = uri.replace("https://", "");
                String str4 = "https://100000.miniapp.transsion.com/" + replace3;
                if (str4.endsWith("/")) {
                    str4 = str4.substring(0, str4.length() - 1);
                }
                String filePath = iPackageResourceManager.getFilePath(str, str4);
                try {
                    if (TextUtils.isEmpty(filePath)) {
                        str3 = "https://" + str + ".miniapp.transsion.com/" + replace3;
                        if (str3.endsWith("/")) {
                            str3 = str3.substring(0, str3.length() - 1);
                        }
                        filePath = iPackageResourceManager.getFilePath(str, str3);
                    }
                    String str5 = filePath;
                    String str6 = str3;
                    str3 = str5;
                    if (TextUtils.isEmpty(str3)) {
                        String str7 = "https://" + str2 + ".miniapp.transsion.com/" + replace3;
                        if (str7.endsWith("/")) {
                            str7 = str7.substring(0, str7.length() - 1);
                        }
                        str6 = str7;
                        str3 = iPackageResourceManager.getFilePath(str2, str6);
                    }
                    Log.e("xujiaddd", "url: " + uri + "; realPath: " + str3 + "; appResUrl: " + str6 + ";frameResUrl: " + str4);
                } catch (Throwable unused2) {
                    str3 = filePath;
                }
            }
        } catch (Throwable unused3) {
        }
        try {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(str, ResourceAnalyseType.INTERCEPT_RESOURCE, " " + str3);
            TmcLogger.d("PackageResourceManager", str3);
        } catch (Throwable unused4) {
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            return BaseResourceProcessor.addCommonWebRespHeaders(new WebResourceResponse(UrlUtils.getContentTypeFromUrl(uri), BaseResourceProcessor.getResourceResponseEncoding(), new FileInputStream(new File(str3))));
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String str, String str2) {
        IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class);
        String vhost = iPackageResourceManager.getVhost(str2);
        if (!str.startsWith(vhost)) {
            if (str.startsWith("/")) {
                str = vhost + str;
            } else {
                str = vhost + "/" + str;
            }
        }
        return FileUtils.getFileByPath(iPackageResourceManager.getFilePath(str2, str));
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String str, String str2, String str3) {
        IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class);
        String vhost = iPackageResourceManager.getVhost(str2);
        if (!str.startsWith(vhost)) {
            if (str.startsWith("/")) {
                str = vhost + str;
            } else {
                str = vhost + "/" + str;
            }
        }
        String filePath = iPackageResourceManager.getFilePath(str2, str);
        if (filePath == null || filePath.isEmpty()) {
            filePath = iPackageResourceManager.getFilePath(str2, str.replace(str2, str3));
        }
        return FileUtils.getFileByPath(filePath);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(WebResourceRequest webResourceRequest, String str) {
        Uri url = webResourceRequest.getUrl();
        return (url == null || TextUtils.isEmpty(url.toString())) ? false : true;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(String str, String str2) {
        return !TextUtils.isEmpty(str);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldInterceptFuzzySearch(String str) {
        return !TextUtils.isEmpty(str);
    }
}
