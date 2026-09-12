package com.transsion.api.gateway.dns;

import android.util.Base64;
import com.transsion.api.gateway.GateWaySdk;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes5.dex */
public abstract class a {
    public static String a(String str) {
        byte[] decode = Base64.decode(str, 2);
        byte[] bArr = new byte[12];
        int length = decode.length - 12;
        byte[] bArr2 = new byte[length];
        System.arraycopy(decode, 0, bArr, 0, 12);
        System.arraycopy(decode, 12, bArr2, 0, length);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, new SecretKeySpec(GateWaySdk.getSecret().substring(0, 16).getBytes(StandardCharsets.UTF_8), "AES"), new GCMParameterSpec(128, bArr));
        return new String(cipher.doFinal(bArr2));
    }
}
