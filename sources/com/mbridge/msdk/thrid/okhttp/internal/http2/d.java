package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bumptech.glide.integration.cronet.BufferQueue;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.thrid.okio.s;
import com.transsion.mpush.core.config.MsgShowStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    static final c[] f38116a;

    /* renamed from: b, reason: collision with root package name */
    static final Map<com.mbridge.msdk.thrid.okio.f, Integer> f38117b;

    /* loaded from: classes5.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<c> f38118a;

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.e f38119b;

        /* renamed from: c, reason: collision with root package name */
        private final int f38120c;

        /* renamed from: d, reason: collision with root package name */
        private int f38121d;

        /* renamed from: e, reason: collision with root package name */
        c[] f38122e;

        /* renamed from: f, reason: collision with root package name */
        int f38123f;

        /* renamed from: g, reason: collision with root package name */
        int f38124g;

        /* renamed from: h, reason: collision with root package name */
        int f38125h;

        a(int i11, int i12, s sVar) {
            this.f38118a = new ArrayList();
            this.f38122e = new c[8];
            this.f38123f = 7;
            this.f38124g = 0;
            this.f38125h = 0;
            this.f38120c = i11;
            this.f38121d = i12;
            this.f38119b = com.mbridge.msdk.thrid.okio.l.a(sVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i11, s sVar) {
            this(i11, i11, sVar);
        }

        private int a(int i11) {
            return this.f38123f + 1 + i11;
        }

        private void a() {
            int i11 = this.f38121d;
            int i12 = this.f38125h;
            if (i11 < i12) {
                if (i11 == 0) {
                    b();
                } else {
                    b(i12 - i11);
                }
            }
        }

        private void a(int i11, c cVar) {
            this.f38118a.add(cVar);
            int i12 = cVar.f38115c;
            if (i11 != -1) {
                i12 -= this.f38122e[a(i11)].f38115c;
            }
            int i13 = this.f38121d;
            if (i12 > i13) {
                b();
                return;
            }
            int b11 = b((this.f38125h + i12) - i13);
            if (i11 == -1) {
                int i14 = this.f38124g + 1;
                c[] cVarArr = this.f38122e;
                if (i14 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f38123f = this.f38122e.length - 1;
                    this.f38122e = cVarArr2;
                }
                int i15 = this.f38123f;
                this.f38123f = i15 - 1;
                this.f38122e[i15] = cVar;
                this.f38124g++;
            } else {
                this.f38122e[i11 + a(i11) + b11] = cVar;
            }
            this.f38125h += i12;
        }

        private int b(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.f38122e.length;
                while (true) {
                    length--;
                    i12 = this.f38123f;
                    if (length < i12 || i11 <= 0) {
                        break;
                    }
                    int i14 = this.f38122e[length].f38115c;
                    i11 -= i14;
                    this.f38125h -= i14;
                    this.f38124g--;
                    i13++;
                }
                c[] cVarArr = this.f38122e;
                int i15 = i12 + 1;
                System.arraycopy(cVarArr, i15, cVarArr, i15 + i13, this.f38124g);
                this.f38123f += i13;
            }
            return i13;
        }

        private void b() {
            Arrays.fill(this.f38122e, (Object) null);
            this.f38123f = this.f38122e.length - 1;
            this.f38124g = 0;
            this.f38125h = 0;
        }

        private com.mbridge.msdk.thrid.okio.f c(int i11) throws IOException {
            if (d(i11)) {
                return d.f38116a[i11].f38113a;
            }
            int a11 = a(i11 - d.f38116a.length);
            if (a11 >= 0) {
                c[] cVarArr = this.f38122e;
                if (a11 < cVarArr.length) {
                    return cVarArr[a11].f38113a;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        private int d() throws IOException {
            return this.f38119b.readByte() & 255;
        }

        private boolean d(int i11) {
            return i11 >= 0 && i11 <= d.f38116a.length - 1;
        }

        private void e(int i11) throws IOException {
            if (d(i11)) {
                this.f38118a.add(d.f38116a[i11]);
                return;
            }
            int a11 = a(i11 - d.f38116a.length);
            if (a11 >= 0) {
                c[] cVarArr = this.f38122e;
                if (a11 < cVarArr.length) {
                    this.f38118a.add(cVarArr[a11]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        private void f(int i11) throws IOException {
            a(-1, new c(c(i11), e()));
        }

        private void g() throws IOException {
            a(-1, new c(d.a(e()), e()));
        }

        private void g(int i11) throws IOException {
            this.f38118a.add(new c(c(i11), e()));
        }

        private void h() throws IOException {
            this.f38118a.add(new c(d.a(e()), e()));
        }

        int a(int i11, int i12) throws IOException {
            int i13 = i11 & i12;
            if (i13 < i12) {
                return i13;
            }
            int i14 = 0;
            while (true) {
                int d11 = d();
                if ((d11 & 128) == 0) {
                    return i12 + (d11 << i14);
                }
                i12 += (d11 & 127) << i14;
                i14 += 7;
            }
        }

        public List<c> c() {
            ArrayList arrayList = new ArrayList(this.f38118a);
            this.f38118a.clear();
            return arrayList;
        }

        com.mbridge.msdk.thrid.okio.f e() throws IOException {
            int d11 = d();
            boolean z10 = (d11 & 128) == 128;
            int a11 = a(d11, 127);
            return z10 ? com.mbridge.msdk.thrid.okio.f.a(k.b().a(this.f38119b.c(a11))) : this.f38119b.b(a11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f() throws IOException {
            while (!this.f38119b.f()) {
                byte readByte = this.f38119b.readByte();
                int i11 = readByte & 255;
                if (i11 == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    e(a(i11, 127) - 1);
                } else if (i11 == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    f(a(i11, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int a11 = a(i11, 31);
                    this.f38121d = a11;
                    if (a11 < 0 || a11 > this.f38120c) {
                        throw new IOException("Invalid dynamic table size update " + this.f38121d);
                    }
                    a();
                } else if (i11 == 16 || i11 == 0) {
                    h();
                } else {
                    g(a(i11, 15) - 1);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.c f38126a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f38127b;

        /* renamed from: c, reason: collision with root package name */
        private int f38128c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f38129d;

        /* renamed from: e, reason: collision with root package name */
        int f38130e;

        /* renamed from: f, reason: collision with root package name */
        int f38131f;

        /* renamed from: g, reason: collision with root package name */
        c[] f38132g;

        /* renamed from: h, reason: collision with root package name */
        int f38133h;

        /* renamed from: i, reason: collision with root package name */
        int f38134i;

        /* renamed from: j, reason: collision with root package name */
        int f38135j;

        b(int i11, boolean z10, com.mbridge.msdk.thrid.okio.c cVar) {
            this.f38128c = Integer.MAX_VALUE;
            this.f38132g = new c[8];
            this.f38133h = 7;
            this.f38134i = 0;
            this.f38135j = 0;
            this.f38130e = i11;
            this.f38131f = i11;
            this.f38127b = z10;
            this.f38126a = cVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(com.mbridge.msdk.thrid.okio.c cVar) {
            this(4096, true, cVar);
        }

        private int a(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.f38132g.length;
                while (true) {
                    length--;
                    i12 = this.f38133h;
                    if (length < i12 || i11 <= 0) {
                        break;
                    }
                    int i14 = this.f38132g[length].f38115c;
                    i11 -= i14;
                    this.f38135j -= i14;
                    this.f38134i--;
                    i13++;
                }
                c[] cVarArr = this.f38132g;
                int i15 = i12 + 1;
                System.arraycopy(cVarArr, i15, cVarArr, i15 + i13, this.f38134i);
                c[] cVarArr2 = this.f38132g;
                int i16 = this.f38133h + 1;
                Arrays.fill(cVarArr2, i16, i16 + i13, (Object) null);
                this.f38133h += i13;
            }
            return i13;
        }

        private void a() {
            int i11 = this.f38131f;
            int i12 = this.f38135j;
            if (i11 < i12) {
                if (i11 == 0) {
                    b();
                } else {
                    a(i12 - i11);
                }
            }
        }

        private void a(c cVar) {
            int i11 = cVar.f38115c;
            int i12 = this.f38131f;
            if (i11 > i12) {
                b();
                return;
            }
            a((this.f38135j + i11) - i12);
            int i13 = this.f38134i + 1;
            c[] cVarArr = this.f38132g;
            if (i13 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f38133h = this.f38132g.length - 1;
                this.f38132g = cVarArr2;
            }
            int i14 = this.f38133h;
            this.f38133h = i14 - 1;
            this.f38132g[i14] = cVar;
            this.f38134i++;
            this.f38135j += i11;
        }

        private void b() {
            Arrays.fill(this.f38132g, (Object) null);
            this.f38133h = this.f38132g.length - 1;
            this.f38134i = 0;
            this.f38135j = 0;
        }

        void a(int i11, int i12, int i13) {
            if (i11 < i12) {
                this.f38126a.writeByte(i11 | i13);
                return;
            }
            this.f38126a.writeByte(i13 | i12);
            int i14 = i11 - i12;
            while (i14 >= 128) {
                this.f38126a.writeByte(128 | (i14 & 127));
                i14 >>>= 7;
            }
            this.f38126a.writeByte(i14);
        }

        void a(com.mbridge.msdk.thrid.okio.f fVar) throws IOException {
            if (!this.f38127b || k.b().a(fVar) >= fVar.e()) {
                a(fVar.e(), 127, 0);
                this.f38126a.a(fVar);
                return;
            }
            com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
            k.b().a(fVar, cVar);
            com.mbridge.msdk.thrid.okio.f o11 = cVar.o();
            a(o11.e(), 127, 128);
            this.f38126a.a(o11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) throws IOException {
            int i11;
            int i12;
            if (this.f38129d) {
                int i13 = this.f38128c;
                if (i13 < this.f38131f) {
                    a(i13, 31, 32);
                }
                this.f38129d = false;
                this.f38128c = Integer.MAX_VALUE;
                a(this.f38131f, 31, 32);
            }
            int size = list.size();
            for (int i14 = 0; i14 < size; i14++) {
                c cVar = list.get(i14);
                com.mbridge.msdk.thrid.okio.f f11 = cVar.f38113a.f();
                com.mbridge.msdk.thrid.okio.f fVar = cVar.f38114b;
                Integer num = d.f38117b.get(f11);
                if (num != null) {
                    int intValue = num.intValue();
                    i12 = intValue + 1;
                    if (i12 > 1 && i12 < 8) {
                        c[] cVarArr = d.f38116a;
                        if (com.mbridge.msdk.thrid.okhttp.internal.c.a(cVarArr[intValue].f38114b, fVar)) {
                            i11 = i12;
                        } else if (com.mbridge.msdk.thrid.okhttp.internal.c.a(cVarArr[i12].f38114b, fVar)) {
                            i12 = intValue + 2;
                            i11 = i12;
                        }
                    }
                    i11 = i12;
                    i12 = -1;
                } else {
                    i11 = -1;
                    i12 = -1;
                }
                if (i12 == -1) {
                    int i15 = this.f38133h + 1;
                    int length = this.f38132g.length;
                    while (true) {
                        if (i15 >= length) {
                            break;
                        }
                        if (com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f38132g[i15].f38113a, f11)) {
                            if (com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f38132g[i15].f38114b, fVar)) {
                                i12 = (i15 - this.f38133h) + d.f38116a.length;
                                break;
                            } else if (i11 == -1) {
                                i11 = (i15 - this.f38133h) + d.f38116a.length;
                            }
                        }
                        i15++;
                    }
                }
                if (i12 != -1) {
                    a(i12, 127, 128);
                } else if (i11 == -1) {
                    this.f38126a.writeByte(64);
                    a(f11);
                    a(fVar);
                    a(cVar);
                } else if (!f11.b(c.f38107d) || c.f38112i.equals(f11)) {
                    a(i11, 63, 64);
                    a(fVar);
                    a(cVar);
                } else {
                    a(i11, 15, 0);
                    a(fVar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(int i11) {
            this.f38130e = i11;
            int min = Math.min(i11, 16384);
            int i12 = this.f38131f;
            if (i12 == min) {
                return;
            }
            if (min < i12) {
                this.f38128c = Math.min(this.f38128c, min);
            }
            this.f38129d = true;
            this.f38131f = min;
            a();
        }
    }

    static {
        c cVar = new c(c.f38112i, "");
        com.mbridge.msdk.thrid.okio.f fVar = c.f38109f;
        c cVar2 = new c(fVar, "GET");
        c cVar3 = new c(fVar, "POST");
        com.mbridge.msdk.thrid.okio.f fVar2 = c.f38110g;
        c cVar4 = new c(fVar2, "/");
        c cVar5 = new c(fVar2, "/index.html");
        com.mbridge.msdk.thrid.okio.f fVar3 = c.f38111h;
        c cVar6 = new c(fVar3, "http");
        c cVar7 = new c(fVar3, "https");
        com.mbridge.msdk.thrid.okio.f fVar4 = c.f38108e;
        f38116a = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, new c(fVar4, MsgShowStatus.STATUS_OK), new c(fVar4, "204"), new c(fVar4, "206"), new c(fVar4, "304"), new c(fVar4, "400"), new c(fVar4, "404"), new c(fVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c(BufferQueue.CONTENT_ENCODING, ""), new c("content-language", ""), new c(BufferQueue.CONTENT_LENGTH, ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c(DownloadModel.ETAG, ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c(RequestParameters.SUBRESOURCE_LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c(RequestParameters.SUBRESOURCE_REFERER, ""), new c(ToolBar.REFRESH, ""), new c("retry-after", ""), new c(TmcConstants.CHANNEL_REQUEST_SERVER, ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f38117b = a();
    }

    static com.mbridge.msdk.thrid.okio.f a(com.mbridge.msdk.thrid.okio.f fVar) throws IOException {
        int e11 = fVar.e();
        for (int i11 = 0; i11 < e11; i11++) {
            byte a11 = fVar.a(i11);
            if (a11 >= 65 && a11 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.h());
            }
        }
        return fVar;
    }

    private static Map<com.mbridge.msdk.thrid.okio.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f38116a.length);
        int i11 = 0;
        while (true) {
            c[] cVarArr = f38116a;
            if (i11 >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i11].f38113a)) {
                linkedHashMap.put(cVarArr[i11].f38113a, Integer.valueOf(i11));
            }
            i11++;
        }
    }
}
