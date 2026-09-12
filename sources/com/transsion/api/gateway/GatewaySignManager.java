package com.transsion.api.gateway;

import android.text.TextUtils;
import com.transsion.api.gateway.bean.GatewayResponse;
import com.transsion.api.gateway.bean.TimeBean;
import com.transsion.api.gateway.dns.a;
import com.transsion.api.gateway.utils.ContextUtils;
import com.transsion.api.gateway.utils.GatewayUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.json.b;

/* loaded from: classes.dex */
public class GatewaySignManager {
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String doSign(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.api.gateway.GatewaySignManager.doSign(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean needRetryForTimeIssue(int i11, String str) {
        if (i11 != 500 && TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            GatewayUtils.L.d("response" + str);
            GatewayResponse gatewayResponse = (GatewayResponse) b.a(str, GatewayResponse.class);
            if ("GW.4410".equals(gatewayResponse.errorCode)) {
                GatewayUtils.L.d("verify sign failed, retrying update time");
                TimeBean timeBean = (TimeBean) b.a(a.a(gatewayResponse.errorMsg), TimeBean.class);
                if (timeBean.time > 0) {
                    SafeStringUtils.getInstance(ContextUtils.getContext()).saveLong("time_offset", timeBean.time - System.currentTimeMillis());
                    return true;
                }
            }
        } catch (Exception e11) {
            GatewayUtils.L.e(e11);
        }
        return false;
    }
}
