package w1;

import android.net.Uri;
import android.util.Base64;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.DataSourceException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes2.dex */
public final class c extends a {

    /* renamed from: e, reason: collision with root package name */
    private h f77624e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f77625f;

    /* renamed from: g, reason: collision with root package name */
    private int f77626g;

    /* renamed from: h, reason: collision with root package name */
    private int f77627h;

    public c() {
        super(false);
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        f(hVar);
        this.f77624e = hVar;
        Uri normalizeScheme = hVar.f77634a.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        androidx.media3.common.util.a.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] o12 = a1.o1(normalizeScheme.getSchemeSpecificPart(), ",");
        if (o12.length != 2) {
            throw ParserException.createForMalformedDataOfUnknownType("Unexpected URI format: " + normalizeScheme, null);
        }
        String str = o12[1];
        if (o12[0].contains(";base64")) {
            try {
                this.f77625f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e11) {
                throw ParserException.createForMalformedDataOfUnknownType("Error while parsing Base64 encoded string: " + str, e11);
            }
        } else {
            this.f77625f = a1.u0(URLDecoder.decode(str, StandardCharsets.US_ASCII.name()));
        }
        long j11 = hVar.f77640g;
        byte[] bArr = this.f77625f;
        if (j11 > bArr.length) {
            this.f77625f = null;
            throw new DataSourceException(2008);
        }
        int i11 = (int) j11;
        this.f77626g = i11;
        int length = bArr.length - i11;
        this.f77627h = length;
        long j12 = hVar.f77641h;
        if (j12 != -1) {
            this.f77627h = (int) Math.min(length, j12);
        }
        g(hVar);
        long j13 = hVar.f77641h;
        return j13 != -1 ? j13 : this.f77627h;
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        if (this.f77625f != null) {
            this.f77625f = null;
            e();
        }
        this.f77624e = null;
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        h hVar = this.f77624e;
        if (hVar != null) {
            return hVar.f77634a;
        }
        return null;
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.f77627h;
        if (i13 == 0) {
            return -1;
        }
        int min = Math.min(i12, i13);
        System.arraycopy(a1.i(this.f77625f), this.f77626g, bArr, i11, min);
        this.f77626g += min;
        this.f77627h -= min;
        d(min);
        return min;
    }
}
