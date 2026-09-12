package androidx.datastore.preferences.core;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class c {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f8738a;

        public a(String name) {
            Intrinsics.h(name, "name");
            this.f8738a = name;
        }

        public final String a() {
            return this.f8738a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Intrinsics.c(this.f8738a, ((a) obj).f8738a);
            }
            return false;
        }

        public int hashCode() {
            return this.f8738a.hashCode();
        }

        public String toString() {
            return this.f8738a;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final MutablePreferences c() {
        return new MutablePreferences(MapsKt.w(a()), false);
    }

    public final c d() {
        return new MutablePreferences(MapsKt.w(a()), true);
    }
}
