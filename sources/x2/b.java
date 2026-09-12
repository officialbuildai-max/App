package x2;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.common.primitives.Ints;

/* loaded from: classes2.dex */
public abstract class b implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f78160a;

    /* renamed from: b, reason: collision with root package name */
    public final String f78161b;

    public b(String str, String str2) {
        this.f78160a = com.google.common.base.a.g(str);
        this.f78161b = str2;
    }

    @Override // androidx.media3.common.x.a
    public void a(v.b bVar) {
        String str = this.f78160a;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1935137620:
                if (str.equals("TOTALTRACKS")) {
                    c11 = 0;
                    break;
                }
                break;
            case -215998278:
                if (str.equals("TOTALDISCS")) {
                    c11 = 1;
                    break;
                }
                break;
            case -113312716:
                if (str.equals("TRACKNUMBER")) {
                    c11 = 2;
                    break;
                }
                break;
            case 62359119:
                if (str.equals("ALBUM")) {
                    c11 = 3;
                    break;
                }
                break;
            case 67703139:
                if (str.equals("GENRE")) {
                    c11 = 4;
                    break;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c11 = 5;
                    break;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c11 = 6;
                    break;
                }
                break;
            case 993300766:
                if (str.equals("DISCNUMBER")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c11 = '\t';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                Integer p11 = Ints.p(this.f78161b);
                if (p11 != null) {
                    bVar.r0(p11);
                    return;
                }
                return;
            case 1:
                Integer p12 = Ints.p(this.f78161b);
                if (p12 != null) {
                    bVar.q0(p12);
                    return;
                }
                return;
            case 2:
                Integer p13 = Ints.p(this.f78161b);
                if (p13 != null) {
                    bVar.s0(p13);
                    return;
                }
                return;
            case 3:
                bVar.P(this.f78161b);
                return;
            case 4:
                bVar.c0(this.f78161b);
                return;
            case 5:
                bVar.p0(this.f78161b);
                return;
            case 6:
                bVar.W(this.f78161b);
                return;
            case 7:
                Integer p14 = Ints.p(this.f78161b);
                if (p14 != null) {
                    bVar.X(p14);
                    return;
                }
                return;
            case '\b':
                bVar.O(this.f78161b);
                return;
            case '\t':
                bVar.Q(this.f78161b);
                return;
            default:
                return;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f78160a.equals(bVar.f78160a) && this.f78161b.equals(bVar.f78161b);
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
        return ((527 + this.f78160a.hashCode()) * 31) + this.f78161b.hashCode();
    }

    public String toString() {
        return "VC: " + this.f78160a + UrlUtils.EQUAL_MARK + this.f78161b;
    }
}
