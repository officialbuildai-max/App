package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f9788a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f9789b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f9790c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f9791d = -1;

    public int a() {
        return this.f9789b;
    }

    public int b() {
        int i11 = this.f9790c;
        int c11 = c();
        if (c11 == 6) {
            i11 |= 4;
        } else if (c11 == 7) {
            i11 |= 1;
        }
        return i11 & 273;
    }

    public int c() {
        int i11 = this.f9791d;
        return i11 != -1 ? i11 : AudioAttributesCompat.a(false, this.f9790c, this.f9788a);
    }

    public int d() {
        return this.f9788a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f9789b == audioAttributesImplBase.a() && this.f9790c == audioAttributesImplBase.b() && this.f9788a == audioAttributesImplBase.d() && this.f9791d == audioAttributesImplBase.f9791d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9789b), Integer.valueOf(this.f9790c), Integer.valueOf(this.f9788a), Integer.valueOf(this.f9791d)});
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f9791d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f9791d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.b(this.f9788a));
        sb2.append(" content=");
        sb2.append(this.f9789b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f9790c).toUpperCase());
        return sb2.toString();
    }
}
