package com.transsion.athena.anateh;

import android.util.Log;
import com.transsion.athena.config.data.model.ehanat;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    private Cipher f42613a;

    /* renamed from: b, reason: collision with root package name */
    private Cipher f42614b;

    public athena(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f42613a = cipher;
            cipher.init(1, secretKeySpec, new IvParameterSpec(ehanat.f42668o));
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f42614b = cipher2;
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(ehanat.f42668o));
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    public byte[] a(String str) {
        Cipher cipher = this.f42613a;
        if (cipher != null) {
            try {
                return cipher.doFinal(str.getBytes("UTF-8"));
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            }
        }
        return null;
    }

    public byte[] a(byte[] bArr) {
        Cipher cipher = this.f42614b;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            }
        }
        return null;
    }

    public byte[] b(byte[] bArr) {
        Cipher cipher = this.f42613a;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            }
        }
        return null;
    }
}
