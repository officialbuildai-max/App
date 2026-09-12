package n00;

import com.google.gson.Gson;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f70200a;

    public h(ArrayList arrayList) {
        this.f70200a = arrayList;
    }

    public i a() {
        return f.a(l.d().a(), new Gson().toJson(this.f70200a), 0);
    }
}
