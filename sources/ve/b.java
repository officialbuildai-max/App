package ve;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class b extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    private a f77396a;

    /* renamed from: b, reason: collision with root package name */
    protected final InterfaceC0975b f77397b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(b bVar);
    }

    /* renamed from: ve.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0975b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0975b interfaceC0975b) {
        this.f77397b = interfaceC0975b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f77396a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void b(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }

    public void c(a aVar) {
        this.f77396a = aVar;
    }
}
