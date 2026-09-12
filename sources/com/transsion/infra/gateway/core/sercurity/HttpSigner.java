package com.transsion.infra.gateway.core.sercurity;

import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.infra.gateway.core.bean.RequestBean;
import com.transsion.infra.gateway.core.utils.d;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class HttpSigner {

    /* renamed from: a, reason: collision with root package name */
    private final c f46049a;

    public HttpSigner(c cVar) {
        this.f46049a = cVar;
    }

    private String a(String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            URI uri = new URI(str);
            sb2.append(uri.getPath());
            if (!TextUtils.isEmpty(uri.getQuery())) {
                String f11 = f(uri.getQuery());
                if (!TextUtils.isEmpty(f11)) {
                    sb2.append(UrlUtils.QUESTION_MARK);
                    sb2.append(f11);
                }
            }
            return sb2.toString();
        } catch (URISyntaxException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String b(RequestBean requestBean) {
        if (requestBean == null) {
            com.transsion.infra.gateway.core.utils.c.f46080a.g("request bean is null");
            return null;
        }
        if (requestBean.getMethod() == null) {
            com.transsion.infra.gateway.core.utils.c.f46080a.g("request method is null");
            return null;
        }
        if (TextUtils.isEmpty(requestBean.getUrl())) {
            com.transsion.infra.gateway.core.utils.c.f46080a.g("request url is null");
            return null;
        }
        if (requestBean.getKey() == null) {
            com.transsion.infra.gateway.core.utils.c.f46080a.g("request key is null");
            return null;
        }
        if (requestBean.getKey().getKey() == null) {
            com.transsion.infra.gateway.core.utils.c.f46080a.g("request key is null");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() + d.a(com.transsion.infra.gateway.core.utils.a.a()).b("time_offset");
        String str = currentTimeMillis + "|" + requestBean.getKey().getKeyVersion() + "|" + new HttpSigner(new a(requestBean.getKey().getKey())).e(requestBean.getMethod(), requestBean.getAccept(), requestBean.getContentType(), requestBean.getUrl(), requestBean.getBody(), currentTimeMillis, requestBean.getKey().getAlgorithm());
        com.transsion.infra.gateway.core.utils.c.f46080a.g("x-tr-signature: " + str);
        return str;
    }

    private String c(Map map) {
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.transsion.infra.gateway.core.sercurity.HttpSigner.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    return entry.getKey().compareTo(entry2.getKey());
                }
            });
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry entry : arrayList) {
                if (!"".equals(entry.getKey())) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    sb2.append(str);
                    sb2.append(UrlUtils.EQUAL_MARK);
                    sb2.append(str2);
                    sb2.append(UrlUtils.AND_MARK);
                }
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String d(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, long r16) {
        /*
            r10 = this;
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            java.lang.String r2 = ""
            r3 = 0
            if (r0 != 0) goto L51
            int r0 = r15.length()     // Catch: java.lang.Exception -> L33
            long r5 = (long) r0
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L2b
            int r0 = r15.length()     // Catch: java.lang.Exception -> L2b
            r7 = 102400(0x19000, float:1.43493E-40)
            if (r0 <= r7) goto L2d
            r0 = 0
            r8 = r15
            java.lang.String r0 = r15.substring(r0, r7)     // Catch: java.lang.Exception -> L2b
            java.lang.String r0 = com.transsion.infra.gateway.core.utils.b.c(r0)     // Catch: java.lang.Exception -> L2b
            goto L5a
        L2b:
            r0 = move-exception
            goto L35
        L2d:
            r8 = r15
            java.lang.String r0 = com.transsion.infra.gateway.core.utils.b.c(r15)     // Catch: java.lang.Exception -> L2b
            goto L5a
        L33:
            r0 = move-exception
            r5 = r3
        L35:
            com.transsion.infra.gateway.core.utils.ObjectLogUtils r7 = com.transsion.infra.gateway.core.utils.c.f46080a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "generateContent exception"
            r8.append(r9)
            java.lang.String r0 = r0.toString()
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r7.i(r0)
            r0 = r2
            goto L5a
        L51:
            com.transsion.infra.gateway.core.utils.ObjectLogUtils r0 = com.transsion.infra.gateway.core.utils.c.f46080a
            java.lang.String r5 = "request body is null"
            r0.g(r5)
            r0 = r2
            r5 = r3
        L5a:
            java.lang.String r7 = r11.toUpperCase()
            r1.append(r7)
            java.lang.String r7 = "\n"
            r1.append(r7)
            if (r12 != 0) goto L6a
            r8 = r2
            goto L6b
        L6a:
            r8 = r12
        L6b:
            r1.append(r8)
            r1.append(r7)
            if (r13 != 0) goto L75
            r8 = r2
            goto L76
        L75:
            r8 = r13
        L76:
            r1.append(r8)
            r1.append(r7)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 != 0) goto L82
            r3 = r2
            goto L86
        L82:
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
        L86:
            r1.append(r3)
            r1.append(r7)
            r3 = r16
            r1.append(r3)
            r1.append(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L9b
            goto L9c
        L9b:
            r2 = r0
        L9c:
            r1.append(r2)
            r1.append(r7)
            r2 = r10
            r3 = r14
            java.lang.String r0 = r10.a(r14)
            r1.append(r0)
            com.transsion.infra.gateway.core.utils.ObjectLogUtils r0 = com.transsion.infra.gateway.core.utils.c.f46080a
            java.lang.String r3 = r1.toString()
            r0.g(r3)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.infra.gateway.core.sercurity.HttpSigner.d(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):java.lang.String");
    }

    private String f(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(UrlUtils.AND_MARK)) {
            int indexOf = str2.indexOf(UrlUtils.EQUAL_MARK);
            try {
                hashMap.put(URLDecoder.decode(str2.substring(0, indexOf), "UTF-8"), URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8"));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return c(hashMap);
    }

    public String e(String str, String str2, String str3, String str4, String str5, long j11, SignAlgorithm signAlgorithm) {
        return this.f46049a.a(signAlgorithm, d(str, str2, str3, str4, str5, j11));
    }
}
