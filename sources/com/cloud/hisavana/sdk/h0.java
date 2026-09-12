package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.sign.GatewayResponse;
import com.cloud.hisavana.sdk.sign.SignAlgorithm;
import com.cloud.hisavana.sdk.sign.TimeBean;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f22565b;

    /* renamed from: a, reason: collision with root package name */
    private final f2 f22566a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Comparator<Map.Entry<String, String>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    }

    public h0(f2 f2Var) {
        this.f22566a = f2Var;
    }

    public static String a() {
        return f22565b ? "Xqn2nnO41/L92o1iuXhSLHTbXvY4Z5ZZ62m8mSLA" : "76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O";
    }

    private String b(String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            URI uri = new URI(str);
            sb2.append(uri.getPath());
            if (!TextUtils.isEmpty(uri.getQuery())) {
                String h11 = h(uri.getQuery());
                if (!TextUtils.isEmpty(h11)) {
                    e4.b().d("ssp", "formatedUrl" + h11);
                    sb2.append(UrlUtils.QUESTION_MARK);
                    sb2.append(h11);
                }
            }
            return sb2.toString();
        } catch (URISyntaxException e11) {
            e4.b().e(Log.getStackTraceString(e11));
            return "";
        }
    }

    public static String c(String str, String str2, String str3, String str4, String str5) {
        System.currentTimeMillis();
        long currentTimeMillis = System.currentTimeMillis() + j7.a.e().h("time_offset");
        return currentTimeMillis + "|2|" + new h0(new p0(a())).i(str, str2, str3, str4, str5, currentTimeMillis);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String d(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, long r17) {
        /*
            r11 = this;
            r0 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r16)
            java.lang.String r3 = "ssp"
            java.lang.String r4 = ""
            r5 = 0
            if (r2 != 0) goto L56
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Exception -> L3a
            byte[] r2 = r0.getBytes(r2)     // Catch: java.lang.Exception -> L3a
            int r2 = r2.length     // Catch: java.lang.Exception -> L3a
            long r7 = (long) r2
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L33
            int r2 = r16.length()     // Catch: java.lang.Exception -> L33
            java.lang.String r9 = "MD5"
            r10 = 102400(0x19000, float:1.43493E-40)
            if (r2 <= r10) goto L35
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r10)     // Catch: java.lang.Exception -> L33
            java.lang.String r0 = com.transsion.infra.gateway.core.utils.b.a(r0, r9)     // Catch: java.lang.Exception -> L33
            goto L61
        L33:
            r0 = move-exception
            goto L3c
        L35:
            java.lang.String r0 = com.transsion.infra.gateway.core.utils.b.a(r0, r9)     // Catch: java.lang.Exception -> L33
            goto L61
        L3a:
            r0 = move-exception
            r7 = r5
        L3c:
            com.cloud.hisavana.sdk.e4 r2 = com.cloud.hisavana.sdk.e4.b()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "generateContent exception"
            r9.append(r10)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r2.d(r3, r0)
            r0 = r4
            goto L61
        L56:
            com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r2 = "request body is null"
            r0.d(r3, r2)
            r0 = r4
            r7 = r5
        L61:
            boolean r2 = android.text.TextUtils.isEmpty(r12)
            if (r2 == 0) goto L69
            r2 = r4
            goto L6d
        L69:
            java.lang.String r2 = r12.toUpperCase()
        L6d:
            r1.append(r2)
            java.lang.String r2 = "\n"
            r1.append(r2)
            if (r13 != 0) goto L79
            r3 = r4
            goto L7a
        L79:
            r3 = r13
        L7a:
            r1.append(r3)
            r1.append(r2)
            if (r14 != 0) goto L84
            r3 = r4
            goto L85
        L84:
            r3 = r14
        L85:
            r1.append(r3)
            r1.append(r2)
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 != 0) goto L91
            r3 = r4
            goto L95
        L91:
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
        L95:
            r1.append(r3)
            r1.append(r2)
            r5 = r17
            r1.append(r5)
            r1.append(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto Laa
            goto Lab
        Laa:
            r4 = r0
        Lab:
            r1.append(r4)
            r1.append(r2)
            r2 = r11
            r3 = r15
            java.lang.String r0 = r11.b(r15)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.h0.d(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):java.lang.String");
    }

    private String e(Map map) {
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new a());
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

    public static void f(boolean z10) {
        f22565b = z10;
    }

    public static boolean g(int i11, String str) {
        if (i11 != 500 && TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            e4.b().d("ssp", "response" + str);
            GatewayResponse gatewayResponse = (GatewayResponse) GsonUtil.a(str, GatewayResponse.class);
            if ("GW.4410".equals(gatewayResponse.error_code)) {
                e4.b().d("ssp", "verify sign failed, retrying update time");
                TimeBean timeBean = (TimeBean) GsonUtil.a(r1.a(gatewayResponse.error_msg), TimeBean.class);
                if (timeBean.time > 0) {
                    j7.a.e().q("time_offset", timeBean.time - System.currentTimeMillis());
                    return true;
                }
            }
        } catch (Exception e11) {
            e4.b().e(Log.getStackTraceString(e11));
        }
        return false;
    }

    private String h(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(UrlUtils.AND_MARK)) {
            if (str2 != null) {
                int indexOf = str2.indexOf(UrlUtils.EQUAL_MARK);
                try {
                    hashMap.put(URLDecoder.decode(str2.substring(0, indexOf), "UTF-8"), URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8"));
                } catch (Exception e11) {
                    e4.b().e(Log.getStackTraceString(e11));
                }
            }
        }
        return e(hashMap);
    }

    public String i(String str, String str2, String str3, String str4, String str5, long j11) {
        String d11 = d(str, str2, str3, str4, str5, j11);
        f2 f2Var = this.f22566a;
        return f2Var != null ? f2Var.a(SignAlgorithm.HmacMD5, d11) : "";
    }
}
