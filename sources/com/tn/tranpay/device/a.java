package com.tn.tranpay.device;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0591a f41589a = new C0591a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f41590b = {"0", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "d", "e", "f"};

    /* renamed from: com.tn.tranpay.device.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0591a {
        private C0591a() {
        }

        public /* synthetic */ C0591a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String buf) {
            Intrinsics.h(buf, "buf");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Intrinsics.g(messageDigest, "getInstance(\"MD5\")");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.g(forName, "forName(...)");
                byte[] bytes = buf.getBytes(forName);
                Intrinsics.g(bytes, "getBytes(...)");
                messageDigest.update(bytes);
                String tempString = new BigInteger(1, messageDigest.digest()).toString(16);
                if (tempString.length() >= 32) {
                    Intrinsics.g(tempString, "tempString");
                    return tempString;
                }
                String str = "";
                for (int i11 = 0; i11 < 32 - tempString.length(); i11++) {
                    str = "0" + str;
                }
                return str + tempString;
            } catch (Exception e11) {
                e11.printStackTrace();
                return buf;
            }
        }
    }
}
