package ev;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.a0;
import com.transsion.transfer.androidasync.http.filter.DataRemainingException;
import com.transsion.transfer.androidasync.p;
import com.transsion.transfer.androidasync.t;
import java.nio.ByteBuffer;
import java.util.zip.Inflater;

/* loaded from: classes7.dex */
public class d extends t {

    /* renamed from: g, reason: collision with root package name */
    private Inflater f62153g;

    /* renamed from: h, reason: collision with root package name */
    ByteBufferList f62154h;

    public d() {
        this(new Inflater());
    }

    public d(Inflater inflater) {
        this.f62154h = new ByteBufferList();
        this.f62153g = inflater;
    }

    @Override // com.transsion.transfer.androidasync.t, bv.d
    public void F(p pVar, ByteBufferList byteBufferList) {
        try {
            ByteBuffer t11 = ByteBufferList.t(byteBufferList.C() * 2);
            while (byteBufferList.E() > 0) {
                ByteBuffer D = byteBufferList.D();
                if (D.hasRemaining()) {
                    D.remaining();
                    this.f62153g.setInput(D.array(), D.arrayOffset() + D.position(), D.remaining());
                    do {
                        t11.position(t11.position() + this.f62153g.inflate(t11.array(), t11.arrayOffset() + t11.position(), t11.remaining()));
                        if (!t11.hasRemaining()) {
                            t11.flip();
                            this.f62154h.a(t11);
                            t11 = ByteBufferList.t(t11.capacity() * 2);
                        }
                        if (!this.f62153g.needsInput()) {
                        }
                    } while (!this.f62153g.finished());
                }
                ByteBufferList.A(D);
            }
            t11.flip();
            this.f62154h.a(t11);
            a0.a(this, this.f62154h);
        } catch (Exception e11) {
            M(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.transfer.androidasync.q
    public void M(Exception exc) {
        this.f62153g.end();
        if (exc != null && this.f62153g.getRemaining() > 0) {
            exc = new DataRemainingException("data still remaining in inflater", exc);
        }
        super.M(exc);
    }
}
