package gz;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f64162a = new d();

    private d() {
    }

    public final String a(File file) {
        Intrinsics.h(file, "file");
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            fileInputStream.close();
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b11)}, 1));
                Intrinsics.g(format, "format(...)");
                sb2.append(format);
            }
            return sb2.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final boolean b(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return StringsKt.H(str, str2, true);
    }
}
