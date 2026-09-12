package ev;

import bv.d;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.p;
import com.transsion.transfer.androidasync.w;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes7.dex */
public class c extends d {

    /* renamed from: i, reason: collision with root package name */
    boolean f62142i;

    /* renamed from: j, reason: collision with root package name */
    protected CRC32 f62143j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements w.j {

        /* renamed from: a, reason: collision with root package name */
        int f62144a;

        /* renamed from: b, reason: collision with root package name */
        boolean f62145b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ p f62146c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ w f62147d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ev.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0772a implements w.j {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: ev.c$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0773a implements w.j {
                C0773a() {
                }

                @Override // com.transsion.transfer.androidasync.w.j
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void a(byte[] bArr) {
                    a aVar = a.this;
                    if (aVar.f62145b) {
                        c.this.f62143j.update(bArr, 0, bArr.length);
                    }
                    a.this.e();
                }
            }

            C0772a() {
            }

            @Override // com.transsion.transfer.androidasync.w.j
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(byte[] bArr) {
                a aVar = a.this;
                if (aVar.f62145b) {
                    c.this.f62143j.update(bArr, 0, 2);
                }
                a.this.f62147d.b(c.O(bArr, 0, ByteOrder.LITTLE_ENDIAN) & 65535, new C0773a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public class b implements bv.d {
            b() {
            }

            @Override // bv.d
            public void F(p pVar, ByteBufferList byteBufferList) {
                if (a.this.f62145b) {
                    while (byteBufferList.E() > 0) {
                        ByteBuffer D = byteBufferList.D();
                        c.this.f62143j.update(D.array(), D.arrayOffset() + D.position(), D.remaining());
                        ByteBufferList.A(D);
                    }
                }
                byteBufferList.B();
                a.this.d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ev.c$a$c, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0774c implements w.j {
            C0774c() {
            }

            @Override // com.transsion.transfer.androidasync.w.j
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(byte[] bArr) {
                if (((short) c.this.f62143j.getValue()) != c.O(bArr, 0, ByteOrder.LITTLE_ENDIAN)) {
                    c.this.M(new IOException("CRC mismatch"));
                    return;
                }
                c.this.f62143j.reset();
                a aVar = a.this;
                c cVar = c.this;
                cVar.f62142i = false;
                cVar.N(aVar.f62146c);
            }
        }

        a(p pVar, w wVar) {
            this.f62146c = pVar;
            this.f62147d = wVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (this.f62145b) {
                this.f62147d.b(2, new C0774c());
                return;
            }
            c cVar = c.this;
            cVar.f62142i = false;
            cVar.N(this.f62146c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            w wVar = new w(this.f62146c);
            b bVar = new b();
            int i11 = this.f62144a;
            if ((i11 & 8) != 0) {
                wVar.c((byte) 0, bVar);
            } else if ((i11 & 16) != 0) {
                wVar.c((byte) 0, bVar);
            } else {
                d();
            }
        }

        @Override // com.transsion.transfer.androidasync.w.j
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            short O = c.O(bArr, 0, ByteOrder.LITTLE_ENDIAN);
            if (O != -29921) {
                c.this.M(new IOException(String.format(Locale.ENGLISH, "unknown format (magic number %x)", Short.valueOf(O))));
                this.f62146c.t(new d.a());
                return;
            }
            byte b11 = bArr[3];
            this.f62144a = b11;
            boolean z10 = (b11 & 2) != 0;
            this.f62145b = z10;
            if (z10) {
                c.this.f62143j.update(bArr, 0, bArr.length);
            }
            if ((this.f62144a & 4) != 0) {
                this.f62147d.b(2, new C0772a());
            } else {
                e();
            }
        }
    }

    public c() {
        super(new Inflater(true));
        this.f62142i = true;
        this.f62143j = new CRC32();
    }

    static short O(byte[] bArr, int i11, ByteOrder byteOrder) {
        int i12;
        byte b11;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i12 = bArr[i11] << 8;
            b11 = bArr[i11 + 1];
        } else {
            i12 = bArr[i11 + 1] << 8;
            b11 = bArr[i11];
        }
        return (short) ((b11 & 255) | i12);
    }

    @Override // ev.d, com.transsion.transfer.androidasync.t, bv.d
    public void F(p pVar, ByteBufferList byteBufferList) {
        if (!this.f62142i) {
            super.F(pVar, byteBufferList);
        } else {
            w wVar = new w(pVar);
            wVar.b(10, new a(pVar, wVar));
        }
    }
}
