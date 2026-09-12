package com.mbridge.msdk.foundation.download.download;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.util.List;

/* loaded from: classes5.dex */
public class ResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    public static final String KEY_INDEX_HTML = "foldername";
    public static final String KEY_MD5CHECK = "nc";
    public static final String KEY_MD5FILENAME = "md5filename";
    private static String TAG = "ResourceManager";
    private String mFileSaveSDDir;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ResourceManagerHolder {
        public static ResourceManager instance = new ResourceManager();

        private ResourceManagerHolder() {
        }
    }

    private ResourceManager() {
        init();
    }

    public static ResourceManager getinstance() {
        return ResourceManagerHolder.instance;
    }

    private String save(String str, String str2, File file) {
        String b11 = m0.b(str2, this.mFileSaveSDDir + "/" + SameMD5.getMD5(z0.b(str)));
        return TextUtils.isEmpty(b11) ? m0.a(file) : b11;
    }

    public void cleanZipRes() {
        try {
            if (TextUtils.isEmpty(this.mFileSaveSDDir)) {
                return;
            }
            DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.ResourceManager.1
                @Override // com.mbridge.msdk.foundation.same.task.a
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.task.a
                public void pauseTask(boolean z10) {
                }

                @Override // com.mbridge.msdk.foundation.same.task.a
                public void runTask() {
                    m0.a(ResourceManager.this.mFileSaveSDDir);
                }
            });
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public String getResDirFromCampaign(String str) {
        String str2;
        String str3 = "";
        try {
            String str4 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(z0.b(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(KEY_INDEX_HTML);
            o0.a(TAG, "check zip 下载情况：url:" + str);
            o0.a(TAG, "check zip 下载情况：indexHtml:" + queryParameters);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str5 = queryParameters.get(0);
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            String str6 = str4 + "/" + str5 + "/" + str5 + ".html";
            if (!m0.e(str6)) {
                return null;
            }
            g d11 = h.b().d(c.m().b());
            if (d11 != null && !TextUtils.isEmpty(d11.T())) {
                d.a(str, new File(str6));
            }
            try {
                str2 = str.substring(str.indexOf(UrlUtils.QUESTION_MARK) + 1);
            } catch (Exception unused) {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = UrlUtils.QUESTION_MARK + str2;
            }
            return AdPayload.FILE_SCHEME + str6 + str3;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e11.printStackTrace();
            return null;
        }
    }

    public void init() {
        this.mFileSaveSDDir = e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_RES);
    }

    public synchronized String saveResFile(String str, byte[] bArr) {
        String message;
        String str2 = "unknow exception ";
        if (bArr != null) {
            try {
                try {
                    if (bArr.length > 0) {
                        String str3 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(z0.b(str)) + ".zip";
                        File file = new File(str3);
                        if (m0.a(bArr, file)) {
                            Uri parse = Uri.parse(str);
                            List<String> queryParameters = parse.getQueryParameters(KEY_MD5CHECK);
                            if (queryParameters != null && queryParameters.size() != 0) {
                                str2 = save(str, str3, file);
                            }
                            List<String> queryParameters2 = parse.getQueryParameters(KEY_MD5FILENAME);
                            if (queryParameters2 != null && queryParameters2.size() > 0) {
                                String str4 = queryParameters2.get(0);
                                if (!TextUtils.isEmpty(str4) && str4.equals(l0.a(file))) {
                                    str2 = save(str, str3, file);
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            m0.a(file);
                        }
                    }
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                    message = e11.getMessage();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        message = str2;
        return message;
    }
}
