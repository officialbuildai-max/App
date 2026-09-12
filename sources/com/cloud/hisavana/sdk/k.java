package com.cloud.hisavana.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: e */
    private static k f22648e;

    /* renamed from: a */
    private final String f22650a;

    /* renamed from: b */
    private Cipher f22651b;

    /* renamed from: c */
    private Cipher f22652c;

    /* renamed from: d */
    public static final a f22647d = new a(null);

    /* renamed from: f */
    private static String f22649f = "";

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ k a(a aVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = aVar.c();
            }
            return aVar.b(str);
        }

        private final String c() {
            if (TextUtils.isEmpty(k.f22649f)) {
                k.f22649f = "ew3s" + d(1, 2) + f() + e();
            }
            return k.f22649f;
        }

        private final String d(int i11, int i12) {
            int i13 = i11 * i12;
            int i14 = 1;
            if (1 <= i13) {
                while (true) {
                    if ((i14 % i11 == 0 && i14 % i12 == 0) || i14 == i13) {
                        break;
                    }
                    i14++;
                }
            }
            return "U3N0";
        }

        private final String e() {
            String string = com.cloud.sdk.commonutil.util.e.a().getResources().getString(R$string.abk4);
            Intrinsics.g(string, "getString(...)");
            return string;
        }

        private final String f() {
            return "Gdef";
        }

        public final synchronized k b(String id2) {
            k kVar;
            Intrinsics.h(id2, "id");
            kVar = k.f22648e;
            if (kVar == null) {
                kVar = new k(id2);
                k.f22648e = kVar;
            }
            return kVar;
        }
    }

    public k(String secretKey) {
        Intrinsics.h(secretKey, "secretKey");
        this.f22650a = "AttrUtil";
        try {
            byte[] bytes = secretKey.getBytes(Charsets.UTF_8);
            Intrinsics.g(bytes, "getBytes(...)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            this.f22651b = Cipher.getInstance("AES");
            this.f22652c = Cipher.getInstance("AES");
            Cipher cipher = this.f22651b;
            if (cipher != null) {
                cipher.init(1, secretKeySpec);
            }
            Cipher cipher2 = this.f22652c;
            if (cipher2 != null) {
                cipher2.init(2, secretKeySpec);
            }
        } catch (Exception e11) {
            e4.b().e(this.f22650a, "e: " + e11);
        }
    }

    public final String e(String str) {
        if (str != null && !StringsKt.q0(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.g(UTF_8, "UTF_8");
                byte[] bytes = str.getBytes(UTF_8);
                Intrinsics.g(bytes, "getBytes(...)");
                byte[] digest = messageDigest.digest(bytes);
                StringBuilder sb2 = new StringBuilder();
                Intrinsics.e(digest);
                for (byte b11 : digest) {
                    String hexString = Integer.toHexString(b11 & 255);
                    if (hexString.length() == 1) {
                        sb2.append('0');
                    }
                    sb2.append(hexString);
                }
                String sb3 = sb2.toString();
                Intrinsics.g(sb3, "toString(...)");
                return sb3;
            } catch (NoSuchAlgorithmException e11) {
                e4.b().e("SHA-256 algorithm not found, e: " + e11);
            }
        }
        return "";
    }

    public final String f(String str) {
        byte[] bArr;
        Base64.Encoder encoder;
        String encodeToString;
        if (str != null && !StringsKt.q0(str)) {
            try {
                Cipher cipher = this.f22651b;
                if (cipher != null) {
                    byte[] bytes = str.getBytes(Charsets.UTF_8);
                    Intrinsics.g(bytes, "getBytes(...)");
                    bArr = cipher.doFinal(bytes);
                } else {
                    bArr = null;
                }
                if (bArr == null) {
                    return "";
                }
                if (Build.VERSION.SDK_INT < 26) {
                    String encodeToString2 = android.util.Base64.encodeToString(bArr, 2);
                    Intrinsics.e(encodeToString2);
                    return encodeToString2;
                }
                encoder = Base64.getEncoder();
                encodeToString = encoder.encodeToString(bArr);
                Intrinsics.e(encodeToString);
                return encodeToString;
            } catch (Exception e11) {
                e4.b().e(this.f22650a, "encrypt e: " + e11);
            }
        }
        return "";
    }
}
