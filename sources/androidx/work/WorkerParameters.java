package androidx.work;

import android.net.Network;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public final class WorkerParameters {

    /* renamed from: a, reason: collision with root package name */
    private UUID f15483a;

    /* renamed from: b, reason: collision with root package name */
    private f f15484b;

    /* renamed from: c, reason: collision with root package name */
    private Set f15485c;

    /* renamed from: d, reason: collision with root package name */
    private a f15486d;

    /* renamed from: e, reason: collision with root package name */
    private int f15487e;

    /* renamed from: f, reason: collision with root package name */
    private Executor f15488f;

    /* renamed from: g, reason: collision with root package name */
    private CoroutineContext f15489g;

    /* renamed from: h, reason: collision with root package name */
    private j4.c f15490h;

    /* renamed from: i, reason: collision with root package name */
    private m0 f15491i;

    /* renamed from: j, reason: collision with root package name */
    private c0 f15492j;

    /* renamed from: k, reason: collision with root package name */
    private j f15493k;

    /* renamed from: l, reason: collision with root package name */
    private int f15494l;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public List f15495a = Collections.emptyList();

        /* renamed from: b, reason: collision with root package name */
        public List f15496b = Collections.emptyList();

        /* renamed from: c, reason: collision with root package name */
        public Network f15497c;
    }

    public WorkerParameters(UUID uuid, f fVar, Collection collection, a aVar, int i11, int i12, Executor executor, CoroutineContext coroutineContext, j4.c cVar, m0 m0Var, c0 c0Var, j jVar) {
        this.f15483a = uuid;
        this.f15484b = fVar;
        this.f15485c = new HashSet(collection);
        this.f15486d = aVar;
        this.f15487e = i11;
        this.f15494l = i12;
        this.f15488f = executor;
        this.f15489g = coroutineContext;
        this.f15490h = cVar;
        this.f15491i = m0Var;
        this.f15492j = c0Var;
        this.f15493k = jVar;
    }

    public Executor a() {
        return this.f15488f;
    }

    public j b() {
        return this.f15493k;
    }

    public UUID c() {
        return this.f15483a;
    }

    public f d() {
        return this.f15484b;
    }

    public j4.c e() {
        return this.f15490h;
    }

    public CoroutineContext f() {
        return this.f15489g;
    }

    public m0 g() {
        return this.f15491i;
    }
}
