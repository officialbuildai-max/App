package jw;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public interface a {

    /* renamed from: jw.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0831a implements a {

        /* renamed from: a, reason: collision with root package name */
        private final jw.b f66426a;

        public C0831a(jw.b model) {
            Intrinsics.h(model, "model");
            this.f66426a = model;
        }

        public final jw.b a() {
            return this.f66426a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0831a) && Intrinsics.c(this.f66426a, ((C0831a) obj).f66426a);
        }

        public int hashCode() {
            return this.f66426a.hashCode();
        }

        public String toString() {
            return "BasicRights(model=" + this.f66426a + ")";
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final String f66427a;

        public b(String text) {
            Intrinsics.h(text, "text");
            this.f66427a = text;
        }

        public final String a() {
            return this.f66427a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.c(this.f66427a, ((b) obj).f66427a);
        }

        public int hashCode() {
            return this.f66427a.hashCode();
        }

        public String toString() {
            return "Description(text=" + this.f66427a + ")";
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final List f66428a;

        public c(List devices) {
            Intrinsics.h(devices, "devices");
            this.f66428a = devices;
        }

        public final List a() {
            return this.f66428a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.c(this.f66428a, ((c) obj).f66428a);
        }

        public int hashCode() {
            return this.f66428a.hashCode();
        }

        public String toString() {
            return "Devices(devices=" + this.f66428a + ")";
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final d f66429a = new d();

        private d() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 573113473;
        }

        public String toString() {
            return "ProScan";
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements a {

        /* renamed from: a, reason: collision with root package name */
        private final jw.b f66430a;

        public e(jw.b model) {
            Intrinsics.h(model, "model");
            this.f66430a = model;
        }

        public final jw.b a() {
            return this.f66430a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.c(this.f66430a, ((e) obj).f66430a);
        }

        public int hashCode() {
            return this.f66430a.hashCode();
        }

        public String toString() {
            return "User(model=" + this.f66430a + ")";
        }
    }
}
