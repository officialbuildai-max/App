package l5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k5.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f68851a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f68852b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final List f68853c = new ArrayList();

    public final void a(String subtitleMd5) {
        Intrinsics.h(subtitleMd5, "subtitleMd5");
        this.f68852b.put(subtitleMd5, "");
    }

    public final void b(Function2 callback) {
        Intrinsics.h(callback, "callback");
        if (this.f68853c.contains(callback)) {
            return;
        }
        this.f68853c.add(callback);
    }

    public final void c() {
        this.f68851a.clear();
    }

    public final List d(String subtitleMd5) {
        Intrinsics.h(subtitleMd5, "subtitleMd5");
        return (List) this.f68851a.get(subtitleMd5);
    }

    public final boolean e(String subtitleMd5) {
        Intrinsics.h(subtitleMd5, "subtitleMd5");
        return this.f68851a.containsKey(subtitleMd5);
    }

    public final void f(String subtitleMd5, List subtitles) {
        Intrinsics.h(subtitleMd5, "subtitleMd5");
        Intrinsics.h(subtitles, "subtitles");
        if (this.f68851a.size() > 10) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Set keySet = this.f68851a.keySet();
                Intrinsics.g(keySet, "subtitlesMap.keys");
                Object h02 = CollectionsKt.h0(keySet);
                Intrinsics.g(h02, "subtitlesMap.keys.first()");
                Result.m1185constructorimpl((List) this.f68851a.remove((String) h02));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        this.f68851a.put(subtitleMd5, subtitles);
    }

    public final boolean g() {
        return this.f68851a.isEmpty();
    }

    public final boolean h(String subtitleMd5) {
        Intrinsics.h(subtitleMd5, "subtitleMd5");
        return this.f68852b.containsKey(subtitleMd5);
    }

    public final void i(String subtitleMd5) {
        Intrinsics.h(subtitleMd5, "subtitleMd5");
        this.f68852b.remove(subtitleMd5);
    }

    public final void j(String subtitleMd5) {
        Intrinsics.h(subtitleMd5, "subtitleMd5");
        this.f68851a.remove(subtitleMd5);
    }

    public final void k(String subtitleMd5, d dVar) {
        Intrinsics.h(subtitleMd5, "subtitleMd5");
        Iterator it = this.f68853c.iterator();
        while (it.hasNext()) {
            ((Function2) it.next()).invoke(subtitleMd5, dVar);
        }
        this.f68853c.clear();
    }
}
