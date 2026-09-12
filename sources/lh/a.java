package lh;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0858a f68965a = new C0858a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f68966b = {"0", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "d", "e", "f"};

    /* renamed from: lh.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0858a {
        private C0858a() {
        }

        public /* synthetic */ C0858a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(byte[] bArr) {
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b11 : bArr) {
                stringBuffer.append(c(b11));
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.g(stringBuffer2, "toString(...)");
            return stringBuffer2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r4 = r4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final java.lang.String c(byte r4) {
            /*
                r3 = this;
                if (r4 >= 0) goto L4
                int r4 = r4 + 256
            L4:
                int r0 = r4 / 16
                int r4 = r4 % 16
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String[] r2 = lh.a.a()
                r0 = r2[r0]
                r1.append(r0)
                java.lang.String[] r0 = lh.a.a()
                r4 = r0[r4]
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: lh.a.C0858a.c(byte):java.lang.String");
        }

        public final String a(String data) {
            Intrinsics.h(data, "data");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bytes = data.getBytes(Charsets.UTF_8);
                Intrinsics.g(bytes, "getBytes(...)");
                byte[] digest = messageDigest.digest(bytes);
                Intrinsics.g(digest, "digest(...)");
                return b(digest);
            } catch (Exception e11) {
                e11.printStackTrace();
                return data;
            }
        }

        public final String d(String buf) {
            Intrinsics.h(buf, "buf");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Intrinsics.g(messageDigest, "getInstance(...)");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.g(forName, "forName(...)");
                byte[] bytes = buf.getBytes(forName);
                Intrinsics.g(bytes, "getBytes(...)");
                messageDigest.update(bytes);
                String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                if (bigInteger.length() >= 32) {
                    Intrinsics.e(bigInteger);
                    return bigInteger;
                }
                String str = "";
                for (int i11 = 0; i11 < 32 - bigInteger.length(); i11++) {
                    str = '0' + str;
                }
                return str + bigInteger;
            } catch (Exception e11) {
                e11.printStackTrace();
                return buf;
            }
        }
    }
}
