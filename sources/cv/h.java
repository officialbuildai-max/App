package cv;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.a0;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.j;
import com.transsion.transfer.androidasync.http.w;
import com.transsion.transfer.androidasync.p;
import com.transsion.transfer.androidasync.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class h implements cv.a {

    /* renamed from: a, reason: collision with root package name */
    private Multimap f61047a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f61048b;

    /* loaded from: classes7.dex */
    class a implements bv.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBufferList f61049a;

        a(ByteBufferList byteBufferList) {
            this.f61049a = byteBufferList;
        }

        @Override // bv.d
        public void F(p pVar, ByteBufferList byteBufferList) {
            byteBufferList.f(this.f61049a);
        }
    }

    /* loaded from: classes7.dex */
    class b implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBufferList f61051a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bv.a f61052b;

        b(ByteBufferList byteBufferList, bv.a aVar) {
            this.f61051a = byteBufferList;
            this.f61052b = aVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            try {
                if (exc != null) {
                    throw exc;
                }
                h.this.f61047a = Multimap.parseUrlEncoded(this.f61051a.y());
                this.f61052b.g(null);
            } catch (Exception e11) {
                this.f61052b.g(e11);
            }
        }
    }

    private void b() {
        StringBuilder sb2 = new StringBuilder();
        try {
            Iterator<w> it = this.f61047a.iterator();
            boolean z10 = true;
            while (it.hasNext()) {
                w next = it.next();
                if (next.getValue() != null) {
                    if (!z10) {
                        sb2.append('&');
                    }
                    sb2.append(URLEncoder.encode(next.getName(), "UTF-8"));
                    sb2.append('=');
                    sb2.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    z10 = false;
                }
            }
            this.f61048b = sb2.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new AssertionError(e11);
        }
    }

    @Override // cv.a
    public void C(j jVar, s sVar, bv.a aVar) {
        if (this.f61048b == null) {
            b();
        }
        a0.h(sVar, this.f61048b, aVar);
    }

    @Override // cv.a
    public boolean K() {
        return true;
    }

    @Override // cv.a
    public String j() {
        return "application/x-www-form-urlencoded; charset=utf-8";
    }

    @Override // cv.a
    public int length() {
        if (this.f61048b == null) {
            b();
        }
        return this.f61048b.length;
    }

    @Override // cv.a
    public void r(p pVar, bv.a aVar) {
        ByteBufferList byteBufferList = new ByteBufferList();
        pVar.t(new a(byteBufferList));
        pVar.s(new b(byteBufferList, aVar));
    }
}
