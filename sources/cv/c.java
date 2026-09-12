package cv;

import android.text.TextUtils;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.a0;
import com.transsion.transfer.androidasync.future.Continuation;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.j;
import com.transsion.transfer.androidasync.http.server.p;
import com.transsion.transfer.androidasync.s;
import com.transsion.transfer.androidasync.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes7.dex */
public class c extends p implements cv.a {

    /* renamed from: i, reason: collision with root package name */
    v f61016i;

    /* renamed from: j, reason: collision with root package name */
    Headers f61017j;

    /* renamed from: k, reason: collision with root package name */
    ByteBufferList f61018k;

    /* renamed from: l, reason: collision with root package name */
    cv.d f61019l;

    /* renamed from: m, reason: collision with root package name */
    String f61020m = "multipart/form-data";

    /* renamed from: n, reason: collision with root package name */
    int f61021n;

    /* renamed from: o, reason: collision with root package name */
    int f61022o;

    /* renamed from: p, reason: collision with root package name */
    private ArrayList f61023p;

    /* loaded from: classes7.dex */
    class a implements v.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Headers f61024a;

        /* renamed from: cv.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        class C0746a implements bv.d {
            C0746a() {
            }

            @Override // bv.d
            public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
                byteBufferList.f(c.this.f61018k);
            }
        }

        a(Headers headers) {
            this.f61024a = headers;
        }

        @Override // com.transsion.transfer.androidasync.v.a
        public void a(String str) {
            if (!"\r".equals(str)) {
                this.f61024a.b(str);
                return;
            }
            c.this.W();
            c cVar = c.this;
            cVar.f61016i = null;
            cVar.t(null);
            cv.d dVar = new cv.d(this.f61024a);
            c.this.getClass();
            if (c.this.I() == null) {
                c cVar2 = c.this;
                cVar2.f61019l = dVar;
                cVar2.f61018k = new ByteBufferList();
                c.this.t(new C0746a());
            }
        }
    }

    /* loaded from: classes7.dex */
    class b implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bv.a f61027a;

        b(bv.a aVar) {
            this.f61027a = aVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            this.f61027a.g(exc);
        }
    }

    /* renamed from: cv.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C0747c implements bv.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f61029a;

        C0747c(s sVar) {
            this.f61029a = sVar;
        }

        @Override // bv.c
        public void onContinue(Continuation continuation, bv.a aVar) {
            byte[] bytes = "\r\n".getBytes();
            a0.h(this.f61029a, bytes, aVar);
            c.this.f61021n += bytes.length;
        }
    }

    /* loaded from: classes7.dex */
    class d implements bv.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cv.d f61031a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ s f61032b;

        d(cv.d dVar, s sVar) {
            this.f61031a = dVar;
            this.f61032b = sVar;
        }

        @Override // bv.c
        public void onContinue(Continuation continuation, bv.a aVar) {
            long c11 = this.f61031a.c();
            if (c11 >= 0) {
                c.this.f61021n = (int) (r5.f61021n + c11);
            }
            this.f61031a.d(this.f61032b, aVar);
        }
    }

    /* loaded from: classes7.dex */
    class e implements bv.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cv.d f61034a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ s f61035b;

        e(cv.d dVar, s sVar) {
            this.f61034a = dVar;
            this.f61035b = sVar;
        }

        @Override // bv.c
        public void onContinue(Continuation continuation, bv.a aVar) {
            byte[] bytes = this.f61034a.b().g(c.this.Q()).getBytes();
            a0.h(this.f61035b, bytes, aVar);
            c.this.f61021n += bytes.length;
        }
    }

    /* loaded from: classes7.dex */
    class f implements bv.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f61037a;

        f(s sVar) {
            this.f61037a = sVar;
        }

        @Override // bv.c
        public void onContinue(Continuation continuation, bv.a aVar) {
            byte[] bytes = c.this.P().getBytes();
            a0.h(this.f61037a, bytes, aVar);
            c.this.f61021n += bytes.length;
        }
    }

    public c() {
    }

    public c(String str) {
        String string = Multimap.parseSemicolonDelimited(str).getString("boundary");
        if (string == null) {
            M(new Exception("No boundary found for multipart/form-data"));
        } else {
            T(string);
        }
    }

    @Override // cv.a
    public void C(j jVar, s sVar, bv.a aVar) {
        if (this.f61023p == null) {
            return;
        }
        Continuation continuation = new Continuation(new b(aVar));
        Iterator it = this.f61023p.iterator();
        while (it.hasNext()) {
            cv.d dVar = (cv.d) it.next();
            continuation.add(new e(dVar, sVar)).add(new d(dVar, sVar)).add(new C0747c(sVar));
        }
        continuation.add(new f(sVar));
        continuation.start();
    }

    @Override // cv.a
    public boolean K() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.transfer.androidasync.http.server.p
    public void R() {
        super.R();
        W();
    }

    @Override // com.transsion.transfer.androidasync.http.server.p
    protected void S() {
        Headers headers = new Headers();
        v vVar = new v();
        this.f61016i = vVar;
        vVar.a(new a(headers));
        t(this.f61016i);
    }

    public void U(cv.d dVar) {
        if (this.f61023p == null) {
            this.f61023p = new ArrayList();
        }
        this.f61023p.add(dVar);
    }

    public List V() {
        if (this.f61023p == null) {
            return null;
        }
        return new ArrayList(this.f61023p);
    }

    void W() {
        if (this.f61018k == null) {
            return;
        }
        if (this.f61017j == null) {
            this.f61017j = new Headers();
        }
        String v11 = this.f61018k.v();
        String a11 = TextUtils.isEmpty(this.f61019l.a()) ? "unnamed" : this.f61019l.a();
        g gVar = new g(a11, v11);
        gVar.f61039a = this.f61019l.f61039a;
        U(gVar);
        this.f61017j.a(a11, v11);
        this.f61019l = null;
        this.f61018k = null;
    }

    @Override // cv.a
    public String j() {
        if (O() == null) {
            T("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        return this.f61020m + "; boundary=" + O();
    }

    @Override // cv.a
    public int length() {
        if (O() == null) {
            T("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        Iterator it = this.f61023p.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            cv.d dVar = (cv.d) it.next();
            String g11 = dVar.b().g(Q());
            if (dVar.c() == -1) {
                return -1;
            }
            i11 = (int) (i11 + dVar.c() + g11.getBytes().length + 2);
        }
        int length = i11 + P().getBytes().length;
        this.f61022o = length;
        return length;
    }

    @Override // cv.a
    public void r(com.transsion.transfer.androidasync.p pVar, bv.a aVar) {
        N(pVar);
        s(aVar);
    }

    public String toString() {
        Iterator it = V().iterator();
        return it.hasNext() ? ((cv.d) it.next()).toString() : "multipart content is empty";
    }
}
