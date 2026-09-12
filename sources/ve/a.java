package ve;

import java.util.HashSet;
import org.json.JSONObject;
import ve.b;

/* loaded from: classes5.dex */
public abstract class a extends b {

    /* renamed from: c, reason: collision with root package name */
    protected final HashSet f77393c;

    /* renamed from: d, reason: collision with root package name */
    protected final JSONObject f77394d;

    /* renamed from: e, reason: collision with root package name */
    protected final long f77395e;

    public a(b.InterfaceC0975b interfaceC0975b, HashSet hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0975b);
        this.f77393c = new HashSet(hashSet);
        this.f77394d = jSONObject;
        this.f77395e = j11;
    }
}
