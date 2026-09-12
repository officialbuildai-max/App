package com.transsion.infra.gateway.core.sercurity;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes5.dex */
public class b {
    public static String a(String str, String str2) {
        byte[] decode = Base64.decode(str, 2);
        byte[] bArr = new byte[12];
        int length = decode.length - 12;
        byte[] bArr2 = new byte[length];
        System.arraycopy(decode, 0, bArr, 0, 12);
        System.arraycopy(decode, 12, bArr2, 0, length);
        return new String(b(str2, 2, bArr).doFinal(bArr2));
    }

    private static Cipher b(String str, int i11, byte[] bArr) {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(i11, new SecretKeySpec(str.substring(0, 16).getBytes(StandardCharsets.UTF_8), "AES"), new GCMParameterSpec(128, bArr));
        return cipher;
    }
}
