package cv;

import com.transsion.transfer.androidasync.a0;
import com.transsion.transfer.androidasync.http.j;
import com.transsion.transfer.androidasync.p;
import com.transsion.transfer.androidasync.s;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b implements cv.a {

    /* renamed from: a, reason: collision with root package name */
    byte[] f61012a;

    /* renamed from: b, reason: collision with root package name */
    JSONObject f61013b;

    /* loaded from: classes7.dex */
    class a implements com.transsion.transfer.androidasync.future.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bv.a f61014a;

        a(bv.a aVar) {
            this.f61014a = aVar;
        }

        @Override // com.transsion.transfer.androidasync.future.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Exception exc, JSONObject jSONObject) {
            b.this.f61013b = jSONObject;
            this.f61014a.g(exc);
        }
    }

    @Override // cv.a
    public void C(j jVar, s sVar, bv.a aVar) {
        a0.h(sVar, this.f61012a, aVar);
    }

    @Override // cv.a
    public boolean K() {
        return true;
    }

    @Override // cv.a
    public String j() {
        return "application/json";
    }

    @Override // cv.a
    public int length() {
        byte[] bytes = this.f61013b.toString().getBytes();
        this.f61012a = bytes;
        return bytes.length;
    }

    @Override // cv.a
    public void r(p pVar, bv.a aVar) {
        new fv.d().a(pVar).f(new a(aVar));
    }
}
