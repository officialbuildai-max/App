package n5;

import java.util.List;

/* loaded from: classes3.dex */
public class a implements m7.a {

    /* renamed from: a, reason: collision with root package name */
    private List f70371a;

    public a(List list) {
        this.f70371a = list;
    }

    @Override // m7.a
    public int a() {
        return this.f70371a.size();
    }

    @Override // m7.a
    public Object getItem(int i11) {
        return (i11 < 0 || i11 >= this.f70371a.size()) ? "" : this.f70371a.get(i11);
    }
}
