package com.squareup.okhttp.internal.framed;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bumptech.glide.integration.cronet.BufferQueue;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.transsion.mpush.core.config.MsgShowStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final com.squareup.okhttp.internal.framed.b[] f40427a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map f40428b;

    /* loaded from: classes5.dex */
    static final class a {

        /* renamed from: b, reason: collision with root package name */
        private final BufferedSource f40430b;

        /* renamed from: c, reason: collision with root package name */
        private int f40431c;

        /* renamed from: d, reason: collision with root package name */
        private int f40432d;

        /* renamed from: f, reason: collision with root package name */
        int f40434f;

        /* renamed from: a, reason: collision with root package name */
        private final List f40429a = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        com.squareup.okhttp.internal.framed.b[] f40433e = new com.squareup.okhttp.internal.framed.b[8];

        /* renamed from: g, reason: collision with root package name */
        int f40435g = 0;

        /* renamed from: h, reason: collision with root package name */
        int f40436h = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i11, Source source) {
            this.f40434f = r0.length - 1;
            this.f40431c = i11;
            this.f40432d = i11;
            this.f40430b = Okio.buffer(source);
        }

        private void a() {
            int i11 = this.f40432d;
            int i12 = this.f40436h;
            if (i11 < i12) {
                if (i11 == 0) {
                    b();
                } else {
                    d(i12 - i11);
                }
            }
        }

        private void b() {
            this.f40429a.clear();
            Arrays.fill(this.f40433e, (Object) null);
            this.f40434f = this.f40433e.length - 1;
            this.f40435g = 0;
            this.f40436h = 0;
        }

        private int c(int i11) {
            return this.f40434f + 1 + i11;
        }

        private int d(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.f40433e.length;
                while (true) {
                    length--;
                    i12 = this.f40434f;
                    if (length < i12 || i11 <= 0) {
                        break;
                    }
                    int i14 = this.f40433e[length].f40426c;
                    i11 -= i14;
                    this.f40436h -= i14;
                    this.f40435g--;
                    i13++;
                }
                com.squareup.okhttp.internal.framed.b[] bVarArr = this.f40433e;
                System.arraycopy(bVarArr, i12 + 1, bVarArr, i12 + 1 + i13, this.f40435g);
                this.f40434f += i13;
            }
            return i13;
        }

        private ByteString f(int i11) {
            return i(i11) ? c.f40427a[i11].f40424a : this.f40433e[c(i11 - c.f40427a.length)].f40424a;
        }

        private void h(int i11, com.squareup.okhttp.internal.framed.b bVar) {
            this.f40429a.add(bVar);
            int i12 = bVar.f40426c;
            if (i11 != -1) {
                i12 -= this.f40433e[c(i11)].f40426c;
            }
            int i13 = this.f40432d;
            if (i12 > i13) {
                b();
                return;
            }
            int d11 = d((this.f40436h + i12) - i13);
            if (i11 == -1) {
                int i14 = this.f40435g + 1;
                com.squareup.okhttp.internal.framed.b[] bVarArr = this.f40433e;
                if (i14 > bVarArr.length) {
                    com.squareup.okhttp.internal.framed.b[] bVarArr2 = new com.squareup.okhttp.internal.framed.b[bVarArr.length * 2];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.f40434f = this.f40433e.length - 1;
                    this.f40433e = bVarArr2;
                }
                int i15 = this.f40434f;
                this.f40434f = i15 - 1;
                this.f40433e[i15] = bVar;
                this.f40435g++;
            } else {
                this.f40433e[i11 + c(i11) + d11] = bVar;
            }
            this.f40436h += i12;
        }

        private boolean i(int i11) {
            return i11 >= 0 && i11 <= c.f40427a.length - 1;
        }

        private int j() {
            return this.f40430b.readByte() & 255;
        }

        private void m(int i11) {
            if (i(i11)) {
                this.f40429a.add(c.f40427a[i11]);
                return;
            }
            int c11 = c(i11 - c.f40427a.length);
            if (c11 >= 0) {
                com.squareup.okhttp.internal.framed.b[] bVarArr = this.f40433e;
                if (c11 <= bVarArr.length - 1) {
                    this.f40429a.add(bVarArr[c11]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        private void o(int i11) {
            h(-1, new com.squareup.okhttp.internal.framed.b(f(i11), k()));
        }

        private void p() {
            h(-1, new com.squareup.okhttp.internal.framed.b(c.d(k()), k()));
        }

        private void q(int i11) {
            this.f40429a.add(new com.squareup.okhttp.internal.framed.b(f(i11), k()));
        }

        private void r() {
            this.f40429a.add(new com.squareup.okhttp.internal.framed.b(c.d(k()), k()));
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f40429a);
            this.f40429a.clear();
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void g(int i11) {
            this.f40431c = i11;
            this.f40432d = i11;
            a();
        }

        ByteString k() {
            int j11 = j();
            boolean z10 = (j11 & 128) == 128;
            int n11 = n(j11, 127);
            return z10 ? ByteString.of(e.d().c(this.f40430b.readByteArray(n11))) : this.f40430b.readByteString(n11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void l() {
            while (!this.f40430b.exhausted()) {
                byte readByte = this.f40430b.readByte();
                int i11 = readByte & 255;
                if (i11 == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    m(n(i11, 127) - 1);
                } else if (i11 == 64) {
                    p();
                } else if ((readByte & 64) == 64) {
                    o(n(i11, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int n11 = n(i11, 31);
                    this.f40432d = n11;
                    if (n11 < 0 || n11 > this.f40431c) {
                        throw new IOException("Invalid dynamic table size update " + this.f40432d);
                    }
                    a();
                } else if (i11 == 16 || i11 == 0) {
                    r();
                } else {
                    q(n(i11, 15) - 1);
                }
            }
        }

        int n(int i11, int i12) {
            int i13 = i11 & i12;
            if (i13 < i12) {
                return i13;
            }
            int i14 = 0;
            while (true) {
                int j11 = j();
                if ((j11 & 128) == 0) {
                    return i12 + (j11 << i14);
                }
                i12 += (j11 & 127) << i14;
                i14 += 7;
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Buffer f40437a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Buffer buffer) {
            this.f40437a = buffer;
        }

        void a(ByteString byteString) {
            c(byteString.size(), 127, 0);
            this.f40437a.write(byteString);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(List list) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                ByteString asciiLowercase = ((com.squareup.okhttp.internal.framed.b) list.get(i11)).f40424a.toAsciiLowercase();
                Integer num = (Integer) c.f40428b.get(asciiLowercase);
                if (num != null) {
                    c(num.intValue() + 1, 15, 0);
                    a(((com.squareup.okhttp.internal.framed.b) list.get(i11)).f40425b);
                } else {
                    this.f40437a.writeByte(0);
                    a(asciiLowercase);
                    a(((com.squareup.okhttp.internal.framed.b) list.get(i11)).f40425b);
                }
            }
        }

        void c(int i11, int i12, int i13) {
            if (i11 < i12) {
                this.f40437a.writeByte(i11 | i13);
                return;
            }
            this.f40437a.writeByte(i13 | i12);
            int i14 = i11 - i12;
            while (i14 >= 128) {
                this.f40437a.writeByte(128 | (i14 & 127));
                i14 >>>= 7;
            }
            this.f40437a.writeByte(i14);
        }
    }

    static {
        com.squareup.okhttp.internal.framed.b bVar = new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40421h, "");
        ByteString byteString = com.squareup.okhttp.internal.framed.b.f40418e;
        com.squareup.okhttp.internal.framed.b bVar2 = new com.squareup.okhttp.internal.framed.b(byteString, "GET");
        com.squareup.okhttp.internal.framed.b bVar3 = new com.squareup.okhttp.internal.framed.b(byteString, "POST");
        ByteString byteString2 = com.squareup.okhttp.internal.framed.b.f40419f;
        com.squareup.okhttp.internal.framed.b bVar4 = new com.squareup.okhttp.internal.framed.b(byteString2, "/");
        com.squareup.okhttp.internal.framed.b bVar5 = new com.squareup.okhttp.internal.framed.b(byteString2, "/index.html");
        ByteString byteString3 = com.squareup.okhttp.internal.framed.b.f40420g;
        com.squareup.okhttp.internal.framed.b bVar6 = new com.squareup.okhttp.internal.framed.b(byteString3, "http");
        com.squareup.okhttp.internal.framed.b bVar7 = new com.squareup.okhttp.internal.framed.b(byteString3, "https");
        ByteString byteString4 = com.squareup.okhttp.internal.framed.b.f40417d;
        f40427a = new com.squareup.okhttp.internal.framed.b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, new com.squareup.okhttp.internal.framed.b(byteString4, MsgShowStatus.STATUS_OK), new com.squareup.okhttp.internal.framed.b(byteString4, "204"), new com.squareup.okhttp.internal.framed.b(byteString4, "206"), new com.squareup.okhttp.internal.framed.b(byteString4, "304"), new com.squareup.okhttp.internal.framed.b(byteString4, "400"), new com.squareup.okhttp.internal.framed.b(byteString4, "404"), new com.squareup.okhttp.internal.framed.b(byteString4, "500"), new com.squareup.okhttp.internal.framed.b("accept-charset", ""), new com.squareup.okhttp.internal.framed.b("accept-encoding", "gzip, deflate"), new com.squareup.okhttp.internal.framed.b("accept-language", ""), new com.squareup.okhttp.internal.framed.b("accept-ranges", ""), new com.squareup.okhttp.internal.framed.b("accept", ""), new com.squareup.okhttp.internal.framed.b("access-control-allow-origin", ""), new com.squareup.okhttp.internal.framed.b("age", ""), new com.squareup.okhttp.internal.framed.b("allow", ""), new com.squareup.okhttp.internal.framed.b("authorization", ""), new com.squareup.okhttp.internal.framed.b("cache-control", ""), new com.squareup.okhttp.internal.framed.b("content-disposition", ""), new com.squareup.okhttp.internal.framed.b(BufferQueue.CONTENT_ENCODING, ""), new com.squareup.okhttp.internal.framed.b("content-language", ""), new com.squareup.okhttp.internal.framed.b(BufferQueue.CONTENT_LENGTH, ""), new com.squareup.okhttp.internal.framed.b("content-location", ""), new com.squareup.okhttp.internal.framed.b("content-range", ""), new com.squareup.okhttp.internal.framed.b("content-type", ""), new com.squareup.okhttp.internal.framed.b("cookie", ""), new com.squareup.okhttp.internal.framed.b("date", ""), new com.squareup.okhttp.internal.framed.b(DownloadModel.ETAG, ""), new com.squareup.okhttp.internal.framed.b("expect", ""), new com.squareup.okhttp.internal.framed.b("expires", ""), new com.squareup.okhttp.internal.framed.b("from", ""), new com.squareup.okhttp.internal.framed.b("host", ""), new com.squareup.okhttp.internal.framed.b("if-match", ""), new com.squareup.okhttp.internal.framed.b("if-modified-since", ""), new com.squareup.okhttp.internal.framed.b("if-none-match", ""), new com.squareup.okhttp.internal.framed.b("if-range", ""), new com.squareup.okhttp.internal.framed.b("if-unmodified-since", ""), new com.squareup.okhttp.internal.framed.b("last-modified", ""), new com.squareup.okhttp.internal.framed.b("link", ""), new com.squareup.okhttp.internal.framed.b(RequestParameters.SUBRESOURCE_LOCATION, ""), new com.squareup.okhttp.internal.framed.b("max-forwards", ""), new com.squareup.okhttp.internal.framed.b("proxy-authenticate", ""), new com.squareup.okhttp.internal.framed.b("proxy-authorization", ""), new com.squareup.okhttp.internal.framed.b("range", ""), new com.squareup.okhttp.internal.framed.b(RequestParameters.SUBRESOURCE_REFERER, ""), new com.squareup.okhttp.internal.framed.b(ToolBar.REFRESH, ""), new com.squareup.okhttp.internal.framed.b("retry-after", ""), new com.squareup.okhttp.internal.framed.b(TmcConstants.CHANNEL_REQUEST_SERVER, ""), new com.squareup.okhttp.internal.framed.b("set-cookie", ""), new com.squareup.okhttp.internal.framed.b("strict-transport-security", ""), new com.squareup.okhttp.internal.framed.b("transfer-encoding", ""), new com.squareup.okhttp.internal.framed.b("user-agent", ""), new com.squareup.okhttp.internal.framed.b("vary", ""), new com.squareup.okhttp.internal.framed.b("via", ""), new com.squareup.okhttp.internal.framed.b("www-authenticate", "")};
        f40428b = e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString d(ByteString byteString) {
        int size = byteString.size();
        for (int i11 = 0; i11 < size; i11++) {
            byte b11 = byteString.getByte(i11);
            if (b11 >= 65 && b11 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f40427a.length);
        int i11 = 0;
        while (true) {
            com.squareup.okhttp.internal.framed.b[] bVarArr = f40427a;
            if (i11 >= bVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(bVarArr[i11].f40424a)) {
                linkedHashMap.put(bVarArr[i11].f40424a, Integer.valueOf(i11));
            }
            i11++;
        }
    }
}
