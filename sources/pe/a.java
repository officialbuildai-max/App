package pe;

import java.util.HashSet;
import org.json.JSONObject;
import pe.b;

/* loaded from: classes5.dex */
public abstract class a extends b {

    /* renamed from: c, reason: collision with root package name */
    protected final HashSet f72560c;

    /* renamed from: d, reason: collision with root package name */
    protected final JSONObject f72561d;

    /* renamed from: e, reason: collision with root package name */
    protected final long f72562e;

    public a(b.InterfaceC0911b interfaceC0911b, HashSet hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0911b);
        this.f72560c = new HashSet(hashSet);
        this.f72561d = jSONObject;
        this.f72562e = j11;
    }
}
