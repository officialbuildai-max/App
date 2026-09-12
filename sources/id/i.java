package id;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f65300a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuilder f65301b;

    /* renamed from: c, reason: collision with root package name */
    private Charset f65302c;

    public i() {
        this.f65302c = StandardCharsets.ISO_8859_1;
        this.f65300a = new StringBuilder();
    }

    public i(int i11) {
        this.f65302c = StandardCharsets.ISO_8859_1;
        this.f65300a = new StringBuilder(i11);
    }

    private void g() {
        Charset charset = this.f65302c;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (charset.equals(charset2)) {
            if (this.f65300a.length() > 0) {
                StringBuilder sb2 = this.f65301b;
                if (sb2 == null) {
                    this.f65301b = this.f65300a;
                    this.f65300a = new StringBuilder();
                    return;
                } else {
                    sb2.append((CharSequence) this.f65300a);
                    this.f65300a = new StringBuilder();
                    return;
                }
            }
            return;
        }
        if (this.f65300a.length() > 0) {
            byte[] bytes = this.f65300a.toString().getBytes(charset2);
            this.f65300a = new StringBuilder();
            StringBuilder sb3 = this.f65301b;
            if (sb3 == null) {
                this.f65301b = new StringBuilder(new String(bytes, this.f65302c));
            } else {
                sb3.append(new String(bytes, this.f65302c));
            }
        }
    }

    public void a(byte b11) {
        this.f65300a.append((char) (b11 & 255));
    }

    public void b(char c11) {
        this.f65300a.append((char) (c11 & 255));
    }

    public void c(int i11) {
        d(String.valueOf(i11));
    }

    public void d(String str) {
        this.f65300a.append(str);
    }

    public void e(StringBuilder sb2) {
        g();
        this.f65301b.append((CharSequence) sb2);
    }

    public void f(int i11) {
        g();
        CharacterSetECI characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(i11);
        if (characterSetECIByValue == null) {
            throw FormatException.getFormatInstance();
        }
        this.f65302c = characterSetECIByValue.getCharset();
    }

    public boolean h() {
        StringBuilder sb2;
        return this.f65300a.length() == 0 && ((sb2 = this.f65301b) == null || sb2.length() == 0);
    }

    public int i() {
        return toString().length();
    }

    public String toString() {
        g();
        StringBuilder sb2 = this.f65301b;
        return sb2 == null ? "" : sb2.toString();
    }
}
