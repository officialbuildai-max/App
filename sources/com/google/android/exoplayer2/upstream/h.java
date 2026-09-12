package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.p0;
import java.net.URLDecoder;

/* loaded from: classes3.dex */
public final class h extends f {

    /* renamed from: e, reason: collision with root package name */
    private n f27461e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f27462f;

    /* renamed from: g, reason: collision with root package name */
    private int f27463g;

    /* renamed from: h, reason: collision with root package name */
    private int f27464h;

    public h() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        j(nVar);
        this.f27461e = nVar;
        Uri uri = nVar.f27491a;
        String scheme = uri.getScheme();
        com.google.android.exoplayer2.util.a.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] S0 = p0.S0(uri.getSchemeSpecificPart(), ",");
        if (S0.length != 2) {
            throw ParserException.createForMalformedDataOfUnknownType("Unexpected URI format: " + uri, null);
        }
        String str = S0[1];
        if (S0[0].contains(";base64")) {
            try {
                this.f27462f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e11) {
                throw ParserException.createForMalformedDataOfUnknownType("Error while parsing Base64 encoded string: " + str, e11);
            }
        } else {
            this.f27462f = p0.n0(URLDecoder.decode(str, com.google.common.base.c.f30280a.name()));
        }
        long j11 = nVar.f27497g;
        byte[] bArr = this.f27462f;
        if (j11 > bArr.length) {
            this.f27462f = null;
            throw new DataSourceException(2008);
        }
        int i11 = (int) j11;
        this.f27463g = i11;
        int length = bArr.length - i11;
        this.f27464h = length;
        long j12 = nVar.f27498h;
        if (j12 != -1) {
            this.f27464h = (int) Math.min(length, j12);
        }
        k(nVar);
        long j13 = nVar.f27498h;
        return j13 != -1 ? j13 : this.f27464h;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        if (this.f27462f != null) {
            this.f27462f = null;
            i();
        }
        this.f27461e = null;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        n nVar = this.f27461e;
        if (nVar != null) {
            return nVar.f27491a;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.f27464h;
        if (i13 == 0) {
            return -1;
        }
        int min = Math.min(i12, i13);
        System.arraycopy(p0.j(this.f27462f), this.f27463g, bArr, i11, min);
        this.f27463g += min;
        this.f27464h -= min;
        h(min);
        return min;
    }
}
