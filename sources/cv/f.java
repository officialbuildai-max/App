package cv;

import com.cloud.tmc.integration.utils.share.config.ShareConstant;
import com.transsion.transfer.androidasync.a0;
import com.transsion.transfer.androidasync.http.j;
import com.transsion.transfer.androidasync.p;
import com.transsion.transfer.androidasync.s;

/* loaded from: classes7.dex */
public class f implements cv.a {

    /* renamed from: a, reason: collision with root package name */
    byte[] f61042a;

    /* renamed from: b, reason: collision with root package name */
    String f61043b;

    /* loaded from: classes7.dex */
    class a implements com.transsion.transfer.androidasync.future.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bv.a f61044a;

        a(bv.a aVar) {
            this.f61044a = aVar;
        }

        @Override // com.transsion.transfer.androidasync.future.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Exception exc, String str) {
            f.this.f61043b = str;
            this.f61044a.g(exc);
        }
    }

    public f() {
    }

    public f(String str) {
        this();
        this.f61043b = str;
    }

    @Override // cv.a
    public void C(j jVar, s sVar, bv.a aVar) {
        if (this.f61042a == null) {
            this.f61042a = this.f61043b.getBytes();
        }
        a0.h(sVar, this.f61042a, aVar);
    }

    @Override // cv.a
    public boolean K() {
        return true;
    }

    public String a() {
        return toString();
    }

    @Override // cv.a
    public String j() {
        return ShareConstant.SHARE_TYPE_TEXT;
    }

    @Override // cv.a
    public int length() {
        if (this.f61042a == null) {
            this.f61042a = this.f61043b.getBytes();
        }
        return this.f61042a.length;
    }

    @Override // cv.a
    public void r(p pVar, bv.a aVar) {
        new fv.f().a(pVar).f(new a(aVar));
    }

    public String toString() {
        return this.f61043b;
    }
}
