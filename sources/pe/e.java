package pe;

import com.iab.omid.library.mmadbridge.adsession.h;
import java.util.HashSet;
import org.json.JSONObject;
import pe.b;

/* loaded from: classes5.dex */
public class e extends a {
    public e(b.InterfaceC0911b interfaceC0911b, HashSet hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0911b, hashSet, jSONObject, j11);
    }

    private void e(String str) {
        com.iab.omid.library.mmadbridge.internal.c e11 = com.iab.omid.library.mmadbridge.internal.c.e();
        if (e11 != null) {
            for (h hVar : e11.c()) {
                if (this.f72560c.contains(hVar.s())) {
                    hVar.t().j(str, this.f72562e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // pe.b, android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        e(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        return this.f72561d.toString();
    }
}
