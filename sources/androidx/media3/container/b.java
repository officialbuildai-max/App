package androidx.media3.container;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class b implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f10660a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f10661b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10662c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10663d;

    public b(String str, byte[] bArr, int i11, int i12) {
        d(str, bArr, i12);
        this.f10660a = str;
        this.f10661b = bArr;
        this.f10662c = i11;
        this.f10663d = i12;
    }

    private static String c(List list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("track types = ");
        com.google.common.base.g.g(',').b(sb2, list);
        return sb2.toString();
    }

    private static void d(String str, byte[] bArr, int i11) {
        byte b11;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1949883051:
                if (str.equals(MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS)) {
                    c11 = 0;
                    break;
                }
                break;
            case -269399509:
                if (str.equals("auxiliary.tracks.interleaved")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1011693540:
                if (str.equals("auxiliary.tracks.length")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1098277265:
                if (str.equals("auxiliary.tracks.offset")) {
                    c11 = 3;
                    break;
                }
                break;
            case 2002123038:
                if (str.equals("auxiliary.tracks.map")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (i11 == 23 && bArr.length == 4) {
                    r1 = true;
                }
                androidx.media3.common.util.a.a(r1);
                return;
            case 1:
                if (i11 == 75 && bArr.length == 1 && ((b11 = bArr[0]) == 0 || b11 == 1)) {
                    r1 = true;
                }
                androidx.media3.common.util.a.a(r1);
                return;
            case 2:
            case 3:
                if (i11 == 78 && bArr.length == 8) {
                    r1 = true;
                }
                androidx.media3.common.util.a.a(r1);
                return;
            case 4:
                androidx.media3.common.util.a.a(i11 == 0);
                return;
            default:
                return;
        }
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public List b() {
        androidx.media3.common.util.a.h(this.f10660a.equals("auxiliary.tracks.map"), "Metadata is not an auxiliary tracks map");
        byte b11 = this.f10661b[1];
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < b11; i11++) {
            arrayList.add(Integer.valueOf(this.f10661b[i11 + 2]));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f10660a.equals(bVar.f10660a) && Arrays.equals(this.f10661b, bVar.f10661b) && this.f10662c == bVar.f10662c && this.f10663d == bVar.f10663d;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return w.a(this);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ r getWrappedMetadataFormat() {
        return w.b(this);
    }

    public int hashCode() {
        return ((((((527 + this.f10660a.hashCode()) * 31) + Arrays.hashCode(this.f10661b)) * 31) + this.f10662c) * 31) + this.f10663d;
    }

    public String toString() {
        String c11;
        int i11 = this.f10663d;
        if (i11 == 0) {
            if (this.f10660a.equals("auxiliary.tracks.map")) {
                c11 = c(b());
            }
            c11 = a1.u1(this.f10661b);
        } else if (i11 == 1) {
            c11 = a1.H(this.f10661b);
        } else if (i11 == 23) {
            c11 = String.valueOf(Float.intBitsToFloat(Ints.g(this.f10661b)));
        } else if (i11 == 67) {
            c11 = String.valueOf(Ints.g(this.f10661b));
        } else if (i11 != 75) {
            if (i11 == 78) {
                c11 = String.valueOf(new j0(this.f10661b).O());
            }
            c11 = a1.u1(this.f10661b);
        } else {
            c11 = String.valueOf(a.a(this.f10661b[0]));
        }
        return "mdta: key=" + this.f10660a + ", value=" + c11;
    }
}
