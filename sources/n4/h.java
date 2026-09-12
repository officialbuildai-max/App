package n4;

import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final List f70328a;

    /* renamed from: b, reason: collision with root package name */
    private final List f70329b;

    /* renamed from: c, reason: collision with root package name */
    private final List f70330c;

    public h(List list) {
        this.f70330c = list;
        this.f70328a = new ArrayList(list.size());
        this.f70329b = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f70328a.add(((Mask) list.get(i11)).b().a());
            this.f70329b.add(((Mask) list.get(i11)).c().a());
        }
    }

    public List a() {
        return this.f70328a;
    }

    public List b() {
        return this.f70330c;
    }

    public List c() {
        return this.f70329b;
    }
}
