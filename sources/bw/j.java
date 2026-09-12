package bw;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import javax.crypto.Cipher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes6.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f17026a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f17027b;

    static {
        byte[] bytes = "#PART#".getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
        f17026a = bytes;
        f17027b = "rsa_public_key.pem";
    }

    public static byte[] a(byte[] data, byte[] publicKey) {
        int i11;
        int i12;
        byte[] bArr;
        Intrinsics.h(data, "data");
        Intrinsics.h(publicKey, "publicKey");
        int length = data.length;
        int i13 = 1;
        int i14 = 245;
        if (length <= 245) {
            Intrinsics.h(data, "data");
            Intrinsics.h(publicKey, "publicKey");
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            byte[] doFinal = cipher.doFinal(data);
            Intrinsics.g(doFinal, "doFinal(...)");
            return doFinal;
        }
        ArrayList arrayList = new ArrayList();
        byte[] data2 = new byte[245];
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < length) {
            Objects.requireNonNull(data2);
            Intrinsics.f(data2, "null cannot be cast to non-null type kotlin.ByteArray");
            data2[i16] = data[i15];
            i16 += i13;
            if (i16 == i14 || i15 == length - 1) {
                i17++;
                if (i17 != i13) {
                    for (byte b11 : f17026a) {
                        arrayList.add(Byte.valueOf(b11));
                    }
                }
                Intrinsics.e(data2);
                Intrinsics.h(data2, "data");
                Intrinsics.h(publicKey, "publicKey");
                PublicKey generatePublic2 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey));
                Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher2.init(1, generatePublic2);
                byte[] doFinal2 = cipher2.doFinal(data2);
                Intrinsics.g(doFinal2, "doFinal(...)");
                for (byte b12 : doFinal2) {
                    arrayList.add(Byte.valueOf(b12));
                }
                if (i15 == length - 1) {
                    bArr = null;
                    i11 = 1;
                    i12 = 245;
                } else {
                    i11 = 1;
                    i12 = 245;
                    bArr = new byte[Math.min(245, (length - i15) - 1)];
                }
                i16 = 0;
            } else {
                int i18 = i14;
                i11 = i13;
                bArr = data2;
                i12 = i18;
            }
            i15++;
            int i19 = i12;
            data2 = bArr;
            i13 = i11;
            i14 = i19;
        }
        byte[] bArr2 = new byte[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i20 = 0;
        while (it.hasNext()) {
            Byte b13 = (Byte) it.next();
            Intrinsics.e(b13);
            bArr2[i20] = b13.byteValue();
            i20++;
        }
        return bArr2;
    }
}
