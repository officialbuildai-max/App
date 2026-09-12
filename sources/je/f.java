package je;

import android.text.TextUtils;
import com.iab.omid.library.hisavana.adsession.h;
import java.util.HashSet;
import je.b;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class f extends a {
    public f(b.InterfaceC0828b interfaceC0828b, HashSet hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0828b, hashSet, jSONObject, j11);
    }

    private void e(String str) {
        com.iab.omid.library.hisavana.internal.c e11 = com.iab.omid.library.hisavana.internal.c.e();
        if (e11 != null) {
            for (h hVar : e11.c()) {
                if (this.f66122c.contains(hVar.k())) {
                    hVar.l().m(str, this.f66124e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // je.b, android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            e(str);
        }
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        if (ie.c.v(this.f66123d, this.f66126b.a())) {
            return null;
        }
        this.f66126b.a(this.f66123d);
        return this.f66123d.toString();
    }
}
