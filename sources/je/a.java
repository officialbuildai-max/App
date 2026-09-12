package je;

import java.util.HashSet;
import je.b;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class a extends b {

    /* renamed from: c, reason: collision with root package name */
    protected final HashSet f66122c;

    /* renamed from: d, reason: collision with root package name */
    protected final JSONObject f66123d;

    /* renamed from: e, reason: collision with root package name */
    protected final long f66124e;

    public a(b.InterfaceC0828b interfaceC0828b, HashSet hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0828b);
        this.f66122c = new HashSet(hashSet);
        this.f66123d = jSONObject;
        this.f66124e = j11;
    }
}
