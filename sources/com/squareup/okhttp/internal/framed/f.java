package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final InflaterSource f40466a;

    /* renamed from: b, reason: collision with root package name */
    private int f40467b;

    /* renamed from: c, reason: collision with root package name */
    private final BufferedSource f40468c;

    /* loaded from: classes5.dex */
    class a extends ForwardingSource {
        a(Source source) {
            super(source);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j11) {
            if (f.this.f40467b == 0) {
                return -1L;
            }
            long read = super.read(buffer, Math.min(j11, f.this.f40467b));
            if (read == -1) {
                return -1L;
            }
            f.this.f40467b = (int) (r8.f40467b - read);
            return read;
        }
    }

    /* loaded from: classes5.dex */
    class b extends Inflater {
        b() {
        }

        @Override // java.util.zip.Inflater
        public int inflate(byte[] bArr, int i11, int i12) {
            int inflate = super.inflate(bArr, i11, i12);
            if (inflate != 0 || !needsDictionary()) {
                return inflate;
            }
            setDictionary(i.f40475a);
            return super.inflate(bArr, i11, i12);
        }
    }

    public f(BufferedSource bufferedSource) {
        InflaterSource inflaterSource = new InflaterSource(new a(bufferedSource), new b());
        this.f40466a = inflaterSource;
        this.f40468c = Okio.buffer(inflaterSource);
    }

    private void d() {
        if (this.f40467b > 0) {
            this.f40466a.refill();
            if (this.f40467b == 0) {
                return;
            }
            throw new IOException("compressedLimit > 0: " + this.f40467b);
        }
    }

    private ByteString e() {
        return this.f40468c.readByteString(this.f40468c.readInt());
    }

    public void c() {
        this.f40468c.close();
    }

    public List f(int i11) {
        this.f40467b += i11;
        int readInt = this.f40468c.readInt();
        if (readInt < 0) {
            throw new IOException("numberOfPairs < 0: " + readInt);
        }
        if (readInt > 1024) {
            throw new IOException("numberOfPairs > 1024: " + readInt);
        }
        ArrayList arrayList = new ArrayList(readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            ByteString asciiLowercase = e().toAsciiLowercase();
            ByteString e11 = e();
            if (asciiLowercase.size() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add(new com.squareup.okhttp.internal.framed.b(asciiLowercase, e11));
        }
        d();
        return arrayList;
    }
}
