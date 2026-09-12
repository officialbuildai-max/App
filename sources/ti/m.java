package ti;

import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f76386a = new m();

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence c(byte b11) {
        return StringsKt.A0(String.valueOf(b11 & 255), 3, '0');
    }

    public final String b(String str) {
        String format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
        MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
        byte[] bytes = (format + str).getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.e(digest);
        return StringsKt.y1(ArraysKt.o0(digest, "", null, null, 0, null, new Function1() { // from class: ti.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence c11;
                c11 = m.c(((Byte) obj).byteValue());
                return c11;
            }
        }, 30, null), 8);
    }

    public final boolean d(String inputPwd, String str) {
        Intrinsics.h(inputPwd, "inputPwd");
        return Intrinsics.c(inputPwd, b(str));
    }
}
