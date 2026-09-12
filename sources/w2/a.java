package w2;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class a implements x.a {

    /* renamed from: g, reason: collision with root package name */
    private static final r f77674g = new r.b().u0(MimeTypes.APPLICATION_ID3).N();

    /* renamed from: h, reason: collision with root package name */
    private static final r f77675h = new r.b().u0(MimeTypes.APPLICATION_SCTE35).N();

    /* renamed from: a, reason: collision with root package name */
    public final String f77676a;

    /* renamed from: b, reason: collision with root package name */
    public final String f77677b;

    /* renamed from: c, reason: collision with root package name */
    public final long f77678c;

    /* renamed from: d, reason: collision with root package name */
    public final long f77679d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f77680e;

    /* renamed from: f, reason: collision with root package name */
    private int f77681f;

    public a(String str, String str2, long j11, long j12, byte[] bArr) {
        this.f77676a = str;
        this.f77677b = str2;
        this.f77678c = j11;
        this.f77679d = j12;
        this.f77680e = bArr;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f77678c == aVar.f77678c && this.f77679d == aVar.f77679d && Objects.equals(this.f77676a, aVar.f77676a) && Objects.equals(this.f77677b, aVar.f77677b) && Arrays.equals(this.f77680e, aVar.f77680e);
    }

    @Override // androidx.media3.common.x.a
    public byte[] getWrappedMetadataBytes() {
        if (getWrappedMetadataFormat() != null) {
            return this.f77680e;
        }
        return null;
    }

    @Override // androidx.media3.common.x.a
    public r getWrappedMetadataFormat() {
        String str = this.f77676a;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals(EventMessage.SCTE35_SCHEME_ID)) {
                    c11 = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals(EventMessage.ID3_SCHEME_ID_AOM)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return f77675h;
            case 1:
            case 2:
                return f77674g;
            default:
                return null;
        }
    }

    public int hashCode() {
        if (this.f77681f == 0) {
            String str = this.f77676a;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f77677b;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j11 = this.f77678c;
            int i11 = (((hashCode + hashCode2) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f77679d;
            this.f77681f = ((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + Arrays.hashCode(this.f77680e);
        }
        return this.f77681f;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f77676a + ", id=" + this.f77679d + ", durationMs=" + this.f77678c + ", value=" + this.f77677b;
    }
}
