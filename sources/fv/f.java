package fv;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.future.y;
import com.transsion.transfer.androidasync.p;
import java.nio.charset.Charset;

/* loaded from: classes7.dex */
public class f implements a {

    /* renamed from: a, reason: collision with root package name */
    Charset f62693a;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String c(String str, ByteBufferList byteBufferList) {
        Charset charset = this.f62693a;
        if (charset == null && str != null) {
            charset = Charset.forName(str);
        }
        return byteBufferList.z(charset);
    }

    @Override // fv.a
    public com.transsion.transfer.androidasync.future.f a(p pVar) {
        final String v11 = pVar.v();
        return new b().a(pVar).h(new y() { // from class: fv.e
            @Override // com.transsion.transfer.androidasync.future.y
            public final Object then(Object obj) {
                String c11;
                c11 = f.this.c(v11, (ByteBufferList) obj);
                return c11;
            }
        });
    }
}
