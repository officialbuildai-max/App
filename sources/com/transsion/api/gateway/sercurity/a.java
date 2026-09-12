package com.transsion.api.gateway.sercurity;

import android.util.Base64;
import com.transsion.api.gateway.utils.GatewayUtils;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f42582a;

    public a(String str) {
        this.f42582a = str;
    }

    public String a(d dVar, String str) {
        try {
            Mac mac = Mac.getInstance(dVar.name());
            mac.init(new SecretKeySpec(Base64.decode(this.f42582a, 2), dVar.name()));
            return Base64.encodeToString(mac.doFinal(str.getBytes(Charset.forName("UTF-8"))), 2);
        } catch (Exception e11) {
            e11.printStackTrace();
            GatewayUtils.L.e(e11);
            return "";
        }
    }
}
