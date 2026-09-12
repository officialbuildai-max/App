package com.transsion.infra.gateway.core.sercurity;

import android.util.Base64;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes5.dex */
public class a extends c {

    /* renamed from: a, reason: collision with root package name */
    private final String f46050a;

    public a(String str) {
        this.f46050a = str;
    }

    @Override // com.transsion.infra.gateway.core.sercurity.c
    public String a(SignAlgorithm signAlgorithm, String str) {
        try {
            Mac mac = Mac.getInstance(signAlgorithm.name());
            mac.init(new SecretKeySpec(Base64.decode(this.f46050a, 2), signAlgorithm.name()));
            return Base64.encodeToString(mac.doFinal(str.getBytes(Charset.forName("UTF-8"))), 2);
        } catch (Exception e11) {
            e11.printStackTrace();
            com.transsion.infra.gateway.core.utils.c.f46080a.i(e11);
            return "";
        }
    }
}
