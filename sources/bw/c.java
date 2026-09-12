package bw;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes6.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final IvParameterSpec f17018a = new IvParameterSpec(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});

    public static String a(String seed) {
        Base64.Encoder encoder;
        String encodeToString;
        Intrinsics.h(seed, "seed");
        try {
            byte[] encoded = c(seed).getEncoded();
            encoder = Base64.getEncoder();
            encodeToString = encoder.encodeToString(encoded);
            return encodeToString;
        } catch (Exception unused) {
            long a11 = vv.d.a("AesUtils", "tag", "fail to generate key", NotificationCompat.CATEGORY_MESSAGE);
            boolean z10 = g.f17021a;
            if (!z10 && a11 - g.f17022b >= 5000) {
                g.f17022b = a11;
                if (Log.isLoggable("upgradeSdkLog", 3)) {
                    g.f17021a = true;
                }
                z10 = g.f17021a;
            }
            if (!yv.f.f79190o.a().f79195d && !z10) {
                return null;
            }
            Log.e("AesUtils", "fail to generate key");
            return null;
        }
    }

    public static String b(String gaid, String packageName) {
        Base64.Decoder decoder;
        byte[] decode;
        Base64.Encoder encoder;
        String encodeToString;
        Intrinsics.h(gaid, "gaid");
        Intrinsics.h(packageName, "packageName");
        try {
            String a11 = a(packageName);
            if (a11 == null) {
                return null;
            }
            decoder = Base64.getDecoder();
            decode = decoder.decode(a11);
            SecretKeySpec secretKeySpec = new SecretKeySpec(decode, 0, decode.length, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, f17018a);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.g(UTF_8, "UTF_8");
            byte[] bytes = gaid.getBytes(UTF_8);
            Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] doFinal = cipher.doFinal(bytes);
            encoder = Base64.getEncoder();
            encodeToString = encoder.encodeToString(doFinal);
            return encodeToString;
        } catch (Exception e11) {
            String msg = "fail to encrypt " + e11.getMessage();
            Intrinsics.h("AesUtils", "tag");
            Intrinsics.h(msg, "msg");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = g.f17021a;
            if (!z10 && currentTimeMillis - g.f17022b >= 5000) {
                g.f17022b = currentTimeMillis;
                if (Log.isLoggable("upgradeSdkLog", 3)) {
                    g.f17021a = true;
                }
                z10 = g.f17021a;
            }
            if (yv.f.f79190o.a().f79195d || z10) {
                Log.e("AesUtils", msg);
            }
            return null;
        }
    }

    public static SecretKeySpec c(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        char[] charArray = str.toCharArray();
        Intrinsics.g(charArray, "this as java.lang.String).toCharArray()");
        return new SecretKeySpec(secretKeyFactory.generateSecret(new PBEKeySpec(charArray, bytes, 65536, 256)).getEncoded(), "AES");
    }

    public static String d(String plainText) {
        Intrinsics.h(plainText, "plainText");
        if (!TextUtils.isEmpty(plainText)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bytes = plainText.getBytes(Charsets.UTF_8);
                Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer("");
                int length = digest.length;
                for (int i11 = 0; i11 < length; i11++) {
                    int i12 = digest[i11];
                    if (i12 < 0) {
                        i12 += 256;
                    }
                    if (i12 < 16) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(Integer.toHexString(i12));
                }
                String stringBuffer2 = stringBuffer.toString();
                Intrinsics.g(stringBuffer2, "toString(...)");
                return stringBuffer2;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return "";
    }
}
