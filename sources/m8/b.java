package m8;

import java.nio.charset.Charset;
import l8.e;

/* loaded from: classes4.dex */
public class b {
    public static e a(String str, int i11) {
        l8.a a11 = a.a();
        a11.o(i11);
        return a11.e(str, null);
    }

    public static e b(String str, int i11, String str2) {
        l8.a a11 = a.a();
        a11.o(i11);
        return a11.j(str, "application/json", str2.getBytes(Charset.forName("UTF-8")));
    }
}
