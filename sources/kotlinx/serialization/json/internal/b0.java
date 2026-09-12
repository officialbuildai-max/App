package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class b0 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private char[] f68413a = h.f68429a.b();

    /* renamed from: b, reason: collision with root package name */
    private int f68414b;

    private final void d(int i11, int i12, String str) {
        int i13;
        int length = str.length();
        while (i11 < length) {
            int f11 = f(i12, 2);
            char charAt = str.charAt(i11);
            if (charAt < o0.a().length) {
                byte b11 = o0.a()[charAt];
                if (b11 == 0) {
                    i13 = f11 + 1;
                    this.f68413a[f11] = charAt;
                } else {
                    if (b11 == 1) {
                        String str2 = o0.b()[charAt];
                        Intrinsics.e(str2);
                        int f12 = f(f11, str2.length());
                        str2.getChars(0, str2.length(), this.f68413a, f12);
                        i12 = f12 + str2.length();
                        this.f68414b = i12;
                    } else {
                        char[] cArr = this.f68413a;
                        cArr[f11] = '\\';
                        cArr[f11 + 1] = (char) b11;
                        i12 = f11 + 2;
                        this.f68414b = i12;
                    }
                    i11++;
                }
            } else {
                i13 = f11 + 1;
                this.f68413a[f11] = charAt;
            }
            i12 = i13;
            i11++;
        }
        int f13 = f(i12, 1);
        this.f68413a[f13] = '\"';
        this.f68414b = f13 + 1;
    }

    private final void e(int i11) {
        f(this.f68414b, i11);
    }

    private final int f(int i11, int i12) {
        int i13 = i12 + i11;
        char[] cArr = this.f68413a;
        if (cArr.length <= i13) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.f(i13, i11 * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68413a = copyOf;
        }
        return i11;
    }

    @Override // kotlinx.serialization.json.internal.h0
    public void a(char c11) {
        e(1);
        char[] cArr = this.f68413a;
        int i11 = this.f68414b;
        this.f68414b = i11 + 1;
        cArr[i11] = c11;
    }

    @Override // kotlinx.serialization.json.internal.h0
    public void b(String text) {
        Intrinsics.h(text, "text");
        e(text.length() + 2);
        char[] cArr = this.f68413a;
        int i11 = this.f68414b;
        int i12 = i11 + 1;
        cArr[i11] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i12);
        int i13 = length + i12;
        for (int i14 = i12; i14 < i13; i14++) {
            char c11 = cArr[i14];
            if (c11 < o0.a().length && o0.a()[c11] != 0) {
                d(i14 - i12, i14, text);
                return;
            }
        }
        cArr[i13] = '\"';
        this.f68414b = i13 + 1;
    }

    @Override // kotlinx.serialization.json.internal.h0
    public void c(String text) {
        Intrinsics.h(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        e(length);
        text.getChars(0, text.length(), this.f68413a, this.f68414b);
        this.f68414b += length;
    }

    public void g() {
        h.f68429a.a(this.f68413a);
    }

    public String toString() {
        return new String(this.f68413a, 0, this.f68414b);
    }

    @Override // kotlinx.serialization.json.internal.h0
    public void writeLong(long j11) {
        c(String.valueOf(j11));
    }
}
