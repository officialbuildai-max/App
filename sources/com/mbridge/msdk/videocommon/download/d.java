package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: h, reason: collision with root package name */
    private static d f39962h;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<String> f39963a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, Object> f39964b;

    /* renamed from: c, reason: collision with root package name */
    private i f39965c;

    /* renamed from: d, reason: collision with root package name */
    private f f39966d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f39967e;

    /* renamed from: f, reason: collision with root package name */
    private final String f39968f = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;

    /* renamed from: g, reason: collision with root package name */
    private final String f39969g = "down_type";

    private d() {
        this.f39967e = false;
        try {
            this.f39965c = i.a();
            this.f39966d = f.a();
            this.f39963a = new CopyOnWriteArrayList<>();
            this.f39964b = new ConcurrentHashMap();
            com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d11 != null) {
                this.f39967e = d11.b(1);
            }
        } catch (Throwable th2) {
            o0.b("H5DownLoadManager", th2.getMessage(), th2);
        }
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (f39962h == null) {
                    f39962h = new d();
                }
                dVar = f39962h;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVar;
    }

    private String b(String str) {
        f fVar = this.f39966d;
        return fVar != null ? fVar.b(str) : str;
    }

    public String a(String str) {
        try {
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (!Patterns.WEB_URL.matcher(str).matches()) {
            if (URLUtil.isValidUrl(str)) {
            }
            return str;
        }
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        return (TextUtils.isEmpty(path) || !TextUtils.isEmpty(parse.getQueryParameter("urlDebug"))) ? str : path.toLowerCase().endsWith(".zip") ? c(str) : b(str);
    }

    public String c(String str) {
        i iVar = this.f39965c;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }
}
