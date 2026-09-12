package rb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final List f74401a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final int f74402b;

    public j(int i11) {
        this.f74402b = i11;
    }

    public List a() {
        List b11 = b();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < b11.size(); i11++) {
            arrayList.add(((i) b11.get(i11)).h());
        }
        return arrayList;
    }

    public synchronized List b() {
        return Collections.unmodifiableList(new ArrayList(this.f74401a));
    }

    public synchronized boolean c(List list) {
        this.f74401a.clear();
        if (list.size() <= this.f74402b) {
            return this.f74401a.addAll(list);
        }
        ob.g.f().k("Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.f74402b);
        return this.f74401a.addAll(list.subList(0, this.f74402b));
    }
}
