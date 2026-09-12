package fv;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.future.w;
import com.transsion.transfer.androidasync.p;

/* loaded from: classes7.dex */
public class b implements fv.a {

    /* loaded from: classes7.dex */
    class a extends w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f62684f;

        a(p pVar) {
            this.f62684f = pVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.transsion.transfer.androidasync.future.n
        public void cancelCleanup() {
            this.f62684f.close();
        }
    }

    /* renamed from: fv.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C0787b implements bv.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBufferList f62686a;

        C0787b(ByteBufferList byteBufferList) {
            this.f62686a = byteBufferList;
        }

        @Override // bv.d
        public void F(p pVar, ByteBufferList byteBufferList) {
            byteBufferList.f(this.f62686a);
        }
    }

    /* loaded from: classes7.dex */
    class c implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f62688a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ByteBufferList f62689b;

        c(w wVar, ByteBufferList byteBufferList) {
            this.f62688a = wVar;
            this.f62689b = byteBufferList;
        }

        @Override // bv.a
        public void g(Exception exc) {
            if (exc != null) {
                this.f62688a.G(exc);
                return;
            }
            try {
                this.f62688a.J(this.f62689b);
            } catch (Exception e11) {
                this.f62688a.G(e11);
            }
        }
    }

    @Override // fv.a
    public com.transsion.transfer.androidasync.future.f a(p pVar) {
        ByteBufferList byteBufferList = new ByteBufferList();
        a aVar = new a(pVar);
        pVar.t(new C0787b(byteBufferList));
        pVar.s(new c(aVar, byteBufferList));
        return aVar;
    }
}
