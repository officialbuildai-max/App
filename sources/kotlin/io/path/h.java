package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final Path f67385a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f67386b;

    /* renamed from: c, reason: collision with root package name */
    private final h f67387c;

    /* renamed from: d, reason: collision with root package name */
    private Iterator f67388d;

    public h(Path path, Object obj, h hVar) {
        Intrinsics.h(path, "path");
        this.f67385a = path;
        this.f67386b = obj;
        this.f67387c = hVar;
    }

    public final Iterator a() {
        return this.f67388d;
    }

    public final Object b() {
        return this.f67386b;
    }

    public final h c() {
        return this.f67387c;
    }

    public final Path d() {
        return this.f67385a;
    }

    public final void e(Iterator it) {
        this.f67388d = it;
    }
}
