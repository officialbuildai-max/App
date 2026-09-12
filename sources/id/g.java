package id;

import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    private static final List f65297c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private final CharsetEncoder[] f65298a;

    /* renamed from: b, reason: collision with root package name */
    private final int f65299b;

    static {
        String[] strArr = {"IBM437", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-10", "ISO-8859-11", "ISO-8859-13", "ISO-8859-14", "ISO-8859-15", "ISO-8859-16", "windows-1250", "windows-1251", "windows-1252", "windows-1256", "Shift_JIS"};
        for (int i11 = 0; i11 < 20; i11++) {
            String str = strArr[i11];
            if (CharacterSetECI.getCharacterSetECIByName(str) != null) {
                try {
                    f65297c.add(Charset.forName(str).newEncoder());
                } catch (UnsupportedCharsetException unused) {
                }
            }
        }
    }

    public g(String str, Charset charset, int i11) {
        boolean z10;
        ArrayList<CharsetEncoder> arrayList = new ArrayList();
        arrayList.add(StandardCharsets.ISO_8859_1.newEncoder());
        int i12 = 0;
        boolean z11 = charset != null && charset.name().startsWith("UTF");
        for (int i13 = 0; i13 < str.length(); i13++) {
            for (CharsetEncoder charsetEncoder : arrayList) {
                char charAt = str.charAt(i13);
                if (charAt == i11 || charsetEncoder.canEncode(charAt)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
            if (!z10) {
                Iterator it = f65297c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CharsetEncoder charsetEncoder2 = (CharsetEncoder) it.next();
                    if (charsetEncoder2.canEncode(str.charAt(i13))) {
                        arrayList.add(charsetEncoder2);
                        z10 = true;
                        break;
                    }
                }
            }
            if (!z10) {
                z11 = true;
            }
        }
        if (arrayList.size() != 1 || z11) {
            this.f65298a = new CharsetEncoder[arrayList.size() + 2];
            Iterator it2 = arrayList.iterator();
            int i14 = 0;
            while (it2.hasNext()) {
                this.f65298a[i14] = (CharsetEncoder) it2.next();
                i14++;
            }
            this.f65298a[i14] = StandardCharsets.UTF_8.newEncoder();
            this.f65298a[i14 + 1] = StandardCharsets.UTF_16BE.newEncoder();
        } else {
            this.f65298a = new CharsetEncoder[]{(CharsetEncoder) arrayList.get(0)};
        }
        if (charset != null) {
            while (true) {
                CharsetEncoder[] charsetEncoderArr = this.f65298a;
                if (i12 >= charsetEncoderArr.length) {
                    break;
                }
                if (charsetEncoderArr[i12] != null && charset.name().equals(this.f65298a[i12].charset().name())) {
                    break;
                } else {
                    i12++;
                }
            }
            this.f65299b = i12;
        }
        i12 = -1;
        this.f65299b = i12;
    }

    public boolean a(char c11, int i11) {
        return this.f65298a[i11].canEncode("" + c11);
    }

    public byte[] b(char c11, int i11) {
        return ("" + c11).getBytes(this.f65298a[i11].charset());
    }

    public byte[] c(String str, int i11) {
        return str.getBytes(this.f65298a[i11].charset());
    }

    public Charset d(int i11) {
        return this.f65298a[i11].charset();
    }

    public int e(int i11) {
        return CharacterSetECI.getCharacterSetECI(this.f65298a[i11].charset()).getValue();
    }

    public int f() {
        return this.f65299b;
    }

    public int g() {
        return this.f65298a.length;
    }
}
