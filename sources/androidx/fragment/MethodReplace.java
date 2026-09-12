package androidx.fragment;

import java.io.ByteArrayOutputStream;

/* loaded from: classes7.dex */
public class MethodReplace {

    /* renamed from: ۣۣ۟ۢۥ, reason: not valid java name and contains not printable characters */
    public static boolean f16 = true;

    /* renamed from: ۢۡ۠ۥ, reason: not valid java name and contains not printable characters */
    public static int m452() {
        return 1752703 ^ InjectData.m440((Object) "ۥۥ۠");
    }

    /* renamed from: ۦۤۢۦ, reason: contains not printable characters */
    public static String m453(String str) {
        String m403 = AndHook.m403();
        String m4032 = AndHook.m403();
        for (int i11 = 0; i11 < 15; i11++) {
            m403 = AndHook.m411(AndHook.m402(AndHook.m402(new StringBuffer(), m403), InjectData.m444(i11)));
            m4032 = AndHook.m411(InjectData.m450(AndHook.m402(new StringBuffer(), m4032), ((int) (AndHook.m409() * 10)) ^ i11));
        }
        do {
        } while (AppCloner.m428(m403) > 0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(AppCloner.m428(str) / 2);
        for (int i12 = 0; i12 < AppCloner.m428(str); i12 += 2) {
            ShowInject.m457(byteArrayOutputStream, (ShowInject.m459(m403, AppCloner.m417(str, i12)) << 4) | ShowInject.m459(m403, AppCloner.m417(str, i12 + 1)));
        }
        byte[] m436 = InjectData.m436(byteArrayOutputStream);
        int length = m436.length;
        int m428 = AppCloner.m428(m4032);
        for (int i13 = 0; i13 < length; i13++) {
            m436[i13] = (byte) (m436[i13] ^ AppCloner.m417(m4032, i13 % m428));
        }
        return new String(m436);
    }

    /* renamed from: ۟ۡۡۦۢ, reason: not valid java name and contains not printable characters */
    public static String m451(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
