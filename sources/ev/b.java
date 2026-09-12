package ev;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.http.filter.PrematureDataEndException;
import com.transsion.transfer.androidasync.p;
import com.transsion.transfer.androidasync.t;

/* loaded from: classes7.dex */
public class b extends t {

    /* renamed from: g, reason: collision with root package name */
    long f62139g;

    /* renamed from: h, reason: collision with root package name */
    long f62140h;

    /* renamed from: i, reason: collision with root package name */
    ByteBufferList f62141i = new ByteBufferList();

    public b(long j11) {
        this.f62139g = j11;
    }

    @Override // com.transsion.transfer.androidasync.t, bv.d
    public void F(p pVar, ByteBufferList byteBufferList) {
        byteBufferList.g(this.f62141i, (int) Math.min(this.f62139g - this.f62140h, byteBufferList.C()));
        int C = this.f62141i.C();
        super.F(pVar, this.f62141i);
        this.f62140h += C - this.f62141i.C();
        this.f62141i.f(byteBufferList);
        if (this.f62140h == this.f62139g) {
            M(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.transfer.androidasync.q
    public void M(Exception exc) {
        if (exc == null && this.f62140h != this.f62139g) {
            exc = new PrematureDataEndException("End of data reached before content length was read: " + this.f62140h + "/" + this.f62139g + " Paused: " + isPaused());
        }
        super.M(exc);
    }
}
