package jw;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public interface c {

    /* loaded from: classes7.dex */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f66440a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1677312116;
        }

        public String toString() {
            return "Error";
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f66441a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1195121496;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* renamed from: jw.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0832c implements c {

        /* renamed from: a, reason: collision with root package name */
        private final jw.b f66442a;

        public C0832c(jw.b model) {
            Intrinsics.h(model, "model");
            this.f66442a = model;
        }

        public final jw.b a() {
            return this.f66442a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0832c) && Intrinsics.c(this.f66442a, ((C0832c) obj).f66442a);
        }

        public int hashCode() {
            return this.f66442a.hashCode();
        }

        public String toString() {
            return "Success(model=" + this.f66442a + ")";
        }
    }
}
