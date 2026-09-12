package oo;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f71195a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f71196b = {"0", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "d", "e", "f"};

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String buf) {
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
                    str = "0" + str;
                }
                return str + bigInteger;
            } catch (Exception e11) {
                e11.printStackTrace();
                return buf;
            }
        }
    }
}
