package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.z0;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.util.List;

/* loaded from: classes5.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private String f39972a;

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public static i f39973a = new i(null);
    }

    private i() {
        b();
    }

    /* synthetic */ i(h hVar) {
        this();
    }

    public static i a() {
        return a.f39973a;
    }

    public String a(String str) {
        String str2;
        String str3 = "";
        try {
            String str4 = this.f39972a + "/" + SameMD5.getMD5(z0.b(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(ResourceManager.KEY_INDEX_HTML);
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
            try {
                com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d11 != null && !TextUtils.isEmpty(d11.T())) {
                    com.mbridge.msdk.foundation.same.d.a(str, new File(str6));
                }
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

    public void b() {
        this.f39972a = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_RES);
    }
}
