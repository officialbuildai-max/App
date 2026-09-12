package pc;

import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;

/* loaded from: classes5.dex */
public final class g implements uz.a {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f72544a;

    /* renamed from: b, reason: collision with root package name */
    private final uz.a f72545b;

    /* renamed from: c, reason: collision with root package name */
    private final uz.a f72546c;

    /* renamed from: d, reason: collision with root package name */
    private final uz.a f72547d;

    /* renamed from: e, reason: collision with root package name */
    private final uz.a f72548e;

    /* renamed from: f, reason: collision with root package name */
    private final uz.a f72549f;

    /* renamed from: g, reason: collision with root package name */
    private final uz.a f72550g;

    public g(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5, uz.a aVar6, uz.a aVar7) {
        this.f72544a = aVar;
        this.f72545b = aVar2;
        this.f72546c = aVar3;
        this.f72547d = aVar4;
        this.f72548e = aVar5;
        this.f72549f = aVar6;
        this.f72550g = aVar7;
    }

    public static g a(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4, uz.a aVar5, uz.a aVar6, uz.a aVar7) {
        return new g(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static e c(com.google.firebase.f fVar, ic.b bVar, jc.e eVar, ic.b bVar2, RemoteConfigManager remoteConfigManager, com.google.firebase.perf.config.a aVar, SessionManager sessionManager) {
        return new e(fVar, bVar, eVar, bVar2, remoteConfigManager, aVar, sessionManager);
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c((com.google.firebase.f) this.f72544a.get(), (ic.b) this.f72545b.get(), (jc.e) this.f72546c.get(), (ic.b) this.f72547d.get(), (RemoteConfigManager) this.f72548e.get(), (com.google.firebase.perf.config.a) this.f72549f.get(), (SessionManager) this.f72550g.get());
    }
}
