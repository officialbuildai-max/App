package xe;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected com.google.zxing.j f78322a;

    /* renamed from: b, reason: collision with root package name */
    protected r f78323b;

    /* renamed from: c, reason: collision with root package name */
    private final int f78324c = 2;

    public c(com.google.zxing.j jVar, r rVar) {
        this.f78322a = jVar;
        this.f78323b = rVar;
    }

    public static List f(List list, r rVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(rVar.f((com.google.zxing.k) it.next()));
        }
        return arrayList;
    }

    public BarcodeFormat a() {
        return this.f78322a.b();
    }

    public Bitmap b() {
        return this.f78323b.b(null, 2);
    }

    public byte[] c() {
        return this.f78322a.c();
    }

    public Map d() {
        return this.f78322a.d();
    }

    public String e() {
        return this.f78322a.f();
    }

    public String toString() {
        return this.f78322a.f();
    }
}
