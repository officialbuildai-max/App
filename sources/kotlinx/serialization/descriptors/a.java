package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f68164a;

    /* renamed from: b, reason: collision with root package name */
    private List f68165b;

    /* renamed from: c, reason: collision with root package name */
    private final List f68166c;

    /* renamed from: d, reason: collision with root package name */
    private final Set f68167d;

    /* renamed from: e, reason: collision with root package name */
    private final List f68168e;

    /* renamed from: f, reason: collision with root package name */
    private final List f68169f;

    /* renamed from: g, reason: collision with root package name */
    private final List f68170g;

    public a(String serialName) {
        Intrinsics.h(serialName, "serialName");
        this.f68164a = serialName;
        this.f68165b = CollectionsKt.l();
        this.f68166c = new ArrayList();
        this.f68167d = new HashSet();
        this.f68168e = new ArrayList();
        this.f68169f = new ArrayList();
        this.f68170g = new ArrayList();
    }

    public static /* synthetic */ void b(a aVar, String str, f fVar, List list, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            list = CollectionsKt.l();
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        aVar.a(str, fVar, list, z10);
    }

    public final void a(String elementName, f descriptor, List annotations, boolean z10) {
        Intrinsics.h(elementName, "elementName");
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(annotations, "annotations");
        if (!this.f68167d.add(elementName)) {
            throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered").toString());
        }
        this.f68166c.add(elementName);
        this.f68168e.add(descriptor);
        this.f68169f.add(annotations);
        this.f68170g.add(Boolean.valueOf(z10));
    }

    public final List c() {
        return this.f68165b;
    }

    public final List d() {
        return this.f68169f;
    }

    public final List e() {
        return this.f68168e;
    }

    public final List f() {
        return this.f68166c;
    }

    public final List g() {
        return this.f68170g;
    }

    public final void h(List list) {
        Intrinsics.h(list, "<set-?>");
        this.f68165b = list;
    }
}
